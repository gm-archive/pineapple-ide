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

pineapple::objects::Color::Color(int r, int g, int b)
{
    this->r = ((float) r)/255;
    this->g = ((float) g)/255;
    this->b = ((float) b)/255;
    this->a = 1.0f;
}

pineapple::objects::Color::Color(int r, int g, int b, float a)
{
    this->r = ((float) r)/255;
    this->g = ((float) g)/255;
    this->b = ((float) b)/255;
    this->a = a;
}

pineapple::objects::Color::Color(int r, int g, int b, int a)
{
    this->r = ((float) r)/255;
    this->g = ((float) g)/255;
    this->b = ((float) b)/255;
    this->a = ((float) a)/255;
}

pineapple::objects::Color::Color(float r, float g, float b)
{
    this->r = r;
    this->g = g;
    this->b = b;
    this->a = 1.0f;
}

pineapple::objects::Color::Color(float r, float g, float b, float a)
{
    this->r = r;
    this->g = g;
    this->b = b;
    this->a = a;
}

float pineapple::objects::Color::getRed()
{
    return r;
}

float pineapple::objects::Color::getGreen()
{
    return g;
}

float pineapple::objects::Color::getBlue()
{
    return b;
}

float pineapple::objects::Color::getAlpha()
{
    return a;
}
