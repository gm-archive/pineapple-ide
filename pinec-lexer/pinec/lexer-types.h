#pragma once

#ifndef __PINEC_LEXER_TYPES_H__
#define __PINEC_LEXER_TYPES_H__

#include <string>
#include <queue>

typedef char TokenType;
typedef char SubType;

struct Token{
	TokenType m_type;
	SubType m_subtype;

	int m_line;
	int m_col;
	std::string m_content;

public:
	Token(){}
	Token(TokenType type, SubType subtype, int line, int col, std::string content)	:
		m_type(type), m_subtype(subtype), m_line(line), m_col(col), m_content(content){}
};

struct Error{
	bool m_fatal;

	int m_line;
	int m_col;
	std::string m_content;

public:
	Error(){}
	Error(bool fatal, int line, int col, std::string content) :
		m_fatal(fatal), m_line(line), m_col(col), m_content(content){}
};

class TokenListener{
public:
	virtual bool handleToken(Token* token);
	virtual void handleEnd();
};

class ErrorListener{
public:
	virtual bool handleError(Error error);
};

class TokenServer : public TokenListener{
	std::queue<Token*> m_tokens;
	bool m_end;
	bool m_reqend;

public:
	TokenServer();
	virtual bool handleToken(Token* token);
	virtual void handleEnd();

	//It is up to the receiver to delete the Token object
	Token* getToken();
	void requestEnd();
};

#endif //__PINEC_LEXER_TYPES_H__
