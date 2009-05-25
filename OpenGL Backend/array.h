#ifndef ARRAY_H_INCLUDED
#define ARRAY_H_INCLUDED

namespace Pineapple{

    template<class T>
    class Array{
        private:
            T* arrayContent;
            int length;
        public:
            Array(int length);
            int getLength();
            T getElementAt(int pos);
            T operator[](int pos){
                return getElementAt(pos);
            }
    };

}

#endif // ARRAY_H_INCLUDED
