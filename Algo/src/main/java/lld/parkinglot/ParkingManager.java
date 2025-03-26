package lld.parkinglot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingManager {

    String lotID;
    ParkingLot parkingLot = null;
    Map<String, Map<Integer, Integer>> parkingViewMap;

    public void createLot(String lotID, int floors, int slots) {
        this.lotID = lotID;
        int[][] lot = new int[floors + 1][slots + 1];
        for (int[] floor : lot) {
            Arrays.fill(floor, 5);
            floor[0] = 10;
            floor[1] = 2;
            floor[2] = 2;
        }
        Arrays.fill(lot[0], -1);
        parkingLot = new ParkingLot(lot);
        parkingViewMap = new HashMap<>();
        HashMap<Integer, Integer> truckMap = new HashMap<>();
        HashMap<Integer, Integer> carMap = new HashMap<>();
        HashMap<Integer, Integer> bikeMap = new HashMap<>();
        for (int i = 1; i <= floors; i++) {
            truckMap.put(i, 1);
            bikeMap.put(i, 2);
            carMap.put(i, slots - 3);
        }
        parkingViewMap.put("Truck", truckMap);
        parkingViewMap.put("Car", carMap);
        parkingViewMap.put("Bike", bikeMap);
    }

    public void displayFreeSlots(String vehicle, int floor) {
        int slots = -1;
        switch (vehicle) {
            case "Truck":
                slots = parkingViewMap.get("Truck").get(floor);
                break;
            case "Car":
                slots = parkingViewMap.get("Car").get(floor);
                break;
            case "Bike":
                slots = parkingViewMap.get("Bike").get(floor);
                break;
        }
        if (slots == -1) {
            System.out.println("Invalid Vehicle Type");
        } else {
            System.out.println("No. of free slots for " + vehicle + " on Floor " + floor + ": " + slots);
        }
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        int start = 0, end = 0;
        switch (vehicle.getType()) {
            case "Truck":
                start = 1;
                end = 1;
                break;
            case "Car":
                start = 2;
                end = 3;
                break;
            case "Bike":
                start = 4;
                end = parkingLot.getLot()[0].length-1;
                break;
        }
        if (checkFreeSlot(start,end, vehicle.getType())){
            return new Ticket(lotID+"_123");
        }
        return new Ticket("");
    }

    private Boolean checkFreeSlot(int start, int end,String type) {
        int[][] lot = parkingLot.getLot();
        for (int i = 1; i < lot.length; i++) {
            for (int j = start; j <= end; j++) {
                if (lot[i][j] > 0) {
                    lot[i][j] = -lot[i][j];
                    parkingViewMap.get(type).put(i,parkingViewMap.get(type).get(i)-1);
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }
}
