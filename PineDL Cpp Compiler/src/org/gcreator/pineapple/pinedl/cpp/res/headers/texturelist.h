#ifndef __PINEDL_TEXTURELIST_H__
#define __PINEDL_TEXTURELIST_H__

#include "texture.h"
#include <vector>

namespace Pineapple
{
    class TextureList
    {
    protected:
        static Texture* Load_Compressed_Texture(FILE*, unsigned int, unsigned int);
        static Texture* Load_Texture(char*, unsigned int);
        static void Load_Textures(unsigned int* ids, unsigned int n);
        static void load();
        struct ImageData
        {
            unsigned long long size;
            unsigned long long decompressed_size;
            Texture* tex;
        };
        static std::vector<ImageData*> images;
        static long archive_size;
        static long archive_data_start;
        static unsigned int* START_IMAGES;
        static unsigned int N_START_IMAGES;
    public:
        static void init();
        static Texture* Get_Texture(unsigned int);
        #include "texturelistdefined.h"
    };
}


#endif
