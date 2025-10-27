/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-2025
 * CMSC 335 Project 1
 * 
 * Shape class represents abstract class for all geometric shapes.
 */


public abstract class Shape {
    private final int dimensions;

    /**
     * Constructs a generic shape object
     * 
     * @param dimensions number of dimensions of the shape
     */
    public Shape(int dimensions){
        this.dimensions = dimensions;
    } 

    /**
     * Getter for shape dimensions
     * 
     * @return number of dimensions
     */
    public int getDimensions(){
        return dimensions;
    }
}
