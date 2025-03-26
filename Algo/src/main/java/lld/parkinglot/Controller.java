package lld.parkinglot;

public class Controller {
    public static void main(String[] args) {
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.createLot("PR123",2,6);
        parkingManager.displayFreeSlots("Car",1);
        Vehicle car = new Vehicle(new Car(),"Car","12345","White");
        parkingManager.parkVehicle(car);
        parkingManager.displayFreeSlots("Car",1);

    }
}
