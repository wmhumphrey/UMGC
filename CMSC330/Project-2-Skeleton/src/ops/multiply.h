// Wyatt Humphrey
// CMSC 330 Project 2
// 10/7/2025
//
// This heaseder file contains the definition of the Multiply class, which
// represents a multiplication operation in an expression tree.


class Multiply: public SubExpression {
public:
    Multiply(Expression* left, Expression* right): SubExpression(left, right) {
    }
    double evaluate() {
       return left->evaluate() * right->evaluate();
    }
};