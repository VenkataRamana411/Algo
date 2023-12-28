package designpatterns.behavioural.strategy;

public class CreditCard implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println(amount +" Rupees Paid through Credit card");
    }
}
