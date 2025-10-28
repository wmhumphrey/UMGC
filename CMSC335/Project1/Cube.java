/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-2025
 * CMSC 335 Project 1
 * 
 * This class represents a cube, a specific type of three-dimensional shape.
 * It extends the ThreeDimensionalShape class and provides an implementation
 */
public class Cube extends ThreeDimensionalShape {
    private double length;
    /**
     * Constructor for Cube class.
     */
    public Cube(double length){
        super();
        this.length = length;
    }
    /**
     * Calculates and returns the volume of the cube.
     * 
     * @return the volume of the cube
     */
    @Override
    public double getVolume() {
        return length * length * length;
    }
    
}
