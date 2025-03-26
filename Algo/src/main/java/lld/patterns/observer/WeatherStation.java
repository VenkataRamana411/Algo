package lld.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements IObservable{

    private int temperature = 0;
    private final List<IObserver> observersList = new ArrayList<>();
    @Override
    public void add(IObserver observer) {
        observersList.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observersList.remove(observer);
    }

    @Override
    public void notify1() {
        System.out.println("===== Notifications sent ====");
        for (IObserver observer : observersList){
            observer.update();
        }
    }

    //Method to get temperature at any point of time
    public int getTemperature() {
        return temperature;
    }

    //just to update it for example purpose
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Temperature Updated");
        notify1();
    }
}
