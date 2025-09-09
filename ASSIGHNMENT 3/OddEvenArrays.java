import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input number from user
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        // Check if input is a natural number (positive integer)
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number greater than 0.");
            scanner.close();
            return;
        }

        // Create arrays to store odd and even numbers
        int size = number / 2 + 1; // max possible size for odd or even numbers
        int[] oddNumbers = new int[size];
        int[] evenNumbers = new int[size];

        // Index variables for odd and even arrays
        int oddIndex = 0, evenIndex = 0;

        // Loop from 1 to number and separate odd/even into arrays
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i;
            } else {
                oddNumbers[oddIndex++] = i;
            }
        }

        // Print odd numbers
        System.out.println("\nOdd numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        // Print even numbers
        System.out.println("\n\nEven numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }

        // Close scanner
        scanner.close();
    }
}

