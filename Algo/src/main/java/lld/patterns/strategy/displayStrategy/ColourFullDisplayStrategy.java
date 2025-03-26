package lld.patterns.strategy.displayStrategy;

public class ColourFullDisplayStrategy implements IDisplayBehaviour{
    @Override
    public void display() {
        System.out.println("ColourFull Display");
    }
}
