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
#include "SDL.h"
#include "SDL_opengl.h"

int pineapple::std::Window::_window_width = 0;
int pineapple::std::Window::_window_height = 0;
bool pineapple::std::Window::_window_resizable = false;
bool pineapple::std::Window::_window_fullscreen = false;
SDL_Surface *pineapple::std::Window::_sdl_screen = NULL;
string pineapple::std::Window::_window_title = "";

int pineapple::std::Window::getWidth() {
    return _window_width;
}

int pineapple::std::Window::getHeight() {
    return _window_height;
}

bool pineapple::std::Window::isFullscreen() {
    return _window_fullscreen;
}

bool pineapple::std::Window::isResizable() {
    return _window_resizable;
}

void pineapple::std::Window::setSize(int width, int height) {
    _window_width = width;
    _window_height = height;
    updateVideoMode();
}

void pineapple::std::Window::setSize(int width, int height, bool fullscreen) {
    _window_width = width;
    _window_height = height;
    _window_fullscreen = fullscreen;
    updateVideoMode();
}

void pineapple::std::Window::setFullscreen(bool fullscreen) {
    _window_fullscreen = fullscreen;
    updateVideoMode();
}

void pineapple::std::Window::setTitle(string title) {
    _window_title = title;
    SDL_WM_SetCaption(title.c_str(), title.c_str());
}

string pineapple::std::Window::getTitle() {
    return _window_title;
}

void pineapple::std::Window::setResizable(bool resizable) {
    _window_resizable = resizable;
    updateVideoMode();
}

void pineapple::std::Window::updateVideoMode() {
    Uint32 flags = SDL_OPENGL;
    if (isFullscreen())
        flags |= SDL_FULLSCREEN;
    if (isResizable())
        flags |= SDL_RESIZABLE;

    _sdl_screen = SDL_SetVideoMode(getWidth(), getHeight(), 16, flags);
    if (_sdl_screen == NULL) {
        printf("Unable set SDL Video Mode: %s\n", SDL_GetError());
        Application::kill(1);
    }
   
    
    glEnable(GL_TEXTURE_2D);
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

    //glShadeModel(GL_SMOOTH);
    //glDepthFunc(GL_LEQUAL);
    //glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
    glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    //glClear(GL_COLOR_BUFFER_BIT);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    
    glOrtho(0.0f, getWidth(), getHeight(), 0.0f, -1.0f, 1.0f); //Zoom
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
}

void pineapple::std::Window::run()
{
    SDL_Event event;
    while(SDL_PollEvent(&event))
    {
        switch(event.type)
        {
            case SDL_QUIT:
                Application::requestExit(); break;
            case SDL_VIDEORESIZE:
                setSize(event.resize.w, event.resize.h);
            case SDL_KEYDOWN:
                simulateKeyDownEvent(
                        string(SDL_GetKeyName(event.key.keysym.sym))); break;
            case SDL_KEYUP:
                simulateKeyUpEvent(
                        string(SDL_GetKeyName(event.key.keysym.sym))); break;
        }
    }
    
    if(Application::isRunning()){
        ::pineapple::objects::Scene* s = Application::getCurrentScene();
        if(s!=NULL)
            s->loop();
        redraw();
        SDL_GL_SwapBuffers();
        SDL_Delay(1000/Application::getPreferredSpeed());
        run();
    }
}

void pineapple::std::Window::redraw()
{
    glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
    glLoadIdentity();
    
    ::pineapple::objects::Scene* s = Application::getCurrentScene();
    if(s!=NULL)
    {
        s->draw();
    }
    else{
        printf("WARNING: Scene is null\n");
    }
}

void pineapple::std::Window::simulateKeyDownEvent(string key)
{
    ::pineapple::objects::Scene* s = Application::getCurrentScene();
    if(s!=NULL)
    {
        s->onKeyDown(key);
    }
}

void pineapple::std::Window::simulateKeyUpEvent(string key)
{
    ::pineapple::objects::Scene* s = Application::getCurrentScene();
    if(s!=NULL)
    {
        s->onKeyUp(key);
    }
}
