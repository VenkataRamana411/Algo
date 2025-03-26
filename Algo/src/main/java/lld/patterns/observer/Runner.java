package lld.patterns.observer;

public class Runner {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay(weatherStation);
        weatherStation.add(phoneDisplay);
        weatherStation.setTemperature(20);
        WindowDisplay windowDisplay = new WindowDisplay(weatherStation);
        weatherStation.add(windowDisplay);
        weatherStation.setTemperature(26);
        weatherStation.setTemperature(30);
    }
}
