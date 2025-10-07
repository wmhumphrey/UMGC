#include <cmath>

class Remainder: public SubExpression {
public:
    Remainder(Expression* left, Expression* right): SubExpression(left, right) {
    }
    double evaluate() {
       return fmod(left->evaluate(), right->evaluate());
    }
};