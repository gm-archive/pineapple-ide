#include "pinec/lexer.h"
#include <map>
#include <sstream>

using namespace std;

#define COLSTART 0

#define forward() \
	prevChar = currentChar; currentChar = nextChar; nextChar = stream.get(); \
	m_col++; \
	if(currentChar=='\r'&&nextChar=='\n'){ \
		m_pcol = m_col; \
		m_line++; m_col = COLSTART; \
		currentChar = nextChar; nextChar = stream.get(); \
	} \
	else if(currentChar=='\r'||currentChar=='\n'){ \
		m_pcol = m_col; \
		m_line++; m_col = COLSTART; \
	}

#define backward() { \
	m_col--; stream.unget(); nextChar = currentChar; currentChar = prevChar; \
	if(m_col<0){ m_line--; m_col = m_pcol;} \
	}

#define dealError(fatal, line, col, message) \
		errorListener->handleError(Error(fatal, line, col, message))

#define fastError(fatal, message) {if(dealError(fatal, m_line, m_col, message)){ return; }}

#define dealToken(type, subtype, line, col, content) \
	tokenListener->handleToken(new Token(type, subtype, line, col, content))

#define fastToken(type, subtype, line, col, content) \
	{if(dealToken(type, subtype, line, col, content)){ return; }}

#define isletter(z) ((z>='a'&&z<='z')|(z>='A'&&z<='Z'))
#define isdigit(z) (z>='0'&&z<='9')
#define ishex(z) (isdigit(z)||(z>='a'&&z<='f')||(z>='A'&&z<='F'))
#define iswhitespace(z) (z==' '||z=='\t'||z=='\r'||z=='\n')
#define iswordstart(z) (z=='_'||z=='$'||isletter(z))
#define iswordchar(z) (iswordstart(z)||isdigit(z))

typedef map<char, int> CMAP;
typedef map<string, int> SMAP;
typedef CMAP::iterator CITER;
typedef SMAP::iterator SITER;

SMAP operators3;
SMAP operators2;
CMAP operators1;
SMAP keywords;

bool initialized = false;

#define MAKE1(b, a) operators1.insert(make_pair<char, int>(a, b));
#define MAKE2(b, a) operators2.insert(make_pair<string, int>(a, b));
#define MAKE3(b, a) operators3.insert(make_pair<string, int>(a, b));
#define MAKEK(b, a) keywords.insert(make_pair<string, int>(a, b));

