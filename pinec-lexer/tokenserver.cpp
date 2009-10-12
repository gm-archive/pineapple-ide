#include "pinec/lexer.h"

TokenServer::TokenServer(){
	m_end = false;
	m_reqend = false;
}

bool TokenServer::handleToken(Token* token){
	if(m_reqend){
		delete token;
	}
	else{
		m_tokens.push(token);
	}
	return m_reqend;
}

void TokenServer::handleEnd(){
	m_end = true;
}

Token* TokenServer::getToken(){
	while(true){
		if(!m_tokens.empty()){
			Token* t = m_tokens.front();
			m_tokens.pop();
			return t;
		}
		if(m_end||m_reqend){
			return NULL;
		}
	}
	return NULL;
}

void TokenServer::requestEnd(){
	m_reqend = true;

	while(!m_tokens.empty()){
		delete m_tokens.front();
		m_tokens.pop();
	}
}
