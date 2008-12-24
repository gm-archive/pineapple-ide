#include "SDL/SDL.h"
#include "SDL/SDL_opengl.h"
#include <vector>
#include "application.h"
#include "actor.h"
#include "scene.h"
#include "scene.h"
using namespace Pineapple;

//
//Scene base constructor
//
Scene::Scene(int width, int height)
{
    glClearColor(0, 0, 0, 1);
    this->width = width;
    this->height = height;
    bgColor = Color::BLACK;
}

//
//Scene base destructor, frees the actors and views used
//
Scene::~Scene()
{
    for (unsigned int i = 0; i < actors.size(); i++)
    {
        delete actors[i];
    }
    for (unsigned int i = 0; i < views.size(); i++)
    {
        delete views[i];
    }
}

//
//Update the scene
//For each actor, update and then move
//
void Scene::update()
{
    for (unsigned int i = 0; i < actors.size(); i++)
    {
        actors[i]->update();
        actors[i]->move();
    }
}

//
//Clear the screen, set the view(s) and draw the actors
//
void Scene::draw()
{
    glClear(GL_COLOR_BUFFER_BIT);

    if (views.size() == 0)
    {
        static View* v = new View();
        v->set(bgColor);
        drawActors();
    }
    else
    {
        for (unsigned int i = 0; i < views.size(); i++)
        {
            View* v = views[i];
            v->set(bgColor);
            drawActors();
        }
    }
}

//
//Draw this scene's actors
//
void Scene::drawActors()
{
    for (unsigned int i = 0; i < actors.size(); i++)
    {
        actors[i]->draw();
    }
}

void Scene::addActor(Actor* actor)
{
    actors.push_back(actor);
}

void Scene::addView(View* view)
{
    views.push_back(view);
}

void Scene::onKeyDown(Key key)
{
    if (key == KeyEscape)
        Application::exit();

    for (unsigned int i = 0; i < actors.size(); i++)
    {
        actors[i]->onKeyDown(key);
    }
}

void Scene::onKeyUp(Key key)
{
    for (unsigned int i = 0; i < actors.size(); i++)
    {
        actors[i]->onKeyUp(key);
    }
}
