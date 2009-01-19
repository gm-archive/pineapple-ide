#ifndef _COLOR_H_
#define _COLOR_H_

namespace Pineapple{
    class Color{
        private:
            float r,g,b,a;
        public:
            static Color* const BLACK;
            static Color* const WHITE;
            static Color* const RED;
            static Color* const GREEN;
            static Color* const BLUE;
            static Color* const YELLOW;
            static Color* const TRANSPARENT;
            Color(float r, float g, float b, float a = 1.0f){
                this->r = r;
                this->g = g;
                this->b = b;
                this->a = a;
            }
            float getRed() const { return r; }
            float getGreen() const { return g; }
            float getBlue() const { return b; }
            float getAlpha() const { return a; }
    };
}

#endif
