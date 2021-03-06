#include "SDL/SDL.h"
#include "SDL/SDL_opengl.h"
#include <vector>
#include <list>
#include "application.h"
#include "actor.h"
#include "scene.h"
#include "window.h"
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
    Window::setSize(width, height);
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
        (*i)->verifyCollisions();
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
    if(bgColor!=NULL)
    {
        glClearColor(bgColor->getRed(), bgColor->getGreen(), bgColor->getBlue(), bgColor->getAlpha());
        glClear(GL_COLOR_BUFFER_BIT);
    }

    if (views.size() == 0)
    {
        View* v = new View();
        addView(v);
    }
    for (unsigned int i = 0; i < views.size(); i++)
    {
        Drawing* d = new Drawing();
        View* v = views[i];
        v->set(bgColor);
        draw(d);
    }
}

void Scene::draw(Drawing* d){
    drawBackgrounds();
    drawActors(d);
}

bool compareActors(Actor*& a, Actor*& b)
{
    return a->getDepth() > b->getDepth();
}
//
//Draw this scene's actors
//
void Scene::drawActors(Drawing* d)
{
    actors.sort(compareActors);

    list<Actor*>::iterator i = actors.begin();
    while (i != actors.end())
    {
        if((*i)->isVisible()){
            glPushMatrix();
            (*i)->draw(d);
            glPopMatrix();
            d->drawColor(Color::WHITE);
        }
        i++;
    }
}

//
//Draw this scene's backgrounds
//
void Scene::drawBackgrounds()
{
    for (unsigned int i = 0; i < backgrounds.size(); i++)
    {
        if (backgrounds[i]->visible)
            backgrounds[i]->draw(this);
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

void Scene::addBackground(Background* bg)
{
    backgrounds.push_back(bg);
}

void Scene::onKeyDown(int key)
{
    if (key == Key::Escape)
        Application::exit();

    list<Actor*>::iterator i = actors.begin();
    while (i != actors.end())
    {
        (*i)->onKeyDown(key);
        i++;
    }
}

void Scene::onKeyUp(int key)
{
    list<Actor*>::iterator i = actors.begin();
    while (i != actors.end())
    {
        (*i)->onKeyUp(key);
        i++;
    }
}

void Scene::onKeyPressed(int key)
{
    list<Actor*>::iterator i = actors.begin();
    while (i != actors.end())
    {
        (*i)->onKeyPressed(key);
        i++;
    }
}
