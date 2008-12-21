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
grammar PineDL;

options{
	backtrack = true;
}

tokens{
	PLUS = '+';
	MINUS = '-';
	MULT = '*';
	DIV = '/';
	MOD = '%';
	DOT = '.';
	RSHIFT = '>>';
	LSHIFT = '<<';
	NOT = '!';
	EQUAL = '=';
	LESS = '<';
	MORE = '>';
	LESSEQ = '<=';
	MOREEQ = '>=';
	EQUALS = '==';
	NEQUAL = '!=';
	STMTEND = ';';
	BITWISEAND = '&';
	BITWISEOR = '|';
	BITWISEXOR = '^';
	LOGAND = '&&';
	LOGOR = '||';
	BLKBEG = '{';
	BLKEND = '}';
	LPAREN = '(';
	RPAREN = ')';
	LARRAY = '[';
	RARRAY = ']';
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
import org.gcreator.pinedl.statements.*;

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
	private PineClass target = null;
}

doc returns [PineClass t]
@init{
	target = new PineClass();
}
	:	pkgstmt
		importstmt*
		clsdecl
		{t = target;};

pkgstmt	:	'package' s=pkgname {target.packageName = s.split("\\."); } STMTEND;

importstmt
	:	'import' i=clstype {target.importStmt.add(i);} STMTEND;
	
clsdecl	:	'class' n=WORD {target.clsName = n.getText();} ('extends' e=clstype {target.superClass = e;})?
		BLKBEG
		(f=field {target.variables.add(f);}|
		m=method {target.functions.add(m);}|c=constructor {target.constructors.add(c);})*
		BLKEND STMTEND?; //STMTEND? means class X{} and class X{}; are both accepted

field returns [Variable v = new Variable()]
	:	a=accesscontrolkeyword {v.access = a;}
		('static' {v.isStatic = true;})?
		t=type {v.type = t;}
		n=WORD {v.name = n.getText();}
		STMTEND;
		
method returns [Function f = new Function()]
	:	a=accesscontrolkeyword {f.access = a;}
		('static' {f.isStatic = true;})?
		t=type {f.returnType = t;}
		n=WORD {f.name = n.getText();}
		LPAREN
		l=argumentlist {f.arguments = l;}
		RPAREN
		b=block {f.content = b;};
	
constructor returns [Constructor c = new Constructor()]
	:	a=accesscontrolkeyword {c.access = a;}
		'this'
		LPAREN
		l=argumentlist {c.arguments = l;}
		RPAREN
		(':' 'super' {c.superArguments = new Vector<Expression>();}
			LPAREN
			(e=expression {c.superArguments.add(e);}
			(',' e=expression {c.superArguments.add(e);})*)?
			RPAREN)?
		b=block {c.content = b;};

argumentlist returns [Vector<Argument> v = new Vector<Argument>()]
	: (a=argument {v.add(a);} (',' a=argument {v.add(a);})*)?;
	
argument returns [Argument a = new Argument()]
	: t=type {a.type = t;}
	n=WORD {a.name = n.getText();};

block	returns [Block b = new Block()]
	:	(BLKBEG (s=stmt {b.content.add(s);})* BLKEND);
	
stmt returns [Leaf l = null]
	:	(e=declAssign {l=e;})
	| (a=expression STMTEND {l=a;})
	| (b=returnstmt {l=b;})
	| (c=ifstmt {l=c;})
	| (w=whilestmt {l=w;})
	| (d=block {l=d;})
	| ('break' STMTEND {l=new BreakStatement();})
	| ('continue' STMTEND {l=new ContinueStatement();})
	| STMTEND;
	
ifstmt returns [IfStatement ifCase = new IfStatement()]
	: 'if' LPAREN s=expression {ifCase.condition = s;} RPAREN
		q=stmt {ifCase.then = q;}
		('else' e=stmt {ifCase.elseCase = e;})?;
		
whilestmt returns [WhileStatement whileCase = new WhileStatement()]
	: 'while' LPAREN s=expression {whileCase.condition = s;} RPAREN
		q=stmt {whileCase.then = q;};
	
returnstmt returns [ReturnStatement ret = new ReturnStatement()]
	:	'return' (r=expression {ret.value = r;})? STMTEND;
	
