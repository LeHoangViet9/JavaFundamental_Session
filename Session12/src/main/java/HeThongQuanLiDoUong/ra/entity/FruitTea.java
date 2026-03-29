package HeThongQuanLiDoUong.ra.entity;

import java.util.Scanner;

public class FruitTea extends Drink{
    public FruitTea(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Lắc với đá và trái cây tươi");
    }
    public static FruitTea input(Scanner sc){
        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(sc.nextLine());

        return new FruitTea(id, name, price);
    }
}
