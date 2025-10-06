class Ternary: public SubExpression {
private:
    Expression* trueExpression;
    Expression* falseExpression;

public:
    Ternary(Expression* condition, Expression* trueExpression,
            Expression* falseExpression): SubExpression(condition, nullptr),
            trueExpression(trueExpression), falseExpression(falseExpression){
            }
    
    double evaluate() {
        return left->evaluate() ? trueExpression->evaluate() : falseExpression->evaluate();
    }
};