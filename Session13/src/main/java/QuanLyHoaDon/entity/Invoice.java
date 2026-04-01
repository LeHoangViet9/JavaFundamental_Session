package QuanLyHoaDon.entity;

import java.util.Scanner;

public class Invoice {
    private String id;
    private double price;

    public Invoice() {
    }

    public Invoice(String id, double price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void input(Scanner sc){
        System.out.println("Nhập id: ");
        id=sc.nextLine();
       while(true){
           System.out.println("Nhập giá: ");
          double price=Double.parseDouble(sc.nextLine());
           if(price<0){
               System.out.println("Vui lòng nhập số thực >= 0!");
           }
           else{
               this.price=price;
           }
       }
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}
