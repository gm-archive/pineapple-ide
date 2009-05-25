/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<bob@bobtheblueberry.com>

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

/*

Grammar guide
	:	
	
 -- Categorizing by the number of operands --
  
Unary operators
	: Operators that work with just one operand.
	-x
	x++
	--x
	They can be a prefix operator or a postfix operator:
    	Prefix operator
    	: operator operand
    	
    	Postfix operator
    	: operand operator
	
Binary Operators
	: Operators that work with two operands.
	x + y
	x * y
	x < y
	They are infix operators, which means they appear between the operands
		:
		operand1 operator operand2
		
Ternary operators
	: Operators that work with three operands.
	: PineDL has only one ternary operator, called the conditional operator.
	: The conditional operator is also infix:
	 operand1 ? operand2 : operand3
	
		


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
	SHIFT_R = '>>';
	SHIFT_L = '<<';
	NOT = '!';
	EQUAL = '=';
	LESS = '<';
	MORE = '>';
	LESS_EQ = '<=';
	MORE_EQ = '>=';
	EQUALS = '==';
	NOT_EQUAL = '!=';
	STMT_END = ';';
	BITWISE_AND = '&';
	BITWISE_OR = '|';
	BITWISE_XOR = '^';
	LOG_AND = '&&';
	LOG_OR = '||';
	BLK_BEG = '{';
	BLK_END = '}';
	PAREN_L = '(';
	PAREN_R = ')';
	ARRAY_L = '[';
	ARRAY_R = ']';
}

@header{
/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<bob@bobtheblueberry.com>

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
package org.gcreator.pineapple.pinedl;

import java.util.Vector;
import org.gcreator.pineapple.pinedl.statements.*;

}

@lexer::header{
/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<bob@bobtheblueberry.com>

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
package org.gcreator.pineapple.pinedl;

}

@members{
	private PineClass target = null;
}

doc returns [PineClass t]
@init{
	target = new PineClass();
}
	:	pkgstmt?
		importstmt*
		clsdecl
		{t = target;};

pkgstmt	:	'package' s=pkgname {target.packageName = s.split("\\."); } STMT_END;

importstmt
	:	'import' i=clstype {target.importStmt.add(i);} STMT_END;
	
clsdecl	:	'class' n=WORD {target.clsName = n.getText();} ('extends' e=clstype {target.superClass = e;})?
		BLK_BEG
		(
			f=field	{ target.variables.add(f); }	|
			m=method { target.functions.add(m); }	|
			c=constructor { target.constructors.add(c); }
		)*
		BLK_END STMT_END?; //STMTEND? means class X{} and class X{}; are both accepted

field returns [Variable v = new Variable()]
	:	a=accesscontrolkeyword {v.access = a;}
		('static' {v.isStatic = true;})?
		('final' {v.isFinal = true;})?
		t=type {v.type = t;}
		n=WORD {v.name = n.getText();}
		(EQUAL d=expression {v.defaultValue = d;})?
		STMT_END;
		
method returns [Function f = new Function()]
	:	a=accesscontrolkeyword {f.access = a;}
		('static' {f.isStatic = true;})?
		('final' {f.isFinal = true;})?
		t=type {f.returnType = t;}
		n=WORD {f.name = n.getText();}
		PAREN_L
		l=argumentlist {f.arguments = l;}
		PAREN_R
		b=block {f.content = b;};
	
constructor returns [Constructor c = new Constructor()]
	:	a=accesscontrolkeyword {c.access = a;}
		'this'
		PAREN_L
		l=argumentlist {c.arguments = l;}
		PAREN_R
		(':' 'super' {c.superArguments = new Vector<Expression>();}
			PAREN_L
			(e=expression {c.superArguments.add(e);}
			(',' e=expression {c.superArguments.add(e);})*)?
			PAREN_R)?
		b=block {c.content = b;};

argumentlist returns [Vector<Argument> v = new Vector<Argument>()]
	: (a=argument {v.add(a);} (',' a=argument {v.add(a);})*)?;
	
argument returns [Argument a = new Argument()]
	: t=type {a.type = t;}
	n=WORD {a.name = n.getText();};

block	returns [Block b = new Block()]
	:	(BLK_BEG (s=stmt {b.content.add(s);})* BLK_END);
	
stmt returns [Leaf l = null]
	:	(e=declaration {l=e;})
	| (a=expression STMT_END {l=a;})
	| (b=returnstmt {l=b;})
	| (t=throwstmt {l=t;})
	| (c=ifstmt {l=c;})
	| (w=whilestmt {l=w;})
	| (f=forstmt {l=f;})
	| (d=block {l=d;})
	| (tr=trystmt {l=tr;})
	| ('break' STMT_END {l=new BreakStatement();})
	| ('continue' STMT_END {l=new ContinueStatement();})
	| STMT_END;
	
ifstmt returns [IfStatement ifCase = new IfStatement()]
	: 'if' PAREN_L s=expression {ifCase.condition = s;} PAREN_R
		q=stmt {ifCase.then = q;}
		('else' e=stmt {ifCase.elseCase = e;})?;
		
whilestmt returns [WhileStatement whileCase = new WhileStatement()]
	: 'while' PAREN_L s=expression {whileCase.condition = s;} PAREN_R
		q=stmt {whileCase.then = q;};
		
forstmt returns [ForStatement forCase = new ForStatement()]
	: 'for' PAREN_L ((a=expression {forCase.firstStatement = a;} STMT_END)|b=declaration {forCase.firstStatement = b;}|STMT_END)
		(s=expression {forCase.condition = s;}) STMT_END
		(d=expression {forCase.loopStatement = d;}) PAREN_R
		q=stmt {forCase.then = q;};

trystmt returns [TryStatement tryStmt = new TryStatement()]
	: 'try' b=stmt {tryStmt.then = b;}
	('catch' PAREN_L t=type n=WORD PAREN_R b=stmt {Catch c = new Catch(); c.t = t; c.name = n.getText(); c.then = b; tryStmt.catchStmt.add(c);})+;
	
returnstmt returns [ReturnStatement ret = new ReturnStatement()]
	:	'return' (r=expression {ret.value = r;})? STMT_END;
	
throwstmt returns [ThrowStatement ret = new ThrowStatement()]
	:	'throw' (r=expression {ret.value = r;})? STMT_END;
	
declaration returns [DeclAssign e = new DeclAssign()]
	: t=type {e.type = t;} n=WORD {e.name = n.getText();} ('=' ex=expression {e.value=ex;})? STMT_END;

pkgname returns [String s = null]
	:	(c=WORD {s = c.getText();} ('.' t=WORD {s += "." + t.getText();})*);

reference returns [Reference r = null]
	:	ref=(WORD|'this'|'super') {r = new VariableReference(ref.getText());}
	
	(PAREN_L {r = new FunctionReference(ref.getText());}
		(e=expression {((FunctionReference) r).arguments.add(e);}
			(',' e=expression {((FunctionReference) r).arguments.add(e);})*
		)?
	PAREN_R)?
	(ARRAY_L e=expression {r = new ArrayReference(r, e);} ARRAY_R)*;

constant returns [Constant c = null]
	: (i=intconst {c=i;})|(d=doubleconst {c=d;})|(b=boolconst {c=b;})|(s=stringconst {c=s;})|(n=nullconst {c=n;});

//Multiple operations, divided by priority levels:

primitive returns [Expression e = null]
	:	
	   /* 55 */
	    c=constant {e=c;}
	    |
	   /* -x */
        s=(MINUS|PLUS) p=primitive{e = (s.getText().equals("-")) ? new NegationOperation(p) : p;}// Ignore +x
	   /* 55.23 */
	    |  (r=reference {e=r;} (('.' b=reference {e=new RetrieverExpression((Reference) e, b);})*))
	   /* (6 + 22) */
		| (PAREN_L x=expression {e=x;} PAREN_R)
	   /* new Class(1 , 2 , 3 , 4 , 5); */	
		|
	(
		'new' t=clstype {e=new NewCall(t);}
		 PAREN_L
		/* First argument */
		(ex=expression { ((NewCall) e).arguments.add(ex); }
		/* additional arguments */
		(',' ex=expression {((NewCall) e).arguments.add(ex);})*)?
		PAREN_R
	)
		/* new int[] { 1 , 2 , 3 , 4 , 5} */
		| ('new' t=clstype '[' x=expression ']' {e=new NewArray(t, x);});
		
