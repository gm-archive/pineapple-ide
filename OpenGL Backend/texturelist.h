#ifndef __PINEDL_TEXTURELIST_H__
#define __PINEDL_TEXTURELIST_H__

using namespace Pineapple;

namespace Game {
	class TextureList {
	    public:
		static void init();
		static Texture* Get_Texture(int);
	};
}

#endif
