// Wyatt Humphrey
// CMSC 330 Project 2
// 10/7/2025
// This heaseder file contains the definition of the Negate class, which
// represents the negation operation in an expression tree.


class Negate: public SubExpression {
    public:
        Negate(Expression* operand) : SubExpression(operand, nullptr) {
        }

        double evaluate() {
            return -left->evaluate();
        }
};