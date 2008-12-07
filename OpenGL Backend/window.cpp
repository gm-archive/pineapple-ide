#include "SDL/SDL.h"
#include "SDL/SDL_opengl.h"
#include "window.h"
#include "timer.h"
#include "scene.h"
#include "application.h"

using namespace Pineapple;

int Window::width;
int Window::height;
bool Window::fullscreen = false;
bool Window::resizable = false;
std::string Window::caption;

//
//save window size and reset the window
//
void Window::setSize(int width, int height, bool fullscreen)
{
    Window::width = width;
    Window::height = height;
    Window::fullscreen = fullscreen;
    update();
}

//
//set fullscreen flag and reset the window
//
void Window::setFullscreen(bool fullscreen)
{
    Window::fullscreen = fullscreen;
    update();
}

//
//set the caption and update the window
//
void Window::setCaption(const std::string title)
{
    SDL_WM_SetCaption(title.c_str(), NULL);
}

//
//set the resizable flag and reset the window
//
void Window::setResizable(bool resizable)
{
    Window::resizable = resizable;
    update();
}

//
//update the window with the current flags
//
inline void Window::update()
{
    Uint32 flags = SDL_OPENGL;
    if (fullscreen)
        flags |= SDL_FULLSCREEN;
    if (resizable)
        flags |= SDL_RESIZABLE;

    SDL_SetVideoMode(width, height, 32, flags);
    glEnable(GL_TEXTURE_2D);
}

//
//main program loop
//
void Window::run()
{
    Timer t;
    SDL_Event event;
    Scene *s;

    while (Application::isRunning())
    {
        t.start();
        s = Application::getScene();

        //handle events
        while (SDL_PollEvent(&event))
        {
            switch (event.type)
            {
                case SDL_QUIT:
                    Application::exit();
                    break;

                case SDL_VIDEORESIZE:
                    setSize(event.resize.w, event.resize.h, fullscreen);
                    break;

                case SDL_KEYDOWN:
                    if (s != NULL)
                        s->onKeyDown((Key)event.key.keysym.sym);
                    break;

                case SDL_KEYUP:
                    if (s != NULL)
                        s->onKeyUp((Key)event.key.keysym.sym);
                    break;
            }
        }

        //update input
        Keyboard::update();

        //update scene
        if (s != NULL)
        {
            s->update();
            s->draw();
        }

        //show the new frame
        SDL_GL_SwapBuffers();

        //wait for the frame to finish
        if (t.get_ticks() < 1000 / Application::getSpeed())
            SDL_Delay(1000 / Application::getSpeed() - t.get_ticks());
    }
}
