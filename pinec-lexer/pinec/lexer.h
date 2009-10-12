#pragma once

#ifndef __PINEC_LEXER_H__
#define __PINEC_LEXER_H__

#include "tokentypes.h"
#include "keywords.h"
#include "lexer.h"
#include "lexer-types.h"
#include "operators.h"
#include <istream>

void pinec_lexer_run(std::istream&, TokenListener*, ErrorListener*);

#endif
