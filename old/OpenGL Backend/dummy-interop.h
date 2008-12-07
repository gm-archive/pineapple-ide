/* 
 * File:   dummy-interop.h
 * Author: luis
 *
 * Created on 26 de Outubro de 2008, 11:33
 */

#ifndef _DUMMY_INTEROP_H
#define	_DUMMY_INTEROP_H

#include "pineapple.h"

#ifdef unix
#include "unix-interop.h"
#else

class pineapple::std::NativeLibrary {
    public:
        NativeLibrary(string libname);
        bool isLoaded();
        FunctionPointer* getFunction(string fname);
        void dispose();
};

#endif

#endif	/* _DUMMY_INTEROP_H */

