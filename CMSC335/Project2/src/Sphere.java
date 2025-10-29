public class Sphere extends ThreeDimensionalShape {
    private double radius;
    public Sphere(double radius) {
        super();
        this.radius = radius;
    }

    public double getVolume() {
        return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
    }
    
}
