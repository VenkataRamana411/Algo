package lld.parkinglot.ref.parkinglot;

import lld.parkinglot.ref.vehicles.Vehicle;

public class CarParkingSpot extends ParkingSpot{
    public CarParkingSpot(int spotNumber) {
        super(spotNumber,"Car");
    }

    @Override
    public Boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equals("Car");
    }
}
