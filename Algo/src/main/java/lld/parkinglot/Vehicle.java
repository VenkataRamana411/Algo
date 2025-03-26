package lld.parkinglot;

public class Vehicle {
    private VehicleType vehicleType;
    private String type;
    private String registrationNumber;
    private String color;

    public Vehicle(VehicleType vehicleType,String type, String registrationNumber, String color) {
        this.vehicleType = vehicleType;
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }
}
