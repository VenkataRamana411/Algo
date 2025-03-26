package lld.patterns.strategy;

import lld.patterns.strategy.displayStrategy.IDisplayBehaviour;
import lld.patterns.strategy.flyStrategy.IFlyBehaviour;
import lld.patterns.strategy.quckStrategy.IQuackBehaviour;

public class Duck {
    private IDisplayBehaviour displayBehaviour;
    private IFlyBehaviour flyBehaviour;
    private IQuackBehaviour quackBehaviour;

    public Duck(IDisplayBehaviour displayBehaviour, IFlyBehaviour flyBehaviour, IQuackBehaviour quackBehaviour) {
        this.displayBehaviour = displayBehaviour;
        this.flyBehaviour = flyBehaviour;
        this.quackBehaviour = quackBehaviour;
    }

    //If there is a common method we can go with Abstract class approach as well

    public void setFlyBehaviour(IFlyBehaviour flyBehaviour){
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(IQuackBehaviour quackBehaviour){
        this.quackBehaviour = quackBehaviour;
    }

    public void display(){
        displayBehaviour.display();
    }
    public void fly(){
        flyBehaviour.fly();
    }
    public void quack(){
        quackBehaviour.quack();
    }
}
