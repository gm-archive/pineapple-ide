#ifndef _IO_H_
#define _IO_H_

#include <string>
#include "core.h"

namespace Pineapple{
    class InputStream : public Object{
        virtual int read() = 0;
        const std::string readAll(){
            std::string value = std::string("");

            while(true){
                int i = read();
                if(i==-1){
                    break;
                }
                value += (char) i;
            }

            return value;
        }
        virtual void close(){}
    };

    class OutputStream : public Object{
        virtual void write(int chr) = 0;
        virtual void write(char chr){ write((int) chr); }
        void write(std::string string){
            for(unsigned int i = 0; i < string.length(); i++){
                write(string[i]);
            }
        }
        virtual void close(){}
    };

    class FileInputStream : public Object{
        private:
            void* file;
            bool closed;
        public:
            FileInputStream(const std::string location);
            virtual int read();
            virtual void close();
    };

    class FileOutputStream : public Object{
        private:
            void* file;
            bool closed;
        public:
            FileOutputStream(const std::string location, bool append = false);
            virtual void write(int chr);
            virtual void close();
    };
}

#endif

