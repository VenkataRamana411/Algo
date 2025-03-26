package lld.patterns.decorator;

public class Horlicks extends AddOnDecorator {
    private Beverage beverage;
    public Horlicks(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {

        return this.beverage.cost() + 10;
    }
}
