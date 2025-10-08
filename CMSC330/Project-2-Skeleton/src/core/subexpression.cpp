// CMSC 330 Advanced Programming Languages
// Project 2 Skeleton
// UMGC CITE
// Spring 2023

// This file contains the body of the functions contained in The SubExpression class, which includes
// the constructor that initializes the left and right subexpressions and the static function parse
// parses the subexpression. Addition and subtraction are the two operators that are implemented.

// Modified by: Wyatt Humphrey Fall 2025
// Rewrote the SubExpression parsing logic to be more robust and handle errors better.
// Implemented parsing for all specified operators including +, -, *, /, %, ^, <, >, &, ~, ?, and #.
// Added helper functions to streamline parsing and improve code readability.
// Ensured proper error handling for unexpected characters and mismatched parentheses.

#include <iostream>
#include <sstream>
using namespace std;

#include "expression.h"
#include "subexpression.h"
#include "operand.h"
#include "plus.h"
#include "minus.h"
#include "multiply.h"
#include "divide.h"
#include "remainder.h"
#include "exponent.h"
#include "min.h"
#include "max.h"
#include "avg.h"
#include "negate.h"
#include "ternary.h"
#include "quartenary.h"




SubExpression::SubExpression(Expression* left, Expression* right) {
    this->left = left;
    this->right = right;
}

SubExpression::SubExpression(Expression* left, Expression* m1, Expression* right) {
    this->left = left;
    this->right = right;
    this->m1 = m1;
}

SubExpression::SubExpression(Expression* left, Expression* m1, Expression* m2, Expression* right) {
    this->left = left;
    this->right = right;
    this->m1 = m1;
    this->m2 = m2;
}

static Expression* parseOne(std::stringstream& s) {
       s >> ws;
       return Operand::parse(s);
    }
    
static void consumeParen(std::stringstream& s) {
       char p;
       s >> ws >> p;
       if (p != ')') {
          throw std::runtime_error(string("Error: expected '(', found '") + p + "'.");
       }
    }


Expression* SubExpression::parse(stringstream& in) {
    
    Expression* left;
    Expression* right;
    Expression* m1;
    Expression* m2;
    char operation, paren;
    
    
    left = parseOne(in);
    in >> ws >> operation;

    switch (operation) {
        case '+':
            right = parseOne(in);
            consumeParen(in);
            return new Plus(left, right);
        case '-':
            right = parseOne(in);
            consumeParen(in);
            return new Minus(left, right);
        case '*':
            right = parseOne(in);
            consumeParen(in);
            return new Multiply(left, right);
        case '/':
            right = parseOne(in);
            consumeParen(in);
            return new Divide(left, right);
        case '%':
            right = parseOne(in);
            consumeParen(in);
            return new Remainder(left, right);
        case '^':
            right = parseOne(in);
            consumeParen(in);
            return new Exponent(left, right);
        case '<':
            right = parseOne(in);
            consumeParen(in);
            return new Min(left, right);
        case '>':
            right = parseOne(in);
            consumeParen(in);
            return new Max(left, right);
        case '&':
            right = parseOne(in);
            consumeParen(in);
            return new Avg(left, right);
        case '~':
            consumeParen(in);
            return new Negate(left);
        case '?': {
            m1 = Operand::parse(in);
            right = Operand::parse(in);
            in >> ws >> paren;
            return new Ternary(left, m1, right);
        }

        case '#': {
            m1 = parseOne(in);
            in >> ws;
            m2 = parseOne(in);
            right = parseOne(in);

            in >> ws >> paren;

            return new Quartenary(left, m1, m2, right);
        }
    }
    return 0;
}
        