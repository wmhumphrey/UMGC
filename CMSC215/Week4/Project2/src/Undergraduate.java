/**
 * Name: Wyatt Humphrey
 * Data: 1/29/25
 * Purpose: Generates an Undergraduate object which is a subclass of Student.
 */
public class Undergraduate extends Student{
    private String year;

    /**
     * Constructs Undergraduate student object
     * @param name student's name
     * @param credits student's credit hours
     * @param qualityPts student's quality points
     * @param year student's year
     */
    public Undergraduate(String name, double credits, double qualityPts, String year) {
        super(name, credits, qualityPts);
        this.year = year;
    }

    /**
     * Determines if student is eligible for honor society
     * @return true if students GPA and year meet requirements
     */
    @Override
    public boolean eligibleForHonorSociety() {
        return  super.eligibleForHonorSociety() && (year.equals("Junior") || year.equals("Senior"));
    }

    /**
     * Returns sting representation of undergraduate
     * @return formated sting with name, gpa, and year
     */
    @Override
    public String toString() {
        return super.toString() + " " + year;
    }
}
