public class Problem14_BankTransactionLimits {

    public static double getRemainingLimit(Double dailyLimit, double withdrawal) {
        if (dailyLimit == null) {
            return 0.0;
        }
        return dailyLimit - withdrawal;
    }

    public static void main(String[] args) {
        Double limit1 = 1000.0;
        Double limit2 = null;

        System.out.println("Remaining for user 1: " + getRemainingLimit(limit1, 250.0));
        System.out.println("Remaining for user 2: " + getRemainingLimit(limit2, 100.0));
    }
}
