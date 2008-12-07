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

pineapple::objects::Actor::Actor()
{
    x = 0;
    y = 0;
    t = NULL;
    visible = false;
    persistent = false;
    hspeed = 0.0f;
    vspeed = 0.0f;
    gravity = 0.0f;
    gravity_direction = 270.0f;
}

void pineapple::objects::Actor::draw(View* view)
{
    if(isVisible()&&t!=NULL)
    {
        if(view==NULL)
            t->GLDraw(getX(), getY());
        else
            t->GLDraw(getX()-view->getSourceX(), getY()-view->getSourceY());
    }
}

void pineapple::objects::Actor::create() {
    
}

void pineapple::objects::Actor::destroy() {
    
}

void pineapple::objects::Actor::loop()
{
    x += hspeed;
    y += vspeed;
    float dirRadians = ::pineapple::std::Math::deg2rad(gravity_direction);
    hspeed += ::pineapple::std::Math::cos(dirRadians) * gravity;
    vspeed -= ::pineapple::std::Math::sin(dirRadians) * gravity;
}

bool pineapple::objects::Actor::isVisible()
{
    return visible;
}

bool pineapple::objects::Actor::isPersistent()
{
    return persistent;
}

float pineapple::objects::Actor::getX()
{
    return x;
}

float pineapple::objects::Actor::getY()
{
    return y;
}

float pineapple::objects::Actor::getHorizontalSpeed()
{
    return hspeed;
}

float pineapple::objects::Actor::getVerticalSpeed()
{
    return vspeed;
}

float pineapple::objects::Actor::getGravity()
{
    return gravity;
}

float pineapple::objects::Actor::getGravityDirection()
{
    return gravity_direction;
}

pineapple::objects::Texture* pineapple::objects::Actor::getTexture()
{
    return t;
}

void pineapple::objects::Actor::setTexture(Texture* t)
{
    this->t = t;
}

void pineapple::objects::Actor::setVisible(bool visible)
{
    this->visible = visible;
}

void pineapple::objects::Actor::setX(float x){
    this->x = x;
}

void pineapple::objects::Actor::setY(float y){
    this->y = y;
}

void pineapple::objects::Actor::setHorizontalSpeed(float speed){
    hspeed = speed;
}

void pineapple::objects::Actor::setVerticalSpeed(float speed){
    vspeed = speed;
}

void pineapple::objects::Actor::setPersistent(bool persistent)
{
    this->persistent = persistent;
}

void pineapple::objects::Actor::setGravity(float gravity){
    this->gravity = gravity;
}

void pineapple::objects::Actor::setGravityDirection(float gravity_direction){
    this->gravity_direction = gravity_direction;
}

void pineapple::objects::Actor::onKeyDown(string key){

}

void pineapple::objects::Actor::onKeyUp(string key){

}
