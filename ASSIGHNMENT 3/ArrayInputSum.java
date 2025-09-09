import java.util.Scanner;

public class ArrayInputSum {
    public static void main(String[] args) {
        
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        Scanner scanner = new Scanner(System.in);

        
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double input = scanner.nextDouble();

            
            if (input <= 0) {
                break;
            }

            
            if (index == 10) {
                System.out.println("Array is full (10 values).");
                break;
            }

            
            numbers[index] = input;
            index++;
        }

        
        System.out.println("\nEntered values:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        // Show total
        System.out.println("\nTotal of entered numbers: " + total);

        // Close scanner
        scanner.close();
    }
}
 


