#ifndef KEYCODES_H
#define KEYCODES_H

namespace Pineapple {

//
//This is just a redefinition of the SDL keycodes so we can have Pineapple names
//
//What we really want is a mapping of every raw key on the keyboard.
//To support international keyboards, we use the range 0xA1 - 0xFF
//as international virtual keycodes.  We'll follow in the footsteps of X11...
//The names of the keys
//
typedef enum {
	//The keyboard syms have been cleverly chosen to map to ASCII
	KeyUnknown		= 0,
	KeyFirst		= 0,
	KeyBackspace	= 8,
	KeyTab	    	= 9,
	KeyClear		= 12,
	KeyReturn		= 13,
	KeyPause		= 19,
	KeyEscape		= 27,
	KeySpace		= 32,
	KeyExclaim		= 33,
	KeyQuotedBL		= 34,
	KeyHash		    = 35,
	KeyDollar		= 36,
	KeyAmpersand	= 38,
	KeyQuote		= 39,
	KeyLeftParen	= 40,
	KeyRightParen	= 41,
	KeyAsterisk		= 42,
	KeyPlus		    = 43,
	KeyComma		= 44,
	KeyMinus		= 45,
	KeyPeriod		= 46,
	KeySlash		= 47,
	Key0			= 48,
	Key1			= 49,
	Key2			= 50,
	Key3			= 51,
	Key4			= 52,
	Key5			= 53,
	Key6			= 54,
	Key7			= 55,
	Key8			= 56,
	Key9			= 57,
	KeyColon		= 58,
	KeySemicolon	= 59,
	KeyLess		    = 60,
	KeyEquals		= 61,
	KeyGreater		= 62,
	KeyQuestion		= 63,
	KeyAt			= 64,

	//Skip uppercase letters

	KeyLeftBracket	= 91,
	KeyBackslash	= 92,
	KeyRightBracket	= 93,
	KeyCaret		= 94,
	KeyUnderscore	= 95,
	KeyBackquote	= 96,
	KeyA			= 97,
	KeyB			= 98,
	KeyC			= 99,
	KeyD			= 100,
	KeyE			= 101,
	KeyF			= 102,
	KeyG			= 103,
	KeyH			= 104,
	KeyI			= 105,
	KeyJ			= 106,
	KeyK			= 107,
	KeyL			= 108,
	KeyM			= 109,
	KeyN			= 110,
	KeyO			= 111,
	KeyP			= 112,
	KeyQ			= 113,
	KeyR			= 114,
	KeyS			= 115,
	KeyT			= 116,
	KeyU			= 117,
	KeyV			= 118,
	KeyW			= 119,
	KeyX			= 120,
	KeyY			= 121,
	KeyZ			= 122,
	KeyDelete		= 127,
	//End of ASCII mapped keysyms

	//International keyboard syms
	KeyWorld0		= 160,		//0xA0
	KeyWorld1		= 161,
	KeyWorld2		= 162,
	KeyWorld3		= 163,
	KeyWorld4		= 164,
	KeyWorld5		= 165,
	KeyWorld6		= 166,
	KeyWorld7		= 167,
	KeyWorld8		= 168,
	KeyWorld9		= 169,
	KeyWorld10		= 170,
	KeyWorld11		= 171,
	KeyWorld12		= 172,
	KeyWorld13		= 173,
	KeyWorld14		= 174,
	KeyWorld15		= 175,
	KeyWorld16		= 176,
	KeyWorld17		= 177,
	KeyWorld18		= 178,
	KeyWorld19		= 179,
	KeyWorld20		= 180,
	KeyWorld21		= 181,
	KeyWorld22		= 182,
	KeyWorld23		= 183,
	KeyWorld24		= 184,
	KeyWorld25		= 185,
	KeyWorld26		= 186,
	KeyWorld27		= 187,
	KeyWorld28		= 188,
	KeyWorld29		= 189,
	KeyWorld30		= 190,
	KeyWorld31		= 191,
	KeyWorld32		= 192,
	KeyWorld33		= 193,
	KeyWorld34		= 194,
	KeyWorld35		= 195,
	KeyWorld36		= 196,
	KeyWorld37		= 197,
	KeyWorld38		= 198,
	KeyWorld39		= 199,
	KeyWorld40		= 200,
	KeyWorld41		= 201,
	KeyWorld42		= 202,
	KeyWorld43		= 203,
	KeyWorld44		= 204,
	KeyWorld45		= 205,
	KeyWorld46		= 206,
	KeyWorld47		= 207,
	KeyWorld48		= 208,
	KeyWorld49		= 209,
	KeyWorld50		= 210,
	KeyWorld51		= 211,
	KeyWorld52		= 212,
	KeyWorld53		= 213,
	KeyWorld54		= 214,
	KeyWorld55		= 215,
	KeyWorld56		= 216,
	KeyWorld57		= 217,
	KeyWorld58		= 218,
	KeyWorld59		= 219,
	KeyWorld60		= 220,
	KeyWorld61		= 221,
	KeyWorld62		= 222,
	KeyWorld63		= 223,
	KeyWorld64		= 224,
	KeyWorld65		= 225,
	KeyWorld66		= 226,
	KeyWorld67		= 227,
	KeyWorld68		= 228,
	KeyWorld69		= 229,
	KeyWorld70		= 230,
	KeyWorld71		= 231,
	KeyWorld72		= 232,
	KeyWorld73		= 233,
	KeyWorld74		= 234,
	KeyWorld75		= 235,
	KeyWorld76		= 236,
	KeyWorld77		= 237,
	KeyWorld78		= 238,
	KeyWorld79		= 239,
	KeyWorld80		= 240,
	KeyWorld81		= 241,
	KeyWorld82		= 242,
	KeyWorld83		= 243,
	KeyWorld84		= 244,
	KeyWorld85		= 245,
	KeyWorld86		= 246,
	KeyWorld87		= 247,
	KeyWorld88		= 248,
	KeyWorld89		= 249,
	KeyWorld90		= 250,
	KeyWorld91		= 251,
	KeyWorld92		= 252,
	KeyWorld93		= 253,
	KeyWorld94		= 254,
	KeyWorld95		= 255,		//0xFF

	//Numeric keypad
	KeyKP0		    = 256,
	KeyKP1		    = 257,
	KeyKP2		    = 258,
	KeyKP3		    = 259,
	KeyKP4		    = 260,
	KeyKP5		    = 261,
	KeyKP6		    = 262,
	KeyKP7		    = 263,
	KeyKP8		    = 264,
	KeyKP9		    = 265,
	KeyKPPeriod 	= 266,
	KeyKPDivide 	= 267,
	KeyKPMultiply	= 268,
	KeyKPMinus		= 269,
	KeyKPPlus		= 270,
	KeyKPEnter		= 271,
	KeyKPEquals 	= 272,

	//Arrows + Home/End pad
	KeyUp			= 273,
	KeyDown		    = 274,
	KeyRight		= 275,
	KeyLeft		    = 276,
	KeyInsert		= 277,
	KeyHome		    = 278,
	KeyEnd		    = 279,
	KeyPageUp		= 280,
	KeyPageDown 	= 281,

	//Function keys
	KeyF1		    = 282,
	KeyF2		    = 283,
	KeyF3		    = 284,
	KeyF4		    = 285,
	KeyF5		    = 286,
	KeyF6		    = 287,
	KeyF7		    = 288,
	KeyF8		    = 289,
	KeyF9		    = 290,
	KeyF10		    = 291,
	KeyF11		    = 292,
	KeyF12		    = 293,
	KeyF13		    = 294,
	KeyF14		    = 295,
	KeyF15		    = 296,

	//Key state modifier keys
	KeyNumLock		= 300,
	KeyCapsLock		= 301,
	KeyScrollLock	= 302,
	KeyRShift		= 303,
	KeyLShift		= 304,
	KeyRCtrl		= 305,
	KeyLCtrl		= 306,
	KeyRAlt		    = 307,
	KeyLAlt		    = 308,
	KeyRMeta		= 309,
	KeyLMeta		= 310,
	KeyLSuper		= 311,		//Left "Windows" key
	KeyRSuper		= 312,		//Right "Windows" key
	KeyMode		    = 313,		//"Alt Gr" key
	KeyCompose		= 314,	    //Multi-key compose key

	//Miscellaneous function keys
	KeyHelp		    = 315,
	KeyPrint		= 316,
	KeySysReq		= 317,
	KeyBreak		= 318,
	KeyMenu		    = 319,
	KeyPower		= 320,		//Power Macintosh power key
	KeyEuro		    = 321,		//Some european keyboards
	KeyUndo		    = 322,		//Atari keyboard has Undo

	//Add any other keys here

	KeyLast
} Key;

//
//Enumeration of valid key mods (possibly OR'd together)
//
typedef enum {
	KeyModNone  = 0x0000,
	KeyModLShift= 0x0001,
	KeyModRShift= 0x0002,
	KeyModLCtrl = 0x0040,
	KeyModRCtrl = 0x0080,
	KeyModLAlt  = 0x0100,
	KeyModRAlt  = 0x0200,
	KeyModLMeta = 0x0400,
	KeyModRMeta = 0x0800,
	KeyModNum   = 0x1000,
	KeyModCaps  = 0x2000,
	KeyModMode  = 0x4000,
	KeyModReserved = 0x8000
} KeyMod;

#define KeyModCtrl	(KeyModLCtrl|KeyModRCtrl)
#define KeyModShift	(KeyModLShift|KeyModRShift)
#define KeyModAlt	(KeyModLAlt|KeyModRAlt)
#define KeyModMeta	(KeyModLMeta|KeyModRMeta)

}

#endif
