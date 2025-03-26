package lld.patterns.strategy.flyStrategy;

public class SimpleFlyStrategy implements IFlyBehaviour {

    @Override
    public void fly() {
        System.out.println("Let's fly simply");
    }
}
