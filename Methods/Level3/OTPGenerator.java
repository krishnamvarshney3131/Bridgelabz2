public class OTPGenerator {
    public static void main(String[] args) {
        System.out.println("Generating 10 OTP numbers:");

        int[] otpNumbers = new int[10];
        for (int i = 0; i < 10; i++) {
            otpNumbers[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otpNumbers[i]);
        }

        boolean isUnique = checkUnique(otpNumbers);
        System.out.println("All OTPs are unique: " + isUnique);
    }

    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    public static int[] saveOTP(int[] otps) {
        return otps.clone();
    }

    public static boolean checkUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}