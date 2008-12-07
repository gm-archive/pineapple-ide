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

void pineapple::objects::DrawingPrimitives::drawRectangle(int x, int y, int width,
        int height, Color* c)
{
    
    glTranslatef(x, y, 0);
    
    glColor4f(c->getRed(), c->getGreen(), c->getBlue(), c->getAlpha());
    glBegin(GL_QUADS);
        glVertex3f(0, 0, 0);

        glVertex3f(0, height, 0);

        glVertex3f(width, height, 0);

        glVertex3f(width, 0, 0);
    glEnd();
    glLoadIdentity();
}

void pineapple::objects::DrawingPrimitives::drawRectangleGradient(int x, int y, int width,
        int height, Color* c1, Color* c2, Color* c3, Color* c4)
{
    
    glTranslatef(x, y, 0);
    
    glBegin(GL_QUADS);
        glColor4f(c1->getRed(), c1->getGreen(), c1->getBlue(), c1->getAlpha());
        glVertex3f(0, 0, 0);

        glColor4f(c2->getRed(), c2->getGreen(), c2->getBlue(), c2->getAlpha());
        glVertex3f(0, height, 0);

        glColor4f(c3->getRed(), c3->getGreen(), c3->getBlue(), c3->getAlpha());
        glVertex3f(width, height, 0);

        glColor4f(c4->getRed(), c4->getGreen(), c4->getBlue(), c4->getAlpha());
        glVertex3f(width, 0, 0);
    glEnd();
    glLoadIdentity();
}
