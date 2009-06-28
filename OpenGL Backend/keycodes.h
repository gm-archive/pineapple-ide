#ifndef _KEYCODES_H
#define _KEYCODES_H

#include "core.h"

namespace Pineapple {

//
//This is just a redefinition of the SDL keycodes so we can have Pineapple names
//
//What we really want is a mapping of every raw key on the keyboard.
//To support international keyboards; we use the range 0xA1 - 0xFF
//as international virtual keycodes.  We'll follow in the footsteps of X11...
//The names of the keys
//
class Key : public Object{
	public:
	//The keyboard syms have been cleverly chosen to map to ASCII
	static const int Unknown	= 0;
	static const int First		= 0;
	static const int Backspace	= 8;
	static const int Tab		= 9;
	static const int Clear		= 12;
	static const int Return		= 13;
	static const int Pause		= 19;
	static const int Escape		= 27;
	static const int Space		= 32;
	static const int Exclaim	= 33;
	static const int QuotedBL	= 34;
	static const int Hash		= 35;
	static const int Dollar		= 36;
	static const int Ampersand	= 38;
	static const int Quote		= 39;
	static const int LeftParen	= 40;
	static const int RightParen	= 41;
	static const int Asterisk	= 42;
	static const int Plus		= 43;
	static const int Comma		= 44;
	static const int Minus		= 45;
	static const int Period		= 46;
	static const int Slash		= 47;
	static const int Number0	= 48;
	static const int Number1	= 49;
	static const int Number2	= 50;
	static const int Number3	= 51;
	static const int Number4	= 52;
	static const int Number5	= 53;
	static const int Number6	= 54;
	static const int Number7	= 55;
	static const int Number8	= 56;
	static const int Number9	= 57;
	static const int Colon		= 58;
	static const int Semicolon	= 59;
	static const int Less		= 60;
	static const int Equals		= 61;
	static const int Greater	= 62;
	static const int Question	= 63;
	static const int At		= 64;

	//Skip uppercase letters

	static const int LeftBracket	= 91;
	static const int Backslash	= 92;
	static const int RightBracket	= 93;
	static const int Caret		= 94;
	static const int Underscore	= 95;
	static const int Backquote	= 96;
	static const int A		= 97;
	static const int B		= 98;
	static const int C		= 99;
	static const int D		= 100;
	static const int E		= 101;
	static const int F		= 102;
	static const int G		= 103;
	static const int H		= 104;
	static const int I		= 105;
	static const int J		= 106;
	static const int K		= 107;
	static const int L		= 108;
	static const int M		= 109;
	static const int N		= 110;
	static const int O		= 111;
	static const int P		= 112;
	static const int Q		= 113;
	static const int R		= 114;
	static const int S		= 115;
	static const int T		= 116;
	static const int U		= 117;
	static const int V		= 118;
	static const int W		= 119;
	static const int X		= 120;
	static const int Y		= 121;
	static const int Z		= 122;
	static const int Delete		= 127;
	//End of ASCII mapped key syms
	//International static Keyboard syms
	static const int World0		= 160;		//0xA0
	static const int World1		= 161;
	static const int World2		= 162;
	static const int World3		= 163;
	static const int World4		= 164;
	static const int World5		= 165;
	static const int World6		= 166;
	static const int World7		= 167;
	static const int World8		= 168;
	static const int World9		= 169;
	static const int World10	= 170;
	static const int World11	= 171;
	static const int World12	= 172;
	static const int World13	= 173;
	static const int World14	= 174;
	static const int World15	= 175;
	static const int World16	= 176;
	static const int World17	= 177;
	static const int World18	= 178;
	static const int World19	= 179;
	static const int World20	= 180;
	static const int World21	= 181;
	static const int World22	= 182;
	static const int World23	= 183;
	static const int World24	= 184;
	static const int World25	= 185;
	static const int World26	= 186;
	static const int World27	= 187;
	static const int World28	= 188;
	static const int World29	= 189;
	static const int World30	= 190;
	static const int World31	= 191;
	static const int World32	= 192;
	static const int World33	= 193;
	static const int World34	= 194;
	static const int World35	= 195;
	static const int World36	= 196;
	static const int World37	= 197;
	static const int World38	= 198;
	static const int World39	= 199;
	static const int World40	= 200;
	static const int World41	= 201;
	static const int World42	= 202;
	static const int World43	= 203;
	static const int World44	= 204;
	static const int World45	= 205;
	static const int World46	= 206;
	static const int World47	= 207;
	static const int World48	= 208;
	static const int World49	= 209;
	static const int World50	= 210;
	static const int World51	= 211;
	static const int World52	= 212;
	static const int World53	= 213;
	static const int World54	= 214;
	static const int World55	= 215;
	static const int World56	= 216;
	static const int World57	= 217;
	static const int World58	= 218;
	static const int World59	= 219;
	static const int World60	= 220;
	static const int World61	= 221;
	static const int World62	= 222;
	static const int World63	= 223;
	static const int World64	= 224;
	static const int World65	= 225;
	static const int World66	= 226;
	static const int World67	= 227;
	static const int World68	= 228;
	static const int World69	= 229;
	static const int World70	= 230;
	static const int World71	= 231;
	static const int World72	= 232;
	static const int World73	= 233;
	static const int World74	= 234;
	static const int World75	= 235;
	static const int World76	= 236;
	static const int World77	= 237;
	static const int World78	= 238;
	static const int World79	= 239;
	static const int World80	= 240;
	static const int World81	= 241;
	static const int World82	= 242;
	static const int World83	= 243;
	static const int World84	= 244;
	static const int World85	= 245;
	static const int World86	= 246;
	static const int World87	= 247;
	static const int World88	= 248;
	static const int World89	= 249;
	static const int World90	= 250;
	static const int World91	= 251;
	static const int World92	= 252;
	static const int World93	= 253;
	static const int World94	= 254;
	static const int World95	= 255;		//0xFF
	//Numeric keypad
	static const int KP0		= 256;
	static const int KP1		= 257;
	static const int KP2		= 258;
	static const int KP3		= 259;
	static const int KP4		= 260;
	static const int KP5		= 261;
	static const int KP6		= 262;
	static const int KP7		= 263;
	static const int KP8		= 264;
	static const int KP9		= 265;
	static const int KPPeriod 	= 266;
	static const int KPDivide 	= 267;
	static const int KPMultiply	= 268;
	static const int KPMinus	= 269;
	static const int KPPlus		= 270;
	static const int KPEnter	= 271;
	static const int KPEquals 	= 272;

