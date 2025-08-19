import java.util.Scanner;

public class Power_Calculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int base = input.nextInt();
        int exponent = input.nextInt();
        input.close();
        double result = Math.pow(base, exponent);
        System.out.println(result);
    }
    
}
