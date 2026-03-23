package QuanLiPhuongTien;

public class Main {
    public static void main(String[] args) {
        Car car=new Car();
        car.accelerate();
        car.printStatus();
        car.accelerate(20);
        car.printStatus();
        car.accelerate(5,4);
        car.printStatus();
    }
}