declAssign returns [DeclAssign e = new DeclAssign()]
	: t=type {e.type = t;} n=WORD {e.name = n.getText();} ('=' ex=expression {e.value=ex;})? STMTEND;

pkgname returns [String s = null]
	:	(c=WORD {s = c.getText();} ('.' t=WORD {s += "." + t.getText();})*);

reference returns [Reference r = null]
	:	ref=(WORD|'this'|'super') {r = new VariableReference(ref.getText());}
	(LPAREN {r = new FunctionReference(ref.getText());}
		(e=expression {((FunctionReference) r).arguments.add(e);}
			(',' e=expression {((FunctionReference) r).arguments.add(e);})*
		)?
	RPAREN)?
	(LARRAY e=expression {r = new ArrayReference(r, e);} RARRAY)*;

constant returns [Constant c = null]
	: (i=intconst {c=i;})|(d=doubleconst {c=d;})|(b=boolconst {c=b;})|(s=stringconst {c=s;});

//Multiple operations, divided by priority levels:

primitive returns [Expression e = null]
	:	c=constant {e=c;}| (r=reference {e=r;} ('.' b=reference {e=new RetrieverExpression((Reference) e, b);})*)
		| (LPAREN x=expression {e=x;} RPAREN)|('new' t=clstype {e=new NewCall(t);}
		LPAREN
		(ex=expression {((NewCall) e).arguments.add(ex);}
			(',' ex=expression {((NewCall) e).arguments.add(ex);})*
		)? RPAREN);
	
notcastexpr returns [Expression e = null]
@init{
TypeCast cast = null;
}
	:	(p=primitive {e=p;})
		| (NOT p=notcastexpr {e=new NotOperation(p);})
		| (LPAREN t=type RPAREN p=notcastexpr {e=new TypeCast(t, p);});
		
multop returns [Expression e = null]
	: t=notcastexpr {e=t;} (
	(MULT q=notcastexpr {e=new MultiplyOperation(e, q);}
	|DIV q=notcastexpr {e=new DivisionOperation(e, q);}
	|MOD q=notcastexpr {e=new ModOperation(e, q);})
	)*;

sumop returns [Expression e = null]
	: t=multop {e=t;} (
	(PLUS q=multop {e=new SumOperation(e, q);}
	|MINUS q=multop {e=new SubtractionOperation(e, q);})
	)*;

shiftop returns [Expression e = null]
	: t=sumop {e=t;} (
	(RSHIFT q=sumop {e=new RShiftOperation(e, q);}
	|LSHIFT q=sumop {e=new LShiftOperation(e, q);})
	)*;
	
compop returns [Expression e = null]
	: t=shiftop {e=t;} (
	(LESS q=shiftop {e=new LessOperation(e, q);}
	|MORE q=shiftop {e=new MoreOperation(e, q);}
	|LESSEQ q=shiftop {e=new LessEqualOperation(e, q);}
	|MOREEQ q=shiftop {e=new MoreEqualOperation(e, q);})
	)*;
	
comp2op returns [Expression e = null]
	: t=compop {e=t;} (
	(EQUALS q=compop {e=new EqualsOperation(e, q);}
	|NEQUAL q=compop {e=new NequalOperation(e, q);})
	)*;

bitwiseand returns [Expression e = null]
	: t=comp2op {e=t;} (
	(BITWISEAND q=comp2op {e=new BitwiseAndOperation(e, q);})
	)*;

bitwiseor returns [Expression e = null]
	: t=bitwiseand {e=t;} (
	(BITWISEOR q=bitwiseand {e=new BitwiseOrOperation(e, q);})
	)*;
	
bitwisexor returns [Expression e = null]
	: t=bitwiseor {e=t;} (
	(BITWISEXOR q=bitwiseor {e=new BitwiseXorOperation(e, q);})
	)*;

logicaland returns [Expression e = null]
	: t=bitwisexor {e=t;} (
	(LOGAND q=bitwisexor {e=new LogicalAndOperation(e, q);})
	)*;

logicalor returns [Expression e = null]
	: t=logicaland {e=t;} (
	(LOGOR q=logicaland {e=new LogicalOrOperation(e, q);})
	)*;
	
