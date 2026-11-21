import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = input.nextLine();

        int[] marks = new int[5];

        // Read marks for all 5 subjects and make sure they are between 0 and 100
        for (int i = 0; i < marks.length; i++) {
            while (true) {
                System.out.print("Enter mark for subject " + (i + 1) + " (0-100): ");

                if (!input.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    input.next(); // Clear invalid text input
                    continue;
                }

                int mark = input.nextInt();
                if (mark < 0 || mark > 100) {
                    System.out.println("Mark must be between 0 and 100. Try again.");
                    continue;
                }

                marks[i] = mark;
                break;
            }
        }

        int total = getTotalMarks(marks);
        double average = getAverageMark(total, marks.length);
        int highest = getHighestMark(marks);
        int lowest = getLowestMark(marks);
        String grade = getGrade(average);
        String status = getResultStatus(marks, average);

        displaySummary(studentName, marks, total, average, highest, lowest, grade, status);

        input.close();
    }

    // all subject marks
    public static int getTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    // Cal average mark
    public static double getAverageMark(int total, int subjectCount) {
        return (double) total / subjectCount;
    }

    // Find the highest mark in the array
    public static int getHighestMark(int[] marks) {
        int highest = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
            }
        }
        return highest;
    }

    // Find the lowest mark
    public static int getLowestMark(int[] marks) {
        int lowest = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }
        return lowest;
    }

    // Decide letter grade based on average
    public static String getGrade(double average) {
        if (average >= 75) {
            return "A";
        } else if (average >= 65) {
            return "B";
        } else if (average >= 55) {
            return "C";
        } else if (average >= 45) {
            return "D";
        } else {
            return "F";
        }
    }

    // Fail
    public static String getResultStatus(int[] marks, double average) {
        for (int mark : marks) {
            if (mark < 40) {
                return "FAIL";
            }
        }

        if (average < 45) {
            return "FAIL";
        }

        return "PASS";
    }

    // summary
    public static void displaySummary(String name, int[] marks, int total, double average,int highest, int lowest, String grade, String status) {
        System.out.println("--- Result Summary ---");
        System.out.println("Name    : " + name);
        System.out.print("Marks   : ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i]);
            if (i < marks.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Total   : " + total);
        System.out.printf("Average : %.2f%n", average);
        System.out.println("Highest : " + highest);
        System.out.println("Lowest  : " + lowest);
        System.out.println("Grade   : " + grade);
        System.out.println("Status  : " + status);
    }
}