#ifndef TIMER_H
#define TIMER_H

namespace Pineapple {

class Timer
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

