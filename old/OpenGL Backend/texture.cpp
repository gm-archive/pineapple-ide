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
#include "SDL.h"
#include "SDL/SDL_opengl.h"
#include "SDL/SDL_image.h"
#include "GL/glu.h"

int powerOfTwo(int input)
{
	int value = 1;
	while (value < input) value <<= 1;
	return value;
}


pineapple::objects::Texture::Texture(string file)
{
    SDL_Surface *surface = IMG_Load(file.c_str());
    if(surface==NULL){
        printf("Could not load.\n");
        ::pineapple::std::Application::kill(1);
    }
    
    glPixelStorei(GL_UNPACK_ALIGNMENT, 4);
    glGenTextures(1, &textureid);
    glBindTexture(GL_TEXTURE_2D, textureid);
    SDL_PixelFormat *format = surface->format;
    
    int p2w = powerOfTwo(surface->w);
    int p2h = powerOfTwo(surface->h);
    
    Uint32 saved_flags;
    Uint8  saved_alpha;
    
    saved_flags = surface->flags&(SDL_SRCALPHA|SDL_RLEACCELOK);
    saved_alpha = surface->format->alpha;
    if ((saved_flags & SDL_SRCALPHA) == SDL_SRCALPHA)
        SDL_SetAlpha(surface, 0, 0);

    
    SDL_Surface* image = SDL_CreateRGBSurface(SDL_SWSURFACE, p2w, p2h, 32,
        0x000000FF, 0x0000FF00, 0x00FF0000, 0xFF000000);
    
    SDL_Rect area;
    area.x = 0;
    area.y = 0;
    area.w = surface->w;
    area.h = surface->h;
    SDL_BlitSurface(surface, &area, image, &area);
    
    gluBuild2DMipmaps(GL_TEXTURE_2D, 4, p2w, p2h, GL_RGBA, GL_UNSIGNED_BYTE, image->pixels);
    
    width = (float) surface->w;
    height = (float) surface->h;
    
    SDL_FreeSurface(image);
    SDL_FreeSurface(surface);
}

pineapple::objects::Texture::~Texture()
{
    glDeleteTextures(1, &textureid);
}

int pineapple::objects::Texture::getWidth()
{
    return width;
}

int pineapple::objects::Texture::getHeight()
{
    return height;
}

void pineapple::objects::Texture::GLDraw(float x, float y)
{
    glBindTexture(GL_TEXTURE_2D, textureid);
    
    glTranslatef(x, y, 0);
    
    glBegin(GL_QUADS);
        glTexCoord2i(0, 0);
        glVertex3f(0, 0, 0);

        glTexCoord2i(0, 1);
        glVertex3f(0, getHeight(), 0);

        glTexCoord2i(1, 1);
        glVertex3f(getWidth(), getHeight(), 0);

        glTexCoord2i(1, 0);
        glVertex3f(getWidth(), 0, 0);
    glEnd();
    glLoadIdentity();
}
