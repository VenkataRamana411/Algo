package lld.patterns.strategy.flyStrategy;

public class NoFlyStrategy implements IFlyBehaviour {

    @Override
    public void fly() {
        System.out.println("I don't Fly");
    }
}
