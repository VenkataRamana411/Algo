package lld.parkinglot.ref.parkinglot;

import lld.parkinglot.ref.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {

    private List<ParkingSpot> parkingSpots;
    private int floorNumber;

    public ParkingFloor(int floorNumber, int totalCarSpots, int totalBikeSpots) {
        this.floorNumber = floorNumber;
        int i = 1;
        parkingSpots = new ArrayList<>();
        while (i++ < totalCarSpots) {
            parkingSpots.add(new CarParkingSpot(i));
        }
        while (i++ < totalCarSpots + totalBikeSpots) {
            parkingSpots.add(new CarParkingSpot(i));
        }
    }

    public ParkingSpot findAvailableSpot(String vehicleType) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isOccupied() && spot.getSpotType().equals(vehicleType)) {
                return spot;
            }
        }
        System.out.println("No spots are available on the floor " + floorNumber + " for " + vehicleType);
        return null;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
