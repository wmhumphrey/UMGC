/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-2025
 * CMSC 335 Project 1
 * 
 * This class represents a cylinder, a specific type of three-dimensional shape.
 * It extends the ThreeDimensionalShape class and provides an implementation
 * for calculating the volume of the cylinder.
 */
public class Cylinder extends ThreeDimensionalShape {
    private double radius;
    private double height;
    /**
     * Constructor for Cylinder class.
     */
    public Cylinder(double radius, double height) {
        super();

        this.radius = radius;
        this.height = height;
    }
    /**
     * Calculates and returns the volume of the cylinder.
     * 
     * @return the volume of the cylinder
     */
    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
