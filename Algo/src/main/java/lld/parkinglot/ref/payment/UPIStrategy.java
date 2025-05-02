package lld.parkinglot.ref.payment;

public class UPIStrategy implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        System.out.println(amount + " Paid through UPI");
    }
}