pre_post_op returns [Expression e = null]
	:
	/* x++ x-- */
  (p=primitive {e=p;}
  (
	  '++' {e=new PrePostFixOperator(false, true, e);}
	 |'--' {e=new PrePostFixOperator(false, false, e);}
	)?)
	/* ++x --x */
	|('++' q=primitive {e=new PrePostFixOperator(true, true, q);})
	|('--' q=primitive {e=new PrePostFixOperator(true, false, q);});
	
notcastexpr returns [Expression e = null]
@init{
TypeCast cast = null;
}
	:	(p=pre_post_op {e=p;})
		| (NOT p=notcastexpr {e=new NotOperation(p);})
		| (PAREN_L t=type PAREN_R p=notcastexpr {e=new TypeCast(t, p);});
		
mult_op returns [Expression e = null]
	: t=notcastexpr {e=t;} (
	(MULT q=notcastexpr {e=new MultiplyOperation(e, q);}
	|DIV q=notcastexpr {e=new DivisionOperation(e, q);}
	|MOD q=notcastexpr {e=new ModOperation(e, q);})
	)*;

sum_op returns [Expression e = null]
	: t=mult_op {e=t;} (
	(PLUS q=mult_op {e=new SumOperation(e, q);}
	|MINUS q=mult_op {e=new SubtractionOperation(e, q);})
	)*;

bitw_shift_op returns [Expression e = null]
	: t=sum_op {e=t;} (
	(SHIFT_R q=sum_op {e=new RShiftOperation(e, q);}
	|SHIFT_L q=sum_op {e=new LShiftOperation(e, q);})
	)*;
	
