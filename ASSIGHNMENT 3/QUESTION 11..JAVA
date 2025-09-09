import java.util.Scanner;

public class VotingEligibilityChecker {
    public static void main(String[] args) {
        // Create an array to store ages of 10 students
        int[] studentAges = new int[10];

        // Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take input for 10 students
        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < studentAges.length; i++) {
