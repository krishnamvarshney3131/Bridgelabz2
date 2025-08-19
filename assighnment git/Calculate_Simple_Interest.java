import java.util.Scanner;

public class Calculate_Simple_Interest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Principal = input.nextInt();
        int Rate = input.nextInt();
        int Time = input.nextInt();
        input.close();
        float Simple_Interest = (Principal * Rate * Time) / 100;
        System.out.println(Simple_Interest);
    }
    
}
