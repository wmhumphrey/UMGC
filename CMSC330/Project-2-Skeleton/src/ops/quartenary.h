class Quartenary: public SubExpression {
private:
    Expression* firstExp;
    Expression* secondExp; 
    Expression* thirdExp;  
    
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