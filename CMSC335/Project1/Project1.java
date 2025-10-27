import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Project1 {
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
                case 1:
                    System.out.println("You selected: Circle");
                    double radius = readPosDouble(scanner, "Please enter the radius of the circle: ");
                    Circle circle = new Circle(radius);
                    System.out.println("The area of the circle is: " + circle.getArea()+ "\n");
                    break;
                case 2:
                    System.out.println("You selected: Triangle");
                    double base = readPosDouble(scanner, "Please enter the base of the triangle: ");
                    double height = readPosDouble(scanner, "Please enter the height of the triangle: ");
                    Triangle triangle = new Triangle(base, height);
                    System.out.println("The area of the triangle is: " + triangle.getArea() + "\n");
                    break;
                case 3:
                    System.out.println("You selected: Square");
                    double length = readPosDouble(scanner, "Please enter the length of the square: ");
                    Square square = new Square(length);
                    System.out.println("The area of the square is: " + square.getArea() + "\n");
                    break;
                case 4:
                    System.out.println("You selected: Rectangle");
                    length = readPosDouble(scanner, "Please enter the length of the rectangle: ");
                    double width = readPosDouble(scanner, "Please enter the width of the rectangle: ");
                    Rectangle rectangle = new Rectangle(length, width);
                    System.out.println("The area of the rectangle is: " + rectangle.getArea() + "\n");
                    break;
                case 5:
                    System.out.println("You selected: Sphere");
                    radius = readPosDouble(scanner, "Please enter the radius of the sphere: ");
                    Sphere sphere = new Sphere(radius);
                    System.out.println("The volume of the sphere is: " + sphere.getVolume()+ "\n");
                    break;
                case 6:
                    System.out.println("You selected: Cone");
                    height = readPosDouble(scanner, "Please enter the height of the cone: ");
                    radius = readPosDouble(scanner, "Please enter the radius of the cone: ");
                    Cone cone = new Cone(height, radius);
                    System.out.println("The volume of the cone is: " + cone.getVolume() + "\n");
                    break;

                case 7:
                    System.out.println("You selected: Cube");
                    length = readPosDouble(scanner, "Please enter the length of the cube: ");
                    Cube cube = new Cube(length);
                    System.out.println("The volume of the cube is: " + cube.getVolume() + "\n");
                    break;
                case 8:
                    System.out.println("You selected: Cylinder");
                    radius = readPosDouble(scanner, "Please enter the radius of the cylinder: ");
                    height = readPosDouble(scanner, "Please enter the height of the cylinder: ");
                    Cylinder cylinder = new Cylinder(radius, height);
                    System.out.println("The volume of the cylinder is: " + cylinder.getVolume() + "\n");
                    break;
                case 9:
                    System.out.println("You selected: Torus");
                    double major = readPosDouble(scanner, "Please enter the major radius of the torus: ");
                    double minor = readPosDouble(scanner, "Please enter the minor radius of the torus: ");
                    Torus torus = new Torus(major, minor);
                    System.out.println("The volume of the tourus is: " + torus.getVolume() + "\n");
                    break;

                case 10:
                    System.out.println("Thank you fo using the Shape Program. Today is " + getCurrentDate());
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }
    private static String getCurrentDate() {
        String date = LocalTime.now().format(DateTimeFormatter.ofPattern("MMM dd 'at' HH:mm"));
        return date;
    }

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
