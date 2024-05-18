package Assignement;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " units. Current balance: " + balance + " units");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " units. Current balance: " + balance + " units");
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void displayInfo() {
        System.out.println("Account Balance: " + balance + " units");
    }
}
