package lld.parkinglot.ref.parkinglot;

import lld.parkinglot.ref.vehicles.Vehicle;

import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle){
//        for (ParkingFloor floor : parkingFloors){
//            ParkingSpot availableSpot = floor.findAvailableSpot(vehicle);
//            if(availableSpot != null){
//                System.out.println("Spot: " + availableSpot.getSpotNumber() +" available on the Floor " + floor.getFloorNumber());
//                return availableSpot;
//            }
//        }
//        System.out.println("No Spots available");
//        return null;
        return parkingFloors.stream()
                .map(floor -> Map.entry(floor, floor.findAvailableSpot(vehicle.getVehicleType())))
                .filter(entry -> entry.getValue() != null)
                .findFirst()
                .map(entry -> {
                    System.out.println("Spot: " + entry.getValue().getSpotNumber() +
                            " available on the Floor " + entry.getKey().getFloorNumber());
                    return entry.getValue();
                })
                .orElseGet(() -> {
                    System.out.println("No Spots available");
                    return null;
                });
    }
    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot availableSpot = findAvailableSpot(vehicle);
        if (availableSpot != null){
            availableSpot.ParkVehicle(vehicle);
            return availableSpot;
        }else {
            return null;
        }
    }
    public void vacateSpot(ParkingSpot spot,Vehicle vehicle){
        if (spot != null && spot.isOccupied() && spot.getVehicle().equals(vehicle)){
            System.out.println("Vehicle got Vacated");
            spot.vacate();
        }
        System.out.println("Details are not matching");
    }

    public ParkingSpot getSpotByNumber(int spotNumber){
        return parkingFloors.stream()
                .map(floor -> floor.getParkingSpots().get(spotNumber))
                .filter(spot -> spot != null)
                .findFirst()
                .orElseGet(null);
//        for (ParkingFloor floor : parkingFloors){
//            ParkingSpot spot = floor.getParkingSpots().get(spotNumber);
//            if (spot != null){
//                return spot;
//            }
//        }
//        return null;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }
}
