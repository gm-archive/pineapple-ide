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

using namespace pineapple::std;
using namespace pineapple::objects;

typedef void WMFunction(char*, char*);

int main(int argc, char** argv)
{
    Application::initialize(&argc, &argv);
    
    Window::setSize(640, 480, false);
    Window::setTitle(string("Hello World!"));
    Window::setResizable(true);
    
    Scene* s = new Scene(640, 480);
    Actor* a = new Actor();
    Texture* t = new Texture(string("luiscubal.png"));
    a->setVisible(true);
    a->setX(0.0f);
    a->setY(0.0f);
    a->setTexture(t);
    s->addActor(a);
    Application::setCurrentScene(s);
    a->setGravityDirection(315.0f);
    a->setGravity(0.05f);
    
    Window::run();
}
