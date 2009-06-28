#include "core.h"

namespace Pineapple{

template<> bool _isInstanceof<int>(Object* o){ return false; }
template<> bool _isInstanceof<int>(int o){ return true; }

template<> bool _isInstanceof<double>(Object* o){ return false; }
template<> bool _isInstanceof<double>(double o){ return true; }

template<> bool _isInstanceof<char>(Object* o){ return false; }
template<> bool _isInstanceof<char>(char o){ return true; }

template<> bool _isInstanceof<bool>(Object* o){ return false; }
template<> bool _isInstanceof<bool>(bool o){ return true; }

template<> bool _isInstanceof<std::string>(Object* o){ return false; }
template<> bool _isInstanceof<std::string>(std::string o){ return true; }

}
