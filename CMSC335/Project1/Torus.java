public class Torus extends ThreeDimensionalShape {
    private double R;
    private double r;

    public Torus(double R, double r) {
        super();
        this.R = R;
        this.r = r;
    }

    public double getVolume() {
        return (Math.PI * Math.pow(r, 2)) * 2 * Math.PI * R;
    }
    
}
