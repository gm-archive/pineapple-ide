#ifndef ACTOR_H
#define ACTOR_H

#include "vector.h"
#include "texture.h"
#include "keyboard.h"
#include <iostream>

namespace Pineapple {

class Actor
{
    Vector* motion;
    Vector* gravity;
    float friction;
protected:
    int texture;
    float angle;
    float width, height;
    float x, y;
    float depth;

public:
    Actor(float x = 0, float y = 0, float depth = 0);
    virtual ~Actor();

    float getX() { return x; }
    float getY() { return y; }

    void setX(float x) { this->x = x; }
    void setY(float y) { this->y = y; }

    float getHSpeed() { return motion->getX(); }
    float getVSpeed() { return motion->getY(); }

    void setHSpeed(float x) { motion->setX(x); }
    void setVSpeed(float y) { motion->setY(y); }

    float getSpeed() { return motion->getSpeed(); }
    float getDirection() { return motion->getDirection(); }
    void setSpeed(float s) { motion->setSpeed(s); }
    void setDirection(float d) { motion->setDirection(d); }

    void setFriction(float f) { friction = f; }
    float getFriction() { return friction; }

    float getGravity() { return gravity->getSpeed(); }
    float getGravityDirection() { return gravity->getDirection(); }
    void setGravity(float g) { gravity->setSpeed(g); }
    void setGravity(float g, float d) { gravity->setSpeed(g); gravity->setDirection(d); }
    void setGravityDirection(float d) { gravity->setDirection(d); }

    float getDepth() { return depth; }
    void setDepth(float depth) { this->depth = depth; }

    void loop();

    enum Motion { MotionXY, MotionRV };
    void setMotionMode(Motion m);

    virtual void update() {}
    void move();
    virtual void draw();

    virtual void onKeyDown(Key key) {}
    virtual void onKeyUp(Key key) {}
    virtual void onKeyPressed(Key key) {}
};

}

#endif
