class Ternary: public SubExpression {
private:
    Expression* trueExpression;
    Expression* falseExpression;

public:
    Ternary(Expression* left, Expression* m1,
            Expression* right): SubExpression(left, m1, right){
            }
    
    double evaluate() {
        return (left->evaluate() !=0)  ? m1->evaluate() : right->evaluate();
    }
};