package designpatterns.behavioural.strategy;

public class PayPal implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println(amount +" Rupees Paid through Paypal");
    }
}
