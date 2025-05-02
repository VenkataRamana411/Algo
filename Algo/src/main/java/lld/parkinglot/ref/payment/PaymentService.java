package lld.parkinglot.ref.payment;

import java.util.Scanner;

public class PaymentService {

    private Scanner scanner;

    public PaymentService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processPayment(double amount){
        choosePaymentMethod(amount);
    }

    public void choosePaymentMethod(double amount){
        System.out.println("Total Fee: " + amount);
        System.out.println("Choose payment method:");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Cash");
        int option = scanner.nextInt();
        Payment payment;
        switch (option){
            case 1:
                payment = new Payment(amount,new UPIStrategy());
                break;
            case 2:
                payment = new Payment(amount,new CardStrategy());
                break;
            case 3:
                payment = new Payment(amount,new CashStrategy());
                break;
            default:
                System.out.println("Invalid choice. Please pay via cash");
                payment = new Payment(amount,new CashStrategy());
                break;
        }
        payment.processPayment();
    }
}
