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

#ifndef _PINEAPPLE_H
#define	_PINEAPPLE_H

#include <string>
#include <vector>
#include "SDL.h"
#include "SDL_opengl.h"

typedef std::string string;
typedef void* _FP_SIMPLIFIER(const void*, ...);

namespace pineapple {
    namespace std {
        class Application;
        class Window;
        class Math;
        class NativeLibrary;
        class FunctionPointer;
    }
    namespace objects {
        class Drawable;
        class Texture;
        class DrawingPrimitives;
        class Color;

        class Actor;
        class View;
        class Scene;
    }
}

#include "application.h"
#include "window.h"
#include "math.h"

#include "drawable.h"
#include "texture.h"
#include "drawingprimitives.h"
#include "color.h"

#include "actor.h"
#include "view.h"
#include "scene.h"

#ifdef unix
//Running Linux Or Unix

#include "unix-interop.h"

#else
//Not yet implemented (Windows?)

#include "dummy-interop.h"

#endif

#include "functionpointer.h"

#endif	/* _PINEAPPLE_H */

