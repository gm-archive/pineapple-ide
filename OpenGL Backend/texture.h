#ifndef TEXTURE_H
#define TEXTURE_H

#include "SDL/SDL_opengl.h"
#include <string>

namespace Pineapple {

class Texture
{
private:
    int width;
    int height;
    int originx;
    int originy;
    GLuint textureid;
public:
    Texture(const std::string file, int originx = 0, int originy = 0);
    ~Texture();

    int getWidth() { return width; }
    int getHeight() { return height; }
    int getOriginX() { return originx; }
    int getOriginY() { return originy; }

    void draw(float x, float y);
    void draw(float x, float y, float width, float height, float angle);
};

}

#endif
