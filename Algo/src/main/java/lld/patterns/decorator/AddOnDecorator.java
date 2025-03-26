package lld.patterns.decorator;

public abstract class AddOnDecorator extends Beverage{

    private Beverage beverage;
    public abstract int cost();
}
