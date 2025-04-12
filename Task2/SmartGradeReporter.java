import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SmartGradeReporter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] subjectNames = new String[subjects];
        int[] marks = new int[subjects];
        int total = 0;

        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter subject name " + (i + 1) + ": ");
            subjectNames[i] = sc.nextLine();

            System.out.print("Enter marks for " + subjectNames[i] + " (out of 100): ");
            marks[i] = sc.nextInt();
            sc.nextLine(); // consume newline
            total += marks[i];
        }

        double average = (double) total / subjects;
        String grade = getGrade(average);
        String feedback = getFeedback(grade);

        // Display Results
        System.out.println("\n--- Report Card ---");
        System.out.println("Student: " + studentName);
        for (int i = 0; i < subjects; i++) {
            System.out.println(subjectNames[i] + ": " + marks[i] + "/100");
        }
        System.out.println("Total Marks: " + total + "/" + (subjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);
        System.out.println("Feedback: " + feedback);

        // Save to file
        try {
            FileWriter writer = new FileWriter("result.txt");
            writer.write("Student: " + studentName + "\n");
            for (int i = 0; i < subjects; i++) {
                writer.write(subjectNames[i] + ": " + marks[i] + "/100\n");
            }
            writer.write("Total Marks: " + total + "/" + (subjects * 100) + "\n");
            writer.write(String.format("Average Percentage: %.2f%%\n", average));
            writer.write("Grade: " + grade + "\n");
            writer.write("Feedback: " + feedback + "\n");
            writer.close();
            System.out.println("Report saved to result.txt ✅");
        } catch (IOException e) {
            System.out.println("Error saving report.");
        }
    }

    static String getGrade(double avg) {
        if (avg >= 90) return "A+";
        else if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }

    static String getFeedback(String grade) {
        return switch (grade) {
            case "A+" -> "Outstanding performance!";
            case "A" -> "Great job, keep pushing!";
            case "B" -> "Good effort, room for improvement.";
            case "C" -> "Fair, but needs more consistency.";
            case "D" -> "Below average, focus needed.";
            default -> "Poor performance. Seek help and practice.";
        };
    }
}
