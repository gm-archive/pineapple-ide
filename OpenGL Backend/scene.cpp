#include "SDL/SDL.h"
#include "SDL/SDL_opengl.h"
#include <vector>
#include <list>
#include "application.h"
#include "actor.h"
#include "scene.h"
#include "scene.h"

using namespace Pineapple;
using namespace std;
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
    list<Actor*>::iterator i = actors.begin();
    while (i != actors.end())
    {
        delete *i;
        i++;
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
    list<Actor*>::iterator i = actors.begin();
    while (i != actors.end())
    {
        (*i)->update();
        (*i)->move();
        i++;
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

bool compareActors(Actor*& a, Actor*& b)
{
    return a->getDepth() > b->getDepth();
}
//
//Draw this scene's actors
//
void Scene::drawActors()
{
    actors.sort(compareActors);

    list<Actor*>::iterator i = actors.begin();
    while (i != actors.end())
    {
        (*i)->draw();
        i++;
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

    list<Actor*>::iterator i = actors.begin();
    while (i != actors.end())
    {
        (*i)->onKeyDown(key);
        i++;
    }
}

void Scene::onKeyUp(Key key)
{
    list<Actor*>::iterator i = actors.begin();
    while (i != actors.end())
    {
        (*i)->onKeyUp(key);
        i++;
    }
}
