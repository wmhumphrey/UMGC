// Wyatt Humphrey
// CMSC 330 Project 2
// 10/7/2025
// This heaseder defines the Min class, which is a subclass of SubExpression
// It represents the minimum of two expressions

#include <algorithm>

class Min: public SubExpression {
    public:
    Min(Expression* left, Expression* right): SubExpression(left, right){
    }
    double evaluate() {
        return std::min(left->evaluate(), right->evaluate());
    }
};