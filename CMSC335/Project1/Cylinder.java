public class Cylinder extends ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        super();

        this.radius = radius;
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
