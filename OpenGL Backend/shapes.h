#ifndef _SHAPES_H_INCLUDED
#define _SHAPES_H_INCLUDED

#include "exceptions.h"
#include "pamath.h"
#include "core.h"

namespace Pineapple
{
    class Point : public Object
    {
        private:
            double x;
            double y;
        public:
            Point(){ x = 0.0; y = 0.0; }
            Point(double x, double y){
                this->x = x;
                this->y = y;
            }
            Point(Point* p){
                this->x = p->x;
            }
            double getX(){ return x; }
            double getY(){ return y; }
    };

    class Rectangle : public Object
    {
        public:
            Point* p1;
            Point* p2;
            Rectangle(){
                p1 = new Point();
                p2 = new Point();
            }
            Rectangle(Point* p1, Point* p2){
                this->p1 = p1;
                this->p2 = p2;
            }
            Rectangle(double x1, double y1, double x2, double y2){
                p1 = new Point(x1, y1);
                p2 = new Point(x2, y2);
            }
            Rectangle(Rectangle* r){
                this->p1 = r->p1;
                this->p2 = r->p2;
            }

            Point* getTopLeftPoint(){
                return p1;
            }
            Point* getBottomRightPoint(){
                return p2;
            }
            double getWidth(){
                return Math::abs(p2->getX() - p1->getX());
            }
            double getHeight(){
                return Math::abs(p2->getY() - p1->getY());
            }
    };
}

#endif
