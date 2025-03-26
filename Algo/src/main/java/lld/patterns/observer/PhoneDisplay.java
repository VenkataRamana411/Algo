package lld.patterns.observer;

public class PhoneDisplay implements IObserver {

    private final WeatherStation weatherStation;

    public PhoneDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        System.out.println("Update from station :: Phone ::Current temperature - " + this.weatherStation.getTemperature());
    }
}
