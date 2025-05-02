package lld.parkinglot.ref.payment;

public class Payment {
    private double amount;
    private PaymentStrategy paymentStrategy;

    public Payment(double amount, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(){
        if (amount > 0){
            paymentStrategy.processPayment(this.amount);
        }else {
            System.out.println("Invalid Payment");
        }
    }

}
