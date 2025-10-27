/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-2025
 * CMSC 335 Project 1
 * 
 * Represents a two-dimensional circle defined by its radius.
 * Extends TwoDimensionalShape and provides geometric operations for a circle.
 *
 */

public class Circle extends TwoDimensionalShape {
    private double radius;
    
    /**
     * Creates a Circle instance with the specified radius.
     *
     * @param radius the radius of the circle (should be non-negative)
     * 
     */
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    /**
     * Calculates and returns the area of the circle.
     * 
     * @return the area of the circle
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
