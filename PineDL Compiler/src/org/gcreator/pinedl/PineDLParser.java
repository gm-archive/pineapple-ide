// $ANTLR 3.1 /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g 2008-12-21 00:02:10

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:179:1: stmt returns [Leaf l = null] : ( (e= declAssign ) | (a= expression STMTEND ) | (b= returnstmt ) );
    public final Leaf stmt() throws RecognitionException {
        Leaf l =  null;

        DeclAssign e = null;

        Expression a = null;

        ReturnStatement b = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:180:2: ( (e= declAssign ) | (a= expression STMTEND ) | (b= returnstmt ) )
            int alt12=3;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:180:4: (e= declAssign )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:180:4: (e= declAssign )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:180:5: e= declAssign
                    {
                    pushFollow(FOLLOW_declAssign_in_stmt665);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:181:4: (a= expression STMTEND )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:181:4: (a= expression STMTEND )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:181:5: a= expression STMTEND
                    {
                    pushFollow(FOLLOW_expression_in_stmt676);
                    a=expression();

                    state._fsp--;
                    if (state.failed) return l;
                    match(input,STMTEND,FOLLOW_STMTEND_in_stmt678); if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=a;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:182:4: (b= returnstmt )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:182:4: (b= returnstmt )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:182:5: b= returnstmt
                    {
                    pushFollow(FOLLOW_returnstmt_in_stmt689);
                    b=returnstmt();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=b;
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
        return l;
    }
    // $ANTLR end "stmt"


    // $ANTLR start "returnstmt"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:184:1: returnstmt returns [ReturnStatement ret = new ReturnStatement()] : 'return' (r= expression )? STMTEND ;
    public final ReturnStatement returnstmt() throws RecognitionException {
        ReturnStatement ret =  new ReturnStatement();

        Expression r = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:185:2: ( 'return' (r= expression )? STMTEND )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:185:4: 'return' (r= expression )? STMTEND
            {
            match(input,48,FOLLOW_48_in_returnstmt706); if (state.failed) return ret;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:185:13: (r= expression )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NOT||LA13_0==LPAREN||(LA13_0>=WORD && LA13_0<=DOUBLECONST_PRIVATE)||LA13_0==INTCONST_PRIVATE||(LA13_0>=61 && LA13_0<=62)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:185:14: r= expression
                    {
                    pushFollow(FOLLOW_expression_in_returnstmt711);
                    r=expression();

                    state._fsp--;
                    if (state.failed) return ret;
                    if ( state.backtracking==0 ) {
                      ret.value = r;
                    }

                    }
                    break;

            }

            match(input,STMTEND,FOLLOW_STMTEND_in_returnstmt717); if (state.failed) return ret;

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
            pushFollow(FOLLOW_type_in_declAssign733);
            t=type();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e.type = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_declAssign739); if (state.failed) return e;
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
                    match(input,EQUAL,FOLLOW_EQUAL_in_declAssign744); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_declAssign748);
                    ex=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e.value=ex;
                    }

                    }
                    break;

            }

            match(input,STMTEND,FOLLOW_STMTEND_in_declAssign754); if (state.failed) return e;

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
            c=(Token)match(input,WORD,FOLLOW_WORD_in_pkgname770); if (state.failed) return s;
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
            	    match(input,DOT,FOLLOW_DOT_in_pkgname775); if (state.failed) return s;
            	    t=(Token)match(input,WORD,FOLLOW_WORD_in_pkgname779); if (state.failed) return s;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:193:1: reference returns [Reference r = null] : ref= WORD ( LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? ( LARRAY e= expression RARRAY )* ;
    public final Reference reference() throws RecognitionException {
        Reference r =  null;

        Token ref=null;
        Expression e = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:194:2: (ref= WORD ( LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? ( LARRAY e= expression RARRAY )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:194:4: ref= WORD ( LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? ( LARRAY e= expression RARRAY )*
            {
            ref=(Token)match(input,WORD,FOLLOW_WORD_in_reference799); if (state.failed) return r;
            if ( state.backtracking==0 ) {
              r = new VariableReference(ref.getText());
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:195:2: ( LPAREN (e= expression ( ',' e= expression )* )? RPAREN )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==LPAREN) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:195:3: LPAREN (e= expression ( ',' e= expression )* )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_reference805); if (state.failed) return r;
                    if ( state.backtracking==0 ) {
                      r = new FunctionReference(ref.getText());
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:196:3: (e= expression ( ',' e= expression )* )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==NOT||LA17_0==LPAREN||(LA17_0>=WORD && LA17_0<=DOUBLECONST_PRIVATE)||LA17_0==INTCONST_PRIVATE||(LA17_0>=61 && LA17_0<=62)) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:196:4: e= expression ( ',' e= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_reference814);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return r;
                            if ( state.backtracking==0 ) {
                              ((FunctionReference) r).arguments.add(e);
                            }
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:197:4: ( ',' e= expression )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==47) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:197:5: ',' e= expression
                            	    {
                            	    match(input,47,FOLLOW_47_in_reference822); if (state.failed) return r;
                            	    pushFollow(FOLLOW_expression_in_reference826);
                            	    e=expression();

                            	    state._fsp--;
                            	    if (state.failed) return r;
                            	    if ( state.backtracking==0 ) {
                            	      ((FunctionReference) r).arguments.add(e);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop16;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_reference838); if (state.failed) return r;

                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:200:2: ( LARRAY e= expression RARRAY )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==LARRAY) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:200:3: LARRAY e= expression RARRAY
            	    {
            	    match(input,LARRAY,FOLLOW_LARRAY_in_reference844); if (state.failed) return r;
            	    pushFollow(FOLLOW_expression_in_reference848);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      r = new ArrayReference(r, e);
            	    }
            	    match(input,RARRAY,FOLLOW_RARRAY_in_reference852); if (state.failed) return r;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:202:1: constant returns [Constant c = null] : ( (i= intconst ) | (d= doubleconst ) | (b= boolconst ) | (s= stringconst ) );
    public final Constant constant() throws RecognitionException {
        Constant c =  null;

        IntConstant i = null;

        DoubleConstant d = null;

        BooleanConstant b = null;

        StringConstant s = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:2: ( (i= intconst ) | (d= doubleconst ) | (b= boolconst ) | (s= stringconst ) )
            int alt20=4;
            switch ( input.LA(1) ) {
            case INTCONST_PRIVATE:
                {
                alt20=1;
                }
                break;
            case DOUBLECONST_PRIVATE:
                {
                alt20=2;
                }
                break;
            case 61:
            case 62:
                {
                alt20=3;
                }
                break;
            case STRINGCONST_PRIVATE:
                {
                alt20=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return c;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:4: (i= intconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:4: (i= intconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:5: i= intconst
                    {
                    pushFollow(FOLLOW_intconst_in_constant870);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:24: (d= doubleconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:24: (d= doubleconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:25: d= doubleconst
                    {
                    pushFollow(FOLLOW_doubleconst_in_constant878);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:47: (b= boolconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:47: (b= boolconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:48: b= boolconst
                    {
                    pushFollow(FOLLOW_boolconst_in_constant886);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:68: (s= stringconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:68: (s= stringconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:203:69: s= stringconst
                    {
                    pushFollow(FOLLOW_stringconst_in_constant894);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:207:1: primitive returns [Expression e = null] : (c= constant | (r= reference ( '.' b= reference )* ) | ( LPAREN x= expression RPAREN ) );
    public final Expression primitive() throws RecognitionException {
        Expression e =  null;

        Constant c = null;

        Reference r = null;

        Reference b = null;

        Expression x = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:208:2: (c= constant | (r= reference ( '.' b= reference )* ) | ( LPAREN x= expression RPAREN ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case STRINGCONST_PRIVATE:
            case DOUBLECONST_PRIVATE:
            case INTCONST_PRIVATE:
            case 61:
            case 62:
                {
                alt22=1;
                }
                break;
            case WORD:
                {
                alt22=2;
                }
                break;
            case LPAREN:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:208:4: c= constant
                    {
                    pushFollow(FOLLOW_constant_in_primitive914);
                    c=constant();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=c;
                    }

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:208:23: (r= reference ( '.' b= reference )* )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:208:23: (r= reference ( '.' b= reference )* )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:208:24: r= reference ( '.' b= reference )*
                    {
                    pushFollow(FOLLOW_reference_in_primitive922);
                    r=reference();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=r;
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:208:43: ( '.' b= reference )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==DOT) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:208:44: '.' b= reference
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_primitive927); if (state.failed) return e;
                    	    pushFollow(FOLLOW_reference_in_primitive931);
                    	    b=reference();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new RetrieverExpression((Reference) e, b);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:209:5: ( LPAREN x= expression RPAREN )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:209:5: ( LPAREN x= expression RPAREN )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:209:6: LPAREN x= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primitive943); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_primitive947);
                    x=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=x;
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primitive951); if (state.failed) return e;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:211:1: notcastexpr returns [Expression e = null] : ( (p= primitive ) | ( NOT p= notcastexpr ) | ( LPAREN t= type RPAREN p= notcastexpr ) );
    public final Expression notcastexpr() throws RecognitionException {
        Expression e =  null;

        Expression p = null;

        Type t = null;



        TypeCast cast = null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:2: ( (p= primitive ) | ( NOT p= notcastexpr ) | ( LPAREN t= type RPAREN p= notcastexpr ) )
            int alt23=3;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:4: (p= primitive )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:4: (p= primitive )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:215:5: p= primitive
                    {
                    pushFollow(FOLLOW_primitive_in_notcastexpr973);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:216:5: ( NOT p= notcastexpr )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:216:5: ( NOT p= notcastexpr )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:216:6: NOT p= notcastexpr
                    {
                    match(input,NOT,FOLLOW_NOT_in_notcastexpr983); if (state.failed) return e;
                    pushFollow(FOLLOW_notcastexpr_in_notcastexpr987);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:217:5: ( LPAREN t= type RPAREN p= notcastexpr )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:217:5: ( LPAREN t= type RPAREN p= notcastexpr )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:217:6: LPAREN t= type RPAREN p= notcastexpr
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_notcastexpr997); if (state.failed) return e;
                    pushFollow(FOLLOW_type_in_notcastexpr1001);
                    t=type();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,RPAREN,FOLLOW_RPAREN_in_notcastexpr1003); if (state.failed) return e;
                    pushFollow(FOLLOW_notcastexpr_in_notcastexpr1007);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:219:1: multop returns [Expression e = null] : t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )* ;
    public final Expression multop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:220:2: (t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:220:4: t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )*
            {
            pushFollow(FOLLOW_notcastexpr_in_multop1027);
            t=notcastexpr();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:220:25: ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=MULT && LA25_0<=MOD)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:221:2: ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:221:2: ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr )
            	    int alt24=3;
            	    switch ( input.LA(1) ) {
            	    case MULT:
            	        {
            	        alt24=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt24=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt24=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt24) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:221:3: MULT q= notcastexpr
            	            {
            	            match(input,MULT,FOLLOW_MULT_in_multop1035); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_multop1039);
            	            q=notcastexpr();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new MultiplyOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:222:3: DIV q= notcastexpr
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_multop1045); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_multop1049);
            	            q=notcastexpr();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new DivisionOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:223:3: MOD q= notcastexpr
            	            {
            	            match(input,MOD,FOLLOW_MOD_in_multop1055); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_multop1059);
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
    // $ANTLR end "multop"


    // $ANTLR start "sumop"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:226:1: sumop returns [Expression e = null] : t= multop ( ( PLUS q= multop | MINUS q= multop ) )* ;
    public final Expression sumop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:2: (t= multop ( ( PLUS q= multop | MINUS q= multop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:4: t= multop ( ( PLUS q= multop | MINUS q= multop ) )*
            {
            pushFollow(FOLLOW_multop_in_sumop1081);
            t=multop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:227:20: ( ( PLUS q= multop | MINUS q= multop ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=PLUS && LA27_0<=MINUS)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:228:2: ( PLUS q= multop | MINUS q= multop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:228:2: ( PLUS q= multop | MINUS q= multop )
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==PLUS) ) {
            	        alt26=1;
            	    }
            	    else if ( (LA26_0==MINUS) ) {
            	        alt26=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 26, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:228:3: PLUS q= multop
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_sumop1089); if (state.failed) return e;
            	            pushFollow(FOLLOW_multop_in_sumop1093);
            	            q=multop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new SumOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:229:3: MINUS q= multop
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_sumop1099); if (state.failed) return e;
            	            pushFollow(FOLLOW_multop_in_sumop1103);
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
    // $ANTLR end "sumop"


    // $ANTLR start "shiftop"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:232:1: shiftop returns [Expression e = null] : t= sumop ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )* ;
    public final Expression shiftop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:233:2: (t= sumop ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:233:4: t= sumop ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )*
            {
            pushFollow(FOLLOW_sumop_in_shiftop1125);
            t=sumop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:233:19: ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=RSHIFT && LA29_0<=LSHIFT)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:234:2: ( RSHIFT q= sumop | LSHIFT q= sumop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:234:2: ( RSHIFT q= sumop | LSHIFT q= sumop )
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==RSHIFT) ) {
            	        alt28=1;
            	    }
            	    else if ( (LA28_0==LSHIFT) ) {
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
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:234:3: RSHIFT q= sumop
            	            {
            	            match(input,RSHIFT,FOLLOW_RSHIFT_in_shiftop1133); if (state.failed) return e;
            	            pushFollow(FOLLOW_sumop_in_shiftop1137);
            	            q=sumop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new RShiftOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:235:3: LSHIFT q= sumop
            	            {
            	            match(input,LSHIFT,FOLLOW_LSHIFT_in_shiftop1143); if (state.failed) return e;
            	            pushFollow(FOLLOW_sumop_in_shiftop1147);
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
    // $ANTLR end "shiftop"


    // $ANTLR start "compop"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:238:1: compop returns [Expression e = null] : t= shiftop ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )* ;
    public final Expression compop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:239:2: (t= shiftop ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:239:4: t= shiftop ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )*
            {
            pushFollow(FOLLOW_shiftop_in_compop1170);
            t=shiftop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:239:21: ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=LESS && LA31_0<=MOREEQ)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:240:2: ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:240:2: ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop )
            	    int alt30=4;
            	    switch ( input.LA(1) ) {
            	    case LESS:
            	        {
            	        alt30=1;
            	        }
            	        break;
            	    case MORE:
            	        {
            	        alt30=2;
            	        }
            	        break;
            	    case LESSEQ:
            	        {
            	        alt30=3;
            	        }
            	        break;
            	    case MOREEQ:
            	        {
            	        alt30=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt30) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:240:3: LESS q= shiftop
            	            {
            	            match(input,LESS,FOLLOW_LESS_in_compop1178); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1182);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new LessOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:241:3: MORE q= shiftop
            	            {
            	            match(input,MORE,FOLLOW_MORE_in_compop1188); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1192);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new MoreOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:242:3: LESSEQ q= shiftop
            	            {
            	            match(input,LESSEQ,FOLLOW_LESSEQ_in_compop1198); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1202);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new LessEqualOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:243:3: MOREEQ q= shiftop
            	            {
            	            match(input,MOREEQ,FOLLOW_MOREEQ_in_compop1208); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1212);
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
    // $ANTLR end "compop"


    // $ANTLR start "comp2op"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:246:1: comp2op returns [Expression e = null] : t= compop ( ( EQUALS q= compop | NEQUAL q= compop ) )* ;
    public final Expression comp2op() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:247:2: (t= compop ( ( EQUALS q= compop | NEQUAL q= compop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:247:4: t= compop ( ( EQUALS q= compop | NEQUAL q= compop ) )*
            {
            pushFollow(FOLLOW_compop_in_comp2op1235);
            t=compop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:247:20: ( ( EQUALS q= compop | NEQUAL q= compop ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=EQUALS && LA33_0<=NEQUAL)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:248:2: ( EQUALS q= compop | NEQUAL q= compop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:248:2: ( EQUALS q= compop | NEQUAL q= compop )
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==EQUALS) ) {
            	        alt32=1;
            	    }
            	    else if ( (LA32_0==NEQUAL) ) {
            	        alt32=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 32, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt32) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:248:3: EQUALS q= compop
            	            {
            	            match(input,EQUALS,FOLLOW_EQUALS_in_comp2op1243); if (state.failed) return e;
            	            pushFollow(FOLLOW_compop_in_comp2op1247);
            	            q=compop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new EqualsOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:249:3: NEQUAL q= compop
            	            {
            	            match(input,NEQUAL,FOLLOW_NEQUAL_in_comp2op1253); if (state.failed) return e;
            	            pushFollow(FOLLOW_compop_in_comp2op1257);
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
    // $ANTLR end "comp2op"


    // $ANTLR start "bitwiseand"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:252:1: bitwiseand returns [Expression e = null] : t= comp2op ( ( BITWISEAND q= comp2op ) )* ;
    public final Expression bitwiseand() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:253:2: (t= comp2op ( ( BITWISEAND q= comp2op ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:253:4: t= comp2op ( ( BITWISEAND q= comp2op ) )*
            {
            pushFollow(FOLLOW_comp2op_in_bitwiseand1279);
            t=comp2op();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:253:21: ( ( BITWISEAND q= comp2op ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==BITWISEAND) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:254:2: ( BITWISEAND q= comp2op )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:254:2: ( BITWISEAND q= comp2op )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:254:3: BITWISEAND q= comp2op
            	    {
            	    match(input,BITWISEAND,FOLLOW_BITWISEAND_in_bitwiseand1287); if (state.failed) return e;
            	    pushFollow(FOLLOW_comp2op_in_bitwiseand1291);
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
    // $ANTLR end "bitwiseand"


    // $ANTLR start "bitwiseor"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:257:1: bitwiseor returns [Expression e = null] : t= bitwiseand ( ( BITWISEOR q= bitwiseand ) )* ;
    public final Expression bitwiseor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:258:2: (t= bitwiseand ( ( BITWISEOR q= bitwiseand ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:258:4: t= bitwiseand ( ( BITWISEOR q= bitwiseand ) )*
            {
            pushFollow(FOLLOW_bitwiseand_in_bitwiseor1313);
            t=bitwiseand();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:258:24: ( ( BITWISEOR q= bitwiseand ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==BITWISEOR) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:259:2: ( BITWISEOR q= bitwiseand )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:259:2: ( BITWISEOR q= bitwiseand )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:259:3: BITWISEOR q= bitwiseand
            	    {
            	    match(input,BITWISEOR,FOLLOW_BITWISEOR_in_bitwiseor1321); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwiseand_in_bitwiseor1325);
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
    // $ANTLR end "bitwiseor"


    // $ANTLR start "bitwisexor"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:262:1: bitwisexor returns [Expression e = null] : t= bitwiseor ( ( BITWISEXOR q= bitwiseor ) )* ;
    public final Expression bitwisexor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:263:2: (t= bitwiseor ( ( BITWISEXOR q= bitwiseor ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:263:4: t= bitwiseor ( ( BITWISEXOR q= bitwiseor ) )*
            {
            pushFollow(FOLLOW_bitwiseor_in_bitwisexor1348);
            t=bitwiseor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:263:23: ( ( BITWISEXOR q= bitwiseor ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==BITWISEXOR) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:264:2: ( BITWISEXOR q= bitwiseor )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:264:2: ( BITWISEXOR q= bitwiseor )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:264:3: BITWISEXOR q= bitwiseor
            	    {
            	    match(input,BITWISEXOR,FOLLOW_BITWISEXOR_in_bitwisexor1356); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwiseor_in_bitwisexor1360);
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
    // $ANTLR end "bitwisexor"


    // $ANTLR start "logicaland"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:267:1: logicaland returns [Expression e = null] : t= bitwisexor ( ( LOGAND q= bitwisexor ) )* ;
    public final Expression logicaland() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:268:2: (t= bitwisexor ( ( LOGAND q= bitwisexor ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:268:4: t= bitwisexor ( ( LOGAND q= bitwisexor ) )*
            {
            pushFollow(FOLLOW_bitwisexor_in_logicaland1382);
            t=bitwisexor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:268:24: ( ( LOGAND q= bitwisexor ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==LOGAND) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:269:2: ( LOGAND q= bitwisexor )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:269:2: ( LOGAND q= bitwisexor )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:269:3: LOGAND q= bitwisexor
            	    {
            	    match(input,LOGAND,FOLLOW_LOGAND_in_logicaland1390); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwisexor_in_logicaland1394);
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
            	    break loop37;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:272:1: logicalor returns [Expression e = null] : t= logicaland ( ( LOGOR q= logicaland ) )* ;
    public final Expression logicalor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:273:2: (t= logicaland ( ( LOGOR q= logicaland ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:273:4: t= logicaland ( ( LOGOR q= logicaland ) )*
            {
            pushFollow(FOLLOW_logicaland_in_logicalor1416);
            t=logicaland();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:273:24: ( ( LOGOR q= logicaland ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==LOGOR) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:274:2: ( LOGOR q= logicaland )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:274:2: ( LOGOR q= logicaland )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:274:3: LOGOR q= logicaland
            	    {
            	    match(input,LOGOR,FOLLOW_LOGOR_in_logicalor1424); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicaland_in_logicalor1428);
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
    // $ANTLR end "logicalor"


    // $ANTLR start "ternary"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:277:1: ternary returns [Expression e = null] : t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )* ;
    public final Expression ternary() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression p = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:278:2: (t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:278:4: t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )*
            {
            pushFollow(FOLLOW_logicalor_in_ternary1451);
            t=logicalor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:278:23: ( ( '?' p= logicalor ':' q= logicalor ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==49) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:279:2: ( '?' p= logicalor ':' q= logicalor )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:279:2: ( '?' p= logicalor ':' q= logicalor )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:279:3: '?' p= logicalor ':' q= logicalor
            	    {
            	    match(input,49,FOLLOW_49_in_ternary1459); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicalor_in_ternary1463);
            	    p=logicalor();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    match(input,50,FOLLOW_50_in_ternary1465); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicalor_in_ternary1469);
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
    // $ANTLR end "ternary"


    // $ANTLR start "expression"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:282:1: expression returns [Expression e = null] : ( (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) | (t= ternary ) );
    public final Expression expression() throws RecognitionException {
        Expression e =  null;

        Expression r = null;

        Expression q = null;

        Expression t = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:2: ( (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) | (t= ternary ) )
            int alt41=2;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:4: (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:4: (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:5: r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )*
                    {
                    pushFollow(FOLLOW_ternary_in_expression1493);
                    r=ternary();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=r;
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:22: ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )*
                    loop40:
                    do {
                        int alt40=12;
                        switch ( input.LA(1) ) {
                        case EQUAL:
                            {
                            alt40=1;
                            }
                            break;
                        case 51:
                            {
                            alt40=2;
                            }
                            break;
                        case 52:
                            {
                            alt40=3;
                            }
                            break;
                        case 53:
                            {
                            alt40=4;
                            }
                            break;
                        case 54:
                            {
                            alt40=5;
                            }
                            break;
                        case 55:
                            {
                            alt40=6;
                            }
                            break;
                        case 56:
                            {
                            alt40=7;
                            }
                            break;
                        case 57:
                            {
                            alt40=8;
                            }
                            break;
                        case 58:
                            {
                            alt40=9;
                            }
                            break;
                        case 59:
                            {
                            alt40=10;
                            }
                            break;
                        case 60:
                            {
                            alt40=11;
                            }
                            break;

                        }

                        switch (alt40) {
                    	case 1 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:284:2: ( EQUAL q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:284:2: ( EQUAL q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:284:3: EQUAL q= ternary
                    	    {
                    	    match(input,EQUAL,FOLLOW_EQUAL_in_expression1501); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1505);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:3: ( '+=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:3: ( '+=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:4: '+=' q= ternary
                    	    {
                    	    match(input,51,FOLLOW_51_in_expression1513); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1517);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:3: ( '-=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:3: ( '-=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:4: '-=' q= ternary
                    	    {
                    	    match(input,52,FOLLOW_52_in_expression1525); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1529);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:3: ( '*=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:3: ( '*=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:4: '*=' q= ternary
                    	    {
                    	    match(input,53,FOLLOW_53_in_expression1537); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1541);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:288:3: ( '/=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:288:3: ( '/=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:288:4: '/=' q= ternary
                    	    {
                    	    match(input,54,FOLLOW_54_in_expression1549); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1553);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:289:3: ( '%=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:289:3: ( '%=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:289:4: '%=' q= ternary
                    	    {
                    	    match(input,55,FOLLOW_55_in_expression1561); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1565);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:290:3: ( '&=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:290:3: ( '&=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:290:4: '&=' q= ternary
                    	    {
                    	    match(input,56,FOLLOW_56_in_expression1573); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1577);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:291:3: ( '|=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:291:3: ( '|=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:291:4: '|=' q= ternary
                    	    {
                    	    match(input,57,FOLLOW_57_in_expression1585); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1589);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:292:3: ( '^=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:292:3: ( '^=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:292:4: '^=' q= ternary
                    	    {
                    	    match(input,58,FOLLOW_58_in_expression1597); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1601);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:293:3: ( '<<=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:293:3: ( '<<=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:293:4: '<<=' q= ternary
                    	    {
                    	    match(input,59,FOLLOW_59_in_expression1609); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1613);
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
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:294:3: ( '>>=' q= ternary )
                    	    {
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:294:3: ( '>>=' q= ternary )
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:294:4: '>>=' q= ternary
                    	    {
                    	    match(input,60,FOLLOW_60_in_expression1621); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression1625);
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
                    	    break loop40;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:295:8: (t= ternary )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:295:8: (t= ternary )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:295:9: t= ternary
                    {
                    pushFollow(FOLLOW_ternary_in_expression1640);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:299:1: stringconst returns [StringConstant s = null] : v= STRINGCONST_PRIVATE ;
    public final StringConstant stringconst() throws RecognitionException {
        StringConstant s =  null;

        Token v=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:300:2: (v= STRINGCONST_PRIVATE )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:300:4: v= STRINGCONST_PRIVATE
            {
            v=(Token)match(input,STRINGCONST_PRIVATE,FOLLOW_STRINGCONST_PRIVATE_in_stringconst1660); if (state.failed) return s;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:308:1: doubleconst returns [DoubleConstant d = null] : v= DOUBLECONST_PRIVATE ;
    public final DoubleConstant doubleconst() throws RecognitionException {
        DoubleConstant d =  null;

        Token v=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:309:2: (v= DOUBLECONST_PRIVATE )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:309:4: v= DOUBLECONST_PRIVATE
            {
            v=(Token)match(input,DOUBLECONST_PRIVATE,FOLLOW_DOUBLECONST_PRIVATE_in_doubleconst1716); if (state.failed) return d;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:314:1: intconst returns [IntConstant i = null] : v= INTCONST_PRIVATE ;
    public final IntConstant intconst() throws RecognitionException {
        IntConstant i =  null;

        Token v=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:315:2: (v= INTCONST_PRIVATE )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:315:4: v= INTCONST_PRIVATE
            {
            v=(Token)match(input,INTCONST_PRIVATE,FOLLOW_INTCONST_PRIVATE_in_intconst1754); if (state.failed) return i;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:323:1: boolconst returns [BooleanConstant b = new BooleanConstant(false)] : ( ( 'true' ) | 'false' );
    public final BooleanConstant boolconst() throws RecognitionException {
        BooleanConstant b =  new BooleanConstant(false);

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:324:2: ( ( 'true' ) | 'false' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==61) ) {
                alt42=1;
            }
            else if ( (LA42_0==62) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return b;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:324:4: ( 'true' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:324:4: ( 'true' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:324:5: 'true'
                    {
                    match(input,61,FOLLOW_61_in_boolconst1829); if (state.failed) return b;
                    if ( state.backtracking==0 ) {
                      b.value = true;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:324:31: 'false'
                    {
                    match(input,62,FOLLOW_62_in_boolconst1834); if (state.failed) return b;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:326:1: type returns [Type type = new Type()] : ( (i= nativetype ) | (t= clstype ) );
    public final Type type() throws RecognitionException {
        Type type =  new Type();

        Type i = null;

        Type t = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:327:2: ( (i= nativetype ) | (t= clstype ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=63 && LA43_0<=72)) ) {
                alt43=1;
            }
            else if ( (LA43_0==WORD) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:327:4: (i= nativetype )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:327:4: (i= nativetype )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:327:5: i= nativetype
                    {
                    pushFollow(FOLLOW_nativetype_in_type1850);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:327:29: (t= clstype )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:327:29: (t= clstype )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:327:30: t= clstype
                    {
                    pushFollow(FOLLOW_clstype_in_type1858);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:329:1: clstype returns [Type type = new Type()] : (c= WORD ( '.' t= WORD )* ) ;
    public final Type clstype() throws RecognitionException {
        Type type =  new Type();

        Token c=null;
        Token t=null;


        	type.typeCategory = TypeCategory.CLASS;
        	String s = "";

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:334:2: ( (c= WORD ( '.' t= WORD )* ) )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:334:4: (c= WORD ( '.' t= WORD )* )
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:334:4: (c= WORD ( '.' t= WORD )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:334:5: c= WORD ( '.' t= WORD )*
            {
            c=(Token)match(input,WORD,FOLLOW_WORD_in_clstype1881); if (state.failed) return type;
            if ( state.backtracking==0 ) {
              s += c.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:334:32: ( '.' t= WORD )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==DOT) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:334:33: '.' t= WORD
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_clstype1886); if (state.failed) return type;
            	    t=(Token)match(input,WORD,FOLLOW_WORD_in_clstype1890); if (state.failed) return type;
            	    if ( state.backtracking==0 ) {
            	      s += "." + t.getText();
            	    }

            	    }
            	    break;

            	default :
            	    break loop44;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:336:1: nativetype returns [Type type = new Type()] : ( ( 'int' ) | ( 'uint' ) | ( 'float' ) | ( 'ufloat' ) | ( 'double' ) | ( 'udouble' ) | ( 'char' ) | ( 'uchar' ) | ( 'bool' ) | ( 'string' ) );
    public final Type nativetype() throws RecognitionException {
        Type type =  new Type();


        	type.typeCategory = TypeCategory.NATIVE;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:339:3: ( ( 'int' ) | ( 'uint' ) | ( 'float' ) | ( 'ufloat' ) | ( 'double' ) | ( 'udouble' ) | ( 'char' ) | ( 'uchar' ) | ( 'bool' ) | ( 'string' ) )
            int alt45=10;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt45=1;
                }
                break;
            case 64:
                {
                alt45=2;
                }
                break;
            case 65:
                {
                alt45=3;
                }
                break;
            case 66:
                {
                alt45=4;
                }
                break;
            case 67:
                {
                alt45=5;
                }
                break;
            case 68:
                {
                alt45=6;
                }
                break;
            case 69:
                {
                alt45=7;
                }
                break;
            case 70:
                {
                alt45=8;
                }
                break;
            case 71:
                {
                alt45=9;
                }
                break;
            case 72:
                {
                alt45=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:339:5: ( 'int' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:339:5: ( 'int' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:339:6: 'int'
                    {
                    match(input,63,FOLLOW_63_in_nativetype1914); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.INT;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:340:2: ( 'uint' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:340:2: ( 'uint' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:340:3: 'uint'
                    {
                    match(input,64,FOLLOW_64_in_nativetype1922); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UINT;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:341:2: ( 'float' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:341:2: ( 'float' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:341:3: 'float'
                    {
                    match(input,65,FOLLOW_65_in_nativetype1930); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.FLOAT;
                    }

                    }


                    }
                    break;
                case 4 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:342:2: ( 'ufloat' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:342:2: ( 'ufloat' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:342:3: 'ufloat'
                    {
                    match(input,66,FOLLOW_66_in_nativetype1938); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UFLOAT;
                    }

                    }


                    }
                    break;
                case 5 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:343:2: ( 'double' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:343:2: ( 'double' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:343:3: 'double'
                    {
                    match(input,67,FOLLOW_67_in_nativetype1946); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.DOUBLE;
                    }

                    }


                    }
                    break;
                case 6 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:344:2: ( 'udouble' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:344:2: ( 'udouble' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:344:3: 'udouble'
                    {
                    match(input,68,FOLLOW_68_in_nativetype1954); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UDOUBLE;
                    }

                    }


                    }
                    break;
                case 7 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:345:2: ( 'char' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:345:2: ( 'char' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:345:3: 'char'
                    {
                    match(input,69,FOLLOW_69_in_nativetype1962); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.CHAR;
                    }

                    }


                    }
                    break;
                case 8 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:346:2: ( 'uchar' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:346:2: ( 'uchar' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:346:3: 'uchar'
                    {
                    match(input,70,FOLLOW_70_in_nativetype1970); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UCHAR;
                    }

                    }


                    }
                    break;
                case 9 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:347:2: ( 'bool' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:347:2: ( 'bool' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:347:3: 'bool'
                    {
                    match(input,71,FOLLOW_71_in_nativetype1978); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.BOOL;
                    }

                    }


                    }
                    break;
                case 10 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:348:2: ( 'string' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:348:2: ( 'string' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:348:3: 'string'
                    {
                    match(input,72,FOLLOW_72_in_nativetype1986); if (state.failed) return type;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:350:1: accesscontrolkeyword returns [AccessControlKeyword a = AccessControlKeyword.PUBLIC] : ( 'public' | ( 'private' ) | ( 'protected' ) );
    public final AccessControlKeyword accesscontrolkeyword() throws RecognitionException {
        AccessControlKeyword a =  AccessControlKeyword.PUBLIC;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:351:2: ( 'public' | ( 'private' ) | ( 'protected' ) )
            int alt46=3;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt46=1;
                }
                break;
            case 74:
                {
                alt46=2;
                }
                break;
            case 75:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return a;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:351:4: 'public'
                    {
                    match(input,73,FOLLOW_73_in_accesscontrolkeyword2003); if (state.failed) return a;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:351:15: ( 'private' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:351:15: ( 'private' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:351:16: 'private'
                    {
                    match(input,74,FOLLOW_74_in_accesscontrolkeyword2008); if (state.failed) return a;
                    if ( state.backtracking==0 ) {
                      a = AccessControlKeyword.PRIVATE;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:351:65: ( 'protected' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:351:65: ( 'protected' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:351:66: 'protected'
                    {
                    match(input,75,FOLLOW_75_in_accesscontrolkeyword2016); if (state.failed) return a;
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

    // $ANTLR start synpred61_PineDL
    public final void synpred61_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:4: ( ( ternary ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )* ) )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:4: ( ternary ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )* )
        {
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:4: ( ternary ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )* )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:5: ternary ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )*
        {
        pushFollow(FOLLOW_ternary_in_synpred61_PineDL1493);
        ternary();

        state._fsp--;
        if (state.failed) return ;
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:283:22: ( ( EQUAL ternary ) | ( '+=' ternary ) | ( '-=' ternary ) | ( '*=' ternary ) | ( '/=' ternary ) | ( '%=' ternary ) | ( '&=' ternary ) | ( '|=' ternary ) | ( '^=' ternary ) | ( '<<=' ternary ) | ( '>>=' ternary ) )*
        loop57:
        do {
            int alt57=12;
            switch ( input.LA(1) ) {
            case EQUAL:
                {
                alt57=1;
                }
                break;
            case 51:
                {
                alt57=2;
                }
                break;
            case 52:
                {
                alt57=3;
                }
                break;
            case 53:
                {
                alt57=4;
                }
                break;
            case 54:
                {
                alt57=5;
                }
                break;
            case 55:
                {
                alt57=6;
                }
                break;
            case 56:
                {
                alt57=7;
                }
                break;
            case 57:
                {
                alt57=8;
                }
                break;
            case 58:
                {
                alt57=9;
                }
                break;
            case 59:
                {
                alt57=10;
                }
                break;
            case 60:
                {
                alt57=11;
                }
                break;

            }

            switch (alt57) {
        	case 1 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:284:2: ( EQUAL ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:284:2: ( EQUAL ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:284:3: EQUAL ternary
        	    {
        	    match(input,EQUAL,FOLLOW_EQUAL_in_synpred61_PineDL1501); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred61_PineDL1505);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 2 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:3: ( '+=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:3: ( '+=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:285:4: '+=' ternary
        	    {
        	    match(input,51,FOLLOW_51_in_synpred61_PineDL1513); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred61_PineDL1517);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 3 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:3: ( '-=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:3: ( '-=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:286:4: '-=' ternary
        	    {
        	    match(input,52,FOLLOW_52_in_synpred61_PineDL1525); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred61_PineDL1529);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 4 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:3: ( '*=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:3: ( '*=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:287:4: '*=' ternary
        	    {
        	    match(input,53,FOLLOW_53_in_synpred61_PineDL1537); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred61_PineDL1541);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 5 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:288:3: ( '/=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:288:3: ( '/=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:288:4: '/=' ternary
        	    {
        	    match(input,54,FOLLOW_54_in_synpred61_PineDL1549); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred61_PineDL1553);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 6 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:289:3: ( '%=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:289:3: ( '%=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:289:4: '%=' ternary
        	    {
        	    match(input,55,FOLLOW_55_in_synpred61_PineDL1561); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred61_PineDL1565);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 7 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:290:3: ( '&=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:290:3: ( '&=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:290:4: '&=' ternary
        	    {
        	    match(input,56,FOLLOW_56_in_synpred61_PineDL1573); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred61_PineDL1577);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 8 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:291:3: ( '|=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:291:3: ( '|=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:291:4: '|=' ternary
        	    {
        	    match(input,57,FOLLOW_57_in_synpred61_PineDL1585); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred61_PineDL1589);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 9 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:292:3: ( '^=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:292:3: ( '^=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:292:4: '^=' ternary
        	    {
        	    match(input,58,FOLLOW_58_in_synpred61_PineDL1597); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred61_PineDL1601);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 10 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:293:3: ( '<<=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:293:3: ( '<<=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:293:4: '<<=' ternary
        	    {
        	    match(input,59,FOLLOW_59_in_synpred61_PineDL1609); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred61_PineDL1613);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 11 :
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:294:3: ( '>>=' ternary )
        	    {
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:294:3: ( '>>=' ternary )
        	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pinedl/PineDL.g:294:4: '>>=' ternary
        	    {
        	    match(input,60,FOLLOW_60_in_synpred61_PineDL1621); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred61_PineDL1625);
        	    ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop57;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred61_PineDL

    // Delegated rules

    public final boolean synpred61_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_PineDL_fragment(); // can never throw exception
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
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA41 dfa41 = new DFA41(this);
    static final String DFA3_eotS =
        "\27\uffff";
    static final String DFA3_eofS =
        "\27\uffff";
    static final String DFA3_minS =
        "\1\33\1\uffff\16\40\1\11\1\uffff\1\24\1\40\2\uffff\1\11";
    static final String DFA3_maxS =
        "\1\113\1\uffff\4\110\13\40\1\uffff\1\34\1\40\2\uffff\1\40";
    static final String DFA3_acceptS =
        "\1\uffff\1\4\17\uffff\1\3\2\uffff\1\1\1\2\1\uffff";
    static final String DFA3_specialS =
        "\27\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1\55\uffff\1\2\1\3\1\4",
            "",
            "\1\20\14\uffff\1\5\1\21\20\uffff\1\6\1\7\1\10\1\11\1\12\1\13"+
            "\1\14\1\15\1\16\1\17",
            "\1\20\14\uffff\1\5\1\21\20\uffff\1\6\1\7\1\10\1\11\1\12\1\13"+
            "\1\14\1\15\1\16\1\17",
            "\1\20\14\uffff\1\5\1\21\20\uffff\1\6\1\7\1\10\1\11\1\12\1\13"+
            "\1\14\1\15\1\16\1\17",
            "\1\20\36\uffff\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1"+
            "\17",
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
            "",
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
    static final String DFA12_eotS =
        "\7\uffff";
    static final String DFA12_eofS =
        "\7\uffff";
    static final String DFA12_minS =
        "\1\14\1\uffff\1\4\2\uffff\1\40\1\4";
    static final String DFA12_maxS =
        "\1\110\1\uffff\1\74\2\uffff\1\40\1\74";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\2\uffff";
    static final String DFA12_specialS =
        "\7\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\3\17\uffff\1\3\3\uffff\1\2\2\3\1\uffff\1\3\13\uffff\1\4\14"+
            "\uffff\2\3\12\1",
            "",
            "\5\3\1\5\2\3\1\uffff\15\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1"+
            "\1\20\uffff\1\3\1\uffff\12\3",
            "",
            "",
            "\1\6",
            "\5\3\1\5\2\3\1\uffff\15\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1"+
            "\1\20\uffff\1\3\1\uffff\12\3"
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "179:1: stmt returns [Leaf l = null] : ( (e= declAssign ) | (a= expression STMTEND ) | (b= returnstmt ) );";
        }
    }
    static final String DFA23_eotS =
        "\11\uffff";
    static final String DFA23_eofS =
        "\7\uffff\1\1\1\uffff";
    static final String DFA23_minS =
        "\1\14\1\uffff\1\14\2\uffff\1\4\1\40\2\4";
    static final String DFA23_maxS =
        "\1\76\1\uffff\1\110\2\uffff\1\74\1\40\1\76\1\74";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\4\uffff";
    static final String DFA23_specialS =
        "\11\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\3\17\uffff\1\2\3\uffff\3\1\1\uffff\1\1\30\uffff\2\1",
            "",
            "\1\1\17\uffff\1\1\3\uffff\1\5\2\1\1\uffff\1\1\30\uffff\2\1"+
            "\12\4",
            "",
            "",
            "\5\1\1\6\2\1\1\uffff\7\1\1\uffff\5\1\2\uffff\1\1\1\7\1\1\22"+
            "\uffff\1\1\1\uffff\12\1",
            "\1\10",
            "\5\1\1\uffff\2\1\1\4\15\1\2\uffff\1\4\1\1\1\uffff\1\1\3\4\1"+
            "\uffff\1\4\12\uffff\1\1\1\uffff\14\1\2\4",
            "\5\1\1\6\2\1\1\uffff\7\1\1\uffff\5\1\2\uffff\1\1\1\7\1\1\22"+
            "\uffff\1\1\1\uffff\12\1"
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "211:1: notcastexpr returns [Expression e = null] : ( (p= primitive ) | ( NOT p= notcastexpr ) | ( LPAREN t= type RPAREN p= notcastexpr ) );";
        }
    }
    static final String DFA41_eotS =
        "\13\uffff";
    static final String DFA41_eofS =
        "\13\uffff";
    static final String DFA41_minS =
        "\1\14\10\0\2\uffff";
    static final String DFA41_maxS =
        "\1\76\10\0\2\uffff";
    static final String DFA41_acceptS =
        "\11\uffff\1\1\1\2";
    static final String DFA41_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff}>";
    static final String[] DFA41_transitionS = {
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

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "282:1: expression returns [Expression e = null] : ( (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) | (t= ternary ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA41_1 = input.LA(1);

                         
                        int index41_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred61_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA41_2 = input.LA(1);

                         
                        int index41_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred61_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA41_3 = input.LA(1);

                         
                        int index41_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred61_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA41_4 = input.LA(1);

                         
                        int index41_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred61_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA41_5 = input.LA(1);

                         
                        int index41_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred61_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA41_6 = input.LA(1);

                         
                        int index41_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred61_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA41_7 = input.LA(1);

                         
                        int index41_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred61_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA41_8 = input.LA(1);

                         
                        int index41_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred61_PineDL()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 41, _s, input);
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
    public static final BitSet FOLLOW_declAssign_in_stmt665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_stmt676 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_stmt678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnstmt_in_stmt689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_returnstmt706 = new BitSet(new long[]{0x6000001710101000L});
    public static final BitSet FOLLOW_expression_in_returnstmt711 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_returnstmt717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_declAssign733 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_declAssign739 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_EQUAL_in_declAssign744 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_expression_in_declAssign748 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_declAssign754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_pkgname770 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_pkgname775 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_pkgname779 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_WORD_in_reference799 = new BitSet(new long[]{0x0000000050000002L});
    public static final BitSet FOLLOW_LPAREN_in_reference805 = new BitSet(new long[]{0x6000001730001000L});
    public static final BitSet FOLLOW_expression_in_reference814 = new BitSet(new long[]{0x0000800020000000L});
    public static final BitSet FOLLOW_47_in_reference822 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_expression_in_reference826 = new BitSet(new long[]{0x0000800020000000L});
    public static final BitSet FOLLOW_RPAREN_in_reference838 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_LARRAY_in_reference844 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_expression_in_reference848 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RARRAY_in_reference852 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_intconst_in_constant870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doubleconst_in_constant878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolconst_in_constant886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringconst_in_constant894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primitive914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_in_primitive922 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_primitive927 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_reference_in_primitive931 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_LPAREN_in_primitive943 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_expression_in_primitive947 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_primitive951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitive_in_notcastexpr973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notcastexpr983 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_notcastexpr_in_notcastexpr987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_notcastexpr997 = new BitSet(new long[]{0x8000200100000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_type_in_notcastexpr1001 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_notcastexpr1003 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_notcastexpr_in_notcastexpr1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notcastexpr_in_multop1027 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_MULT_in_multop1035 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_notcastexpr_in_multop1039 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_DIV_in_multop1045 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_notcastexpr_in_multop1049 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_MOD_in_multop1055 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_notcastexpr_in_multop1059 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_multop_in_sumop1081 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_PLUS_in_sumop1089 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_multop_in_sumop1093 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_MINUS_in_sumop1099 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_multop_in_sumop1103 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_sumop_in_shiftop1125 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_RSHIFT_in_shiftop1133 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_sumop_in_shiftop1137 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_LSHIFT_in_shiftop1143 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_sumop_in_shiftop1147 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_shiftop_in_compop1170 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LESS_in_compop1178 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_shiftop_in_compop1182 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_MORE_in_compop1188 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_shiftop_in_compop1192 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LESSEQ_in_compop1198 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_shiftop_in_compop1202 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_MOREEQ_in_compop1208 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_shiftop_in_compop1212 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_compop_in_comp2op1235 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_EQUALS_in_comp2op1243 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_compop_in_comp2op1247 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_NEQUAL_in_comp2op1253 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_compop_in_comp2op1257 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_comp2op_in_bitwiseand1279 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_BITWISEAND_in_bitwiseand1287 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_comp2op_in_bitwiseand1291 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_bitwiseand_in_bitwiseor1313 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_BITWISEOR_in_bitwiseor1321 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_bitwiseand_in_bitwiseor1325 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_bitwiseor_in_bitwisexor1348 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_BITWISEXOR_in_bitwisexor1356 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_bitwiseor_in_bitwisexor1360 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_bitwisexor_in_logicaland1382 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_LOGAND_in_logicaland1390 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_bitwisexor_in_logicaland1394 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_logicaland_in_logicalor1416 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LOGOR_in_logicalor1424 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_logicaland_in_logicalor1428 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_logicalor_in_ternary1451 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ternary1459 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_logicalor_in_ternary1463 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ternary1465 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_logicalor_in_ternary1469 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_ternary_in_expression1493 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_EQUAL_in_expression1501 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1505 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_51_in_expression1513 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1517 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_52_in_expression1525 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1529 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_53_in_expression1537 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1541 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_54_in_expression1549 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1553 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_55_in_expression1561 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1565 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_56_in_expression1573 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1577 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_57_in_expression1585 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1589 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_58_in_expression1597 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1601 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_59_in_expression1609 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1613 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_60_in_expression1621 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_expression1625 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_ternary_in_expression1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGCONST_PRIVATE_in_stringconst1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLECONST_PRIVATE_in_doubleconst1716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTCONST_PRIVATE_in_intconst1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_boolconst1829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_boolconst1834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativetype_in_type1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_clstype_in_type1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_clstype1881 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_clstype1886 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_clstype1890 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_63_in_nativetype1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_nativetype1922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_nativetype1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_nativetype1938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_nativetype1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_nativetype1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_nativetype1962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_nativetype1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_nativetype1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_nativetype1986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_accesscontrolkeyword2003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_accesscontrolkeyword2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_accesscontrolkeyword2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ternary_in_synpred61_PineDL1493 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_EQUAL_in_synpred61_PineDL1501 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred61_PineDL1505 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_51_in_synpred61_PineDL1513 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred61_PineDL1517 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_52_in_synpred61_PineDL1525 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred61_PineDL1529 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_53_in_synpred61_PineDL1537 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred61_PineDL1541 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_54_in_synpred61_PineDL1549 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred61_PineDL1553 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_55_in_synpred61_PineDL1561 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred61_PineDL1565 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_56_in_synpred61_PineDL1573 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred61_PineDL1577 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_57_in_synpred61_PineDL1585 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred61_PineDL1589 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_58_in_synpred61_PineDL1597 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred61_PineDL1601 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_59_in_synpred61_PineDL1609 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred61_PineDL1613 = new BitSet(new long[]{0x1FF8000000002002L});
    public static final BitSet FOLLOW_60_in_synpred61_PineDL1621 = new BitSet(new long[]{0x6000001710001000L});
    public static final BitSet FOLLOW_ternary_in_synpred61_PineDL1625 = new BitSet(new long[]{0x1FF8000000002002L});

}