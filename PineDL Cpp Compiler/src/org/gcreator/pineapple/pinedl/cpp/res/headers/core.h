#ifndef _CORE_H_INCLUDED
#define _CORE_H_INCLUDED

#include <cstdio> //For NULL. I'd prefer not to have this call, but we need it
#include <string>

namespace Pineapple{

    class Object
    {
        protected:
            virtual void _t(){} //Used to solve some compile errors
    };

    template<class T>
    bool _isInstanceof(Object* o)
    {
        return o!=NULL && (dynamic_cast<T> (o))!=NULL;
    }

    template<class T> bool _isInstanceof(int o){ return false; }
    template<class T> bool _isInstanceof(double o){ return false; }
    template<class T> bool _isInstanceof(char o){ return false; }
    template<class T> bool _isInstanceof(bool o){ return false; }
    template<class T> bool _isInstanceof(std::string o){ return false; }

}

#endif
