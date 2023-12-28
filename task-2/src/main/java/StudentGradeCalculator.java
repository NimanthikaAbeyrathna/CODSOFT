import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        BigDecimal totalMarks = BigDecimal.ZERO;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in Subject " + i + ": ");
            int subjectMarks = scanner.nextInt();
            totalMarks = totalMarks.add(BigDecimal.valueOf(subjectMarks));
        }

        BigDecimal averagePercentage = totalMarks.divide(BigDecimal.valueOf(numSubjects), 2, RoundingMode.HALF_UP);

        char grade;
        if (averagePercentage.compareTo(new BigDecimal("75")) >= 0) {
            grade = 'A';
        } else if (averagePercentage.compareTo(new BigDecimal("65")) >= 0) {
            grade = 'B';
        } else if (averagePercentage.compareTo(new BigDecimal("45")) >= 0) {
            grade = 'C';
        } else if (averagePercentage.compareTo(new BigDecimal("35")) >= 0) {
            grade = 'S';
        } else {
            grade = 'F';
        }

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
