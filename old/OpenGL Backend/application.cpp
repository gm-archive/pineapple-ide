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
#include <stdlib.h>
#include "SDL.h"

int* _argc;
char*** _argv;
bool _initialized = false;
bool _running = true;
int _preferred_fps = 60;
::pineapple::objects::Scene* currentScene = NULL;

void pineapple::std::Application::initialize(int* argc, char*** argv)
{
    if(_initialized)
        throw string("Already initialized");
    
    _argc = argc;
    _argv = argv;
    
    if(SDL_Init(SDL_INIT_VIDEO)){
        printf("Unable to initialize SDL: %s\n", SDL_GetError());
        Application::kill(1);
    }
    atexit(SDL_Quit);
    
    currentScene = NULL;
    
    SDL_GL_SetAttribute(SDL_GL_DOUBLEBUFFER, 1);
    SDL_GL_SetAttribute(SDL_GL_DEPTH_SIZE, 16);
    SDL_GL_SetAttribute(SDL_GL_RED_SIZE, 8);
    SDL_GL_SetAttribute(SDL_GL_GREEN_SIZE, 8);
    SDL_GL_SetAttribute(SDL_GL_BLUE_SIZE, 8);
    SDL_GL_SetAttribute(SDL_GL_ALPHA_SIZE, 8);
    
    _initialized = true;
}

int pineapple::std::Application::getArgumentCount()
{
    return (*_argc);
}

string pineapple::std::Application::getArgumentAt(int index)
{
    if(index>=getArgumentCount())
        return string("");
    char** argv = (*_argv);
    char* argbeg = argv[index];
    return string(argbeg);
}

bool pineapple::std::Application::isRunning()
{
    return _running;
}

void pineapple::std::Application::requestExit()
{
    _running = false;
}

void pineapple::std::Application::kill(int errorcode)
{
    exit(errorcode);
}

int pineapple::std::Application::getPreferredSpeed()
{
    return _preferred_fps;
}

void pineapple::std::Application::setPreferredSpeed(int fps)
{
    _preferred_fps = fps;
}

::pineapple::objects::Scene* pineapple::std::Application::getCurrentScene()
{
    return currentScene;
}

void pineapple::std::Application::setCurrentScene(::pineapple::objects::Scene* scene)
{
    if(currentScene==scene) return;
    ::pineapple::objects::Scene* oldScene = currentScene;
    if(currentScene!=NULL){
        currentScene->destroy();
    }
    currentScene = scene;
    scene->create();
    if(oldScene!=NULL)
        scene->retrievePersistentActors(oldScene);
}
