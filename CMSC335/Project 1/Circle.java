public class Circle extends TwoDimensionalShape {
    private double radius;
    
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public double getArea() {
        return 2 * Math.PI * radius;
    }
}
