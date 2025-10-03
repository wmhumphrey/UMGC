/**
 * Name: Wyatt Humphrey
 * Data: 1/29/25
 * Purpose: Generate a Student object with the attributes, name, credit hours, and quality points. Includes methods for
 * determining GPA and eligibility for honor society.
 */
public class Student {
    private String name;
    private double credits;
    private  double qualityPts;
    private static double gpaThreshold;

    /**
     * Constructs Student object
     * @param name student's name
     * @param credits student's credit hours
     * @param qualityPts student's quality points
     */
    public Student(String name, double credits, double qualityPts) {
        this.name = name;
        this.credits = credits;
        this.qualityPts =  qualityPts;
    }

    /**
     * Computes GPA of student
     * @return calculated GPA
     */
    public double gpa() {
        if (credits == 0) return 0.00;
        return qualityPts / credits ;
    }

    /**
     * Determines if student is eligible for honor society
     * @return true if student's GPA meets threshold
     */
    public boolean eligibleForHonorSociety() {
        return  gpa() >= gpaThreshold;
    }

    /**
     * Returns string representation of student
     * @return formatted string with student's name and gpa
     */
    @Override
    public String toString() {
        return "Name: " + name + " GPA: " +  String.format("%.2f", gpa());
    }

    /**
     * Sets GPA threshold
     * @param threshold minimum GPA required
     */
    public static void setGpaThreshold(double threshold) {
        gpaThreshold = threshold;
    }
}