void pinec_lexer_initialize(){
	if(initialized){
		return;
	}

	initialized = true;

	MAKE1(OT_DOT, '.');
	MAKE1(OT_COLON, ':');
	MAKE1(OT_COMMA, ',');
	MAKE1(OT_SEMICOLON, ';');
	MAKE1(OT_CBO, '{');
	MAKE1(OT_CBC, '}');
	MAKE1(OT_SBO, '[');
	MAKE1(OT_SBC, ']');
	MAKE1(OT_NBO, '(');
	MAKE1(OT_NBC, ')');
	MAKE1(OT_PLUS, '+');
	MAKE1(OT_MINUS, '-');
	MAKE1(OT_MULT, '*');
	MAKE1(OT_DIV, '/');
	MAKE1(OT_MOD, '%');
	MAKE1(OT_BITAND, '&');
	MAKE1(OT_BITOR, '|');
	MAKE1(OT_BITXOR, '^');
	MAKE1(OT_BITNOT, '~');
	MAKE2(OT_LOGAND, "&&");
	MAKE2(OT_LOGOR, "||");
	MAKE1(OT_LOGNOT, '!');
	MAKE1(OT_ASSIGN, '=');
	MAKE2(OT_EQUALS, "==");
	MAKE2(OT_NOTEQUAL, "!=");
	MAKE1(OT_GREATER, '>');
	MAKE2(OT_GTE, ">=");
	MAKE1(OT_SMALLER, '<');
	MAKE2(OT_SME, "<=");
	MAKE2(OT_INCREMENT, "++");
	MAKE2(OT_DECREMENT, "--");
	MAKE2(OT_PLUSASSIGN, "+=");
	MAKE2(OT_MINUSASSIGN, "-=");
	MAKE2(OT_MULTASSIGN, "*=");
	MAKE2(OT_DIVASSIGN, "/=");
	MAKE2(OT_MODASSIGN, "%=");
	MAKE2(OT_BITANDASSIGN, "&=");
	MAKE2(OT_BITORASSIGN, "|=");
	MAKE2(OT_BITXORASSIGN, "^=");
	MAKE3(OT_LOGANDASSIGN, "&&=");
	MAKE3(OT_LOGORASSIGN, "||=");
	MAKE2(OT_RANGE, "..");
	MAKE1(OT_QMARK, '?');
	MAKE2(OT_RSHIFT, ">>");
	MAKE2(OT_LSHIFT, "<<");
	MAKE3(OT_RSEQ, ">>=");
	MAKE3(OT_LSEQ, "<<=");

	MAKEK(KT_ARRAY, "array");
	MAKEK(KT_BOOL, "bool");
	MAKEK(KT_BREAK, "break");
	MAKEK(KT_CALLEE, "callee");
	MAKEK(KT_CASE, "case");
	MAKEK(KT_CHAR, "char");
	MAKEK(KT_CLASS, "class");
	MAKEK(KT_CONST, "const");
	MAKEK(KT_CONTINUE, "continue");
	MAKEK(KT_DEFAULT, "default");
	MAKEK(KT_DO, "do");
	MAKEK(KT_ELSE, "else");
	MAKEK(KT_EXTENDS, "extends");
	MAKEK(KT_FALSE, "false");
	MAKEK(KT_FINAL, "final");
	MAKEK(KT_FOR, "for");
	MAKEK(KT_FUNCTION, "function");
	MAKEK(KT_IF, "if");
	MAKEK(KT_IS, "is");
	MAKEK(KT_NEW, "new");
	MAKEK(KT_NULL, "null");
	MAKEK(KT_NUMBER, "number");
	MAKEK(KT_PRIVATE, "private");
	MAKEK(KT_PROTECTED, "protected");
	MAKEK(KT_PUBLIC, "public");
	MAKEK(KT_RANGE, "range");
	MAKEK(KT_REFERENCED, "referenced");
	MAKEK(KT_RETURN, "return");
	MAKEK(KT_STATIC, "static");
	MAKEK(KT_STRING, "string");
	MAKEK(KT_SUPER, "super");
	MAKEK(KT_SWITCH, "switch");
	MAKEK(KT_THIS, "this");
	MAKEK(KT_TRUE, "true");
	MAKEK(KT_TYPE, "type");
	MAKEK(KT_VAR, "var");
	MAKEK(KT_VIRTUAL, "virtual");
	MAKEK(KT_WHILE, "while");
}

