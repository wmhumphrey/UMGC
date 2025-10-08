// Wyatt Humphrey
// CMSC 330 Project 2
// 10/7/2025
// This heaseder file contains the class definition for the Ternary class, which
// is a subclass of SubExpression. The Ternary class represents a ternary operation
// in an expression tree, specifically the conditional operator (?:). It evaluates
// the left expression and returns the result of either the middle or right expression
// based on the truthiness of the left expression.

class Ternary: public SubExpression {
public:
    Ternary(Expression* left, Expression* m1,
            Expression* right): SubExpression(left, m1, right){
            }
    
    double evaluate() {
        return (left->evaluate() !=0)  ? m1->evaluate() : right->evaluate();
    }
};