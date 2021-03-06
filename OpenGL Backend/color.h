#ifndef _COLOR_H_
#define _COLOR_H_

#include "core.h"

namespace Pineapple{
    class Color : public Object{
        private:
            float r,g,b,a;
        public:
            static Color* const TRANSPARENT_WHITE;

            Color(float r, float g, float b, float a = 1.0) {
                this->r = r;
                this->g = g;
                this->b = b;
                this->a = a;
            }

            Color(int r, int g, int b, int a = 255) {
                this->r = r/255.0;
                this->g = g/255.0;
                this->b = b/255.0;
                this->a = a/255.0;
            }
            float getRed() const { return r; }
            float getGreen() const { return g; }
            float getBlue() const { return b; }
            float getAlpha() const { return a; }

            static Color* const SNOW;
            static Color* const GHOST_WHITE;
            static Color* const GHOSTWHITE;
            static Color* const WHITE_SMOKE;
            static Color* const WHITESMOKE;
            static Color* const GAINSBORO;
            static Color* const FLORAL_WHITE;
            static Color* const FLORALWHITE;
            static Color* const OLD_LACE;
            static Color* const OLDLACE;
            static Color* const LINEN;
            static Color* const ANTIQUE_WHITE;
            static Color* const ANTIQUEWHITE;
            static Color* const PAPAYA_WHIP;
            static Color* const PAPAYAWHIP;
            static Color* const BLANCHED_ALMOND;
            static Color* const BLANCHEDALMOND;
            static Color* const BISQUE;
            static Color* const PEACH_PUFF;
            static Color* const PEACHPUFF;
            static Color* const NAVAJO_WHITE;
            static Color* const NAVAJOWHITE;
            static Color* const MOCCASIN;
            static Color* const CORNSILK;
            static Color* const IVORY;
            static Color* const LEMON_CHIFFON;
            static Color* const LEMONCHIFFON;
            static Color* const SEASHELL;
            static Color* const HONEYDEW;
            static Color* const MINT_CREAM;
            static Color* const MINTCREAM;
            static Color* const AZURE;
            static Color* const ALICE_BLUE;
            static Color* const ALICEBLUE;
            static Color* const LAVENDER;
            static Color* const LAVENDER_BLUSH;
            static Color* const LAVENDERBLUSH;
            static Color* const MISTY_ROSE;
            static Color* const MISTYROSE;
            static Color* const WHITE;
            static Color* const BLACK;
            static Color* const DARK_SLATE_GRAY;
            static Color* const DARKSLATEGRAY;
            static Color* const DARK_SLATE_GREY;
            static Color* const DARKSLATEGREY;
            static Color* const DIM_GRAY;
            static Color* const DIMGRAY;
            static Color* const DIM_GREY;
            static Color* const DIMGREY;
            static Color* const SLATE_GRAY;
            static Color* const SLATEGRAY;
            static Color* const SLATE_GREY;
            static Color* const SLATEGREY;
            static Color* const LIGHT_SLATE_GRAY;
            static Color* const LIGHTSLATEGRAY;
            static Color* const LIGHT_SLATE_GREY;
            static Color* const LIGHTSLATEGREY;
            static Color* const GRAY;
            static Color* const GREY;
            static Color* const LIGHT_GREY;
            static Color* const LIGHTGREY;
            static Color* const LIGHT_GRAY;
            static Color* const LIGHTGRAY;
            static Color* const MIDNIGHT_BLUE;
            static Color* const MIDNIGHTBLUE;
            static Color* const NAVY;
            static Color* const NAVY_BLUE;
            static Color* const NAVYBLUE;
            static Color* const CORNFLOWER_BLUE;
            static Color* const CORNFLOWERBLUE;
            static Color* const DARK_SLATE_BLUE;
            static Color* const DARKSLATEBLUE;
            static Color* const SLATE_BLUE;
            static Color* const SLATEBLUE;
            static Color* const MEDIUM_SLATE_BLUE;
            static Color* const MEDIUMSLATEBLUE;
            static Color* const LIGHT_SLATE_BLUE;
            static Color* const LIGHTSLATEBLUE;
            static Color* const MEDIUM_BLUE;
            static Color* const MEDIUMBLUE;
            static Color* const ROYAL_BLUE;
            static Color* const ROYALBLUE;
            static Color* const BLUE;
            static Color* const DODGER_BLUE;
            static Color* const DODGERBLUE;
            static Color* const DEEP_SKY_BLUE;
            static Color* const DEEPSKYBLUE;
            static Color* const SKY_BLUE;
            static Color* const SKYBLUE;
            static Color* const LIGHT_SKY_BLUE;
            static Color* const LIGHTSKYBLUE;
            static Color* const STEEL_BLUE;
            static Color* const STEELBLUE;
            static Color* const LIGHT_STEEL_BLUE;
            static Color* const LIGHTSTEELBLUE;
            static Color* const LIGHT_BLUE;
            static Color* const LIGHTBLUE;
            static Color* const POWDER_BLUE;
            static Color* const POWDERBLUE;
            static Color* const PALE_TURQUOISE;
            static Color* const PALETURQUOISE;
            static Color* const DARK_TURQUOISE;
            static Color* const DARKTURQUOISE;
            static Color* const MEDIUM_TURQUOISE;
            static Color* const MEDIUMTURQUOISE;
            static Color* const TURQUOISE;
            static Color* const CYAN;
            static Color* const LIGHT_CYAN;
            static Color* const LIGHTCYAN;
            static Color* const CADET_BLUE;
            static Color* const CADETBLUE;
            static Color* const MEDIUM_AQUAMARINE;
            static Color* const MEDIUMAQUAMARINE;
            static Color* const AQUAMARINE;
            static Color* const DARK_GREEN;
            static Color* const DARKGREEN;
            static Color* const DARK_OLIVE_GREEN;
            static Color* const DARKOLIVEGREEN;
            static Color* const DARK_SEA_GREEN;
            static Color* const DARKSEAGREEN;
            static Color* const SEA_GREEN;
            static Color* const SEAGREEN;
            static Color* const MEDIUM_SEA_GREEN;
            static Color* const MEDIUMSEAGREEN;
            static Color* const LIGHT_SEA_GREEN;
            static Color* const LIGHTSEAGREEN;
            static Color* const PALE_GREEN;
            static Color* const PALEGREEN;
            static Color* const SPRING_GREEN;
            static Color* const SPRINGGREEN;
            static Color* const LAWN_GREEN;
            static Color* const LAWNGREEN;
            static Color* const GREEN;
            static Color* const CHARTREUSE;
            static Color* const MEDIUM_SPRING_GREEN;
            static Color* const MEDIUMSPRINGGREEN;
            static Color* const GREEN_YELLOW;
            static Color* const GREENYELLOW;
            static Color* const LIME_GREEN;
            static Color* const LIMEGREEN;
            static Color* const YELLOW_GREEN;
            static Color* const YELLOWGREEN;
            static Color* const FOREST_GREEN;
            static Color* const FORESTGREEN;
            static Color* const OLIVE_DRAB;
            static Color* const OLIVEDRAB;
            static Color* const DARK_KHAKI;
            static Color* const DARKKHAKI;
            static Color* const KHAKI;
            static Color* const PALE_GOLDENROD;
            static Color* const PALEGOLDENROD;
            static Color* const LIGHT_GOLDENROD_YELLOW;
            static Color* const LIGHTGOLDENRODYELLOW;
            static Color* const LIGHT_YELLOW;
            static Color* const LIGHTYELLOW;
            static Color* const YELLOW;
            static Color* const GOLD;
            static Color* const LIGHT_GOLDENROD;
            static Color* const LIGHTGOLDENROD;
            static Color* const GOLDENROD;
            static Color* const DARK_GOLDENROD;
            static Color* const DARKGOLDENROD;
            static Color* const ROSY_BROWN;
            static Color* const ROSYBROWN;
            static Color* const INDIAN_RED;
            static Color* const INDIANRED;
            static Color* const SADDLE_BROWN;
            static Color* const SADDLEBROWN;
            static Color* const SIENNA;
            static Color* const PERU;
            static Color* const BURLYWOOD;
            static Color* const BEIGE;
            static Color* const WHEAT;
            static Color* const SANDY_BROWN;
            static Color* const SANDYBROWN;
            static Color* const TAN;
            static Color* const CHOCOLATE;
            static Color* const FIREBRICK;
            static Color* const BROWN;
            static Color* const DARK_SALMON;
            static Color* const DARKSALMON;
            static Color* const SALMON;
            static Color* const LIGHT_SALMON;
            static Color* const LIGHTSALMON;
            static Color* const ORANGE;
            static Color* const DARK_ORANGE;
            static Color* const DARKORANGE;
            static Color* const CORAL;
            static Color* const LIGHT_CORAL;
            static Color* const LIGHTCORAL;
            static Color* const TOMATO;
            static Color* const ORANGE_RED;
            static Color* const ORANGERED;
            static Color* const RED;
            static Color* const HOT_PINK;
            static Color* const HOTPINK;
            static Color* const DEEP_PINK;
            static Color* const DEEPPINK;
            static Color* const PINK;
            static Color* const LIGHT_PINK;
            static Color* const LIGHTPINK;
            static Color* const PALE_VIOLET_RED;
            static Color* const PALEVIOLETRED;
            static Color* const MAROON;
            static Color* const MEDIUM_VIOLET_RED;
            static Color* const MEDIUMVIOLETRED;
            static Color* const VIOLET_RED;
            static Color* const VIOLETRED;
            static Color* const MAGENTA;
            static Color* const VIOLET;
            static Color* const PLUM;
            static Color* const ORCHID;
            static Color* const MEDIUM_ORCHID;
            static Color* const MEDIUMORCHID;
            static Color* const DARK_ORCHID;
            static Color* const DARKORCHID;
            static Color* const DARK_VIOLET;
            static Color* const DARKVIOLET;
            static Color* const BLUE_VIOLET;
            static Color* const BLUEVIOLET;
            static Color* const PURPLE;
            static Color* const MEDIUM_PURPLE;
            static Color* const MEDIUMPURPLE;
            static Color* const THISTLE;
            static Color* const SNOW1;
            static Color* const SNOW2;
            static Color* const SNOW3;
            static Color* const SNOW4;
            static Color* const SEASHELL1;
            static Color* const SEASHELL2;
            static Color* const SEASHELL3;
            static Color* const SEASHELL4;
            static Color* const ANTIQUEWHITE1;
            static Color* const ANTIQUEWHITE2;
            static Color* const ANTIQUEWHITE3;
            static Color* const ANTIQUEWHITE4;
            static Color* const BISQUE1;
            static Color* const BISQUE2;
            static Color* const BISQUE3;
            static Color* const BISQUE4;
            static Color* const PEACHPUFF1;
            static Color* const PEACHPUFF2;
            static Color* const PEACHPUFF3;
            static Color* const PEACHPUFF4;
            static Color* const NAVAJOWHITE1;
            static Color* const NAVAJOWHITE2;
            static Color* const NAVAJOWHITE3;
            static Color* const NAVAJOWHITE4;
            static Color* const LEMONCHIFFON1;
            static Color* const LEMONCHIFFON2;
            static Color* const LEMONCHIFFON3;
            static Color* const LEMONCHIFFON4;
            static Color* const CORNSILK1;
            static Color* const CORNSILK2;
            static Color* const CORNSILK3;
            static Color* const CORNSILK4;
            static Color* const IVORY1;
            static Color* const IVORY2;
            static Color* const IVORY3;
            static Color* const IVORY4;
            static Color* const HONEYDEW1;
            static Color* const HONEYDEW2;
            static Color* const HONEYDEW3;
            static Color* const HONEYDEW4;
            static Color* const LAVENDERBLUSH1;
            static Color* const LAVENDERBLUSH2;
            static Color* const LAVENDERBLUSH3;
            static Color* const LAVENDERBLUSH4;
            static Color* const MISTYROSE1;
            static Color* const MISTYROSE2;
            static Color* const MISTYROSE3;
            static Color* const MISTYROSE4;
            static Color* const AZURE1;
            static Color* const AZURE2;
            static Color* const AZURE3;
            static Color* const AZURE4;
            static Color* const SLATEBLUE1;
            static Color* const SLATEBLUE2;
            static Color* const SLATEBLUE3;
            static Color* const SLATEBLUE4;
            static Color* const ROYALBLUE1;
            static Color* const ROYALBLUE2;
            static Color* const ROYALBLUE3;
            static Color* const ROYALBLUE4;
            static Color* const BLUE1;
            static Color* const BLUE2;
            static Color* const BLUE3;
            static Color* const BLUE4;
            static Color* const DODGERBLUE1;
            static Color* const DODGERBLUE2;
            static Color* const DODGERBLUE3;
            static Color* const DODGERBLUE4;
            static Color* const STEELBLUE1;
            static Color* const STEELBLUE2;
            static Color* const STEELBLUE3;
            static Color* const STEELBLUE4;
            static Color* const DEEPSKYBLUE1;
            static Color* const DEEPSKYBLUE2;
            static Color* const DEEPSKYBLUE3;
            static Color* const DEEPSKYBLUE4;
            static Color* const SKYBLUE1;
            static Color* const SKYBLUE2;
            static Color* const SKYBLUE3;
            static Color* const SKYBLUE4;
            static Color* const LIGHTSKYBLUE1;
            static Color* const LIGHTSKYBLUE2;
            static Color* const LIGHTSKYBLUE3;
            static Color* const LIGHTSKYBLUE4;
            static Color* const SLATEGRAY1;
            static Color* const SLATEGRAY2;
            static Color* const SLATEGRAY3;
            static Color* const SLATEGRAY4;
            static Color* const LIGHTSTEELBLUE1;
            static Color* const LIGHTSTEELBLUE2;
            static Color* const LIGHTSTEELBLUE3;
            static Color* const LIGHTSTEELBLUE4;
            static Color* const LIGHTBLUE1;
            static Color* const LIGHTBLUE2;
            static Color* const LIGHTBLUE3;
            static Color* const LIGHTBLUE4;
            static Color* const LIGHTCYAN1;
            static Color* const LIGHTCYAN2;
            static Color* const LIGHTCYAN3;
            static Color* const LIGHTCYAN4;
            static Color* const PALETURQUOISE1;
            static Color* const PALETURQUOISE2;
            static Color* const PALETURQUOISE3;
            static Color* const PALETURQUOISE4;
            static Color* const CADETBLUE1;
            static Color* const CADETBLUE2;
            static Color* const CADETBLUE3;
            static Color* const CADETBLUE4;
            static Color* const TURQUOISE1;
            static Color* const TURQUOISE2;
            static Color* const TURQUOISE3;
            static Color* const TURQUOISE4;
            static Color* const CYAN1;
            static Color* const CYAN2;
            static Color* const CYAN3;
            static Color* const CYAN4;
            static Color* const DARKSLATEGRAY1;
            static Color* const DARKSLATEGRAY2;
            static Color* const DARKSLATEGRAY3;
            static Color* const DARKSLATEGRAY4;
            static Color* const AQUAMARINE1;
            static Color* const AQUAMARINE2;
            static Color* const AQUAMARINE3;
            static Color* const AQUAMARINE4;
            static Color* const DARKSEAGREEN1;
            static Color* const DARKSEAGREEN2;
            static Color* const DARKSEAGREEN3;
            static Color* const DARKSEAGREEN4;
            static Color* const SEAGREEN1;
            static Color* const SEAGREEN2;
            static Color* const SEAGREEN3;
            static Color* const SEAGREEN4;
            static Color* const PALEGREEN1;
            static Color* const PALEGREEN2;
            static Color* const PALEGREEN3;
            static Color* const PALEGREEN4;
            static Color* const SPRINGGREEN1;
            static Color* const SPRINGGREEN2;
            static Color* const SPRINGGREEN3;
            static Color* const SPRINGGREEN4;
            static Color* const GREEN1;
            static Color* const GREEN2;
            static Color* const GREEN3;
            static Color* const GREEN4;
            static Color* const CHARTREUSE1;
            static Color* const CHARTREUSE2;
            static Color* const CHARTREUSE3;
            static Color* const CHARTREUSE4;
            static Color* const OLIVEDRAB1;
            static Color* const OLIVEDRAB2;
            static Color* const OLIVEDRAB3;
            static Color* const OLIVEDRAB4;
            static Color* const DARKOLIVEGREEN1;
            static Color* const DARKOLIVEGREEN2;
            static Color* const DARKOLIVEGREEN3;
            static Color* const DARKOLIVEGREEN4;
            static Color* const KHAKI1;
            static Color* const KHAKI2;
            static Color* const KHAKI3;
            static Color* const KHAKI4;
            static Color* const LIGHTGOLDENROD1;
            static Color* const LIGHTGOLDENROD2;
            static Color* const LIGHTGOLDENROD3;
            static Color* const LIGHTGOLDENROD4;
            static Color* const LIGHTYELLOW1;
            static Color* const LIGHTYELLOW2;
            static Color* const LIGHTYELLOW3;
            static Color* const LIGHTYELLOW4;
            static Color* const YELLOW1;
            static Color* const YELLOW2;
            static Color* const YELLOW3;
            static Color* const YELLOW4;
            static Color* const GOLD1;
            static Color* const GOLD2;
            static Color* const GOLD3;
            static Color* const GOLD4;
            static Color* const GOLDENROD1;
            static Color* const GOLDENROD2;
            static Color* const GOLDENROD3;
            static Color* const GOLDENROD4;
            static Color* const DARKGOLDENROD1;
            static Color* const DARKGOLDENROD2;
            static Color* const DARKGOLDENROD3;
            static Color* const DARKGOLDENROD4;
            static Color* const ROSYBROWN1;
            static Color* const ROSYBROWN2;
            static Color* const ROSYBROWN3;
            static Color* const ROSYBROWN4;
            static Color* const INDIANRED1;
            static Color* const INDIANRED2;
            static Color* const INDIANRED3;
            static Color* const INDIANRED4;
            static Color* const SIENNA1;
            static Color* const SIENNA2;
            static Color* const SIENNA3;
            static Color* const SIENNA4;
            static Color* const BURLYWOOD1;
            static Color* const BURLYWOOD2;
            static Color* const BURLYWOOD3;
            static Color* const BURLYWOOD4;
            static Color* const WHEAT1;
            static Color* const WHEAT2;
            static Color* const WHEAT3;
            static Color* const WHEAT4;
            static Color* const TAN1;
            static Color* const TAN2;
            static Color* const TAN3;
            static Color* const TAN4;
            static Color* const CHOCOLATE1;
            static Color* const CHOCOLATE2;
            static Color* const CHOCOLATE3;
            static Color* const CHOCOLATE4;
            static Color* const FIREBRICK1;
            static Color* const FIREBRICK2;
            static Color* const FIREBRICK3;
            static Color* const FIREBRICK4;
            static Color* const BROWN1;
            static Color* const BROWN2;
            static Color* const BROWN3;
            static Color* const BROWN4;
            static Color* const SALMON1;
            static Color* const SALMON2;
            static Color* const SALMON3;
            static Color* const SALMON4;
            static Color* const LIGHTSALMON1;
            static Color* const LIGHTSALMON2;
            static Color* const LIGHTSALMON3;
            static Color* const LIGHTSALMON4;
            static Color* const ORANGE1;
            static Color* const ORANGE2;
            static Color* const ORANGE3;
            static Color* const ORANGE4;
            static Color* const DARKORANGE1;
            static Color* const DARKORANGE2;
            static Color* const DARKORANGE3;
            static Color* const DARKORANGE4;
            static Color* const CORAL1;
            static Color* const CORAL2;
            static Color* const CORAL3;
            static Color* const CORAL4;
            static Color* const TOMATO1;
            static Color* const TOMATO2;
            static Color* const TOMATO3;
            static Color* const TOMATO4;
            static Color* const ORANGERED1;
            static Color* const ORANGERED2;
            static Color* const ORANGERED3;
            static Color* const ORANGERED4;
            static Color* const RED1;
            static Color* const RED2;
            static Color* const RED3;
            static Color* const RED4;
            static Color* const DEBIANRED;
            static Color* const DEEPPINK1;
            static Color* const DEEPPINK2;
            static Color* const DEEPPINK3;
            static Color* const DEEPPINK4;
            static Color* const HOTPINK1;
            static Color* const HOTPINK2;
            static Color* const HOTPINK3;
            static Color* const HOTPINK4;
            static Color* const PINK1;
            static Color* const PINK2;
            static Color* const PINK3;
            static Color* const PINK4;
            static Color* const LIGHTPINK1;
            static Color* const LIGHTPINK2;
            static Color* const LIGHTPINK3;
            static Color* const LIGHTPINK4;
            static Color* const PALEVIOLETRED1;
            static Color* const PALEVIOLETRED2;
            static Color* const PALEVIOLETRED3;
            static Color* const PALEVIOLETRED4;
            static Color* const MAROON1;
            static Color* const MAROON2;
            static Color* const MAROON3;
            static Color* const MAROON4;
            static Color* const VIOLETRED1;
            static Color* const VIOLETRED2;
            static Color* const VIOLETRED3;
            static Color* const VIOLETRED4;
            static Color* const MAGENTA1;
            static Color* const MAGENTA2;
            static Color* const MAGENTA3;
            static Color* const MAGENTA4;
            static Color* const ORCHID1;
            static Color* const ORCHID2;
            static Color* const ORCHID3;
            static Color* const ORCHID4;
            static Color* const PLUM1;
            static Color* const PLUM2;
            static Color* const PLUM3;
            static Color* const PLUM4;
            static Color* const MEDIUMORCHID1;
            static Color* const MEDIUMORCHID2;
            static Color* const MEDIUMORCHID3;
            static Color* const MEDIUMORCHID4;
            static Color* const DARKORCHID1;
            static Color* const DARKORCHID2;
            static Color* const DARKORCHID3;
            static Color* const DARKORCHID4;
            static Color* const PURPLE1;
            static Color* const PURPLE2;
            static Color* const PURPLE3;
            static Color* const PURPLE4;
            static Color* const MEDIUMPURPLE1;
            static Color* const MEDIUMPURPLE2;
            static Color* const MEDIUMPURPLE3;
            static Color* const MEDIUMPURPLE4;
            static Color* const THISTLE1;
            static Color* const THISTLE2;
            static Color* const THISTLE3;
            static Color* const THISTLE4;
            static Color* const GRAY0;
            static Color* const GREY0;
            static Color* const GRAY1;
            static Color* const GREY1;
            static Color* const GRAY2;
            static Color* const GREY2;
            static Color* const GRAY3;
            static Color* const GREY3;
            static Color* const GRAY4;
            static Color* const GREY4;
            static Color* const GRAY5;
            static Color* const GREY5;
            static Color* const GRAY6;
            static Color* const GREY6;
            static Color* const GRAY7;
            static Color* const GREY7;
            static Color* const GRAY8;
            static Color* const GREY8;
            static Color* const GRAY9;
            static Color* const GREY9;
            static Color* const GRAY10;
            static Color* const GREY10;
            static Color* const GRAY11;
            static Color* const GREY11;
            static Color* const GRAY12;
            static Color* const GREY12;
            static Color* const GRAY13;
            static Color* const GREY13;
            static Color* const GRAY14;
            static Color* const GREY14;
            static Color* const GRAY15;
            static Color* const GREY15;
            static Color* const GRAY16;
            static Color* const GREY16;
            static Color* const GRAY17;
            static Color* const GREY17;
            static Color* const GRAY18;
            static Color* const GREY18;
            static Color* const GRAY19;
            static Color* const GREY19;
            static Color* const GRAY20;
            static Color* const GREY20;
            static Color* const GRAY21;
            static Color* const GREY21;
            static Color* const GRAY22;
            static Color* const GREY22;
            static Color* const GRAY23;
            static Color* const GREY23;
            static Color* const GRAY24;
            static Color* const GREY24;
            static Color* const GRAY25;
            static Color* const GREY25;
            static Color* const GRAY26;
            static Color* const GREY26;
            static Color* const GRAY27;
            static Color* const GREY27;
            static Color* const GRAY28;
            static Color* const GREY28;
            static Color* const GRAY29;
            static Color* const GREY29;
            static Color* const GRAY30;
            static Color* const GREY30;
            static Color* const GRAY31;
            static Color* const GREY31;
            static Color* const GRAY32;
            static Color* const GREY32;
            static Color* const GRAY33;
            static Color* const GREY33;
            static Color* const GRAY34;
            static Color* const GREY34;
            static Color* const GRAY35;
            static Color* const GREY35;
            static Color* const GRAY36;
            static Color* const GREY36;
            static Color* const GRAY37;
            static Color* const GREY37;
            static Color* const GRAY38;
            static Color* const GREY38;
            static Color* const GRAY39;
            static Color* const GREY39;
            static Color* const GRAY40;
            static Color* const GREY40;
            static Color* const GRAY41;
            static Color* const GREY41;
            static Color* const GRAY42;
            static Color* const GREY42;
            static Color* const GRAY43;
            static Color* const GREY43;
            static Color* const GRAY44;
            static Color* const GREY44;
            static Color* const GRAY45;
            static Color* const GREY45;
            static Color* const GRAY46;
            static Color* const GREY46;
            static Color* const GRAY47;
            static Color* const GREY47;
            static Color* const GRAY48;
            static Color* const GREY48;
            static Color* const GRAY49;
            static Color* const GREY49;
            static Color* const GRAY50;
            static Color* const GREY50;
            static Color* const GRAY51;
            static Color* const GREY51;
            static Color* const GRAY52;
            static Color* const GREY52;
            static Color* const GRAY53;
            static Color* const GREY53;
            static Color* const GRAY54;
            static Color* const GREY54;
            static Color* const GRAY55;
            static Color* const GREY55;
            static Color* const GRAY56;
            static Color* const GREY56;
            static Color* const GRAY57;
            static Color* const GREY57;
            static Color* const GRAY58;
            static Color* const GREY58;
            static Color* const GRAY59;
            static Color* const GREY59;
            static Color* const GRAY60;
            static Color* const GREY60;
            static Color* const GRAY61;
            static Color* const GREY61;
            static Color* const GRAY62;
            static Color* const GREY62;
            static Color* const GRAY63;
            static Color* const GREY63;
            static Color* const GRAY64;
            static Color* const GREY64;
            static Color* const GRAY65;
            static Color* const GREY65;
            static Color* const GRAY66;
            static Color* const GREY66;
            static Color* const GRAY67;
            static Color* const GREY67;
            static Color* const GRAY68;
            static Color* const GREY68;
            static Color* const GRAY69;
            static Color* const GREY69;
            static Color* const GRAY70;
            static Color* const GREY70;
            static Color* const GRAY71;
            static Color* const GREY71;
            static Color* const GRAY72;
            static Color* const GREY72;
            static Color* const GRAY73;
            static Color* const GREY73;
            static Color* const GRAY74;
            static Color* const GREY74;
            static Color* const GRAY75;
            static Color* const GREY75;
            static Color* const GRAY76;
            static Color* const GREY76;
            static Color* const GRAY77;
            static Color* const GREY77;
            static Color* const GRAY78;
            static Color* const GREY78;
            static Color* const GRAY79;
            static Color* const GREY79;
            static Color* const GRAY80;
            static Color* const GREY80;
            static Color* const GRAY81;
            static Color* const GREY81;
            static Color* const GRAY82;
            static Color* const GREY82;
            static Color* const GRAY83;
            static Color* const GREY83;
            static Color* const GRAY84;
            static Color* const GREY84;
            static Color* const GRAY85;
            static Color* const GREY85;
            static Color* const GRAY86;
            static Color* const GREY86;
            static Color* const GRAY87;
            static Color* const GREY87;
            static Color* const GRAY88;
            static Color* const GREY88;
            static Color* const GRAY89;
            static Color* const GREY89;
            static Color* const GRAY90;
            static Color* const GREY90;
            static Color* const GRAY91;
            static Color* const GREY91;
            static Color* const GRAY92;
            static Color* const GREY92;
            static Color* const GRAY93;
            static Color* const GREY93;
            static Color* const GRAY94;
            static Color* const GREY94;
            static Color* const GRAY95;
            static Color* const GREY95;
            static Color* const GRAY96;
            static Color* const GREY96;
            static Color* const GRAY97;
            static Color* const GREY97;
            static Color* const GRAY98;
            static Color* const GREY98;
            static Color* const GRAY99;
            static Color* const GREY99;
            static Color* const GRAY100;
            static Color* const GREY100;
            static Color* const DARK_GREY;
            static Color* const DARKGREY;
            static Color* const DARK_GRAY;
            static Color* const DARKGRAY;
            static Color* const DARK_BLUE;
            static Color* const DARKBLUE;
            static Color* const DARK_CYAN;
            static Color* const DARKCYAN;
            static Color* const DARK_MAGENTA;
            static Color* const DARKMAGENTA;
            static Color* const DARK_RED;
            static Color* const DARKRED;
            static Color* const LIGHT_GREEN;
            static Color* const LIGHTGREEN;
    };
}

#endif
