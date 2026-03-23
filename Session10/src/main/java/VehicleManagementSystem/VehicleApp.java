package VehicleManagementSystem;

import java.util.Scanner;

public class VehicleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Tạo đối tượng các phương tiện
        Car car = new Car("Toyota", 2020, "Gasoline");
        Motorcycle moto = new Motorcycle("Yamaha", 2021, "Gasoline");
        Truck truck = new Truck("Volvo", 2018, "Diesel");
        boolean running = true;
        while (running) {
            System.out.println("\n=== Vehicle Management Menu ===");
            System.out.println("1. Show info of all vehicles");
            System.out.println("2. Start all engines");
            System.out.println("3. Move all vehicles");
            System.out.println("4. Move vehicles at specific speed");
            System.out.println("5. Special actions");
            System.out.println("6. Test overloading move()");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    car.showInfor();
                    moto.showInfor();
                    truck.showInfor();
                    break;
                case 2:
                    car.startEngine();
                    moto.startEngine();
                    truck.startEngine();
                    break;
                case 3:
                    car.move();
                    moto.move();
                    truck.move();
                    break;
                case 4:
                    System.out.print("Enter speed for vehicles: ");
                    int speed = sc.nextInt();
                    car.move(speed);
                    moto.move(speed);
                    truck.move(speed);
                    break;
                case 5:
                    car.openTrunk();
                    moto.doWheelie();
                    truck.loadCargo();
                    break;
                case 6:
                    System.out.println("Default move():");
                    car.move();
                    System.out.println("Move at 50 km/h:");
                    car.move(50);
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting VehicleApp...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        sc.close();
    }
}
