import java.util.Scanner;

public class FootballTeamMeanHeight {
    public static void main(String[] args) {
        
        double[] heights = new double[11];
        double sum = 0.0;

        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter the height of 11 football players (in cm or meters):");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i]; 
        }

        
        double mean = sum / heights.length;


        System.out.println("\nMean height of the football team: " + mean);

        
        scanner.close();
    }
}
