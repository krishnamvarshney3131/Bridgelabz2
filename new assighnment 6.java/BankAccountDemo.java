
class BankAccount {
    
    private static String bankName = "State Bank of India";
    private static int totalAccounts = 0;

    private String accountHolderName;
    private final int accountNumber;  

    
    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;  
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    
    public static void getTotalAccounts() {
        System.out.println("Total Accounts in " + bankName + " = " + totalAccounts);
    }

    
    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        } else {
            System.out.println("Not a valid BankAccount object.");
        }
    }
}


public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Rahul Sharma", 101);
        BankAccount acc2 = new BankAccount("Priya Verma", 102);

        
        acc1.displayDetails();
        System.out.println("--------------------");
        acc2.displayDetails();

        System.out.println("--------------------");
        
        BankAccount.getTotalAccounts();
    }
}

