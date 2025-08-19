import java.util.Scanner;

public class Convert_Kilometers_to_Miles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float Kilometers = input.nextInt();
        input.close();
        double Miles = Kilometers * 0.621371;
        System.out.println(Miles);
    }
    
}
