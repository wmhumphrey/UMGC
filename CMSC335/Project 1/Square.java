public class Square extends TwoDimensionalShape {
    private double length;


    public Square(double length) {
        super();
        this.length = length;
    }

    public double getArea() {
        return length * length;
    }
}