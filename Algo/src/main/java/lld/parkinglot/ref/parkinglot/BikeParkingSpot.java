package lld.parkinglot.ref.parkinglot;

import lld.parkinglot.ref.vehicles.Vehicle;

public class BikeParkingSpot extends ParkingSpot{
    public BikeParkingSpot(int spotNumber) {
        super(spotNumber,"Bike");
    }

    @Override
    public Boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equals("Bike");
    }
}
