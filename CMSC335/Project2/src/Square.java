/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-25
 * CMSC 335 Project 1
 * 
 * Class to represent a 2D square object. 
 * Contains method for calculating the area.
 */


public class Square extends TwoDimensionalShape {
    private double length;

    /**
     * Constructs a sqaure object.
     * 
     * @param length length of a side of the square
     */
    public Square(double length) {
        super();
        this.length = length;
    }

    /**
     * Calculates the area of a square by square the length of a side
     * 
     * @return the area of the square
     */
    @Override
    public double getArea() {
        return length * length;
    }
}