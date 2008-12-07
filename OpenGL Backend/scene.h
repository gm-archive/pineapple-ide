#ifndef SCENE_H
#define SCENE_H

#include "actor.h"
#include "view.h"
#include "keyboard.h"
#include <vector>

namespace Pineapple {

class Scene
{
protected:
    std::vector<Actor*> actors;
    std::vector<View*> views;

    int width;
    int height;

    virtual void drawActors();
public:
    Scene();
    virtual ~Scene();

    virtual void update();
    virtual void draw();

    virtual void addActor(Actor* actor);
    virtual void addView(View* view);

    virtual void onKeyDown(Key key);
    virtual void onKeyUp(Key key);

    int getWidth() { return width; }
    int getHeight() { return height; }
};

}

#endif
