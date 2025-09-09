import java.util.Scanner;

public class FactorsFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a number to find its factors: ");
        int number = scanner.nextInt();

        // Initial capacity for factors array
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;  // Tracks number of factors stored

        // Loop from 1 to number to find factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {  // i is a factor
                // Check if array needs to be resized
                if (index == maxFactor) {
                    // Double the size of the array
                    maxFactor *= 2;
                    int[] temp = new int[maxFactor];
                    // Copy old factors into new larger array
                    for (int j = 0; j < index; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp;  // Re-assign reference
                }
                // Add the factor to the array
                factors[index++] = i;
            }
        }

        // Display the factors
        System.out.println("\nFactors of " + number + " are:");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        // Close scanner
        scanner.close();
    }
}

