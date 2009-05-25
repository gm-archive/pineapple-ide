#ifndef _EXCEPTIONS_H_
#define _EXCEPTIONS_H_

namespace Pineapple {

class Exception{
    private:
        std::string message;
    public:
        Exception(const std::string message){ this->message = message; }
        Exception(){ this->message = std::string(""); }
        const std::string getMessage(){ return message; }
};

class IOException : public Exception{
    public:
        IOException() : Exception(){}
        IOException(const std::string message) : Exception(message){}
};

class IndexOutOfBoundsException : public Exception{
    public:
        IndexOutOfBoundsException() : Exception(){}
        IndexOutOfBoundsException(const std::string message) : Exception(message){}
};

class InvalidArgumentException : public Exception{
    public:
        InvalidArgumentException() : Exception(){}
        InvalidArgumentException(const std::string message) : Exception(message){}
};

}

#endif