compop returns [Expression e = null]
	: t=bitw_shift_op {e=t;} (
	(LESS q=bitw_shift_op {e=new LessOperation(e, q);}
	|MORE q=bitw_shift_op {e=new MoreOperation(e, q);}
	|LESS_EQ q=bitw_shift_op {e=new LessEqualOperation(e, q);}
	|MORE_EQ q=bitw_shift_op {e=new MoreEqualOperation(e, q);})
	)*;
	
comp2op returns [Expression e = null]
	: t=compop {e=t;} (
	(EQUALS q=compop {e=new EqualsOperation(e, q);}
	|NOT_EQUAL q=compop {e=new NequalOperation(e, q);})
	)*;

bitwiseand returns [Expression e = null]
	: t=comp2op {e=t;} (
	(BITWISE_AND q=comp2op {e=new BitwiseAndOperation(e, q);})
	)*;

bitwiseor returns [Expression e = null]
	: t=bitwiseand {e=t;} (
	(BITWISE_OR q=bitwiseand {e=new BitwiseOrOperation(e, q);})
	)*;
	
bitwisexor returns [Expression e = null]
	: t=bitwiseor {e=t;} (
	(BITWISE_XOR q=bitwiseor {e=new BitwiseXorOperation(e, q);})
	)*;

logicaland returns [Expression e = null]
	: t=bitwisexor {e=t;} (
	(LOG_AND q=bitwisexor {e=new LogicalAndOperation(e, q);})
	)*;

logicalor returns [Expression e = null]
	: t=logicaland {e=t;} (
	(LOG_OR q=logicaland {e=new LogicalOrOperation(e, q);})
	)*;
	
ternary_conditional returns [Expression e = null]
	: t=logicalor {e=t;} (
	('?' p=logicalor ':' q=logicalor {e=new TernaryConditional(e, p, q);})
	)*;
	
expression returns [Expression e = null]
	: r=ternary_conditional {e=r;} (
	(EQUAL q=ternary_conditional {e=new EqualOperation(e, q);})
	|('+=' q=ternary_conditional {e=new EqualOperation(e, new SumOperation(e,q));})
	|('-=' q=ternary_conditional {e=new EqualOperation(e, new SubtractionOperation(e,q));})
	|('*=' q=ternary_conditional {e=new EqualOperation(e, new MultiplyOperation(e,q));})
	|('/=' q=ternary_conditional {e=new EqualOperation(e, new DivisionOperation(e,q));})
	|('%=' q=ternary_conditional {e=new EqualOperation(e, new ModOperation(e,q));})
	|('&=' q=ternary_conditional {e=new EqualOperation(e, new BitwiseAndOperation(e,q));})
	|('|=' q=ternary_conditional {e=new EqualOperation(e, new BitwiseOrOperation(e,q));})
	|('^=' q=ternary_conditional {e=new EqualOperation(e, new BitwiseXorOperation(e,q));})
	|('<<=' q=ternary_conditional {e=new EqualOperation(e, new LShiftOperation(e,q));})
	|('>>=' q=ternary_conditional {e=new EqualOperation(e, new RShiftOperation(e,q));})
	)*;

//End of operations

stringconst returns [StringConstant s = null]
	: v=STRINGCONST_PRIVATE {s=StringConstant.parse(v.getText());};


STRINGCONST_PRIVATE
	: ('"'
		(~('\\'|'\r'|'\n'|'"')|'\\\\'|'\\n'|'\\t'|'\\\"')*
	'"');

doubleconst returns [DoubleConstant d = null]
	: s=(PLUS|MINUS)? v=DOUBLECONST_PRIVATE {d=new DoubleConstant(((s != null) ? s.getText() : "")+v.getText());};

DOUBLECONST_PRIVATE
	: (DIGIT* '.' DIGIT+);

intconst returns [IntConstant i = null]
	: s=(PLUS|MINUS)? v=INTCONST_PRIVATE {i = new IntConstant(((s != null) ? s.getText() : "")+v.getText());};



INTCONST_PRIVATE
	:	(
			(('1'..'9' DIGIT*)|('0x' ('0'..'9'|'a'..'f'|'A'..'F')+)|('0' '0'..'7'*))
		);

nullconst returns [NullConstant n = new NullConstant()]
	: 'null';

boolconst returns [BooleanConstant b = new BooleanConstant(false)]
	:	('true' {b.value = true;})|'false';

type returns [Type type = new Type()]
	: (i=nativetype {type=i;})|(t=clstype {type=t;})
	('[' ']' {Type ar = new Type(); ar.typeCategory = TypeCategory.ARRAY; ar.arrayType = type; type = ar;})*;

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
	('string' {type.nativeType = NativeType.STRING;})|
	('void' {type.nativeType = NativeType.VOID;});
	
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

WHITESPACE : ( 
    (' ' | '\t' | '\f')+
  |
    // handle newlines
    ( '\r\n'  // DOS/Windows
      | '\r'    // Macintosh
      | '\n'    // Unix
    )
    )
 { $channel = HIDDEN; };

