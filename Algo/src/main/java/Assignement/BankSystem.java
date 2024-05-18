package Assignement;

import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a savings account with an initial balance of 1000 units and an interest rate of 5%
        SavingsAccount savingsAccount = new SavingsAccount(1000, 0.05);

        // Deposit 500 units into the savings account
        savingsAccount.deposit(500);

        // Withdraw 200 units from the savings account
        savingsAccount.withdraw(200);

        // Display the account information
        savingsAccount.displayInfo();

        // Calculate and display the interest accrued
        savingsAccount.calculateInterest();

        scanner.close();
    }
}