ternary returns [Expression e = null]
	: t=logicalor {e=t;} (
	('?' p=logicalor ':' q=logicalor {e=new TernaryConditional(e, p, q);})
	)*;
	
expression returns [Expression e = null]
	: (r=ternary {e=r;} (
	(EQUAL q=ternary {e=new EqualOperation(e, q);})
	|('+=' q=ternary {e=new EqualOperation(e, new SumOperation(e,q));})
	|('-=' q=ternary {e=new EqualOperation(e, new SubtractionOperation(e,q));})
	|('*=' q=ternary {e=new EqualOperation(e, new MultiplyOperation(e,q));})
	|('/=' q=ternary {e=new EqualOperation(e, new DivisionOperation(e,q));})
	|('%=' q=ternary {e=new EqualOperation(e, new ModOperation(e,q));})
	|('&=' q=ternary {e=new EqualOperation(e, new BitwiseAndOperation(e,q));})
	|('|=' q=ternary {e=new EqualOperation(e, new BitwiseOrOperation(e,q));})
	|('^=' q=ternary {e=new EqualOperation(e, new BitwiseXorOperation(e,q));})
	|('<<=' q=ternary {e=new EqualOperation(e, new LShiftOperation(e,q));})
	|('>>=' q=ternary {e=new EqualOperation(e, new RShiftOperation(e,q));})
	)*) | (t=ternary {e=t;});

//End of operations

stringconst returns [StringConstant s = null]
	: v=STRINGCONST_PRIVATE {s=StringConstant.parse(v.getText());};


STRINGCONST_PRIVATE
	: ('"'
		(~('\\'|'\r'|'\n'|'"')|'\\\\'|'\\n'|'\\t'|'\\\"')*
	'"');

doubleconst returns [DoubleConstant d = null]
	: v=DOUBLECONST_PRIVATE {d=new DoubleConstant(v.getText());};
	
DOUBLECONST_PRIVATE
	: ('-'? DIGIT* '.' DIGIT+);

intconst returns [IntConstant i = null]
	: v=INTCONST_PRIVATE {i = new IntConstant(v.getText());};


INTCONST_PRIVATE
	:	('-'?
		(('1'..'9' DIGIT*)|('0x' ('0'..'9'|'a'..'f'|'A'..'F')+)|('0' '1'..'7'*))
		);
		
boolconst returns [BooleanConstant b = new BooleanConstant(false)]
	:	('true' {b.value = true;})|'false';

type returns [Type type = new Type()]
	: (i=nativetype {type=i;})|(t=clstype {type=t;});

clstype returns [Type type = new Type()]
@init{
	type.typeCategory = TypeCategory.CLASS;
	String s = "";
}
	:	(c=WORD {s += c.getText();} ('.' t=WORD {s += "." + t.getText();})*) {type.type = s.split("\\.");};

nativetype returns [Type type = new Type()]
@init{
	type.typeCategory = TypeCategory.NATIVE;
} :	('int' {type.nativeType = NativeType.INT;})|
	('uint' {type.nativeType = NativeType.UINT;})|
	('float' {type.nativeType = NativeType.FLOAT;})|
	('ufloat' {type.nativeType = NativeType.UFLOAT;})|
	('double' {type.nativeType = NativeType.DOUBLE;})|
	('udouble' {type.nativeType = NativeType.UDOUBLE;})|
	('char' {type.nativeType = NativeType.CHAR;})|
	('uchar' {type.nativeType = NativeType.UCHAR;})|
	('bool' {type.nativeType = NativeType.BOOL;})|
	('string' {type.nativeType = NativeType.STRING;});
	
accesscontrolkeyword returns [AccessControlKeyword a = AccessControlKeyword.PUBLIC]
	:	'public' | ('private' {a = AccessControlKeyword.PRIVATE;}) | ('protected' {a = AccessControlKeyword.PROTECTED;});

WORD	:	ALPHA (ALPHA|DIGIT)*;

fragment DIGIT
	:	'0'..'9';

fragment ALPHA
	:	'_' | ('a'..'z') | ('A'..'Z');

SLCOMMENT
	:	'//' (~('\r'|'\n'))* {$channel = HIDDEN; };

MLCOMMENT 
	:	'/*' ( options {greedy=false;} : . )* '*/' { $channel = HIDDEN; };

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; };
