package VehicleManagementSystem;

public class Car extends MortorVehicle{
    public Car(String brand, int year, String fluelType) {
        super(brand, year, fluelType);
    }

    @Override
    public void startEngine() {
        System.out.println(brand+" car engine start");
    }
    public void openTrunk(){
        System.out.println(brand+" car trunk is open");
    }
}
