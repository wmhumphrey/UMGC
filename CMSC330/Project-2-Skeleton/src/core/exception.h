#include <stdexcept>
#include <string>

class UninitVarErr: public std::runtime_error {
    public:
        explicit UninitVarErr(const std::string& variable):
         runtime_error("Error: " + variable + " is uninitialized.") {}
};

class DupVarErr: public std::runtime_error {
    public:
        explicit DupVarErr(const std::string& variable):
         runtime_error("Error: " + variable + " has be initlaized ore than once.") {}
};