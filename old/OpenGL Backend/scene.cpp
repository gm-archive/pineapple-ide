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

pineapple::objects::Scene::Scene(int width, int height)
{
    views = new ::std::vector<View*>();
    this->width = width;
    this->height = height;
    actors = new ::std::vector<Actor*>();
}

void pineapple::objects::Scene::create()
{
    for(int i = 0; i < actors->size(); i++)
    {
        actors->at(i)->create();
    }
}

void pineapple::objects::Scene::destroy()
{
    for(int i = 0; i < actors->size(); i++)
    {
        if(!actors->at(i)->isPersistent())
            actors->at(i)->destroy();
    }
}

void pineapple::objects::Scene::retrievePersistentActors(pineapple::objects::Scene* other) {
    if(other==NULL) return;
    
    for(int i = 0; i < other->actors->size(); i++) {
        Actor* a = other->actors->at(i);
        if(a->isPersistent()) {
            actors->push_back(a);
            ::std::vector<Actor*>::iterator it = other->actors->begin()+i;
            other->actors->erase(it);
        }
    }
}

void pineapple::objects::Scene::draw()
{
    if(views->size()==0)
    {
        View* v = new View(); //Default view
        v->GLSetup();
        drawView(v);
    }
    else{
        for(int i = 0; i < views->size(); i++)
        {
            View* v = views->at(i);
            v->GLSetup();
            drawView(v);
        }
    }
}

void pineapple::objects::Scene::loop()
{
    for(int i = 0; i < actors->size(); i++)
    {
        Actor* a = actors->at(i);
        a->loop();
    }
}

void pineapple::objects::Scene::drawView(View* v)
{
    for(int i = 0; i < actors->size(); i++)
    {
        Actor* a = actors->at(i);
        a->draw(v);
    }
}

int pineapple::objects::Scene::getWidth()
{
    return width;
}

int pineapple::objects::Scene::getHeight()
{
    return height;
}

void pineapple::objects::Scene::setWidth(int width)
{
    this->width = width;
}

void pineapple::objects::Scene::setHeight(int height)
{
    this->height = height;
}

void pineapple::objects::Scene::addView(View* v)
{
    views->push_back(v);
}

void pineapple::objects::Scene::addActor(Actor* a)
{
    actors->push_back(a);
}

void pineapple::objects::Scene::onKeyDown(string key)
{
    for(int i = 0; i < actors->size(); i++)
    {
        Actor* a = actors->at(i);
        a->onKeyDown(key);
    }
}

void pineapple::objects::Scene::onKeyUp(string key)
{
    for(int i = 0; i < actors->size(); i++)
    {
        Actor* a = actors->at(i);
        a->onKeyUp(key);
    }
}
