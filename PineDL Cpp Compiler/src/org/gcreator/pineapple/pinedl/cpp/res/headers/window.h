#ifndef WINDOW_H
#define WINDOW_H

#include <string>
#include <vector>
#include "keycodes.h"

namespace Pineapple {

class Window
{
    static int width;
    static int height;
    static std::string caption;
    static bool fullscreen;
    static bool resizable;
    static std::vector<int> keys_pressed;

    static inline void update();
public:
    static void setSize(int width, int height, bool fullscreen = false);
    static void setFullscreen(bool fullscreen);
    static void setCaption(const std::string title);
    static void setResizable(bool resizable);

    static int getWidth() { return width; }
    static int getHeight() { return height; }

    static void run();
};

}

#endif
