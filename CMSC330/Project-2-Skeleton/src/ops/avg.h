// Wyatt Humphrey
// CMSC 330 Project 2
// 10/7/2025
// This heaseder file contains the declaration of the Avg class, which
// is a subclass of SubExpression. The Avg class represents the average
// of two expressions.


class Avg: public SubExpression {
public:
    Avg(Expression *left, Expression *right) : SubExpression(left, right) {}
    double evaluate(){
        return (left->evaluate() + right->evaluate()) / 2.0;
    }
};