#include <algorithm>

class Avg: public SubExpression {
public: 
    Avg(Expression* left, Expression* right): SubExpression(left, right){}
    double evaluate(){
        return std::mean(left->evaluate(), right->evaluate());
    }
};