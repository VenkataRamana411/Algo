package lld.patterns.strategy;

import lld.patterns.strategy.displayStrategy.ColourFullDisplayStrategy;
import lld.patterns.strategy.displayStrategy.SimpleDisplayStrategy;
import lld.patterns.strategy.flyStrategy.JetFlyStrategy;
import lld.patterns.strategy.flyStrategy.NoFlyStrategy;
import lld.patterns.strategy.flyStrategy.SimpleFlyStrategy;
import lld.patterns.strategy.quckStrategy.NoQuackStrategy;
import lld.patterns.strategy.quckStrategy.SimpleQuackStrategy;

public class Runner {
    public static void main(String[] args) {
        SimpleFlyStrategy simpleFlyStrategy = new SimpleFlyStrategy();
        NoFlyStrategy noFlyStrategy = new NoFlyStrategy();
        SimpleDisplayStrategy simpleDisplayStrategy = new SimpleDisplayStrategy();
        ColourFullDisplayStrategy colourFullDisplayStrategy = new ColourFullDisplayStrategy();
        SimpleQuackStrategy simpleQuackStrategy = new SimpleQuackStrategy();
        NoQuackStrategy noQuackStrategy = new NoQuackStrategy();
        Duck normalDuck = new Duck(simpleDisplayStrategy,simpleFlyStrategy,simpleQuackStrategy);
        System.out.println("Normal Duck");
        normalDuck.display();
        normalDuck.quack();
        normalDuck.fly();

        System.out.println("============================");
        Duck rubberDuck = new Duck(colourFullDisplayStrategy,noFlyStrategy,noQuackStrategy);
        System.out.println("Rubber Duck");
        rubberDuck.display();
        rubberDuck.quack();
        rubberDuck.fly();

        System.out.println("============================");
        Duck specialDuck = new Duck(colourFullDisplayStrategy,new JetFlyStrategy(),simpleQuackStrategy);
        System.out.println("Special Duck");
        specialDuck.display();
        specialDuck.quack();
        specialDuck.fly();
    }
}
