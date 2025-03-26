package lld.patterns.observer;

public class WindowDisplay implements IObserver {

    private WeatherStation weatherStation;

    public WindowDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    //We can remove reference to weatherStation if we know what observer wants from object so we can define as a parameter
    @Override
    public void update() {
        System.out.println("Update from station :: Window :: Current temperature - " + this.weatherStation.getTemperature());
    }
}
