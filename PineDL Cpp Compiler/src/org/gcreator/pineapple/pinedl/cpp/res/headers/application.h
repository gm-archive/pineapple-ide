#ifndef APPLICATION_H
#define APPLICATION_H

#include "scene.h"
#include <string>

namespace Pineapple {

class Application
{
    static int speed;
    static bool running;
    static Scene* currentScene;
public:
	static void init();
	static void exit() { running = false; }
	static bool isRunning() { return running; }
	static int getSpeed() { return speed; }

	static std::string getCurrentDirectory();
	static std::string getExecutablePath();
	static std::string getExecutableDirectory();

	static void setScene(Scene* scene);
	static Scene* getScene() { return currentScene; }
};

}

#endif
