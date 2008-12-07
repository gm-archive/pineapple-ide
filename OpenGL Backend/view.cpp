#include "SDL/SDL_opengl.h"
#include "view.h"
#include "window.h"
#include <iostream>

using namespace Pineapple;

View::View(int swidth, int sheight, int pwidth, int pheight,
           int sx, int sy, int px, int py)
{
    this->px = px;
    this->py = py;
    this->pwidth = pwidth;
    this->pheight = pheight;

    this->sx = sx;
    this->sy = sy;
    this->swidth = swidth;
    this->sheight = sheight;
}

void View::set()
{
    //viewport
    int width = pwidth;
    int height = pheight;

    if (width == 0)
        width = Window::getWidth();
    else if (width < 0)
        width = Window::getWidth() + width;

    if (height == 0)
        height = Window::getHeight();
    else if (height < 0)
        height = Window::getHeight() + height;

    glViewport(px, py, width, height);

    //view size
    int sw = swidth;
    int sh = sheight;

    if (sw == 0)
        sw = width;
    else if (sw < 0)
        sw = width + sw;

    if (sh == 0)
        sh = height;
    else if (sh < 0)
        sh = height + sh;

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    glOrtho(sx, sx + sw, sy + sh, sy, -1.0f, 1.0f);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
}
