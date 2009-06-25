#include "SDL/SDL.h"
#include "SDL/SDL_opengl.h"
#include "window.h"
#include "timer.h"
#include "scene.h"
#include "application.h"
#include "texturelist.h"

using namespace Pineapple;

int Window::width;
int Window::height;
bool Window::fullscreen = false;
bool Window::resizable = false;
std::string Window::caption;
std::vector<int> Window::keys_pressed;

//
//save window size and reset the window
//
void Window::setSize(int width, int height, bool fullscreen)
{
    Window::width = width;
    Window::height = height;
    Window::fullscreen = fullscreen;
    Window::update();
}

//
//set fullscreen flag and reset the window
//
void Window::setFullscreen(bool fullscreen)
{
    Window::fullscreen = fullscreen;
    Window::update();
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
    Window::update();
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
    SDL_GL_SetAttribute( SDL_GL_DOUBLEBUFFER, 1 );
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
                        s->onKeyDown(event.key.keysym.sym);
                    keys_pressed.push_back(event.key.keysym.sym);
                    break;

                case SDL_KEYUP:
                    if (s != NULL)
                        s->onKeyUp(event.key.keysym.sym);
                    for (unsigned int i = 0; i < keys_pressed.size(); i++)
                    {
                        if (keys_pressed[i] == event.key.keysym.sym) {
                            keys_pressed.erase(keys_pressed.begin()+i);
                            // Do not break loop; search for duplicate key entries.
                        }
                    }
                    break;
            }
        }

        for (unsigned int i = 0; i < keys_pressed.size() && s != NULL; i++)
        {
            s->onKeyPressed(keys_pressed[i]);
        }
        //update input
        Keyboard::update();

        //update scene
        if (Application::isPlaying() && s != NULL)
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
