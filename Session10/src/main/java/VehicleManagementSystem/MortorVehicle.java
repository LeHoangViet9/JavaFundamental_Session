package VehicleManagementSystem;

public class MortorVehicle extends Vehicle {
    String fluelType;

    public MortorVehicle(String brand, int year, String fluelType) {
        super(brand, year);
        this.fluelType = fluelType;
    }

    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("FluelType: "+fluelType);
    }
}
