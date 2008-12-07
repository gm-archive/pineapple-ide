grammar PineDL;

options{
	backtrack = true;
}

tokens {
	PLUS = '+';
	MINUS = '-';
	MULT = '*';
	DIV = '/';
	MOD = '%';
	LPAREN = '(';
	RPAREN = ')';
	LARRAY = '[';
	RARRAY = ']';
	BBLOCK = '{';
	EBLOCK = '}';
	BTWAND = '&';
	BTWOR = '|';
	BTWXOR = '^';
	LOGAND = '&&';
	LOGOR = '||';
	STMTCUT = ';';
	DBLDOT = ':';
	BTWNOT = '~';
	LOGNOT = '!';
	INC = '++';
	DEC = '--';
	EQ = '=';
	CEQ = '==';
	NEQ = '!=';
	BG = '>';
	BGE = '>=';
	LT = '<';
	LTE = '<=';
}

@header{
/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <bob@bobtheblueberry.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
package org.gcreator.pinedl;

import java.util.Vector;
}

@lexer::header{
/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <bob@bobtheblueberry.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
package org.gcreator.pinedl;
}

@members{
	private SignalReceiver signal = new SignalReceiver(); //Empty signal receiver
	
	public void setSignalReceiver(SignalReceiver signal){
		this.signal = signal;
		if(signal==null)
			this.signal = new SignalReceiver(); //Prevent NullPointerExceptions
	}
	
	public SignalReceiver getSignalReceiver(){
		return signal;
	}
}

doc	:	pkgstmt
		impstmt*
		clsstmt;

pkgstmt
	:	'package' c=context {signal.sendPackageSignal(c);} STMTCUT;
impstmt	:	'import' c=context {signal.sendImportSignal(c);} STMTCUT;

clsstmt @init{String cls = ""; String baseclass = null;}
	:	'class' c=WORD {cls=c.getText();} ('extends' d=context {baseclass=d;})
		{signal.sendClassDeclaration(cls, baseclass);}
		BBLOCK
			classcontent
		EBLOCK
		{signal.endClass();};
		
classcontent
	:	element*;
	
element	:	method|field|constructor;

field	
@init{
String privacy = null;
boolean isstatic = false;
boolean isconst = false;
String type = "";
}	:
	a=PRIVACY {privacy=a.getText();}
	s='static'? {if(s!=null) isstatic = true;}
	/*('const' {isconst = true;})?*/
	d=type {type = d;}
	n=WORD {signal.sendFieldSignal(privacy, isstatic, isconst, type, n.getText());}
	STMTCUT;

method
@init{
String privacy = null;
boolean isstatic = false;
String type = "";
String name = "";
Vector<Argument> args = new Vector<Argument>();
}	:	p=PRIVACY {privacy=p.getText();}
		(s='static' {isstatic = true;})?
		t=type {type=t;}
		n=WORD {name=n.getText();}
		LPAREN (a=argument {args.add(a);} (',' b=argument {args.add(b);})*)? RPAREN
		{signal.sendMethodSignal(privacy, isstatic, type, name, args); }
		BBLOCK
			code
		EBLOCK;

constructor
@init{
String privacy = null;
Vector<Argument> args = new Vector<Argument>();
}
	:	p=PRIVACY {privacy=p.getText();}
		THIS LPAREN (a=argument {args.add(a);}(',' b=argument {args.add(b);})*)? RPAREN
		{signal.sendConstructorSignal(privacy, args);}
		(DBLDOT (THIS|SUPER) LPAREN (WORD (',' WORD)*)? RPAREN )?
		BBLOCK
			code
		EBLOCK;
		
argument returns [Argument a = new Argument()]
	:	c=type {a.type = c;} d=WORD {a.name = d.getText();};

code	:	codel*;

codel	:	trycatch |
		assign |
		ifcase |
		whilecase |
		(type2value STMTCUT) |
		returncase |
		throwcase |
		STMTCUT /*empty statement*/;

returncase
	:	'return' (expression)? STMTCUT;
	
throwcase
	:	'throw' expression STMTCUT;

//type name [= expression]
//OR
//name = expression
//If it was [type] name [= expression], then simply name would be valid.
assign	:	((type WORD (EQ expression)?) | (WORD EQ expression)) STMTCUT;

//situation is NOT used because "try x=doIt(); catch(Exception e) doOther(); is not allowed.
//You MUST use the {}: try{x=doIt();}catch(Exception e){ doOther; } is allowed.
trycatch:	'try' BBLOCK code EBLOCK 'catch' LPAREN argument RPAREN BBLOCK code EBLOCK;

ifcase	:	'if' LPAREN expression RPAREN situation
		elsecase?;

//elsif	:	'elsif' LPAREN expression RPAREN situation;

elsecase:	'else' situation;

whilecase
	:	'while' LPAREN expression RPAREN situation;

situation
	:	codel | (BBLOCK code EBLOCK);

expression
	:	(value | ('(' value ')') | ('(' sgloperation ')' ))
		((PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE)
		expression)*;

sgloperation
	:	(BTWNOT | LOGNOT) expression;

value	:	type1value | type2value | type3value;

//Increment/Decrement or pure variable
type1value
	:	(contextp | elemcontext) (INC|DEC)?;

//Function call
type2value
	:	((THIS|SUPER|WORD) '.')?
		(WORD) acelem* ('.' WORD acelem*)*;

acelem	:	((LARRAY expression RARRAY) | (LPAREN (expression (',' expression)* )? RPAREN) );

type3value
	:	NULL | BOOLEAN | STRING | CHAR | FLOAT | DOUBLE | INTEGER;

elemcontext
	:	(THIS|SUPER) ('.' WORD (LARRAY expression RARRAY)* )+;	

contextp:	WORD ('.' WORD (LARRAY expression RARRAY)* )+;

context returns [String result = ""]
	:	c=WORD {$result += c.getText();} ('.' t=WORD {$result += "." + t.getText();})*;

//Only used to ensure some keywords
type	returns [String s = ""]
	:	(t=('int'|'float'|'double'|'uint'|'char'|'string'|'bool') {s=t.getText();})|(g=context {s = g;});

THIS	:	'this';

SUPER	:	'super';

PRIVACY	:	'public' | 'protected' | 'private';

NULL	:	'null';

BOOLEAN	:	'true' | 'false';

WORD	:	ALPHA (ALPHA|DIGIT)*;

STRING	:	'"' (~('\"'|'\\')|'\\\\'|'\\\''|'\\\"'|'\\n')* '"';

CHAR	:	'\'' (~('\''|'\\')|'\\\\'|'\\\''|'\\\"'|'\\n') '\'';

FLOAT	:	'-'? DIGIT+ '.' DIGIT+ 'f';

DOUBLE	:	'-'? DIGIT+ '.' DIGIT+;

INTEGER	:	'-'? DIGIT+;

fragment ALPHA	:	'a'..'z'|'A'..'Z'|'_';

fragment DIGIT	:	'0'..'9';

SLCOMMENT
	:	'//' (~('\r'|'\n'))* {$channel = HIDDEN; };

MLCOMMENT 
	:	'/*' ( options {greedy=false;} : . )* '*/' { $channel = HIDDEN; };

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; };
