package lld.parkinglot.ref.vehicles;

public abstract class Vehicle {
    private String licensePlate;

    private String vehicleType;

    public Vehicle(String licensePlate, String vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public abstract double calculateFee(int hoursStayed);
}
