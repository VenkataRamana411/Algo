package lld.patterns.decorator;

public class Ginger extends AddOnDecorator {
    private Beverage beverage;
    public Ginger(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return this.beverage.cost() + 2;
    }
}
