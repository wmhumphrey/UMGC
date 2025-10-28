/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-2025
 * CMSC 335 Project 1
 * 
 * This class contains the main method for running the OOP Java Shape program.
 * It creates a CLI that can be used to calculate the volume or area of a shape
 * based on the user inputs.
 */

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Project1 {
    /**
     * Main method for OOP Java Shape program
     * 
     * @param args
     */
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String menu = """
                        1.             Construct a Circle

                        2.           Construct a Triangle
                    
                        3.             Construct a Square
                    
                        4.          Construct a Rectangle
                            
                        5.             Construct a Shpere
                            
                        6.               Construct a Cone
                            
                        7.               Construct a Cube
                            
                        8.           Construct a Cylinder
                            
                        9.              Construct a Torus
                            
                        10.                  Exit program
               """;
       
        System.out.println("\n\n---------Welcome to the Java Shape Program---------\n");

        // Handles user input cases and only accepts selections in the range 1-10
        while(true) {
            System.out.println(menu);
            int selection = 0;
            try {
                System.out.print("Please enter a number: ");
                selection = scanner.nextInt();
            } catch(IllegalArgumentException e) {
                System.out.println("Incorrect value entered.");
            }
            switch (selection) {
                // Circle case
                case 1:
                    System.out.println("You selected: Circle");
                    double radius = readPosDouble(scanner, "Please enter the radius of the circle: ");
                    Circle circle = new Circle(radius);
                    System.out.println("The area of the circle is: " + circle.getArea()+ "\n");
                    break;
                
                // Triangle case
                case 2:
                    System.out.println("You selected: Triangle");
                    double base = readPosDouble(scanner, "Please enter the base of the triangle: ");
                    double height = readPosDouble(scanner, "Please enter the height of the triangle: ");
                    Triangle triangle = new Triangle(base, height);
                    System.out.println("The area of the triangle is: " + triangle.getArea() + "\n");
                    break;
                
                // Square case
                case 3:
                    System.out.println("You selected: Square");
                    double length = readPosDouble(scanner, "Please enter the length of the square: ");
                    Square square = new Square(length);
                    System.out.println("The area of the square is: " + square.getArea() + "\n");
                    break;
                
                // Rectangle case
                case 4:
                    System.out.println("You selected: Rectangle");
                    length = readPosDouble(scanner, "Please enter the length of the rectangle: ");
                    double width = readPosDouble(scanner, "Please enter the width of the rectangle: ");
                    Rectangle rectangle = new Rectangle(length, width);
                    System.out.println("The area of the rectangle is: " + rectangle.getArea() + "\n");
                    break;
                
                // Sphere case
                case 5:
                    System.out.println("You selected: Sphere");
                    radius = readPosDouble(scanner, "Please enter the radius of the sphere: ");
                    Sphere sphere = new Sphere(radius);
                    System.out.println("The volume of the sphere is: " + sphere.getVolume()+ "\n");
                    break;
                
                // Cone case
                case 6:
                    System.out.println("You selected: Cone");
                    height = readPosDouble(scanner, "Please enter the height of the cone: ");
                    radius = readPosDouble(scanner, "Please enter the radius of the cone: ");
                    Cone cone = new Cone(height, radius);
                    System.out.println("The volume of the cone is: " + cone.getVolume() + "\n");
                    break;

                // Cube case
                case 7:
                    System.out.println("You selected: Cube");
                    length = readPosDouble(scanner, "Please enter the length of the cube: ");
                    Cube cube = new Cube(length);
                    System.out.println("The volume of the cube is: " + cube.getVolume() + "\n");
                    break;

                // Cylinder case
                case 8:
                    System.out.println("You selected: Cylinder");
                    radius = readPosDouble(scanner, "Please enter the radius of the cylinder: ");
                    height = readPosDouble(scanner, "Please enter the height of the cylinder: ");
                    Cylinder cylinder = new Cylinder(radius, height);
                    System.out.println("The volume of the cylinder is: " + cylinder.getVolume() + "\n");
                    break;
                
                // Torus case
                case 9:
                    System.out.println("You selected: Torus");
                    double major, minor;
                    while (true) {
                        major = readPosDouble(scanner, "Please enter the major radius of the torus: ");
                        minor = readPosDouble(scanner, "Please enter the minor radius of the torus: ");
                        if (major > minor) {
                            break;
                        } else {
                            System.out.println("Incorrect values. Major radius must be greater than minor radius.");
                        }    
                    Torus torus = new Torus(major, minor);
                    System.out.println("The volume of the tourus is: " + torus.getVolume() + "\n");
                    break;
                
                // Exit case    
                case 10:
                    System.out.println("Thank you fo using the Shape Program. Today is " + getCurrentDate());
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * Method for calculating the current date and time at termination
     * 
     * @return current date and time in MMM dd HH:mm format
     */
    private static String getCurrentDate() {
        String date = LocalTime.now().format(DateTimeFormatter.ofPattern("MMM dd 'at' HH:mm"));
        return date;
    }


    /**
     * Helper method to validate user input for parameters used in calculating area and volume.
     * Ensures values are positive numbers.
     * 
     * @param scanner scanner object
     * @param prompt String that prompts the user on what to enter
     * @return d double, the value that is entered if postive number. 
     */
    private static double readPosDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if(scanner.hasNextDouble()) {
                double d = scanner.nextDouble();
                scanner.nextLine();
                if (d > 0) {
                    return d;
                } else {
                    System.out.println("Incorrect value. Please enter a postitive number.");
                }
            } 
        }
    }
}
 