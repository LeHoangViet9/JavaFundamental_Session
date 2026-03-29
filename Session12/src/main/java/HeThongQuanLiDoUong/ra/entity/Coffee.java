package HeThongQuanLiDoUong.ra.entity;

import java.util.Scanner;

public class Coffee extends Drink {
    public Coffee(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Pha bằng máy");
    }
    public static Coffee input(Scanner sc) {
        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(sc.nextLine());

        return new Coffee(id, name, price);
    }
}
