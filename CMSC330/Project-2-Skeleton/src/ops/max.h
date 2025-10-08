// Wyatt Humphrey
// CMSC 330 Project 2
// 10/7/2025
// This header file defines the Max class, which inherits from SubExpression
// and implements the evaluate method to return the maximum of two expressions.

#include <algorithm>

class Max : public SubExpression
{
public:
    Max(Expression *left, Expression *right) : SubExpression(left, right){
    }
    double evaluate()
    {
        return std::max(left->evaluate(), right->evaluate());
    }
};