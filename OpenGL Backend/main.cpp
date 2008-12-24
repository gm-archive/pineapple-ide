#include "pineapple.h"

using namespace Pineapple;

class Ship : public Actor
{
public:
    Ship(int x, int y) : Actor(x, y)
    {
        setFriction(1);
        setMotionMode(MotionRV);

        texture = new Texture("test.png", 16, 16);
    }

    ~Ship()
    {
        delete texture;
    }

    void update()
    {
        loop();

        if (Keyboard::isKeyDown(KeyUp))
            setSpeed(getSpeed() + 2);
        if (Keyboard::isKeyDown(KeyDown))
            setSpeed(getSpeed() - 2);

        setSpeed(sign(getSpeed()) * min(abs(getSpeed()), 8.0f));

        if (Keyboard::isKeyDown(KeyLeft))
            setDirection(getDirection() + 4);
        if (Keyboard::isKeyDown(KeyRight))
            setDirection(getDirection() - 4);

        angle = getDirection();
    }
};

class TestScene : public Scene
{
public:
    TestScene() : Scene(640, 480)
    {
        addActor(new Ship(50, 50));
    }
};

int main(int argc, char* argv[])
{
    Application::init();
    Window::setSize(640, 480);
    Window::setCaption("Hello");

    Scene* s = new TestScene();
    Application::setScene(s);

    Window::run();

    return 0;
}
