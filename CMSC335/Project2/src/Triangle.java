/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-2025
 * CMSC 335 Project 1
 * 
 * This class represents a triangle, a specific type of two-dimensional shape.
 * It extends the TwoDimensionalShape class and provides an implementation
 */
public class Triangle extends TwoDimensionalShape {
    private double base;
    private double height;

    /**
     * Constructor for Triangle class.
     */
    public Triangle(double base, double height) {
        super();
        this.base = base;
        this.height = height;
    }
    
    /**
     * Calculates and returns the area of the triangle.
     * 
     * @return the area of the triangle
     */
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}