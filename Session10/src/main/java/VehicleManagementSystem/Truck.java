package VehicleManagementSystem;

public class Truck extends Motorcycle{
    public Truck(String brand, int year, String fluelType) {
        super(brand, year, fluelType);
    }
    @Override
    public void startEngine() {
        System.out.println(brand + " truck engine started.");
    }

    public void loadCargo() {
        System.out.println(brand + " truck is loading cargo.");
    }
}
