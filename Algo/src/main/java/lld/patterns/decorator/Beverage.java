package lld.patterns.decorator;

public abstract class Beverage {
    public abstract int cost();
    public String getDescription(){
        System.out.println("This is Beverage");
        return "This is Beverage";
    }
}
