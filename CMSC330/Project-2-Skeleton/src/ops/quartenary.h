// Wyatt Humphrey
// CMSC 330 Project 2
// 10/7/2025
// This heaseder file contains the exception class for quartenary expressions. 
// A quartenary expression has four sub-expressions, and evaluates to the first
// sub-expression if it is less than zero, the second sub-expression if it is
// equal to zero, and the third sub-expression if it is greater than zero.



class Quartenary: public SubExpression {
public:
    Quartenary(Expression* left, Expression* m1, 
               Expression* m2, Expression* right): SubExpression(left, m1, m2, right){}
    double evaluate() {
        if (left->evaluate() <= 0){
            return m1->evaluate();
        } else if (left->evaluate() == 0) {
            return m2->evaluate();
        } else {
            return right->evaluate();
        }
    }
};