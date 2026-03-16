package BaiTap.TrienKhaiCacLop;

public class Order {
    private int orderId;
    private Customer customer;
    private double total;

    public void printOrder(){
        System.out.println("Order Id: "+orderId);
        System.out.println("Customer: "+customer);
        System.out.println("Total: "+total);
    }
}
