public class Sphere extends ThreeDimensionalShape {
    private double radius;
    public Sphere(double radius) {
        super();
        this.radius = radius;
    }

    public double getVolume() {
        return (4/3) * Math.PI * Math.pow(radius, 3);
    }
    
}
