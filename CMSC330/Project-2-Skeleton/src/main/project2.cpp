// CMSC 330 Advanced Programming Languages
// Project 2 Skeleton
// UMGC CITE
// Spring 2023

// This file contains the main function for the project 2 skeleton. It reads an input file named input.txt
// that contains one statement that includes an expression following by a sequence of variable assignments.
// It parses each statement and then evaluates it.

// Modified by: Wyatt Humphrey Fall 2025
// Updated parsing of assignments to handle doubles, valitdation of '=' and ';', and improved error messages.




#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <cctype>
#include <vector>
using namespace std;

#include "expression.h"
#include "subexpression.h"
#include "symboltable.h"
#include "parse.h"

SymbolTable symbolTable;

void parseAssignments(stringstream& in);

int main() {
	const int SIZE = 256;
	Expression* expression;
    char paren, comma, line[SIZE];
 
	ifstream fin;
	fin = ifstream("input.txt");
	if (!(fin.is_open())) {
		cout << "File did not open" << endl;
		system("pause");
		return 1;
	}
	while (true) {
        fin.getline(line, SIZE);
		if (!fin)
			break;
		symbolTable.clear();
		stringstream in(line, ios_base::in); 
		in >> ws >> paren;
		cout << line << " ";
		try {
			expression = SubExpression::parse(in);
			in >> ws >> comma;
			parseAssignments(in);
			double result = expression->evaluate();
			cout << "Value = " << result << endl;
		}
		catch (string message) {
			cout << message << endl;
		} 
		catch (runtime_error& e) {
			cout << e.what() << endl;
		}
	}
	system("pause");
	return 0;
}

void parseAssignments(stringstream& in) {
	char assignop, delimiter;
    string variable;
    double value;
    do {
		in >> ws;
        variable = parseName(in);
        in >> ws >> assignop >> ws >> value >> ws;

		if (assignop != '=') {
            throw std::runtime_error("Error: expected '=' in assignment to '" + variable + "'.");
        }

        symbolTable.insert(variable, value);

		in >> delimiter;
        while (in && std::isspace(static_cast<unsigned char>(delimiter))) {
            in >> delimiter;
        }
    }
    while (delimiter == ',');
	
	if (delimiter != ';') {
        throw std::runtime_error("Error: expected ';' at end of assignments.");
    }
}
   
