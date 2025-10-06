
class Negate: public SubExpression {
    public:
        Negate(Expression* operand) : SubExpression(operand, nullptr) {
        }

        double evaluate() {
            return -left->evaluate();
        }
};