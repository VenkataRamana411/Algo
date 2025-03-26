package lld.patterns.strategy.quckStrategy;

public class NoQuackStrategy implements IQuackBehaviour{
    @Override
    public void quack() {
        System.out.println("No quacking !!");
    }
}
