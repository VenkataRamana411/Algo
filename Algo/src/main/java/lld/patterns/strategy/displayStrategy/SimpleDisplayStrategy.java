package lld.patterns.strategy.displayStrategy;

public class SimpleDisplayStrategy implements IDisplayBehaviour{
    @Override
    public void display() {
        System.out.println("Display Simply");
    }
}
