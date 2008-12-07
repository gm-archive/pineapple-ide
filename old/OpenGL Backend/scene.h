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


#ifndef _SCENE_H
#define	_SCENE_H

#include "pineapple.h"

class pineapple::objects::Scene
{
    private:
        ::std::vector<View*>* views;
        ::std::vector<Actor*>* actors;
        int width;
        int height;
    public:
        Scene(int width = 640, int height = 480);
        void draw();
        void drawView(View* v);
        void create();
        void loop();
        void destroy();
        void retrievePersistentActors(Scene* otherScene);
        int getWidth();
        int getHeight();
        void setWidth(int width);
        void setHeight(int height);
        void addView(View* view);
        void addActor(Actor* actor);
        void onKeyDown(string key);
        void onKeyUp(string key);
};

#endif	/* _SCENE_H */

