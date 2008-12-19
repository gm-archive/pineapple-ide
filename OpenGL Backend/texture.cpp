#include "SDL/SDL.h"
#include "SDL/SDL_image.h"
#include "SDL/SDL_opengl.h"
#include "texture.h"

using namespace Pineapple;

Texture::Texture(const std::string file, int originx, int originy)
{
    //load the image
    SDL_Surface* surface = IMG_Load(file.c_str());
    if (surface == NULL)
        throw "Could not load image";
    GLuint texture;

    //set up a gl texture
    glGenTextures(1, &texture);
    glBindTexture(GL_TEXTURE_2D, texture);
    glPixelStorei(GL_UNPACK_ALIGNMENT, 4);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);

    //put the image in the texture with correct alpha format
    SDL_PixelFormat *format = surface->format;
    if (format->Amask)
        gluBuild2DMipmaps(GL_TEXTURE_2D, 4, surface->w, surface->h, GL_RGBA, GL_UNSIGNED_BYTE, surface->pixels);
    else
        gluBuild2DMipmaps(GL_TEXTURE_2D, 3, surface->w, surface->h, GL_RGB, GL_UNSIGNED_BYTE, surface->pixels);

    //setup the sprite class' stuff
    this->textureid = texture;
    this->width = surface->w;
    this->height = surface->h;
    this->originx = originx;
    this->originy = originy;

    //free the image
    SDL_FreeSurface(surface);
}

Texture::~Texture()
{
    glDeleteTextures(1, &textureid);
}

void Texture::draw(float x, float y)
{
    //use this texture
    glBindTexture(GL_TEXTURE_2D, this->textureid);

    //enable alpha blending
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

    //translate/rotate, then draw a quad with the texture
    glTranslatef(x, y, 0);
    glBegin(GL_QUADS);
        glTexCoord2i(0, 0);
        glVertex3f(-this->originx, -this->originy, 0);

        glTexCoord2i(0, 1);
        glVertex3f(-this->originx, this->height - this->originy, 0);

        glTexCoord2i(1, 1);
        glVertex3f(this->width - this->originx, this->height - this->originy, 0);

        glTexCoord2i(1, 0);
        glVertex3f(this->width - this->originx, -this->originy, 0);
    glEnd();
    glLoadIdentity();
}

void Texture::draw(float x, float y, float width, float height, float angle)
{
    //use this texture
    glBindTexture(GL_TEXTURE_2D, this->textureid);

    //enable alpha blending
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

    //translate/rotate, then draw a quad with the texture
    glTranslatef(x, y, 0);
    glRotatef(-angle, 0, 0, 1);
    glBegin(GL_QUADS);
        glTexCoord2i(0, 0);
        glVertex3f(-this->originx * width, -this->originy * height, 0);

        glTexCoord2i(0, 1);
        glVertex3f(-this->originx * width, (this->height - this->originy) * height, 0);

        glTexCoord2i(1, 1);
        glVertex3f((this->width - this->originx) * width, (this->height - this->originy) * height, 0);

        glTexCoord2i(1, 0);
        glVertex3f((this->width - this->originx) * width, -this->originy * height, 0);
    glEnd();
    glLoadIdentity();
}
