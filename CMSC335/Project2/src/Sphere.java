/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-2025
 * CMSC 335 Project 1
 * 
 * This class represents a sphere, a specific type of three-dimensional shape.
 * It extends the ThreeDimensionalShape class and provides an implementation
 * for calculating the volume of the sphere.
 */
public class Sphere extends ThreeDimensionalShape {
    private double radius;
    /**
     * Constructor for Sphere class.
     */
    public Sphere(double radius) {
        super();
        this.radius = radius;
    }

    /**
     * Calculates and returns the volume of the sphere.
     * 
     * @return the volume of the sphere
     */
    @Override
    public double getVolume() {
        return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
    }
    
}
