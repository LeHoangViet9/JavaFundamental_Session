package QuanLySanPhamVoiCollectionsVaStream.view;

import QuanLySanPhamVoiCollectionsVaStream.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductManager {
    static Scanner sc=new Scanner(System.in);
    static HashMap<Integer, Product> products=new HashMap<>();
    static void addProduct(){
        System.out.println("Enter id: ");
        int id=Integer.parseInt(sc.nextLine());
        if(products.containsKey(id)){
            System.out.println("Id is existed!");
            return;
        }
        System.out.println("Enter name: ");
        String name=sc.nextLine();
        System.out.println("Enter price: ");
        double price=Double.parseDouble(sc.nextLine());
        products.put(id,new Product(id,name,price));
        System.out.println("Add sucessfull");
    }
    static void updateProduct(){
        System.out.println("Enter id: ");
        int id=Integer.parseInt(sc.nextLine());
        if(!products.containsKey(id)){
            System.out.println("Id is not existed!");
            return;
        }
        System.out.println("Enter new name: ");
        String name=sc.nextLine();
        System.out.println("Enter new price: ");
        double price=Double.parseDouble(sc.nextLine());
        Product p=products.get(id);
        p.setName(name);
        p.setPrice(price);
        System.out.println("Update successfull");
    }
    static void deleteProduct(){
        System.out.println("Enter id: ");
        int id=Integer.parseInt(sc.nextLine());

        if(products.remove(id)==null){
            System.out.println("Id is not existed!");
        }else{
            System.out.println("Delete succesful");
        }
    }
    static void show(){
        System.out.println("List of product: ");
        if(products.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        products.values().forEach(System.out::println);
    }
    static void filterProduct(){
        List<Product> list=products.values().stream().filter(p->p.getPrice()>100).collect(Collectors.toList());
        if(list.isEmpty()){
            System.out.println("List don't have the product with price >100");

        }
        else{
            list.forEach(System.out::println);
        }
    }
    static void totalPrice(){
        double sum=products.values().stream().mapToDouble(Product::getPrice).sum();
        System.out.println("Total price: "+sum);
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị");
            System.out.println("5. Lọc giá > 100");
            System.out.println("6. Tính tổng tiền");
            System.out.println("0. Thoát");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    show();
                    break;
                case 5:
                    filterProduct();
                    break;
                case 6:
                    totalPrice();
                    break;
                case 0:
                    return;
            }
        }
    }

}
