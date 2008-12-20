// $ANTLR 3.1 /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g 2008-12-20 22:39:01

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "MINUS", "MULT", "DIV", "MOD", "DOT", "RSHIFT", "LSHIFT", "NOT", "EQUAL", "LESS", "MORE", "LESSEQ", "MOREEQ", "EQUALS", "NEQUAL", "STMTEND", "BITWISEAND", "BITWISEOR", "BITWISEXOR", "LOGAND", "LOGOR", "BLKBEG", "BLKEND", "LPAREN", "RPAREN", "LARRAY", "RARRAY", "WORD", "STRINGCONST_PRIVATE", "DOUBLECONST_PRIVATE", "DIGIT", "INTCONST_PRIVATE", "ALPHA", "SLCOMMENT", "MLCOMMENT", "WHITESPACE", "'package'", "'import'", "'class'", "'extends'", "'static'", "'this'", "','", "'return'", "'?'", "':'", "'+='", "'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'true'", "'false'", "'int'", "'uint'", "'float'", "'ufloat'", "'double'", "'udouble'", "'char'", "'uchar'", "'bool'", "'string'", "'public'", "'private'", "'protected'"
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
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int LSHIFT=11;
    public static final int T__49=49;
    public static final int LOGAND=24;
    public static final int INTCONST_PRIVATE=36;
    public static final int LOGOR=25;
    public static final int WHITESPACE=40;
    public static final int MINUS=5;
    public static final int MULT=6;
    public static final int BITWISEOR=22;
    public static final int ALPHA=37;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int MORE=15;
    public static final int T__70=70;
    public static final int DIV=7;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:148:1: method returns [Function f = new Function()] : a= accesscontrolkeyword ( 'static' )? t= type n= WORD LPAREN l= argumentlist RPAREN b= block ( STMTEND )? ;
    public final Function method() throws RecognitionException {
        Function f =  new Function();

        Token n=null;
        AccessControlKeyword a = null;

        Type t = null;

        Vector<Argument> l = null;

        Block b = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:149:2: (a= accesscontrolkeyword ( 'static' )? t= type n= WORD LPAREN l= argumentlist RPAREN b= block ( STMTEND )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:149:4: a= accesscontrolkeyword ( 'static' )? t= type n= WORD LPAREN l= argumentlist RPAREN b= block ( STMTEND )?
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
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:157:3: ( STMTEND )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==STMTEND) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:0:0: STMTEND
                    {
                    match(input,STMTEND,FOLLOW_STMTEND_in_method509); if (state.failed) return f;

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
        return f;
    }
    // $ANTLR end "method"


    // $ANTLR start "constructor"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:159:1: constructor returns [Constructor c = new Constructor()] : a= accesscontrolkeyword 'this' LPAREN l= argumentlist RPAREN b= block ( STMTEND )? ;
    public final Constructor constructor() throws RecognitionException {
        Constructor c =  new Constructor();

        AccessControlKeyword a = null;

        Vector<Argument> l = null;

        Block b = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:160:2: (a= accesscontrolkeyword 'this' LPAREN l= argumentlist RPAREN b= block ( STMTEND )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:160:4: a= accesscontrolkeyword 'this' LPAREN l= argumentlist RPAREN b= block ( STMTEND )?
            {
            pushFollow(FOLLOW_accesscontrolkeyword_in_constructor527);
            a=accesscontrolkeyword();

            state._fsp--;
            if (state.failed) return c;
            if ( state.backtracking==0 ) {
              c.access = a;
            }
            match(input,46,FOLLOW_46_in_constructor533); if (state.failed) return c;
            match(input,LPAREN,FOLLOW_LPAREN_in_constructor540); if (state.failed) return c;
            pushFollow(FOLLOW_argumentlist_in_constructor546);
            l=argumentlist();

            state._fsp--;
            if (state.failed) return c;
            if ( state.backtracking==0 ) {
              c.arguments = l;
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_constructor552); if (state.failed) return c;
            pushFollow(FOLLOW_block_in_constructor558);
            b=block();

            state._fsp--;
            if (state.failed) return c;
            if ( state.backtracking==0 ) {
              c.content = b;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:167:3: ( STMTEND )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==STMTEND) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:0:0: STMTEND
                    {
                    match(input,STMTEND,FOLLOW_STMTEND_in_constructor564); if (state.failed) return c;

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
        return c;
    }
    // $ANTLR end "constructor"


    // $ANTLR start "argumentlist"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:169:1: argumentlist returns [Vector<Argument> v = new Vector<Argument>()] : (a= argument ( ',' a= argument )* )? ;
    public final Vector<Argument> argumentlist() throws RecognitionException {
        Vector<Argument> v =  new Vector<Argument>();

        Argument a = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:170:2: ( (a= argument ( ',' a= argument )* )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:170:4: (a= argument ( ',' a= argument )* )?
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:170:4: (a= argument ( ',' a= argument )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==WORD||(LA10_0>=63 && LA10_0<=72)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:170:5: a= argument ( ',' a= argument )*
                    {
                    pushFollow(FOLLOW_argument_in_argumentlist582);
                    a=argument();

                    state._fsp--;
                    if (state.failed) return v;
                    if ( state.backtracking==0 ) {
                      v.add(a);
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:170:28: ( ',' a= argument )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==47) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:170:29: ',' a= argument
                    	    {
                    	    match(input,47,FOLLOW_47_in_argumentlist587); if (state.failed) return v;
                    	    pushFollow(FOLLOW_argument_in_argumentlist591);
                    	    a=argument();

                    	    state._fsp--;
                    	    if (state.failed) return v;
                    	    if ( state.backtracking==0 ) {
                    	      v.add(a);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:172:1: argument returns [Argument a = new Argument()] : t= type n= WORD ;
    public final Argument argument() throws RecognitionException {
        Argument a =  new Argument();

        Token n=null;
        Type t = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:173:2: (t= type n= WORD )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:173:4: t= type n= WORD
            {
            pushFollow(FOLLOW_type_in_argument613);
            t=type();

            state._fsp--;
            if (state.failed) return a;
            if ( state.backtracking==0 ) {
              a.type = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_argument620); if (state.failed) return a;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:176:1: block returns [Block b = new Block()] : ( BLKBEG (s= stmt )* BLKEND ) ;
    public final Block block() throws RecognitionException {
        Block b =  new Block();

        Leaf s = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:177:2: ( ( BLKBEG (s= stmt )* BLKEND ) )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:177:4: ( BLKBEG (s= stmt )* BLKEND )
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:177:4: ( BLKBEG (s= stmt )* BLKEND )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:177:5: BLKBEG (s= stmt )* BLKEND
            {
            match(input,BLKBEG,FOLLOW_BLKBEG_in_block636); if (state.failed) return b;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:177:12: (s= stmt )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==NOT||LA11_0==LPAREN||(LA11_0>=WORD && LA11_0<=DOUBLECONST_PRIVATE)||LA11_0==INTCONST_PRIVATE||LA11_0==48||(LA11_0>=61 && LA11_0<=72)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:177:13: s= stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_block641);
            	    s=stmt();

            	    state._fsp--;
            	    if (state.failed) return b;
            	    if ( state.backtracking==0 ) {
            	      b.content.add(s);
            	    }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match(input,BLKEND,FOLLOW_BLKEND_in_block647); if (state.failed) return b;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:179:1: stmt returns [Leaf l] : (e= declAssign | ( expression STMTEND ) | returnstmt );
    public final Leaf stmt() throws RecognitionException {
        Leaf l = null;

        DeclAssign e = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:180:2: (e= declAssign | ( expression STMTEND ) | returnstmt )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
                {
                alt12=1;
                }
                break;
            case WORD:
                {
                int LA12_2 = input.LA(2);

                if ( ((LA12_2>=PLUS && LA12_2<=MOD)||(LA12_2>=RSHIFT && LA12_2<=LSHIFT)||(LA12_2>=EQUAL && LA12_2<=LOGOR)||LA12_2==LARRAY||LA12_2==49||(LA12_2>=51 && LA12_2<=60)) ) {
                    alt12=2;
                }
                else if ( (LA12_2==DOT||LA12_2==WORD) ) {
                    alt12=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return l;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
                }
                break;
            case NOT:
            case LPAREN:
            case STRINGCONST_PRIVATE:
            case DOUBLECONST_PRIVATE:
            case INTCONST_PRIVATE:
            case 61:
            case 62:
                {
                alt12=2;
                }
                break;
            case 48:
                {
                alt12=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return l;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:180:4: e= declAssign
                    {
                    pushFollow(FOLLOW_declAssign_in_stmt664);
                    e=declAssign();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=e;
                    }

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:181:4: ( expression STMTEND )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:181:4: ( expression STMTEND )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:181:5: expression STMTEND
                    {
                    pushFollow(FOLLOW_expression_in_stmt672);
                    expression();

                    state._fsp--;
                    if (state.failed) return l;
                    match(input,STMTEND,FOLLOW_STMTEND_in_stmt674); if (state.failed) return l;

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:182:4: returnstmt
                    {
                    pushFollow(FOLLOW_returnstmt_in_stmt680);
                    returnstmt();

                    state._fsp--;
                    if (state.failed) return l;

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


    // $ANTLR start "returnstmt"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:184:1: returnstmt : 'return' ( expression )? STMTEND ;
    public final void returnstmt() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:185:2: ( 'return' ( expression )? STMTEND )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:185:4: 'return' ( expression )? STMTEND
            {
            match(input,48,FOLLOW_48_in_returnstmt690); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:185:13: ( expression )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NOT||LA13_0==LPAREN||(LA13_0>=WORD && LA13_0<=DOUBLECONST_PRIVATE)||LA13_0==INTCONST_PRIVATE||(LA13_0>=61 && LA13_0<=62)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:0:0: expression
                    {
                    pushFollow(FOLLOW_expression_in_returnstmt692);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            match(input,STMTEND,FOLLOW_STMTEND_in_returnstmt695); if (state.failed) return ;

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
    // $ANTLR end "returnstmt"


    // $ANTLR start "declAssign"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:187:1: declAssign returns [DeclAssign e = new DeclAssign()] : t= type n= WORD ( '=' ex= expression )? STMTEND ;
    public final DeclAssign declAssign() throws RecognitionException {
        DeclAssign e =  new DeclAssign();

        Token n=null;
        Type t = null;

        Expression ex = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:188:2: (t= type n= WORD ( '=' ex= expression )? STMTEND )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:188:4: t= type n= WORD ( '=' ex= expression )? STMTEND
            {
            pushFollow(FOLLOW_type_in_declAssign711);
            t=type();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e.type = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_declAssign717); if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e.name = n.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:188:56: ( '=' ex= expression )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==EQUAL) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:188:57: '=' ex= expression
                    {
                    match(input,EQUAL,FOLLOW_EQUAL_in_declAssign722); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_declAssign726);
                    ex=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e.value=ex;
                    }

                    }
                    break;

            }

            match(input,STMTEND,FOLLOW_STMTEND_in_declAssign732); if (state.failed) return e;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:190:1: pkgname returns [String s = null] : (c= WORD ( '.' t= WORD )* ) ;
    public final String pkgname() throws RecognitionException {
        String s =  null;

        Token c=null;
        Token t=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:191:2: ( (c= WORD ( '.' t= WORD )* ) )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:191:4: (c= WORD ( '.' t= WORD )* )
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:191:4: (c= WORD ( '.' t= WORD )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:191:5: c= WORD ( '.' t= WORD )*
            {
            c=(Token)match(input,WORD,FOLLOW_WORD_in_pkgname748); if (state.failed) return s;
            if ( state.backtracking==0 ) {
              s = c.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:191:31: ( '.' t= WORD )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==DOT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:191:32: '.' t= WORD
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_pkgname753); if (state.failed) return s;
            	    t=(Token)match(input,WORD,FOLLOW_WORD_in_pkgname757); if (state.failed) return s;
            	    if ( state.backtracking==0 ) {
            	      s += "." + t.getText();
            	    }

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:193:1: reference returns [Reference r = null] : ref= WORD ( LARRAY e= expression RARRAY )* ;
    public final Reference reference() throws RecognitionException {
        Reference r =  null;

        Token ref=null;
        Expression e = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:194:2: (ref= WORD ( LARRAY e= expression RARRAY )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:194:4: ref= WORD ( LARRAY e= expression RARRAY )*
            {
            ref=(Token)match(input,WORD,FOLLOW_WORD_in_reference777); if (state.failed) return r;
            if ( state.backtracking==0 ) {
              r = new VariableReference(ref.getText());
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:195:2: ( LARRAY e= expression RARRAY )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==LARRAY) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:195:3: LARRAY e= expression RARRAY
            	    {
            	    match(input,LARRAY,FOLLOW_LARRAY_in_reference783); if (state.failed) return r;
            	    pushFollow(FOLLOW_expression_in_reference787);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      r = new ArrayReference(r, e);
            	    }
            	    match(input,RARRAY,FOLLOW_RARRAY_in_reference791); if (state.failed) return r;

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:197:1: constant returns [Constant c = null] : ( (i= intconst ) | (d= doubleconst ) | (b= boolconst ) | (s= stringconst ) );
    public final Constant constant() throws RecognitionException {
        Constant c =  null;

        IntConstant i = null;

        DoubleConstant d = null;

        BooleanConstant b = null;

        StringConstant s = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:2: ( (i= intconst ) | (d= doubleconst ) | (b= boolconst ) | (s= stringconst ) )
            int alt17=4;
            switch ( input.LA(1) ) {
            case INTCONST_PRIVATE:
                {
                alt17=1;
                }
                break;
            case DOUBLECONST_PRIVATE:
                {
                alt17=2;
                }
                break;
            case 61:
            case 62:
                {
                alt17=3;
                }
                break;
            case STRINGCONST_PRIVATE:
                {
                alt17=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return c;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:4: (i= intconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:4: (i= intconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:5: i= intconst
                    {
                    pushFollow(FOLLOW_intconst_in_constant809);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:24: (d= doubleconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:24: (d= doubleconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:25: d= doubleconst
                    {
                    pushFollow(FOLLOW_doubleconst_in_constant817);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:47: (b= boolconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:47: (b= boolconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:48: b= boolconst
                    {
                    pushFollow(FOLLOW_boolconst_in_constant825);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:68: (s= stringconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:68: (s= stringconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:198:69: s= stringconst
                    {
                    pushFollow(FOLLOW_stringconst_in_constant833);
                    s=stringconst();

                    state._fsp--;
                    if (state.failed) return c;
                    if ( state.backtracking==0 ) {
                      c=s;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:202:1: primitive returns [Expression e = null] : (c= constant | r= reference | ( LPAREN x= expression RPAREN ) );
    public final Expression primitive() throws RecognitionException {
        Expression e =  null;

        Constant c = null;

        Reference r = null;

        Expression x = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:2: (c= constant | r= reference | ( LPAREN x= expression RPAREN ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case STRINGCONST_PRIVATE:
            case DOUBLECONST_PRIVATE:
            case INTCONST_PRIVATE:
            case 61:
            case 62:
                {
                alt18=1;
                }
                break;
            case WORD:
                {
                alt18=2;
                }
                break;
            case LPAREN:
                {
                alt18=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:4: c= constant
                    {
                    pushFollow(FOLLOW_constant_in_primitive853);
                    c=constant();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=c;
                    }

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:23: r= reference
                    {
                    pushFollow(FOLLOW_reference_in_primitive860);
                    r=reference();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=r;
                    }

                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:44: ( LPAREN x= expression RPAREN )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:44: ( LPAREN x= expression RPAREN )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:45: LPAREN x= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primitive867); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_primitive871);
                    x=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=x;
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primitive875); if (state.failed) return e;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:205:1: notcastexpr returns [Expression e = null] : ( (p= primitive ) | ( NOT p= notcastexpr ) | ( LPAREN t= type RPAREN p= notcastexpr ) );
    public final Expression notcastexpr() throws RecognitionException {
        Expression e =  null;

        Expression p = null;

        Type t = null;



        TypeCast cast = null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:209:2: ( (p= primitive ) | ( NOT p= notcastexpr ) | ( LPAREN t= type RPAREN p= notcastexpr ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case WORD:
            case STRINGCONST_PRIVATE:
            case DOUBLECONST_PRIVATE:
            case INTCONST_PRIVATE:
            case 61:
            case 62:
                {
                alt19=1;
                }
                break;
            case LPAREN:
                {
                switch ( input.LA(2) ) {
                case NOT:
                case LPAREN:
                case STRINGCONST_PRIVATE:
                case DOUBLECONST_PRIVATE:
                case INTCONST_PRIVATE:
                case 61:
                case 62:
                    {
                    alt19=1;
                    }
                    break;
                case WORD:
                    {
                    switch ( input.LA(3) ) {
                    case PLUS:
                    case MINUS:
                    case MULT:
                    case DIV:
                    case MOD:
                    case RSHIFT:
                    case LSHIFT:
                    case EQUAL:
                    case LESS:
                    case MORE:
                    case LESSEQ:
                    case MOREEQ:
                    case EQUALS:
                    case NEQUAL:
                    case BITWISEAND:
                    case BITWISEOR:
                    case BITWISEXOR:
                    case LOGAND:
                    case LOGOR:
                    case LARRAY:
                    case 49:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                        {
                        alt19=1;
                        }
                        break;
                    case RPAREN:
                        {
                        int LA19_6 = input.LA(4);

                        if ( (LA19_6==NOT||LA19_6==LPAREN||(LA19_6>=WORD && LA19_6<=DOUBLECONST_PRIVATE)||LA19_6==INTCONST_PRIVATE||(LA19_6>=61 && LA19_6<=62)) ) {
                            alt19=3;
                        }
                        else if ( (LA19_6==EOF||(LA19_6>=PLUS && LA19_6<=MOD)||(LA19_6>=RSHIFT && LA19_6<=LSHIFT)||(LA19_6>=EQUAL && LA19_6<=LOGOR)||LA19_6==RPAREN||LA19_6==RARRAY||(LA19_6>=49 && LA19_6<=60)) ) {
                            alt19=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return e;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 6, input);

                            throw nvae;
                        }
                        }
                        break;
                    case DOT:
                        {
                        alt19=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return e;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 4, input);

                        throw nvae;
                    }

                    }
                    break;
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                    {
                    alt19=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return e;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 2, input);

                    throw nvae;
                }

                }
                break;
            case NOT:
                {
                alt19=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:209:4: (p= primitive )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:209:4: (p= primitive )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:209:5: p= primitive
                    {
                    pushFollow(FOLLOW_primitive_in_notcastexpr897);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:210:5: ( NOT p= notcastexpr )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:210:5: ( NOT p= notcastexpr )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:210:6: NOT p= notcastexpr
                    {
                    match(input,NOT,FOLLOW_NOT_in_notcastexpr907); if (state.failed) return e;
                    pushFollow(FOLLOW_notcastexpr_in_notcastexpr911);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:211:5: ( LPAREN t= type RPAREN p= notcastexpr )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:211:5: ( LPAREN t= type RPAREN p= notcastexpr )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:211:6: LPAREN t= type RPAREN p= notcastexpr
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_notcastexpr921); if (state.failed) return e;
                    pushFollow(FOLLOW_type_in_notcastexpr925);
                    t=type();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,RPAREN,FOLLOW_RPAREN_in_notcastexpr927); if (state.failed) return e;
                    pushFollow(FOLLOW_notcastexpr_in_notcastexpr931);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:213:1: multop returns [Expression e = null] : t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )* ;
    public final Expression multop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:214:2: (t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:214:4: t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )*
            {
            pushFollow(FOLLOW_notcastexpr_in_multop951);
            t=notcastexpr();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:214:25: ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=MULT && LA21_0<=MOD)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:2: ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:2: ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr )
            	    int alt20=3;
            	    switch ( input.LA(1) ) {
            	    case MULT:
            	        {
            	        alt20=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt20=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt20=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt20) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:3: MULT q= notcastexpr
            	            {
            	            match(input,MULT,FOLLOW_MULT_in_multop959); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_multop963);
            	            q=notcastexpr();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new MultiplyOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:216:3: DIV q= notcastexpr
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_multop969); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_multop973);
            	            q=notcastexpr();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new DivisionOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:217:3: MOD q= notcastexpr
            	            {
            	            match(input,MOD,FOLLOW_MOD_in_multop979); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_multop983);
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
            	    break loop21;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:220:1: sumop returns [Expression e = null] : t= multop ( ( PLUS q= multop | MINUS q= multop ) )* ;
    public final Expression sumop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:221:2: (t= multop ( ( PLUS q= multop | MINUS q= multop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:221:4: t= multop ( ( PLUS q= multop | MINUS q= multop ) )*
            {
            pushFollow(FOLLOW_multop_in_sumop1005);
            t=multop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:221:20: ( ( PLUS q= multop | MINUS q= multop ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=PLUS && LA23_0<=MINUS)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:222:2: ( PLUS q= multop | MINUS q= multop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:222:2: ( PLUS q= multop | MINUS q= multop )
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( (LA22_0==PLUS) ) {
            	        alt22=1;
            	    }
            	    else if ( (LA22_0==MINUS) ) {
            	        alt22=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:222:3: PLUS q= multop
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_sumop1013); if (state.failed) return e;
            	            pushFollow(FOLLOW_multop_in_sumop1017);
            	            q=multop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new SumOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:223:3: MINUS q= multop
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_sumop1023); if (state.failed) return e;
            	            pushFollow(FOLLOW_multop_in_sumop1027);
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
            	    break loop23;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:226:1: shiftop returns [Expression e = null] : t= sumop ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )* ;
    public final Expression shiftop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:2: (t= sumop ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:4: t= sumop ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )*
            {
            pushFollow(FOLLOW_sumop_in_shiftop1049);
            t=sumop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:19: ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RSHIFT && LA25_0<=LSHIFT)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:228:2: ( RSHIFT q= sumop | LSHIFT q= sumop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:228:2: ( RSHIFT q= sumop | LSHIFT q= sumop )
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==RSHIFT) ) {
            	        alt24=1;
            	    }
            	    else if ( (LA24_0==LSHIFT) ) {
            	        alt24=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:228:3: RSHIFT q= sumop
            	            {
            	            match(input,RSHIFT,FOLLOW_RSHIFT_in_shiftop1057); if (state.failed) return e;
            	            pushFollow(FOLLOW_sumop_in_shiftop1061);
            	            q=sumop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new RShiftOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:229:3: LSHIFT q= sumop
            	            {
            	            match(input,LSHIFT,FOLLOW_LSHIFT_in_shiftop1067); if (state.failed) return e;
            	            pushFollow(FOLLOW_sumop_in_shiftop1071);
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
            	    break loop25;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:232:1: compop returns [Expression e = null] : t= shiftop ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )* ;
    public final Expression compop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:233:2: (t= shiftop ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:233:4: t= shiftop ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )*
            {
            pushFollow(FOLLOW_shiftop_in_compop1094);
            t=shiftop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:233:21: ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=LESS && LA27_0<=MOREEQ)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:234:2: ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:234:2: ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop )
            	    int alt26=4;
            	    switch ( input.LA(1) ) {
            	    case LESS:
            	        {
            	        alt26=1;
            	        }
            	        break;
            	    case MORE:
            	        {
            	        alt26=2;
            	        }
            	        break;
            	    case LESSEQ:
            	        {
            	        alt26=3;
            	        }
            	        break;
            	    case MOREEQ:
            	        {
            	        alt26=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 26, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt26) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:234:3: LESS q= shiftop
            	            {
            	            match(input,LESS,FOLLOW_LESS_in_compop1102); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1106);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new LessOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:235:3: MORE q= shiftop
            	            {
            	            match(input,MORE,FOLLOW_MORE_in_compop1112); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1116);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new MoreOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:236:3: LESSEQ q= shiftop
            	            {
            	            match(input,LESSEQ,FOLLOW_LESSEQ_in_compop1122); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1126);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new LessEqualOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:237:3: MOREEQ q= shiftop
            	            {
            	            match(input,MOREEQ,FOLLOW_MOREEQ_in_compop1132); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1136);
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
            	    break loop27;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:240:1: comp2op returns [Expression e = null] : t= compop ( ( EQUALS q= compop | NEQUAL q= compop ) )* ;
    public final Expression comp2op() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:241:2: (t= compop ( ( EQUALS q= compop | NEQUAL q= compop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:241:4: t= compop ( ( EQUALS q= compop | NEQUAL q= compop ) )*
            {
            pushFollow(FOLLOW_compop_in_comp2op1159);
            t=compop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:241:20: ( ( EQUALS q= compop | NEQUAL q= compop ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=EQUALS && LA29_0<=NEQUAL)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:242:2: ( EQUALS q= compop | NEQUAL q= compop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:242:2: ( EQUALS q= compop | NEQUAL q= compop )
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==EQUALS) ) {
            	        alt28=1;
            	    }
            	    else if ( (LA28_0==NEQUAL) ) {
            	        alt28=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 28, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:242:3: EQUALS q= compop
            	            {
            	            match(input,EQUALS,FOLLOW_EQUALS_in_comp2op1167); if (state.failed) return e;
            	            pushFollow(FOLLOW_compop_in_comp2op1171);
            	            q=compop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new EqualsOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:243:3: NEQUAL q= compop
            	            {
            	            match(input,NEQUAL,FOLLOW_NEQUAL_in_comp2op1177); if (state.failed) return e;
            	            pushFollow(FOLLOW_compop_in_comp2op1181);
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
            	    break loop29;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:246:1: bitwiseand returns [Expression e = null] : t= comp2op ( ( BITWISEAND q= comp2op ) )* ;
    public final Expression bitwiseand() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:247:2: (t= comp2op ( ( BITWISEAND q= comp2op ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:247:4: t= comp2op ( ( BITWISEAND q= comp2op ) )*
            {
            pushFollow(FOLLOW_comp2op_in_bitwiseand1203);
            t=comp2op();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:247:21: ( ( BITWISEAND q= comp2op ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==BITWISEAND) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:248:2: ( BITWISEAND q= comp2op )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:248:2: ( BITWISEAND q= comp2op )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:248:3: BITWISEAND q= comp2op
            	    {
            	    match(input,BITWISEAND,FOLLOW_BITWISEAND_in_bitwiseand1211); if (state.failed) return e;
            	    pushFollow(FOLLOW_comp2op_in_bitwiseand1215);
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
    // $ANTLR end "bitwiseand"


    // $ANTLR start "bitwiseor"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:251:1: bitwiseor returns [Expression e = null] : t= bitwiseand ( ( BITWISEOR q= bitwiseand ) )* ;
    public final Expression bitwiseor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:252:2: (t= bitwiseand ( ( BITWISEOR q= bitwiseand ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:252:4: t= bitwiseand ( ( BITWISEOR q= bitwiseand ) )*
            {
            pushFollow(FOLLOW_bitwiseand_in_bitwiseor1237);
            t=bitwiseand();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:252:24: ( ( BITWISEOR q= bitwiseand ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==BITWISEOR) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:253:2: ( BITWISEOR q= bitwiseand )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:253:2: ( BITWISEOR q= bitwiseand )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:253:3: BITWISEOR q= bitwiseand
            	    {
            	    match(input,BITWISEOR,FOLLOW_BITWISEOR_in_bitwiseor1245); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwiseand_in_bitwiseor1249);
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
            	    break loop31;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:256:1: bitwisexor returns [Expression e = null] : t= bitwiseor ( ( BITWISEXOR q= bitwiseor ) )* ;
    public final Expression bitwisexor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:257:2: (t= bitwiseor ( ( BITWISEXOR q= bitwiseor ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:257:4: t= bitwiseor ( ( BITWISEXOR q= bitwiseor ) )*
            {
            pushFollow(FOLLOW_bitwiseor_in_bitwisexor1272);
            t=bitwiseor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:257:23: ( ( BITWISEXOR q= bitwiseor ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==BITWISEXOR) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:258:2: ( BITWISEXOR q= bitwiseor )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:258:2: ( BITWISEXOR q= bitwiseor )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:258:3: BITWISEXOR q= bitwiseor
            	    {
            	    match(input,BITWISEXOR,FOLLOW_BITWISEXOR_in_bitwisexor1280); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwiseor_in_bitwisexor1284);
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
    // $ANTLR end "bitwisexor"


    // $ANTLR start "logicaland"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:261:1: logicaland returns [Expression e = null] : t= bitwisexor ( ( LOGAND q= bitwisexor ) )* ;
    public final Expression logicaland() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:262:2: (t= bitwisexor ( ( LOGAND q= bitwisexor ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:262:4: t= bitwisexor ( ( LOGAND q= bitwisexor ) )*
            {
            pushFollow(FOLLOW_bitwisexor_in_logicaland1306);
            t=bitwisexor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:262:24: ( ( LOGAND q= bitwisexor ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==LOGAND) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:263:2: ( LOGAND q= bitwisexor )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:263:2: ( LOGAND q= bitwisexor )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:263:3: LOGAND q= bitwisexor
            	    {
            	    match(input,LOGAND,FOLLOW_LOGAND_in_logicaland1314); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwisexor_in_logicaland1318);
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
            	    break loop33;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:266:1: logicalor returns [Expression e = null] : t= logicaland ( ( LOGOR q= logicaland ) )* ;
    public final Expression logicalor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:267:2: (t= logicaland ( ( LOGOR q= logicaland ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:267:4: t= logicaland ( ( LOGOR q= logicaland ) )*
            {
            pushFollow(FOLLOW_logicaland_in_logicalor1340);
            t=logicaland();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:267:24: ( ( LOGOR q= logicaland ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==LOGOR) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:268:2: ( LOGOR q= logicaland )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:268:2: ( LOGOR q= logicaland )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:268:3: LOGOR q= logicaland
            	    {
            	    match(input,LOGOR,FOLLOW_LOGOR_in_logicalor1348); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicaland_in_logicalor1352);
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
    // $ANTLR end "logicalor"


    // $ANTLR start "ternary"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:271:1: ternary returns [Expression e = null] : t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )* ;
    public final Expression ternary() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression p = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:272:2: (t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:272:4: t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )*
            {
            pushFollow(FOLLOW_logicalor_in_ternary1375);
            t=logicalor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:272:23: ( ( '?' p= logicalor ':' q= logicalor ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==49) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:273:2: ( '?' p= logicalor ':' q= logicalor )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:273:2: ( '?' p= logicalor ':' q= logicalor )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:273:3: '?' p= logicalor ':' q= logicalor
            	    {
            	    match(input,49,FOLLOW_49_in_ternary1383); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicalor_in_ternary1387);
            	    p=logicalor();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    match(input,50,FOLLOW_50_in_ternary1389); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicalor_in_ternary1393);
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
            	    break loop35;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:276:1: expression returns [Expression e = null] : ( (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) | (t= ternary ) );
    public final Expression expression() throws RecognitionException {
        Expression e =  null;

        Expression r = null;

        Expression q = null;

        Expression t = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:277:2: ( (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) | (t= ternary ) )
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:277:4: (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:277:4: (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:277:5: r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )*
                    {
                    pushFollow(FOLLOW_ternary_in_expression1417);
                    r=ternary();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=r;
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:277:22: ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )*
                    loop36:
                    do {
                        int alt36=12;
                        switch ( input.LA(1) ) {
                        case EQUAL:
                            {
                            alt36=1;
                            }
                            break;
                        case 51:
                            {
                            alt36=2;
                            }
                            break;
                        case 52:
                            {
                            alt36=3;
                            }
                            break;
                        case 53:
                            {
                            alt36=4;
                            }
                            break;
                        case 54:
                            {
                            alt36=5;
                            }
                            break;
                        case 55:
                            {
                            alt36=6;
                            }
                            break;
                        case 56:
                            {
                            alt36=7;
                            }
                            break;
                        case 57:
                            {
                            alt36=8;
                            }
                            break;
                        case 58:
                            {
                            alt36=9;
                            }
                            break;
                        case 59:
                            {
                            alt36=10;
                            }
                            break;
                        case 60:
                            {
                            alt36=11;
                            }
                            break;

                        }

                        switch (alt36) {
                    	case 1 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:278:2: ( EQUAL q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:278:2: ( EQUAL q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:278:3: EQUAL q= ternary
                    	    {
                    	    match(input,EQUAL,FOLLOW_EQUAL_in_expression1425); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1429);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:279:3: ( '+=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:279:3: ( '+=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:279:4: '+=' q= ternary
                    	    {
                    	    match(input,51,FOLLOW_51_in_expression1437); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1441);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:280:3: ( '-=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:280:3: ( '-=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:280:4: '-=' q= ternary
                    	    {
                    	    match(input,52,FOLLOW_52_in_expression1449); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1453);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:281:3: ( '*=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:281:3: ( '*=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:281:4: '*=' q= ternary
                    	    {
                    	    match(input,53,FOLLOW_53_in_expression1461); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1465);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:282:3: ( '/=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:282:3: ( '/=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:282:4: '/=' q= ternary
                    	    {
                    	    match(input,54,FOLLOW_54_in_expression1473); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1477);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:3: ( '%=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:3: ( '%=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:4: '%=' q= ternary
                    	    {
                    	    match(input,55,FOLLOW_55_in_expression1485); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1489);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:284:3: ( '&=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:284:3: ( '&=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:284:4: '&=' q= ternary
                    	    {
                    	    match(input,56,FOLLOW_56_in_expression1497); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1501);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:3: ( '|=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:3: ( '|=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:4: '|=' q= ternary
                    	    {
                    	    match(input,57,FOLLOW_57_in_expression1509); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1513);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:3: ( '^=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:3: ( '^=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:4: '^=' q= ternary
                    	    {
                    	    match(input,58,FOLLOW_58_in_expression1521); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1525);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:3: ( '<<=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:3: ( '<<=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:4: '<<=' q= ternary
                    	    {
                    	    match(input,59,FOLLOW_59_in_expression1533); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1537);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:288:3: ( '>>=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:288:3: ( '>>=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:288:4: '>>=' q= ternary
                    	    {
                    	    match(input,60,FOLLOW_60_in_expression1545); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1549);
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
                    	    break loop36;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:289:8: (t= ternary )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:289:8: (t= ternary )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:289:9: t= ternary
                    {
                    pushFollow(FOLLOW_ternary_in_expression1564);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:293:1: stringconst returns [StringConstant s = null] : v= STRINGCONST_PRIVATE ;
    public final StringConstant stringconst() throws RecognitionException {
        StringConstant s =  null;

        Token v=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:294:2: (v= STRINGCONST_PRIVATE )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:294:4: v= STRINGCONST_PRIVATE
            {
            v=(Token)match(input,STRINGCONST_PRIVATE,FOLLOW_STRINGCONST_PRIVATE_in_stringconst1584); if (state.failed) return s;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:302:1: doubleconst returns [DoubleConstant d = null] : v= DOUBLECONST_PRIVATE ;
    public final DoubleConstant doubleconst() throws RecognitionException {
        DoubleConstant d =  null;

        Token v=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:303:2: (v= DOUBLECONST_PRIVATE )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:303:4: v= DOUBLECONST_PRIVATE
            {
            v=(Token)match(input,DOUBLECONST_PRIVATE,FOLLOW_DOUBLECONST_PRIVATE_in_doubleconst1640); if (state.failed) return d;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:308:1: intconst returns [IntConstant i = null] : v= INTCONST_PRIVATE ;
    public final IntConstant intconst() throws RecognitionException {
        IntConstant i =  null;

        Token v=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:309:2: (v= INTCONST_PRIVATE )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:309:4: v= INTCONST_PRIVATE
            {
            v=(Token)match(input,INTCONST_PRIVATE,FOLLOW_INTCONST_PRIVATE_in_intconst1678); if (state.failed) return i;
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


    // $ANTLR start "boolconst"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:317:1: boolconst returns [BooleanConstant b = new BooleanConstant(false)] : ( ( 'true' ) | 'false' );
    public final BooleanConstant boolconst() throws RecognitionException {
        BooleanConstant b =  new BooleanConstant(false);

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:318:2: ( ( 'true' ) | 'false' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==61) ) {
                alt38=1;
            }
            else if ( (LA38_0==62) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return b;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:318:4: ( 'true' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:318:4: ( 'true' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:318:5: 'true'
                    {
                    match(input,61,FOLLOW_61_in_boolconst1753); if (state.failed) return b;
                    if ( state.backtracking==0 ) {
                      b.value = true;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:318:31: 'false'
                    {
                    match(input,62,FOLLOW_62_in_boolconst1758); if (state.failed) return b;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:320:1: type returns [Type type = new Type()] : ( (i= nativetype ) | (t= clstype ) );
    public final Type type() throws RecognitionException {
        Type type =  new Type();

        Type i = null;

        Type t = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:2: ( (i= nativetype ) | (t= clstype ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=63 && LA39_0<=72)) ) {
                alt39=1;
            }
            else if ( (LA39_0==WORD) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:4: (i= nativetype )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:4: (i= nativetype )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:5: i= nativetype
                    {
                    pushFollow(FOLLOW_nativetype_in_type1774);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:29: (t= clstype )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:29: (t= clstype )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:321:30: t= clstype
                    {
                    pushFollow(FOLLOW_clstype_in_type1782);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:323:1: clstype returns [Type type = new Type()] : (c= WORD ( '.' t= WORD )* ) ;
    public final Type clstype() throws RecognitionException {
        Type type =  new Type();

        Token c=null;
        Token t=null;


        	type.typeCategory = TypeCategory.CLASS;
        	String s = "";

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:328:2: ( (c= WORD ( '.' t= WORD )* ) )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:328:4: (c= WORD ( '.' t= WORD )* )
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:328:4: (c= WORD ( '.' t= WORD )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:328:5: c= WORD ( '.' t= WORD )*
            {
            c=(Token)match(input,WORD,FOLLOW_WORD_in_clstype1805); if (state.failed) return type;
            if ( state.backtracking==0 ) {
              s += c.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:328:32: ( '.' t= WORD )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==DOT) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:328:33: '.' t= WORD
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_clstype1810); if (state.failed) return type;
            	    t=(Token)match(input,WORD,FOLLOW_WORD_in_clstype1814); if (state.failed) return type;
            	    if ( state.backtracking==0 ) {
            	      s += "." + t.getText();
            	    }

            	    }
            	    break;

            	default :
            	    break loop40;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:330:1: nativetype returns [Type type = new Type()] : ( ( 'int' ) | ( 'uint' ) | ( 'float' ) | ( 'ufloat' ) | ( 'double' ) | ( 'udouble' ) | ( 'char' ) | ( 'uchar' ) | ( 'bool' ) | ( 'string' ) );
    public final Type nativetype() throws RecognitionException {
        Type type =  new Type();


        	type.typeCategory = TypeCategory.NATIVE;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:333:3: ( ( 'int' ) | ( 'uint' ) | ( 'float' ) | ( 'ufloat' ) | ( 'double' ) | ( 'udouble' ) | ( 'char' ) | ( 'uchar' ) | ( 'bool' ) | ( 'string' ) )
            int alt41=10;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt41=1;
                }
                break;
            case 64:
                {
                alt41=2;
                }
                break;
            case 65:
                {
                alt41=3;
                }
                break;
            case 66:
                {
                alt41=4;
                }
                break;
            case 67:
                {
                alt41=5;
                }
                break;
            case 68:
                {
                alt41=6;
                }
                break;
            case 69:
                {
                alt41=7;
                }
                break;
            case 70:
                {
                alt41=8;
                }
                break;
            case 71:
                {
                alt41=9;
                }
                break;
            case 72:
                {
                alt41=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:333:5: ( 'int' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:333:5: ( 'int' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:333:6: 'int'
                    {
                    match(input,63,FOLLOW_63_in_nativetype1838); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.INT;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:334:2: ( 'uint' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:334:2: ( 'uint' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:334:3: 'uint'
                    {
                    match(input,64,FOLLOW_64_in_nativetype1846); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UINT;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:335:2: ( 'float' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:335:2: ( 'float' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:335:3: 'float'
                    {
                    match(input,65,FOLLOW_65_in_nativetype1854); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.FLOAT;
                    }

                    }


                    }
                    break;
                case 4 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:336:2: ( 'ufloat' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:336:2: ( 'ufloat' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:336:3: 'ufloat'
                    {
                    match(input,66,FOLLOW_66_in_nativetype1862); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UFLOAT;
                    }

                    }


                    }
                    break;
                case 5 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:337:2: ( 'double' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:337:2: ( 'double' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:337:3: 'double'
                    {
                    match(input,67,FOLLOW_67_in_nativetype1870); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.DOUBLE;
                    }

                    }


                    }
                    break;
                case 6 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:338:2: ( 'udouble' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:338:2: ( 'udouble' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:338:3: 'udouble'
                    {
                    match(input,68,FOLLOW_68_in_nativetype1878); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UDOUBLE;
                    }

                    }


                    }
                    break;
                case 7 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:339:2: ( 'char' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:339:2: ( 'char' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:339:3: 'char'
                    {
                    match(input,69,FOLLOW_69_in_nativetype1886); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.CHAR;
                    }

                    }


                    }
                    break;
                case 8 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:340:2: ( 'uchar' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:340:2: ( 'uchar' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:340:3: 'uchar'
                    {
                    match(input,70,FOLLOW_70_in_nativetype1894); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UCHAR;
                    }

                    }


                    }
                    break;
                case 9 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:341:2: ( 'bool' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:341:2: ( 'bool' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:341:3: 'bool'
                    {
                    match(input,71,FOLLOW_71_in_nativetype1902); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.BOOL;
                    }

                    }


                    }
                    break;
                case 10 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:342:2: ( 'string' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:342:2: ( 'string' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:342:3: 'string'
                    {
                    match(input,72,FOLLOW_72_in_nativetype1910); if (state.failed) return type;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:344:1: accesscontrolkeyword returns [AccessControlKeyword a = AccessControlKeyword.PUBLIC] : ( 'public' | ( 'private' ) | ( 'protected' ) );
    public final AccessControlKeyword accesscontrolkeyword() throws RecognitionException {
        AccessControlKeyword a =  AccessControlKeyword.PUBLIC;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:345:2: ( 'public' | ( 'private' ) | ( 'protected' ) )
            int alt42=3;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt42=1;
                }
                break;
            case 74:
                {
                alt42=2;
                }
                break;
            case 75:
                {
                alt42=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return a;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:345:4: 'public'
                    {
                    match(input,73,FOLLOW_73_in_accesscontrolkeyword1927); if (state.failed) return a;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:345:15: ( 'private' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:345:15: ( 'private' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:345:16: 'private'
                    {
                    match(input,74,FOLLOW_74_in_accesscontrolkeyword1932); if (state.failed) return a;
                    if ( state.backtracking==0 ) {
                      a = AccessControlKeyword.PRIVATE;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:345:65: ( 'protected' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:345:65: ( 'protected' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:345:66: 'protected'
                    {
                    match(input,75,FOLLOW_75_in_accesscontrolkeyword1940); if (state.failed) return a;
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

    // $ANTLR start synpred57_PineDL
    public final void synpred57_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:277:4: ( ( ternary ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )* ) )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:277:4: ( ternary ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )* )
        {
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:277:4: ( ternary ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )* )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:277:5: ternary ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )*
        {
        pushFollow(FOLLOW_ternary_in_synpred57_PineDL1417);
        ternary();

        state._fsp--;
        if (state.failed) return ;
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:277:22: ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )*
        loop49:
        do {
            int alt49=12;
            switch ( input.LA(1) ) {
            case EQUAL:
                {
                alt49=1;
                }
                break;
            case 51:
                {
                alt49=2;
                }
                break;
            case 52:
                {
                alt49=3;
                }
                break;
            case 53:
                {
                alt49=4;
                }
                break;
            case 54:
                {
                alt49=5;
                }
                break;
            case 55:
                {
                alt49=6;
                }
                break;
            case 56:
                {
                alt49=7;
                }
                break;
            case 57:
                {
                alt49=8;
                }
                break;
            case 58:
                {
                alt49=9;
                }
                break;
            case 59:
                {
                alt49=10;
                }
                break;
            case 60:
                {
                alt49=11;
                }
                break;

            }

            switch (alt49) {
        	case 1 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:278:2: ( EQUAL ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:278:2: ( EQUAL ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:278:3: EQUAL ternary
        	    {
        	    match(input,EQUAL,FOLLOW_EQUAL_in_synpred57_PineDL1425); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred57_PineDL1429);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 2 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:279:3: ( '+=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:279:3: ( '+=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:279:4: '+=' ternary
        	    {
        	    match(input,51,FOLLOW_51_in_synpred57_PineDL1437); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred57_PineDL1441);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 3 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:280:3: ( '-=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:280:3: ( '-=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:280:4: '-=' ternary
        	    {
        	    match(input,52,FOLLOW_52_in_synpred57_PineDL1449); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred57_PineDL1453);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 4 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:281:3: ( '*=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:281:3: ( '*=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:281:4: '*=' ternary
        	    {
        	    match(input,53,FOLLOW_53_in_synpred57_PineDL1461); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred57_PineDL1465);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 5 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:282:3: ( '/=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:282:3: ( '/=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:282:4: '/=' ternary
        	    {
        	    match(input,54,FOLLOW_54_in_synpred57_PineDL1473); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred57_PineDL1477);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 6 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:3: ( '%=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:3: ( '%=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:4: '%=' ternary
        	    {
        	    match(input,55,FOLLOW_55_in_synpred57_PineDL1485); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred57_PineDL1489);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 7 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:284:3: ( '&=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:284:3: ( '&=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:284:4: '&=' ternary
        	    {
        	    match(input,56,FOLLOW_56_in_synpred57_PineDL1497); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred57_PineDL1501);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 8 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:3: ( '|=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:3: ( '|=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:4: '|=' ternary
        	    {
        	    match(input,57,FOLLOW_57_in_synpred57_PineDL1509); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred57_PineDL1513);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 9 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:3: ( '^=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:3: ( '^=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:4: '^=' ternary
        	    {
        	    match(input,58,FOLLOW_58_in_synpred57_PineDL1521); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred57_PineDL1525);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 10 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:3: ( '<<=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:3: ( '<<=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:4: '<<=' ternary
        	    {
        	    match(input,59,FOLLOW_59_in_synpred57_PineDL1533); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred57_PineDL1537);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 11 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:288:3: ( '>>=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:288:3: ( '>>=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:288:4: '>>=' ternary
        	    {
        	    match(input,60,FOLLOW_60_in_synpred57_PineDL1545); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred57_PineDL1549);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop49;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred57_PineDL

    // Delegated rules

    public final boolean synpred57_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_PineDL_fragment(); // can never throw exception
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
    protected DFA37 dfa37 = new DFA37(this);
    static final String DFA3_eotS =
        "\27\uffff";
    static final String DFA3_eofS =
        "\27\uffff";
    static final String DFA3_minS =
        "\1\33\1\uffff\3\40\1\uffff\13\40\1\11\1\24\1\40\2\uffff\1\11";
    static final String DFA3_maxS =
        "\1\113\1\uffff\3\110\1\uffff\1\110\13\40\1\34\1\40\2\uffff\1\40";
    static final String DFA3_acceptS =
        "\1\uffff\1\4\3\uffff\1\3\16\uffff\1\1\1\2\1\uffff";
    static final String DFA3_specialS =
        "\27\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1\55\uffff\1\2\1\3\1\4",
            "",
            "\1\21\14\uffff\1\6\1\5\20\uffff\1\7\1\10\1\11\1\12\1\13\1\14"+
            "\1\15\1\16\1\17\1\20",
            "\1\21\14\uffff\1\6\1\5\20\uffff\1\7\1\10\1\11\1\12\1\13\1\14"+
            "\1\15\1\16\1\17\1\20",
            "\1\21\14\uffff\1\6\1\5\20\uffff\1\7\1\10\1\11\1\12\1\13\1\14"+
            "\1\15\1\16\1\17\1\20",
            "",
            "\1\21\36\uffff\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
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
            "\1\24\7\uffff\1\25",
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
    static final String DFA37_eotS =
        "\13\uffff";
    static final String DFA37_eofS =
        "\13\uffff";
    static final String DFA37_minS =
        "\1\14\10\0\2\uffff";
    static final String DFA37_maxS =
        "\1\76\10\0\2\uffff";
    static final String DFA37_acceptS =
        "\11\uffff\1\1\1\2";
    static final String DFA37_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\10\17\uffff\1\7\3\uffff\1\6\1\5\1\2\1\uffff\1\1\30\uffff"+
            "\1\3\1\4",
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

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "276:1: expression returns [Expression e = null] : ( (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) | (t= ternary ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_1 = input.LA(1);

                         
                        int index37_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index37_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA37_2 = input.LA(1);

                         
                        int index37_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index37_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA37_3 = input.LA(1);

                         
                        int index37_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index37_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA37_4 = input.LA(1);

                         
                        int index37_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index37_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA37_5 = input.LA(1);

                         
                        int index37_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index37_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA37_6 = input.LA(1);

                         
                        int index37_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index37_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA37_7 = input.LA(1);

                         
                        int index37_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index37_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA37_8 = input.LA(1);

                         
                        int index37_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index37_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
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
    public static final BitSet FOLLOW_BLKBEG_in_clsdecl357 = new BitSet(new long[]{0x0000000008000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_field_in_clsdecl364 = new BitSet(new long[]{0x0000000008000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_method_in_clsdecl373 = new BitSet(new long[]{0x0000000008000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_constructor_in_clsdecl379 = new BitSet(new long[]{0x0000000008000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_BLKEND_in_clsdecl387 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_STMTEND_in_clsdecl389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accesscontrolkeyword_in_field406 = new BitSet(new long[]{0x8000200100000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_45_in_field413 = new BitSet(new long[]{0x8000200100000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_type_in_field423 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_field431 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_field437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accesscontrolkeyword_in_method454 = new BitSet(new long[]{0x8000200100000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_45_in_method461 = new BitSet(new long[]{0x8000200100000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_type_in_method471 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_method479 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_method485 = new BitSet(new long[]{0x8000200120000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_argumentlist_in_method491 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_method497 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_block_in_method503 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_STMTEND_in_method509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accesscontrolkeyword_in_constructor527 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_constructor533 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_constructor540 = new BitSet(new long[]{0x8000200120000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_argumentlist_in_constructor546 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_constructor552 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_block_in_constructor558 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_STMTEND_in_constructor564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_argumentlist582 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_argumentlist587 = new BitSet(new long[]{0x8000200100000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_argument_in_argumentlist591 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_type_in_argument613 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_argument620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLKBEG_in_block636 = new BitSet(new long[]{0xE001201718001000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_stmt_in_block641 = new BitSet(new long[]{0xE001201718001000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_BLKEND_in_block647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declAssign_in_stmt664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_stmt672 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_stmt674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnstmt_in_stmt680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_returnstmt690 = new BitSet(new long[]{0x6000001710101000L});
    public static final BitSet FOLLOW_expression_in_returnstmt692 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_returnstmt695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_declAssign711 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_declAssign717 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_EQUAL_in_declAssign722 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_expression_in_declAssign726 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_declAssign732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_pkgname748 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_pkgname753 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_pkgname757 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_WORD_in_reference777 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_LARRAY_in_reference783 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_expression_in_reference787 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RARRAY_in_reference791 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_intconst_in_constant809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doubleconst_in_constant817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolconst_in_constant825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringconst_in_constant833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primitive853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_in_primitive860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primitive867 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_expression_in_primitive871 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_primitive875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitive_in_notcastexpr897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notcastexpr907 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_notcastexpr_in_notcastexpr911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_notcastexpr921 = new BitSet(new long[]{0x8000200100000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_type_in_notcastexpr925 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_notcastexpr927 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_notcastexpr_in_notcastexpr931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notcastexpr_in_multop951 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_MULT_in_multop959 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_notcastexpr_in_multop963 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_DIV_in_multop969 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_notcastexpr_in_multop973 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_MOD_in_multop979 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_notcastexpr_in_multop983 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_multop_in_sumop1005 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_PLUS_in_sumop1013 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_multop_in_sumop1017 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_MINUS_in_sumop1023 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_multop_in_sumop1027 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_sumop_in_shiftop1049 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_RSHIFT_in_shiftop1057 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_sumop_in_shiftop1061 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_LSHIFT_in_shiftop1067 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_sumop_in_shiftop1071 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_shiftop_in_compop1094 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LESS_in_compop1102 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_shiftop_in_compop1106 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_MORE_in_compop1112 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_shiftop_in_compop1116 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LESSEQ_in_compop1122 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_shiftop_in_compop1126 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_MOREEQ_in_compop1132 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_shiftop_in_compop1136 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_compop_in_comp2op1159 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_EQUALS_in_comp2op1167 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_compop_in_comp2op1171 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_NEQUAL_in_comp2op1177 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_compop_in_comp2op1181 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_comp2op_in_bitwiseand1203 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_BITWISEAND_in_bitwiseand1211 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_comp2op_in_bitwiseand1215 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_bitwiseand_in_bitwiseor1237 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_BITWISEOR_in_bitwiseor1245 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_bitwiseand_in_bitwiseor1249 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_bitwiseor_in_bitwisexor1272 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_BITWISEXOR_in_bitwisexor1280 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_bitwiseor_in_bitwisexor1284 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_bitwisexor_in_logicaland1306 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_LOGAND_in_logicaland1314 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_bitwisexor_in_logicaland1318 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_logicaland_in_logicalor1340 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LOGOR_in_logicalor1348 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_logicaland_in_logicalor1352 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_logicalor_in_ternary1375 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ternary1383 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_logicalor_in_ternary1387 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ternary1389 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_logicalor_in_ternary1393 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_ternary_in_expression1417 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_EQUAL_in_expression1425 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1429 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_51_in_expression1437 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1441 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_52_in_expression1449 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1453 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_53_in_expression1461 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1465 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_54_in_expression1473 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1477 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_55_in_expression1485 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1489 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_56_in_expression1497 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1501 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_57_in_expression1509 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1513 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_58_in_expression1521 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1525 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_59_in_expression1533 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1537 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_60_in_expression1545 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1549 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_ternary_in_expression1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGCONST_PRIVATE_in_stringconst1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLECONST_PRIVATE_in_doubleconst1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTCONST_PRIVATE_in_intconst1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_boolconst1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_boolconst1758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativetype_in_type1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_clstype_in_type1782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_clstype1805 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_clstype1810 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_clstype1814 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_63_in_nativetype1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_nativetype1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_nativetype1854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_nativetype1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_nativetype1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_nativetype1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_nativetype1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_nativetype1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_nativetype1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_nativetype1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_accesscontrolkeyword1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_accesscontrolkeyword1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_accesscontrolkeyword1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ternary_in_synpred57_PineDL1417 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_EQUAL_in_synpred57_PineDL1425 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred57_PineDL1429 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_51_in_synpred57_PineDL1437 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred57_PineDL1441 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_52_in_synpred57_PineDL1449 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred57_PineDL1453 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_53_in_synpred57_PineDL1461 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred57_PineDL1465 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_54_in_synpred57_PineDL1473 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred57_PineDL1477 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_55_in_synpred57_PineDL1485 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred57_PineDL1489 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_56_in_synpred57_PineDL1497 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred57_PineDL1501 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_57_in_synpred57_PineDL1509 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred57_PineDL1513 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_58_in_synpred57_PineDL1521 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred57_PineDL1525 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_59_in_synpred57_PineDL1533 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred57_PineDL1537 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_60_in_synpred57_PineDL1545 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred57_PineDL1549 = new BitSet(new long[]{0x1FF8000000002002L});

}