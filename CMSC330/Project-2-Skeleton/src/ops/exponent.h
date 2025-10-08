// Wyatt Humphrey
// CMSC 330 Project 2
// 10/7/2025
// This heaseder file contains the exponent class for exponent expressions.
// An exponent expression has two sub-expressions, and evaluates to the first
// sub-expression raised to the power of the second sub-expression.

#include <cmath>

class Exponent: public SubExpression {
public:
    Exponent(Expression* left, Expression* right): SubExpression(left, right) {
    }
    double evaluate() {
       return pow(left->evaluate(), right->evaluate());
    }
};