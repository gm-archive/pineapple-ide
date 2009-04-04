#include "application.h"
#include "vector.h"
#include "actor.h"
#include "texturelist.h"
using namespace Pineapple;

//
//Set actor defaults
//
Actor::Actor(float x, float y, float depth)
{
    this->x = x;
    this->y = y;
    this->depth = depth;
    this->texture = -1;

    angle = 0;
    width = height = 1;

    motion = new VectorXY(0, 0);
    gravity = new VectorRV(270, 0);
    friction = 0;
}

//
//Free actor
//
Actor::~Actor()
{
    delete motion;
    delete gravity;
}

//
//Loop outside the room
//
void Actor::loop()
{
    if (texture < 0)
        return;
    Texture* tex = ::Game::TextureList::Get_Texture(texture);
    if (x > Application::getScene()->getWidth() + tex->getOriginX())
        x = -tex->getOriginX();
    if (x < -tex->getOriginX())
        x = Application::getScene()->getWidth() + tex->getOriginX();
    if (y > Application::getScene()->getHeight() + tex->getOriginY())
        y = -tex->getOriginY();
    if (y < -tex->getOriginY())
        y = Application::getScene()->getHeight() + tex->getOriginY();
}

//
//switch between VectorXY and VectorRV
//
void Actor::setMotionMode(Motion m)
{
    Vector* motion = this->motion;
    if (m == MotionXY)
        this->motion = new VectorXY(motion->getX(), motion->getY());
    else
        this->motion = new VectorRV(motion->getDirection(), motion->getSpeed());
    delete motion;
}

//
//Actor motion
//Updates location based on local vars
//
void Actor::move()
{
    if (friction != 0)
        motion->setSpeed(sign(motion->getSpeed()) * (abs(motion->getSpeed()) - friction));
    if (getGravity() != 0)
        motion->add(gravity);

    x += motion->getX();
    y += motion->getY();
}

//
//Draws the actor
//
void Actor::draw()
{
    if (texture < 0)
        return;
    Texture* tex = ::Game::TextureList::Get_Texture(texture);
    tex->draw(x, y, width, height, angle);
}
