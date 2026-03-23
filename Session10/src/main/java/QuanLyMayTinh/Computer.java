package QuanLyMayTinh;

public class Computer {
    double calculatePrice(double basePrice){
        System.out.println("[Using basePrice only]");
        return basePrice;
    }
    double calculatePrice(double basePrice, double tax){
        System.out.println("[Using basePrice + tax]");
        return basePrice + tax;
    }
    double calculatePrice(double basePrice,double tax, double discount){
        System.out.println("[Using basePrice +tax + discount]");
        return basePrice+tax+discount;
    }
}
