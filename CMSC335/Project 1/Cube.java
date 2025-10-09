public class Cube extends ThreeDimensionalShape {
    private double length;
    private double width;
    private double height;

    public Cube(double length, double width, double height){
        super();

        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getVolume() {
        return length * width * height;
    }
    
}
