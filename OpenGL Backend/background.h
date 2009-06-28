#ifndef _BACKGROUND_H_INCLUDED
#define _BACKGROUND_H_INCLUDED

#include "core.h"

namespace Pineapple {
class Scene;
class Background : public Object
{
  public:
    bool visible;
    int texture;
    bool hrepeat;
    bool vrepeat;
    int x, y;
    virtual void draw(Scene* s);
    Background(int texture, int x = 0, int y = 0, bool visible = true, bool hrepeat = true, bool vrepeat = true);
};

}




#endif // BACKGROUND_H_INCLUDED
