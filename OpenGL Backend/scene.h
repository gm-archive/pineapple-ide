#ifndef SCENE_H
#define SCENE_H

#include "actor.h"
#include "view.h"
#include "keyboard.h"
#include <vector>
#include <list>

namespace Pineapple {

class Scene
{
protected:
    std::list<Actor*> actors;
    std::vector<View*> views;
    Color* bgColor;

    int width;
    int height;

    virtual void drawActors();
public:
    Scene(int width, int height);
    virtual ~Scene();

    Color* getBackground(){ return bgColor; }
    void setBackground(Color* bgColor){ this->bgColor = bgColor; }

    virtual void update();
    virtual void draw();

    void addActor(Actor* actor);
    void addView(View* view);

    virtual void onKeyDown(Key key);
    virtual void onKeyUp(Key key);

    int getWidth() { return width; }
    int getHeight() { return height; }
};

}

#endif
