package lld.parkinglot.ref.parkinglot;

import lld.parkinglot.ref.vehicles.Vehicle;

public abstract class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Vehicle vehicle;
    private String spotType;

    public ParkingSpot(int spotNumber, String spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
    }

    public abstract Boolean canParkVehicle(Vehicle vehicle);

    public void ParkVehicle(Vehicle vehicle) {
        if (canParkVehicle(vehicle) && !isOccupied()) {
            System.out.println("Vehicle Parked on the spot: " + spotNumber);
            this.vehicle = vehicle;
            isOccupied = true;
        } else {
            System.out.println("Can't Park Vehicle");
        }

    }

    public void vacate() {
        if (isOccupied()) {
            System.out.println("UnParking Vehicle at spot: " + spotNumber);
            this.vehicle = null;
            isOccupied = false;
        } else {
            System.out.println("Spot is empty");
        }
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getSpotType() {
        return spotType;
    }
}
