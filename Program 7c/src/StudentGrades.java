import java.util.Scanner;
import java.util.HashMap;

public class StudentGrades {

    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);
        String studentName;
        double studentGrade;

        HashMap<String, Double> studentGrades = new HashMap<String, Double>();

        // Students's grades (pre-entered)
        studentGrades.put("Harry Rawlins", 84.3);
        studentGrades.put("Stephanie Kong", 91.0);
        studentGrades.put("Shailen Tennyson", 78.6);
        studentGrades.put("Quincy Wraight", 65.4);
        studentGrades.put("Janine Antinori", 98.2);

        // TODO: Read in new grade for a student, output initial
        //       grade, replace with new grade in HashMap,
        //       output new grade
        //System.out.print("Enter student's name: ");
        studentName = scnr.nextLine();

        // Output initial grade
        System.out.println(studentName + "'s original grade: " + studentGrades.get(studentName));

        // Read in new grade for the student
        System.out.print("Enter " + studentName + "'s new grade: ");
        studentGrade = scnr.nextDouble();

        // Replace original grade with new grade in HashMap
        studentGrades.put(studentName, studentGrade);

        // Output new grade
        //System.out.println(studentName + "'s new grade: " + studentGrades.get(studentName));

    }
}
