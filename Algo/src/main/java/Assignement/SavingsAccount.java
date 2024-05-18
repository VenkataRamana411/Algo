package Assignement;

public class SavingsAccount extends BankAccount{

    private double interestRate;
    private double balance;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest accrued: " + interest + " units. Current balance: " + balance + " units");
    }
}
