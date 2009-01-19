#include "pineapple.h"

#include <cstdio>

using namespace Pineapple;

FileInputStream::FileInputStream(const std::string location){
    closed = false;
    file = (void*) fopen(location.c_str(), "r");
    if(file==NULL){
        throw new IOException("Could not open file");
    }
}

int FileInputStream::read(){
    if(closed){
        throw new IOException("Attempting to read from closed stream");
    }
    return fgetc((FILE*) file);
}

void FileInputStream::close(){
    if(closed){
        throw new IOException("Attempting to close a stream that was already closed.");
    }
    fclose((FILE*) file);
    closed = true;
}

FileOutputStream::FileOutputStream(const std::string location, bool append){
    closed = false;
    file = (void*) fopen(location.c_str(), append?"a":"w+");
    if(file==NULL){
        throw new IOException("Could not open file");
    }
}

void FileOutputStream::close(){
    if(closed){
        throw new IOException("Attempting to close a stream that was already closed.");
    }
    fclose((FILE*) file);
    closed = true;
}

void FileOutputStream::write(int chr){
    fputc(chr, (FILE*) file);
}

