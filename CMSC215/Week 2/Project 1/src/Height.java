/**
 * Name: Wyatt Humphrey
 * Date: 1/21/25
 * Purpose: Height class, takes feet and inches. Has method to convert height to inches.
 */
// Height class
public class Height {
    private final int feet;
    private final int inches;
    // Height constructor
    public Height(int feet, int inches){
        int totalInches = (feet * 12) + inches;
        this.feet = totalInches / 12;
        this.inches = totalInches % 12;
    }
    // Converts height to inches
    public int toInches() {
        return (this.feet * 12) + this.inches;
    }
    @Override
    public String toString() {
        return this.feet + "'" + this.inches + "\"";
    }
}
