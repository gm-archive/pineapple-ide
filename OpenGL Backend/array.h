#ifndef _ARRAY_H_INCLUDED
#define _ARRAY_H_INCLUDED

#include "exceptions.h"
#include "core.h"

namespace Pineapple
{

    template<class T>
    class Array : public Object
    {
    private:
        T* arrayContent;
        int length;
    public:
        Array(int length)
        {
            if (length<=0) throw new InvalidArgumentException("Array length must be greater than 0");
            this->length = length;
            arrayContent = new T[length];
        }
        int getLength()
        {
            return length;
        }
        T& getElementAt(int pos)
        {
            if (pos>=length)
            {
                throw new IndexOutOfBoundsException();
            }
            return arrayContent[pos];
        }
        T& operator[](int pos)
        {
            return getElementAt(pos);
        }
    };

}
#endif // ARRAY_H_INCLUDED
