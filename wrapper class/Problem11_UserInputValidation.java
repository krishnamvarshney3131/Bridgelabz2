public class Problem11_UserInputValidation {

    public static boolean isValidAge(String input) {
        try {
            int age = Integer.parseInt(input);
            return age >= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Is '25' valid? " + isValidAge("25"));
        System.out.println("Is '17' valid? " + isValidAge("17"));
        System.out.println("Is 'abc' valid? " + isValidAge("abc"));
        System.out.println("Is '18' valid? " + isValidAge("18"));
    }
}
