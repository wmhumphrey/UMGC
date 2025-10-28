/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-2025
 * CMSC 335 Project 1
 * 
 * This class represents a rectangle, a specific type of two-dimensional shape.
 * It extends the TwoDimensionalShape class and provides an implementation
 * for calculating the area of a rectangle.
 */

public class Rectangle extends TwoDimensionalShape {
    private double length;
    private double width;
    /**
     * Constructor for Rectangle class.
     */
    public Rectangle(double length, double width) {
        super();
        this.length = length;
        this.width =  width;
    }
    /**
     * Calculates and returns the area of the rectangle.
     * 
     * @return the area of the rectangle
     */
    @Override
     public double getArea() {
        return length * width;
    }
}