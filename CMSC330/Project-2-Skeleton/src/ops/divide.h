// Wyatt Humphrey
// CMSC 330 Project 2
// 10/7/2025
// This heaseder file contains the Divide class definition.
// Divide is a subclass of SubExpression and implements the evaluate method.

class Divide: public SubExpression {
public:
    Divide(Expression* left, Expression* right): SubExpression(left, right) {
    }
    double evaluate() {
       return left->evaluate() / right->evaluate();
    }
};