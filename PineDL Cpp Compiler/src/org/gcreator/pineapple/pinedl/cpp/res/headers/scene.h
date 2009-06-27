#ifndef SCENE_H
#define SCENE_H

#include "actor.h"
#include "view.h"
#include "background.h"
#include "keyboard.h"
#include <vector>
#include <list>

namespace Pineapple {

class Scene
{
protected:
    std::list<Actor*> actors;
    std::vector<View*> views;
    std::vector<Background*> backgrounds;
    Color* bgColor;

    int width;
    int height;

    virtual void drawActors(Drawing* d);
    virtual void drawBackgrounds();

    friend class Actor;
public:
    Scene(int width, int height);
    virtual ~Scene();

    Color* getBackground(){ return bgColor; }
    void setBackground(Color* bgColor){ this->bgColor = bgColor; }

    virtual void update();
    void draw();
    virtual void draw(Drawing* d);

    virtual void addActor(Actor* actor);
    virtual void addView(View* view);
    virtual void addBackground(Background* bg);

    virtual void onKeyDown(int key);
    virtual void onKeyUp(int key);
    virtual void onKeyPressed(int key);

    int getWidth() { return width; }
    int getHeight() { return height; }
};

}

#endif
