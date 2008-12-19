#ifndef PAMATH_H
#define PAMATH_H

#include <cmath>

namespace Pineapple
{
    namespace Math
    {
        const double pi = 3.141592653589793238;

        template <class T>
        inline int sign(T a)
        {
            return (a < 0) ? -1 : ((a > 0) ? 1 : 0);
        }

        template <class T>
        inline T max(T a, T b)
        {
            return (a > b) ? a : b;
        }

        template <class T>
        inline T min(T a, T b)
        {
            return (a < b) ? a : b;
        }

        template <class T>
        inline T abs(T a)
        {
            return (a > 0) ? a : -a;
        }

        //Aliases so we can have these in the Math namespace
        //left out because of abiguities... how to get Math:: to work?
        /*inline double sin(double angle) { return ::sin(angle); }
        inline double cos(double angle) { return ::cos(angle); }
        inline double tan(double angle) { return ::tan(angle); }
        inline double asin(double x) { return ::asin(x); }
        inline double acos(double x) { return ::acos(x); }
        inline double atan(double x) { return ::atan(x); }
        inline double pow(double base, double exponent) { return ::pow(base, exponent); }
        inline double sqrt(double x) { return ::sqrt(x); }*/
    }
}

#endif
