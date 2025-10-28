/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-2025
 * CMSC 335 Project 1
 * 
 * Abstract class representing a three-dimensional shape.
 * The ThreeDimensionalShape class extends Shape and serves as the base class for any three-dimensional shape.
 */

public abstract class ThreeDimensionalShape extends Shape {
    /**
     * Constructs a ThreeDimensionalShape object with dimension of 3
     */
    
    public ThreeDimensionalShape() {
        super(3);
    }

    /**
     * Abstract method for calculating the volume of a 3d shape.
     * 
     * @return the positive volume of the 3d shape
     */
    public abstract double getVolume();
}