void pinec_lexer_run(istream& stream,
		TokenListener* tokenListener, ErrorListener* errorListener){

	pinec_lexer_initialize();

	int m_pcol = 0;
	int m_line = 1;
	int m_col = COLSTART-1;
	int prevChar = 0; //Do not use after backward()
	register int currentChar = 0;
	int nextChar = 0;
	string content;
	int line;
	register int col;

	forward();

	bigloop_start:
	while(stream.good()){
		forward();

		if(currentChar=='"'){

			content = "";
			line = m_line;
			col = m_col;

			strloop_start:
			while(true){
				if(!stream.good()){
					fastError(true, "Unexpected end of file (unclosed string literal)");
					goto strloop_start;
				}
				forward();
				if(currentChar=='\r'||currentChar=='\n'){
					fastError(true, "Unexpected line break (unclosed string literal)");
					goto strloop_start;
				}
				if(currentChar=='\\'){
					if(!stream.good()){
						fastError(true, "Unexpected end of file (unclosed string literal)");
						break;
					}
					forward();
					switch(currentChar){
					case 'r': content += '\r'; break;
					case 'n': content += '\n'; break;
					case 't': content += '\t'; break;
					case '"': content += '"'; break;
					case '\'': content += '\''; break;
					case '\\': content += '\\'; break;
					}
					if(isdigit(currentChar)){
						if(currentChar=='8'||currentChar=='9'){
							fastError(true, "ASCII escape sequence not in valid octal");
							break;
						}
						char ch = currentChar-'0';
						if(currentChar<='2'){
							if(!stream.good()){
								fastError(true, "Unexpected end of file (unclosed string literal)");
								break;
							}
							forward();
							if(!isdigit(currentChar)||currentChar=='8'||currentChar=='9'){
								backward();
							}
							else{
								ch *= 8;
								ch += currentChar-'0';
								if(!stream.good()){
									fastError(true, "Unexpected end of file (unclosed string literal)");
									break;
								}
								forward();
								if(!isdigit(currentChar)||currentChar=='8'||currentChar=='9'){
									backward();
								}
								ch *= 8;
								ch += currentChar-'0';
							}
							content += ch;
						}
						else{
							if(!stream.good()){
								fastError(true, "Unexpected end of file (unclosed string literal)");
								break;
							}
							forward();
							if(!isdigit(currentChar)||currentChar=='8'||currentChar=='9'){
								backward();
							}
							else{
								ch *= 8;
								ch += currentChar-'0';
							}
							content += ch;
						}
					}
					//TODO: Hexadecimal ASCII and UNICODE sequences

					fastError(true, "Unknown escape sequence");
					goto strloop_start;
				}
				if(currentChar=='"'){
					fastToken(TT_STRING, 0, line, col, content);

					goto bigloop_start;
				}

				content += (char) currentChar;
			}
		}

		if(currentChar=='\''){
			line = m_line;
			col = m_col;
			if(!stream.good()){
				fastError(true, "Unexpected end of file(unclosed character literal)");
				continue;
			}
			forward();
			if(currentChar=='\''){
				fastError(true, "Empty character literal");
				continue;
			}
			if(currentChar=='\r'||currentChar=='\n'){
				fastError(true, "Unexpected line break (unclosed character literal)");
				continue;
			}

			//TODO Ascii sequences and UNICODE sequences

			content = "";
			if(currentChar=='\\'){
				forward();
				switch(currentChar){
				case 'n': content += '\n'; forward(); break;
				case 'r': content += '\r'; forward(); break;
				case 't': content += '\t'; forward(); break;
				case '"': content += '"'; forward(); break;
				case '\'': content += '\''; forward(); break;
				case '\\': content += '\\'; forward(); break;
				default: ;//TODO Handle ASCII and UNICODE escape sequences
				}
			}
			else{
				content += (char) currentChar;
				if(!stream.good()){
					fastError(true, "Unexpected end of file (unclosed character literal)");
					continue;
				}
				forward();
			}
			if(currentChar!='\''){
				fastError(true, "Unexpected character (expecting character literal closing)");
				forward();
				continue;
			}

			fastToken(TT_CHAR, 0, line, col, content);
			continue;
		}

		if(currentChar=='/'&&nextChar=='/'){
			while(stream.good()){
				forward();

				if(currentChar=='\n'||currentChar=='\r'){
					goto bigloop_start;
				}
			}
			continue;
		}

		if(currentChar=='/'&&nextChar=='*'){
			if(!stream.good()){
				fastError(true, "Unexpected end of file (Unclosed block comment)");
			}

			forward();

			while(true){
				if(!stream.good()){
					fastError(true, "Unexpected end of file (Unclosed block comment)");
				}

				forward();

				if(currentChar=='*'&&nextChar=='/'){
					forward();
					goto bigloop_start;
				}
			}
		}

		if(iswhitespace(currentChar)){
			continue;
		}

		if(isdigit(currentChar)){
			content = "";
			col = m_col;
			if(currentChar=='0'){
				forward();

				if(currentChar=='x'||currentChar=='X'){
					//Hexadecimal 0xF
					bool hasNumber = false;
					int number = 0;
					while(true){
						if(!stream.good()){
							fastError(true, "Unexpected end of file (expected hexadecimal number)");
							goto bigloop_start;
						}
						forward();
						if(ishex(currentChar)){
							hasNumber = true;
							int n = currentChar;
							if(isdigit(n)){
								n = n - '0';
							}
							else if(n>='a'&&n<='z'){
								n = n - 'a' + 10;
							}
							else{
								n = n - 'A' + 10;
							}
							number <<= 4;
							number += n;
						}
						else if(currentChar=='.'){
							if(isdigit(nextChar)){
								fastError(true, "Non-integer numbers not supported in hexadecimal");
							}
							goto numericloop_end;
						}
					}
					numericloop_end:

					if(!hasNumber){
						fastError(true, "Empty hexadecimal sequence");
						goto bigloop_start;
					}

					backward();

					std::stringstream str;
					str << number;
					content = str.str();
					fastToken(TT_NUMBER, 0, m_line, col, content);
					continue;
				}
				else if(currentChar=='.'){
					//0.xxxxx
					content = "0.";
					while(true){
						if(!stream.good()){
							goto digloop_end;
						}
						forward();
						if(currentChar=='.'){
							if(stream.good()&&isdigit(nextChar)){
								fastError(true, "Invalid numeric sequence");
							}
							else{
								backward();
							}
							goto digloop_end;
						}
						if(!isdigit(currentChar)){
							backward();
							goto digloop_end;
						}
						content += (char) currentChar;
					}
					digloop_end:
					fastToken(TT_NUMBER, 0, m_line, col, content);
					continue;
				}
				else if(isdigit(currentChar)){
					//01234567
					int number = 0;
					backward();
					while(stream.good()){
						forward();
						if(currentChar=='.'&&isdigit(nextChar)){
							fastError(true, "Non-integer numbers not supported for octal sequences");
							goto octalparse_end;
						}
						if(isdigit(currentChar)){
							if(currentChar=='8'||currentChar=='9'){
								fastError(true, "Invalid octal sequence");
								goto octalparse_end;
							}

							number <<= 3;
							number += (currentChar-'0');
						}
						else{
							backward();
							goto octalparse_end;
						}
					}
					octalparse_end:

					std::stringstream str;
					str << number;
					content = str.str();

					fastToken(TT_NUMBER, 0, m_line, col, content);
					continue;
				}
				else{
					content = "Unexpected character '";
					content += (char) currentChar;
					content += "' (expected '0', 'x', '.' or octal digit)";
					fastError(true, content);
					continue;
				}
			}
			else{
				//Parse 123.123 sequences
				backward();
				bool foundDot = false;
				while(stream.good()){
					forward();

					if(currentChar=='.'&&isdigit(nextChar)){
						if(foundDot){
							fastError(true, "Unexpected character '.'");
							goto bigloop_start;
						}
						else{
							foundDot = true;
							content += '.';
						}
					}
					else if(isdigit(currentChar)){
						content += (char) currentChar;
					}
					else{
						backward();
						goto standardnumeric_end;
					}
				}
				standardnumeric_end:
				fastToken(TT_NUMBER, 0, m_line, col, content);
				continue;
			}
		}
		else if(currentChar=='.'&&isdigit(nextChar)){
			content = "0.";
			line = m_line;
			col = m_col;
			while(true){
				if(!stream.good()){
					goto digitloopend;
				}
				forward();
				if(!isdigit(currentChar)){
					backward();
					goto digitloopend;
				}
				content += (char) currentChar;
			}
			digitloopend:

			fastToken(TT_NUMBER, 0, line, col, content);

			continue;
		}

		CITER loc = operators1.find(currentChar);
		if(loc!=operators1.end()){
			forward();
			content = "";
			content += (char) prevChar;
			content += (char) currentChar;
			content += (char) nextChar;
			SITER op = operators3.find(content);
			if(op!=operators3.end()){
				forward();
				fastToken(TT_OPERATOR, op->second, m_line, m_col-2, content);
				continue;
			}
			content = "";
			content += prevChar;
			content += currentChar;
			op = operators2.find(content);
			if(op!=operators2.end()){
				fastToken(TT_OPERATOR, op->second, m_line, m_col-1, content);
				continue;
			}
			backward();
			content = "";
			content += currentChar;
			fastToken(TT_OPERATOR, loc->second, m_line, m_col, content);
			continue;
		}

		if(iswordstart(currentChar)){
			line = m_line;
			col = m_col;
			content = "";
			while(stream.good()&&iswordchar(currentChar)){
				content += currentChar;
				forward();
			}
			backward();

			SITER kIter = keywords.find(content);
			bool isWord = kIter==keywords.end();
			fastToken(isWord ? TT_WORD : TT_KEYWORD,
					isWord ? 0 : kIter->second, line, col, content);
			continue;
		}

		content = "Unexpected character '";
		content += (char) currentChar;
		content += '\'';
		fastError(true, content);
	}
	tokenListener->handleEnd();

}
