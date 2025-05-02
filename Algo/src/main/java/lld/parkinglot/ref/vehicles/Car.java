package lld.parkinglot.ref.vehicles;

public class Car extends Vehicle {
    private static final double RATE = 10.0;

    public Car(String licensePlate) {
        super(licensePlate, "Car");
    }

    @Override
    public double calculateFee(int hoursStayed) {
        return hoursStayed * 10;
    }
}
