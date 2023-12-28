package designpatterns.behavioural.strategy;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Please Press :  \n1 : UPI \n2 : Credit Card \n3 : Paypal ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        PaymentSystem paymentSystem = new PaymentSystem();
        if (input == 1){
            paymentSystem.setPaymentStrategy(new UPI());
        } else if (input == 2) {
            paymentSystem.setPaymentStrategy(new CreditCard());
        } else if (input == 3) {
            paymentSystem.setPaymentStrategy(new PayPal());
        }else {
            System.out.println("Invalid option!!");
        }
        paymentSystem.pay(1000);
    }
}
