#ifndef APPLICATION_H
#define APPLICATION_H

#include "scene.h"
#include <string>
#include "core.h"

namespace Pineapple {

class Application : public Object
{
    static int speed;
    static bool running;
    static bool playing;
    static Scene* currentScene;
public:
	static void init();
	static void exit() { running = false; }
	static bool isRunning() { return running; }
	static bool isPlaying() { return playing; }
	static int getSpeed() { return speed; }
	static void play() { playing = true; }
	static void pause() { playing = false; }

	static std::string getCurrentDirectory();
	static std::string getExecutablePath();
	static std::string getExecutableDirectory();

	static void setScene(Scene* scene);
	static Scene* getScene() { return currentScene; }
};

}

#endif
