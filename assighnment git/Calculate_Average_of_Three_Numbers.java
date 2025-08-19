import java.util.Scanner;

public class Calculate_Average_of_Three_Numbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        input.close();
        System.out.println((a+b+c)/3);
    }
    
}
