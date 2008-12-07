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

#ifndef _VIEW_H
#define	_VIEW_H

#include "pineapple.h"

class pineapple::objects::View
{
    private:
        int viewport_x;
        int viewport_y;
        //As for the following comments
        //Never forget that POSITIVE + NEGATIVE
        //Is the same as POSITIVE - abs(NEGATIVE)
        int viewport_width; //If>0, then absolute value
                                //If=0, then screen width
                                //If<0, then screen width + viewport_width
        int viewport_height; //If>0, then absolute value
                                //If=0, then screen height
                                //If<0, then screen height + viewport_height
        
        int source_x;
        int source_y;
        int source_width; //If>0, then absolute value
                              //If=0, then same as viewport_width
                              //If<0, then viewport_width + source_width
        int source_height;//If>0, then absolute value
                              //If=0, then same as viewport_height
                              //If<0, then viewport_height + source_height
        
    public:
        View();
        int getViewportX();
        int getViewportY();
        int getViewportWidth();
        int getViewportHeight();
        int getSourceX();
        int getSourceY();
        int getSourceWidth();
        int getSourceHeight();
        void setViewportX(int x);
        void setViewportY(int y);
        void setViewportWidth(int width);
        void setViewportHeight(int height);
        void setSourceX(int x);
        void setSourceY(int y);
        void setSourceWidth(int width);
        void setSourceHeight(int height);
        
        void GLSetup();
};

#endif	/* _VIEW_H */

