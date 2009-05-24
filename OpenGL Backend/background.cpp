#include "scene.h"
#include "background.h"
#include "texturelist.h"
using namespace Pineapple;


Background::Background(int texture, int x, int y, bool visible, bool hrepeat, bool vrepeat)
{
    this->texture = texture;
    this->x = x;
    this->y = y;
    this->visible = visible;
    this->hrepeat = hrepeat;
    this->vrepeat = vrepeat;
    this->visible = visible;
}

void Background::draw(Scene* s)
{
    if (texture < 0)
        return;
    Texture* tex = Game::TextureList::Get_Texture(texture);
    for (int yy = 0; y + (tex->getHeight() * yy) < s->getHeight(); yy++) {
        for (int xx = 0; x + (tex->getWidth() * xx) < s->getWidth(); xx++) {
            tex->draw(x + (tex->getWidth() * xx), y + (tex->getHeight() * yy), 1, 1, 0);
            if (!hrepeat) {
                break;
            }
        }
        if (!vrepeat) {
            break;
        }
    }
}
