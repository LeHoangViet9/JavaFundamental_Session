package VehicleManagementSystem;

public class Motorcycle extends MortorVehicle{

    public Motorcycle(String brand, int year, String fluelType) {
        super(brand, year, fluelType);
    }

    @Override
    public void startEngine() {
        System.out.println(brand+" motorcycle engine start.");
    }
    public void doWheelie() {
        System.out.println(brand + " motorcycle is doing a wheelie!");
    }
}
