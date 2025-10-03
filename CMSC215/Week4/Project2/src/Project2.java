/**
 * Name: Wyatt Humphrey
 * Data: 1/29/25
 * Purpose: This program reads data from students.txt. Then loads an arrayList of student objects with their respective
 * subclasses based on what type they are. Then the program calculates the GPA threshold based on the midpoint GPA of
 * students. Then program returns a formated string of all eligible students for the honor society.
 */
import java.io.*;
import java.util.*;

public class Project2 {
    public static void main(String[] args) {

        ArrayList<Student> studentList = new ArrayList<>();
        double totalGpa = 0.0;
        int studentCount = 0;

        try (Scanner scanner = new Scanner(new File("src/students.txt"))) {
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] segments = line.split(" ", 4);

                String name = segments[0];
                double credits = Double.parseDouble(segments[1]);
                double qualityPts = Double.parseDouble(segments[2]);
                String type = segments[3];

                if(type.equals("Freshman") || type.equals("Sophomore") || type.equals("Junior") || type.equals("Senior")) {
                    Undergraduate undergrad = new Undergraduate(name, credits, qualityPts, type);
                    studentList.add(undergrad);
                    totalGpa += undergrad.gpa();
                    studentCount++;

                } else if (type.equals("Masters") || type.equals("Doctorate")) {
                    Graduate graduate = new Graduate(name, credits, qualityPts, type);
                    studentList.add(graduate);
                    totalGpa += graduate.gpa();
                    studentCount++;
                }
           }

        } catch (FileNotFoundException e) {
            System.out.print("File not found: "+ e);
            System.exit(1);
        }

        double averageGpa = totalGpa / studentCount;
        double threshold = (averageGpa + 4.00) / 2.00;
        Student.setGpaThreshold(threshold);
        System.out.printf("GPA threshold for membership is: %.2f\n", threshold);

        for (Student student : studentList) {
            if (student.eligibleForHonorSociety()) {
                System.out.println(student);
            }
        }
    }
}
