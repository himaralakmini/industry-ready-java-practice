import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = input.nextLine();

        int[] marks = new int[5];

        for (int i = 0; i < marks.length; i++) {
            while (true) {
                System.out.print("Enter mark for subject " + (i + 1) + " (0-100): ");

                if (!input.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    input.next(); 
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
