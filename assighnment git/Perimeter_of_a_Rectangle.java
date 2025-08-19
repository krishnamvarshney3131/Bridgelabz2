import java.util.Scanner;

public class Perimeter_of_a_Rectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int width = input.nextInt();
        input.close();
        int Perimeter = 2 * (length + width);
        System.out.println(Perimeter);
    }
    
}
