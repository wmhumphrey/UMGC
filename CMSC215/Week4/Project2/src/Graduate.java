/**
 * Name: Wyatt Humphrey
 * Data: 1/29/25
 * Purpose: Generates a Graduate object which is a subclass of Student.
 */
public class Graduate extends Student {
    private String degree;

    /**
     * Constructs a Graduate student object
     * @param name student's name
     * @param credits student's credit hours
     * @param qualityPts student's quality points
     * @param degree student's degree type
     */
    public Graduate(String name, double credits, double qualityPts, String degree) {
        super(name, credits, qualityPts);
        this.degree = degree;
    }

    /**
     * Determines if student is eligible for honor society
     * @return true if students GPA and degree type meet requirements
     */
    @Override
    public boolean eligibleForHonorSociety() {
        return super.eligibleForHonorSociety() && (degree.equals("Masters"));
    }

    /**
     * Returns string representation of Graduate object
     * @return formated string for Graduate object
     */
    @Override
    public String toString() {
        return super.toString() + " " + degree;
    }
}
