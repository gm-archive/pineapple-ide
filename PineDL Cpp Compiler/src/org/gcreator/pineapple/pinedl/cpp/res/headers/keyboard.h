#ifndef KEYBOARD_H
#define KEYBOARD_H

#define WINTRANSPARENT TRANSPARENT
#undef TRANSPARENT
#define TRANSPARENT _SDL_TRANSPARENT
#include "SDL/SDL.h"
#undef TRANSPARENT
#include "keycodes.h"

namespace Pineapple {

class Keyboard
{
    static Uint8* keys;
public:
    static void update() { keys = SDL_GetKeyState(NULL); }
    static bool isKeyDown(Key key) { return keys[key]; }
};

}

#endif
