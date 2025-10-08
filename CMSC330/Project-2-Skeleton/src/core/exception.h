// Wyatt Humphrey
// CMSC 330 Project 2
// 10/7/2025
// This heaseder file contains the exception classes for the project including exceptions for uninitialized variables and duplicate variable assignments.

#include <stdexcept>
#include <string>

class UninitVarErr: public std::runtime_error {
    public:
        explicit UninitVarErr(const std::string& variable):
         std::runtime_error("Error: " + variable + " is uninitialized.") {}
};

class DupVarErr: public std::runtime_error {
    public:
        explicit DupVarErr(const std::string& variable):
        std::runtime_error("Error: " + variable + " has be initlaized ore than once.") {}
};