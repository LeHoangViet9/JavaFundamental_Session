package QuanLyMayTinh;

public class Main {
    public static void main(String[] args) {
        Computer obj =new Computer();
        double price1=obj.calculatePrice(1000);
        System.out.println("Finale price:"+price1 );
        double price2=obj.calculatePrice(1000,100);
        System.out.println("Finale price: "+price2);
        double price3=obj.calculatePrice(1000,100,50);
        System.out.println("Finale price: "+price3);

    }
}
