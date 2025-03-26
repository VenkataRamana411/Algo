package lld.patterns.decorator;

public class Runner {
    public static void main(String[] args) {
        System.out.print("Coffee: 10\nTea: 5\nHorlicks: 10\nGinger:: 2\n");
        System.out.println("===================");
        Coffee coffee = new Coffee();
        System.out.println("Plain Coffee : "+coffee.cost());
        Horlicks horlicks = new Horlicks(coffee);
        System.out.println("Coffee with Horlicks : "+horlicks.cost());
        Ginger ginger = new Ginger(horlicks);
        System.out.println("Coffee with Horlicks and Ginger : "+ginger.cost());
        Ginger gingerTea = new Ginger(new Tea());
        System.out.println("Ginger Tea : " + gingerTea.cost());
    }
}
