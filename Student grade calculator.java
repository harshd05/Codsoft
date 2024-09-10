
import java.util.Scanner;

public class StudentPerformanceEvaluator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many subjects did you take this semester? ");
        int numSubjects = scanner.nextInt();
        System.out.println("Please enter your marks for each subject (out of 100):");

        int[] scores = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            scores[i] = scanner.nextInt();
        }

        int totalScore = calculateTotalScore(scores);
        double averagePercentage = calculateAveragePercentage(totalScore, numSubjects);
        String grade = determineGrade(averagePercentage);

        System.out.println("\nYour Results:");
        System.out.println("Total Score: " + totalScore);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        scanner.close();
    }

    private static int calculateTotalScore(int[] scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    private static double calculateAveragePercentage(int totalScore, int numSubjects) {
        return (double) totalScore / numSubjects;
    }

    private static String determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A (Excellent)";
        } else if (averagePercentage >= 80) {
            return "B (Good)";
        } else if (averagePercentage >= 70) {
            return "C (Fair)";
        } else if (averagePercentage >= 60) {
            return "D (Pass)";
        } else {
            return "F (Fail)";
        }
    }
}
