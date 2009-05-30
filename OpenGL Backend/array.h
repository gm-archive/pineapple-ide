#include "exceptions.h"

#ifndef ARRAY_H_INCLUDED
#define ARRAY_H_INCLUDED

namespace Pineapple
{

    template<class T>
    class Array
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
        T getElementAt(int pos)
        {
            if (pos>=length)
            {
                throw new IndexOutOfBoundsException();
            }
        }
        T operator[](int pos)
        {
            return getElementAt(pos);
        }
    };

}
#endif // ARRAY_H_INCLUDED
