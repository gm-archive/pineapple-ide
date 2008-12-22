// $ANTLR 3.1 /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g 2008-12-22 18:33:34

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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class PineDLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "MINUS", "MULT", "DIV", "MOD", "DOT", "RSHIFT", "LSHIFT", "NOT", "EQUAL", "LESS", "MORE", "LESSEQ", "MOREEQ", "EQUALS", "NEQUAL", "STMTEND", "BITWISEAND", "BITWISEOR", "BITWISEXOR", "LOGAND", "LOGOR", "BLKBEG", "BLKEND", "LPAREN", "RPAREN", "LARRAY", "RARRAY", "WORD", "STRINGCONST_PRIVATE", "DOUBLECONST_PRIVATE", "DIGIT", "INTCONST_PRIVATE", "ALPHA", "SLCOMMENT", "MLCOMMENT", "WHITESPACE", "'package'", "'import'", "'class'", "'extends'", "'static'", "'this'", "':'", "'super'", "','", "'break'", "'continue'", "'if'", "'else'", "'while'", "'for'", "'return'", "'new'", "'?'", "'+='", "'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'null'", "'true'", "'false'", "'int'", "'uint'", "'float'", "'ufloat'", "'double'", "'udouble'", "'char'", "'uchar'", "'bool'", "'string'", "'public'", "'private'", "'protected'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int RARRAY=31;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int MOD=8;
    public static final int BLKEND=27;
    public static final int STMTEND=20;
    public static final int BITWISEXOR=23;
    public static final int DOUBLECONST_PRIVATE=34;
    public static final int SLCOMMENT=38;
    public static final int EQUALS=18;
    public static final int NOT=12;
    public static final int STRINGCONST_PRIVATE=33;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int LPAREN=28;
    public static final int WORD=32;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RPAREN=29;
    public static final int MOREEQ=17;
    public static final int T__57=57;
    public static final int BITWISEAND=21;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int LESSEQ=16;
    public static final int T__54=54;
    public static final int BLKBEG=26;
    public static final int T__59=59;
    public static final int EQUAL=13;
    public static final int LESS=14;
    public static final int PLUS=4;
    public static final int DIGIT=35;
    public static final int DOT=9;
    public static final int RSHIFT=10;
    public static final int T__50=50;
    public static final int MLCOMMENT=39;
    public static final int T__42=42;
    public static final int LARRAY=30;
    public static final int T__43=43;
    public static final int NEQUAL=19;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__47=47;
    public static final int T__82=82;
    public static final int T__44=44;
    public static final int T__83=83;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int LSHIFT=11;
    public static final int T__49=49;
    public static final int LOGAND=24;
    public static final int INTCONST_PRIVATE=36;
    public static final int LOGOR=25;
    public static final int WHITESPACE=40;
    public static final int MULT=6;
    public static final int MINUS=5;
    public static final int T__84=84;
    public static final int BITWISEOR=22;
    public static final int ALPHA=37;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int MORE=15;
    public static final int T__70=70;
    public static final int DIV=7;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;

    // delegates
    // delegators


        public PineDLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PineDLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PineDLParser.tokenNames; }
    public String getGrammarFileName() { return "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g"; }


    	private PineClass target = null;



    // $ANTLR start "doc"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:121:1: doc returns [PineClass t] : pkgstmt ( importstmt )* clsdecl ;
    public final PineClass doc() throws RecognitionException {
        PineClass t = null;


        	target = new PineClass();

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:125:2: ( pkgstmt ( importstmt )* clsdecl )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:125:4: pkgstmt ( importstmt )* clsdecl
            {
            pushFollow(FOLLOW_pkgstmt_in_doc281);
            pkgstmt();

            state._fsp--;
            if (state.failed) return t;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:126:3: ( importstmt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==42) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:0:0: importstmt
            	    {
            	    pushFollow(FOLLOW_importstmt_in_doc285);
            	    importstmt();

            	    state._fsp--;
            	    if (state.failed) return t;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            pushFollow(FOLLOW_clsdecl_in_doc290);
            clsdecl();

            state._fsp--;
            if (state.failed) return t;
            if ( state.backtracking==0 ) {
              t = target;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end "doc"


    // $ANTLR start "pkgstmt"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:130:1: pkgstmt : 'package' s= pkgname STMTEND ;
    public final void pkgstmt() throws RecognitionException {
        String s = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:130:9: ( 'package' s= pkgname STMTEND )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:130:11: 'package' s= pkgname STMTEND
            {
            match(input,41,FOLLOW_41_in_pkgstmt302); if (state.failed) return ;
            pushFollow(FOLLOW_pkgname_in_pkgstmt306);
            s=pkgname();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              target.packageName = s.split("\\."); 
            }
            match(input,STMTEND,FOLLOW_STMTEND_in_pkgstmt310); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pkgstmt"


    // $ANTLR start "importstmt"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:132:1: importstmt : 'import' i= clstype STMTEND ;
    public final void importstmt() throws RecognitionException {
        Type i = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:133:2: ( 'import' i= clstype STMTEND )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:133:4: 'import' i= clstype STMTEND
            {
            match(input,42,FOLLOW_42_in_importstmt319); if (state.failed) return ;
            pushFollow(FOLLOW_clstype_in_importstmt323);
            i=clstype();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              target.importStmt.add(i);
            }
            match(input,STMTEND,FOLLOW_STMTEND_in_importstmt327); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "importstmt"


    // $ANTLR start "clsdecl"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:135:1: clsdecl : 'class' n= WORD ( 'extends' e= clstype )? BLKBEG (f= field | m= method | c= constructor )* BLKEND ( STMTEND )? ;
    public final void clsdecl() throws RecognitionException {
        Token n=null;
        Type e = null;

        Variable f = null;

        Function m = null;

        Constructor c = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:135:9: ( 'class' n= WORD ( 'extends' e= clstype )? BLKBEG (f= field | m= method | c= constructor )* BLKEND ( STMTEND )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:135:11: 'class' n= WORD ( 'extends' e= clstype )? BLKBEG (f= field | m= method | c= constructor )* BLKEND ( STMTEND )?
            {
            match(input,43,FOLLOW_43_in_clsdecl336); if (state.failed) return ;
            n=(Token)match(input,WORD,FOLLOW_WORD_in_clsdecl340); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              target.clsName = n.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:135:58: ( 'extends' e= clstype )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==44) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:135:59: 'extends' e= clstype
                    {
                    match(input,44,FOLLOW_44_in_clsdecl345); if (state.failed) return ;
                    pushFollow(FOLLOW_clstype_in_clsdecl349);
                    e=clstype();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      target.superClass = e;
                    }

                    }
                    break;

            }

            match(input,BLKBEG,FOLLOW_BLKBEG_in_clsdecl357); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:137:3: (f= field | m= method | c= constructor )*
            loop3:
            do {
                int alt3=4;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:137:4: f= field
            	    {
            	    pushFollow(FOLLOW_field_in_clsdecl364);
            	    f=field();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      target.variables.add(f);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:138:3: m= method
            	    {
            	    pushFollow(FOLLOW_method_in_clsdecl373);
            	    m=method();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      target.functions.add(m);
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:138:39: c= constructor
            	    {
            	    pushFollow(FOLLOW_constructor_in_clsdecl379);
            	    c=constructor();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      target.constructors.add(c);
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,BLKEND,FOLLOW_BLKEND_in_clsdecl387); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:139:10: ( STMTEND )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==STMTEND) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:0:0: STMTEND
                    {
                    match(input,STMTEND,FOLLOW_STMTEND_in_clsdecl389); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "clsdecl"


    // $ANTLR start "field"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:141:1: field returns [Variable v = new Variable()] : a= accesscontrolkeyword ( 'static' )? t= type n= WORD STMTEND ;
    public final Variable field() throws RecognitionException {
        Variable v =  new Variable();

        Token n=null;
        AccessControlKeyword a = null;

        Type t = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:142:2: (a= accesscontrolkeyword ( 'static' )? t= type n= WORD STMTEND )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:142:4: a= accesscontrolkeyword ( 'static' )? t= type n= WORD STMTEND
            {
            pushFollow(FOLLOW_accesscontrolkeyword_in_field406);
            a=accesscontrolkeyword();

            state._fsp--;
            if (state.failed) return v;
            if ( state.backtracking==0 ) {
              v.access = a;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:143:3: ( 'static' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==45) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:143:4: 'static'
                    {
                    match(input,45,FOLLOW_45_in_field413); if (state.failed) return v;
                    if ( state.backtracking==0 ) {
                      v.isStatic = true;
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_type_in_field423);
            t=type();

            state._fsp--;
            if (state.failed) return v;
            if ( state.backtracking==0 ) {
              v.type = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_field431); if (state.failed) return v;
            if ( state.backtracking==0 ) {
              v.name = n.getText();
            }
            match(input,STMTEND,FOLLOW_STMTEND_in_field437); if (state.failed) return v;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return v;
    }
    // $ANTLR end "field"


    // $ANTLR start "method"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:148:1: method returns [Function f = new Function()] : a= accesscontrolkeyword ( 'static' )? t= type n= WORD LPAREN l= argumentlist RPAREN b= block ;
    public final Function method() throws RecognitionException {
        Function f =  new Function();

        Token n=null;
        AccessControlKeyword a = null;

        Type t = null;

        Vector<Argument> l = null;

        Block b = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:149:2: (a= accesscontrolkeyword ( 'static' )? t= type n= WORD LPAREN l= argumentlist RPAREN b= block )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:149:4: a= accesscontrolkeyword ( 'static' )? t= type n= WORD LPAREN l= argumentlist RPAREN b= block
            {
            pushFollow(FOLLOW_accesscontrolkeyword_in_method454);
            a=accesscontrolkeyword();

            state._fsp--;
            if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.access = a;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:150:3: ( 'static' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==45) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:150:4: 'static'
                    {
                    match(input,45,FOLLOW_45_in_method461); if (state.failed) return f;
                    if ( state.backtracking==0 ) {
                      f.isStatic = true;
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_type_in_method471);
            t=type();

            state._fsp--;
            if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.returnType = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_method479); if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.name = n.getText();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_method485); if (state.failed) return f;
            pushFollow(FOLLOW_argumentlist_in_method491);
            l=argumentlist();

            state._fsp--;
            if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.arguments = l;
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_method497); if (state.failed) return f;
            pushFollow(FOLLOW_block_in_method503);
            b=block();

            state._fsp--;
            if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.content = b;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return f;
    }
    // $ANTLR end "method"


    // $ANTLR start "constructor"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:158:1: constructor returns [Constructor c = new Constructor()] : a= accesscontrolkeyword 'this' LPAREN l= argumentlist RPAREN ( ':' 'super' LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? b= block ;
    public final Constructor constructor() throws RecognitionException {
        Constructor c =  new Constructor();

        AccessControlKeyword a = null;

        Vector<Argument> l = null;

        Expression e = null;

        Block b = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:159:2: (a= accesscontrolkeyword 'this' LPAREN l= argumentlist RPAREN ( ':' 'super' LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? b= block )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:159:4: a= accesscontrolkeyword 'this' LPAREN l= argumentlist RPAREN ( ':' 'super' LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? b= block
            {
            pushFollow(FOLLOW_accesscontrolkeyword_in_constructor521);
            a=accesscontrolkeyword();

            state._fsp--;
            if (state.failed) return c;
            if ( state.backtracking==0 ) {
              c.access = a;
            }
            match(input,46,FOLLOW_46_in_constructor527); if (state.failed) return c;
            match(input,LPAREN,FOLLOW_LPAREN_in_constructor531); if (state.failed) return c;
            pushFollow(FOLLOW_argumentlist_in_constructor537);
            l=argumentlist();

            state._fsp--;
            if (state.failed) return c;
            if ( state.backtracking==0 ) {
              c.arguments = l;
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_constructor543); if (state.failed) return c;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:164:3: ( ':' 'super' LPAREN (e= expression ( ',' e= expression )* )? RPAREN )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==47) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:164:4: ':' 'super' LPAREN (e= expression ( ',' e= expression )* )? RPAREN
                    {
                    match(input,47,FOLLOW_47_in_constructor548); if (state.failed) return c;
                    match(input,48,FOLLOW_48_in_constructor550); if (state.failed) return c;
                    if ( state.backtracking==0 ) {
                      c.superArguments = new Vector<Expression>();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_constructor557); if (state.failed) return c;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:166:4: (e= expression ( ',' e= expression )* )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==NOT||LA8_0==LPAREN||(LA8_0>=WORD && LA8_0<=DOUBLECONST_PRIVATE)||LA8_0==INTCONST_PRIVATE||LA8_0==46||LA8_0==48||LA8_0==57||(LA8_0>=69 && LA8_0<=71)) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:166:5: e= expression ( ',' e= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_constructor565);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return c;
                            if ( state.backtracking==0 ) {
                              c.superArguments.add(e);
                            }
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:167:4: ( ',' e= expression )*
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);

                                if ( (LA7_0==49) ) {
                                    alt7=1;
                                }


                                switch (alt7) {
                            	case 1 :
                            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:167:5: ',' e= expression
                            	    {
                            	    match(input,49,FOLLOW_49_in_constructor573); if (state.failed) return c;
                            	    pushFollow(FOLLOW_expression_in_constructor577);
                            	    e=expression();

                            	    state._fsp--;
                            	    if (state.failed) return c;
                            	    if ( state.backtracking==0 ) {
                            	      c.superArguments.add(e);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop7;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_constructor588); if (state.failed) return c;

                    }
                    break;

            }

            pushFollow(FOLLOW_block_in_constructor596);
            b=block();

            state._fsp--;
            if (state.failed) return c;
            if ( state.backtracking==0 ) {
              c.content = b;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return c;
    }
    // $ANTLR end "constructor"


    // $ANTLR start "argumentlist"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:171:1: argumentlist returns [Vector<Argument> v = new Vector<Argument>()] : (a= argument ( ',' a= argument )* )? ;
    public final Vector<Argument> argumentlist() throws RecognitionException {
        Vector<Argument> v =  new Vector<Argument>();

        Argument a = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:172:2: ( (a= argument ( ',' a= argument )* )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:172:4: (a= argument ( ',' a= argument )* )?
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:172:4: (a= argument ( ',' a= argument )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==WORD||(LA11_0>=72 && LA11_0<=81)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:172:5: a= argument ( ',' a= argument )*
                    {
                    pushFollow(FOLLOW_argument_in_argumentlist614);
                    a=argument();

                    state._fsp--;
                    if (state.failed) return v;
                    if ( state.backtracking==0 ) {
                      v.add(a);
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:172:28: ( ',' a= argument )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==49) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:172:29: ',' a= argument
                    	    {
                    	    match(input,49,FOLLOW_49_in_argumentlist619); if (state.failed) return v;
                    	    pushFollow(FOLLOW_argument_in_argumentlist623);
                    	    a=argument();

                    	    state._fsp--;
                    	    if (state.failed) return v;
                    	    if ( state.backtracking==0 ) {
                    	      v.add(a);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return v;
    }
    // $ANTLR end "argumentlist"


    // $ANTLR start "argument"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:174:1: argument returns [Argument a = new Argument()] : t= type n= WORD ;
    public final Argument argument() throws RecognitionException {
        Argument a =  new Argument();

        Token n=null;
        Type t = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:175:2: (t= type n= WORD )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:175:4: t= type n= WORD
            {
            pushFollow(FOLLOW_type_in_argument645);
            t=type();

            state._fsp--;
            if (state.failed) return a;
            if ( state.backtracking==0 ) {
              a.type = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_argument652); if (state.failed) return a;
            if ( state.backtracking==0 ) {
              a.name = n.getText();
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return a;
    }
    // $ANTLR end "argument"


    // $ANTLR start "block"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:178:1: block returns [Block b = new Block()] : ( BLKBEG (s= stmt )* BLKEND ) ;
    public final Block block() throws RecognitionException {
        Block b =  new Block();

        Leaf s = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:179:2: ( ( BLKBEG (s= stmt )* BLKEND ) )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:179:4: ( BLKBEG (s= stmt )* BLKEND )
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:179:4: ( BLKBEG (s= stmt )* BLKEND )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:179:5: BLKBEG (s= stmt )* BLKEND
            {
            match(input,BLKBEG,FOLLOW_BLKBEG_in_block668); if (state.failed) return b;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:179:12: (s= stmt )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==NOT||LA12_0==STMTEND||LA12_0==BLKBEG||LA12_0==LPAREN||(LA12_0>=WORD && LA12_0<=DOUBLECONST_PRIVATE)||LA12_0==INTCONST_PRIVATE||LA12_0==46||LA12_0==48||(LA12_0>=50 && LA12_0<=52)||(LA12_0>=54 && LA12_0<=57)||(LA12_0>=69 && LA12_0<=81)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:179:13: s= stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_block673);
            	    s=stmt();

            	    state._fsp--;
            	    if (state.failed) return b;
            	    if ( state.backtracking==0 ) {
            	      b.content.add(s);
            	    }

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match(input,BLKEND,FOLLOW_BLKEND_in_block679); if (state.failed) return b;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return b;
    }
    // $ANTLR end "block"


    // $ANTLR start "stmt"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:181:1: stmt returns [Leaf l = null] : ( (e= declAssign ) | (a= expression STMTEND ) | (b= returnstmt ) | (c= ifstmt ) | (w= whilestmt ) | (f= forstmt ) | (d= block ) | ( 'break' STMTEND ) | ( 'continue' STMTEND ) | STMTEND );
    public final Leaf stmt() throws RecognitionException {
        Leaf l =  null;

        DeclAssign e = null;

        Expression a = null;

        ReturnStatement b = null;

        IfStatement c = null;

        WhileStatement w = null;

        ForStatement f = null;

        Block d = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:182:2: ( (e= declAssign ) | (a= expression STMTEND ) | (b= returnstmt ) | (c= ifstmt ) | (w= whilestmt ) | (f= forstmt ) | (d= block ) | ( 'break' STMTEND ) | ( 'continue' STMTEND ) | STMTEND )
            int alt13=10;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:182:4: (e= declAssign )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:182:4: (e= declAssign )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:182:5: e= declAssign
                    {
                    pushFollow(FOLLOW_declAssign_in_stmt697);
                    e=declAssign();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=e;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:183:4: (a= expression STMTEND )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:183:4: (a= expression STMTEND )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:183:5: a= expression STMTEND
                    {
                    pushFollow(FOLLOW_expression_in_stmt708);
                    a=expression();

                    state._fsp--;
                    if (state.failed) return l;
                    match(input,STMTEND,FOLLOW_STMTEND_in_stmt710); if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=a;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:184:4: (b= returnstmt )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:184:4: (b= returnstmt )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:184:5: b= returnstmt
                    {
                    pushFollow(FOLLOW_returnstmt_in_stmt721);
                    b=returnstmt();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=b;
                    }

                    }


                    }
                    break;
                case 4 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:185:4: (c= ifstmt )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:185:4: (c= ifstmt )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:185:5: c= ifstmt
                    {
                    pushFollow(FOLLOW_ifstmt_in_stmt732);
                    c=ifstmt();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=c;
                    }

                    }


                    }
                    break;
                case 5 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:186:4: (w= whilestmt )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:186:4: (w= whilestmt )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:186:5: w= whilestmt
                    {
                    pushFollow(FOLLOW_whilestmt_in_stmt743);
                    w=whilestmt();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=w;
                    }

                    }


                    }
                    break;
                case 6 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:187:4: (f= forstmt )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:187:4: (f= forstmt )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:187:5: f= forstmt
                    {
                    pushFollow(FOLLOW_forstmt_in_stmt754);
                    f=forstmt();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=f;
                    }

                    }


                    }
                    break;
                case 7 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:188:4: (d= block )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:188:4: (d= block )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:188:5: d= block
                    {
                    pushFollow(FOLLOW_block_in_stmt765);
                    d=block();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=d;
                    }

                    }


                    }
                    break;
                case 8 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:189:4: ( 'break' STMTEND )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:189:4: ( 'break' STMTEND )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:189:5: 'break' STMTEND
                    {
                    match(input,50,FOLLOW_50_in_stmt774); if (state.failed) return l;
                    match(input,STMTEND,FOLLOW_STMTEND_in_stmt776); if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=new BreakStatement();
                    }

                    }


                    }
                    break;
                case 9 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:190:4: ( 'continue' STMTEND )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:190:4: ( 'continue' STMTEND )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:190:5: 'continue' STMTEND
                    {
                    match(input,51,FOLLOW_51_in_stmt785); if (state.failed) return l;
                    match(input,STMTEND,FOLLOW_STMTEND_in_stmt787); if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=new ContinueStatement();
                    }

                    }


                    }
                    break;
                case 10 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:191:4: STMTEND
                    {
                    match(input,STMTEND,FOLLOW_STMTEND_in_stmt795); if (state.failed) return l;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return l;
    }
    // $ANTLR end "stmt"


    // $ANTLR start "ifstmt"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:193:1: ifstmt returns [IfStatement ifCase = new IfStatement()] : 'if' LPAREN s= expression RPAREN q= stmt ( 'else' e= stmt )? ;
    public final IfStatement ifstmt() throws RecognitionException {
        IfStatement ifCase =  new IfStatement();

        Expression s = null;

        Leaf q = null;

        Leaf e = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:194:2: ( 'if' LPAREN s= expression RPAREN q= stmt ( 'else' e= stmt )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:194:4: 'if' LPAREN s= expression RPAREN q= stmt ( 'else' e= stmt )?
            {
            match(input,52,FOLLOW_52_in_ifstmt809); if (state.failed) return ifCase;
            match(input,LPAREN,FOLLOW_LPAREN_in_ifstmt811); if (state.failed) return ifCase;
            pushFollow(FOLLOW_expression_in_ifstmt815);
            s=expression();

            state._fsp--;
            if (state.failed) return ifCase;
            if ( state.backtracking==0 ) {
              ifCase.condition = s;
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_ifstmt819); if (state.failed) return ifCase;
            pushFollow(FOLLOW_stmt_in_ifstmt825);
            q=stmt();

            state._fsp--;
            if (state.failed) return ifCase;
            if ( state.backtracking==0 ) {
              ifCase.then = q;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:196:3: ( 'else' e= stmt )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==53) ) {
                int LA14_1 = input.LA(2);

                if ( (synpred24_PineDL()) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:196:4: 'else' e= stmt
                    {
                    match(input,53,FOLLOW_53_in_ifstmt832); if (state.failed) return ifCase;
                    pushFollow(FOLLOW_stmt_in_ifstmt836);
                    e=stmt();

                    state._fsp--;
                    if (state.failed) return ifCase;
                    if ( state.backtracking==0 ) {
                      ifCase.elseCase = e;
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ifCase;
    }
    // $ANTLR end "ifstmt"


    // $ANTLR start "whilestmt"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:1: whilestmt returns [WhileStatement whileCase = new WhileStatement()] : 'while' LPAREN s= expression RPAREN q= stmt ;
    public final WhileStatement whilestmt() throws RecognitionException {
        WhileStatement whileCase =  new WhileStatement();

        Expression s = null;

        Leaf q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:199:2: ( 'while' LPAREN s= expression RPAREN q= stmt )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:199:4: 'while' LPAREN s= expression RPAREN q= stmt
            {
            match(input,54,FOLLOW_54_in_whilestmt855); if (state.failed) return whileCase;
            match(input,LPAREN,FOLLOW_LPAREN_in_whilestmt857); if (state.failed) return whileCase;
            pushFollow(FOLLOW_expression_in_whilestmt861);
            s=expression();

            state._fsp--;
            if (state.failed) return whileCase;
            if ( state.backtracking==0 ) {
              whileCase.condition = s;
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_whilestmt865); if (state.failed) return whileCase;
            pushFollow(FOLLOW_stmt_in_whilestmt871);
            q=stmt();

            state._fsp--;
            if (state.failed) return whileCase;
            if ( state.backtracking==0 ) {
              whileCase.then = q;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return whileCase;
    }
    // $ANTLR end "whilestmt"


    // $ANTLR start "forstmt"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:202:1: forstmt returns [ForStatement forCase = new ForStatement()] : 'for' LPAREN ( (a= expression STMTEND ) | b= declAssign | STMTEND ) (s= expression ) STMTEND (d= expression ) RPAREN q= stmt ;
    public final ForStatement forstmt() throws RecognitionException {
        ForStatement forCase =  new ForStatement();

        Expression a = null;

        DeclAssign b = null;

        Expression s = null;

        Expression d = null;

        Leaf q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:2: ( 'for' LPAREN ( (a= expression STMTEND ) | b= declAssign | STMTEND ) (s= expression ) STMTEND (d= expression ) RPAREN q= stmt )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:4: 'for' LPAREN ( (a= expression STMTEND ) | b= declAssign | STMTEND ) (s= expression ) STMTEND (d= expression ) RPAREN q= stmt
            {
            match(input,55,FOLLOW_55_in_forstmt888); if (state.failed) return forCase;
            match(input,LPAREN,FOLLOW_LPAREN_in_forstmt890); if (state.failed) return forCase;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:17: ( (a= expression STMTEND ) | b= declAssign | STMTEND )
            int alt15=3;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:18: (a= expression STMTEND )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:18: (a= expression STMTEND )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:19: a= expression STMTEND
                    {
                    pushFollow(FOLLOW_expression_in_forstmt896);
                    a=expression();

                    state._fsp--;
                    if (state.failed) return forCase;
                    if ( state.backtracking==0 ) {
                      forCase.firstStatement = a;
                    }
                    match(input,STMTEND,FOLLOW_STMTEND_in_forstmt900); if (state.failed) return forCase;

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:71: b= declAssign
                    {
                    pushFollow(FOLLOW_declAssign_in_forstmt905);
                    b=declAssign();

                    state._fsp--;
                    if (state.failed) return forCase;
                    if ( state.backtracking==0 ) {
                      forCase.firstStatement = b;
                    }

                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:114: STMTEND
                    {
                    match(input,STMTEND,FOLLOW_STMTEND_in_forstmt909); if (state.failed) return forCase;

                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:204:3: (s= expression )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:204:4: s= expression
            {
            pushFollow(FOLLOW_expression_in_forstmt917);
            s=expression();

            state._fsp--;
            if (state.failed) return forCase;
            if ( state.backtracking==0 ) {
              forCase.condition = s;
            }

            }

            match(input,STMTEND,FOLLOW_STMTEND_in_forstmt922); if (state.failed) return forCase;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:205:3: (d= expression )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:205:4: d= expression
            {
            pushFollow(FOLLOW_expression_in_forstmt929);
            d=expression();

            state._fsp--;
            if (state.failed) return forCase;
            if ( state.backtracking==0 ) {
              forCase.loopStatement = d;
            }

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_forstmt934); if (state.failed) return forCase;
            pushFollow(FOLLOW_stmt_in_forstmt940);
            q=stmt();

            state._fsp--;
            if (state.failed) return forCase;
            if ( state.backtracking==0 ) {
              forCase.then = q;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return forCase;
    }
    // $ANTLR end "forstmt"


    // $ANTLR start "returnstmt"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:208:1: returnstmt returns [ReturnStatement ret = new ReturnStatement()] : 'return' (r= expression )? STMTEND ;
    public final ReturnStatement returnstmt() throws RecognitionException {
        ReturnStatement ret =  new ReturnStatement();

        Expression r = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:209:2: ( 'return' (r= expression )? STMTEND )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:209:4: 'return' (r= expression )? STMTEND
            {
            match(input,56,FOLLOW_56_in_returnstmt956); if (state.failed) return ret;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:209:13: (r= expression )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==NOT||LA16_0==LPAREN||(LA16_0>=WORD && LA16_0<=DOUBLECONST_PRIVATE)||LA16_0==INTCONST_PRIVATE||LA16_0==46||LA16_0==48||LA16_0==57||(LA16_0>=69 && LA16_0<=71)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:209:14: r= expression
                    {
                    pushFollow(FOLLOW_expression_in_returnstmt961);
                    r=expression();

                    state._fsp--;
                    if (state.failed) return ret;
                    if ( state.backtracking==0 ) {
                      ret.value = r;
                    }

                    }
                    break;

            }

            match(input,STMTEND,FOLLOW_STMTEND_in_returnstmt967); if (state.failed) return ret;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret;
    }
    // $ANTLR end "returnstmt"


    // $ANTLR start "declAssign"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:211:1: declAssign returns [DeclAssign e = new DeclAssign()] : t= type n= WORD ( '=' ex= expression )? STMTEND ;
    public final DeclAssign declAssign() throws RecognitionException {
        DeclAssign e =  new DeclAssign();

        Token n=null;
        Type t = null;

        Expression ex = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:212:2: (t= type n= WORD ( '=' ex= expression )? STMTEND )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:212:4: t= type n= WORD ( '=' ex= expression )? STMTEND
            {
            pushFollow(FOLLOW_type_in_declAssign983);
            t=type();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e.type = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_declAssign989); if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e.name = n.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:212:56: ( '=' ex= expression )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==EQUAL) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:212:57: '=' ex= expression
                    {
                    match(input,EQUAL,FOLLOW_EQUAL_in_declAssign994); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_declAssign998);
                    ex=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e.value=ex;
                    }

                    }
                    break;

            }

            match(input,STMTEND,FOLLOW_STMTEND_in_declAssign1004); if (state.failed) return e;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "declAssign"


    // $ANTLR start "pkgname"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:214:1: pkgname returns [String s = null] : (c= WORD ( '.' t= WORD )* ) ;
    public final String pkgname() throws RecognitionException {
        String s =  null;

        Token c=null;
        Token t=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:2: ( (c= WORD ( '.' t= WORD )* ) )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:4: (c= WORD ( '.' t= WORD )* )
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:4: (c= WORD ( '.' t= WORD )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:5: c= WORD ( '.' t= WORD )*
            {
            c=(Token)match(input,WORD,FOLLOW_WORD_in_pkgname1020); if (state.failed) return s;
            if ( state.backtracking==0 ) {
              s = c.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:31: ( '.' t= WORD )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==DOT) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:32: '.' t= WORD
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_pkgname1025); if (state.failed) return s;
            	    t=(Token)match(input,WORD,FOLLOW_WORD_in_pkgname1029); if (state.failed) return s;
            	    if ( state.backtracking==0 ) {
            	      s += "." + t.getText();
            	    }

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "pkgname"


    // $ANTLR start "reference"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:217:1: reference returns [Reference r = null] : ref= ( WORD | 'this' | 'super' ) ( LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? ( LARRAY e= expression RARRAY )* ;
    public final Reference reference() throws RecognitionException {
        Reference r =  null;

        Token ref=null;
        Expression e = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:218:2: (ref= ( WORD | 'this' | 'super' ) ( LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? ( LARRAY e= expression RARRAY )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:218:4: ref= ( WORD | 'this' | 'super' ) ( LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? ( LARRAY e= expression RARRAY )*
            {
            ref=(Token)input.LT(1);
            if ( input.LA(1)==WORD||input.LA(1)==46||input.LA(1)==48 ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return r;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
              r = new VariableReference(ref.getText());
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:219:2: ( LPAREN (e= expression ( ',' e= expression )* )? RPAREN )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==LPAREN) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:219:3: LPAREN (e= expression ( ',' e= expression )* )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_reference1061); if (state.failed) return r;
                    if ( state.backtracking==0 ) {
                      r = new FunctionReference(ref.getText());
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:220:3: (e= expression ( ',' e= expression )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==NOT||LA20_0==LPAREN||(LA20_0>=WORD && LA20_0<=DOUBLECONST_PRIVATE)||LA20_0==INTCONST_PRIVATE||LA20_0==46||LA20_0==48||LA20_0==57||(LA20_0>=69 && LA20_0<=71)) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:220:4: e= expression ( ',' e= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_reference1070);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return r;
                            if ( state.backtracking==0 ) {
                              ((FunctionReference) r).arguments.add(e);
                            }
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:221:4: ( ',' e= expression )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==49) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:221:5: ',' e= expression
                            	    {
                            	    match(input,49,FOLLOW_49_in_reference1078); if (state.failed) return r;
                            	    pushFollow(FOLLOW_expression_in_reference1082);
                            	    e=expression();

                            	    state._fsp--;
                            	    if (state.failed) return r;
                            	    if ( state.backtracking==0 ) {
                            	      ((FunctionReference) r).arguments.add(e);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop19;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_reference1094); if (state.failed) return r;

                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:224:2: ( LARRAY e= expression RARRAY )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==LARRAY) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:224:3: LARRAY e= expression RARRAY
            	    {
            	    match(input,LARRAY,FOLLOW_LARRAY_in_reference1100); if (state.failed) return r;
            	    pushFollow(FOLLOW_expression_in_reference1104);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      r = new ArrayReference(r, e);
            	    }
            	    match(input,RARRAY,FOLLOW_RARRAY_in_reference1108); if (state.failed) return r;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return r;
    }
    // $ANTLR end "reference"


    // $ANTLR start "constant"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:226:1: constant returns [Constant c = null] : ( (i= intconst ) | (d= doubleconst ) | (b= boolconst ) | (s= stringconst ) | (n= nullconst ) );
    public final Constant constant() throws RecognitionException {
        Constant c =  null;

        IntConstant i = null;

        DoubleConstant d = null;

        BooleanConstant b = null;

        StringConstant s = null;

        NullConstant n = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:2: ( (i= intconst ) | (d= doubleconst ) | (b= boolconst ) | (s= stringconst ) | (n= nullconst ) )
            int alt23=5;
            switch ( input.LA(1) ) {
            case INTCONST_PRIVATE:
                {
                alt23=1;
                }
                break;
            case DOUBLECONST_PRIVATE:
                {
                alt23=2;
                }
                break;
            case 70:
            case 71:
                {
                alt23=3;
                }
                break;
            case STRINGCONST_PRIVATE:
                {
                alt23=4;
                }
                break;
            case 69:
                {
                alt23=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return c;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:4: (i= intconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:4: (i= intconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:5: i= intconst
                    {
                    pushFollow(FOLLOW_intconst_in_constant1126);
                    i=intconst();

                    state._fsp--;
                    if (state.failed) return c;
                    if ( state.backtracking==0 ) {
                      c=i;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:24: (d= doubleconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:24: (d= doubleconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:25: d= doubleconst
                    {
                    pushFollow(FOLLOW_doubleconst_in_constant1134);
                    d=doubleconst();

                    state._fsp--;
                    if (state.failed) return c;
                    if ( state.backtracking==0 ) {
                      c=d;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:47: (b= boolconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:47: (b= boolconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:48: b= boolconst
                    {
                    pushFollow(FOLLOW_boolconst_in_constant1142);
                    b=boolconst();

                    state._fsp--;
                    if (state.failed) return c;
                    if ( state.backtracking==0 ) {
                      c=b;
                    }

                    }


                    }
                    break;
                case 4 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:68: (s= stringconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:68: (s= stringconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:69: s= stringconst
                    {
                    pushFollow(FOLLOW_stringconst_in_constant1150);
                    s=stringconst();

                    state._fsp--;
                    if (state.failed) return c;
                    if ( state.backtracking==0 ) {
                      c=s;
                    }

                    }


                    }
                    break;
                case 5 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:91: (n= nullconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:91: (n= nullconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:92: n= nullconst
                    {
                    pushFollow(FOLLOW_nullconst_in_constant1158);
                    n=nullconst();

                    state._fsp--;
                    if (state.failed) return c;
                    if ( state.backtracking==0 ) {
                      c=n;
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return c;
    }
    // $ANTLR end "constant"


    // $ANTLR start "primitive"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:231:1: primitive returns [Expression e = null] : (c= constant | (r= reference ( '.' b= reference )* ) | ( LPAREN x= expression RPAREN ) | ( 'new' t= clstype LPAREN (ex= expression ( ',' ex= expression )* )? RPAREN ) );
    public final Expression primitive() throws RecognitionException {
        Expression e =  null;

        Constant c = null;

        Reference r = null;

        Reference b = null;

        Expression x = null;

        Type t = null;

        Expression ex = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:232:2: (c= constant | (r= reference ( '.' b= reference )* ) | ( LPAREN x= expression RPAREN ) | ( 'new' t= clstype LPAREN (ex= expression ( ',' ex= expression )* )? RPAREN ) )
            int alt27=4;
            switch ( input.LA(1) ) {
            case STRINGCONST_PRIVATE:
            case DOUBLECONST_PRIVATE:
            case INTCONST_PRIVATE:
            case 69:
            case 70:
            case 71:
                {
                alt27=1;
                }
                break;
            case WORD:
            case 46:
            case 48:
                {
                alt27=2;
                }
                break;
            case LPAREN:
                {
                alt27=3;
                }
                break;
            case 57:
                {
                alt27=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:232:4: c= constant
                    {
                    pushFollow(FOLLOW_constant_in_primitive1178);
                    c=constant();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=c;
                    }

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:232:23: (r= reference ( '.' b= reference )* )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:232:23: (r= reference ( '.' b= reference )* )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:232:24: r= reference ( '.' b= reference )*
                    {
                    pushFollow(FOLLOW_reference_in_primitive1186);
                    r=reference();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=r;
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:232:43: ( '.' b= reference )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==DOT) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:232:44: '.' b= reference
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_primitive1191); if (state.failed) return e;
                    	    pushFollow(FOLLOW_reference_in_primitive1195);
                    	    b=reference();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new RetrieverExpression((Reference) e, b);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:233:5: ( LPAREN x= expression RPAREN )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:233:5: ( LPAREN x= expression RPAREN )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:233:6: LPAREN x= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primitive1207); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_primitive1211);
                    x=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=x;
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primitive1215); if (state.failed) return e;

                    }


                    }
                    break;
                case 4 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:233:41: ( 'new' t= clstype LPAREN (ex= expression ( ',' ex= expression )* )? RPAREN )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:233:41: ( 'new' t= clstype LPAREN (ex= expression ( ',' ex= expression )* )? RPAREN )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:233:42: 'new' t= clstype LPAREN (ex= expression ( ',' ex= expression )* )? RPAREN
                    {
                    match(input,57,FOLLOW_57_in_primitive1219); if (state.failed) return e;
                    pushFollow(FOLLOW_clstype_in_primitive1223);
                    t=clstype();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=new NewCall(t);
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primitive1229); if (state.failed) return e;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:235:3: (ex= expression ( ',' ex= expression )* )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==NOT||LA26_0==LPAREN||(LA26_0>=WORD && LA26_0<=DOUBLECONST_PRIVATE)||LA26_0==INTCONST_PRIVATE||LA26_0==46||LA26_0==48||LA26_0==57||(LA26_0>=69 && LA26_0<=71)) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:235:4: ex= expression ( ',' ex= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_primitive1236);
                            ex=expression();

                            state._fsp--;
                            if (state.failed) return e;
                            if ( state.backtracking==0 ) {
                              ((NewCall) e).arguments.add(ex);
                            }
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:236:4: ( ',' ex= expression )*
                            loop25:
                            do {
                                int alt25=2;
                                int LA25_0 = input.LA(1);

                                if ( (LA25_0==49) ) {
                                    alt25=1;
                                }


                                switch (alt25) {
                            	case 1 :
                            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:236:5: ',' ex= expression
                            	    {
                            	    match(input,49,FOLLOW_49_in_primitive1244); if (state.failed) return e;
                            	    pushFollow(FOLLOW_expression_in_primitive1248);
                            	    ex=expression();

                            	    state._fsp--;
                            	    if (state.failed) return e;
                            	    if ( state.backtracking==0 ) {
                            	      ((NewCall) e).arguments.add(ex);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop25;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_primitive1259); if (state.failed) return e;

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "primitive"


    // $ANTLR start "notcastexpr"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:239:1: notcastexpr returns [Expression e = null] : ( (p= primitive ) | ( NOT p= notcastexpr ) | ( LPAREN t= type RPAREN p= notcastexpr ) );
    public final Expression notcastexpr() throws RecognitionException {
        Expression e =  null;

        Expression p = null;

        Type t = null;



        TypeCast cast = null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:243:2: ( (p= primitive ) | ( NOT p= notcastexpr ) | ( LPAREN t= type RPAREN p= notcastexpr ) )
            int alt28=3;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:243:4: (p= primitive )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:243:4: (p= primitive )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:243:5: p= primitive
                    {
                    pushFollow(FOLLOW_primitive_in_notcastexpr1281);
                    p=primitive();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=p;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:244:5: ( NOT p= notcastexpr )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:244:5: ( NOT p= notcastexpr )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:244:6: NOT p= notcastexpr
                    {
                    match(input,NOT,FOLLOW_NOT_in_notcastexpr1291); if (state.failed) return e;
                    pushFollow(FOLLOW_notcastexpr_in_notcastexpr1295);
                    p=notcastexpr();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=new NotOperation(p);
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:245:5: ( LPAREN t= type RPAREN p= notcastexpr )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:245:5: ( LPAREN t= type RPAREN p= notcastexpr )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:245:6: LPAREN t= type RPAREN p= notcastexpr
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_notcastexpr1305); if (state.failed) return e;
                    pushFollow(FOLLOW_type_in_notcastexpr1309);
                    t=type();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,RPAREN,FOLLOW_RPAREN_in_notcastexpr1311); if (state.failed) return e;
                    pushFollow(FOLLOW_notcastexpr_in_notcastexpr1315);
                    p=notcastexpr();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=new TypeCast(t, p);
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "notcastexpr"


    // $ANTLR start "multop"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:247:1: multop returns [Expression e = null] : t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )* ;
    public final Expression multop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:248:2: (t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:248:4: t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )*
            {
            pushFollow(FOLLOW_notcastexpr_in_multop1335);
            t=notcastexpr();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:248:25: ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=MULT && LA30_0<=MOD)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:249:2: ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:249:2: ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr )
            	    int alt29=3;
            	    switch ( input.LA(1) ) {
            	    case MULT:
            	        {
            	        alt29=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt29=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt29=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 29, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt29) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:249:3: MULT q= notcastexpr
            	            {
            	            match(input,MULT,FOLLOW_MULT_in_multop1343); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_multop1347);
            	            q=notcastexpr();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new MultiplyOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:250:3: DIV q= notcastexpr
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_multop1353); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_multop1357);
            	            q=notcastexpr();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new DivisionOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:251:3: MOD q= notcastexpr
            	            {
            	            match(input,MOD,FOLLOW_MOD_in_multop1363); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_multop1367);
            	            q=notcastexpr();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new ModOperation(e, q);
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "multop"


    // $ANTLR start "sumop"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:254:1: sumop returns [Expression e = null] : t= multop ( ( PLUS q= multop | MINUS q= multop ) )* ;
    public final Expression sumop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:255:2: (t= multop ( ( PLUS q= multop | MINUS q= multop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:255:4: t= multop ( ( PLUS q= multop | MINUS q= multop ) )*
            {
            pushFollow(FOLLOW_multop_in_sumop1389);
            t=multop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:255:20: ( ( PLUS q= multop | MINUS q= multop ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=PLUS && LA32_0<=MINUS)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:256:2: ( PLUS q= multop | MINUS q= multop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:256:2: ( PLUS q= multop | MINUS q= multop )
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==PLUS) ) {
            	        alt31=1;
            	    }
            	    else if ( (LA31_0==MINUS) ) {
            	        alt31=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 31, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:256:3: PLUS q= multop
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_sumop1397); if (state.failed) return e;
            	            pushFollow(FOLLOW_multop_in_sumop1401);
            	            q=multop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new SumOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:257:3: MINUS q= multop
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_sumop1407); if (state.failed) return e;
            	            pushFollow(FOLLOW_multop_in_sumop1411);
            	            q=multop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new SubtractionOperation(e, q);
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "sumop"


    // $ANTLR start "shiftop"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:260:1: shiftop returns [Expression e = null] : t= sumop ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )* ;
    public final Expression shiftop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:261:2: (t= sumop ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:261:4: t= sumop ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )*
            {
            pushFollow(FOLLOW_sumop_in_shiftop1433);
            t=sumop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:261:19: ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=RSHIFT && LA34_0<=LSHIFT)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:262:2: ( RSHIFT q= sumop | LSHIFT q= sumop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:262:2: ( RSHIFT q= sumop | LSHIFT q= sumop )
            	    int alt33=2;
            	    int LA33_0 = input.LA(1);

            	    if ( (LA33_0==RSHIFT) ) {
            	        alt33=1;
            	    }
            	    else if ( (LA33_0==LSHIFT) ) {
            	        alt33=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 33, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt33) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:262:3: RSHIFT q= sumop
            	            {
            	            match(input,RSHIFT,FOLLOW_RSHIFT_in_shiftop1441); if (state.failed) return e;
            	            pushFollow(FOLLOW_sumop_in_shiftop1445);
            	            q=sumop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new RShiftOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:263:3: LSHIFT q= sumop
            	            {
            	            match(input,LSHIFT,FOLLOW_LSHIFT_in_shiftop1451); if (state.failed) return e;
            	            pushFollow(FOLLOW_sumop_in_shiftop1455);
            	            q=sumop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new LShiftOperation(e, q);
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "shiftop"


    // $ANTLR start "compop"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:266:1: compop returns [Expression e = null] : t= shiftop ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )* ;
    public final Expression compop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:267:2: (t= shiftop ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:267:4: t= shiftop ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )*
            {
            pushFollow(FOLLOW_shiftop_in_compop1478);
            t=shiftop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:267:21: ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=LESS && LA36_0<=MOREEQ)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:268:2: ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:268:2: ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop )
            	    int alt35=4;
            	    switch ( input.LA(1) ) {
            	    case LESS:
            	        {
            	        alt35=1;
            	        }
            	        break;
            	    case MORE:
            	        {
            	        alt35=2;
            	        }
            	        break;
            	    case LESSEQ:
            	        {
            	        alt35=3;
            	        }
            	        break;
            	    case MOREEQ:
            	        {
            	        alt35=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 35, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt35) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:268:3: LESS q= shiftop
            	            {
            	            match(input,LESS,FOLLOW_LESS_in_compop1486); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1490);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new LessOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:269:3: MORE q= shiftop
            	            {
            	            match(input,MORE,FOLLOW_MORE_in_compop1496); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1500);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new MoreOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:270:3: LESSEQ q= shiftop
            	            {
            	            match(input,LESSEQ,FOLLOW_LESSEQ_in_compop1506); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1510);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new LessEqualOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:271:3: MOREEQ q= shiftop
            	            {
            	            match(input,MOREEQ,FOLLOW_MOREEQ_in_compop1516); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1520);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new MoreEqualOperation(e, q);
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "compop"


    // $ANTLR start "comp2op"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:274:1: comp2op returns [Expression e = null] : t= compop ( ( EQUALS q= compop | NEQUAL q= compop ) )* ;
    public final Expression comp2op() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:275:2: (t= compop ( ( EQUALS q= compop | NEQUAL q= compop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:275:4: t= compop ( ( EQUALS q= compop | NEQUAL q= compop ) )*
            {
            pushFollow(FOLLOW_compop_in_comp2op1543);
            t=compop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:275:20: ( ( EQUALS q= compop | NEQUAL q= compop ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=EQUALS && LA38_0<=NEQUAL)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:276:2: ( EQUALS q= compop | NEQUAL q= compop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:276:2: ( EQUALS q= compop | NEQUAL q= compop )
            	    int alt37=2;
            	    int LA37_0 = input.LA(1);

            	    if ( (LA37_0==EQUALS) ) {
            	        alt37=1;
            	    }
            	    else if ( (LA37_0==NEQUAL) ) {
            	        alt37=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 37, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt37) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:276:3: EQUALS q= compop
            	            {
            	            match(input,EQUALS,FOLLOW_EQUALS_in_comp2op1551); if (state.failed) return e;
            	            pushFollow(FOLLOW_compop_in_comp2op1555);
            	            q=compop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new EqualsOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:277:3: NEQUAL q= compop
            	            {
            	            match(input,NEQUAL,FOLLOW_NEQUAL_in_comp2op1561); if (state.failed) return e;
            	            pushFollow(FOLLOW_compop_in_comp2op1565);
            	            q=compop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new NequalOperation(e, q);
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "comp2op"


    // $ANTLR start "bitwiseand"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:280:1: bitwiseand returns [Expression e = null] : t= comp2op ( ( BITWISEAND q= comp2op ) )* ;
    public final Expression bitwiseand() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:281:2: (t= comp2op ( ( BITWISEAND q= comp2op ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:281:4: t= comp2op ( ( BITWISEAND q= comp2op ) )*
            {
            pushFollow(FOLLOW_comp2op_in_bitwiseand1587);
            t=comp2op();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:281:21: ( ( BITWISEAND q= comp2op ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==BITWISEAND) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:282:2: ( BITWISEAND q= comp2op )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:282:2: ( BITWISEAND q= comp2op )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:282:3: BITWISEAND q= comp2op
            	    {
            	    match(input,BITWISEAND,FOLLOW_BITWISEAND_in_bitwiseand1595); if (state.failed) return e;
            	    pushFollow(FOLLOW_comp2op_in_bitwiseand1599);
            	    q=comp2op();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new BitwiseAndOperation(e, q);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "bitwiseand"


    // $ANTLR start "bitwiseor"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:1: bitwiseor returns [Expression e = null] : t= bitwiseand ( ( BITWISEOR q= bitwiseand ) )* ;
    public final Expression bitwiseor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:2: (t= bitwiseand ( ( BITWISEOR q= bitwiseand ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:4: t= bitwiseand ( ( BITWISEOR q= bitwiseand ) )*
            {
            pushFollow(FOLLOW_bitwiseand_in_bitwiseor1621);
            t=bitwiseand();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:24: ( ( BITWISEOR q= bitwiseand ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==BITWISEOR) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:2: ( BITWISEOR q= bitwiseand )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:2: ( BITWISEOR q= bitwiseand )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:3: BITWISEOR q= bitwiseand
            	    {
            	    match(input,BITWISEOR,FOLLOW_BITWISEOR_in_bitwiseor1629); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwiseand_in_bitwiseor1633);
            	    q=bitwiseand();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new BitwiseOrOperation(e, q);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "bitwiseor"


    // $ANTLR start "bitwisexor"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:290:1: bitwisexor returns [Expression e = null] : t= bitwiseor ( ( BITWISEXOR q= bitwiseor ) )* ;
    public final Expression bitwisexor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:291:2: (t= bitwiseor ( ( BITWISEXOR q= bitwiseor ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:291:4: t= bitwiseor ( ( BITWISEXOR q= bitwiseor ) )*
            {
            pushFollow(FOLLOW_bitwiseor_in_bitwisexor1656);
            t=bitwiseor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:291:23: ( ( BITWISEXOR q= bitwiseor ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==BITWISEXOR) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:292:2: ( BITWISEXOR q= bitwiseor )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:292:2: ( BITWISEXOR q= bitwiseor )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:292:3: BITWISEXOR q= bitwiseor
            	    {
            	    match(input,BITWISEXOR,FOLLOW_BITWISEXOR_in_bitwisexor1664); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwiseor_in_bitwisexor1668);
            	    q=bitwiseor();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new BitwiseXorOperation(e, q);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "bitwisexor"


    // $ANTLR start "logicaland"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:295:1: logicaland returns [Expression e = null] : t= bitwisexor ( ( LOGAND q= bitwisexor ) )* ;
    public final Expression logicaland() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:296:2: (t= bitwisexor ( ( LOGAND q= bitwisexor ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:296:4: t= bitwisexor ( ( LOGAND q= bitwisexor ) )*
            {
            pushFollow(FOLLOW_bitwisexor_in_logicaland1690);
            t=bitwisexor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:296:24: ( ( LOGAND q= bitwisexor ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==LOGAND) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:297:2: ( LOGAND q= bitwisexor )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:297:2: ( LOGAND q= bitwisexor )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:297:3: LOGAND q= bitwisexor
            	    {
            	    match(input,LOGAND,FOLLOW_LOGAND_in_logicaland1698); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwisexor_in_logicaland1702);
            	    q=bitwisexor();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new LogicalAndOperation(e, q);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "logicaland"


    // $ANTLR start "logicalor"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:300:1: logicalor returns [Expression e = null] : t= logicaland ( ( LOGOR q= logicaland ) )* ;
    public final Expression logicalor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:301:2: (t= logicaland ( ( LOGOR q= logicaland ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:301:4: t= logicaland ( ( LOGOR q= logicaland ) )*
            {
            pushFollow(FOLLOW_logicaland_in_logicalor1724);
            t=logicaland();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:301:24: ( ( LOGOR q= logicaland ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==LOGOR) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:302:2: ( LOGOR q= logicaland )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:302:2: ( LOGOR q= logicaland )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:302:3: LOGOR q= logicaland
            	    {
            	    match(input,LOGOR,FOLLOW_LOGOR_in_logicalor1732); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicaland_in_logicalor1736);
            	    q=logicaland();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new LogicalOrOperation(e, q);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "logicalor"


    // $ANTLR start "ternary"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:305:1: ternary returns [Expression e = null] : t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )* ;
    public final Expression ternary() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression p = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:306:2: (t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:306:4: t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )*
            {
            pushFollow(FOLLOW_logicalor_in_ternary1759);
            t=logicalor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:306:23: ( ( '?' p= logicalor ':' q= logicalor ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==58) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:307:2: ( '?' p= logicalor ':' q= logicalor )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:307:2: ( '?' p= logicalor ':' q= logicalor )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:307:3: '?' p= logicalor ':' q= logicalor
            	    {
            	    match(input,58,FOLLOW_58_in_ternary1767); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicalor_in_ternary1771);
            	    p=logicalor();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    match(input,47,FOLLOW_47_in_ternary1773); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicalor_in_ternary1777);
            	    q=logicalor();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new TernaryConditional(e, p, q);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "ternary"


    // $ANTLR start "expression"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:310:1: expression returns [Expression e = null] : ( (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) | (t= ternary ) );
    public final Expression expression() throws RecognitionException {
        Expression e =  null;

        Expression r = null;

        Expression q = null;

        Expression t = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:311:2: ( (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) | (t= ternary ) )
            int alt46=2;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:311:4: (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:311:4: (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:311:5: r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )*
                    {
                    pushFollow(FOLLOW_ternary_in_expression1801);
                    r=ternary();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=r;
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:311:22: ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )*
                    loop45:
                    do {
                        int alt45=12;
                        switch ( input.LA(1) ) {
                        case EQUAL:
                            {
                            alt45=1;
                            }
                            break;
                        case 59:
                            {
                            alt45=2;
                            }
                            break;
                        case 60:
                            {
                            alt45=3;
                            }
                            break;
                        case 61:
                            {
                            alt45=4;
                            }
                            break;
                        case 62:
                            {
                            alt45=5;
                            }
                            break;
                        case 63:
                            {
                            alt45=6;
                            }
                            break;
                        case 64:
                            {
                            alt45=7;
                            }
                            break;
                        case 65:
                            {
                            alt45=8;
                            }
                            break;
                        case 66:
                            {
                            alt45=9;
                            }
                            break;
                        case 67:
                            {
                            alt45=10;
                            }
                            break;
                        case 68:
                            {
                            alt45=11;
                            }
                            break;

                        }

                        switch (alt45) {
                    	case 1 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:312:2: ( EQUAL q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:312:2: ( EQUAL q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:312:3: EQUAL q= ternary
                    	    {
                    	    match(input,EQUAL,FOLLOW_EQUAL_in_expression1809); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1813);
                    	    q=ternary();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new EqualOperation(e, q);
                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:313:3: ( '+=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:313:3: ( '+=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:313:4: '+=' q= ternary
                    	    {
                    	    match(input,59,FOLLOW_59_in_expression1821); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1825);
                    	    q=ternary();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new EqualOperation(e, new SumOperation(e,q));
                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:314:3: ( '-=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:314:3: ( '-=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:314:4: '-=' q= ternary
                    	    {
                    	    match(input,60,FOLLOW_60_in_expression1833); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1837);
                    	    q=ternary();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new EqualOperation(e, new SubtractionOperation(e,q));
                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:315:3: ( '*=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:315:3: ( '*=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:315:4: '*=' q= ternary
                    	    {
                    	    match(input,61,FOLLOW_61_in_expression1845); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1849);
                    	    q=ternary();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new EqualOperation(e, new MultiplyOperation(e,q));
                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:316:3: ( '/=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:316:3: ( '/=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:316:4: '/=' q= ternary
                    	    {
                    	    match(input,62,FOLLOW_62_in_expression1857); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1861);
                    	    q=ternary();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new EqualOperation(e, new DivisionOperation(e,q));
                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 6 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:317:3: ( '%=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:317:3: ( '%=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:317:4: '%=' q= ternary
                    	    {
                    	    match(input,63,FOLLOW_63_in_expression1869); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1873);
                    	    q=ternary();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new EqualOperation(e, new ModOperation(e,q));
                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 7 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:318:3: ( '&=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:318:3: ( '&=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:318:4: '&=' q= ternary
                    	    {
                    	    match(input,64,FOLLOW_64_in_expression1881); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1885);
                    	    q=ternary();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new EqualOperation(e, new BitwiseAndOperation(e,q));
                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 8 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:319:3: ( '|=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:319:3: ( '|=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:319:4: '|=' q= ternary
                    	    {
                    	    match(input,65,FOLLOW_65_in_expression1893); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1897);
                    	    q=ternary();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new EqualOperation(e, new BitwiseOrOperation(e,q));
                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 9 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:320:3: ( '^=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:320:3: ( '^=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:320:4: '^=' q= ternary
                    	    {
                    	    match(input,66,FOLLOW_66_in_expression1905); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1909);
                    	    q=ternary();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new EqualOperation(e, new BitwiseXorOperation(e,q));
                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 10 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:3: ( '<<=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:3: ( '<<=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:4: '<<=' q= ternary
                    	    {
                    	    match(input,67,FOLLOW_67_in_expression1917); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1921);
                    	    q=ternary();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new EqualOperation(e, new LShiftOperation(e,q));
                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 11 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:322:3: ( '>>=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:322:3: ( '>>=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:322:4: '>>=' q= ternary
                    	    {
                    	    match(input,68,FOLLOW_68_in_expression1929); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1933);
                    	    q=ternary();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new EqualOperation(e, new RShiftOperation(e,q));
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:323:8: (t= ternary )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:323:8: (t= ternary )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:323:9: t= ternary
                    {
                    pushFollow(FOLLOW_ternary_in_expression1948);
                    t=ternary();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=t;
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "expression"


    // $ANTLR start "stringconst"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:327:1: stringconst returns [StringConstant s = null] : v= STRINGCONST_PRIVATE ;
    public final StringConstant stringconst() throws RecognitionException {
        StringConstant s =  null;

        Token v=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:328:2: (v= STRINGCONST_PRIVATE )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:328:4: v= STRINGCONST_PRIVATE
            {
            v=(Token)match(input,STRINGCONST_PRIVATE,FOLLOW_STRINGCONST_PRIVATE_in_stringconst1968); if (state.failed) return s;
            if ( state.backtracking==0 ) {
              s=StringConstant.parse(v.getText());
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "stringconst"


    // $ANTLR start "doubleconst"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:336:1: doubleconst returns [DoubleConstant d = null] : v= DOUBLECONST_PRIVATE ;
    public final DoubleConstant doubleconst() throws RecognitionException {
        DoubleConstant d =  null;

        Token v=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:337:2: (v= DOUBLECONST_PRIVATE )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:337:4: v= DOUBLECONST_PRIVATE
            {
            v=(Token)match(input,DOUBLECONST_PRIVATE,FOLLOW_DOUBLECONST_PRIVATE_in_doubleconst2024); if (state.failed) return d;
            if ( state.backtracking==0 ) {
              d=new DoubleConstant(v.getText());
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end "doubleconst"


    // $ANTLR start "intconst"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:342:1: intconst returns [IntConstant i = null] : v= INTCONST_PRIVATE ;
    public final IntConstant intconst() throws RecognitionException {
        IntConstant i =  null;

        Token v=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:343:2: (v= INTCONST_PRIVATE )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:343:4: v= INTCONST_PRIVATE
            {
            v=(Token)match(input,INTCONST_PRIVATE,FOLLOW_INTCONST_PRIVATE_in_intconst2062); if (state.failed) return i;
            if ( state.backtracking==0 ) {
              i = new IntConstant(v.getText());
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return i;
    }
    // $ANTLR end "intconst"


    // $ANTLR start "nullconst"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:351:1: nullconst returns [NullConstant n = new NullConstant()] : 'null' ;
    public final NullConstant nullconst() throws RecognitionException {
        NullConstant n =  new NullConstant();

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:352:2: ( 'null' )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:352:4: 'null'
            {
            match(input,69,FOLLOW_69_in_nullconst2134); if (state.failed) return n;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return n;
    }
    // $ANTLR end "nullconst"


    // $ANTLR start "boolconst"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:354:1: boolconst returns [BooleanConstant b = new BooleanConstant(false)] : ( ( 'true' ) | 'false' );
    public final BooleanConstant boolconst() throws RecognitionException {
        BooleanConstant b =  new BooleanConstant(false);

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:355:2: ( ( 'true' ) | 'false' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==70) ) {
                alt47=1;
            }
            else if ( (LA47_0==71) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return b;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:355:4: ( 'true' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:355:4: ( 'true' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:355:5: 'true'
                    {
                    match(input,70,FOLLOW_70_in_boolconst2148); if (state.failed) return b;
                    if ( state.backtracking==0 ) {
                      b.value = true;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:355:31: 'false'
                    {
                    match(input,71,FOLLOW_71_in_boolconst2153); if (state.failed) return b;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return b;
    }
    // $ANTLR end "boolconst"


    // $ANTLR start "type"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:357:1: type returns [Type type = new Type()] : ( (i= nativetype ) | (t= clstype ) );
    public final Type type() throws RecognitionException {
        Type type =  new Type();

        Type i = null;

        Type t = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:358:2: ( (i= nativetype ) | (t= clstype ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=72 && LA48_0<=81)) ) {
                alt48=1;
            }
            else if ( (LA48_0==WORD) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:358:4: (i= nativetype )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:358:4: (i= nativetype )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:358:5: i= nativetype
                    {
                    pushFollow(FOLLOW_nativetype_in_type2169);
                    i=nativetype();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type=i;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:358:29: (t= clstype )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:358:29: (t= clstype )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:358:30: t= clstype
                    {
                    pushFollow(FOLLOW_clstype_in_type2177);
                    t=clstype();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type=t;
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return type;
    }
    // $ANTLR end "type"


    // $ANTLR start "clstype"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:360:1: clstype returns [Type type = new Type()] : (c= WORD ( '.' t= WORD )* ) ;
    public final Type clstype() throws RecognitionException {
        Type type =  new Type();

        Token c=null;
        Token t=null;


        	type.typeCategory = TypeCategory.CLASS;
        	String s = "";

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:365:2: ( (c= WORD ( '.' t= WORD )* ) )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:365:4: (c= WORD ( '.' t= WORD )* )
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:365:4: (c= WORD ( '.' t= WORD )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:365:5: c= WORD ( '.' t= WORD )*
            {
            c=(Token)match(input,WORD,FOLLOW_WORD_in_clstype2200); if (state.failed) return type;
            if ( state.backtracking==0 ) {
              s += c.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:365:32: ( '.' t= WORD )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==DOT) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:365:33: '.' t= WORD
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_clstype2205); if (state.failed) return type;
            	    t=(Token)match(input,WORD,FOLLOW_WORD_in_clstype2209); if (state.failed) return type;
            	    if ( state.backtracking==0 ) {
            	      s += "." + t.getText();
            	    }

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              type.type = s.split("\\.");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return type;
    }
    // $ANTLR end "clstype"


    // $ANTLR start "nativetype"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:367:1: nativetype returns [Type type = new Type()] : ( ( 'int' ) | ( 'uint' ) | ( 'float' ) | ( 'ufloat' ) | ( 'double' ) | ( 'udouble' ) | ( 'char' ) | ( 'uchar' ) | ( 'bool' ) | ( 'string' ) );
    public final Type nativetype() throws RecognitionException {
        Type type =  new Type();


        	type.typeCategory = TypeCategory.NATIVE;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:370:3: ( ( 'int' ) | ( 'uint' ) | ( 'float' ) | ( 'ufloat' ) | ( 'double' ) | ( 'udouble' ) | ( 'char' ) | ( 'uchar' ) | ( 'bool' ) | ( 'string' ) )
            int alt50=10;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt50=1;
                }
                break;
            case 73:
                {
                alt50=2;
                }
                break;
            case 74:
                {
                alt50=3;
                }
                break;
            case 75:
                {
                alt50=4;
                }
                break;
            case 76:
                {
                alt50=5;
                }
                break;
            case 77:
                {
                alt50=6;
                }
                break;
            case 78:
                {
                alt50=7;
                }
                break;
            case 79:
                {
                alt50=8;
                }
                break;
            case 80:
                {
                alt50=9;
                }
                break;
            case 81:
                {
                alt50=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:370:5: ( 'int' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:370:5: ( 'int' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:370:6: 'int'
                    {
                    match(input,72,FOLLOW_72_in_nativetype2233); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.INT;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:371:2: ( 'uint' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:371:2: ( 'uint' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:371:3: 'uint'
                    {
                    match(input,73,FOLLOW_73_in_nativetype2241); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UINT;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:372:2: ( 'float' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:372:2: ( 'float' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:372:3: 'float'
                    {
                    match(input,74,FOLLOW_74_in_nativetype2249); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.FLOAT;
                    }

                    }


                    }
                    break;
                case 4 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:373:2: ( 'ufloat' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:373:2: ( 'ufloat' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:373:3: 'ufloat'
                    {
                    match(input,75,FOLLOW_75_in_nativetype2257); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UFLOAT;
                    }

                    }


                    }
                    break;
                case 5 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:374:2: ( 'double' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:374:2: ( 'double' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:374:3: 'double'
                    {
                    match(input,76,FOLLOW_76_in_nativetype2265); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.DOUBLE;
                    }

                    }


                    }
                    break;
                case 6 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:375:2: ( 'udouble' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:375:2: ( 'udouble' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:375:3: 'udouble'
                    {
                    match(input,77,FOLLOW_77_in_nativetype2273); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UDOUBLE;
                    }

                    }


                    }
                    break;
                case 7 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:376:2: ( 'char' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:376:2: ( 'char' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:376:3: 'char'
                    {
                    match(input,78,FOLLOW_78_in_nativetype2281); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.CHAR;
                    }

                    }


                    }
                    break;
                case 8 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:377:2: ( 'uchar' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:377:2: ( 'uchar' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:377:3: 'uchar'
                    {
                    match(input,79,FOLLOW_79_in_nativetype2289); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UCHAR;
                    }

                    }


                    }
                    break;
                case 9 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:378:2: ( 'bool' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:378:2: ( 'bool' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:378:3: 'bool'
                    {
                    match(input,80,FOLLOW_80_in_nativetype2297); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.BOOL;
                    }

                    }


                    }
                    break;
                case 10 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:379:2: ( 'string' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:379:2: ( 'string' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:379:3: 'string'
                    {
                    match(input,81,FOLLOW_81_in_nativetype2305); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.STRING;
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return type;
    }
    // $ANTLR end "nativetype"


    // $ANTLR start "accesscontrolkeyword"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:381:1: accesscontrolkeyword returns [AccessControlKeyword a = AccessControlKeyword.PUBLIC] : ( 'public' | ( 'private' ) | ( 'protected' ) );
    public final AccessControlKeyword accesscontrolkeyword() throws RecognitionException {
        AccessControlKeyword a =  AccessControlKeyword.PUBLIC;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:382:2: ( 'public' | ( 'private' ) | ( 'protected' ) )
            int alt51=3;
            switch ( input.LA(1) ) {
            case 82:
                {
                alt51=1;
                }
                break;
            case 83:
                {
                alt51=2;
                }
                break;
            case 84:
                {
                alt51=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return a;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:382:4: 'public'
                    {
                    match(input,82,FOLLOW_82_in_accesscontrolkeyword2322); if (state.failed) return a;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:382:15: ( 'private' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:382:15: ( 'private' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:382:16: 'private'
                    {
                    match(input,83,FOLLOW_83_in_accesscontrolkeyword2327); if (state.failed) return a;
                    if ( state.backtracking==0 ) {
                      a = AccessControlKeyword.PRIVATE;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:382:65: ( 'protected' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:382:65: ( 'protected' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:382:66: 'protected'
                    {
                    match(input,84,FOLLOW_84_in_accesscontrolkeyword2335); if (state.failed) return a;
                    if ( state.backtracking==0 ) {
                      a = AccessControlKeyword.PROTECTED;
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return a;
    }
    // $ANTLR end "accesscontrolkeyword"

    // $ANTLR start synpred24_PineDL
    public final void synpred24_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:196:4: ( 'else' stmt )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:196:4: 'else' stmt
        {
        match(input,53,FOLLOW_53_in_synpred24_PineDL832); if (state.failed) return ;
        pushFollow(FOLLOW_stmt_in_synpred24_PineDL836);
        stmt();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_PineDL

    // $ANTLR start synpred78_PineDL
    public final void synpred78_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:311:4: ( ( ternary ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )* ) )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:311:4: ( ternary ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )* )
        {
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:311:4: ( ternary ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )* )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:311:5: ternary ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )*
        {
        pushFollow(FOLLOW_ternary_in_synpred78_PineDL1801);
        ternary();

        state._fsp--;
        if (state.failed) return ;
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:311:22: ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )*
        loop66:
        do {
            int alt66=12;
            switch ( input.LA(1) ) {
            case EQUAL:
                {
                alt66=1;
                }
                break;
            case 59:
                {
                alt66=2;
                }
                break;
            case 60:
                {
                alt66=3;
                }
                break;
            case 61:
                {
                alt66=4;
                }
                break;
            case 62:
                {
                alt66=5;
                }
                break;
            case 63:
                {
                alt66=6;
                }
                break;
            case 64:
                {
                alt66=7;
                }
                break;
            case 65:
                {
                alt66=8;
                }
                break;
            case 66:
                {
                alt66=9;
                }
                break;
            case 67:
                {
                alt66=10;
                }
                break;
            case 68:
                {
                alt66=11;
                }
                break;

            }

            switch (alt66) {
        	case 1 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:312:2: ( EQUAL ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:312:2: ( EQUAL ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:312:3: EQUAL ternary
        	    {
        	    match(input,EQUAL,FOLLOW_EQUAL_in_synpred78_PineDL1809); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred78_PineDL1813);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 2 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:313:3: ( '+=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:313:3: ( '+=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:313:4: '+=' ternary
        	    {
        	    match(input,59,FOLLOW_59_in_synpred78_PineDL1821); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred78_PineDL1825);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 3 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:314:3: ( '-=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:314:3: ( '-=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:314:4: '-=' ternary
        	    {
        	    match(input,60,FOLLOW_60_in_synpred78_PineDL1833); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred78_PineDL1837);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 4 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:315:3: ( '*=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:315:3: ( '*=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:315:4: '*=' ternary
        	    {
        	    match(input,61,FOLLOW_61_in_synpred78_PineDL1845); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred78_PineDL1849);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 5 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:316:3: ( '/=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:316:3: ( '/=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:316:4: '/=' ternary
        	    {
        	    match(input,62,FOLLOW_62_in_synpred78_PineDL1857); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred78_PineDL1861);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 6 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:317:3: ( '%=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:317:3: ( '%=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:317:4: '%=' ternary
        	    {
        	    match(input,63,FOLLOW_63_in_synpred78_PineDL1869); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred78_PineDL1873);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 7 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:318:3: ( '&=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:318:3: ( '&=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:318:4: '&=' ternary
        	    {
        	    match(input,64,FOLLOW_64_in_synpred78_PineDL1881); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred78_PineDL1885);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 8 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:319:3: ( '|=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:319:3: ( '|=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:319:4: '|=' ternary
        	    {
        	    match(input,65,FOLLOW_65_in_synpred78_PineDL1893); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred78_PineDL1897);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 9 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:320:3: ( '^=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:320:3: ( '^=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:320:4: '^=' ternary
        	    {
        	    match(input,66,FOLLOW_66_in_synpred78_PineDL1905); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred78_PineDL1909);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 10 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:3: ( '<<=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:3: ( '<<=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:4: '<<=' ternary
        	    {
        	    match(input,67,FOLLOW_67_in_synpred78_PineDL1917); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred78_PineDL1921);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 11 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:322:3: ( '>>=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:322:3: ( '>>=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:322:4: '>>=' ternary
        	    {
        	    match(input,68,FOLLOW_68_in_synpred78_PineDL1929); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred78_PineDL1933);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop66;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred78_PineDL

    // Delegated rules

    public final boolean synpred78_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA46 dfa46 = new DFA46(this);
    static final String DFA3_eotS =
        "\27\uffff";
    static final String DFA3_eofS =
        "\27\uffff";
    static final String DFA3_minS =
        "\1\33\1\uffff\3\40\1\uffff\13\40\1\11\1\24\1\40\2\uffff\1\11";
    static final String DFA3_maxS =
        "\1\124\1\uffff\3\121\1\uffff\1\121\13\40\1\34\1\40\2\uffff\1\40";
    static final String DFA3_acceptS =
        "\1\uffff\1\4\3\uffff\1\3\16\uffff\1\2\1\1\1\uffff";
    static final String DFA3_specialS =
        "\27\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1\66\uffff\1\2\1\3\1\4",
            "",
            "\1\21\14\uffff\1\6\1\5\31\uffff\1\7\1\10\1\11\1\12\1\13\1\14"+
            "\1\15\1\16\1\17\1\20",
            "\1\21\14\uffff\1\6\1\5\31\uffff\1\7\1\10\1\11\1\12\1\13\1\14"+
            "\1\15\1\16\1\17\1\20",
            "\1\21\14\uffff\1\6\1\5\31\uffff\1\7\1\10\1\11\1\12\1\13\1\14"+
            "\1\15\1\16\1\17\1\20",
            "",
            "\1\21\47\uffff\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
            "\1\20",
            "\1\22",
            "\1\22",
            "\1\22",
            "\1\22",
            "\1\22",
            "\1\22",
            "\1\22",
            "\1\22",
            "\1\22",
            "\1\22",
            "\1\23\26\uffff\1\22",
            "\1\25\7\uffff\1\24",
            "\1\26",
            "",
            "",
            "\1\23\26\uffff\1\22"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()* loopback of 137:3: (f= field | m= method | c= constructor )*";
        }
    }
    static final String DFA13_eotS =
        "\16\uffff";
    static final String DFA13_eofS =
        "\16\uffff";
    static final String DFA13_minS =
        "\1\14\1\uffff\1\4\11\uffff\1\40\1\4";
    static final String DFA13_maxS =
        "\1\121\1\uffff\1\104\11\uffff\1\60\1\104";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\2\uffff";
    static final String DFA13_specialS =
        "\16\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\3\7\uffff\1\13\5\uffff\1\10\1\uffff\1\3\3\uffff\1\2\2\3\1"+
            "\uffff\1\3\11\uffff\1\3\1\uffff\1\3\1\uffff\1\11\1\12\1\5\1"+
            "\uffff\1\6\1\7\1\4\1\3\13\uffff\3\3\12\1",
            "",
            "\5\3\1\14\2\3\1\uffff\15\3\2\uffff\1\3\1\uffff\1\3\1\uffff"+
            "\1\1\31\uffff\13\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15\15\uffff\1\3\1\uffff\1\3",
            "\5\3\1\14\2\3\1\uffff\15\3\2\uffff\1\3\1\uffff\1\3\1\uffff"+
            "\1\1\31\uffff\13\3"
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "181:1: stmt returns [Leaf l = null] : ( (e= declAssign ) | (a= expression STMTEND ) | (b= returnstmt ) | (c= ifstmt ) | (w= whilestmt ) | (f= forstmt ) | (d= block ) | ( 'break' STMTEND ) | ( 'continue' STMTEND ) | STMTEND );";
        }
    }
    static final String DFA15_eotS =
        "\7\uffff";
    static final String DFA15_eofS =
        "\7\uffff";
    static final String DFA15_minS =
        "\1\14\1\uffff\1\4\2\uffff\1\40\1\4";
    static final String DFA15_maxS =
        "\1\121\1\uffff\1\104\2\uffff\1\60\1\104";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\2\uffff";
    static final String DFA15_specialS =
        "\7\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\7\uffff\1\4\7\uffff\1\1\3\uffff\1\2\2\1\1\uffff\1\1\11"+
            "\uffff\1\1\1\uffff\1\1\10\uffff\1\1\13\uffff\3\1\12\3",
            "",
            "\5\1\1\5\2\1\1\uffff\15\1\2\uffff\1\1\1\uffff\1\1\1\uffff\1"+
            "\3\31\uffff\13\1",
            "",
            "",
            "\1\6\15\uffff\1\1\1\uffff\1\1",
            "\5\1\1\5\2\1\1\uffff\15\1\2\uffff\1\1\1\uffff\1\1\1\uffff\1"+
            "\3\31\uffff\13\1"
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "203:17: ( (a= expression STMTEND ) | b= declAssign | STMTEND )";
        }
    }
    static final String DFA28_eotS =
        "\11\uffff";
    static final String DFA28_eofS =
        "\7\uffff\1\1\1\uffff";
    static final String DFA28_minS =
        "\1\14\1\uffff\1\14\1\uffff\1\4\1\uffff\1\40\2\4";
    static final String DFA28_maxS =
        "\1\107\1\uffff\1\121\1\uffff\1\104\1\uffff\1\60\1\107\1\104";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\uffff\1\3\3\uffff";
    static final String DFA28_specialS =
        "\11\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\3\17\uffff\1\2\3\uffff\3\1\1\uffff\1\1\11\uffff\1\1\1\uffff"+
            "\1\1\10\uffff\1\1\13\uffff\3\1",
            "",
            "\1\1\17\uffff\1\1\3\uffff\1\4\2\1\1\uffff\1\1\11\uffff\1\1"+
            "\1\uffff\1\1\10\uffff\1\1\13\uffff\3\1\12\5",
            "",
            "\5\1\1\6\2\1\1\uffff\7\1\1\uffff\5\1\2\uffff\1\1\1\7\1\1\33"+
            "\uffff\13\1",
            "",
            "\1\10\15\uffff\1\1\1\uffff\1\1",
            "\5\1\1\uffff\2\1\1\5\15\1\2\uffff\1\5\1\1\1\uffff\1\1\3\5\1"+
            "\uffff\1\5\11\uffff\1\5\1\1\1\5\1\1\7\uffff\1\5\13\1\3\5",
            "\5\1\1\6\2\1\1\uffff\7\1\1\uffff\5\1\2\uffff\1\1\1\7\1\1\33"+
            "\uffff\13\1"
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "239:1: notcastexpr returns [Expression e = null] : ( (p= primitive ) | ( NOT p= notcastexpr ) | ( LPAREN t= type RPAREN p= notcastexpr ) );";
        }
    }
    static final String DFA46_eotS =
        "\15\uffff";
    static final String DFA46_eofS =
        "\15\uffff";
    static final String DFA46_minS =
        "\1\14\12\0\2\uffff";
    static final String DFA46_maxS =
        "\1\107\12\0\2\uffff";
    static final String DFA46_acceptS =
        "\13\uffff\1\1\1\2";
    static final String DFA46_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\2\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\12\17\uffff\1\10\3\uffff\1\7\1\5\1\2\1\uffff\1\1\11\uffff"+
            "\1\7\1\uffff\1\7\10\uffff\1\11\13\uffff\1\6\1\3\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "310:1: expression returns [Expression e = null] : ( (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) | (t= ternary ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_1 = input.LA(1);

                         
                        int index46_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_PineDL()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index46_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA46_2 = input.LA(1);

                         
                        int index46_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_PineDL()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index46_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA46_3 = input.LA(1);

                         
                        int index46_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_PineDL()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index46_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA46_4 = input.LA(1);

                         
                        int index46_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_PineDL()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index46_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA46_5 = input.LA(1);

                         
                        int index46_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_PineDL()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index46_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA46_6 = input.LA(1);

                         
                        int index46_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_PineDL()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index46_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA46_7 = input.LA(1);

                         
                        int index46_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_PineDL()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index46_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA46_8 = input.LA(1);

                         
                        int index46_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_PineDL()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index46_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA46_9 = input.LA(1);

                         
                        int index46_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_PineDL()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index46_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA46_10 = input.LA(1);

                         
                        int index46_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_PineDL()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index46_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 46, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_pkgstmt_in_doc281 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_importstmt_in_doc285 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_clsdecl_in_doc290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_pkgstmt302 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pkgname_in_pkgstmt306 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_pkgstmt310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_importstmt319 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_clstype_in_importstmt323 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_importstmt327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_clsdecl336 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_clsdecl340 = new BitSet(new long[]{0x0000100004000000L});
    public static final BitSet FOLLOW_44_in_clsdecl345 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_clstype_in_clsdecl349 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_BLKBEG_in_clsdecl357 = new BitSet(new long[]{0x0000000008000000L,0x00000000001C0000L});
    public static final BitSet FOLLOW_field_in_clsdecl364 = new BitSet(new long[]{0x0000000008000000L,0x00000000001C0000L});
    public static final BitSet FOLLOW_method_in_clsdecl373 = new BitSet(new long[]{0x0000000008000000L,0x00000000001C0000L});
    public static final BitSet FOLLOW_constructor_in_clsdecl379 = new BitSet(new long[]{0x0000000008000000L,0x00000000001C0000L});
    public static final BitSet FOLLOW_BLKEND_in_clsdecl387 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_STMTEND_in_clsdecl389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accesscontrolkeyword_in_field406 = new BitSet(new long[]{0x0000200100000000L,0x000000000003FF00L});
    public static final BitSet FOLLOW_45_in_field413 = new BitSet(new long[]{0x0000200100000000L,0x000000000003FF00L});
    public static final BitSet FOLLOW_type_in_field423 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_field431 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_field437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accesscontrolkeyword_in_method454 = new BitSet(new long[]{0x0000200100000000L,0x000000000003FF00L});
    public static final BitSet FOLLOW_45_in_method461 = new BitSet(new long[]{0x0000200100000000L,0x000000000003FF00L});
    public static final BitSet FOLLOW_type_in_method471 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_method479 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_method485 = new BitSet(new long[]{0x0000200120000000L,0x000000000003FF00L});
    public static final BitSet FOLLOW_argumentlist_in_method491 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_method497 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_block_in_method503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accesscontrolkeyword_in_constructor521 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_constructor527 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_constructor531 = new BitSet(new long[]{0x0000200120000000L,0x000000000003FF00L});
    public static final BitSet FOLLOW_argumentlist_in_constructor537 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_constructor543 = new BitSet(new long[]{0x0000800004000000L});
    public static final BitSet FOLLOW_47_in_constructor548 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_constructor550 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_constructor557 = new BitSet(new long[]{0x0201401730001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_constructor565 = new BitSet(new long[]{0x0002000020000000L});
    public static final BitSet FOLLOW_49_in_constructor573 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_constructor577 = new BitSet(new long[]{0x0002000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_constructor588 = new BitSet(new long[]{0x0000800004000000L});
    public static final BitSet FOLLOW_block_in_constructor596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_argumentlist614 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_argumentlist619 = new BitSet(new long[]{0x0000200100000000L,0x000000000003FF00L});
    public static final BitSet FOLLOW_argument_in_argumentlist623 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_type_in_argument645 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_argument652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLKBEG_in_block668 = new BitSet(new long[]{0x03DDE0171C101000L,0x000000000003FFE0L});
    public static final BitSet FOLLOW_stmt_in_block673 = new BitSet(new long[]{0x03DDE0171C101000L,0x000000000003FFE0L});
    public static final BitSet FOLLOW_BLKEND_in_block679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declAssign_in_stmt697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_stmt708 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_stmt710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnstmt_in_stmt721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifstmt_in_stmt732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whilestmt_in_stmt743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forstmt_in_stmt754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_stmt765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_stmt774 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_stmt776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_stmt785 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_stmt787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STMTEND_in_stmt795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ifstmt809 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_ifstmt811 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_ifstmt815 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_ifstmt819 = new BitSet(new long[]{0x03DDE0171C101000L,0x000000000003FFE0L});
    public static final BitSet FOLLOW_stmt_in_ifstmt825 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_ifstmt832 = new BitSet(new long[]{0x03DDE0171C101000L,0x000000000003FFE0L});
    public static final BitSet FOLLOW_stmt_in_ifstmt836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_whilestmt855 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_whilestmt857 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_whilestmt861 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_whilestmt865 = new BitSet(new long[]{0x03DDE0171C101000L,0x000000000003FFE0L});
    public static final BitSet FOLLOW_stmt_in_whilestmt871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_forstmt888 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_forstmt890 = new BitSet(new long[]{0x0201601710101000L,0x000000000003FFE0L});
    public static final BitSet FOLLOW_expression_in_forstmt896 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_forstmt900 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_declAssign_in_forstmt905 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_STMTEND_in_forstmt909 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_forstmt917 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_forstmt922 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_forstmt929 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_forstmt934 = new BitSet(new long[]{0x03DDE0171C101000L,0x000000000003FFE0L});
    public static final BitSet FOLLOW_stmt_in_forstmt940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_returnstmt956 = new BitSet(new long[]{0x0201401710101000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_returnstmt961 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_returnstmt967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_declAssign983 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_declAssign989 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_EQUAL_in_declAssign994 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_declAssign998 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_declAssign1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_pkgname1020 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_pkgname1025 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_pkgname1029 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_set_in_reference1049 = new BitSet(new long[]{0x0000000050000002L});
    public static final BitSet FOLLOW_LPAREN_in_reference1061 = new BitSet(new long[]{0x0201401730001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_reference1070 = new BitSet(new long[]{0x0002000020000000L});
    public static final BitSet FOLLOW_49_in_reference1078 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_reference1082 = new BitSet(new long[]{0x0002000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_reference1094 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_LARRAY_in_reference1100 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_reference1104 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RARRAY_in_reference1108 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_intconst_in_constant1126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doubleconst_in_constant1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolconst_in_constant1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringconst_in_constant1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nullconst_in_constant1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primitive1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_in_primitive1186 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_primitive1191 = new BitSet(new long[]{0x0001400100000000L});
    public static final BitSet FOLLOW_reference_in_primitive1195 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_LPAREN_in_primitive1207 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_primitive1211 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_primitive1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_primitive1219 = new BitSet(new long[]{0x0000200100000000L,0x000000000003FF00L});
    public static final BitSet FOLLOW_clstype_in_primitive1223 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_primitive1229 = new BitSet(new long[]{0x0201401730001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_primitive1236 = new BitSet(new long[]{0x0002000020000000L});
    public static final BitSet FOLLOW_49_in_primitive1244 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_expression_in_primitive1248 = new BitSet(new long[]{0x0002000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_primitive1259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitive_in_notcastexpr1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notcastexpr1291 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_notcastexpr_in_notcastexpr1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_notcastexpr1305 = new BitSet(new long[]{0x0000200100000000L,0x000000000003FF00L});
    public static final BitSet FOLLOW_type_in_notcastexpr1309 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_notcastexpr1311 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_notcastexpr_in_notcastexpr1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notcastexpr_in_multop1335 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_MULT_in_multop1343 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_notcastexpr_in_multop1347 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_DIV_in_multop1353 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_notcastexpr_in_multop1357 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_MOD_in_multop1363 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_notcastexpr_in_multop1367 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_multop_in_sumop1389 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_PLUS_in_sumop1397 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_multop_in_sumop1401 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_MINUS_in_sumop1407 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_multop_in_sumop1411 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_sumop_in_shiftop1433 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_RSHIFT_in_shiftop1441 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_sumop_in_shiftop1445 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_LSHIFT_in_shiftop1451 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_sumop_in_shiftop1455 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_shiftop_in_compop1478 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LESS_in_compop1486 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_shiftop_in_compop1490 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_MORE_in_compop1496 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_shiftop_in_compop1500 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LESSEQ_in_compop1506 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_shiftop_in_compop1510 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_MOREEQ_in_compop1516 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_shiftop_in_compop1520 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_compop_in_comp2op1543 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_EQUALS_in_comp2op1551 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_compop_in_comp2op1555 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_NEQUAL_in_comp2op1561 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_compop_in_comp2op1565 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_comp2op_in_bitwiseand1587 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_BITWISEAND_in_bitwiseand1595 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_comp2op_in_bitwiseand1599 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_bitwiseand_in_bitwiseor1621 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_BITWISEOR_in_bitwiseor1629 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_bitwiseand_in_bitwiseor1633 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_bitwiseor_in_bitwisexor1656 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_BITWISEXOR_in_bitwisexor1664 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_bitwiseor_in_bitwisexor1668 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_bitwisexor_in_logicaland1690 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_LOGAND_in_logicaland1698 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_bitwisexor_in_logicaland1702 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_logicaland_in_logicalor1724 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LOGOR_in_logicalor1732 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_logicaland_in_logicalor1736 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_logicalor_in_ternary1759 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_ternary1767 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_logicalor_in_ternary1771 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ternary1773 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_logicalor_in_ternary1777 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_ternary_in_expression1801 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_EQUAL_in_expression1809 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_expression1813 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_59_in_expression1821 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_expression1825 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_60_in_expression1833 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_expression1837 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_61_in_expression1845 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_expression1849 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_62_in_expression1857 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_expression1861 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_63_in_expression1869 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_expression1873 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_64_in_expression1881 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_expression1885 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_65_in_expression1893 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_expression1897 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_66_in_expression1905 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_expression1909 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_67_in_expression1917 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_expression1921 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_68_in_expression1929 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_expression1933 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_ternary_in_expression1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGCONST_PRIVATE_in_stringconst1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLECONST_PRIVATE_in_doubleconst2024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTCONST_PRIVATE_in_intconst2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_nullconst2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_boolconst2148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_boolconst2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativetype_in_type2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_clstype_in_type2177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_clstype2200 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_clstype2205 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_clstype2209 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_72_in_nativetype2233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_nativetype2241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_nativetype2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_nativetype2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_nativetype2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_nativetype2273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_nativetype2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_nativetype2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_nativetype2297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_nativetype2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_accesscontrolkeyword2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_accesscontrolkeyword2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_accesscontrolkeyword2335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred24_PineDL832 = new BitSet(new long[]{0x03DDE0171C101000L,0x000000000003FFE0L});
    public static final BitSet FOLLOW_stmt_in_synpred24_PineDL836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ternary_in_synpred78_PineDL1801 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_EQUAL_in_synpred78_PineDL1809 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_synpred78_PineDL1813 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_59_in_synpred78_PineDL1821 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_synpred78_PineDL1825 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_60_in_synpred78_PineDL1833 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_synpred78_PineDL1837 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_61_in_synpred78_PineDL1845 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_synpred78_PineDL1849 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_62_in_synpred78_PineDL1857 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_synpred78_PineDL1861 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_63_in_synpred78_PineDL1869 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_synpred78_PineDL1873 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_64_in_synpred78_PineDL1881 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_synpred78_PineDL1885 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_65_in_synpred78_PineDL1893 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_synpred78_PineDL1897 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_66_in_synpred78_PineDL1905 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_synpred78_PineDL1909 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_67_in_synpred78_PineDL1917 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_synpred78_PineDL1921 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});
    public static final BitSet FOLLOW_68_in_synpred78_PineDL1929 = new BitSet(new long[]{0x0201401710001000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ternary_in_synpred78_PineDL1933 = new BitSet(new long[]{0xF800000000002002L,0x000000000000001FL});

}