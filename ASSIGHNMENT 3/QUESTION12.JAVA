import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        // Define an array of 5 integers
        int[] numbers = new int[5];
        Scanner scanner = new Scanner(System.in);

        // Input 5 numbers from user
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n--- Number Analysis ---");

        // Analyze each number
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println("Number " + num + " is positive and even.");
                } else {
                    System.out.println("Number " + num + " is positive and odd.");
                }
            } else if (num < 0) {
                System.out.println("Number " + num + " is negative.");
            } else {
                System.out.println("Number is zero.");
            }
        }

        // Compare first and last element
        int first = numbers[0];
        int last = numbers[4];

        System.out.println("\n--- First and Last Element Comparison ---");
        if (first == last) {
            System.out.println("First and last elements are equal (" + first + ").");
        } else if (first > last) {
            System.out.println("First element (" + first + ") is greater than last element (" + last + ").");
        } else {
            System.out.println("First element (" + first + ") is less than last element (" + last + ").");
        }

        // Close scanner
        scanner.close();
    }
}

