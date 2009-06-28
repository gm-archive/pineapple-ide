#ifndef _TIMER_H
#define _TIMER_H

#include "core.h"

namespace Pineapple {

class Timer : public Object
{
private:
    int startTicks;
    bool started;
public:
    Timer();
    void start();
    int get_ticks();
};

}

#endif

