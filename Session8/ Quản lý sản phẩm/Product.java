package QuanLiSanPham;

import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private double price;
     static int AUTO_ID=1;
    private final String WAREHOUSE_CODE="KHO-01";

    public Product() {
        AUTO_ID++;
    }

    public Product( String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }
    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Name: ");
        name=sc.nextLine();
        System.out.print("Price: ");
        price=sc.nextDouble();

    }
    public void print(){
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Price: "+price);
        System.out.println("WAREHOUSE:  "+WAREHOUSE_CODE);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
