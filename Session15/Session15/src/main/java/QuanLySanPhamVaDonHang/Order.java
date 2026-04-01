package QuanLySanPhamVaDonHang;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<Product> products;

    public Order() {
        products=new ArrayList<>();
    }

    public Order(int id, List<Product> products) {
        this.id = id;
        this.products = products;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void addProduct(Product p){
        products.add(p);
    }
    public double calPrice(){
        double total=0;
        for(Product p:products){
           total+= p.getPrice();
        }
        return total;
    }
    public void display() {
        System.out.println("Order ID: " + id);
        products.forEach(System.out::println);
        System.out.println("Total: " + calPrice());
    }
}
