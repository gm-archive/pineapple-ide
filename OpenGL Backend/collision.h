#ifndef _COLLISION_H_INCLUDED
#define _COLLISION_H_INCLUDED

class CollisionManager
{
    public:
        static bool rectangleIntersects(Rectangle* r1, Rectangle* r2)
        {
            Point* r1p = r1->getTopLeftPoint();
            double r1x = r1p->getX();
            double r1y = r1p->getY();
            double r1width = r1->getWidth();
            double r1height = r1->getHeight();
            Point* r2p = r2->getTopLeftPoint();
            double r2x = r2p->getX();
            double r2y = r2p->getY();
            double r2width = r2->getWidth();
            double r2height = r2->getHeight();
            if(r1x>=r2x+r2width) return false;
            if(r1x+r1width<=r2x) return false;
            if(r1y>=r2y+r2height) return false;
            if(r1y+r1height<=r2y) return false;
            return true;
        }

	static bool rectangleIsTangent(Rectangle* r1, Rectangle* r2)
        {
            Point* r1p = r1->getTopLeftPoint();
            double r1x = r1p->getX();
            double r1y = r1p->getY();
            double r1width = r1->getWidth();
            double r1height = r1->getHeight();
            Point* r2p = r2->getTopLeftPoint();
            double r2x = r2p->getX();
            double r2y = r2p->getY();
            double r2width = r2->getWidth();
            double r2height = r2->getHeight();
            if(r1x==r2x+r2width) return false;
            if(r1x+r1width==r2x) return false;
            if(r1y==r2y+r2height) return false;
            if(r1y+r1height==r2y) return false;
            return true;
        }
};

#endif
