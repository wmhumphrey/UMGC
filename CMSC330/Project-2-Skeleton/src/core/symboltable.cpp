// CMSC 330 Advanced Programming Languages
// Project 2 Skeleton
// UMGC CITE
// Spring 2023

// This file contains the body of the functions contained in The SymbolTable class. The insert function 
// inserts a new variable symbol and its value into the symbol table and the lookUp function returns
// that value of the supplied variable symbol name.

// Modified by: Wyatt Humphrey Fall 2025
// Added error handling for duplicate and uninitialized variables.
// Ensures the symbol table is cleared before processing a new line.


#include <string>
#include <vector>
using namespace std;

#include "symboltable.h"
#include "exception.h"

void SymbolTable::insert(string variable, double value) {
    for (const Symbol& s:elements) {
        if (s.variable == variable) {
            throw DupVarErr(variable);
        }
    }
    const Symbol& symbol = Symbol(variable, value);
    elements.push_back(symbol);
}

double SymbolTable::lookUp(string variable) const {
    for (const Symbol& s:elements) {
        if (s.variable == variable) {
            return s.value;
        }
    }
    throw UninitVarErr(variable);
}
