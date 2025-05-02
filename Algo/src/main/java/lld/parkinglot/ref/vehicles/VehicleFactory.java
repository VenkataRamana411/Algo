package lld.parkinglot.ref.vehicles;

public class VehicleFactory {

    public static Vehicle createVehicle(String vehicleType, String licencePlate) {
        if (vehicleType.equals("Car")) {
            return new Car(licencePlate);
        } else if (vehicleType.equals("Bike")) {
            return new Bike(licencePlate);
        }
        System.out.println("Vehicle Type not supported");
        return null;
    }
}
