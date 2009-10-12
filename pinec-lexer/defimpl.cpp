#include "pinec/lexer.h"

bool TokenListener::handleToken(Token* token){
	delete token;
	return false;
}

void TokenListener::handleEnd(){
}

bool ErrorListener::handleError(Error error){
	return error.m_fatal;
}
