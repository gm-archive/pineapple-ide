#ifndef ACTOR_H
#define ACTOR_H

#include "vector.h"
#include "texture.h"
#include "keyboard.h"
#include "drawing.h"

namespace Pineapple {

class Actor
{
private:
    Vector* motion;
    Vector* gravity;
    double friction;
protected:
    int texture;
    double angle;
    double width, height;
    double x, y;
    double depth;
    bool visible;

public:
    Actor(double x = 0, double y = 0, double depth = 0);
    virtual ~Actor();

    double getX() { return x; }
    double getY() { return y; }

    void setX(double x) { this->x = x; }
    void setY(double y) { this->y = y; }

    double getHSpeed() { return motion->getX(); }
    double getVSpeed() { return motion->getY(); }

    void setHSpeed(double x) { motion->setX(x); }
    void setVSpeed(double y) { motion->setY(y); }

    double getSpeed() { return motion->getSpeed(); }
    double getDirection() { return motion->getDirection(); }
    void setSpeed(double s) { motion->setSpeed(s); }
    void setDirection(double d) { motion->setDirection(d); }

    void setFriction(double f) { friction = f; }
    double getFriction() { return friction; }

    double getGravity() { return gravity->getSpeed(); }
    double getGravityDirection() { return gravity->getDirection(); }
    void setGravity(double g) { gravity->setSpeed(g); }
    void setGravity(double g, double d) { gravity->setSpeed(g); gravity->setDirection(d); }
    void setGravityDirection(double d) { gravity->setDirection(d); }

    double getDepth() { return depth; }
    void setDepth(double depth) { this->depth = depth; }

    void loop();

    enum Motion { MotionXY, MotionRV };
    void setMotionMode(Motion m);

    virtual void update() {}
    void move();
    virtual void draw(Pineapple::Drawing* d);

    virtual void onKeyDown(int key) {}
    virtual void onKeyUp(int key) {}
    virtual void onKeyPressed(int key) {}

    bool isVisible() { return visible; }
    void setVisible(bool visible) { this->visible = visible; }

    Texture* getTexture();

    virtual void verifyCollisions();

    virtual void handleCollision(Actor* other){}

    virtual Rectangle* getRectangle(){
        Texture* tex = getTexture();
        if(tex==NULL){ return NULL; }
        return new Rectangle(x, y, x+tex->getWidth(), y+tex->getHeight());
    }

};

}

#endif
