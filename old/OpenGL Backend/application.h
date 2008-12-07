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

#ifndef _APPLICATION_H
#define	_APPLICATION_H

#include "pineapple.h"

class pineapple::std::Application
{
    private:
        Application(); //Don't construct
    public:
        static void initialize(int* argc, char*** argv);
        static int getArgumentCount();
        static string getArgumentAt(int index);
        static bool isRunning(); //requestExit();
        static void requestExit();
        static void kill(int errorcode);
        static int getPreferredSpeed();
        static void setPreferredSpeed(int fps);
        static ::pineapple::objects::Scene* getCurrentScene();
        static void setCurrentScene(::pineapple::objects::Scene* scene);
};

#endif	/* _APPLICATION_H */
