/**
 * @author Wyatt Humphrey
 * @version 1.0
 * Date: 10-28-2025
 * CMSC 335 Project 1
 * 
 * This class represents a torus, a specific type of three-dimensional shape.
 * It extends the ThreeDimensionalShape class and provides an implementation
 * for calculating the volume of the torus.
 */
public class Torus extends ThreeDimensionalShape {
    private double R;
    private double r;
    /**
     * Constructor for Torus class.
     */
    public Torus(double R, double r) {
        super();
        this.R = R;
        this.r = r;
    }
    /**
     * Calculates and returns the volume of the torus.
     * 
     * @return the volume of the torus
     */
    @Override
    public double getVolume() {
        return (Math.PI * Math.pow(r, 2)) * 2 * Math.PI * R;
    }
    
}
