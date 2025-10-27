public class Cube extends ThreeDimensionalShape {
    private double length;

    public Cube(double length){
        super();
        this.length = length;
    }

    public double getVolume() {
        return length * length * length;
    }
    
}
