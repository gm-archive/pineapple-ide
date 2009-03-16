#include "SDL/SDL_opengl.h"
#include "scene.h"
#include "application.h"

#include <cstdio>
#ifdef WIN32
    #include <direct.h>
    #include <windows.h>
    #define GetCurrentDir _wgetcwd
#else
    #include <unistd.h>
    #define GetCurrentDir getcwd
#endif

using namespace Pineapple;

int Application::speed = 60;
bool Application::running = true;
Scene* Application::currentScene = NULL;

void Application::init()
{
	if (SDL_Init(SDL_INIT_VIDEO) < 0)
		throw "Could not initialize SDL";
    atexit(SDL_Quit);

    running = true;
}

void Application::setScene(Scene* scene)
{
    if (currentScene != NULL)
        delete currentScene;

    currentScene = scene;
}

std::string Application::getCurrentDirectory()
{
    #ifdef WIN32
      wchar_t cPath[FILENAME_MAX+1];
    #else
      char cPath[FILENAME_MAX+1];
    #endif
	if(!GetCurrentDir(cPath, sizeof(cPath))){
	    return "";
	}
	cPath[sizeof(cPath) - 1] = '\0';

	#ifdef WIN32
	  char fPath[FILENAME_MAX+1];
	  wcstombs(fPath, cPath, FILENAME_MAX+1);
	  std::string s = fPath;
    #else
      std::string s = cPath;
    #endif
    return s;
}

std::string Application::getExecutablePath()
{
    char cPath[FILENAME_MAX+1];
#ifdef WIN32
    int bytes = GetModuleFileName(NULL, cPath, FILENAME_MAX);
    if(bytes==0){
        return "";
    }
    cPath[sizeof(cPath) - 1] = '\0';
#else
    char szTmp[32];
    sprintf(szTmp, "/proc/%d/exe", getpid());
    int bytes = readlink(szTmp, cPath, FILENAME_MAX);
    if(bytes >= 0){
            cPath[bytes] = '\0';
    }
#endif
	std::string s = cPath;
    return s;
}

std::string Application::getExecutableDirectory()
{
    std::string fpath = getExecutablePath();
    if(fpath==""){ return ""; }
    size_t i = fpath.find_last_of("/");
    size_t i2 = fpath.find_last_of("\\");
    if(i2>i){
        i = i2;
    }
    if(i==std::string::npos){
        return fpath;
    }
    return fpath.substr(0, i+1);
}
