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

    virtual void drawActors(Drawing& d);
    virtual void drawBackgrounds();
public:
    Scene(int width, int height);
    virtual ~Scene();

    Color* getBackground(){ return bgColor; }
    void setBackground(Color* bgColor){ this->bgColor = bgColor; }

    virtual void update();
    virtual void draw();

    virtual void addActor(Actor* actor);
    virtual void addView(View* view);
    virtual void addBackground(Background* bg);

    virtual void onKeyDown(Key key);
    virtual void onKeyUp(Key key);
    virtual void onKeyPressed(Key key);

    int getWidth() { return width; }
    int getHeight() { return height; }
};

}

#endif
