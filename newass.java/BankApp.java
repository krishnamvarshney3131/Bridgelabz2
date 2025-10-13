package Abstract;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private boolean hasLoan;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
        this.hasLoan = false;
    }

    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public void applyForLoan(double amount) {
        if (!hasLoan && calculateLoanEligibility()) {
            hasLoan = true;
        }
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private boolean hasLoan;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
        this.hasLoan = false;
    }

    public double calculateInterest() {
        return 0;
    }

    public void applyForLoan(double amount) {
        if (!hasLoan && calculateLoanEligibility()) {
            hasLoan = true;
        }
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

public class BankApp {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("SAV123", "Alice", 8000),
            new CurrentAccount("CUR456", "Bob", 15000)
        };

        for (BankAccount acc : accounts) {
            acc.deposit(2000);
            acc.withdraw(1000);
            double interest = acc.calculateInterest();
            System.out.println("Account: " + acc.getAccountNumber());
            System.out.println("Holder: " + acc.getHolderName());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Interest: " + interest);
            ((Loanable) acc).applyForLoan(5000);
            boolean eligible = ((Loanable) acc).calculateLoanEligibility();
            System.out.println("Loan Eligible: " + eligible);
            System.out.println();
        }
    }
}
