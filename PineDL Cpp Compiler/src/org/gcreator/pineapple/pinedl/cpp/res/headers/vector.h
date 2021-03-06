#ifndef _PINEDL_VECTOR_H
#define _PINEDL_VECTOR_H

#include "pamath.h"
#include "core.h"

namespace Pineapple {

class Vector : public Object
{
public:
    virtual void setX(float x) = 0;
    virtual void setY(float y) = 0;

    virtual float getX() = 0;
    virtual float getY() = 0;

    virtual void setDirection(float d) = 0;
    virtual void setSpeed(float s) = 0;

    virtual float getDirection() = 0;
    virtual float getSpeed() = 0;

    virtual void add(Vector* v) = 0;
};

class VectorXY : public Vector
{
    float x;
    float y;
    float direction;
public:
    VectorXY(float x, float y) { this->x = x; this->y = y; direction = 0; }

    void setX(float x) { this->x = x; }
    void setY(float y) { this->y = y; }

    float getX() { return x; }
    float getY() { return y; }

    void setDirection(float d)
    {
        x = cos(d * Pineapple::Math::pi/180) * (180/Pineapple::Math::pi) * getSpeed();
        y = -sin(d * Pineapple::Math::pi/180) * (180/Pineapple::Math::pi) * getSpeed();
        direction = d;
    }

    void setSpeed(float s)
    {
        x = cos(getDirection() * Pineapple::Math::pi/180) * s;
        y = -sin(getDirection() * Pineapple::Math::pi/180) * s;
    }

    float getDirection()
    {
        return (x == 0 && y == 0) ? direction : (direction = atan2(x, y) * 180/Pineapple::Math::pi);
    }
    float getSpeed()
    {
        return sqrt(x * x + y * y);
    }

    void add(Vector* v)
    {
        x += v->getX();
        y += v->getY();
    }
};

class VectorRV : public Vector
{
    float direction;
    float speed;
public:
    VectorRV(float d, float s) { direction = d; speed = s; }

    void setDirection(float d) { direction = d; }
    void setSpeed(float s) { speed = s; }

    float getDirection() { return direction; }
    float getSpeed() { return speed; }

    float getX() { return cos(direction * Pineapple::Math::pi/180) * speed; }
    float getY() { return -sin(direction * Pineapple::Math::pi/180) * speed; }

    void setX(float x)
    {
        direction = atan2(x, getY()) * 180/Pineapple::Math::pi;
        speed = sqrt(x * x + getY() * getY());
    }

    void setY(float y)
    {
        direction = atan2(getX(), y) * 180/Pineapple::Math::pi;
        speed = sqrt(getX() * getX() + y * y);
    }

    void add(Vector* v)
    {
        setX(getX() + v->getX());
        setY(getY() + v->getY());
    }
};

}

#endif
