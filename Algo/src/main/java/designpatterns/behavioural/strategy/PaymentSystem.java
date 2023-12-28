package designpatterns.behavioural.strategy;

public class PaymentSystem {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(int amount){
        paymentStrategy.pay(amount);
    }
}