	//Arrows + Home/End pad
	static const int Up		= 273;
	static const int Down		= 274;
	static const int Right		= 275;
	static const int Left		= 276;
	static const int Insert		= 277;
	static const int Home		= 278;
	static const int End		= 279;
	static const int PageUp		= 280;
	static const int PageDown 	= 281;

	//Function keys
	static const int F1		= 282;
	static const int F2		= 283;
	static const int F3		= 284;
	static const int F4		= 285;
	static const int F5		= 286;
	static const int F6		= 287;
	static const int F7		= 288;
	static const int F8		= 289;
	static const int F9		= 290;
	static const int F10		= 291;
	static const int F11		= 292;
	static const int F12		= 293;
	static const int F13		= 294;
	static const int F14		= 295;
	static const int F15		= 296;

	//Key state modifier Keys
	static const int NumLock	= 300;
	static const int CapsLock	= 301;
	static const int ScrollLock	= 302;
	static const int RShift		= 303;
	static const int LShift		= 304;
	static const int RCtrl		= 305;
	static const int LCtrl		= 306;
	static const int RAlt		= 307;
	static const int LAlt		= 308;
	static const int RMeta		= 309;
	static const int LMeta		= 310;
	static const int LSuper		= 311;		//Left "Windows" key
	static const int RSuper		= 312;		//Right "Windows" key
	static const int Mode		= 313;		//"Alt Gr" key
	static const int Compose	= 314;	    //Multi-key compose key

	//Miscellaneous function keys
	static const int Help		= 315;
	static const int Print		= 316;
	static const int SysReq		= 317;
	static const int Break		= 318;
	static const int Menu		= 319;
	static const int Power		= 320;		//Power Macintosh power key
	static const int Euro		= 321;		//Some european keyboards
	static const int Undo		= 322;		//Atari keyboard has Undo

	//Add any other keys here
};

//
//Enumeration of valid key mods (possibly OR'd together)
//
class KeyMod : public Object{
	static const int ModNone  = 0x0000;
	static const int ModLShift= 0x0001;
	static const int ModRShift= 0x0002;
	static const int ModLCtrl = 0x0040;
	static const int ModRCtrl = 0x0080;
	static const int ModLAlt  = 0x0100;
	static const int ModRAlt  = 0x0200;
	static const int ModLMeta = 0x0400;
	static const int ModRMeta = 0x0800;
	static const int ModNum   = 0x1000;
	static const int ModCaps  = 0x2000;
	static const int ModMode  = 0x4000;
	static const int ModReserved = 0x8000;
};

#define KeyModCtrl	(KeyModLCtrl|KeyModRCtrl)
#define KeyModShift	(KeyModLShift|KeyModRShift)
#define KeyModAlt	(KeyModLAlt|KeyModRAlt)
#define KeyModMeta	(KeyModLMeta|KeyModRMeta)

}

#endif
