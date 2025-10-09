public class Cone extends ThreeDimensionalShape {
    private double height;
    private double radius;

    public Cone(double height, double radius) {
        super();
        this.height = height;
        this.radius = radius;
    }

    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) *(height / 3);
    }
}
