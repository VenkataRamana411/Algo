package lld.patterns.strategy.quckStrategy;

public class SimpleQuackStrategy implements IQuackBehaviour{
    @Override
    public void quack() {
        System.out.println("Quacking simply");
    }
}
