package VehicleManagementSystem;

public class Vehicle {
    String brand;
    int year;

    public Vehicle() {
    }

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    public void showInfor(){
        System.out.println("Brand: "+brand+", year: "+year);
    }
    public void startEngine() {
        System.out.println("Vehicle engine started.");
    }

    public void move() {
        System.out.println("Vehicle is moving.");
    }

    public void move(int speed) {
        System.out.println("Vehicle is moving at " + speed + " km/h.");
    }
}
