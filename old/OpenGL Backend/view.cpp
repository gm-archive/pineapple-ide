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

using pineapple::std::Window;

pineapple::objects::View::View()
{
    viewport_x = 0;
    viewport_y = 0;
    viewport_width = 0;
    viewport_height = 0;
    source_x = 0;
    source_y = 0;
    source_width = 640;
    source_height = 480;
}

int pineapple::objects::View::getViewportX()
{
    return viewport_x;
}

int pineapple::objects::View::getViewportY()
{
    return viewport_y;
}

int pineapple::objects::View::getViewportWidth()
{
    return viewport_width;
}

int pineapple::objects::View::getViewportHeight()
{
    return viewport_height;
}

int pineapple::objects::View::getSourceX()
{
    return source_x;
}

int pineapple::objects::View::getSourceY()
{
    return source_y;
}

int pineapple::objects::View::getSourceWidth()
{
    return source_width;
}

int pineapple::objects::View::getSourceHeight()
{
    return source_height;
}

void pineapple::objects::View::setViewportX(int x)
{
    viewport_x = x;
}

void pineapple::objects::View::setViewportY(int y)
{
    viewport_y = y;
}

void pineapple::objects::View::setViewportWidth(int width)
{
    viewport_width = width;
}

void pineapple::objects::View::setViewportHeight(int height)
{
    viewport_height = height;
}

void pineapple::objects::View::setSourceX(int x)
{
    source_x = x;
}

void pineapple::objects::View::setSourceY(int y)
{
    source_y = y;
}

void pineapple::objects::View::setSourceWidth(int width)
{
    source_width = width;
}

void pineapple::objects::View::setSourceHeight(int height)
{
    source_height = height;
}

void pineapple::objects::View::GLSetup()
{
    int x = viewport_x;
    int y = viewport_y;
    int width = viewport_width;
    int height = viewport_height;
    if(width==0){
        width = Window::getWidth();
    } else if(width<0){
        width = Window::getWidth() + width; //Since width is negative
                                            //This '+' becomes a '-'
    }
    
    if(height==0){
        height = Window::getHeight();
    } else if(width<0){
        height = Window::getHeight() + height; //Since height is negative
                                            //This '+' becomes a '-'
    }
    glViewport(x, y, width, height);
    
    int sw = source_width;
    int sh = source_height;
    if(sw==0)
        sw = width;
    else if(sw<0)
        sw = width + sw;
    if(sh==0)
        sh = height;
    else if(sh<0)
        sh = height + sh;
    
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0.0f, sw, sh, 0.0f, -1.0f, 1.0f); //Zoom
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
}
