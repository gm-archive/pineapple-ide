// $ANTLR 3.1.1 /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g 2009-06-24 22:06:56

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "MINUS", "MULT", "DIV", "MOD", "DOT", "SHIFT_R", "SHIFT_L", "NOT", "EQUAL", "LESS", "MORE", "LESS_EQ", "MORE_EQ", "EQUALS", "NOT_EQUAL", "STMT_END", "BITWISE_AND", "BITWISE_OR", "BITWISE_XOR", "LOG_AND", "LOG_OR", "BLK_BEG", "BLK_END", "PAREN_L", "PAREN_R", "ARRAY_L", "ARRAY_R", "WORD", "STRINGCONST_PRIVATE", "DOUBLECONST_PRIVATE", "DIGIT", "INTCONST_PRIVATE", "ALPHA", "SLCOMMENT", "MLCOMMENT", "WHITESPACE", "'package'", "'import'", "'class'", "'extends'", "'static'", "'final'", "'this'", "':'", "'super'", "','", "'break'", "'continue'", "'if'", "'else'", "'while'", "'for'", "'try'", "'catch'", "'return'", "'throw'", "'new'", "'++'", "'--'", "'?'", "'+='", "'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'null'", "'true'", "'false'", "'int'", "'float'", "'char'", "'bool'", "'string'", "'void'", "'public'", "'private'", "'protected'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int BITWISE_AND=21;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int MOD=8;
    public static final int SHIFT_L=11;
    public static final int DOUBLECONST_PRIVATE=34;
    public static final int SLCOMMENT=38;
    public static final int BITWISE_OR=22;
    public static final int PAREN_L=28;
    public static final int EQUALS=18;
    public static final int NOT=12;
    public static final int SHIFT_R=10;
    public static final int STRINGCONST_PRIVATE=33;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int PAREN_R=29;
    public static final int WORD=32;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int BITWISE_XOR=23;
    public static final int NOT_EQUAL=19;
    public static final int T__59=59;
    public static final int EQUAL=13;
    public static final int LESS=14;
    public static final int PLUS=4;
    public static final int LOG_OR=25;
    public static final int DIGIT=35;
    public static final int DOT=9;
    public static final int LOG_AND=24;
    public static final int T__50=50;
    public static final int MLCOMMENT=39;
    public static final int T__42=42;
    public static final int LESS_EQ=16;
    public static final int T__43=43;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__47=47;
    public static final int T__82=82;
    public static final int T__44=44;
    public static final int T__83=83;
    public static final int T__45=45;
    public static final int MORE_EQ=17;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int INTCONST_PRIVATE=36;
    public static final int WHITESPACE=40;
    public static final int MULT=6;
    public static final int MINUS=5;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__86=86;
    public static final int ALPHA=37;
    public static final int BLK_END=27;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int STMT_END=20;
    public static final int MORE=15;
    public static final int T__70=70;
    public static final int BLK_BEG=26;
    public static final int ARRAY_L=30;
    public static final int DIV=7;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int ARRAY_R=31;
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
    public String getGrammarFileName() { return "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g"; }


    	private PineClass target = null;



    // $ANTLR start "doc"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:160:1: doc returns [PineClass t] : ( pkgstmt )? ( importstmt )* clsdecl ;
    public final PineClass doc() throws RecognitionException {
        PineClass t = null;


        	target = new PineClass();

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:164:2: ( ( pkgstmt )? ( importstmt )* clsdecl )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:164:4: ( pkgstmt )? ( importstmt )* clsdecl
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:164:4: ( pkgstmt )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==41) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:0:0: pkgstmt
                    {
                    pushFollow(FOLLOW_pkgstmt_in_doc284);
                    pkgstmt();

                    state._fsp--;
                    if (state.failed) return t;

                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:165:3: ( importstmt )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==42) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:0:0: importstmt
            	    {
            	    pushFollow(FOLLOW_importstmt_in_doc289);
            	    importstmt();

            	    state._fsp--;
            	    if (state.failed) return t;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            pushFollow(FOLLOW_clsdecl_in_doc294);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:169:1: pkgstmt : 'package' s= pkgname STMT_END ;
    public final void pkgstmt() throws RecognitionException {
        String s = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:169:9: ( 'package' s= pkgname STMT_END )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:169:11: 'package' s= pkgname STMT_END
            {
            match(input,41,FOLLOW_41_in_pkgstmt306); if (state.failed) return ;
            pushFollow(FOLLOW_pkgname_in_pkgstmt310);
            s=pkgname();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              target.packageName = s.split("\\."); 
            }
            match(input,STMT_END,FOLLOW_STMT_END_in_pkgstmt314); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:171:1: importstmt : 'import' i= clstype STMT_END ;
    public final void importstmt() throws RecognitionException {
        Type i = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:172:2: ( 'import' i= clstype STMT_END )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:172:4: 'import' i= clstype STMT_END
            {
            match(input,42,FOLLOW_42_in_importstmt323); if (state.failed) return ;
            pushFollow(FOLLOW_clstype_in_importstmt327);
            i=clstype();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              target.importStmt.add(i);
            }
            match(input,STMT_END,FOLLOW_STMT_END_in_importstmt331); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:174:1: clsdecl : 'class' n= WORD ( 'extends' e= clstype )? BLK_BEG (f= field | m= method | c= constructor )* BLK_END ( STMT_END )? ;
    public final void clsdecl() throws RecognitionException {
        Token n=null;
        Type e = null;

        Variable f = null;

        Function m = null;

        Constructor c = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:174:9: ( 'class' n= WORD ( 'extends' e= clstype )? BLK_BEG (f= field | m= method | c= constructor )* BLK_END ( STMT_END )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:174:11: 'class' n= WORD ( 'extends' e= clstype )? BLK_BEG (f= field | m= method | c= constructor )* BLK_END ( STMT_END )?
            {
            match(input,43,FOLLOW_43_in_clsdecl340); if (state.failed) return ;
            n=(Token)match(input,WORD,FOLLOW_WORD_in_clsdecl344); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              target.clsName = n.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:174:58: ( 'extends' e= clstype )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==44) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:174:59: 'extends' e= clstype
                    {
                    match(input,44,FOLLOW_44_in_clsdecl349); if (state.failed) return ;
                    pushFollow(FOLLOW_clstype_in_clsdecl353);
                    e=clstype();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      target.superClass = e;
                    }

                    }
                    break;

            }

            match(input,BLK_BEG,FOLLOW_BLK_BEG_in_clsdecl361); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:176:3: (f= field | m= method | c= constructor )*
            loop4:
            do {
                int alt4=4;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:177:4: f= field
            	    {
            	    pushFollow(FOLLOW_field_in_clsdecl372);
            	    f=field();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	       target.variables.add(f); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:178:4: m= method
            	    {
            	    pushFollow(FOLLOW_method_in_clsdecl383);
            	    m=method();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	       target.functions.add(m); 
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:179:4: c= constructor
            	    {
            	    pushFollow(FOLLOW_constructor_in_clsdecl394);
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

            match(input,BLK_END,FOLLOW_BLK_END_in_clsdecl405); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:181:11: ( STMT_END )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==STMT_END) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:0:0: STMT_END
                    {
                    match(input,STMT_END,FOLLOW_STMT_END_in_clsdecl407); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:183:1: field returns [Variable v = new Variable()] : a= accesscontrolkeyword ( 'static' )? ( 'final' )? t= type n= WORD ( EQUAL d= expression )? STMT_END ;
    public final Variable field() throws RecognitionException {
        Variable v =  new Variable();

        Token n=null;
        AccessControlKeyword a = null;

        Type t = null;

        Expression d = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:184:2: (a= accesscontrolkeyword ( 'static' )? ( 'final' )? t= type n= WORD ( EQUAL d= expression )? STMT_END )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:184:4: a= accesscontrolkeyword ( 'static' )? ( 'final' )? t= type n= WORD ( EQUAL d= expression )? STMT_END
            {
            pushFollow(FOLLOW_accesscontrolkeyword_in_field424);
            a=accesscontrolkeyword();

            state._fsp--;
            if (state.failed) return v;
            if ( state.backtracking==0 ) {
              v.access = a;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:185:3: ( 'static' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==45) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:185:4: 'static'
                    {
                    match(input,45,FOLLOW_45_in_field431); if (state.failed) return v;
                    if ( state.backtracking==0 ) {
                      v.isStatic = true;
                    }

                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:186:3: ( 'final' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==46) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:186:4: 'final'
                    {
                    match(input,46,FOLLOW_46_in_field440); if (state.failed) return v;
                    if ( state.backtracking==0 ) {
                      v.isFinal = true;
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_type_in_field450);
            t=type();

            state._fsp--;
            if (state.failed) return v;
            if ( state.backtracking==0 ) {
              v.type = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_field458); if (state.failed) return v;
            if ( state.backtracking==0 ) {
              v.name = n.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:189:3: ( EQUAL d= expression )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==EQUAL) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:189:4: EQUAL d= expression
                    {
                    match(input,EQUAL,FOLLOW_EQUAL_in_field465); if (state.failed) return v;
                    pushFollow(FOLLOW_expression_in_field469);
                    d=expression();

                    state._fsp--;
                    if (state.failed) return v;
                    if ( state.backtracking==0 ) {
                      v.defaultValue = d;
                    }

                    }
                    break;

            }

            match(input,STMT_END,FOLLOW_STMT_END_in_field477); if (state.failed) return v;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:192:1: method returns [Function f = new Function()] : a= accesscontrolkeyword ( 'static' )? ( 'final' )? t= type n= WORD PAREN_L l= argumentlist PAREN_R b= block ;
    public final Function method() throws RecognitionException {
        Function f =  new Function();

        Token n=null;
        AccessControlKeyword a = null;

        Type t = null;

        Vector<Argument> l = null;

        Block b = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:193:2: (a= accesscontrolkeyword ( 'static' )? ( 'final' )? t= type n= WORD PAREN_L l= argumentlist PAREN_R b= block )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:193:4: a= accesscontrolkeyword ( 'static' )? ( 'final' )? t= type n= WORD PAREN_L l= argumentlist PAREN_R b= block
            {
            pushFollow(FOLLOW_accesscontrolkeyword_in_method494);
            a=accesscontrolkeyword();

            state._fsp--;
            if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.access = a;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:194:3: ( 'static' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==45) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:194:4: 'static'
                    {
                    match(input,45,FOLLOW_45_in_method501); if (state.failed) return f;
                    if ( state.backtracking==0 ) {
                      f.isStatic = true;
                    }

                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:195:3: ( 'final' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==46) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:195:4: 'final'
                    {
                    match(input,46,FOLLOW_46_in_method510); if (state.failed) return f;
                    if ( state.backtracking==0 ) {
                      f.isFinal = true;
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_type_in_method520);
            t=type();

            state._fsp--;
            if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.returnType = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_method528); if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.name = n.getText();
            }
            match(input,PAREN_L,FOLLOW_PAREN_L_in_method534); if (state.failed) return f;
            pushFollow(FOLLOW_argumentlist_in_method540);
            l=argumentlist();

            state._fsp--;
            if (state.failed) return f;
            if ( state.backtracking==0 ) {
              f.arguments = l;
            }
            match(input,PAREN_R,FOLLOW_PAREN_R_in_method546); if (state.failed) return f;
            pushFollow(FOLLOW_block_in_method552);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:203:1: constructor returns [Constructor c = new Constructor()] : a= accesscontrolkeyword 'this' PAREN_L l= argumentlist PAREN_R ( ':' 'super' PAREN_L (e= expression ( ',' e= expression )* )? PAREN_R )? b= block ;
    public final Constructor constructor() throws RecognitionException {
        Constructor c =  new Constructor();

        AccessControlKeyword a = null;

        Vector<Argument> l = null;

        Expression e = null;

        Block b = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:204:2: (a= accesscontrolkeyword 'this' PAREN_L l= argumentlist PAREN_R ( ':' 'super' PAREN_L (e= expression ( ',' e= expression )* )? PAREN_R )? b= block )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:204:4: a= accesscontrolkeyword 'this' PAREN_L l= argumentlist PAREN_R ( ':' 'super' PAREN_L (e= expression ( ',' e= expression )* )? PAREN_R )? b= block
            {
            pushFollow(FOLLOW_accesscontrolkeyword_in_constructor570);
            a=accesscontrolkeyword();

            state._fsp--;
            if (state.failed) return c;
            if ( state.backtracking==0 ) {
              c.access = a;
            }
            match(input,47,FOLLOW_47_in_constructor576); if (state.failed) return c;
            match(input,PAREN_L,FOLLOW_PAREN_L_in_constructor580); if (state.failed) return c;
            pushFollow(FOLLOW_argumentlist_in_constructor586);
            l=argumentlist();

            state._fsp--;
            if (state.failed) return c;
            if ( state.backtracking==0 ) {
              c.arguments = l;
            }
            match(input,PAREN_R,FOLLOW_PAREN_R_in_constructor592); if (state.failed) return c;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:209:3: ( ':' 'super' PAREN_L (e= expression ( ',' e= expression )* )? PAREN_R )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==48) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:209:4: ':' 'super' PAREN_L (e= expression ( ',' e= expression )* )? PAREN_R
                    {
                    match(input,48,FOLLOW_48_in_constructor597); if (state.failed) return c;
                    match(input,49,FOLLOW_49_in_constructor599); if (state.failed) return c;
                    if ( state.backtracking==0 ) {
                      c.superArguments = new Vector<Expression>();
                    }
                    match(input,PAREN_L,FOLLOW_PAREN_L_in_constructor606); if (state.failed) return c;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:211:4: (e= expression ( ',' e= expression )* )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>=PLUS && LA12_0<=MINUS)||LA12_0==NOT||LA12_0==PAREN_L||(LA12_0>=WORD && LA12_0<=DOUBLECONST_PRIVATE)||LA12_0==INTCONST_PRIVATE||LA12_0==47||LA12_0==49||(LA12_0>=61 && LA12_0<=63)||(LA12_0>=75 && LA12_0<=77)) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:211:5: e= expression ( ',' e= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_constructor614);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return c;
                            if ( state.backtracking==0 ) {
                              c.superArguments.add(e);
                            }
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:212:4: ( ',' e= expression )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==50) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:212:5: ',' e= expression
                            	    {
                            	    match(input,50,FOLLOW_50_in_constructor622); if (state.failed) return c;
                            	    pushFollow(FOLLOW_expression_in_constructor626);
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

                    match(input,PAREN_R,FOLLOW_PAREN_R_in_constructor637); if (state.failed) return c;

                    }
                    break;

            }

            pushFollow(FOLLOW_block_in_constructor645);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:216:1: argumentlist returns [Vector<Argument> v = new Vector<Argument>()] : (a= argument ( ',' a= argument )* )? ;
    public final Vector<Argument> argumentlist() throws RecognitionException {
        Vector<Argument> v =  new Vector<Argument>();

        Argument a = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:217:2: ( (a= argument ( ',' a= argument )* )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:217:4: (a= argument ( ',' a= argument )* )?
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:217:4: (a= argument ( ',' a= argument )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==WORD||(LA15_0>=78 && LA15_0<=83)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:217:5: a= argument ( ',' a= argument )*
                    {
                    pushFollow(FOLLOW_argument_in_argumentlist663);
                    a=argument();

                    state._fsp--;
                    if (state.failed) return v;
                    if ( state.backtracking==0 ) {
                      v.add(a);
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:217:28: ( ',' a= argument )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==50) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:217:29: ',' a= argument
                    	    {
                    	    match(input,50,FOLLOW_50_in_argumentlist668); if (state.failed) return v;
                    	    pushFollow(FOLLOW_argument_in_argumentlist672);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:219:1: argument returns [Argument a = new Argument()] : t= type n= WORD ;
    public final Argument argument() throws RecognitionException {
        Argument a =  new Argument();

        Token n=null;
        Type t = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:220:2: (t= type n= WORD )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:220:4: t= type n= WORD
            {
            pushFollow(FOLLOW_type_in_argument694);
            t=type();

            state._fsp--;
            if (state.failed) return a;
            if ( state.backtracking==0 ) {
              a.type = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_argument701); if (state.failed) return a;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:223:1: block returns [Block b = new Block()] : ( BLK_BEG (s= stmt )* BLK_END ) ;
    public final Block block() throws RecognitionException {
        Block b =  new Block();

        Leaf s = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:224:2: ( ( BLK_BEG (s= stmt )* BLK_END ) )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:224:4: ( BLK_BEG (s= stmt )* BLK_END )
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:224:4: ( BLK_BEG (s= stmt )* BLK_END )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:224:5: BLK_BEG (s= stmt )* BLK_END
            {
            match(input,BLK_BEG,FOLLOW_BLK_BEG_in_block717); if (state.failed) return b;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:224:13: (s= stmt )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=PLUS && LA16_0<=MINUS)||LA16_0==NOT||LA16_0==STMT_END||LA16_0==BLK_BEG||LA16_0==PAREN_L||(LA16_0>=WORD && LA16_0<=DOUBLECONST_PRIVATE)||LA16_0==INTCONST_PRIVATE||LA16_0==47||LA16_0==49||(LA16_0>=51 && LA16_0<=53)||(LA16_0>=55 && LA16_0<=57)||(LA16_0>=59 && LA16_0<=63)||(LA16_0>=75 && LA16_0<=83)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:224:14: s= stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_block722);
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

            match(input,BLK_END,FOLLOW_BLK_END_in_block728); if (state.failed) return b;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:226:1: stmt returns [Leaf l = null] : ( (e= declaration ) | (a= expression STMT_END ) | (b= returnstmt ) | (t= throwstmt ) | (c= ifstmt ) | (w= whilestmt ) | (f= forstmt ) | (d= block ) | (tr= trystmt ) | ( 'break' STMT_END ) | ( 'continue' STMT_END ) | STMT_END );
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
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:227:2: ( (e= declaration ) | (a= expression STMT_END ) | (b= returnstmt ) | (t= throwstmt ) | (c= ifstmt ) | (w= whilestmt ) | (f= forstmt ) | (d= block ) | (tr= trystmt ) | ( 'break' STMT_END ) | ( 'continue' STMT_END ) | STMT_END )
            int alt17=12;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:227:4: (e= declaration )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:227:4: (e= declaration )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:227:5: e= declaration
                    {
                    pushFollow(FOLLOW_declaration_in_stmt746);
                    e=declaration();

                    state._fsp--;
                    if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=e;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:228:4: (a= expression STMT_END )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:228:4: (a= expression STMT_END )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:228:5: a= expression STMT_END
                    {
                    pushFollow(FOLLOW_expression_in_stmt757);
                    a=expression();

                    state._fsp--;
                    if (state.failed) return l;
                    match(input,STMT_END,FOLLOW_STMT_END_in_stmt759); if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=a;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:229:4: (b= returnstmt )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:229:4: (b= returnstmt )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:229:5: b= returnstmt
                    {
                    pushFollow(FOLLOW_returnstmt_in_stmt770);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:230:4: (t= throwstmt )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:230:4: (t= throwstmt )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:230:5: t= throwstmt
                    {
                    pushFollow(FOLLOW_throwstmt_in_stmt781);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:231:4: (c= ifstmt )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:231:4: (c= ifstmt )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:231:5: c= ifstmt
                    {
                    pushFollow(FOLLOW_ifstmt_in_stmt792);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:232:4: (w= whilestmt )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:232:4: (w= whilestmt )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:232:5: w= whilestmt
                    {
                    pushFollow(FOLLOW_whilestmt_in_stmt803);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:233:4: (f= forstmt )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:233:4: (f= forstmt )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:233:5: f= forstmt
                    {
                    pushFollow(FOLLOW_forstmt_in_stmt814);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:234:4: (d= block )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:234:4: (d= block )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:234:5: d= block
                    {
                    pushFollow(FOLLOW_block_in_stmt825);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:235:4: (tr= trystmt )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:235:4: (tr= trystmt )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:235:5: tr= trystmt
                    {
                    pushFollow(FOLLOW_trystmt_in_stmt836);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:236:4: ( 'break' STMT_END )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:236:4: ( 'break' STMT_END )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:236:5: 'break' STMT_END
                    {
                    match(input,51,FOLLOW_51_in_stmt845); if (state.failed) return l;
                    match(input,STMT_END,FOLLOW_STMT_END_in_stmt847); if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=new BreakStatement();
                    }

                    }


                    }
                    break;
                case 11 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:237:4: ( 'continue' STMT_END )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:237:4: ( 'continue' STMT_END )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:237:5: 'continue' STMT_END
                    {
                    match(input,52,FOLLOW_52_in_stmt856); if (state.failed) return l;
                    match(input,STMT_END,FOLLOW_STMT_END_in_stmt858); if (state.failed) return l;
                    if ( state.backtracking==0 ) {
                      l=new ContinueStatement();
                    }

                    }


                    }
                    break;
                case 12 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:238:4: STMT_END
                    {
                    match(input,STMT_END,FOLLOW_STMT_END_in_stmt866); if (state.failed) return l;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:240:1: ifstmt returns [IfStatement ifCase = new IfStatement()] : 'if' PAREN_L s= expression PAREN_R q= stmt ( 'else' e= stmt )? ;
    public final IfStatement ifstmt() throws RecognitionException {
        IfStatement ifCase =  new IfStatement();

        Expression s = null;

        Leaf q = null;

        Leaf e = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:241:2: ( 'if' PAREN_L s= expression PAREN_R q= stmt ( 'else' e= stmt )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:241:4: 'if' PAREN_L s= expression PAREN_R q= stmt ( 'else' e= stmt )?
            {
            match(input,53,FOLLOW_53_in_ifstmt880); if (state.failed) return ifCase;
            match(input,PAREN_L,FOLLOW_PAREN_L_in_ifstmt882); if (state.failed) return ifCase;
            pushFollow(FOLLOW_expression_in_ifstmt886);
            s=expression();

            state._fsp--;
            if (state.failed) return ifCase;
            if ( state.backtracking==0 ) {
              ifCase.condition = s;
            }
            match(input,PAREN_R,FOLLOW_PAREN_R_in_ifstmt890); if (state.failed) return ifCase;
            pushFollow(FOLLOW_stmt_in_ifstmt896);
            q=stmt();

            state._fsp--;
            if (state.failed) return ifCase;
            if ( state.backtracking==0 ) {
              ifCase.then = q;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:243:3: ( 'else' e= stmt )?
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:243:4: 'else' e= stmt
                    {
                    match(input,54,FOLLOW_54_in_ifstmt903); if (state.failed) return ifCase;
                    pushFollow(FOLLOW_stmt_in_ifstmt907);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:245:1: whilestmt returns [WhileStatement whileCase = new WhileStatement()] : 'while' PAREN_L s= expression PAREN_R q= stmt ;
    public final WhileStatement whilestmt() throws RecognitionException {
        WhileStatement whileCase =  new WhileStatement();

        Expression s = null;

        Leaf q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:246:2: ( 'while' PAREN_L s= expression PAREN_R q= stmt )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:246:4: 'while' PAREN_L s= expression PAREN_R q= stmt
            {
            match(input,55,FOLLOW_55_in_whilestmt926); if (state.failed) return whileCase;
            match(input,PAREN_L,FOLLOW_PAREN_L_in_whilestmt928); if (state.failed) return whileCase;
            pushFollow(FOLLOW_expression_in_whilestmt932);
            s=expression();

            state._fsp--;
            if (state.failed) return whileCase;
            if ( state.backtracking==0 ) {
              whileCase.condition = s;
            }
            match(input,PAREN_R,FOLLOW_PAREN_R_in_whilestmt936); if (state.failed) return whileCase;
            pushFollow(FOLLOW_stmt_in_whilestmt942);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:249:1: forstmt returns [ForStatement forCase = new ForStatement()] : 'for' PAREN_L ( (a= expression STMT_END ) | b= declaration | STMT_END ) (s= expression ) STMT_END (d= expression ) PAREN_R q= stmt ;
    public final ForStatement forstmt() throws RecognitionException {
        ForStatement forCase =  new ForStatement();

        Expression a = null;

        DeclAssign b = null;

        Expression s = null;

        Expression d = null;

        Leaf q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:250:2: ( 'for' PAREN_L ( (a= expression STMT_END ) | b= declaration | STMT_END ) (s= expression ) STMT_END (d= expression ) PAREN_R q= stmt )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:250:4: 'for' PAREN_L ( (a= expression STMT_END ) | b= declaration | STMT_END ) (s= expression ) STMT_END (d= expression ) PAREN_R q= stmt
            {
            match(input,56,FOLLOW_56_in_forstmt959); if (state.failed) return forCase;
            match(input,PAREN_L,FOLLOW_PAREN_L_in_forstmt961); if (state.failed) return forCase;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:250:18: ( (a= expression STMT_END ) | b= declaration | STMT_END )
            int alt19=3;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:250:19: (a= expression STMT_END )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:250:19: (a= expression STMT_END )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:250:20: a= expression STMT_END
                    {
                    pushFollow(FOLLOW_expression_in_forstmt967);
                    a=expression();

                    state._fsp--;
                    if (state.failed) return forCase;
                    if ( state.backtracking==0 ) {
                      forCase.firstStatement = a;
                    }
                    match(input,STMT_END,FOLLOW_STMT_END_in_forstmt971); if (state.failed) return forCase;

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:250:73: b= declaration
                    {
                    pushFollow(FOLLOW_declaration_in_forstmt976);
                    b=declaration();

                    state._fsp--;
                    if (state.failed) return forCase;
                    if ( state.backtracking==0 ) {
                      forCase.firstStatement = b;
                    }

                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:250:117: STMT_END
                    {
                    match(input,STMT_END,FOLLOW_STMT_END_in_forstmt980); if (state.failed) return forCase;

                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:251:3: (s= expression )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:251:4: s= expression
            {
            pushFollow(FOLLOW_expression_in_forstmt988);
            s=expression();

            state._fsp--;
            if (state.failed) return forCase;
            if ( state.backtracking==0 ) {
              forCase.condition = s;
            }

            }

            match(input,STMT_END,FOLLOW_STMT_END_in_forstmt993); if (state.failed) return forCase;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:252:3: (d= expression )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:252:4: d= expression
            {
            pushFollow(FOLLOW_expression_in_forstmt1000);
            d=expression();

            state._fsp--;
            if (state.failed) return forCase;
            if ( state.backtracking==0 ) {
              forCase.loopStatement = d;
            }

            }

            match(input,PAREN_R,FOLLOW_PAREN_R_in_forstmt1005); if (state.failed) return forCase;
            pushFollow(FOLLOW_stmt_in_forstmt1011);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:255:1: trystmt returns [TryStatement tryStmt = new TryStatement()] : 'try' b= stmt ( 'catch' PAREN_L t= type n= WORD PAREN_R b= stmt )+ ;
    public final TryStatement trystmt() throws RecognitionException {
        TryStatement tryStmt =  new TryStatement();

        Token n=null;
        Leaf b = null;

        Type t = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:256:2: ( 'try' b= stmt ( 'catch' PAREN_L t= type n= WORD PAREN_R b= stmt )+ )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:256:4: 'try' b= stmt ( 'catch' PAREN_L t= type n= WORD PAREN_R b= stmt )+
            {
            match(input,57,FOLLOW_57_in_trystmt1026); if (state.failed) return tryStmt;
            pushFollow(FOLLOW_stmt_in_trystmt1030);
            b=stmt();

            state._fsp--;
            if (state.failed) return tryStmt;
            if ( state.backtracking==0 ) {
              tryStmt.then = b;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:257:2: ( 'catch' PAREN_L t= type n= WORD PAREN_R b= stmt )+
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
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:257:3: 'catch' PAREN_L t= type n= WORD PAREN_R b= stmt
            	    {
            	    match(input,58,FOLLOW_58_in_trystmt1036); if (state.failed) return tryStmt;
            	    match(input,PAREN_L,FOLLOW_PAREN_L_in_trystmt1038); if (state.failed) return tryStmt;
            	    pushFollow(FOLLOW_type_in_trystmt1042);
            	    t=type();

            	    state._fsp--;
            	    if (state.failed) return tryStmt;
            	    n=(Token)match(input,WORD,FOLLOW_WORD_in_trystmt1046); if (state.failed) return tryStmt;
            	    match(input,PAREN_R,FOLLOW_PAREN_R_in_trystmt1048); if (state.failed) return tryStmt;
            	    pushFollow(FOLLOW_stmt_in_trystmt1052);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:259:1: returnstmt returns [ReturnStatement ret = new ReturnStatement()] : 'return' (r= expression )? STMT_END ;
    public final ReturnStatement returnstmt() throws RecognitionException {
        ReturnStatement ret =  new ReturnStatement();

        Expression r = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:260:2: ( 'return' (r= expression )? STMT_END )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:260:4: 'return' (r= expression )? STMT_END
            {
            match(input,59,FOLLOW_59_in_returnstmt1070); if (state.failed) return ret;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:260:13: (r= expression )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=PLUS && LA21_0<=MINUS)||LA21_0==NOT||LA21_0==PAREN_L||(LA21_0>=WORD && LA21_0<=DOUBLECONST_PRIVATE)||LA21_0==INTCONST_PRIVATE||LA21_0==47||LA21_0==49||(LA21_0>=61 && LA21_0<=63)||(LA21_0>=75 && LA21_0<=77)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:260:14: r= expression
                    {
                    pushFollow(FOLLOW_expression_in_returnstmt1075);
                    r=expression();

                    state._fsp--;
                    if (state.failed) return ret;
                    if ( state.backtracking==0 ) {
                      ret.value = r;
                    }

                    }
                    break;

            }

            match(input,STMT_END,FOLLOW_STMT_END_in_returnstmt1081); if (state.failed) return ret;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:262:1: throwstmt returns [ThrowStatement ret = new ThrowStatement()] : 'throw' (r= expression )? STMT_END ;
    public final ThrowStatement throwstmt() throws RecognitionException {
        ThrowStatement ret =  new ThrowStatement();

        Expression r = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:263:2: ( 'throw' (r= expression )? STMT_END )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:263:4: 'throw' (r= expression )? STMT_END
            {
            match(input,60,FOLLOW_60_in_throwstmt1095); if (state.failed) return ret;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:263:12: (r= expression )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=PLUS && LA22_0<=MINUS)||LA22_0==NOT||LA22_0==PAREN_L||(LA22_0>=WORD && LA22_0<=DOUBLECONST_PRIVATE)||LA22_0==INTCONST_PRIVATE||LA22_0==47||LA22_0==49||(LA22_0>=61 && LA22_0<=63)||(LA22_0>=75 && LA22_0<=77)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:263:13: r= expression
                    {
                    pushFollow(FOLLOW_expression_in_throwstmt1100);
                    r=expression();

                    state._fsp--;
                    if (state.failed) return ret;
                    if ( state.backtracking==0 ) {
                      ret.value = r;
                    }

                    }
                    break;

            }

            match(input,STMT_END,FOLLOW_STMT_END_in_throwstmt1106); if (state.failed) return ret;

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


    // $ANTLR start "declaration"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:265:1: declaration returns [DeclAssign e = new DeclAssign()] : t= type n= WORD ( '=' ex= expression )? STMT_END ;
    public final DeclAssign declaration() throws RecognitionException {
        DeclAssign e =  new DeclAssign();

        Token n=null;
        Type t = null;

        Expression ex = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:266:2: (t= type n= WORD ( '=' ex= expression )? STMT_END )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:266:4: t= type n= WORD ( '=' ex= expression )? STMT_END
            {
            pushFollow(FOLLOW_type_in_declaration1122);
            t=type();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e.type = t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_declaration1128); if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e.name = n.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:266:56: ( '=' ex= expression )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==EQUAL) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:266:57: '=' ex= expression
                    {
                    match(input,EQUAL,FOLLOW_EQUAL_in_declaration1133); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_declaration1137);
                    ex=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e.value=ex;
                    }

                    }
                    break;

            }

            match(input,STMT_END,FOLLOW_STMT_END_in_declaration1143); if (state.failed) return e;

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
    // $ANTLR end "declaration"


    // $ANTLR start "pkgname"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:268:1: pkgname returns [String s = null] : (c= WORD ( '.' t= WORD )* ) ;
    public final String pkgname() throws RecognitionException {
        String s =  null;

        Token c=null;
        Token t=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:269:2: ( (c= WORD ( '.' t= WORD )* ) )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:269:4: (c= WORD ( '.' t= WORD )* )
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:269:4: (c= WORD ( '.' t= WORD )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:269:5: c= WORD ( '.' t= WORD )*
            {
            c=(Token)match(input,WORD,FOLLOW_WORD_in_pkgname1159); if (state.failed) return s;
            if ( state.backtracking==0 ) {
              s = c.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:269:31: ( '.' t= WORD )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==DOT) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:269:32: '.' t= WORD
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_pkgname1164); if (state.failed) return s;
            	    t=(Token)match(input,WORD,FOLLOW_WORD_in_pkgname1168); if (state.failed) return s;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:271:1: reference returns [Reference r = null] : ref= ( WORD | 'this' | 'super' ) ( PAREN_L (e= expression ( ',' e= expression )* )? PAREN_R )? ;
    public final Reference reference() throws RecognitionException {
        Reference r =  null;

        Token ref=null;
        Expression e = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:272:2: (ref= ( WORD | 'this' | 'super' ) ( PAREN_L (e= expression ( ',' e= expression )* )? PAREN_R )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:272:4: ref= ( WORD | 'this' | 'super' ) ( PAREN_L (e= expression ( ',' e= expression )* )? PAREN_R )?
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
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:274:2: ( PAREN_L (e= expression ( ',' e= expression )* )? PAREN_R )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==PAREN_L) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:274:3: PAREN_L (e= expression ( ',' e= expression )* )? PAREN_R
                    {
                    match(input,PAREN_L,FOLLOW_PAREN_L_in_reference1202); if (state.failed) return r;
                    if ( state.backtracking==0 ) {
                      r = new FunctionReference(ref.getText());
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:275:3: (e= expression ( ',' e= expression )* )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0>=PLUS && LA26_0<=MINUS)||LA26_0==NOT||LA26_0==PAREN_L||(LA26_0>=WORD && LA26_0<=DOUBLECONST_PRIVATE)||LA26_0==INTCONST_PRIVATE||LA26_0==47||LA26_0==49||(LA26_0>=61 && LA26_0<=63)||(LA26_0>=75 && LA26_0<=77)) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:275:4: e= expression ( ',' e= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_reference1211);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return r;
                            if ( state.backtracking==0 ) {
                              ((FunctionReference) r).arguments.add(e);
                            }
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:276:4: ( ',' e= expression )*
                            loop25:
                            do {
                                int alt25=2;
                                int LA25_0 = input.LA(1);

                                if ( (LA25_0==50) ) {
                                    alt25=1;
                                }


                                switch (alt25) {
                            	case 1 :
                            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:276:5: ',' e= expression
                            	    {
                            	    match(input,50,FOLLOW_50_in_reference1219); if (state.failed) return r;
                            	    pushFollow(FOLLOW_expression_in_reference1223);
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

                    match(input,PAREN_R,FOLLOW_PAREN_R_in_reference1235); if (state.failed) return r;

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
        return r;
    }
    // $ANTLR end "reference"


    // $ANTLR start "constant"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:280:1: constant returns [Constant c = null] : ( (i= intconst ) | (d= doubleconst ) | (b= boolconst ) | (s= stringconst ) | (n= nullconst ) );
    public final Constant constant() throws RecognitionException {
        Constant c =  null;

        IntConstant i = null;

        DoubleConstant d = null;

        BooleanConstant b = null;

        StringConstant s = null;

        NullConstant n = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:2: ( (i= intconst ) | (d= doubleconst ) | (b= boolconst ) | (s= stringconst ) | (n= nullconst ) )
            int alt28=5;
            switch ( input.LA(1) ) {
            case PLUS:
            case MINUS:
                {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==DOUBLECONST_PRIVATE) ) {
                    alt28=2;
                }
                else if ( (LA28_1==INTCONST_PRIVATE) ) {
                    alt28=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return c;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
                }
                break;
            case INTCONST_PRIVATE:
                {
                alt28=1;
                }
                break;
            case DOUBLECONST_PRIVATE:
                {
                alt28=2;
                }
                break;
            case 76:
            case 77:
                {
                alt28=3;
                }
                break;
            case STRINGCONST_PRIVATE:
                {
                alt28=4;
                }
                break;
            case 75:
                {
                alt28=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return c;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:4: (i= intconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:4: (i= intconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:5: i= intconst
                    {
                    pushFollow(FOLLOW_intconst_in_constant1253);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:24: (d= doubleconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:24: (d= doubleconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:25: d= doubleconst
                    {
                    pushFollow(FOLLOW_doubleconst_in_constant1261);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:47: (b= boolconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:47: (b= boolconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:48: b= boolconst
                    {
                    pushFollow(FOLLOW_boolconst_in_constant1269);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:68: (s= stringconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:68: (s= stringconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:69: s= stringconst
                    {
                    pushFollow(FOLLOW_stringconst_in_constant1277);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:91: (n= nullconst )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:91: (n= nullconst )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:281:92: n= nullconst
                    {
                    pushFollow(FOLLOW_nullconst_in_constant1285);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:285:1: primitive returns [Expression e = null] : (c= constant | s= ( MINUS | PLUS ) p= primitive | (r= reference ) | ( PAREN_L x= expression PAREN_R ) | ( 'new' t= clstype PAREN_L (ex= expression ( ',' ex= expression )* )? PAREN_R ) | ( 'new' t= type '[' x= expression ']' ) );
    public final Expression primitive() throws RecognitionException {
        Expression e =  null;

        Token s=null;
        Constant c = null;

        Expression p = null;

        Reference r = null;

        Expression x = null;

        Type t = null;

        Expression ex = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:286:2: (c= constant | s= ( MINUS | PLUS ) p= primitive | (r= reference ) | ( PAREN_L x= expression PAREN_R ) | ( 'new' t= clstype PAREN_L (ex= expression ( ',' ex= expression )* )? PAREN_R ) | ( 'new' t= type '[' x= expression ']' ) )
            int alt31=6;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:288:6: c= constant
                    {
                    pushFollow(FOLLOW_constant_in_primitive1317);
                    c=constant();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=c;
                    }

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:291:9: s= ( MINUS | PLUS ) p= primitive
                    {
                    s=(Token)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return e;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_primitive_in_primitive1352);
                    p=primitive();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e = (s.getText().equals("-")) ? new NegationOperation(p) : p;
                    }

                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:293:7: (r= reference )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:293:7: (r= reference )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:293:8: r= reference
                    {
                    pushFollow(FOLLOW_reference_in_primitive1371);
                    r=reference();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                       e = r; 
                    }

                    }


                    }
                    break;
                case 4 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:296:5: ( PAREN_L x= expression PAREN_R )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:296:5: ( PAREN_L x= expression PAREN_R )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:296:6: PAREN_L x= expression PAREN_R
                    {
                    match(input,PAREN_L,FOLLOW_PAREN_L_in_primitive1393); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_primitive1397);
                    x=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=x;
                    }
                    match(input,PAREN_R,FOLLOW_PAREN_R_in_primitive1401); if (state.failed) return e;

                    }


                    }
                    break;
                case 5 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:300:2: ( 'new' t= clstype PAREN_L (ex= expression ( ',' ex= expression )* )? PAREN_R )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:300:2: ( 'new' t= clstype PAREN_L (ex= expression ( ',' ex= expression )* )? PAREN_R )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:301:3: 'new' t= clstype PAREN_L (ex= expression ( ',' ex= expression )* )? PAREN_R
                    {
                    match(input,61,FOLLOW_61_in_primitive1424); if (state.failed) return e;
                    pushFollow(FOLLOW_clstype_in_primitive1428);
                    t=clstype();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=new NewCall(t);
                    }
                    match(input,PAREN_L,FOLLOW_PAREN_L_in_primitive1435); if (state.failed) return e;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:304:3: (ex= expression ( ',' ex= expression )* )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( ((LA30_0>=PLUS && LA30_0<=MINUS)||LA30_0==NOT||LA30_0==PAREN_L||(LA30_0>=WORD && LA30_0<=DOUBLECONST_PRIVATE)||LA30_0==INTCONST_PRIVATE||LA30_0==47||LA30_0==49||(LA30_0>=61 && LA30_0<=63)||(LA30_0>=75 && LA30_0<=77)) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:304:4: ex= expression ( ',' ex= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_primitive1446);
                            ex=expression();

                            state._fsp--;
                            if (state.failed) return e;
                            if ( state.backtracking==0 ) {
                               ((NewCall) e).arguments.add(ex); 
                            }
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:306:3: ( ',' ex= expression )*
                            loop29:
                            do {
                                int alt29=2;
                                int LA29_0 = input.LA(1);

                                if ( (LA29_0==50) ) {
                                    alt29=1;
                                }


                                switch (alt29) {
                            	case 1 :
                            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:306:4: ',' ex= expression
                            	    {
                            	    match(input,50,FOLLOW_50_in_primitive1457); if (state.failed) return e;
                            	    pushFollow(FOLLOW_expression_in_primitive1461);
                            	    ex=expression();

                            	    state._fsp--;
                            	    if (state.failed) return e;
                            	    if ( state.backtracking==0 ) {
                            	      ((NewCall) e).arguments.add(ex);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop29;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,PAREN_R,FOLLOW_PAREN_R_in_primitive1471); if (state.failed) return e;

                    }


                    }
                    break;
                case 6 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:310:5: ( 'new' t= type '[' x= expression ']' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:310:5: ( 'new' t= type '[' x= expression ']' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:310:6: 'new' t= type '[' x= expression ']'
                    {
                    match(input,61,FOLLOW_61_in_primitive1486); if (state.failed) return e;
                    pushFollow(FOLLOW_type_in_primitive1490);
                    t=type();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,ARRAY_L,FOLLOW_ARRAY_L_in_primitive1492); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_primitive1496);
                    x=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,ARRAY_R,FOLLOW_ARRAY_R_in_primitive1498); if (state.failed) return e;
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


    // $ANTLR start "reference_checked"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:312:1: reference_checked returns [Expression e = null] : t= primitive ( ( '.' ) b= reference )* ( ARRAY_L i= expression ARRAY_R )* ;
    public final Expression reference_checked() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Reference b = null;

        Expression i = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:313:1: (t= primitive ( ( '.' ) b= reference )* ( ARRAY_L i= expression ARRAY_R )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:314:2: t= primitive ( ( '.' ) b= reference )* ( ARRAY_L i= expression ARRAY_R )*
            {
            pushFollow(FOLLOW_primitive_in_reference_checked1516);
            t=primitive();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e = t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:316:2: ( ( '.' ) b= reference )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==DOT) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:316:3: ( '.' ) b= reference
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:316:3: ( '.' )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:316:4: '.'
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_reference_checked1525); if (state.failed) return e;

            	    }

            	    pushFollow(FOLLOW_reference_in_reference_checked1530);
            	    b=reference();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e = new RetrieverExpression(e, b);
            	    }

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:318:2: ( ARRAY_L i= expression ARRAY_R )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==ARRAY_L) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:318:3: ARRAY_L i= expression ARRAY_R
            	    {
            	    match(input,ARRAY_L,FOLLOW_ARRAY_L_in_reference_checked1540); if (state.failed) return e;
            	    pushFollow(FOLLOW_expression_in_reference_checked1544);
            	    i=expression();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e = new ArrayReference(e, i); 
            	    }
            	    match(input,ARRAY_R,FOLLOW_ARRAY_R_in_reference_checked1548); if (state.failed) return e;

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
    // $ANTLR end "reference_checked"


    // $ANTLR start "pre_post_op"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:321:1: pre_post_op returns [Expression e = null] : ( (p= reference_checked ( '++' | '--' )? ) | ( '++' q= primitive ) | ( '--' q= primitive ) );
    public final Expression pre_post_op() throws RecognitionException {
        Expression e =  null;

        Expression p = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:322:2: ( (p= reference_checked ( '++' | '--' )? ) | ( '++' q= primitive ) | ( '--' q= primitive ) )
            int alt35=3;
            switch ( input.LA(1) ) {
            case PLUS:
            case MINUS:
            case PAREN_L:
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
                alt35=1;
                }
                break;
            case 62:
                {
                alt35=2;
                }
                break;
            case 63:
                {
                alt35=3;
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:324:3: (p= reference_checked ( '++' | '--' )? )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:324:3: (p= reference_checked ( '++' | '--' )? )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:324:4: p= reference_checked ( '++' | '--' )?
                    {
                    pushFollow(FOLLOW_reference_checked_in_pre_post_op1572);
                    p=reference_checked();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=p;
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:325:3: ( '++' | '--' )?
                    int alt34=3;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==62) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==63) ) {
                        alt34=2;
                    }
                    switch (alt34) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:326:4: '++'
                            {
                            match(input,62,FOLLOW_62_in_pre_post_op1583); if (state.failed) return e;
                            if ( state.backtracking==0 ) {
                              e=new PrePostFixOperator(false, true, e);
                            }

                            }
                            break;
                        case 2 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:327:4: '--'
                            {
                            match(input,63,FOLLOW_63_in_pre_post_op1590); if (state.failed) return e;
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:330:3: ( '++' q= primitive )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:330:3: ( '++' q= primitive )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:330:4: '++' q= primitive
                    {
                    match(input,62,FOLLOW_62_in_pre_post_op1605); if (state.failed) return e;
                    pushFollow(FOLLOW_primitive_in_pre_post_op1609);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:331:3: ( '--' q= primitive )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:331:3: ( '--' q= primitive )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:331:4: '--' q= primitive
                    {
                    match(input,63,FOLLOW_63_in_pre_post_op1617); if (state.failed) return e;
                    pushFollow(FOLLOW_primitive_in_pre_post_op1621);
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
    // $ANTLR end "pre_post_op"


    // $ANTLR start "notcastexpr"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:333:1: notcastexpr returns [Expression e = null] : ( (p= pre_post_op ) | ( NOT p= notcastexpr ) | ( PAREN_L t= type PAREN_R p= notcastexpr ) );
    public final Expression notcastexpr() throws RecognitionException {
        Expression e =  null;

        Expression p = null;

        Type t = null;



        TypeCast cast = null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:337:2: ( (p= pre_post_op ) | ( NOT p= notcastexpr ) | ( PAREN_L t= type PAREN_R p= notcastexpr ) )
            int alt36=3;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:337:4: (p= pre_post_op )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:337:4: (p= pre_post_op )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:337:5: p= pre_post_op
                    {
                    pushFollow(FOLLOW_pre_post_op_in_notcastexpr1645);
                    p=pre_post_op();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e=p;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:338:5: ( NOT p= notcastexpr )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:338:5: ( NOT p= notcastexpr )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:338:6: NOT p= notcastexpr
                    {
                    match(input,NOT,FOLLOW_NOT_in_notcastexpr1655); if (state.failed) return e;
                    pushFollow(FOLLOW_notcastexpr_in_notcastexpr1659);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:339:5: ( PAREN_L t= type PAREN_R p= notcastexpr )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:339:5: ( PAREN_L t= type PAREN_R p= notcastexpr )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:339:6: PAREN_L t= type PAREN_R p= notcastexpr
                    {
                    match(input,PAREN_L,FOLLOW_PAREN_L_in_notcastexpr1669); if (state.failed) return e;
                    pushFollow(FOLLOW_type_in_notcastexpr1673);
                    t=type();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,PAREN_R,FOLLOW_PAREN_R_in_notcastexpr1675); if (state.failed) return e;
                    pushFollow(FOLLOW_notcastexpr_in_notcastexpr1679);
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


    // $ANTLR start "mult_op"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:341:1: mult_op returns [Expression e = null] : t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )* ;
    public final Expression mult_op() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:342:2: (t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:342:4: t= notcastexpr ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )*
            {
            pushFollow(FOLLOW_notcastexpr_in_mult_op1699);
            t=notcastexpr();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:342:25: ( ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=MULT && LA38_0<=MOD)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:343:2: ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:343:2: ( MULT q= notcastexpr | DIV q= notcastexpr | MOD q= notcastexpr )
            	    int alt37=3;
            	    switch ( input.LA(1) ) {
            	    case MULT:
            	        {
            	        alt37=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt37=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt37=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 37, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt37) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:343:3: MULT q= notcastexpr
            	            {
            	            match(input,MULT,FOLLOW_MULT_in_mult_op1707); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_mult_op1711);
            	            q=notcastexpr();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new MultiplyOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:344:3: DIV q= notcastexpr
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_mult_op1717); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_mult_op1721);
            	            q=notcastexpr();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new DivisionOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:345:3: MOD q= notcastexpr
            	            {
            	            match(input,MOD,FOLLOW_MOD_in_mult_op1727); if (state.failed) return e;
            	            pushFollow(FOLLOW_notcastexpr_in_mult_op1731);
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
    // $ANTLR end "mult_op"


    // $ANTLR start "sum_op"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:348:1: sum_op returns [Expression e = null] : t= mult_op ( ( PLUS q= mult_op | MINUS q= mult_op ) )* ;
    public final Expression sum_op() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:349:2: (t= mult_op ( ( PLUS q= mult_op | MINUS q= mult_op ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:349:4: t= mult_op ( ( PLUS q= mult_op | MINUS q= mult_op ) )*
            {
            pushFollow(FOLLOW_mult_op_in_sum_op1753);
            t=mult_op();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:349:21: ( ( PLUS q= mult_op | MINUS q= mult_op ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=PLUS && LA40_0<=MINUS)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:350:2: ( PLUS q= mult_op | MINUS q= mult_op )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:350:2: ( PLUS q= mult_op | MINUS q= mult_op )
            	    int alt39=2;
            	    int LA39_0 = input.LA(1);

            	    if ( (LA39_0==PLUS) ) {
            	        alt39=1;
            	    }
            	    else if ( (LA39_0==MINUS) ) {
            	        alt39=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 39, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt39) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:350:3: PLUS q= mult_op
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_sum_op1761); if (state.failed) return e;
            	            pushFollow(FOLLOW_mult_op_in_sum_op1765);
            	            q=mult_op();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new SumOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:351:3: MINUS q= mult_op
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_sum_op1771); if (state.failed) return e;
            	            pushFollow(FOLLOW_mult_op_in_sum_op1775);
            	            q=mult_op();

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
    // $ANTLR end "sum_op"


    // $ANTLR start "bitw_shift_op"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:354:1: bitw_shift_op returns [Expression e = null] : t= sum_op ( ( SHIFT_R q= sum_op | SHIFT_L q= sum_op ) )* ;
    public final Expression bitw_shift_op() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:355:2: (t= sum_op ( ( SHIFT_R q= sum_op | SHIFT_L q= sum_op ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:355:4: t= sum_op ( ( SHIFT_R q= sum_op | SHIFT_L q= sum_op ) )*
            {
            pushFollow(FOLLOW_sum_op_in_bitw_shift_op1797);
            t=sum_op();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:355:20: ( ( SHIFT_R q= sum_op | SHIFT_L q= sum_op ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=SHIFT_R && LA42_0<=SHIFT_L)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:356:2: ( SHIFT_R q= sum_op | SHIFT_L q= sum_op )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:356:2: ( SHIFT_R q= sum_op | SHIFT_L q= sum_op )
            	    int alt41=2;
            	    int LA41_0 = input.LA(1);

            	    if ( (LA41_0==SHIFT_R) ) {
            	        alt41=1;
            	    }
            	    else if ( (LA41_0==SHIFT_L) ) {
            	        alt41=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 41, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt41) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:356:3: SHIFT_R q= sum_op
            	            {
            	            match(input,SHIFT_R,FOLLOW_SHIFT_R_in_bitw_shift_op1805); if (state.failed) return e;
            	            pushFollow(FOLLOW_sum_op_in_bitw_shift_op1809);
            	            q=sum_op();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new RShiftOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:357:3: SHIFT_L q= sum_op
            	            {
            	            match(input,SHIFT_L,FOLLOW_SHIFT_L_in_bitw_shift_op1815); if (state.failed) return e;
            	            pushFollow(FOLLOW_sum_op_in_bitw_shift_op1819);
            	            q=sum_op();

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
    // $ANTLR end "bitw_shift_op"


    // $ANTLR start "compop"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:360:1: compop returns [Expression e = null] : t= bitw_shift_op ( ( LESS q= bitw_shift_op | MORE q= bitw_shift_op | LESS_EQ q= bitw_shift_op | MORE_EQ q= bitw_shift_op ) )* ;
    public final Expression compop() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:361:2: (t= bitw_shift_op ( ( LESS q= bitw_shift_op | MORE q= bitw_shift_op | LESS_EQ q= bitw_shift_op | MORE_EQ q= bitw_shift_op ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:361:4: t= bitw_shift_op ( ( LESS q= bitw_shift_op | MORE q= bitw_shift_op | LESS_EQ q= bitw_shift_op | MORE_EQ q= bitw_shift_op ) )*
            {
            pushFollow(FOLLOW_bitw_shift_op_in_compop1842);
            t=bitw_shift_op();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:361:27: ( ( LESS q= bitw_shift_op | MORE q= bitw_shift_op | LESS_EQ q= bitw_shift_op | MORE_EQ q= bitw_shift_op ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=LESS && LA44_0<=MORE_EQ)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:362:2: ( LESS q= bitw_shift_op | MORE q= bitw_shift_op | LESS_EQ q= bitw_shift_op | MORE_EQ q= bitw_shift_op )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:362:2: ( LESS q= bitw_shift_op | MORE q= bitw_shift_op | LESS_EQ q= bitw_shift_op | MORE_EQ q= bitw_shift_op )
            	    int alt43=4;
            	    switch ( input.LA(1) ) {
            	    case LESS:
            	        {
            	        alt43=1;
            	        }
            	        break;
            	    case MORE:
            	        {
            	        alt43=2;
            	        }
            	        break;
            	    case LESS_EQ:
            	        {
            	        alt43=3;
            	        }
            	        break;
            	    case MORE_EQ:
            	        {
            	        alt43=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 43, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt43) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:362:3: LESS q= bitw_shift_op
            	            {
            	            match(input,LESS,FOLLOW_LESS_in_compop1850); if (state.failed) return e;
            	            pushFollow(FOLLOW_bitw_shift_op_in_compop1854);
            	            q=bitw_shift_op();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new LessOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:363:3: MORE q= bitw_shift_op
            	            {
            	            match(input,MORE,FOLLOW_MORE_in_compop1860); if (state.failed) return e;
            	            pushFollow(FOLLOW_bitw_shift_op_in_compop1864);
            	            q=bitw_shift_op();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new MoreOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:364:3: LESS_EQ q= bitw_shift_op
            	            {
            	            match(input,LESS_EQ,FOLLOW_LESS_EQ_in_compop1870); if (state.failed) return e;
            	            pushFollow(FOLLOW_bitw_shift_op_in_compop1874);
            	            q=bitw_shift_op();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new LessEqualOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:365:3: MORE_EQ q= bitw_shift_op
            	            {
            	            match(input,MORE_EQ,FOLLOW_MORE_EQ_in_compop1880); if (state.failed) return e;
            	            pushFollow(FOLLOW_bitw_shift_op_in_compop1884);
            	            q=bitw_shift_op();

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
    // $ANTLR end "compop"


    // $ANTLR start "comp2op"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:368:1: comp2op returns [Expression e = null] : t= compop ( ( EQUALS q= compop | NOT_EQUAL q= compop ) )* ;
    public final Expression comp2op() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:369:2: (t= compop ( ( EQUALS q= compop | NOT_EQUAL q= compop ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:369:4: t= compop ( ( EQUALS q= compop | NOT_EQUAL q= compop ) )*
            {
            pushFollow(FOLLOW_compop_in_comp2op1907);
            t=compop();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:369:20: ( ( EQUALS q= compop | NOT_EQUAL q= compop ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=EQUALS && LA46_0<=NOT_EQUAL)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:370:2: ( EQUALS q= compop | NOT_EQUAL q= compop )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:370:2: ( EQUALS q= compop | NOT_EQUAL q= compop )
            	    int alt45=2;
            	    int LA45_0 = input.LA(1);

            	    if ( (LA45_0==EQUALS) ) {
            	        alt45=1;
            	    }
            	    else if ( (LA45_0==NOT_EQUAL) ) {
            	        alt45=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 45, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt45) {
            	        case 1 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:370:3: EQUALS q= compop
            	            {
            	            match(input,EQUALS,FOLLOW_EQUALS_in_comp2op1915); if (state.failed) return e;
            	            pushFollow(FOLLOW_compop_in_comp2op1919);
            	            q=compop();

            	            state._fsp--;
            	            if (state.failed) return e;
            	            if ( state.backtracking==0 ) {
            	              e=new EqualsOperation(e, q);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:371:3: NOT_EQUAL q= compop
            	            {
            	            match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_comp2op1925); if (state.failed) return e;
            	            pushFollow(FOLLOW_compop_in_comp2op1929);
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
            	    break loop46;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:374:1: bitwiseand returns [Expression e = null] : t= comp2op ( ( BITWISE_AND q= comp2op ) )* ;
    public final Expression bitwiseand() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:375:2: (t= comp2op ( ( BITWISE_AND q= comp2op ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:375:4: t= comp2op ( ( BITWISE_AND q= comp2op ) )*
            {
            pushFollow(FOLLOW_comp2op_in_bitwiseand1951);
            t=comp2op();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:375:21: ( ( BITWISE_AND q= comp2op ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==BITWISE_AND) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:376:2: ( BITWISE_AND q= comp2op )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:376:2: ( BITWISE_AND q= comp2op )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:376:3: BITWISE_AND q= comp2op
            	    {
            	    match(input,BITWISE_AND,FOLLOW_BITWISE_AND_in_bitwiseand1959); if (state.failed) return e;
            	    pushFollow(FOLLOW_comp2op_in_bitwiseand1963);
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
    // $ANTLR end "bitwiseand"


    // $ANTLR start "bitwiseor"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:379:1: bitwiseor returns [Expression e = null] : t= bitwiseand ( ( BITWISE_OR q= bitwiseand ) )* ;
    public final Expression bitwiseor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:380:2: (t= bitwiseand ( ( BITWISE_OR q= bitwiseand ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:380:4: t= bitwiseand ( ( BITWISE_OR q= bitwiseand ) )*
            {
            pushFollow(FOLLOW_bitwiseand_in_bitwiseor1985);
            t=bitwiseand();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:380:24: ( ( BITWISE_OR q= bitwiseand ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==BITWISE_OR) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:381:2: ( BITWISE_OR q= bitwiseand )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:381:2: ( BITWISE_OR q= bitwiseand )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:381:3: BITWISE_OR q= bitwiseand
            	    {
            	    match(input,BITWISE_OR,FOLLOW_BITWISE_OR_in_bitwiseor1993); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwiseand_in_bitwiseor1997);
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
            	    break loop48;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:384:1: bitwisexor returns [Expression e = null] : t= bitwiseor ( ( BITWISE_XOR q= bitwiseor ) )* ;
    public final Expression bitwisexor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:385:2: (t= bitwiseor ( ( BITWISE_XOR q= bitwiseor ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:385:4: t= bitwiseor ( ( BITWISE_XOR q= bitwiseor ) )*
            {
            pushFollow(FOLLOW_bitwiseor_in_bitwisexor2020);
            t=bitwiseor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:385:23: ( ( BITWISE_XOR q= bitwiseor ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==BITWISE_XOR) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:386:2: ( BITWISE_XOR q= bitwiseor )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:386:2: ( BITWISE_XOR q= bitwiseor )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:386:3: BITWISE_XOR q= bitwiseor
            	    {
            	    match(input,BITWISE_XOR,FOLLOW_BITWISE_XOR_in_bitwisexor2028); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwiseor_in_bitwisexor2032);
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
    // $ANTLR end "bitwisexor"


    // $ANTLR start "logicaland"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:389:1: logicaland returns [Expression e = null] : t= bitwisexor ( ( LOG_AND q= bitwisexor ) )* ;
    public final Expression logicaland() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:390:2: (t= bitwisexor ( ( LOG_AND q= bitwisexor ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:390:4: t= bitwisexor ( ( LOG_AND q= bitwisexor ) )*
            {
            pushFollow(FOLLOW_bitwisexor_in_logicaland2054);
            t=bitwisexor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:390:24: ( ( LOG_AND q= bitwisexor ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==LOG_AND) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:391:2: ( LOG_AND q= bitwisexor )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:391:2: ( LOG_AND q= bitwisexor )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:391:3: LOG_AND q= bitwisexor
            	    {
            	    match(input,LOG_AND,FOLLOW_LOG_AND_in_logicaland2062); if (state.failed) return e;
            	    pushFollow(FOLLOW_bitwisexor_in_logicaland2066);
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
    // $ANTLR end "logicaland"


    // $ANTLR start "logicalor"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:394:1: logicalor returns [Expression e = null] : t= logicaland ( ( LOG_OR q= logicaland ) )* ;
    public final Expression logicalor() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:395:2: (t= logicaland ( ( LOG_OR q= logicaland ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:395:4: t= logicaland ( ( LOG_OR q= logicaland ) )*
            {
            pushFollow(FOLLOW_logicaland_in_logicalor2088);
            t=logicaland();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:395:24: ( ( LOG_OR q= logicaland ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==LOG_OR) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:396:2: ( LOG_OR q= logicaland )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:396:2: ( LOG_OR q= logicaland )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:396:3: LOG_OR q= logicaland
            	    {
            	    match(input,LOG_OR,FOLLOW_LOG_OR_in_logicalor2096); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicaland_in_logicalor2100);
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
    // $ANTLR end "logicalor"


    // $ANTLR start "ternary_conditional"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:399:1: ternary_conditional returns [Expression e = null] : t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )* ;
    public final Expression ternary_conditional() throws RecognitionException {
        Expression e =  null;

        Expression t = null;

        Expression p = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:400:2: (t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:400:4: t= logicalor ( ( '?' p= logicalor ':' q= logicalor ) )*
            {
            pushFollow(FOLLOW_logicalor_in_ternary_conditional2123);
            t=logicalor();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=t;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:400:23: ( ( '?' p= logicalor ':' q= logicalor ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==64) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:401:2: ( '?' p= logicalor ':' q= logicalor )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:401:2: ( '?' p= logicalor ':' q= logicalor )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:401:3: '?' p= logicalor ':' q= logicalor
            	    {
            	    match(input,64,FOLLOW_64_in_ternary_conditional2131); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicalor_in_ternary_conditional2135);
            	    p=logicalor();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    match(input,48,FOLLOW_48_in_ternary_conditional2137); if (state.failed) return e;
            	    pushFollow(FOLLOW_logicalor_in_ternary_conditional2141);
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
    // $ANTLR end "ternary_conditional"


    // $ANTLR start "expression"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:404:1: expression returns [Expression e = null] : r= ternary_conditional ( ( EQUAL q= ternary_conditional ) | ( '+=' q= ternary_conditional ) | ( '-=' q= ternary_conditional ) | ( '*=' q= ternary_conditional ) | ( '/=' q= ternary_conditional ) | ( '%=' q= ternary_conditional ) | ( '&=' q= ternary_conditional ) | ( '|=' q= ternary_conditional ) | ( '^=' q= ternary_conditional ) | ( '<<=' q= ternary_conditional ) | ( '>>=' q= ternary_conditional ) )* ;
    public final Expression expression() throws RecognitionException {
        Expression e =  null;

        Expression r = null;

        Expression q = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:405:2: (r= ternary_conditional ( ( EQUAL q= ternary_conditional ) | ( '+=' q= ternary_conditional ) | ( '-=' q= ternary_conditional ) | ( '*=' q= ternary_conditional ) | ( '/=' q= ternary_conditional ) | ( '%=' q= ternary_conditional ) | ( '&=' q= ternary_conditional ) | ( '|=' q= ternary_conditional ) | ( '^=' q= ternary_conditional ) | ( '<<=' q= ternary_conditional ) | ( '>>=' q= ternary_conditional ) )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:405:4: r= ternary_conditional ( ( EQUAL q= ternary_conditional ) | ( '+=' q= ternary_conditional ) | ( '-=' q= ternary_conditional ) | ( '*=' q= ternary_conditional ) | ( '/=' q= ternary_conditional ) | ( '%=' q= ternary_conditional ) | ( '&=' q= ternary_conditional ) | ( '|=' q= ternary_conditional ) | ( '^=' q= ternary_conditional ) | ( '<<=' q= ternary_conditional ) | ( '>>=' q= ternary_conditional ) )*
            {
            pushFollow(FOLLOW_ternary_conditional_in_expression2164);
            r=ternary_conditional();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e=r;
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:405:33: ( ( EQUAL q= ternary_conditional ) | ( '+=' q= ternary_conditional ) | ( '-=' q= ternary_conditional ) | ( '*=' q= ternary_conditional ) | ( '/=' q= ternary_conditional ) | ( '%=' q= ternary_conditional ) | ( '&=' q= ternary_conditional ) | ( '|=' q= ternary_conditional ) | ( '^=' q= ternary_conditional ) | ( '<<=' q= ternary_conditional ) | ( '>>=' q= ternary_conditional ) )*
            loop53:
            do {
                int alt53=12;
                switch ( input.LA(1) ) {
                case EQUAL:
                    {
                    alt53=1;
                    }
                    break;
                case 65:
                    {
                    alt53=2;
                    }
                    break;
                case 66:
                    {
                    alt53=3;
                    }
                    break;
                case 67:
                    {
                    alt53=4;
                    }
                    break;
                case 68:
                    {
                    alt53=5;
                    }
                    break;
                case 69:
                    {
                    alt53=6;
                    }
                    break;
                case 70:
                    {
                    alt53=7;
                    }
                    break;
                case 71:
                    {
                    alt53=8;
                    }
                    break;
                case 72:
                    {
                    alt53=9;
                    }
                    break;
                case 73:
                    {
                    alt53=10;
                    }
                    break;
                case 74:
                    {
                    alt53=11;
                    }
                    break;

                }

                switch (alt53) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:406:2: ( EQUAL q= ternary_conditional )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:406:2: ( EQUAL q= ternary_conditional )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:406:3: EQUAL q= ternary_conditional
            	    {
            	    match(input,EQUAL,FOLLOW_EQUAL_in_expression2172); if (state.failed) return e;
            	    pushFollow(FOLLOW_ternary_conditional_in_expression2176);
            	    q=ternary_conditional();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new EqualOperation(e, q);
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:407:3: ( '+=' q= ternary_conditional )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:407:3: ( '+=' q= ternary_conditional )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:407:4: '+=' q= ternary_conditional
            	    {
            	    match(input,65,FOLLOW_65_in_expression2184); if (state.failed) return e;
            	    pushFollow(FOLLOW_ternary_conditional_in_expression2188);
            	    q=ternary_conditional();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new EqualOperation(e, new SumOperation(e,q));
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:408:3: ( '-=' q= ternary_conditional )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:408:3: ( '-=' q= ternary_conditional )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:408:4: '-=' q= ternary_conditional
            	    {
            	    match(input,66,FOLLOW_66_in_expression2196); if (state.failed) return e;
            	    pushFollow(FOLLOW_ternary_conditional_in_expression2200);
            	    q=ternary_conditional();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new EqualOperation(e, new SubtractionOperation(e,q));
            	    }

            	    }


            	    }
            	    break;
            	case 4 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:409:3: ( '*=' q= ternary_conditional )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:409:3: ( '*=' q= ternary_conditional )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:409:4: '*=' q= ternary_conditional
            	    {
            	    match(input,67,FOLLOW_67_in_expression2208); if (state.failed) return e;
            	    pushFollow(FOLLOW_ternary_conditional_in_expression2212);
            	    q=ternary_conditional();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new EqualOperation(e, new MultiplyOperation(e,q));
            	    }

            	    }


            	    }
            	    break;
            	case 5 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:410:3: ( '/=' q= ternary_conditional )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:410:3: ( '/=' q= ternary_conditional )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:410:4: '/=' q= ternary_conditional
            	    {
            	    match(input,68,FOLLOW_68_in_expression2220); if (state.failed) return e;
            	    pushFollow(FOLLOW_ternary_conditional_in_expression2224);
            	    q=ternary_conditional();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new EqualOperation(e, new DivisionOperation(e,q));
            	    }

            	    }


            	    }
            	    break;
            	case 6 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:411:3: ( '%=' q= ternary_conditional )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:411:3: ( '%=' q= ternary_conditional )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:411:4: '%=' q= ternary_conditional
            	    {
            	    match(input,69,FOLLOW_69_in_expression2232); if (state.failed) return e;
            	    pushFollow(FOLLOW_ternary_conditional_in_expression2236);
            	    q=ternary_conditional();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new EqualOperation(e, new ModOperation(e,q));
            	    }

            	    }


            	    }
            	    break;
            	case 7 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:412:3: ( '&=' q= ternary_conditional )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:412:3: ( '&=' q= ternary_conditional )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:412:4: '&=' q= ternary_conditional
            	    {
            	    match(input,70,FOLLOW_70_in_expression2244); if (state.failed) return e;
            	    pushFollow(FOLLOW_ternary_conditional_in_expression2248);
            	    q=ternary_conditional();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new EqualOperation(e, new BitwiseAndOperation(e,q));
            	    }

            	    }


            	    }
            	    break;
            	case 8 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:413:3: ( '|=' q= ternary_conditional )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:413:3: ( '|=' q= ternary_conditional )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:413:4: '|=' q= ternary_conditional
            	    {
            	    match(input,71,FOLLOW_71_in_expression2256); if (state.failed) return e;
            	    pushFollow(FOLLOW_ternary_conditional_in_expression2260);
            	    q=ternary_conditional();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new EqualOperation(e, new BitwiseOrOperation(e,q));
            	    }

            	    }


            	    }
            	    break;
            	case 9 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:414:3: ( '^=' q= ternary_conditional )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:414:3: ( '^=' q= ternary_conditional )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:414:4: '^=' q= ternary_conditional
            	    {
            	    match(input,72,FOLLOW_72_in_expression2268); if (state.failed) return e;
            	    pushFollow(FOLLOW_ternary_conditional_in_expression2272);
            	    q=ternary_conditional();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new EqualOperation(e, new BitwiseXorOperation(e,q));
            	    }

            	    }


            	    }
            	    break;
            	case 10 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:415:3: ( '<<=' q= ternary_conditional )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:415:3: ( '<<=' q= ternary_conditional )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:415:4: '<<=' q= ternary_conditional
            	    {
            	    match(input,73,FOLLOW_73_in_expression2280); if (state.failed) return e;
            	    pushFollow(FOLLOW_ternary_conditional_in_expression2284);
            	    q=ternary_conditional();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new EqualOperation(e, new LShiftOperation(e,q));
            	    }

            	    }


            	    }
            	    break;
            	case 11 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:416:3: ( '>>=' q= ternary_conditional )
            	    {
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:416:3: ( '>>=' q= ternary_conditional )
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:416:4: '>>=' q= ternary_conditional
            	    {
            	    match(input,74,FOLLOW_74_in_expression2292); if (state.failed) return e;
            	    pushFollow(FOLLOW_ternary_conditional_in_expression2296);
            	    q=ternary_conditional();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e=new EqualOperation(e, new RShiftOperation(e,q));
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
    // $ANTLR end "expression"


    // $ANTLR start "stringconst"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:421:1: stringconst returns [StringConstant s = null] : v= STRINGCONST_PRIVATE ;
    public final StringConstant stringconst() throws RecognitionException {
        StringConstant s =  null;

        Token v=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:422:2: (v= STRINGCONST_PRIVATE )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:422:4: v= STRINGCONST_PRIVATE
            {
            v=(Token)match(input,STRINGCONST_PRIVATE,FOLLOW_STRINGCONST_PRIVATE_in_stringconst2320); if (state.failed) return s;
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:430:1: doubleconst returns [DoubleConstant d = null] : (s= ( PLUS | MINUS ) )? v= DOUBLECONST_PRIVATE ;
    public final DoubleConstant doubleconst() throws RecognitionException {
        DoubleConstant d =  null;

        Token s=null;
        Token v=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:431:2: ( (s= ( PLUS | MINUS ) )? v= DOUBLECONST_PRIVATE )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:431:4: (s= ( PLUS | MINUS ) )? v= DOUBLECONST_PRIVATE
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:431:5: (s= ( PLUS | MINUS ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=PLUS && LA54_0<=MINUS)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:0:0: s= ( PLUS | MINUS )
                    {
                    s=(Token)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return d;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }

            v=(Token)match(input,DOUBLECONST_PRIVATE,FOLLOW_DOUBLECONST_PRIVATE_in_doubleconst2385); if (state.failed) return d;
            if ( state.backtracking==0 ) {
              d=new DoubleConstant(((s != null) ? s.getText() : "")+v.getText());
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:436:1: intconst returns [IntConstant i = null] : (s= ( PLUS | MINUS ) )? v= INTCONST_PRIVATE ;
    public final IntConstant intconst() throws RecognitionException {
        IntConstant i =  null;

        Token s=null;
        Token v=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:437:2: ( (s= ( PLUS | MINUS ) )? v= INTCONST_PRIVATE )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:437:4: (s= ( PLUS | MINUS ) )? v= INTCONST_PRIVATE
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:437:5: (s= ( PLUS | MINUS ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=PLUS && LA55_0<=MINUS)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:0:0: s= ( PLUS | MINUS )
                    {
                    s=(Token)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return i;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }

            v=(Token)match(input,INTCONST_PRIVATE,FOLLOW_INTCONST_PRIVATE_in_intconst2428); if (state.failed) return i;
            if ( state.backtracking==0 ) {
              i = new IntConstant(((s != null) ? s.getText() : "")+v.getText());
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:446:1: nullconst returns [NullConstant n = new NullConstant()] : 'null' ;
    public final NullConstant nullconst() throws RecognitionException {
        NullConstant n =  new NullConstant();

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:447:2: ( 'null' )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:447:4: 'null'
            {
            match(input,75,FOLLOW_75_in_nullconst2500); if (state.failed) return n;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:449:1: boolconst returns [BooleanConstant b = new BooleanConstant(false)] : ( ( 'true' ) | 'false' );
    public final BooleanConstant boolconst() throws RecognitionException {
        BooleanConstant b =  new BooleanConstant(false);

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:450:2: ( ( 'true' ) | 'false' )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==76) ) {
                alt56=1;
            }
            else if ( (LA56_0==77) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return b;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:450:4: ( 'true' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:450:4: ( 'true' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:450:5: 'true'
                    {
                    match(input,76,FOLLOW_76_in_boolconst2514); if (state.failed) return b;
                    if ( state.backtracking==0 ) {
                      b.value = true;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:450:31: 'false'
                    {
                    match(input,77,FOLLOW_77_in_boolconst2519); if (state.failed) return b;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:452:1: type returns [Type type = new Type()] : (i= primitivetype | t= clstype ) ( ARRAY_L ARRAY_R )* ;
    public final Type type() throws RecognitionException {
        Type type =  new Type();

        Type i = null;

        Type t = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:453:2: ( (i= primitivetype | t= clstype ) ( ARRAY_L ARRAY_R )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:453:4: (i= primitivetype | t= clstype ) ( ARRAY_L ARRAY_R )*
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:453:4: (i= primitivetype | t= clstype )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=78 && LA57_0<=83)) ) {
                alt57=1;
            }
            else if ( (LA57_0==WORD) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:453:5: i= primitivetype
                    {
                    pushFollow(FOLLOW_primitivetype_in_type2535);
                    i=primitivetype();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type=i;
                    }

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:453:31: t= clstype
                    {
                    pushFollow(FOLLOW_clstype_in_type2541);
                    t=clstype();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type=t;
                    }

                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:454:2: ( ARRAY_L ARRAY_R )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==ARRAY_L) ) {
                    int LA58_2 = input.LA(2);

                    if ( (LA58_2==ARRAY_R) ) {
                        alt58=1;
                    }


                }


                switch (alt58) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:454:3: ARRAY_L ARRAY_R
            	    {
            	    match(input,ARRAY_L,FOLLOW_ARRAY_L_in_type2548); if (state.failed) return type;
            	    match(input,ARRAY_R,FOLLOW_ARRAY_R_in_type2550); if (state.failed) return type;
            	    if ( state.backtracking==0 ) {
            	      Type ar = new Type(); ar.typeCategory = TypeCategory.ARRAY; ar.arrayType = type; type = ar;
            	    }

            	    }
            	    break;

            	default :
            	    break loop58;
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
        return type;
    }
    // $ANTLR end "type"


    // $ANTLR start "clstype"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:456:1: clstype returns [Type type = new Type()] : (c= WORD ( '.' t= WORD )* ) ;
    public final Type clstype() throws RecognitionException {
        Type type =  new Type();

        Token c=null;
        Token t=null;


        	type.typeCategory = TypeCategory.CLASS;
        	String s = "";

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:461:2: ( (c= WORD ( '.' t= WORD )* ) )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:461:4: (c= WORD ( '.' t= WORD )* )
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:461:4: (c= WORD ( '.' t= WORD )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:461:5: c= WORD ( '.' t= WORD )*
            {
            c=(Token)match(input,WORD,FOLLOW_WORD_in_clstype2574); if (state.failed) return type;
            if ( state.backtracking==0 ) {
              s += c.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:461:32: ( '.' t= WORD )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==DOT) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:461:33: '.' t= WORD
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_clstype2579); if (state.failed) return type;
            	    t=(Token)match(input,WORD,FOLLOW_WORD_in_clstype2583); if (state.failed) return type;
            	    if ( state.backtracking==0 ) {
            	      s += "." + t.getText();
            	    }

            	    }
            	    break;

            	default :
            	    break loop59;
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


    // $ANTLR start "primitivetype"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:463:1: primitivetype returns [Type type = new Type()] : ( ( 'int' ) | ( 'float' ) | ( 'char' ) | ( 'bool' ) | ( 'string' ) | ( 'void' ) );
    public final Type primitivetype() throws RecognitionException {
        Type type =  new Type();


        	type.typeCategory = TypeCategory.PRIMITIVE;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:466:3: ( ( 'int' ) | ( 'float' ) | ( 'char' ) | ( 'bool' ) | ( 'string' ) | ( 'void' ) )
            int alt60=6;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt60=1;
                }
                break;
            case 79:
                {
                alt60=2;
                }
                break;
            case 80:
                {
                alt60=3;
                }
                break;
            case 81:
                {
                alt60=4;
                }
                break;
            case 82:
                {
                alt60=5;
                }
                break;
            case 83:
                {
                alt60=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:466:5: ( 'int' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:466:5: ( 'int' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:466:6: 'int'
                    {
                    match(input,78,FOLLOW_78_in_primitivetype2607); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.primitiveType = PrimitiveType.INT;
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:467:2: ( 'float' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:467:2: ( 'float' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:467:3: 'float'
                    {
                    match(input,79,FOLLOW_79_in_primitivetype2615); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.primitiveType = PrimitiveType.FLOAT;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:468:2: ( 'char' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:468:2: ( 'char' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:468:3: 'char'
                    {
                    match(input,80,FOLLOW_80_in_primitivetype2623); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.primitiveType = PrimitiveType.CHAR;
                    }

                    }


                    }
                    break;
                case 4 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:469:2: ( 'bool' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:469:2: ( 'bool' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:469:3: 'bool'
                    {
                    match(input,81,FOLLOW_81_in_primitivetype2631); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.primitiveType = PrimitiveType.BOOL;
                    }

                    }


                    }
                    break;
                case 5 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:470:2: ( 'string' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:470:2: ( 'string' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:470:3: 'string'
                    {
                    match(input,82,FOLLOW_82_in_primitivetype2639); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.primitiveType = PrimitiveType.STRING;
                    }

                    }


                    }
                    break;
                case 6 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:471:2: ( 'void' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:471:2: ( 'void' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:471:3: 'void'
                    {
                    match(input,83,FOLLOW_83_in_primitivetype2647); if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                      type.primitiveType = PrimitiveType.VOID;
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
    // $ANTLR end "primitivetype"


    // $ANTLR start "accesscontrolkeyword"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:473:1: accesscontrolkeyword returns [AccessControlKeyword a = AccessControlKeyword.PUBLIC] : ( 'public' | ( 'private' ) | ( 'protected' ) );
    public final AccessControlKeyword accesscontrolkeyword() throws RecognitionException {
        AccessControlKeyword a =  AccessControlKeyword.PUBLIC;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:474:2: ( 'public' | ( 'private' ) | ( 'protected' ) )
            int alt61=3;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt61=1;
                }
                break;
            case 85:
                {
                alt61=2;
                }
                break;
            case 86:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return a;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:474:4: 'public'
                    {
                    match(input,84,FOLLOW_84_in_accesscontrolkeyword2664); if (state.failed) return a;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:474:15: ( 'private' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:474:15: ( 'private' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:474:16: 'private'
                    {
                    match(input,85,FOLLOW_85_in_accesscontrolkeyword2669); if (state.failed) return a;
                    if ( state.backtracking==0 ) {
                      a = AccessControlKeyword.PRIVATE;
                    }

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:474:65: ( 'protected' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:474:65: ( 'protected' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:474:66: 'protected'
                    {
                    match(input,86,FOLLOW_86_in_accesscontrolkeyword2677); if (state.failed) return a;
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


        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:243:4: ( 'else' e= stmt )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:243:4: 'else' e= stmt
        {
        match(input,54,FOLLOW_54_in_synpred30_PineDL903); if (state.failed) return ;
        pushFollow(FOLLOW_stmt_in_synpred30_PineDL907);
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


        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:257:3: ( 'catch' PAREN_L t= type n= WORD PAREN_R b= stmt )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:257:3: 'catch' PAREN_L t= type n= WORD PAREN_R b= stmt
        {
        match(input,58,FOLLOW_58_in_synpred33_PineDL1036); if (state.failed) return ;
        match(input,PAREN_L,FOLLOW_PAREN_L_in_synpred33_PineDL1038); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred33_PineDL1042);
        t=type();

        state._fsp--;
        if (state.failed) return ;
        n=(Token)match(input,WORD,FOLLOW_WORD_in_synpred33_PineDL1046); if (state.failed) return ;
        match(input,PAREN_R,FOLLOW_PAREN_R_in_synpred33_PineDL1048); if (state.failed) return ;
        pushFollow(FOLLOW_stmt_in_synpred33_PineDL1052);
        b=stmt();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_PineDL

    // $ANTLR start synpred47_PineDL
    public final void synpred47_PineDL_fragment() throws RecognitionException {   
        Constant c = null;


        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:288:6: (c= constant )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:288:6: c= constant
        {
        pushFollow(FOLLOW_constant_in_synpred47_PineDL1317);
        c=constant();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_PineDL

    // $ANTLR start synpred49_PineDL
    public final void synpred49_PineDL_fragment() throws RecognitionException {   
        Token s=null;
        Expression p = null;


        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:291:9: (s= ( MINUS | PLUS ) p= primitive )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:291:9: s= ( MINUS | PLUS ) p= primitive
        {
        s=(Token)input.LT(1);
        if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        pushFollow(FOLLOW_primitive_in_synpred49_PineDL1352);
        p=primitive();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_PineDL

    // $ANTLR start synpred61_PineDL
    public final void synpred61_PineDL_fragment() throws RecognitionException {   
        Expression p = null;


        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:337:4: ( (p= pre_post_op ) )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:337:4: (p= pre_post_op )
        {
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:337:4: (p= pre_post_op )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL Compiler/src/org/gcreator/pineapple/pinedl/PineDL.g:337:5: p= pre_post_op
        {
        pushFollow(FOLLOW_pre_post_op_in_synpred61_PineDL1645);
        p=pre_post_op();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred61_PineDL

    // Delegated rules

    public final boolean synpred49_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_PineDL_fragment(); // can never throw exception
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
    public final boolean synpred47_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_PineDL_fragment(); // can never throw exception
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
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA4_eotS =
        "\26\uffff";
    static final String DFA4_eofS =
        "\26\uffff";
    static final String DFA4_minS =
        "\1\33\1\uffff\5\40\6\36\1\11\1\uffff\1\37\1\15\1\40\1\36\2\uffff"+
        "\1\11";
    static final String DFA4_maxS =
        "\1\126\1\uffff\5\123\7\40\1\uffff\1\37\1\34\2\40\2\uffff\1\40";
    static final String DFA4_acceptS =
        "\1\uffff\1\4\14\uffff\1\3\4\uffff\1\1\1\2\1\uffff";
    static final String DFA4_specialS =
        "\26\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1\70\uffff\1\2\1\3\1\4",
            "",
            "\1\15\14\uffff\1\5\1\6\1\16\36\uffff\1\7\1\10\1\11\1\12\1\13"+
            "\1\14",
            "\1\15\14\uffff\1\5\1\6\1\16\36\uffff\1\7\1\10\1\11\1\12\1\13"+
            "\1\14",
            "\1\15\14\uffff\1\5\1\6\1\16\36\uffff\1\7\1\10\1\11\1\12\1\13"+
            "\1\14",
            "\1\15\15\uffff\1\6\37\uffff\1\7\1\10\1\11\1\12\1\13\1\14",
            "\1\15\55\uffff\1\7\1\10\1\11\1\12\1\13\1\14",
            "\1\17\1\uffff\1\20",
            "\1\17\1\uffff\1\20",
            "\1\17\1\uffff\1\20",
            "\1\17\1\uffff\1\20",
            "\1\17\1\uffff\1\20",
            "\1\17\1\uffff\1\20",
            "\1\21\24\uffff\1\17\1\uffff\1\20",
            "",
            "\1\22",
            "\1\23\6\uffff\1\23\7\uffff\1\24",
            "\1\25",
            "\1\17\1\uffff\1\20",
            "",
            "",
            "\1\21\24\uffff\1\17\1\uffff\1\20"
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
            return "()* loopback of 176:3: (f= field | m= method | c= constructor )*";
        }
    }
    static final String DFA17_eotS =
        "\21\uffff";
    static final String DFA17_eofS =
        "\21\uffff";
    static final String DFA17_minS =
        "\1\4\1\uffff\1\4\13\uffff\1\40\2\4";
    static final String DFA17_maxS =
        "\1\123\1\uffff\1\112\13\uffff\1\61\1\115\1\112";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
        "\1\14\3\uffff";
    static final String DFA17_specialS =
        "\21\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\3\6\uffff\1\3\7\uffff\1\15\5\uffff\1\11\1\uffff\1\3\3\uffff"+
            "\1\2\2\3\1\uffff\1\3\12\uffff\1\3\1\uffff\1\3\1\uffff\1\13\1"+
            "\14\1\6\1\uffff\1\7\1\10\1\12\1\uffff\1\4\1\5\3\3\13\uffff\3"+
            "\3\6\1",
            "",
            "\5\3\1\16\2\3\1\uffff\15\3\2\uffff\1\3\1\uffff\1\17\1\uffff"+
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
            "\1\20\16\uffff\1\3\1\uffff\1\3",
            "\2\3\6\uffff\1\3\17\uffff\1\3\2\uffff\1\1\3\3\1\uffff\1\3\12"+
            "\uffff\1\3\1\uffff\1\3\13\uffff\3\3\13\uffff\3\3",
            "\5\3\1\16\2\3\1\uffff\15\3\2\uffff\1\3\1\uffff\1\17\1\uffff"+
            "\1\1\35\uffff\15\3"
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
            return "226:1: stmt returns [Leaf l = null] : ( (e= declaration ) | (a= expression STMT_END ) | (b= returnstmt ) | (t= throwstmt ) | (c= ifstmt ) | (w= whilestmt ) | (f= forstmt ) | (d= block ) | (tr= trystmt ) | ( 'break' STMT_END ) | ( 'continue' STMT_END ) | STMT_END );";
        }
    }
    static final String DFA19_eotS =
        "\10\uffff";
    static final String DFA19_eofS =
        "\10\uffff";
    static final String DFA19_minS =
        "\1\4\1\uffff\1\4\2\uffff\1\40\2\4";
    static final String DFA19_maxS =
        "\1\123\1\uffff\1\112\2\uffff\1\61\1\115\1\112";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\3\uffff";
    static final String DFA19_specialS =
        "\10\uffff}>";
    static final String[] DFA19_transitionS = {
            "\2\1\6\uffff\1\1\7\uffff\1\4\7\uffff\1\1\3\uffff\1\2\2\1\1\uffff"+
            "\1\1\12\uffff\1\1\1\uffff\1\1\13\uffff\3\1\13\uffff\3\1\6\3",
            "",
            "\5\1\1\5\2\1\1\uffff\15\1\2\uffff\1\1\1\uffff\1\6\1\uffff\1"+
            "\3\35\uffff\15\1",
            "",
            "",
            "\1\7\16\uffff\1\1\1\uffff\1\1",
            "\2\1\6\uffff\1\1\17\uffff\1\1\2\uffff\1\3\3\1\1\uffff\1\1\12"+
            "\uffff\1\1\1\uffff\1\1\13\uffff\3\1\13\uffff\3\1",
            "\5\1\1\5\2\1\1\uffff\15\1\2\uffff\1\1\1\uffff\1\6\1\uffff\1"+
            "\3\35\uffff\15\1"
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
            return "250:18: ( (a= expression STMT_END ) | b= declaration | STMT_END )";
        }
    }
    static final String DFA31_eotS =
        "\14\uffff";
    static final String DFA31_eofS =
        "\14\uffff";
    static final String DFA31_minS =
        "\1\4\1\0\3\uffff\1\40\1\uffff\1\11\1\uffff\1\40\1\uffff\1\11";
    static final String DFA31_maxS =
        "\1\115\1\0\3\uffff\1\123\1\uffff\1\36\1\uffff\1\40\1\uffff\1\36";
    static final String DFA31_acceptS =
        "\2\uffff\1\1\1\3\1\4\1\uffff\1\2\1\uffff\1\6\1\uffff\1\5\1\uffff";
    static final String DFA31_specialS =
        "\1\uffff\1\0\12\uffff}>";
    static final String[] DFA31_transitionS = {
            "\2\1\26\uffff\1\4\3\uffff\1\3\2\2\1\uffff\1\2\12\uffff\1\3\1"+
            "\uffff\1\3\13\uffff\1\5\15\uffff\3\2",
            "\1\uffff",
            "",
            "",
            "",
            "\1\7\55\uffff\6\10",
            "",
            "\1\11\22\uffff\1\12\1\uffff\1\10",
            "",
            "\1\13",
            "",
            "\1\11\22\uffff\1\12\1\uffff\1\10"
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "285:1: primitive returns [Expression e = null] : (c= constant | s= ( MINUS | PLUS ) p= primitive | (r= reference ) | ( PAREN_L x= expression PAREN_R ) | ( 'new' t= clstype PAREN_L (ex= expression ( ',' ex= expression )* )? PAREN_R ) | ( 'new' t= type '[' x= expression ']' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_1 = input.LA(1);

                         
                        int index31_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred47_PineDL()) ) {s = 2;}

                        else if ( (synpred49_PineDL()) ) {s = 6;}

                         
                        input.seek(index31_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA36_eotS =
        "\17\uffff";
    static final String DFA36_eofS =
        "\17\uffff";
    static final String DFA36_minS =
        "\1\4\10\uffff\1\0\5\uffff";
    static final String DFA36_maxS =
        "\1\115\10\uffff\1\0\5\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\1\13\uffff\1\2\1\3";
    static final String DFA36_specialS =
        "\11\uffff\1\0\5\uffff}>";
    static final String[] DFA36_transitionS = {
            "\2\1\6\uffff\1\15\17\uffff\1\11\3\uffff\3\1\1\uffff\1\1\12\uffff"+
            "\1\1\1\uffff\1\1\13\uffff\3\1\13\uffff\3\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
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
            return "333:1: notcastexpr returns [Expression e = null] : ( (p= pre_post_op ) | ( NOT p= notcastexpr ) | ( PAREN_L t= type PAREN_R p= notcastexpr ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_9 = input.LA(1);

                         
                        int index36_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred61_PineDL()) ) {s = 1;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index36_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_pkgstmt_in_doc284 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_importstmt_in_doc289 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_clsdecl_in_doc294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_pkgstmt306 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pkgname_in_pkgstmt310 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMT_END_in_pkgstmt314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_importstmt323 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_clstype_in_importstmt327 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMT_END_in_importstmt331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_clsdecl340 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_clsdecl344 = new BitSet(new long[]{0x0000100004000000L});
    public static final BitSet FOLLOW_44_in_clsdecl349 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_clstype_in_clsdecl353 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_BLK_BEG_in_clsdecl361 = new BitSet(new long[]{0x0000000008000000L,0x0000000000700000L});
    public static final BitSet FOLLOW_field_in_clsdecl372 = new BitSet(new long[]{0x0000000008000000L,0x0000000000700000L});
    public static final BitSet FOLLOW_method_in_clsdecl383 = new BitSet(new long[]{0x0000000008000000L,0x0000000000700000L});
    public static final BitSet FOLLOW_constructor_in_clsdecl394 = new BitSet(new long[]{0x0000000008000000L,0x0000000000700000L});
    public static final BitSet FOLLOW_BLK_END_in_clsdecl405 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_STMT_END_in_clsdecl407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accesscontrolkeyword_in_field424 = new BitSet(new long[]{0x0000600100000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_45_in_field431 = new BitSet(new long[]{0x0000600100000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_46_in_field440 = new BitSet(new long[]{0x0000600100000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_type_in_field450 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_field458 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_EQUAL_in_field465 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_field469 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMT_END_in_field477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accesscontrolkeyword_in_method494 = new BitSet(new long[]{0x0000600100000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_45_in_method501 = new BitSet(new long[]{0x0000600100000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_46_in_method510 = new BitSet(new long[]{0x0000600100000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_type_in_method520 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_method528 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_PAREN_L_in_method534 = new BitSet(new long[]{0x0000600120000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_argumentlist_in_method540 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_PAREN_R_in_method546 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_block_in_method552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accesscontrolkeyword_in_constructor570 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_constructor576 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_PAREN_L_in_constructor580 = new BitSet(new long[]{0x0000600120000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_argumentlist_in_constructor586 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_PAREN_R_in_constructor592 = new BitSet(new long[]{0x0001000004000000L});
    public static final BitSet FOLLOW_48_in_constructor597 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_constructor599 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_PAREN_L_in_constructor606 = new BitSet(new long[]{0xE002801730001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_constructor614 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_50_in_constructor622 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_constructor626 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_PAREN_R_in_constructor637 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_block_in_constructor645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_argumentlist663 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_argumentlist668 = new BitSet(new long[]{0x0000600100000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_argument_in_argumentlist672 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_type_in_argument694 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_argument701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLK_BEG_in_block717 = new BitSet(new long[]{0xFBBAE0171C101030L,0x00000000000FF800L});
    public static final BitSet FOLLOW_stmt_in_block722 = new BitSet(new long[]{0xFBBAE0171C101030L,0x00000000000FF800L});
    public static final BitSet FOLLOW_BLK_END_in_block728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_stmt746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_stmt757 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMT_END_in_stmt759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnstmt_in_stmt770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwstmt_in_stmt781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifstmt_in_stmt792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whilestmt_in_stmt803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forstmt_in_stmt814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_stmt825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trystmt_in_stmt836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_stmt845 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMT_END_in_stmt847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_stmt856 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMT_END_in_stmt858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STMT_END_in_stmt866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ifstmt880 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_PAREN_L_in_ifstmt882 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_ifstmt886 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_PAREN_R_in_ifstmt890 = new BitSet(new long[]{0xFBBAE01714101030L,0x00000000000FF800L});
    public static final BitSet FOLLOW_stmt_in_ifstmt896 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_ifstmt903 = new BitSet(new long[]{0xFBBAE01714101030L,0x00000000000FF800L});
    public static final BitSet FOLLOW_stmt_in_ifstmt907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_whilestmt926 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_PAREN_L_in_whilestmt928 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_whilestmt932 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_PAREN_R_in_whilestmt936 = new BitSet(new long[]{0xFBBAE01714101030L,0x00000000000FF800L});
    public static final BitSet FOLLOW_stmt_in_whilestmt942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_forstmt959 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_PAREN_L_in_forstmt961 = new BitSet(new long[]{0xE002E01710101030L,0x00000000000FF800L});
    public static final BitSet FOLLOW_expression_in_forstmt967 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMT_END_in_forstmt971 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_declaration_in_forstmt976 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_STMT_END_in_forstmt980 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_forstmt988 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMT_END_in_forstmt993 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_forstmt1000 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_PAREN_R_in_forstmt1005 = new BitSet(new long[]{0xFBBAE01714101030L,0x00000000000FF800L});
    public static final BitSet FOLLOW_stmt_in_forstmt1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_trystmt1026 = new BitSet(new long[]{0xFBBAE01714101030L,0x00000000000FF800L});
    public static final BitSet FOLLOW_stmt_in_trystmt1030 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_trystmt1036 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_PAREN_L_in_trystmt1038 = new BitSet(new long[]{0x0000600100000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_type_in_trystmt1042 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_trystmt1046 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_PAREN_R_in_trystmt1048 = new BitSet(new long[]{0xFBBAE01714101030L,0x00000000000FF800L});
    public static final BitSet FOLLOW_stmt_in_trystmt1052 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_59_in_returnstmt1070 = new BitSet(new long[]{0xE002801710101030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_returnstmt1075 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMT_END_in_returnstmt1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_throwstmt1095 = new BitSet(new long[]{0xE002801710101030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_throwstmt1100 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMT_END_in_throwstmt1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_declaration1122 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_declaration1128 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_EQUAL_in_declaration1133 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_declaration1137 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMT_END_in_declaration1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_pkgname1159 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_pkgname1164 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_pkgname1168 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_set_in_reference1188 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_PAREN_L_in_reference1202 = new BitSet(new long[]{0xE002801730001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_reference1211 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_50_in_reference1219 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_reference1223 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_PAREN_R_in_reference1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_intconst_in_constant1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doubleconst_in_constant1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolconst_in_constant1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringconst_in_constant1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nullconst_in_constant1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primitive1317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitive1344 = new BitSet(new long[]{0x2002801710000030L,0x0000000000003800L});
    public static final BitSet FOLLOW_primitive_in_primitive1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_in_primitive1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PAREN_L_in_primitive1393 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_primitive1397 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_PAREN_R_in_primitive1401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_primitive1424 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_clstype_in_primitive1428 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_PAREN_L_in_primitive1435 = new BitSet(new long[]{0xE002801730001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_primitive1446 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_50_in_primitive1457 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_primitive1461 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_PAREN_R_in_primitive1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_primitive1486 = new BitSet(new long[]{0x0000600100000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_type_in_primitive1490 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ARRAY_L_in_primitive1492 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_primitive1496 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ARRAY_R_in_primitive1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitive_in_reference_checked1516 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_DOT_in_reference_checked1525 = new BitSet(new long[]{0x0002800100000000L});
    public static final BitSet FOLLOW_reference_in_reference_checked1530 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ARRAY_L_in_reference_checked1540 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_expression_in_reference_checked1544 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ARRAY_R_in_reference_checked1548 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_reference_checked_in_pre_post_op1572 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_62_in_pre_post_op1583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_pre_post_op1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_pre_post_op1605 = new BitSet(new long[]{0x2002801710000030L,0x0000000000003800L});
    public static final BitSet FOLLOW_primitive_in_pre_post_op1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_pre_post_op1617 = new BitSet(new long[]{0x2002801710000030L,0x0000000000003800L});
    public static final BitSet FOLLOW_primitive_in_pre_post_op1621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pre_post_op_in_notcastexpr1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notcastexpr1655 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_notcastexpr_in_notcastexpr1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PAREN_L_in_notcastexpr1669 = new BitSet(new long[]{0x0000600100000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_type_in_notcastexpr1673 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_PAREN_R_in_notcastexpr1675 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_notcastexpr_in_notcastexpr1679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notcastexpr_in_mult_op1699 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_MULT_in_mult_op1707 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_notcastexpr_in_mult_op1711 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_DIV_in_mult_op1717 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_notcastexpr_in_mult_op1721 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_MOD_in_mult_op1727 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_notcastexpr_in_mult_op1731 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_mult_op_in_sum_op1753 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_PLUS_in_sum_op1761 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_mult_op_in_sum_op1765 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_MINUS_in_sum_op1771 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_mult_op_in_sum_op1775 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_sum_op_in_bitw_shift_op1797 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_SHIFT_R_in_bitw_shift_op1805 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_sum_op_in_bitw_shift_op1809 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_SHIFT_L_in_bitw_shift_op1815 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_sum_op_in_bitw_shift_op1819 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_bitw_shift_op_in_compop1842 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LESS_in_compop1850 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_bitw_shift_op_in_compop1854 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_MORE_in_compop1860 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_bitw_shift_op_in_compop1864 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LESS_EQ_in_compop1870 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_bitw_shift_op_in_compop1874 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_MORE_EQ_in_compop1880 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_bitw_shift_op_in_compop1884 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_compop_in_comp2op1907 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_EQUALS_in_comp2op1915 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_compop_in_comp2op1919 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_comp2op1925 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_compop_in_comp2op1929 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_comp2op_in_bitwiseand1951 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_BITWISE_AND_in_bitwiseand1959 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_comp2op_in_bitwiseand1963 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_bitwiseand_in_bitwiseor1985 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_BITWISE_OR_in_bitwiseor1993 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_bitwiseand_in_bitwiseor1997 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_bitwiseor_in_bitwisexor2020 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_BITWISE_XOR_in_bitwisexor2028 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_bitwiseor_in_bitwisexor2032 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_bitwisexor_in_logicaland2054 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_LOG_AND_in_logicaland2062 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_bitwisexor_in_logicaland2066 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_logicaland_in_logicalor2088 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LOG_OR_in_logicalor2096 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_logicaland_in_logicalor2100 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_logicalor_in_ternary_conditional2123 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ternary_conditional2131 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_logicalor_in_ternary_conditional2135 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ternary_conditional2137 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_logicalor_in_ternary_conditional2141 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ternary_conditional_in_expression2164 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_EQUAL_in_expression2172 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_conditional_in_expression2176 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_65_in_expression2184 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_conditional_in_expression2188 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_66_in_expression2196 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_conditional_in_expression2200 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_67_in_expression2208 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_conditional_in_expression2212 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_68_in_expression2220 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_conditional_in_expression2224 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_69_in_expression2232 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_conditional_in_expression2236 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_70_in_expression2244 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_conditional_in_expression2248 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_71_in_expression2256 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_conditional_in_expression2260 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_72_in_expression2268 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_conditional_in_expression2272 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_73_in_expression2280 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_conditional_in_expression2284 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_74_in_expression2292 = new BitSet(new long[]{0xE002801710001030L,0x0000000000003800L});
    public static final BitSet FOLLOW_ternary_conditional_in_expression2296 = new BitSet(new long[]{0x0000000000002002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_STRINGCONST_PRIVATE_in_stringconst2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_doubleconst2376 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_DOUBLECONST_PRIVATE_in_doubleconst2385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_intconst2419 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_INTCONST_PRIVATE_in_intconst2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_nullconst2500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_boolconst2514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_boolconst2519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitivetype_in_type2535 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_clstype_in_type2541 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ARRAY_L_in_type2548 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ARRAY_R_in_type2550 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_WORD_in_clstype2574 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_clstype2579 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_clstype2583 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_78_in_primitivetype2607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_primitivetype2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_primitivetype2623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_primitivetype2631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_primitivetype2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_primitivetype2647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_accesscontrolkeyword2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_accesscontrolkeyword2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_accesscontrolkeyword2677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_synpred30_PineDL903 = new BitSet(new long[]{0xFBBAE01714101030L,0x00000000000FF800L});
    public static final BitSet FOLLOW_stmt_in_synpred30_PineDL907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_synpred33_PineDL1036 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_PAREN_L_in_synpred33_PineDL1038 = new BitSet(new long[]{0x0000600100000000L,0x00000000000FC000L});
    public static final BitSet FOLLOW_type_in_synpred33_PineDL1042 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_WORD_in_synpred33_PineDL1046 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_PAREN_R_in_synpred33_PineDL1048 = new BitSet(new long[]{0xFBBAE01714101030L,0x00000000000FF800L});
    public static final BitSet FOLLOW_stmt_in_synpred33_PineDL1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_synpred47_PineDL1317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred49_PineDL1344 = new BitSet(new long[]{0x2002801710000030L,0x0000000000003800L});
    public static final BitSet FOLLOW_primitive_in_synpred49_PineDL1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pre_post_op_in_synpred61_PineDL1645 = new BitSet(new long[]{0x0000000000000002L});

}