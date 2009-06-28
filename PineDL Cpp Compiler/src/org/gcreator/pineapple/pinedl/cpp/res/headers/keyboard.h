#ifndef _KEYBOARD_H
#define _KEYBOARD_H

#define _WINTRANSPARENT TRANSPARENT
#undef TRANSPARENT
#define TRANSPARENT _SDL_TRANSPARENT
#include "SDL/SDL.h"
#undef TRANSPARENT
#include "keycodes.h"
#include "core.h"

namespace Pineapple {

class Keyboard : public Object
{
    static Uint8* keys;
public:
    static void update() { keys = SDL_GetKeyState(NULL); }
    static bool isKeyDown(int key) { return keys[key]; }
};

}

#endif
