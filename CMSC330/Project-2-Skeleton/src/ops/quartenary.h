class Quartenary: public SubExpression {
private:
    Expression* firstExp;
    Expression* secondExp; 
    Expression* thirdExp;  
    
public:
    Quartenary(Expression* condition, Expression* firstExp, 
               Expression* secondExp, Expression* thirdExp): 
               SubExpression(condition, nullptr), firstExp(firstExp), secondExp(secondExp), thirdExp(thirdExp){}
    double evaluate() {
        if (left->evaluate() <= 0){
            return firstExp->evaluate();
        } else if (left->evaluate() == 0) {
            return secondExp->evaluate();
        } else {
            return thirdExp->evaluate();
        }
    }
};