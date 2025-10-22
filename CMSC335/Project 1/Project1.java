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
                    System.out.print("Please enter the radius of the circle: ");
                    double radius = scanner.nextDouble();
                    scanner.nextLine();
                    Circle circle = new Circle(radius);

                    System.out.println("The area of the circle is: " + circle.getArea()+ "\n");
                    break;
                case 2:
                    System.out.println("You selected: Triangle");
                    System.out.print("Please enter the base length of the triangle: ");
                    double base = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Please enter the height of the triangle: ");
                    double height = scanner.nextDouble();
                    scanner.nextLine();

                    Triangle triangle = new Triangle(base, height);

                    System.out.println("The area of the triangle is: " + triangle.getArea() + "\n");
                    break;
                case 3:
                    System.out.println("You selected: Square");
                    System.out.print("Please enter the length of the square: ");
                    double length = scanner.nextDouble();
                    scanner.nextLine();
                    Square square = new Square(length);

                    System.out.println("The area of the square is: " + square.getArea() + "\n");
                    break;
                case 4:
                    System.out.println("You selected: Rectangle");
                    System.out.print("Please enter the length of the rectangle: ");
                    length = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Please enter the width of the rectangle: ");
                    double width = scanner.nextDouble();
                    scanner.nextLine();
                    Rectangle rectangle = new Rectangle(length, width);

                    System.out.println("The area of the rectangle is: " + rectangle.getArea() + "\n");
                    break;
                case 5:
                    System.out.println("You selected: Sphere");
                    System.out.print("Please enter the radius of the sphere: ");
                    radius = scanner.nextDouble();
                    scanner.nextLine();
                    Sphere sphere = new Sphere(radius);

                    System.out.println("The volume of the sphere is: " + sphere.getVolume()+ "\n");
                    break;
                case 6:
                    System.out.println("You selected: Cone");
                    System.out.print("Please enter the height of the cone: ");
                    height = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Please enter the radius of the cone: ");
                    radius = scanner.nextInt();
                    scanner.nextLine();
                    Cone cone = new Cone(height, radius);

                    System.out.println("The volume of the cone is: " + cone.getVolume() + "\n");
                    break;

                case 7:
                    System.out.println("You selected: Cube");
                    System.out.print("Please enter the length of the cube: ");
                    length = scanner.nextDouble();
                    scanner.nextLine();
                    Cube cube = new Cube(length);

                    System.out.println("The volume of the cube is: " + cube.getVolume() + "\n");
                    break;

                case 8:
                    System.out.println("You selected: Cylinder");
                    System.out.print("Please enter the radius of the cylinder: ");
                    radius = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Please enter the heigt of the cylinder: ");
                    height = scanner.nextInt();
                    scanner.nextLine();
                    Cylinder cylinder = new Cylinder(radius, height);

                    System.out.println("The volume of the cylinder is: " + cylinder.getVolume() + "\n");
                    break;

                case 9:
                    System.out.println("You selected: Torus");
                    System.out.print("Please enter the major radius of the torus: ");
                    double major = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Please enter the minor radius of the torus: ");
                    double minor = scanner.nextDouble();
                    scanner.nextLine();
                    Torus torus = new Torus(major, minor);

                    System.out.println("The volume of the tourus is: " + torus.getVolume() + "\n");
                    break;

                case 10:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }
}
