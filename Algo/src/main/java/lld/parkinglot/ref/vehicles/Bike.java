package lld.parkinglot.ref.vehicles;

public class Bike extends Vehicle {
    private static final double RATE = 5.0;

    public Bike(String licensePlate) {
        super(licensePlate, "Bike");
    }

    @Override
    public double calculateFee(int hoursStayed) {
        return hoursStayed * 10;
    }
}
