/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>

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

#include "pineapple.h"

#include <math.h>

const double pineapple::std::Math::PI = M_PI;

double pineapple::std::Math::sin(double x) {
    return ::sin(x);
}

double pineapple::std::Math::cos(double x) {
    return ::cos(x);
}

double pineapple::std::Math::tan(double x) {
    return ::tan(x);
}

double pineapple::std::Math::sqrt(double x) {
    return ::sqrt(x);
}

double pineapple::std::Math::deg2rad(double deg) {
    return (deg*PI)/180;
}

double pineapple::std::Math::rad2deg(double rad) {
    return (rad*180)/PI;
}

