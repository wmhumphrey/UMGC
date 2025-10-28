/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-2025
 * CMSC 335 Project 1
 * 
 * This class represents a cone, a specific type of three-dimensional shape.
 * It extends the ThreeDimensionalShape class and provides an implementation
 * for calculating the volume of the cone.
 */
public class Cone extends ThreeDimensionalShape {
    private double height;
    private double radius;

    /**
     * Constructor for Cone class.
     */
    public Cone(double height, double radius) {
        super();
        this.height = height;
        this.radius = radius;
    }

    /**
     * Calculates and returns the volume of the cone.
     * 
     * @return the volume of the cone
     */
    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) *(height / 3);
    }
}
