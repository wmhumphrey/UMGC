public class Rectangle extends TwoDimensionalShape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super();
        this.length = length;
        this.width =  width;
    }

    public double getArea() {
        return length * width;
    }
}