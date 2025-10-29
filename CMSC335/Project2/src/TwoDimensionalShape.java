/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-2025
 * CMSC 335 Project 1
 * 
 * The TwoDimensionalShape class which extends Shape is the base class for any two dimensional shape.
 */

public abstract class TwoDimensionalShape extends Shape{
    /**
     * Constructs a TwoDimensionalShape object with dimension of 2
     */
    public TwoDimensionalShape(){
        super(2);
    }

    /**
     * Abstract method for calculating the area of a 2d shape.
     * 
     * @return the positive area of the 2d shape
     */
    public abstract double getArea();
}
