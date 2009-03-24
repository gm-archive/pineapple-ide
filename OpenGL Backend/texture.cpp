#include "SDL/SDL.h"
#include "SDL/SDL_image.h"
#include "SDL/SDL_opengl.h"
#include "texture.h"
#include "exceptions.h"


using namespace Pineapple;

SDL_Surface* load_image( std::string filename );

Texture::Texture(const std::string file, int originx, int originy)
{
    //load the image
    SDL_Surface* surface = IMG_Load(file.c_str());
    if (surface == NULL)
        throw new IOException("Could not load image");
    init(surface);
}

Texture::Texture(char* start, int size, int originx, int originy)
{
    SDL_RWops* rw = SDL_RWFromMem(start, size);

    //load the image
    SDL_Surface* surface = IMG_Load_RW(rw, 1);
    if (surface == NULL)
        throw new IOException("Could not load image");
    init(surface);
}

void Texture::init(SDL_Surface* surface) {
    GLuint texture;

    //set up a gl texture
    glGenTextures(1, &texture);
    glBindTexture(GL_TEXTURE_2D, texture);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
    // Set the texture's stretching properties
    GLenum texture_format;

        glTexParameteri( GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR );
        glTexParameteri( GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR );
       GLint nOfColors = surface->format->BytesPerPixel;
        if (nOfColors == 4)     // contains an alpha channel
        {
                if (surface->format->Rmask == 0x000000ff)
                        texture_format = GL_RGBA;
                else
                        texture_format = GL_BGRA;
        } else if (nOfColors == 3)     // no alpha channel
        {
                if (surface->format->Rmask == 0x000000ff)
                        texture_format = GL_RGB;
                else
                        texture_format = GL_BGR;
        } else {
                // warning: the image is not truecolor..  this will probably break
                // this error should not go unhandled

                // Let's make a guess!
                texture_format = GL_RGB;
        }

        glTexImage2D( GL_TEXTURE_2D, 0, nOfColors, surface->w, surface->h, 0,
                      texture_format, GL_UNSIGNED_BYTE, surface->pixels );

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
