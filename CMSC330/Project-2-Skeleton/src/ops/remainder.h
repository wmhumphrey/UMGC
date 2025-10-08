// Wyatt Humphrey
// CMSC 330 Project 2
// 10/7/2025
//
// This heaseder file contains the definition of the Remainder class, which
// inherits from the SubExpression class and implements the evaluate method
// to compute the remainder of two expressions using the fmod function from
// the cmath library.

#include <cmath>

class Remainder: public SubExpression {
public:
    Remainder(Expression* left, Expression* right): SubExpression(left, right) {
    }
    double evaluate() {
       return fmod(left->evaluate(), right->evaluate());
    }
};