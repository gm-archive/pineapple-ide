#include "array.h"
#include "exceptions.h"

using namespace Pineapple;

template <class T> Array::Array(int length)
{
    if(length<=0) throw new InvalidArgumentException("Array length must be greater than 0");
    this->length = length;
    arrayContent = new T[length];
}

template <class T> int Array::getLength()
{
    return length;
}

template <class T> T Array::getElementAt(int pos)
{
    if(pos>=length)
    {
        throw new IndexOutOfBoundsException();
    }
}
