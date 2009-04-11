// $ANTLR 3.1.2 /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g 2009-04-11 13:49:37

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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class PineDLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "MINUS", "MULT", "DIV", "MOD", "DOT", "RSHIFT", "LSHIFT", "NOT", "EQUAL", "LESS", "MORE", "LESSEQ", "MOREEQ", "EQUALS", "NEQUAL", "STMTEND", "BITWISEAND", "BITWISEOR", "BITWISEXOR", "LOGAND", "LOGOR", "BLKBEG", "BLKEND", "LPAREN", "RPAREN", "LARRAY", "RARRAY", "WORD", "STRINGCONST_PRIVATE", "DOUBLECONST_PRIVATE", "DIGIT", "INTCONST_PRIVATE", "ALPHA", "SLCOMMENT", "MLCOMMENT", "WHITESPACE", "'package'", "'import'", "'class'", "'extends'", "'static'", "'final'", "'this'", "':'", "'super'", "','", "'break'", "'continue'", "'if'", "'else'", "'while'", "'for'", "'try'", "'catch'", "'return'", "'throw'", "'new'", "'++'", "'--'", "'?'", "'+='", "'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'null'", "'true'", "'false'", "'int'", "'uint'", "'float'", "'ufloat'", "'double'", "'udouble'", "'char'", "'uchar'", "'bool'", "'string'", "'void'", "'public'", "'private'", "'protected'"
    };
    public static final int RARRAY=31;
    public static final int MOD=8;
    public static final int BLKEND=27;
    public static final int BITWISEXOR=23;
    public static final int DOUBLECONST_PRIVATE=34;
    public static final int SLCOMMENT=38;
    public static final int EQUALS=18;
    public static final int NOT=12;
    public static final int STRINGCONST_PRIVATE=33;
    public static final int EOF=-1;
    public static final int WORD=32;
    public static final int T__91=91;
    public static final int RPAREN=29;
    public static final int BITWISEAND=21;
    public static final int T__90=90;
    public static final int LESS=14;
    public static final int MLCOMMENT=39;
    public static final int NEQUAL=19;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int LSHIFT=11;
    public static final int LOGAND=24;
    public static final int INTCONST_PRIVATE=36;
    public static final int WHITESPACE=40;
    public static final int MULT=6;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int ALPHA=37;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int MORE=15;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int STMTEND=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int LPAREN=28;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int MOREEQ=17;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int LESSEQ=16;
    public static final int BLKBEG=26;
    public static final int T__59=59;
    public static final int EQUAL=13;
    public static final int PLUS=4;
    public static final int DIGIT=35;
    public static final int DOT=9;
    public static final int T__50=50;
    public static final int RSHIFT=10;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int LARRAY=30;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int LOGOR=25;
    public static final int MINUS=5;
    public static final int BITWISEOR=22;
    public static final int DIV=7;

    // delegates
    // delegators


        public PineDLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PineDLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PineDLParser.tokenNames; }
    public String getGrammarFileName() { return "/home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g"; }


    	private PineClass target = null;



    // $ANTLR start "doc"
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:133:1: doc returns [PineClass t] : ( pkgstmt )? ( importstmt )* clsdecl ;
    public final PineClass doc() throws RecognitionException {
        PineClass t = null;


        	target = new PineClass();

        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:137:2: ( ( pkgstmt )? ( importstmt )* clsdecl )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:137:4: ( pkgstmt )? ( importstmt )* clsdecl
            {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:137:4: ( pkgstmt )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==41) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:0:0: pkgstmt
                    {
                    pushFollow(FOLLOW_pkgstmt_in_doc289);
                    pkgstmt();

                    state._fsp--;
                    if (state.failed) return t;

                    }
                    break;

            }

            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:138:3: ( importstmt )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==42) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:0:0: importstmt
            	    {
            	    pushFollow(FOLLOW_importstmt_in_doc294);
            	    importstmt();

            	    state._fsp--;
            	    if (state.failed) return t;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            pushFollow(FOLLOW_clsdecl_in_doc299);
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:142:1: pkgstmt : 'package' s= pkgname STMTEND ;
    public final void pkgstmt() throws RecognitionException {
        String s = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:142:9: ( 'package' s= pkgname STMTEND )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:142:11: 'package' s= pkgname STMTEND
            {
            match(input,41,FOLLOW_41_in_pkgstmt311); if (state.failed) return ;
            pushFollow(FOLLOW_pkgname_in_pkgstmt315);
            s=pkgname();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              target.packageName = s.split("\\."); 
            }
            match(input,STMTEND,FOLLOW_STMTEND_in_pkgstmt319); if (state.failed) return ;

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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:144:1: importstmt : 'import' i= clstype STMTEND ;
    public final void importstmt() throws RecognitionException {
        Type i = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:145:2: ( 'import' i= clstype STMTEND )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:145:4: 'import' i= clstype STMTEND
            {
            match(input,42,FOLLOW_42_in_importstmt328); if (state.failed) return ;
            pushFollow(FOLLOW_clstype_in_importstmt332);
            i=clstype();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              target.importStmt.add(i);
            }
            match(input,STMTEND,FOLLOW_STMTEND_in_importstmt336); if (state.failed) return ;

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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:147:1: clsdecl : 'class' n= WORD ( 'extends' e= clstype )? BLKBEG (f= field | m= method | c= constructor )* BLKEND ( STMTEND )? ;
    public final void clsdecl() throws RecognitionException {
        Token n=null;
        Type e = null;

        Variable f = null;

        Function m = null;

        Constructor c = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:147:9: ( 'class' n= WORD ( 'extends' e= clstype )? BLKBEG (f= field | m= method | c= constructor )* BLKEND ( STMTEND )? )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:147:11: 'class' n= WORD ( 'extends' e= clstype )? BLKBEG (f= field | m= method | c= constructor )* BLKEND ( STMTEND )?
            {
            match(input,43,FOLLOW_43_in_clsdecl345); if (state.failed) return ;
            n=(Token)match(input,WORD,FOLLOW_WORD_in_clsdecl349); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              target.clsName = n.getText();
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:147:58: ( 'extends' e= clstype )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==44) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:147:59: 'extends' e= clstype
                    {
                    match(input,44,FOLLOW_44_in_clsdecl354); if (state.failed) return ;
                    pushFollow(FOLLOW_clstype_in_clsdecl358);
                    e=clstype();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      target.superClass = e;
                    }

                    }
                    break;

            }

            match(input,BLKBEG,FOLLOW_BLKBEG_in_clsdecl366); if (state.failed) return ;
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:149:3: (f= field | m= method | c= constructor )*
            loop4:
            do {
                int alt4=4;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:150:4: f= field
            	    {
            	    pushFollow(FOLLOW_field_in_clsdecl377);
            	    f=field();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	       target.variables.add(f); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:151:4: m= method
            	    {
            	    pushFollow(FOLLOW_method_in_clsdecl388);
            	    m=method();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	       target.functions.add(m); 
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:152:4: c= constructor
            	    {
            	    pushFollow(FOLLOW_constructor_in_clsdecl399);
            	    c=constructor();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	       target.constructors.add(c); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,BLKEND,FOLLOW_BLKEND_in_clsdecl410); if (state.failed) return ;
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:154:10: ( STMTEND )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==STMTEND) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:0:0: STMTEND
                    {
                    match(input,STMTEND,FOLLOW_STMTEND_in_clsdecl412); if (state.failed) return ;

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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:156:1: field returns [Variable v = new Variable()] : a= accesscontrolkeyword ( 'static' )? ( 'final' )? t= type n= WORD ( EQUAL d= expression )? STMTEND ;
    public final Variable field() throws RecognitionException {
        Variable v =  new Variable();

        Token n=null;
        AccessControlKeyword a = null;

        Type t = null;

        Expression d = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:157:2: (a= accesscontrolkeyword ( 'static' )? ( 'final' )? t= type n= WORD ( EQUAL d= expression )? STMTEND )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:157:4: a= accesscontrolkeyword ( 'static' )? ( 'final' )? t= type n= WORD ( EQUAL d= expression )? STMTEND
            {
            pushFollow(FOLLOW_accesscontrolkeyword_in_field429);
            a=accesscontrolkeyword();

            state._fsp--;
            if (state.failed) return v;
            if ( state.backtracking==0 ) {
              v.access = a;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:158:3: ( 'static' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==45) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:158:4: 'static'
                    {
                    match(input,45,FOLLOW_45_in_field436); if (state.failed) return v;
                    if ( state.backtracking==0 ) {
                      v.isStatic = true;
                    }

                    }
                    break;

            }

            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:159:3: ( 'final' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==46) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:159:4: 'final'
                    {
                    match(input,46,FOLLOW_46_in_field445); if (state.failed) return v;
                    if ( state.backtracking==0 ) {
                      v.isFinal = true;
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_type_in_field455);
            t=type();

            state._fsp--;
            if (state.failed) return v;
            if ( state.backtracking==0 ) {
              v.type = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_field463); if (state.failed) return v;
            if ( state.backtracking==0 ) {
              v.name = n.getText();
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:162:3: ( EQUAL d= expression )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==EQUAL) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:162:4: EQUAL d= expression
                    {
                    match(input,EQUAL,FOLLOW_EQUAL_in_field470); if (state.failed) return v;
                    pushFollow(FOLLOW_expression_in_field474);
                    d=expression();

                    state._fsp--;
                    if (state.failed) return v;
                    if ( state.backtracking==0 ) {
                      v.defaultValue = d;
                    }

                    }
                    break;

            }

            match(input,STMTEND,FOLLOW_STMTEND_in_field482); if (state.failed) return v;

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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:165:1: method returns [Function f = new Function()] : a= accesscontrolkeyword ( 'static' )? ( 'final' )? t= type n= WORD LPAREN l= argumentlist RPAREN b= block ;
    public final Function method() throws RecognitionException {
        Function f =  new Function();

        Token n=null;
        AccessControlKeyword a = null;

        Type t = null;

        Vector<Argument> l = null;

        Block b = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:166:2: (a= accesscontrolkeyword ( 'static' )? ( 'final' )? t= type n= WORD LPAREN l= argumentlist RPAREN b= block )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:166:4: a= accesscontrolkeyword ( 'static' )? ( 'final' )? t= type n= WORD LPAREN l= argumentlist RPAREN b= block
            {
            pushFollow(FOLLOW_accesscontrolkeyword_in_method499);
            a=accesscontrolkeyword();

            state._fsp--;
            if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.access = a;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:167:3: ( 'static' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==45) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:167:4: 'static'
                    {
                    match(input,45,FOLLOW_45_in_method506); if (state.failed) return f;
                    if ( state.backtracking==0 ) {
                      f.isStatic = true;
                    }

                    }
                    break;

            }

            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:168:3: ( 'final' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==46) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:168:4: 'final'
                    {
                    match(input,46,FOLLOW_46_in_method515); if (state.failed) return f;
                    if ( state.backtracking==0 ) {
                      f.isFinal = true;
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_type_in_method525);
            t=type();

            state._fsp--;
            if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.returnType = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_method533); if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.name = n.getText();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_method539); if (state.failed) return f;
            pushFollow(FOLLOW_argumentlist_in_method545);
            l=argumentlist();

            state._fsp--;
            if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.arguments = l;
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_method551); if (state.failed) return f;
            pushFollow(FOLLOW_block_in_method557);
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:176:1: constructor returns [Constructor c = new Constructor()] : a= accesscontrolkeyword 'this' LPAREN l= argumentlist RPAREN ( ':' 'super' LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? b= block ;
    public final Constructor constructor() throws RecognitionException {
        Constructor c =  new Constructor();

        AccessControlKeyword a = null;

        Vector<Argument> l = null;

        Expression e = null;

        Block b = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:177:2: (a= accesscontrolkeyword 'this' LPAREN l= argumentlist RPAREN ( ':' 'super' LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? b= block )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:177:4: a= accesscontrolkeyword 'this' LPAREN l= argumentlist RPAREN ( ':' 'super' LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? b= block
            {
            pushFollow(FOLLOW_accesscontrolkeyword_in_constructor575);
            a=accesscontrolkeyword();

            state._fsp--;
            if (state.failed) return c;
            if ( state.backtracking==0 ) {
              c.access = a;
            }
            match(input,47,FOLLOW_47_in_constructor581); if (state.failed) return c;
            match(input,LPAREN,FOLLOW_LPAREN_in_constructor585); if (state.failed) return c;
            pushFollow(FOLLOW_argumentlist_in_constructor591);
            l=argumentlist();

            state._fsp--;
            if (state.failed) return c;
            if ( state.backtracking==0 ) {
              c.arguments = l;
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_constructor597); if (state.failed) return c;
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:182:3: ( ':' 'super' LPAREN (e= expression ( ',' e= expression )* )? RPAREN )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==48) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:182:4: ':' 'super' LPAREN (e= expression ( ',' e= expression )* )? RPAREN
                    {
                    match(input,48,FOLLOW_48_in_constructor602); if (state.failed) return c;
                    match(input,49,FOLLOW_49_in_constructor604); if (state.failed) return c;
                    if ( state.backtracking==0 ) {
                      c.superArguments = new Vector<Expression>();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_constructor611); if (state.failed) return c;
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:184:4: (e= expression ( ',' e= expression )* )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>=PLUS && LA12_0<=MINUS)||LA12_0==NOT||LA12_0==LPAREN||(LA12_0>=WORD && LA12_0<=DOUBLECONST_PRIVATE)||LA12_0==INTCONST_PRIVATE||LA12_0==47||LA12_0==49||(LA12_0>=61 && LA12_0<=63)||(LA12_0>=75 && LA12_0<=77)) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:184:5: e= expression ( ',' e= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_constructor619);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return c;
                            if ( state.backtracking==0 ) {
                              c.superArguments.add(e);
                            }
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:185:4: ( ',' e= expression )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==50) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:185:5: ',' e= expression
                            	    {
                            	    match(input,50,FOLLOW_50_in_constructor627); if (state.failed) return c;
                            	    pushFollow(FOLLOW_expression_in_constructor631);
                            	    e=expression();

                            	    state._fsp--;
                            	    if (state.failed) return c;
                            	    if ( state.backtracking==0 ) {
                            	      c.superArguments.add(e);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_constructor642); if (state.failed) return c;

                    }
                    break;

            }

            pushFollow(FOLLOW_block_in_constructor650);
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:189:1: argumentlist returns [Vector<Argument> v = new Vector<Argument>()] : (a= argument ( ',' a= argument )* )? ;
    public final Vector<Argument> argumentlist() throws RecognitionException {
        Vector<Argument> v =  new Vector<Argument>();

        Argument a = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:190:2: ( (a= argument ( ',' a= argument )* )? )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:190:4: (a= argument ( ',' a= argument )* )?
            {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:190:4: (a= argument ( ',' a= argument )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==WORD||(LA15_0>=78 && LA15_0<=88)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:190:5: a= argument ( ',' a= argument )*
                    {
                    pushFollow(FOLLOW_argument_in_argumentlist668);
                    a=argument();

                    state._fsp--;
                    if (state.failed) return v;
                    if ( state.backtracking==0 ) {
                      v.add(a);
                    }
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:190:28: ( ',' a= argument )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==50) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:190:29: ',' a= argument
                    	    {
                    	    match(input,50,FOLLOW_50_in_argumentlist673); if (state.failed) return v;
                    	    pushFollow(FOLLOW_argument_in_argumentlist677);
                    	    a=argument();

                    	    state._fsp--;
                    	    if (state.failed) return v;
                    	    if ( state.backtracking==0 ) {
                    	      v.add(a);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:192:1: argument returns [Argument a = new Argument()] : t= type n= WORD ;
    public final Argument argument() throws RecognitionException {
        Argument a =  new Argument();

        Token n=null;
        Type t = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:193:2: (t= type n= WORD )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:193:4: t= type n= WORD
            {
            pushFollow(FOLLOW_type_in_argument699);
            t=type();

            state._fsp--;
            if (state.failed) return a;
            if ( state.backtracking==0 ) {
              a.type = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_argument706); if (state.failed) return a;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:196:1: block returns [Block b = new Block()] : ( BLKBEG (s= stmt )* BLKEND ) ;
    public final Block block() throws RecognitionException {
        Block b =  new Block();

        Leaf s = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:197:2: ( ( BLKBEG (s= stmt )* BLKEND ) )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:197:4: ( BLKBEG (s= stmt )* BLKEND )
            {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:197:4: ( BLKBEG (s= stmt )* BLKEND )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:197:5: BLKBEG (s= stmt )* BLKEND
            {
            match(input,BLKBEG,FOLLOW_BLKBEG_in_block722); if (state.failed) return b;
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:197:12: (s= stmt )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=PLUS && LA16_0<=MINUS)||LA16_0==NOT||LA16_0==STMTEND||LA16_0==BLKBEG||LA16_0==LPAREN||(LA16_0>=WORD && LA16_0<=DOUBLECONST_PRIVATE)||LA16_0==INTCONST_PRIVATE||LA16_0==47||LA16_0==49||(LA16_0>=51 && LA16_0<=53)||(LA16_0>=55 && LA16_0<=57)||(LA16_0>=59 && LA16_0<=63)||(LA16_0>=75 && LA16_0<=88)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:197:13: s= stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_block727);
            	    s=stmt();

            	    state._fsp--;
            	    if (state.failed) return b;
            	    if ( state.backtracking==0 ) {
            	      b.content.add(s);
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            match(input,BLKEND,FOLLOW_BLKEND_in_block733); if (state.failed) return b;

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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:199:1: stmt returns [Leaf l = null] : ( (e= declAssign ) | (a= expression STMTEND ) | (b= returnstmt ) | (t= throwstmt ) | (c= ifstmt ) | (w= whilestmt ) | (f= forstmt ) | (d= block ) | (tr= trystmt ) | ( 'break' STMTEND ) | ( 'continue' STMTEND ) | STMTEND );
    public final Leaf stmt() throws RecognitionException {
        Leaf l =  null;

        DeclAssign e = null;

        Expression a = null;

        ReturnStatement b = null;

        ThrowStatement t = null;

        IfStatement c = null;

        WhileStatement w = null;

        ForStatement f = null;

        Block d = null;

        TryStatement tr = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:200:2: ( (e= declAssign ) | (a= expression STMTEND ) | (b= returnstmt ) | (t= throwstmt ) | (c= ifstmt ) | (w= whilestmt ) | (f= forstmt ) | (d= block ) | (tr= trystmt ) | ( 'break' STMTEND ) | ( 'continue' STMTEND ) | STMTEND )
            int alt17=12;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:200:4: (e= declAssign )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:200:4: (e= declAssign )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:200:5: e= declAssign
                    {
                    pushFollow(FOLLOW_declAssign_in_stmt751);
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
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:201:4: (a= expression STMTEND )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:201:4: (a= expression STMTEND )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:201:5: a= expression STMTEND
                    {
                    pushFollow(FOLLOW_expression_in_stmt762);
                    a=expression();

                    state._fsp--;
                    if (state.failed) return l;
                    match(input,STMTEND,FOLLOW_STMTEND_in_stmt764); if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=a;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:202:4: (b= returnstmt )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:202:4: (b= returnstmt )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:202:5: b= returnstmt
                    {
                    pushFollow(FOLLOW_returnstmt_in_stmt775);
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
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:203:4: (t= throwstmt )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:203:4: (t= throwstmt )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:203:5: t= throwstmt
                    {
                    pushFollow(FOLLOW_throwstmt_in_stmt786);
                    t=throwstmt();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=t;
                    }

                    }


                    }
                    break;
                case 5 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:204:4: (c= ifstmt )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:204:4: (c= ifstmt )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:204:5: c= ifstmt
                    {
                    pushFollow(FOLLOW_ifstmt_in_stmt797);
                    c=ifstmt();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=c;
                    }

                    }


                    }
                    break;
                case 6 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:205:4: (w= whilestmt )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:205:4: (w= whilestmt )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:205:5: w= whilestmt
                    {
                    pushFollow(FOLLOW_whilestmt_in_stmt808);
                    w=whilestmt();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=w;
                    }

                    }


                    }
                    break;
                case 7 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:206:4: (f= forstmt )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:206:4: (f= forstmt )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:206:5: f= forstmt
                    {
                    pushFollow(FOLLOW_forstmt_in_stmt819);
                    f=forstmt();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=f;
                    }

                    }


                    }
                    break;
                case 8 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:207:4: (d= block )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:207:4: (d= block )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:207:5: d= block
                    {
                    pushFollow(FOLLOW_block_in_stmt830);
                    d=block();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=d;
                    }

                    }


                    }
                    break;
                case 9 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:208:4: (tr= trystmt )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:208:4: (tr= trystmt )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:208:5: tr= trystmt
                    {
                    pushFollow(FOLLOW_trystmt_in_stmt841);
                    tr=trystmt();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=tr;
                    }

                    }


                    }
                    break;
                case 10 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:209:4: ( 'break' STMTEND )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:209:4: ( 'break' STMTEND )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:209:5: 'break' STMTEND
                    {
                    match(input,51,FOLLOW_51_in_stmt850); if (state.failed) return l;
                    match(input,STMTEND,FOLLOW_STMTEND_in_stmt852); if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=new BreakStatement();
                    }

                    }


                    }
                    break;
                case 11 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:210:4: ( 'continue' STMTEND )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:210:4: ( 'continue' STMTEND )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:210:5: 'continue' STMTEND
                    {
                    match(input,52,FOLLOW_52_in_stmt861); if (state.failed) return l;
                    match(input,STMTEND,FOLLOW_STMTEND_in_stmt863); if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=new ContinueStatement();
                    }

                    }


                    }
                    break;
                case 12 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:211:4: STMTEND
                    {
                    match(input,STMTEND,FOLLOW_STMTEND_in_stmt871); if (state.failed) return l;

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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:213:1: ifstmt returns [IfStatement ifCase = new IfStatement()] : 'if' LPAREN s= expression RPAREN q= stmt ( 'else' e= stmt )? ;
    public final IfStatement ifstmt() throws RecognitionException {
        IfStatement ifCase =  new IfStatement();

        Expression s = null;

        Leaf q = null;

        Leaf e = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:214:2: ( 'if' LPAREN s= expression RPAREN q= stmt ( 'else' e= stmt )? )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:214:4: 'if' LPAREN s= expression RPAREN q= stmt ( 'else' e= stmt )?
            {
            match(input,53,FOLLOW_53_in_ifstmt885); if (state.failed) return ifCase;
            match(input,LPAREN,FOLLOW_LPAREN_in_ifstmt887); if (state.failed) return ifCase;
            pushFollow(FOLLOW_expression_in_ifstmt891);
            s=expression();

            state._fsp--;
            if (state.failed) return ifCase;
            if ( state.backtracking==0 ) {
              ifCase.condition = s;
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_ifstmt895); if (state.failed) return ifCase;
            pushFollow(FOLLOW_stmt_in_ifstmt901);
            q=stmt();

            state._fsp--;
            if (state.failed) return ifCase;
            if ( state.backtracking==0 ) {
              ifCase.then = q;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:216:3: ( 'else' e= stmt )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==54) ) {
                int LA18_1 = input.LA(2);

                if ( (synpred30_PineDL()) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:216:4: 'else' e= stmt
                    {
                    match(input,54,FOLLOW_54_in_ifstmt908); if (state.failed) return ifCase;
                    pushFollow(FOLLOW_stmt_in_ifstmt912);
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:218:1: whilestmt returns [WhileStatement whileCase = new WhileStatement()] : 'while' LPAREN s= expression RPAREN q= stmt ;
    public final WhileStatement whilestmt() throws RecognitionException {
        WhileStatement whileCase =  new WhileStatement();

        Expression s = null;

        Leaf q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:219:2: ( 'while' LPAREN s= expression RPAREN q= stmt )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:219:4: 'while' LPAREN s= expression RPAREN q= stmt
            {
            match(input,55,FOLLOW_55_in_whilestmt931); if (state.failed) return whileCase;
            match(input,LPAREN,FOLLOW_LPAREN_in_whilestmt933); if (state.failed) return whileCase;
            pushFollow(FOLLOW_expression_in_whilestmt937);
            s=expression();

            state._fsp--;
            if (state.failed) return whileCase;
            if ( state.backtracking==0 ) {
              whileCase.condition = s;
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_whilestmt941); if (state.failed) return whileCase;
            pushFollow(FOLLOW_stmt_in_whilestmt947);
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:222:1: forstmt returns [ForStatement forCase = new ForStatement()] : 'for' LPAREN ( (a= expression STMTEND ) | b= declAssign | STMTEND ) (s= expression ) STMTEND (d= expression ) RPAREN q= stmt ;
    public final ForStatement forstmt() throws RecognitionException {
        ForStatement forCase =  new ForStatement();

        Expression a = null;

        DeclAssign b = null;

        Expression s = null;

        Expression d = null;

        Leaf q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:223:2: ( 'for' LPAREN ( (a= expression STMTEND ) | b= declAssign | STMTEND ) (s= expression ) STMTEND (d= expression ) RPAREN q= stmt )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:223:4: 'for' LPAREN ( (a= expression STMTEND ) | b= declAssign | STMTEND ) (s= expression ) STMTEND (d= expression ) RPAREN q= stmt
            {
            match(input,56,FOLLOW_56_in_forstmt964); if (state.failed) return forCase;
            match(input,LPAREN,FOLLOW_LPAREN_in_forstmt966); if (state.failed) return forCase;
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:223:17: ( (a= expression STMTEND ) | b= declAssign | STMTEND )
            int alt19=3;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:223:18: (a= expression STMTEND )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:223:18: (a= expression STMTEND )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:223:19: a= expression STMTEND
                    {
                    pushFollow(FOLLOW_expression_in_forstmt972);
                    a=expression();

                    state._fsp--;
                    if (state.failed) return forCase;
                    if ( state.backtracking==0 ) {
                      forCase.firstStatement = a;
                    }
                    match(input,STMTEND,FOLLOW_STMTEND_in_forstmt976); if (state.failed) return forCase;

                    }


                    }
                    break;
                case 2 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:223:71: b= declAssign
                    {
                    pushFollow(FOLLOW_declAssign_in_forstmt981);
                    b=declAssign();

                    state._fsp--;
                    if (state.failed) return forCase;
                    if ( state.backtracking==0 ) {
                      forCase.firstStatement = b;
                    }

                    }
                    break;
                case 3 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:223:114: STMTEND
                    {
                    match(input,STMTEND,FOLLOW_STMTEND_in_forstmt985); if (state.failed) return forCase;

                    }
                    break;

            }

            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:224:3: (s= expression )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:224:4: s= expression
            {
            pushFollow(FOLLOW_expression_in_forstmt993);
            s=expression();

            state._fsp--;
            if (state.failed) return forCase;
            if ( state.backtracking==0 ) {
              forCase.condition = s;
            }

            }

            match(input,STMTEND,FOLLOW_STMTEND_in_forstmt998); if (state.failed) return forCase;
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:225:3: (d= expression )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:225:4: d= expression
            {
            pushFollow(FOLLOW_expression_in_forstmt1005);
            d=expression();

            state._fsp--;
            if (state.failed) return forCase;
            if ( state.backtracking==0 ) {
              forCase.loopStatement = d;
            }

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_forstmt1010); if (state.failed) return forCase;
            pushFollow(FOLLOW_stmt_in_forstmt1016);
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


    // $ANTLR start "trystmt"
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:228:1: trystmt returns [TryStatement tryStmt = new TryStatement()] : 'try' b= stmt ( 'catch' LPAREN t= type n= WORD RPAREN b= stmt )+ ;
    public final TryStatement trystmt() throws RecognitionException {
        TryStatement tryStmt =  new TryStatement();

        Token n=null;
        Leaf b = null;

        Type t = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:229:2: ( 'try' b= stmt ( 'catch' LPAREN t= type n= WORD RPAREN b= stmt )+ )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:229:4: 'try' b= stmt ( 'catch' LPAREN t= type n= WORD RPAREN b= stmt )+
            {
            match(input,57,FOLLOW_57_in_trystmt1031); if (state.failed) return tryStmt;
            pushFollow(FOLLOW_stmt_in_trystmt1035);
            b=stmt();

            state._fsp--;
            if (state.failed) return tryStmt;
            if ( state.backtracking==0 ) {
              tryStmt.then = b;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:230:2: ( 'catch' LPAREN t= type n= WORD RPAREN b= stmt )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==58) ) {
                    int LA20_2 = input.LA(2);

                    if ( (synpred33_PineDL()) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:230:3: 'catch' LPAREN t= type n= WORD RPAREN b= stmt
            	    {
            	    match(input,58,FOLLOW_58_in_trystmt1041); if (state.failed) return tryStmt;
            	    match(input,LPAREN,FOLLOW_LPAREN_in_trystmt1043); if (state.failed) return tryStmt;
            	    pushFollow(FOLLOW_type_in_trystmt1047);
            	    t=type();

            	    state._fsp--;
            	    if (state.failed) return tryStmt;
            	    n=(Token)match(input,WORD,FOLLOW_WORD_in_trystmt1051); if (state.failed) return tryStmt;
            	    match(input,RPAREN,FOLLOW_RPAREN_in_trystmt1053); if (state.failed) return tryStmt;
            	    pushFollow(FOLLOW_stmt_in_trystmt1057);
            	    b=stmt();

            	    state._fsp--;
            	    if (state.failed) return tryStmt;
            	    if ( state.backtracking==0 ) {
            	      Catch c = new Catch(); c.t = t; c.name = n.getText(); c.then = b; tryStmt.catchStmt.add(c);
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return tryStmt;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tryStmt;
    }
    // $ANTLR end "trystmt"


    // $ANTLR start "returnstmt"
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:232:1: returnstmt returns [ReturnStatement ret = new ReturnStatement()] : 'return' (r= expression )? STMTEND ;
    public final ReturnStatement returnstmt() throws RecognitionException {
        ReturnStatement ret =  new ReturnStatement();

        Expression r = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:233:2: ( 'return' (r= expression )? STMTEND )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:233:4: 'return' (r= expression )? STMTEND
            {
            match(input,59,FOLLOW_59_in_returnstmt1075); if (state.failed) return ret;
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:233:13: (r= expression )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=PLUS && LA21_0<=MINUS)||LA21_0==NOT||LA21_0==LPAREN||(LA21_0>=WORD && LA21_0<=DOUBLECONST_PRIVATE)||LA21_0==INTCONST_PRIVATE||LA21_0==47||LA21_0==49||(LA21_0>=61 && LA21_0<=63)||(LA21_0>=75 && LA21_0<=77)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:233:14: r= expression
                    {
                    pushFollow(FOLLOW_expression_in_returnstmt1080);
                    r=expression();

                    state._fsp--;
                    if (state.failed) return ret;
                    if ( state.backtracking==0 ) {
                      ret.value = r;
                    }

                    }
                    break;

            }

            match(input,STMTEND,FOLLOW_STMTEND_in_returnstmt1086); if (state.failed) return ret;

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


    // $ANTLR start "throwstmt"
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:235:1: throwstmt returns [ThrowStatement ret = new ThrowStatement()] : 'throw' (r= expression )? STMTEND ;
    public final ThrowStatement throwstmt() throws RecognitionException {
        ThrowStatement ret =  new ThrowStatement();

        Expression r = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:236:2: ( 'throw' (r= expression )? STMTEND )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:236:4: 'throw' (r= expression )? STMTEND
            {
            match(input,60,FOLLOW_60_in_throwstmt1100); if (state.failed) return ret;
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:236:12: (r= expression )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=PLUS && LA22_0<=MINUS)||LA22_0==NOT||LA22_0==LPAREN||(LA22_0>=WORD && LA22_0<=DOUBLECONST_PRIVATE)||LA22_0==INTCONST_PRIVATE||LA22_0==47||LA22_0==49||(LA22_0>=61 && LA22_0<=63)||(LA22_0>=75 && LA22_0<=77)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:236:13: r= expression
                    {
                    pushFollow(FOLLOW_expression_in_throwstmt1105);
                    r=expression();

                    state._fsp--;
                    if (state.failed) return ret;
                    if ( state.backtracking==0 ) {
                      ret.value = r;
                    }

                    }
                    break;

            }

            match(input,STMTEND,FOLLOW_STMTEND_in_throwstmt1111); if (state.failed) return ret;

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
    // $ANTLR end "throwstmt"


    // $ANTLR start "declAssign"
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:238:1: declAssign returns [DeclAssign e = new DeclAssign()] : t= type n= WORD ( '=' ex= expression )? STMTEND ;
    public final DeclAssign declAssign() throws RecognitionException {
        DeclAssign e =  new DeclAssign();

        Token n=null;
        Type t = null;

        Expression ex = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:239:2: (t= type n= WORD ( '=' ex= expression )? STMTEND )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:239:4: t= type n= WORD ( '=' ex= expression )? STMTEND
            {
            pushFollow(FOLLOW_type_in_declAssign1127);
            t=type();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e.type = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_declAssign1133); if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e.name = n.getText();
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:239:56: ( '=' ex= expression )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==EQUAL) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:239:57: '=' ex= expression
                    {
                    match(input,EQUAL,FOLLOW_EQUAL_in_declAssign1138); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_declAssign1142);
                    ex=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e.value=ex;
                    }

                    }
                    break;

            }

            match(input,STMTEND,FOLLOW_STMTEND_in_declAssign1148); if (state.failed) return e;

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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:241:1: pkgname returns [String s = null] : (c= WORD ( '.' t= WORD )* ) ;
    public final String pkgname() throws RecognitionException {
        String s =  null;

        Token c=null;
        Token t=null;

        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:242:2: ( (c= WORD ( '.' t= WORD )* ) )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:242:4: (c= WORD ( '.' t= WORD )* )
            {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:242:4: (c= WORD ( '.' t= WORD )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:242:5: c= WORD ( '.' t= WORD )*
            {
            c=(Token)match(input,WORD,FOLLOW_WORD_in_pkgname1164); if (state.failed) return s;
            if ( state.backtracking==0 ) {
              s = c.getText();
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:242:31: ( '.' t= WORD )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==DOT) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:242:32: '.' t= WORD
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_pkgname1169); if (state.failed) return s;
            	    t=(Token)match(input,WORD,FOLLOW_WORD_in_pkgname1173); if (state.failed) return s;
            	    if ( state.backtracking==0 ) {
            	      s += "." + t.getText();
            	    }

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:244:1: reference returns [Reference r = null] : ref= ( WORD | 'this' | 'super' ) ( LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? ( LARRAY e= expression RARRAY )* ;
    public final Reference reference() throws RecognitionException {
        Reference r =  null;

        Token ref=null;
        Expression e = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:245:2: (ref= ( WORD | 'this' | 'super' ) ( LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? ( LARRAY e= expression RARRAY )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:245:4: ref= ( WORD | 'this' | 'super' ) ( LPAREN (e= expression ( ',' e= expression )* )? RPAREN )? ( LARRAY e= expression RARRAY )*
            {
            ref=(Token)input.LT(1);
            if ( input.LA(1)==WORD||input.LA(1)==47||input.LA(1)==49 ) {
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
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:246:2: ( LPAREN (e= expression ( ',' e= expression )* )? RPAREN )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LPAREN) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:246:3: LPAREN (e= expression ( ',' e= expression )* )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_reference1205); if (state.failed) return r;
                    if ( state.backtracking==0 ) {
                      r = new FunctionReference(ref.getText());
                    }
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:247:3: (e= expression ( ',' e= expression )* )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0>=PLUS && LA26_0<=MINUS)||LA26_0==NOT||LA26_0==LPAREN||(LA26_0>=WORD && LA26_0<=DOUBLECONST_PRIVATE)||LA26_0==INTCONST_PRIVATE||LA26_0==47||LA26_0==49||(LA26_0>=61 && LA26_0<=63)||(LA26_0>=75 && LA26_0<=77)) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:247:4: e= expression ( ',' e= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_reference1214);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return r;
                            if ( state.backtracking==0 ) {
                              ((FunctionReference) r).arguments.add(e);
                            }
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:248:4: ( ',' e= expression )*
                            loop25:
                            do {
                                int alt25=2;
                                int LA25_0 = input.LA(1);

                                if ( (LA25_0==50) ) {
                                    alt25=1;
                                }


                                switch (alt25) {
                            	case 1 :
                            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:248:5: ',' e= expression
                            	    {
                            	    match(input,50,FOLLOW_50_in_reference1222); if (state.failed) return r;
                            	    pushFollow(FOLLOW_expression_in_reference1226);
                            	    e=expression();

                            	    state._fsp--;
                            	    if (state.failed) return r;
                            	    if ( state.backtracking==0 ) {
                            	      ((FunctionReference) r).arguments.add(e);
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

                    match(input,RPAREN,FOLLOW_RPAREN_in_reference1238); if (state.failed) return r;

                    }
                    break;

            }

            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:251:2: ( LARRAY e= expression RARRAY )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==LARRAY) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:251:3: LARRAY e= expression RARRAY
            	    {
            	    match(input,LARRAY,FOLLOW_LARRAY_in_reference1244); if (state.failed) return r;
            	    pushFollow(FOLLOW_expression_in_reference1248);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      r = new ArrayReference(r, e);
            	    }
            	    match(input,RARRAY,FOLLOW_RARRAY_in_reference1252); if (state.failed) return r;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:253:1: constant returns [Constant c = null] : ( (i= intconst ) | (d= doubleconst ) | (b= boolconst ) | (s= stringconst ) | (n= nullconst ) );
    public final Constant constant() throws RecognitionException {
        Constant c =  null;

        IntConstant i = null;

        DoubleConstant d = null;

        BooleanConstant b = null;

        StringConstant s = null;

        NullConstant n = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:2: ( (i= intconst ) | (d= doubleconst ) | (b= boolconst ) | (s= stringconst ) | (n= nullconst ) )
            int alt29=5;
            switch ( input.LA(1) ) {
            case INTCONST_PRIVATE:
                {
                alt29=1;
                }
                break;
            case DOUBLECONST_PRIVATE:
                {
                alt29=2;
                }
                break;
            case 76:
            case 77:
                {
                alt29=3;
                }
                break;
            case STRINGCONST_PRIVATE:
                {
                alt29=4;
                }
                break;
            case 75:
                {
                alt29=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return c;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:4: (i= intconst )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:4: (i= intconst )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:5: i= intconst
                    {
                    pushFollow(FOLLOW_intconst_in_constant1270);
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
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:24: (d= doubleconst )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:24: (d= doubleconst )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:25: d= doubleconst
                    {
                    pushFollow(FOLLOW_doubleconst_in_constant1278);
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
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:47: (b= boolconst )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:47: (b= boolconst )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:48: b= boolconst
                    {
                    pushFollow(FOLLOW_boolconst_in_constant1286);
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
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:68: (s= stringconst )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:68: (s= stringconst )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:69: s= stringconst
                    {
                    pushFollow(FOLLOW_stringconst_in_constant1294);
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
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:91: (n= nullconst )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:91: (n= nullconst )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:254:92: n= nullconst
                    {
                    pushFollow(FOLLOW_nullconst_in_constant1302);
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:258:1: primitive returns [Expression e = null] : ( ( MINUS | PLUS )? c= constant | ( MINUS | PLUS )? (r= reference ( '.' b= reference )* ) | ( LPAREN x= expression RPAREN ) | ( 'new' t= clstype ( MINUS | PLUS )? LPAREN (ex= expression ( ',' ex= expression )* )? RPAREN ) | ( 'new' t= clstype '[' x= expression ']' ) );
    public final Expression primitive() throws RecognitionException {
        Expression e =  null;

        Constant c = null;

        Reference r = null;

        Reference b = null;

        Expression x = null;

        Type t = null;

        Expression ex = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:259:2: ( ( MINUS | PLUS )? c= constant | ( MINUS | PLUS )? (r= reference ( '.' b= reference )* ) | ( LPAREN x= expression RPAREN ) | ( 'new' t= clstype ( MINUS | PLUS )? LPAREN (ex= expression ( ',' ex= expression )* )? RPAREN ) | ( 'new' t= clstype '[' x= expression ']' ) )
            int alt36=5;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:259:4: ( MINUS | PLUS )? c= constant
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:259:4: ( MINUS | PLUS )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( ((LA30_0>=PLUS && LA30_0<=MINUS)) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:
                            {
                            if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                                input.consume();
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return e;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }

                    pushFollow(FOLLOW_constant_in_primitive1329);
                    c=constant();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=c;
                    }

                    }
                    break;
                case 2 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:259:37: ( MINUS | PLUS )? (r= reference ( '.' b= reference )* )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:259:37: ( MINUS | PLUS )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( ((LA31_0>=PLUS && LA31_0<=MINUS)) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:
                            {
                            if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                                input.consume();
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return e;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }

                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:259:51: (r= reference ( '.' b= reference )* )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:259:52: r= reference ( '.' b= reference )*
                    {
                    pushFollow(FOLLOW_reference_in_primitive1344);
                    r=reference();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=r;
                    }
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:259:71: ( '.' b= reference )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==DOT) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:259:72: '.' b= reference
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_primitive1349); if (state.failed) return e;
                    	    pushFollow(FOLLOW_reference_in_primitive1353);
                    	    b=reference();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      e=new RetrieverExpression((Reference) e, b);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:260:5: ( LPAREN x= expression RPAREN )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:260:5: ( LPAREN x= expression RPAREN )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:260:6: LPAREN x= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primitive1365); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_primitive1369);
                    x=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=x;
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primitive1373); if (state.failed) return e;

                    }


                    }
                    break;
                case 4 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:260:41: ( 'new' t= clstype ( MINUS | PLUS )? LPAREN (ex= expression ( ',' ex= expression )* )? RPAREN )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:260:41: ( 'new' t= clstype ( MINUS | PLUS )? LPAREN (ex= expression ( ',' ex= expression )* )? RPAREN )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:260:42: 'new' t= clstype ( MINUS | PLUS )? LPAREN (ex= expression ( ',' ex= expression )* )? RPAREN
                    {
                    match(input,61,FOLLOW_61_in_primitive1377); if (state.failed) return e;
                    pushFollow(FOLLOW_clstype_in_primitive1381);
                    t=clstype();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=new NewCall(t);
                    }
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:261:3: ( MINUS | PLUS )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=PLUS && LA33_0<=MINUS)) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:
                            {
                            if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                                input.consume();
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return e;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }

                    match(input,LPAREN,FOLLOW_LPAREN_in_primitive1394); if (state.failed) return e;
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:262:3: (ex= expression ( ',' ex= expression )* )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( ((LA35_0>=PLUS && LA35_0<=MINUS)||LA35_0==NOT||LA35_0==LPAREN||(LA35_0>=WORD && LA35_0<=DOUBLECONST_PRIVATE)||LA35_0==INTCONST_PRIVATE||LA35_0==47||LA35_0==49||(LA35_0>=61 && LA35_0<=63)||(LA35_0>=75 && LA35_0<=77)) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:262:4: ex= expression ( ',' ex= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_primitive1401);
                            ex=expression();

                            state._fsp--;
                            if (state.failed) return e;
                            if ( state.backtracking==0 ) {
                              ((NewCall) e).arguments.add(ex);
                            }
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:263:4: ( ',' ex= expression )*
                            loop34:
                            do {
                                int alt34=2;
                                int LA34_0 = input.LA(1);

                                if ( (LA34_0==50) ) {
                                    alt34=1;
                                }


                                switch (alt34) {
                            	case 1 :
                            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:263:5: ',' ex= expression
                            	    {
                            	    match(input,50,FOLLOW_50_in_primitive1409); if (state.failed) return e;
                            	    pushFollow(FOLLOW_expression_in_primitive1413);
                            	    ex=expression();

                            	    state._fsp--;
                            	    if (state.failed) return e;
                            	    if ( state.backtracking==0 ) {
                            	      ((NewCall) e).arguments.add(ex);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop34;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_primitive1424); if (state.failed) return e;

                    }


                    }
                    break;
                case 5 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:265:5: ( 'new' t= clstype '[' x= expression ']' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:265:5: ( 'new' t= clstype '[' x= expression ']' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:265:6: 'new' t= clstype '[' x= expression ']'
                    {
                    match(input,61,FOLLOW_61_in_primitive1432); if (state.failed) return e;
                    pushFollow(FOLLOW_clstype_in_primitive1436);
                    t=clstype();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,LARRAY,FOLLOW_LARRAY_in_primitive1438); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_primitive1442);
                    x=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,RARRAY,FOLLOW_RARRAY_in_primitive1444); if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=new NewArray(t, x);
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
    // $ANTLR end "primitive"


    // $ANTLR start "prepostop"
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:267:1: prepostop returns [Expression e = null] : ( (p= primitive ( '++' | '--' )? ) | ( '++' q= primitive ) | ( '--' q= primitive ) );
    public final Expression prepostop() throws RecognitionException {
        Expression e =  null;

        Expression p = null;

        Expression q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:268:2: ( (p= primitive ( '++' | '--' )? ) | ( '++' q= primitive ) | ( '--' q= primitive ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case PLUS:
            case MINUS:
            case LPAREN:
            case WORD:
            case STRINGCONST_PRIVATE:
            case DOUBLECONST_PRIVATE:
            case INTCONST_PRIVATE:
            case 47:
            case 49:
            case 61:
            case 75:
            case 76:
            case 77:
                {
                alt38=1;
                }
                break;
            case 62:
                {
                alt38=2;
                }
                break;
            case 63:
                {
                alt38=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:268:4: (p= primitive ( '++' | '--' )? )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:268:4: (p= primitive ( '++' | '--' )? )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:268:5: p= primitive ( '++' | '--' )?
                    {
                    pushFollow(FOLLOW_primitive_in_prepostop1465);
                    p=primitive();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=p;
                    }
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:269:2: ( '++' | '--' )?
                    int alt37=3;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==62) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==63) ) {
                        alt37=2;
                    }
                    switch (alt37) {
                        case 1 :
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:269:3: '++'
                            {
                            match(input,62,FOLLOW_62_in_prepostop1471); if (state.failed) return e;
                            if ( state.backtracking==0 ) {
                              e=new PrePostFixOperator(false, true, e);
                            }

                            }
                            break;
                        case 2 :
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:269:52: '--'
                            {
                            match(input,63,FOLLOW_63_in_prepostop1475); if (state.failed) return e;
                            if ( state.backtracking==0 ) {
                              e=new PrePostFixOperator(false, false, e);
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:270:4: ( '++' q= primitive )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:270:4: ( '++' q= primitive )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:270:5: '++' q= primitive
                    {
                    match(input,62,FOLLOW_62_in_prepostop1486); if (state.failed) return e;
                    pushFollow(FOLLOW_primitive_in_prepostop1490);
                    q=primitive();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=new PrePostFixOperator(true, true, q);
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:271:4: ( '--' q= primitive )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:271:4: ( '--' q= primitive )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:271:5: '--' q= primitive
                    {
                    match(input,63,FOLLOW_63_in_prepostop1499); if (state.failed) return e;
                    pushFollow(FOLLOW_primitive_in_prepostop1503);
                    q=primitive();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=new PrePostFixOperator(true, false, q);
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
    // $ANTLR end "prepostop"


    // $ANTLR start "notcastexpr"
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:273:1: notcastexpr returns [Expression e = null] : ( (p= prepostop ) | ( NOT p= notcastexpr ) | ( LPAREN t= type RPAREN p= notcastexpr ) );
    public final Expression notcastexpr() throws RecognitionException {
        Expression e =  null;

        Expression p = null;

        Type t = null;



        TypeCast cast = null;

        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:277:2: ( (p= prepostop ) | ( NOT p= notcastexpr ) | ( LPAREN t= type RPAREN p= notcastexpr ) )
            int alt39=3;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:277:4: (p= prepostop )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:277:4: (p= prepostop )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:277:5: p= prepostop
                    {
                    pushFollow(FOLLOW_prepostop_in_notcastexpr1527);
                    p=prepostop();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=p;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:278:5: ( NOT p= notcastexpr )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:278:5: ( NOT p= notcastexpr )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:278:6: NOT p= notcastexpr
                    {
                    match(input,NOT,FOLLOW_NOT_in_notcastexpr1537); if (state.failed) return e;
                    pushFollow(FOLLOW_notcastexpr_in_notcastexpr1541);
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
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:279:5: ( LPAREN t= type RPAREN p= notcastexpr )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:279:5: ( LPAREN t= type RPAREN p= notcastexpr )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:279:6: LPAREN t= type RPAREN p= notcastexpr
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_notcastexpr1551); if (state.failed) return e;
                    pushFollow(FOLLOW_type_in_notcastexpr1555);
                    t=type();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,RPAREN,FOLLOW_RPAREN_in_notcastexpr1557); if (state.failed) return e;
                    pushFollow(FOLLOW_notcastexpr_in_notcastexpr1561);
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:1: multop returns [Expression e = null] : t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )* ;
    public final Expression multop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:282:2: (t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:282:4: t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )*
            {
            pushFollow(FOLLOW_notcastexpr_in_multop1581);
            t=notcastexpr();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:282:25: ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=MULT && LA41_0<=MOD)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:283:2: ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr )
            	    {
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:283:2: ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr )
            	    int alt40=3;
            	    switch ( input.LA(1) ) {
            	    case MULT:
            	        {
            	        alt40=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt40=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt40=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 40, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt40) {
            	        case 1 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:283:3: MULT q= notcastexpr
            	            {
            	            match(input,MULT,FOLLOW_MULT_in_multop1589); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_multop1593);
            	            q=notcastexpr();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new MultiplyOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:284:3: DIV q= notcastexpr
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_multop1599); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_multop1603);
            	            q=notcastexpr();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new DivisionOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:285:3: MOD q= notcastexpr
            	            {
            	            match(input,MOD,FOLLOW_MOD_in_multop1609); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_multop1613);
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
    // $ANTLR end "multop"


    // $ANTLR start "sumop"
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:288:1: sumop returns [Expression e = null] : t= multop ( ( PLUS q= multop | MINUS q= multop ) )* ;
    public final Expression sumop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:289:2: (t= multop ( ( PLUS q= multop | MINUS q= multop ) )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:289:4: t= multop ( ( PLUS q= multop | MINUS q= multop ) )*
            {
            pushFollow(FOLLOW_multop_in_sumop1635);
            t=multop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:289:20: ( ( PLUS q= multop | MINUS q= multop ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=PLUS && LA43_0<=MINUS)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:290:2: ( PLUS q= multop | MINUS q= multop )
            	    {
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:290:2: ( PLUS q= multop | MINUS q= multop )
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0==PLUS) ) {
            	        alt42=1;
            	    }
            	    else if ( (LA42_0==MINUS) ) {
            	        alt42=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:290:3: PLUS q= multop
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_sumop1643); if (state.failed) return e;
            	            pushFollow(FOLLOW_multop_in_sumop1647);
            	            q=multop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new SumOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:291:3: MINUS q= multop
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_sumop1653); if (state.failed) return e;
            	            pushFollow(FOLLOW_multop_in_sumop1657);
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
    // $ANTLR end "sumop"


    // $ANTLR start "shiftop"
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:294:1: shiftop returns [Expression e = null] : t= sumop ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )* ;
    public final Expression shiftop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:295:2: (t= sumop ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:295:4: t= sumop ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )*
            {
            pushFollow(FOLLOW_sumop_in_shiftop1679);
            t=sumop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:295:19: ( ( RSHIFT q= sumop | LSHIFT q= sumop ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=RSHIFT && LA45_0<=LSHIFT)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:296:2: ( RSHIFT q= sumop | LSHIFT q= sumop )
            	    {
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:296:2: ( RSHIFT q= sumop | LSHIFT q= sumop )
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==RSHIFT) ) {
            	        alt44=1;
            	    }
            	    else if ( (LA44_0==LSHIFT) ) {
            	        alt44=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 44, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:296:3: RSHIFT q= sumop
            	            {
            	            match(input,RSHIFT,FOLLOW_RSHIFT_in_shiftop1687); if (state.failed) return e;
            	            pushFollow(FOLLOW_sumop_in_shiftop1691);
            	            q=sumop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new RShiftOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:297:3: LSHIFT q= sumop
            	            {
            	            match(input,LSHIFT,FOLLOW_LSHIFT_in_shiftop1697); if (state.failed) return e;
            	            pushFollow(FOLLOW_sumop_in_shiftop1701);
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
            	    break loop45;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:300:1: compop returns [Expression e = null] : t= shiftop ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )* ;
    public final Expression compop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:301:2: (t= shiftop ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:301:4: t= shiftop ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )*
            {
            pushFollow(FOLLOW_shiftop_in_compop1724);
            t=shiftop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:301:21: ( ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=LESS && LA47_0<=MOREEQ)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:302:2: ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop )
            	    {
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:302:2: ( LESS q= shiftop | MORE q= shiftop | LESSEQ q= shiftop | MOREEQ q= shiftop )
            	    int alt46=4;
            	    switch ( input.LA(1) ) {
            	    case LESS:
            	        {
            	        alt46=1;
            	        }
            	        break;
            	    case MORE:
            	        {
            	        alt46=2;
            	        }
            	        break;
            	    case LESSEQ:
            	        {
            	        alt46=3;
            	        }
            	        break;
            	    case MOREEQ:
            	        {
            	        alt46=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 46, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt46) {
            	        case 1 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:302:3: LESS q= shiftop
            	            {
            	            match(input,LESS,FOLLOW_LESS_in_compop1732); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1736);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new LessOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:303:3: MORE q= shiftop
            	            {
            	            match(input,MORE,FOLLOW_MORE_in_compop1742); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1746);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new MoreOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:304:3: LESSEQ q= shiftop
            	            {
            	            match(input,LESSEQ,FOLLOW_LESSEQ_in_compop1752); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1756);
            	            q=shiftop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new LessEqualOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:305:3: MOREEQ q= shiftop
            	            {
            	            match(input,MOREEQ,FOLLOW_MOREEQ_in_compop1762); if (state.failed) return e;
            	            pushFollow(FOLLOW_shiftop_in_compop1766);
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
            	    break loop47;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:308:1: comp2op returns [Expression e = null] : t= compop ( ( EQUALS q= compop | NEQUAL q= compop ) )* ;
    public final Expression comp2op() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:309:2: (t= compop ( ( EQUALS q= compop | NEQUAL q= compop ) )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:309:4: t= compop ( ( EQUALS q= compop | NEQUAL q= compop ) )*
            {
            pushFollow(FOLLOW_compop_in_comp2op1789);
            t=compop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:309:20: ( ( EQUALS q= compop | NEQUAL q= compop ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=EQUALS && LA49_0<=NEQUAL)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:310:2: ( EQUALS q= compop | NEQUAL q= compop )
            	    {
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:310:2: ( EQUALS q= compop | NEQUAL q= compop )
            	    int alt48=2;
            	    int LA48_0 = input.LA(1);

            	    if ( (LA48_0==EQUALS) ) {
            	        alt48=1;
            	    }
            	    else if ( (LA48_0==NEQUAL) ) {
            	        alt48=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 48, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt48) {
            	        case 1 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:310:3: EQUALS q= compop
            	            {
            	            match(input,EQUALS,FOLLOW_EQUALS_in_comp2op1797); if (state.failed) return e;
            	            pushFollow(FOLLOW_compop_in_comp2op1801);
            	            q=compop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new EqualsOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:311:3: NEQUAL q= compop
            	            {
            	            match(input,NEQUAL,FOLLOW_NEQUAL_in_comp2op1807); if (state.failed) return e;
            	            pushFollow(FOLLOW_compop_in_comp2op1811);
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
            	    break loop49;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:314:1: bitwiseand returns [Expression e = null] : t= comp2op ( ( BITWISEAND q= comp2op ) )* ;
    public final Expression bitwiseand() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:315:2: (t= comp2op ( ( BITWISEAND q= comp2op ) )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:315:4: t= comp2op ( ( BITWISEAND q= comp2op ) )*
            {
            pushFollow(FOLLOW_comp2op_in_bitwiseand1833);
            t=comp2op();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:315:21: ( ( BITWISEAND q= comp2op ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==BITWISEAND) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:316:2: ( BITWISEAND q= comp2op )
            	    {
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:316:2: ( BITWISEAND q= comp2op )
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:316:3: BITWISEAND q= comp2op
            	    {
            	    match(input,BITWISEAND,FOLLOW_BITWISEAND_in_bitwiseand1841); if (state.failed) return e;
            	    pushFollow(FOLLOW_comp2op_in_bitwiseand1845);
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
            	    break loop50;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:319:1: bitwiseor returns [Expression e = null] : t= bitwiseand ( ( BITWISEOR q= bitwiseand ) )* ;
    public final Expression bitwiseor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:320:2: (t= bitwiseand ( ( BITWISEOR q= bitwiseand ) )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:320:4: t= bitwiseand ( ( BITWISEOR q= bitwiseand ) )*
            {
            pushFollow(FOLLOW_bitwiseand_in_bitwiseor1867);
            t=bitwiseand();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:320:24: ( ( BITWISEOR q= bitwiseand ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==BITWISEOR) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:321:2: ( BITWISEOR q= bitwiseand )
            	    {
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:321:2: ( BITWISEOR q= bitwiseand )
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:321:3: BITWISEOR q= bitwiseand
            	    {
            	    match(input,BITWISEOR,FOLLOW_BITWISEOR_in_bitwiseor1875); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwiseand_in_bitwiseor1879);
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
            	    break loop51;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:324:1: bitwisexor returns [Expression e = null] : t= bitwiseor ( ( BITWISEXOR q= bitwiseor ) )* ;
    public final Expression bitwisexor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:325:2: (t= bitwiseor ( ( BITWISEXOR q= bitwiseor ) )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:325:4: t= bitwiseor ( ( BITWISEXOR q= bitwiseor ) )*
            {
            pushFollow(FOLLOW_bitwiseor_in_bitwisexor1902);
            t=bitwiseor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:325:23: ( ( BITWISEXOR q= bitwiseor ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==BITWISEXOR) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:326:2: ( BITWISEXOR q= bitwiseor )
            	    {
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:326:2: ( BITWISEXOR q= bitwiseor )
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:326:3: BITWISEXOR q= bitwiseor
            	    {
            	    match(input,BITWISEXOR,FOLLOW_BITWISEXOR_in_bitwisexor1910); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwiseor_in_bitwisexor1914);
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
            	    break loop52;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:329:1: logicaland returns [Expression e = null] : t= bitwisexor ( ( LOGAND q= bitwisexor ) )* ;
    public final Expression logicaland() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:330:2: (t= bitwisexor ( ( LOGAND q= bitwisexor ) )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:330:4: t= bitwisexor ( ( LOGAND q= bitwisexor ) )*
            {
            pushFollow(FOLLOW_bitwisexor_in_logicaland1936);
            t=bitwisexor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:330:24: ( ( LOGAND q= bitwisexor ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==LOGAND) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:331:2: ( LOGAND q= bitwisexor )
            	    {
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:331:2: ( LOGAND q= bitwisexor )
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:331:3: LOGAND q= bitwisexor
            	    {
            	    match(input,LOGAND,FOLLOW_LOGAND_in_logicaland1944); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwisexor_in_logicaland1948);
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
            	    break loop53;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:334:1: logicalor returns [Expression e = null] : t= logicaland ( ( LOGOR q= logicaland ) )* ;
    public final Expression logicalor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:335:2: (t= logicaland ( ( LOGOR q= logicaland ) )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:335:4: t= logicaland ( ( LOGOR q= logicaland ) )*
            {
            pushFollow(FOLLOW_logicaland_in_logicalor1970);
            t=logicaland();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:335:24: ( ( LOGOR q= logicaland ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==LOGOR) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:336:2: ( LOGOR q= logicaland )
            	    {
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:336:2: ( LOGOR q= logicaland )
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:336:3: LOGOR q= logicaland
            	    {
            	    match(input,LOGOR,FOLLOW_LOGOR_in_logicalor1978); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicaland_in_logicalor1982);
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
            	    break loop54;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:339:1: ternary returns [Expression e = null] : t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )* ;
    public final Expression ternary() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression p = null;

        Expression q = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:340:2: (t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:340:4: t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )*
            {
            pushFollow(FOLLOW_logicalor_in_ternary2005);
            t=logicalor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:340:23: ( ( '?' p= logicalor ':' q= logicalor ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==64) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:341:2: ( '?' p= logicalor ':' q= logicalor )
            	    {
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:341:2: ( '?' p= logicalor ':' q= logicalor )
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:341:3: '?' p= logicalor ':' q= logicalor
            	    {
            	    match(input,64,FOLLOW_64_in_ternary2013); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicalor_in_ternary2017);
            	    p=logicalor();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    match(input,48,FOLLOW_48_in_ternary2019); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicalor_in_ternary2023);
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
            	    break loop55;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:344:1: expression returns [Expression e = null] : ( ( MINUS | PLUS )? (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) | ( MINUS | PLUS )? (t= ternary ) );
    public final Expression expression() throws RecognitionException {
        Expression e =  null;

        Expression r = null;

        Expression q = null;

        Expression t = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:2: ( ( MINUS | PLUS )? (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) | ( MINUS | PLUS )? (t= ternary ) )
            int alt59=2;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:4: ( MINUS | PLUS )? (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:4: ( MINUS | PLUS )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( ((LA56_0>=PLUS && LA56_0<=MINUS)) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:
                            {
                            if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                                input.consume();
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return e;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }

                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:18: (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:19: r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )*
                    {
                    pushFollow(FOLLOW_ternary_in_expression2054);
                    r=ternary();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=r;
                    }
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:36: ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )*
                    loop57:
                    do {
                        int alt57=12;
                        switch ( input.LA(1) ) {
                        case EQUAL:
                            {
                            alt57=1;
                            }
                            break;
                        case 65:
                            {
                            alt57=2;
                            }
                            break;
                        case 66:
                            {
                            alt57=3;
                            }
                            break;
                        case 67:
                            {
                            alt57=4;
                            }
                            break;
                        case 68:
                            {
                            alt57=5;
                            }
                            break;
                        case 69:
                            {
                            alt57=6;
                            }
                            break;
                        case 70:
                            {
                            alt57=7;
                            }
                            break;
                        case 71:
                            {
                            alt57=8;
                            }
                            break;
                        case 72:
                            {
                            alt57=9;
                            }
                            break;
                        case 73:
                            {
                            alt57=10;
                            }
                            break;
                        case 74:
                            {
                            alt57=11;
                            }
                            break;

                        }

                        switch (alt57) {
                    	case 1 :
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:346:2: ( EQUAL q= ternary )
                    	    {
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:346:2: ( EQUAL q= ternary )
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:346:3: EQUAL q= ternary
                    	    {
                    	    match(input,EQUAL,FOLLOW_EQUAL_in_expression2062); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression2066);
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
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:347:3: ( '+=' q= ternary )
                    	    {
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:347:3: ( '+=' q= ternary )
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:347:4: '+=' q= ternary
                    	    {
                    	    match(input,65,FOLLOW_65_in_expression2074); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression2078);
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
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:348:3: ( '-=' q= ternary )
                    	    {
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:348:3: ( '-=' q= ternary )
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:348:4: '-=' q= ternary
                    	    {
                    	    match(input,66,FOLLOW_66_in_expression2086); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression2090);
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
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:349:3: ( '*=' q= ternary )
                    	    {
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:349:3: ( '*=' q= ternary )
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:349:4: '*=' q= ternary
                    	    {
                    	    match(input,67,FOLLOW_67_in_expression2098); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression2102);
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
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:350:3: ( '/=' q= ternary )
                    	    {
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:350:3: ( '/=' q= ternary )
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:350:4: '/=' q= ternary
                    	    {
                    	    match(input,68,FOLLOW_68_in_expression2110); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression2114);
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
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:351:3: ( '%=' q= ternary )
                    	    {
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:351:3: ( '%=' q= ternary )
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:351:4: '%=' q= ternary
                    	    {
                    	    match(input,69,FOLLOW_69_in_expression2122); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression2126);
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
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:352:3: ( '&=' q= ternary )
                    	    {
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:352:3: ( '&=' q= ternary )
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:352:4: '&=' q= ternary
                    	    {
                    	    match(input,70,FOLLOW_70_in_expression2134); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression2138);
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
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:353:3: ( '|=' q= ternary )
                    	    {
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:353:3: ( '|=' q= ternary )
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:353:4: '|=' q= ternary
                    	    {
                    	    match(input,71,FOLLOW_71_in_expression2146); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression2150);
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
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:354:3: ( '^=' q= ternary )
                    	    {
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:354:3: ( '^=' q= ternary )
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:354:4: '^=' q= ternary
                    	    {
                    	    match(input,72,FOLLOW_72_in_expression2158); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression2162);
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
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:355:3: ( '<<=' q= ternary )
                    	    {
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:355:3: ( '<<=' q= ternary )
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:355:4: '<<=' q= ternary
                    	    {
                    	    match(input,73,FOLLOW_73_in_expression2170); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression2174);
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
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:356:3: ( '>>=' q= ternary )
                    	    {
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:356:3: ( '>>=' q= ternary )
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:356:4: '>>=' q= ternary
                    	    {
                    	    match(input,74,FOLLOW_74_in_expression2182); if (state.failed) return e;
                    	    pushFollow(FOLLOW_ternary_in_expression2186);
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
                    	    break loop57;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:357:8: ( MINUS | PLUS )? (t= ternary )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:357:8: ( MINUS | PLUS )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( ((LA58_0>=PLUS && LA58_0<=MINUS)) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:
                            {
                            if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                                input.consume();
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return e;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }

                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:357:22: (t= ternary )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:357:23: t= ternary
                    {
                    pushFollow(FOLLOW_ternary_in_expression2208);
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:361:1: stringconst returns [StringConstant s = null] : v= STRINGCONST_PRIVATE ;
    public final StringConstant stringconst() throws RecognitionException {
        StringConstant s =  null;

        Token v=null;

        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:362:2: (v= STRINGCONST_PRIVATE )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:362:4: v= STRINGCONST_PRIVATE
            {
            v=(Token)match(input,STRINGCONST_PRIVATE,FOLLOW_STRINGCONST_PRIVATE_in_stringconst2228); if (state.failed) return s;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:370:1: doubleconst returns [DoubleConstant d = null] : v= DOUBLECONST_PRIVATE ;
    public final DoubleConstant doubleconst() throws RecognitionException {
        DoubleConstant d =  null;

        Token v=null;

        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:371:2: (v= DOUBLECONST_PRIVATE )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:371:4: v= DOUBLECONST_PRIVATE
            {
            v=(Token)match(input,DOUBLECONST_PRIVATE,FOLLOW_DOUBLECONST_PRIVATE_in_doubleconst2284); if (state.failed) return d;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:376:1: intconst returns [IntConstant i = null] : v= INTCONST_PRIVATE ;
    public final IntConstant intconst() throws RecognitionException {
        IntConstant i =  null;

        Token v=null;

        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:377:2: (v= INTCONST_PRIVATE )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:377:4: v= INTCONST_PRIVATE
            {
            v=(Token)match(input,INTCONST_PRIVATE,FOLLOW_INTCONST_PRIVATE_in_intconst2323); if (state.failed) return i;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:386:1: nullconst returns [NullConstant n = new NullConstant()] : 'null' ;
    public final NullConstant nullconst() throws RecognitionException {
        NullConstant n =  new NullConstant();

        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:387:2: ( 'null' )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:387:4: 'null'
            {
            match(input,75,FOLLOW_75_in_nullconst2401); if (state.failed) return n;

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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:389:1: boolconst returns [BooleanConstant b = new BooleanConstant(false)] : ( ( 'true' ) | 'false' );
    public final BooleanConstant boolconst() throws RecognitionException {
        BooleanConstant b =  new BooleanConstant(false);

        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:390:2: ( ( 'true' ) | 'false' )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==76) ) {
                alt60=1;
            }
            else if ( (LA60_0==77) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return b;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:390:4: ( 'true' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:390:4: ( 'true' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:390:5: 'true'
                    {
                    match(input,76,FOLLOW_76_in_boolconst2415); if (state.failed) return b;
                    if ( state.backtracking==0 ) {
                      b.value = true;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:390:31: 'false'
                    {
                    match(input,77,FOLLOW_77_in_boolconst2420); if (state.failed) return b;

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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:392:1: type returns [Type type = new Type()] : ( (i= nativetype ) | (t= clstype ) ( '[' ']' )* );
    public final Type type() throws RecognitionException {
        Type type =  new Type();

        Type i = null;

        Type t = null;


        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:393:2: ( (i= nativetype ) | (t= clstype ) ( '[' ']' )* )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=78 && LA62_0<=88)) ) {
                alt62=1;
            }
            else if ( (LA62_0==WORD) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:393:4: (i= nativetype )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:393:4: (i= nativetype )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:393:5: i= nativetype
                    {
                    pushFollow(FOLLOW_nativetype_in_type2436);
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
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:393:29: (t= clstype ) ( '[' ']' )*
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:393:29: (t= clstype )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:393:30: t= clstype
                    {
                    pushFollow(FOLLOW_clstype_in_type2444);
                    t=clstype();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type=t;
                    }

                    }

                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:394:2: ( '[' ']' )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==LARRAY) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:394:3: '[' ']'
                    	    {
                    	    match(input,LARRAY,FOLLOW_LARRAY_in_type2451); if (state.failed) return type;
                    	    match(input,RARRAY,FOLLOW_RARRAY_in_type2453); if (state.failed) return type;
                    	    if ( state.backtracking==0 ) {
                    	      Type ar = new Type(); ar.typeCategory = TypeCategory.ARRAY; ar.arrayType = type; type = ar;
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:396:1: clstype returns [Type type = new Type()] : (c= WORD ( '.' t= WORD )* ) ;
    public final Type clstype() throws RecognitionException {
        Type type =  new Type();

        Token c=null;
        Token t=null;


        	type.typeCategory = TypeCategory.CLASS;
        	String s = "";

        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:401:2: ( (c= WORD ( '.' t= WORD )* ) )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:401:4: (c= WORD ( '.' t= WORD )* )
            {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:401:4: (c= WORD ( '.' t= WORD )* )
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:401:5: c= WORD ( '.' t= WORD )*
            {
            c=(Token)match(input,WORD,FOLLOW_WORD_in_clstype2477); if (state.failed) return type;
            if ( state.backtracking==0 ) {
              s += c.getText();
            }
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:401:32: ( '.' t= WORD )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==DOT) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:401:33: '.' t= WORD
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_clstype2482); if (state.failed) return type;
            	    t=(Token)match(input,WORD,FOLLOW_WORD_in_clstype2486); if (state.failed) return type;
            	    if ( state.backtracking==0 ) {
            	      s += "." + t.getText();
            	    }

            	    }
            	    break;

            	default :
            	    break loop63;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:403:1: nativetype returns [Type type = new Type()] : ( ( 'int' ) | ( 'uint' ) | ( 'float' ) | ( 'ufloat' ) | ( 'double' ) | ( 'udouble' ) | ( 'char' ) | ( 'uchar' ) | ( 'bool' ) | ( 'string' ) | ( 'void' ) );
    public final Type nativetype() throws RecognitionException {
        Type type =  new Type();


        	type.typeCategory = TypeCategory.NATIVE;

        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:406:3: ( ( 'int' ) | ( 'uint' ) | ( 'float' ) | ( 'ufloat' ) | ( 'double' ) | ( 'udouble' ) | ( 'char' ) | ( 'uchar' ) | ( 'bool' ) | ( 'string' ) | ( 'void' ) )
            int alt64=11;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt64=1;
                }
                break;
            case 79:
                {
                alt64=2;
                }
                break;
            case 80:
                {
                alt64=3;
                }
                break;
            case 81:
                {
                alt64=4;
                }
                break;
            case 82:
                {
                alt64=5;
                }
                break;
            case 83:
                {
                alt64=6;
                }
                break;
            case 84:
                {
                alt64=7;
                }
                break;
            case 85:
                {
                alt64=8;
                }
                break;
            case 86:
                {
                alt64=9;
                }
                break;
            case 87:
                {
                alt64=10;
                }
                break;
            case 88:
                {
                alt64=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:406:5: ( 'int' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:406:5: ( 'int' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:406:6: 'int'
                    {
                    match(input,78,FOLLOW_78_in_nativetype2510); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.INT;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:407:2: ( 'uint' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:407:2: ( 'uint' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:407:3: 'uint'
                    {
                    match(input,79,FOLLOW_79_in_nativetype2518); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UINT;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:408:2: ( 'float' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:408:2: ( 'float' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:408:3: 'float'
                    {
                    match(input,80,FOLLOW_80_in_nativetype2526); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.FLOAT;
                    }

                    }


                    }
                    break;
                case 4 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:409:2: ( 'ufloat' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:409:2: ( 'ufloat' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:409:3: 'ufloat'
                    {
                    match(input,81,FOLLOW_81_in_nativetype2534); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UFLOAT;
                    }

                    }


                    }
                    break;
                case 5 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:410:2: ( 'double' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:410:2: ( 'double' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:410:3: 'double'
                    {
                    match(input,82,FOLLOW_82_in_nativetype2542); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.DOUBLE;
                    }

                    }


                    }
                    break;
                case 6 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:411:2: ( 'udouble' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:411:2: ( 'udouble' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:411:3: 'udouble'
                    {
                    match(input,83,FOLLOW_83_in_nativetype2550); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UDOUBLE;
                    }

                    }


                    }
                    break;
                case 7 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:412:2: ( 'char' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:412:2: ( 'char' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:412:3: 'char'
                    {
                    match(input,84,FOLLOW_84_in_nativetype2558); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.CHAR;
                    }

                    }


                    }
                    break;
                case 8 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:413:2: ( 'uchar' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:413:2: ( 'uchar' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:413:3: 'uchar'
                    {
                    match(input,85,FOLLOW_85_in_nativetype2566); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.UCHAR;
                    }

                    }


                    }
                    break;
                case 9 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:414:2: ( 'bool' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:414:2: ( 'bool' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:414:3: 'bool'
                    {
                    match(input,86,FOLLOW_86_in_nativetype2574); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.BOOL;
                    }

                    }


                    }
                    break;
                case 10 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:415:2: ( 'string' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:415:2: ( 'string' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:415:3: 'string'
                    {
                    match(input,87,FOLLOW_87_in_nativetype2582); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.STRING;
                    }

                    }


                    }
                    break;
                case 11 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:416:2: ( 'void' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:416:2: ( 'void' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:416:3: 'void'
                    {
                    match(input,88,FOLLOW_88_in_nativetype2590); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.nativeType = NativeType.VOID;
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
    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:418:1: accesscontrolkeyword returns [AccessControlKeyword a = AccessControlKeyword.PUBLIC] : ( 'public' | ( 'private' ) | ( 'protected' ) );
    public final AccessControlKeyword accesscontrolkeyword() throws RecognitionException {
        AccessControlKeyword a =  AccessControlKeyword.PUBLIC;

        try {
            // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:419:2: ( 'public' | ( 'private' ) | ( 'protected' ) )
            int alt65=3;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt65=1;
                }
                break;
            case 90:
                {
                alt65=2;
                }
                break;
            case 91:
                {
                alt65=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return a;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:419:4: 'public'
                    {
                    match(input,89,FOLLOW_89_in_accesscontrolkeyword2607); if (state.failed) return a;

                    }
                    break;
                case 2 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:419:15: ( 'private' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:419:15: ( 'private' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:419:16: 'private'
                    {
                    match(input,90,FOLLOW_90_in_accesscontrolkeyword2612); if (state.failed) return a;
                    if ( state.backtracking==0 ) {
                      a = AccessControlKeyword.PRIVATE;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:419:65: ( 'protected' )
                    {
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:419:65: ( 'protected' )
                    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:419:66: 'protected'
                    {
                    match(input,91,FOLLOW_91_in_accesscontrolkeyword2620); if (state.failed) return a;
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

    // $ANTLR start synpred30_PineDL
    public final void synpred30_PineDL_fragment() throws RecognitionException {   
        Leaf e = null;


        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:216:4: ( 'else' e= stmt )
        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:216:4: 'else' e= stmt
        {
        match(input,54,FOLLOW_54_in_synpred30_PineDL908); if (state.failed) return ;
        pushFollow(FOLLOW_stmt_in_synpred30_PineDL912);
        e=stmt();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_PineDL

    // $ANTLR start synpred33_PineDL
    public final void synpred33_PineDL_fragment() throws RecognitionException {   
        Token n=null;
        Type t = null;

        Leaf b = null;


        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:230:3: ( 'catch' LPAREN t= type n= WORD RPAREN b= stmt )
        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:230:3: 'catch' LPAREN t= type n= WORD RPAREN b= stmt
        {
        match(input,58,FOLLOW_58_in_synpred33_PineDL1041); if (state.failed) return ;
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred33_PineDL1043); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred33_PineDL1047);
        t=type();

        state._fsp--;
        if (state.failed) return ;
        n=(Token)match(input,WORD,FOLLOW_WORD_in_synpred33_PineDL1051); if (state.failed) return ;
        match(input,RPAREN,FOLLOW_RPAREN_in_synpred33_PineDL1053); if (state.failed) return ;
        pushFollow(FOLLOW_stmt_in_synpred33_PineDL1057);
        b=stmt();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_PineDL

    // $ANTLR start synpred65_PineDL
    public final void synpred65_PineDL_fragment() throws RecognitionException {   
        Expression p = null;


        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:277:4: ( (p= prepostop ) )
        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:277:4: (p= prepostop )
        {
        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:277:4: (p= prepostop )
        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:277:5: p= prepostop
        {
        pushFollow(FOLLOW_prepostop_in_synpred65_PineDL1527);
        p=prepostop();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred65_PineDL

    // $ANTLR start synpred99_PineDL
    public final void synpred99_PineDL_fragment() throws RecognitionException {   
        Expression r = null;

        Expression q = null;


        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:4: ( ( MINUS | PLUS )? (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) )
        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:4: ( MINUS | PLUS )? (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* )
        {
        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:4: ( MINUS | PLUS )?
        int alt86=2;
        int LA86_0 = input.LA(1);

        if ( ((LA86_0>=PLUS && LA86_0<=MINUS)) ) {
            alt86=1;
        }
        switch (alt86) {
            case 1 :
                // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:
                {
                if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }


                }
                break;

        }

        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:18: (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* )
        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:19: r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )*
        {
        pushFollow(FOLLOW_ternary_in_synpred99_PineDL2054);
        r=ternary();

        state._fsp--;
        if (state.failed) return ;
        // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:36: ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )*
        loop87:
        do {
            int alt87=12;
            switch ( input.LA(1) ) {
            case EQUAL:
                {
                alt87=1;
                }
                break;
            case 65:
                {
                alt87=2;
                }
                break;
            case 66:
                {
                alt87=3;
                }
                break;
            case 67:
                {
                alt87=4;
                }
                break;
            case 68:
                {
                alt87=5;
                }
                break;
            case 69:
                {
                alt87=6;
                }
                break;
            case 70:
                {
                alt87=7;
                }
                break;
            case 71:
                {
                alt87=8;
                }
                break;
            case 72:
                {
                alt87=9;
                }
                break;
            case 73:
                {
                alt87=10;
                }
                break;
            case 74:
                {
                alt87=11;
                }
                break;

            }

            switch (alt87) {
        	case 1 :
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:346:2: ( EQUAL q= ternary )
        	    {
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:346:2: ( EQUAL q= ternary )
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:346:3: EQUAL q= ternary
        	    {
        	    match(input,EQUAL,FOLLOW_EQUAL_in_synpred99_PineDL2062); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred99_PineDL2066);
        	    q=ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 2 :
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:347:3: ( '+=' q= ternary )
        	    {
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:347:3: ( '+=' q= ternary )
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:347:4: '+=' q= ternary
        	    {
        	    match(input,65,FOLLOW_65_in_synpred99_PineDL2074); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred99_PineDL2078);
        	    q=ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 3 :
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:348:3: ( '-=' q= ternary )
        	    {
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:348:3: ( '-=' q= ternary )
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:348:4: '-=' q= ternary
        	    {
        	    match(input,66,FOLLOW_66_in_synpred99_PineDL2086); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred99_PineDL2090);
        	    q=ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 4 :
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:349:3: ( '*=' q= ternary )
        	    {
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:349:3: ( '*=' q= ternary )
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:349:4: '*=' q= ternary
        	    {
        	    match(input,67,FOLLOW_67_in_synpred99_PineDL2098); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred99_PineDL2102);
        	    q=ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 5 :
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:350:3: ( '/=' q= ternary )
        	    {
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:350:3: ( '/=' q= ternary )
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:350:4: '/=' q= ternary
        	    {
        	    match(input,68,FOLLOW_68_in_synpred99_PineDL2110); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred99_PineDL2114);
        	    q=ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 6 :
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:351:3: ( '%=' q= ternary )
        	    {
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:351:3: ( '%=' q= ternary )
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:351:4: '%=' q= ternary
        	    {
        	    match(input,69,FOLLOW_69_in_synpred99_PineDL2122); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred99_PineDL2126);
        	    q=ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 7 :
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:352:3: ( '&=' q= ternary )
        	    {
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:352:3: ( '&=' q= ternary )
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:352:4: '&=' q= ternary
        	    {
        	    match(input,70,FOLLOW_70_in_synpred99_PineDL2134); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred99_PineDL2138);
        	    q=ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 8 :
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:353:3: ( '|=' q= ternary )
        	    {
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:353:3: ( '|=' q= ternary )
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:353:4: '|=' q= ternary
        	    {
        	    match(input,71,FOLLOW_71_in_synpred99_PineDL2146); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred99_PineDL2150);
        	    q=ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 9 :
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:354:3: ( '^=' q= ternary )
        	    {
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:354:3: ( '^=' q= ternary )
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:354:4: '^=' q= ternary
        	    {
        	    match(input,72,FOLLOW_72_in_synpred99_PineDL2158); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred99_PineDL2162);
        	    q=ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 10 :
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:355:3: ( '<<=' q= ternary )
        	    {
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:355:3: ( '<<=' q= ternary )
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:355:4: '<<=' q= ternary
        	    {
        	    match(input,73,FOLLOW_73_in_synpred99_PineDL2170); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred99_PineDL2174);
        	    q=ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 11 :
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:356:3: ( '>>=' q= ternary )
        	    {
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:356:3: ( '>>=' q= ternary )
        	    // /home/bob/NetBeansProjects/Pineapple/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:356:4: '>>=' q= ternary
        	    {
        	    match(input,74,FOLLOW_74_in_synpred99_PineDL2182); if (state.failed) return ;
        	    pushFollow(FOLLOW_ternary_in_synpred99_PineDL2186);
        	    q=ternary();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop87;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred99_PineDL

    // Delegated rules

    public final boolean synpred99_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA59 dfa59 = new DFA59(this);
    static final String DFA4_eotS =
        "\33\uffff";
    static final String DFA4_eofS =
        "\33\uffff";
    static final String DFA4_minS =
        "\1\33\1\uffff\3\40\1\uffff\15\40\1\11\1\15\1\40\1\37\2\uffff\1\11"+
        "\1\36";
    static final String DFA4_maxS =
        "\1\133\1\uffff\3\130\1\uffff\2\130\14\40\1\34\1\40\1\37\2\uffff"+
        "\2\40";
    static final String DFA4_acceptS =
        "\1\uffff\1\4\3\uffff\1\3\21\uffff\1\2\1\1\2\uffff";
    static final String DFA4_specialS =
        "\33\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1\75\uffff\1\2\1\3\1\4",
            "",
            "\1\23\14\uffff\1\6\1\7\1\5\36\uffff\1\10\1\11\1\12\1\13\1\14"+
            "\1\15\1\16\1\17\1\20\1\21\1\22",
            "\1\23\14\uffff\1\6\1\7\1\5\36\uffff\1\10\1\11\1\12\1\13\1\14"+
            "\1\15\1\16\1\17\1\20\1\21\1\22",
            "\1\23\14\uffff\1\6\1\7\1\5\36\uffff\1\10\1\11\1\12\1\13\1\14"+
            "\1\15\1\16\1\17\1\20\1\21\1\22",
            "",
            "\1\23\15\uffff\1\7\37\uffff\1\10\1\11\1\12\1\13\1\14\1\15\1"+
            "\16\1\17\1\20\1\21\1\22",
            "\1\23\55\uffff\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
            "\1\21\1\22",
            "\1\24",
            "\1\24",
            "\1\24",
            "\1\24",
            "\1\24",
            "\1\24",
            "\1\24",
            "\1\24",
            "\1\24",
            "\1\24",
            "\1\24",
            "\1\25\24\uffff\1\26\1\uffff\1\24",
            "\1\30\6\uffff\1\30\7\uffff\1\27",
            "\1\31",
            "\1\32",
            "",
            "",
            "\1\25\24\uffff\1\26\1\uffff\1\24",
            "\1\26\1\uffff\1\24"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "()* loopback of 149:3: (f= field | m= method | c= constructor )*";
        }
    }
    static final String DFA17_eotS =
        "\22\uffff";
    static final String DFA17_eofS =
        "\22\uffff";
    static final String DFA17_minS =
        "\1\4\1\uffff\1\4\13\uffff\1\4\1\40\2\4";
    static final String DFA17_maxS =
        "\1\130\1\uffff\1\112\13\uffff\1\115\1\61\1\112\1\115";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
        "\1\14\4\uffff";
    static final String DFA17_specialS =
        "\22\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\3\6\uffff\1\3\7\uffff\1\15\5\uffff\1\11\1\uffff\1\3\3\uffff"+
            "\1\2\2\3\1\uffff\1\3\12\uffff\1\3\1\uffff\1\3\1\uffff\1\13\1"+
            "\14\1\6\1\uffff\1\7\1\10\1\12\1\uffff\1\4\1\5\3\3\13\uffff\3"+
            "\3\13\1",
            "",
            "\5\3\1\17\2\3\1\uffff\15\3\2\uffff\1\3\1\uffff\1\16\1\uffff"+
            "\1\1\35\uffff\15\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\3\6\uffff\1\3\17\uffff\1\3\2\uffff\1\1\3\3\1\uffff\1\3\12"+
            "\uffff\1\3\1\uffff\1\3\13\uffff\3\3\13\uffff\3\3",
            "\1\20\16\uffff\1\3\1\uffff\1\3",
            "\5\3\1\17\2\3\1\uffff\15\3\2\uffff\1\3\1\uffff\1\21\1\uffff"+
            "\1\1\35\uffff\15\3",
            "\2\3\6\uffff\1\3\17\uffff\1\3\2\uffff\1\1\3\3\1\uffff\1\3\12"+
            "\uffff\1\3\1\uffff\1\3\13\uffff\3\3\13\uffff\3\3"
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "199:1: stmt returns [Leaf l = null] : ( (e= declAssign ) | (a= expression STMTEND ) | (b= returnstmt ) | (t= throwstmt ) | (c= ifstmt ) | (w= whilestmt ) | (f= forstmt ) | (d= block ) | (tr= trystmt ) | ( 'break' STMTEND ) | ( 'continue' STMTEND ) | STMTEND );";
        }
    }
    static final String DFA19_eotS =
        "\11\uffff";
    static final String DFA19_eofS =
        "\11\uffff";
    static final String DFA19_minS =
        "\1\4\1\uffff\1\4\2\uffff\1\40\3\4";
    static final String DFA19_maxS =
        "\1\130\1\uffff\1\112\2\uffff\1\61\1\115\1\112\1\115";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\4\uffff";
    static final String DFA19_specialS =
        "\11\uffff}>";
    static final String[] DFA19_transitionS = {
            "\2\1\6\uffff\1\1\7\uffff\1\4\7\uffff\1\1\3\uffff\1\2\2\1\1\uffff"+
            "\1\1\12\uffff\1\1\1\uffff\1\1\13\uffff\3\1\13\uffff\3\1\13\3",
            "",
            "\5\1\1\5\2\1\1\uffff\15\1\2\uffff\1\1\1\uffff\1\6\1\uffff\1"+
            "\3\35\uffff\15\1",
            "",
            "",
            "\1\7\16\uffff\1\1\1\uffff\1\1",
            "\2\1\6\uffff\1\1\17\uffff\1\1\2\uffff\1\3\3\1\1\uffff\1\1\12"+
            "\uffff\1\1\1\uffff\1\1\13\uffff\3\1\13\uffff\3\1",
            "\5\1\1\5\2\1\1\uffff\15\1\2\uffff\1\1\1\uffff\1\10\1\uffff"+
            "\1\3\35\uffff\15\1",
            "\2\1\6\uffff\1\1\17\uffff\1\1\2\uffff\1\3\3\1\1\uffff\1\1\12"+
            "\uffff\1\1\1\uffff\1\1\13\uffff\3\1\13\uffff\3\1"
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "223:17: ( (a= expression STMTEND ) | b= declAssign | STMTEND )";
        }
    }
    static final String DFA36_eotS =
        "\13\uffff";
    static final String DFA36_eofS =
        "\13\uffff";
    static final String DFA36_minS =
        "\1\4\1\40\3\uffff\1\40\1\4\1\40\2\uffff\1\4";
    static final String DFA36_maxS =
        "\2\115\3\uffff\1\40\1\36\1\40\2\uffff\1\36";
    static final String DFA36_acceptS =
        "\2\uffff\1\1\1\2\1\3\3\uffff\1\4\1\5\1\uffff";
    static final String DFA36_specialS =
        "\13\uffff}>";
    static final String[] DFA36_transitionS = {
            "\2\1\26\uffff\1\4\3\uffff\1\3\2\2\1\uffff\1\2\12\uffff\1\3\1"+
            "\uffff\1\3\13\uffff\1\5\15\uffff\3\2",
            "\1\3\2\2\1\uffff\1\2\12\uffff\1\3\1\uffff\1\3\31\uffff\3\2",
            "",
            "",
            "",
            "\1\6",
            "\2\10\3\uffff\1\7\22\uffff\1\10\1\uffff\1\11",
            "\1\12",
            "",
            "",
            "\2\10\3\uffff\1\7\22\uffff\1\10\1\uffff\1\11"
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "258:1: primitive returns [Expression e = null] : ( ( MINUS | PLUS )? c= constant | ( MINUS | PLUS )? (r= reference ( '.' b= reference )* ) | ( LPAREN x= expression RPAREN ) | ( 'new' t= clstype ( MINUS | PLUS )? LPAREN (ex= expression ( ',' ex= expression )* )? RPAREN ) | ( 'new' t= clstype '[' x= expression ']' ) );";
        }
    }
    static final String DFA39_eotS =
        "\75\uffff";
    static final String DFA39_eofS =
        "\10\uffff\1\1\2\uffff\2\1\60\uffff";
    static final String DFA39_minS =
        "\1\4\1\uffff\1\4\2\uffff\1\4\1\40\10\4\7\0\4\4\43\0";
    static final String DFA39_maxS =
        "\1\115\1\uffff\1\130\2\uffff\1\112\1\61\2\115\1\112\5\115\7\0\4"+
        "\115\43\0";
    static final String DFA39_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\70\uffff";
    static final String DFA39_specialS =
        "\17\uffff\1\45\1\50\1\20\1\46\1\4\1\35\1\16\4\uffff\1\1\1\0\1\47"+
        "\1\5\1\12\1\37\1\27\1\21\1\34\1\36\1\22\1\33\1\26\1\10\1\11\1\51"+
        "\1\40\1\14\1\43\1\31\1\23\1\42\1\44\1\15\1\41\1\32\1\17\1\7\1\30"+
        "\1\25\1\6\1\24\1\13\1\2\1\3}>";
    static final String[] DFA39_transitionS = {
            "\2\1\6\uffff\1\3\17\uffff\1\2\3\uffff\3\1\1\uffff\1\1\12\uffff"+
            "\1\1\1\uffff\1\1\13\uffff\3\1\13\uffff\3\1",
            "",
            "\2\1\6\uffff\1\1\17\uffff\1\1\3\uffff\1\5\2\1\1\uffff\1\1\12"+
            "\uffff\1\1\1\uffff\1\1\13\uffff\3\1\13\uffff\3\1\13\4",
            "",
            "",
            "\5\1\1\6\2\1\1\uffff\7\1\1\uffff\5\1\2\uffff\1\1\1\10\1\7\37"+
            "\uffff\15\1",
            "\1\11\16\uffff\1\1\1\uffff\1\1",
            "\2\1\6\uffff\1\1\17\uffff\1\1\2\uffff\1\4\3\1\1\uffff\1\1\12"+
            "\uffff\1\1\1\uffff\1\1\13\uffff\3\1\13\uffff\3\1",
            "\1\12\1\15\3\1\1\uffff\2\1\1\4\15\1\2\uffff\1\4\1\1\1\uffff"+
            "\1\1\3\4\1\uffff\1\4\12\uffff\1\4\1\1\1\4\1\1\12\uffff\1\4\1"+
            "\13\1\14\13\1\3\4",
            "\5\1\1\6\2\1\1\uffff\7\1\1\uffff\5\1\2\uffff\1\1\1\10\1\16"+
            "\37\uffff\15\1",
            "\2\1\6\uffff\1\1\17\uffff\1\1\3\uffff\1\25\1\23\1\20\1\uffff"+
            "\1\17\12\uffff\1\25\1\uffff\1\25\13\uffff\3\1\13\uffff\1\24"+
            "\1\21\1\22",
            "\1\26\1\27\3\1\1\uffff\2\1\1\uffff\15\1\2\uffff\1\4\1\1\1\uffff"+
            "\1\1\3\4\1\uffff\1\4\12\uffff\1\4\1\1\1\4\1\1\12\uffff\1\4\2"+
            "\uffff\13\1\3\4",
            "\1\30\1\31\3\1\1\uffff\2\1\1\uffff\15\1\2\uffff\1\4\1\1\1\uffff"+
            "\1\1\3\4\1\uffff\1\4\12\uffff\1\4\1\1\1\4\1\1\12\uffff\1\4\2"+
            "\uffff\13\1\3\4",
            "\2\1\6\uffff\1\1\17\uffff\1\1\3\uffff\1\40\1\36\1\33\1\uffff"+
            "\1\32\12\uffff\1\40\1\uffff\1\40\13\uffff\3\1\13\uffff\1\37"+
            "\1\34\1\35",
            "\2\1\6\uffff\1\1\17\uffff\1\1\2\uffff\1\4\3\1\1\uffff\1\1\12"+
            "\uffff\1\1\1\uffff\1\1\13\uffff\3\1\13\uffff\3\1",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\2\1\6\uffff\1\1\17\uffff\1\1\3\uffff\1\41\1\46\1\43\1\uffff"+
            "\1\42\12\uffff\1\41\1\uffff\1\41\13\uffff\3\1\13\uffff\1\47"+
            "\1\44\1\45",
            "\2\1\6\uffff\1\1\17\uffff\1\1\3\uffff\1\50\1\55\1\52\1\uffff"+
            "\1\51\12\uffff\1\50\1\uffff\1\50\13\uffff\3\1\13\uffff\1\56"+
            "\1\53\1\54",
            "\2\1\6\uffff\1\1\17\uffff\1\1\3\uffff\1\65\1\63\1\60\1\uffff"+
            "\1\57\12\uffff\1\65\1\uffff\1\65\13\uffff\3\1\13\uffff\1\64"+
            "\1\61\1\62",
            "\2\1\6\uffff\1\1\17\uffff\1\1\3\uffff\1\74\1\72\1\67\1\uffff"+
            "\1\66\12\uffff\1\74\1\uffff\1\74\13\uffff\3\1\13\uffff\1\73"+
            "\1\70\1\71",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "273:1: notcastexpr returns [Expression e = null] : ( (p= prepostop ) | ( NOT p= notcastexpr ) | ( LPAREN t= type RPAREN p= notcastexpr ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_27 = input.LA(1);

                         
                        int index39_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_27);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA39_26 = input.LA(1);

                         
                        int index39_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_26);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA39_59 = input.LA(1);

                         
                        int index39_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_59);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA39_60 = input.LA(1);

                         
                        int index39_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_60);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA39_19 = input.LA(1);

                         
                        int index39_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_19);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA39_29 = input.LA(1);

                         
                        int index39_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_29);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA39_56 = input.LA(1);

                         
                        int index39_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_56);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA39_53 = input.LA(1);

                         
                        int index39_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_53);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA39_39 = input.LA(1);

                         
                        int index39_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_39);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA39_40 = input.LA(1);

                         
                        int index39_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_40);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA39_30 = input.LA(1);

                         
                        int index39_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_30);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA39_58 = input.LA(1);

                         
                        int index39_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_58);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA39_43 = input.LA(1);

                         
                        int index39_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_43);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA39_49 = input.LA(1);

                         
                        int index39_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_49);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA39_21 = input.LA(1);

                         
                        int index39_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_21);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA39_52 = input.LA(1);

                         
                        int index39_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_52);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA39_17 = input.LA(1);

                         
                        int index39_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA39_33 = input.LA(1);

                         
                        int index39_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_33);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA39_36 = input.LA(1);

                         
                        int index39_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_36);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA39_46 = input.LA(1);

                         
                        int index39_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_46);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA39_57 = input.LA(1);

                         
                        int index39_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_57);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA39_55 = input.LA(1);

                         
                        int index39_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_55);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA39_38 = input.LA(1);

                         
                        int index39_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_38);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA39_32 = input.LA(1);

                         
                        int index39_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_32);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA39_54 = input.LA(1);

                         
                        int index39_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_54);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA39_45 = input.LA(1);

                         
                        int index39_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_45);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA39_51 = input.LA(1);

                         
                        int index39_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_51);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA39_37 = input.LA(1);

                         
                        int index39_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_37);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA39_34 = input.LA(1);

                         
                        int index39_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_34);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA39_20 = input.LA(1);

                         
                        int index39_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_20);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA39_35 = input.LA(1);

                         
                        int index39_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_35);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA39_31 = input.LA(1);

                         
                        int index39_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_31);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA39_42 = input.LA(1);

                         
                        int index39_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_42);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA39_50 = input.LA(1);

                         
                        int index39_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_50);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA39_47 = input.LA(1);

                         
                        int index39_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_47);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA39_44 = input.LA(1);

                         
                        int index39_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_44);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA39_48 = input.LA(1);

                         
                        int index39_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_48);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA39_15 = input.LA(1);

                         
                        int index39_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_15);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA39_18 = input.LA(1);

                         
                        int index39_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_18);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA39_28 = input.LA(1);

                         
                        int index39_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_28);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA39_16 = input.LA(1);

                         
                        int index39_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_16);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA39_41 = input.LA(1);

                         
                        int index39_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index39_41);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA59_eotS =
        "\20\uffff";
    static final String DFA59_eofS =
        "\20\uffff";
    static final String DFA59_minS =
        "\1\4\15\0\2\uffff";
    static final String DFA59_maxS =
        "\1\115\15\0\2\uffff";
    static final String DFA59_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA59_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\2\uffff}>";
    static final String[] DFA59_transitionS = {
            "\2\1\6\uffff\1\15\17\uffff\1\11\3\uffff\1\10\1\6\1\3\1\uffff"+
            "\1\2\12\uffff\1\10\1\uffff\1\10\13\uffff\1\12\1\13\1\14\13\uffff"+
            "\1\7\1\4\1\5",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA59_eot = DFA.unpackEncodedString(DFA59_eotS);
    static final short[] DFA59_eof = DFA.unpackEncodedString(DFA59_eofS);
    static final char[] DFA59_min = DFA.unpackEncodedStringToUnsignedChars(DFA59_minS);
    static final char[] DFA59_max = DFA.unpackEncodedStringToUnsignedChars(DFA59_maxS);
    static final short[] DFA59_accept = DFA.unpackEncodedString(DFA59_acceptS);
    static final short[] DFA59_special = DFA.unpackEncodedString(DFA59_specialS);
    static final short[][] DFA59_transition;

    static {
        int numStates = DFA59_transitionS.length;
        DFA59_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA59_transition[i] = DFA.unpackEncodedString(DFA59_transitionS[i]);
        }
    }

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = DFA59_eot;
            this.eof = DFA59_eof;
            this.min = DFA59_min;
            this.max = DFA59_max;
            this.accept = DFA59_accept;
            this.special = DFA59_special;
            this.transition = DFA59_transition;
        }
        public String getDescription() {
            return "344:1: expression returns [Expression e = null] : ( ( MINUS | PLUS )? (r= ternary ( ( EQUAL q= ternary ) | ( '+=' q= ternary ) | ( '-=' q= ternary ) | ( '*=' q= ternary ) | ( '/=' q= ternary ) | ( '%=' q= ternary ) | ( '&=' q= ternary ) | ( '|=' q= ternary ) | ( '^=' q= ternary ) | ( '<<=' q= ternary ) | ( '>>=' q= ternary ) )* ) | ( MINUS | PLUS )? (t= ternary ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_1 = input.LA(1);

                         
                        int index59_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA59_2 = input.LA(1);

                         
                        int index59_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA59_3 = input.LA(1);

                         
                        int index59_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA59_4 = input.LA(1);

                         
                        int index59_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA59_5 = input.LA(1);

                         
                        int index59_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA59_6 = input.LA(1);

                         
                        int index59_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA59_7 = input.LA(1);

                         
                        int index59_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA59_8 = input.LA(1);

                         
                        int index59_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA59_9 = input.LA(1);

                         
                        int index59_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA59_10 = input.LA(1);

                         
                        int index59_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA59_11 = input.LA(1);

                         
                        int index59_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA59_12 = input.LA(1);

                         
                        int index59_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA59_13 = input.LA(1);

                         
                        int index59_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_PineDL()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index59_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 59, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_pkgstmt_in_doc289 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_importstmt_in_doc294 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_clsdecl_in_doc299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_pkgstmt311 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pkgname_in_pkgstmt315 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_pkgstmt319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_importstmt328 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_clstype_in_importstmt332 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_importstmt336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_clsdecl345 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_clsdecl349 = new BitSet(new long[]{0x0000100004000000L});
    public static final BitSet FOLLOW_44_in_clsdecl354 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_clstype_in_clsdecl358 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_BLKBEG_in_clsdecl366 = new BitSet(new long[]{0x0000000008000000L,0x000000000E000000L});
    public static final BitSet FOLLOW_field_in_clsdecl377 = new BitSet(new long[]{0x0000000008000000L,0x000000000E000000L});
    public static final BitSet FOLLOW_method_in_clsdecl388 = new BitSet(new long[]{0x0000000008000000L,0x000000000E000000L});
    public static final BitSet FOLLOW_constructor_in_clsdecl399 = new BitSet(new long[]{0x0000000008000000L,0x000000000E000000L});
    public static final BitSet FOLLOW_BLKEND_in_clsdecl410 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_STMTEND_in_clsdecl412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accesscontrolkeyword_in_field429 = new BitSet(new long[]{0x0000600100000000L,0x0000000001FFC000L});
    public static final BitSet FOLLOW_45_in_field436 = new BitSet(new long[]{0x0000600100000000L,0x0000000001FFC000L});
    public static final BitSet FOLLOW_46_in_field445 = new BitSet(new long[]{0x0000600100000000L,0x0000000001FFC000L});
    public static final BitSet FOLLOW_type_in_field455 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_field463 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_EQUAL_in_field470 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_field474 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_field482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accesscontrolkeyword_in_method499 = new BitSet(new long[]{0x0000600100000000L,0x0000000001FFC000L});
    public static final BitSet FOLLOW_45_in_method506 = new BitSet(new long[]{0x0000600100000000L,0x0000000001FFC000L});
    public static final BitSet FOLLOW_46_in_method515 = new BitSet(new long[]{0x0000600100000000L,0x0000000001FFC000L});
    public static final BitSet FOLLOW_type_in_method525 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_method533 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_method539 = new BitSet(new long[]{0x0000600120000000L,0x0000000001FFC000L});
    public static final BitSet FOLLOW_argumentlist_in_method545 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_method551 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_block_in_method557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accesscontrolkeyword_in_constructor575 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_constructor581 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_constructor585 = new BitSet(new long[]{0x0000600120000000L,0x0000000001FFC000L});
    public static final BitSet FOLLOW_argumentlist_in_constructor591 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_constructor597 = new BitSet(new long[]{0x0001000004000000L});
    public static final BitSet FOLLOW_48_in_constructor602 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_constructor604 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_constructor611 = new BitSet(new long[]{0xE002801730001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_constructor619 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_50_in_constructor627 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_constructor631 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_constructor642 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_block_in_constructor650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_argumentlist668 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_argumentlist673 = new BitSet(new long[]{0x0000600100000000L,0x0000000001FFC000L});
    public static final BitSet FOLLOW_argument_in_argumentlist677 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_type_in_argument699 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_argument706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLKBEG_in_block722 = new BitSet(new long[]{0xFBBAE0171C101030L,0x0000000001FFF800L});
    public static final BitSet FOLLOW_stmt_in_block727 = new BitSet(new long[]{0xFBBAE0171C101030L,0x0000000001FFF800L});
    public static final BitSet FOLLOW_BLKEND_in_block733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declAssign_in_stmt751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_stmt762 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_stmt764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnstmt_in_stmt775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwstmt_in_stmt786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifstmt_in_stmt797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whilestmt_in_stmt808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forstmt_in_stmt819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_stmt830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trystmt_in_stmt841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_stmt850 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_stmt852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_stmt861 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_stmt863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STMTEND_in_stmt871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ifstmt885 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_ifstmt887 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_ifstmt891 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_ifstmt895 = new BitSet(new long[]{0xFBBAE01714101030L,0x0000000001FFF800L});
    public static final BitSet FOLLOW_stmt_in_ifstmt901 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_ifstmt908 = new BitSet(new long[]{0xFBBAE01714101030L,0x0000000001FFF800L});
    public static final BitSet FOLLOW_stmt_in_ifstmt912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_whilestmt931 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_whilestmt933 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_whilestmt937 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_whilestmt941 = new BitSet(new long[]{0xFBBAE01714101030L,0x0000000001FFF800L});
    public static final BitSet FOLLOW_stmt_in_whilestmt947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_forstmt964 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_forstmt966 = new BitSet(new long[]{0xE002E01710101030L,0x0000000001FFF800L});
    public static final BitSet FOLLOW_expression_in_forstmt972 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_forstmt976 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_declAssign_in_forstmt981 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_STMTEND_in_forstmt985 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_forstmt993 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_forstmt998 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_forstmt1005 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_forstmt1010 = new BitSet(new long[]{0xFBBAE01714101030L,0x0000000001FFF800L});
    public static final BitSet FOLLOW_stmt_in_forstmt1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_trystmt1031 = new BitSet(new long[]{0xFBBAE01714101030L,0x0000000001FFF800L});
    public static final BitSet FOLLOW_stmt_in_trystmt1035 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_trystmt1041 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_trystmt1043 = new BitSet(new long[]{0x0000600100000000L,0x0000000001FFC000L});
    public static final BitSet FOLLOW_type_in_trystmt1047 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_trystmt1051 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_trystmt1053 = new BitSet(new long[]{0xFBBAE01714101030L,0x0000000001FFF800L});
    public static final BitSet FOLLOW_stmt_in_trystmt1057 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_59_in_returnstmt1075 = new BitSet(new long[]{0xE002801710101030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_returnstmt1080 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_returnstmt1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_throwstmt1100 = new BitSet(new long[]{0xE002801710101030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_throwstmt1105 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_throwstmt1111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_declAssign1127 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_declAssign1133 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_EQUAL_in_declAssign1138 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_declAssign1142 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTEND_in_declAssign1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_pkgname1164 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_pkgname1169 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_pkgname1173 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_set_in_reference1193 = new BitSet(new long[]{0x0000000050000002L});
    public static final BitSet FOLLOW_LPAREN_in_reference1205 = new BitSet(new long[]{0xE002801730001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_reference1214 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_50_in_reference1222 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_reference1226 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_reference1238 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_LARRAY_in_reference1244 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_reference1248 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RARRAY_in_reference1252 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_intconst_in_constant1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doubleconst_in_constant1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolconst_in_constant1286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringconst_in_constant1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nullconst_in_constant1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitive1320 = new BitSet(new long[]{0x0000001600000030L,0x0000000000003800L});
    public static final BitSet FOLLOW_constant_in_primitive1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitive1334 = new BitSet(new long[]{0x0002800100000030L});
    public static final BitSet FOLLOW_reference_in_primitive1344 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_primitive1349 = new BitSet(new long[]{0x0002800100000030L});
    public static final BitSet FOLLOW_reference_in_primitive1353 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_LPAREN_in_primitive1365 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_primitive1369 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_primitive1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_primitive1377 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_clstype_in_primitive1381 = new BitSet(new long[]{0x0000000010000030L});
    public static final BitSet FOLLOW_set_in_primitive1387 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_primitive1394 = new BitSet(new long[]{0xE002801730001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_primitive1401 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_50_in_primitive1409 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_primitive1413 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_primitive1424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_primitive1432 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_clstype_in_primitive1436 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_LARRAY_in_primitive1438 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_primitive1442 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RARRAY_in_primitive1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitive_in_prepostop1465 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_62_in_prepostop1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_prepostop1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_prepostop1486 = new BitSet(new long[]{0x2002801710000030L,0x0000000000003800L});
    public static final BitSet FOLLOW_primitive_in_prepostop1490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_prepostop1499 = new BitSet(new long[]{0x2002801710000030L,0x0000000000003800L});
    public static final BitSet FOLLOW_primitive_in_prepostop1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prepostop_in_notcastexpr1527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notcastexpr1537 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_notcastexpr_in_notcastexpr1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_notcastexpr1551 = new BitSet(new long[]{0x0000600100000000L,0x0000000001FFC000L});
    public static final BitSet FOLLOW_type_in_notcastexpr1555 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_notcastexpr1557 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_notcastexpr_in_notcastexpr1561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notcastexpr_in_multop1581 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_MULT_in_multop1589 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_notcastexpr_in_multop1593 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_DIV_in_multop1599 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_notcastexpr_in_multop1603 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_MOD_in_multop1609 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_notcastexpr_in_multop1613 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_multop_in_sumop1635 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_PLUS_in_sumop1643 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_multop_in_sumop1647 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_MINUS_in_sumop1653 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_multop_in_sumop1657 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_sumop_in_shiftop1679 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_RSHIFT_in_shiftop1687 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_sumop_in_shiftop1691 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_LSHIFT_in_shiftop1697 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_sumop_in_shiftop1701 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_shiftop_in_compop1724 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LESS_in_compop1732 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_shiftop_in_compop1736 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_MORE_in_compop1742 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_shiftop_in_compop1746 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LESSEQ_in_compop1752 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_shiftop_in_compop1756 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_MOREEQ_in_compop1762 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_shiftop_in_compop1766 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_compop_in_comp2op1789 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_EQUALS_in_comp2op1797 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_compop_in_comp2op1801 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_NEQUAL_in_comp2op1807 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_compop_in_comp2op1811 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_comp2op_in_bitwiseand1833 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_BITWISEAND_in_bitwiseand1841 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_comp2op_in_bitwiseand1845 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_bitwiseand_in_bitwiseor1867 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_BITWISEOR_in_bitwiseor1875 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_bitwiseand_in_bitwiseor1879 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_bitwiseor_in_bitwisexor1902 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_BITWISEXOR_in_bitwisexor1910 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_bitwiseor_in_bitwisexor1914 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_bitwisexor_in_logicaland1936 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_LOGAND_in_logicaland1944 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_bitwisexor_in_logicaland1948 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_logicaland_in_logicalor1970 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LOGOR_in_logicalor1978 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_logicaland_in_logicalor1982 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_logicalor_in_ternary2005 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ternary2013 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_logicalor_in_ternary2017 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ternary2019 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_logicalor_in_ternary2023 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_set_in_expression2044 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2054 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_EQUAL_in_expression2062 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2066 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_65_in_expression2074 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2078 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_66_in_expression2086 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2090 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_67_in_expression2098 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2102 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_68_in_expression2110 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2114 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_69_in_expression2122 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2126 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_70_in_expression2134 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2138 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_71_in_expression2146 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2150 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_72_in_expression2158 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2162 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_73_in_expression2170 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2174 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_74_in_expression2182 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2186 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_set_in_expression2198 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_expression2208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGCONST_PRIVATE_in_stringconst2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLECONST_PRIVATE_in_doubleconst2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTCONST_PRIVATE_in_intconst2323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_nullconst2401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_boolconst2415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_boolconst2420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativetype_in_type2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_clstype_in_type2444 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_LARRAY_in_type2451 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RARRAY_in_type2453 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_WORD_in_clstype2477 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_clstype2482 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_clstype2486 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_78_in_nativetype2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_nativetype2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_nativetype2526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_nativetype2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_nativetype2542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_nativetype2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_nativetype2558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_nativetype2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_nativetype2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_nativetype2582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_nativetype2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_accesscontrolkeyword2607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_accesscontrolkeyword2612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_accesscontrolkeyword2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_synpred30_PineDL908 = new BitSet(new long[]{0xFBBAE01714101030L,0x0000000001FFF800L});
    public static final BitSet FOLLOW_stmt_in_synpred30_PineDL912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_synpred33_PineDL1041 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_synpred33_PineDL1043 = new BitSet(new long[]{0x0000600100000000L,0x0000000001FFC000L});
    public static final BitSet FOLLOW_type_in_synpred33_PineDL1047 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_synpred33_PineDL1051 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred33_PineDL1053 = new BitSet(new long[]{0xFBBAE01714101030L,0x0000000001FFF800L});
    public static final BitSet FOLLOW_stmt_in_synpred33_PineDL1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prepostop_in_synpred65_PineDL1527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred99_PineDL2044 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_synpred99_PineDL2054 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_EQUAL_in_synpred99_PineDL2062 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_synpred99_PineDL2066 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_65_in_synpred99_PineDL2074 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_synpred99_PineDL2078 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_66_in_synpred99_PineDL2086 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_synpred99_PineDL2090 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_67_in_synpred99_PineDL2098 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_synpred99_PineDL2102 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_68_in_synpred99_PineDL2110 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_synpred99_PineDL2114 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_69_in_synpred99_PineDL2122 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_synpred99_PineDL2126 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_70_in_synpred99_PineDL2134 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_synpred99_PineDL2138 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_71_in_synpred99_PineDL2146 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_synpred99_PineDL2150 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_72_in_synpred99_PineDL2158 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_synpred99_PineDL2162 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_73_in_synpred99_PineDL2170 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_synpred99_PineDL2174 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_74_in_synpred99_PineDL2182 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_in_synpred99_PineDL2186 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});

}