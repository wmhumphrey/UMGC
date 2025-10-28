# Java Shape Calculator (CMSC 335 Project 1)

## Overview
This console-based Java application demonstrates object-oriented programming using inheritance and polymorphism to model two- and three-dimensional shapes.

Users can select from a menu of ten options to calculate the area of 2D shapes or the volume of 3D shapes.

### Supported Shapes
| 2D Shapes | 3D Shapes |
|------------|-----------|
| Circle | Sphere |
| Triangle | Cube |
| Square | Cylinder |
| Rectangle | Cone |
|  | Torus (major > minor radius) |

---

## Class Structure
- Shape — Abstract parent class; base for all shapes.  
- TwoDimensionalShape — Extends Shape; defines abstract getArea().  
- ThreeDimensionalShape — Extends Shape; defines abstract getVolume().  
- Subclasses such as Circle, Square, Triangle, Sphere, and Torus implement the specific geometric formulas.

The Project1.java class provides the main program loop, CLI interface, and user input validation.

---

## Prerequisites
- Java Development Kit (JDK 17+) installed.  
  Verify installation:
  ```bash
  java -version
  javac -version
  ```

---

## Compilation
Ensure all .java files are in the same directory, for example:
```
./Project1/
│
├── Shape.java
├── TwoDimensionalShape.java
├── ThreeDimensionalShape.java
├── Circle.java
├── Rectangle.java
├── Square.java
├── Triangle.java
├── Sphere.java
├── Cube.java
├── Cylinder.java
├── Cone.java
├── Torus.java
└── Project1.java
```

### Windows
```bash
cd D:\School\UMGC-repo\CMSC335\Project1
javac *.java
```

### macOS / Linux
```bash
cd ~/School/UMGC-repo/CMSC335/Project1
javac *.java
```

Compilation creates .class files for each source.

---

## Execution
Run the program using:
```bash
java Project1
```

### Program Flow
1. A menu (1–10) appears.  
2. Enter a number corresponding to a shape.  
3. Enter positive dimensions when prompted.  
   - For Torus, the major radius must be greater than the minor radius.  
   - If invalid input is entered, the program will re-prompt.  
4. Choose option 10 to exit.  
   The program displays a goodbye message with the current date and time.

---

## Example Session
```
---------Welcome to the Java Shape Program---------

1.  Construct a Circle
...
10. Exit program

Please enter a number: 1
You selected: Circle
Please enter the radius of the circle: 3
The area of the circle is: 28.274333882308138

Please enter a number: 10
Thank you for using the Shape Program. Today is Oct 28 14:23
```

---

## Troubleshooting
| Issue | Fix |
|--------|-----|
| 'javac' is not recognized | Install JDK 17+ and ensure PATH or JAVA_HOME are set. |
| Program “does nothing” | It is waiting for input in the terminal, not the Output panel. |
| Wrong results | Check that input values are positive and valid for the chosen shape. |

---

## Cleaning Build Files
To remove .class files before recompiling:

### Windows
```bash
del *.class
```

### macOS / Linux
```bash
rm -f *.class
```

Then recompile using `javac *.java`.

---

## Timestamp
The program prints a timestamp at exit using:
```java
LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd HH:mm"));
```
Example output:
```
Oct 28 14:23
```

---

## .gitignore Recommendation
You should ignore .class files in Git, as they are compiled artifacts.

### Example .gitignore
```
# Compiled class files
*.class

# Logs / temporary files
*.log
*.tmp

# IDE settings
.vscode/
.idea/
*.iml
```

---

## Author
Wyatt Humphrey  
CMSC 335 — Object-Oriented and Concurrent Programming  
University of Maryland Global Campus  
Fall 2025
