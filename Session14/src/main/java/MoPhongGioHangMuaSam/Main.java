package MoPhongGioHangMuaSam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        ShoppingCart cart = new ShoppingCart();

        products.add(new Product("P01", "Ao", 100_000));
        products.add(new Product("P02", "Quan", 200_000));
        products.add(new Product("P03", "Giay", 300_000));

        while(true){
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem san pham");
            System.out.println("2. Them vao gio");
            System.out.println("3. Xoa khoi gio");
            System.out.println("4. Xem gio hang");
            System.out.println("5. Thanh toan");
            System.out.println("0. Thoat");
            System.out.println("Chọn: ");
            int choice;
            try {
                choice=Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                System.out.println("Nhap sai");
                return;
            }
            try {
                switch (choice){
                    case 1:
                        for(Product p:products){
                            System.out.println(p);
                            break;
                        }
                        break;
                    case 2:
                        System.out.print("Nhap ma san pham: ");
                        String id = sc.nextLine();

                        Product selected = null;
                        for (Product p : products) {
                            if (p.getId().equals(id)) {
                                selected = p;
                                break;
                            }
                        }

                        if (selected == null) {
                            System.out.println("Khong tim thay san pham!");
                            break;
                        }

                        System.out.print("Nhap so luong: ");
                        int qty = Integer.parseInt(sc.nextLine());

                        cart.addToCart(selected, qty);
                        System.out.println("Da them vao gio!");
                        break;

                    case 3:
                        System.out.print("Nhap ma san pham can xoa: ");
                        String removeId = sc.nextLine();
                        cart.removeFromCart(removeId);
                        System.out.println("Da xoa!");
                        break;

                    case 4:
                        cart.displayCart();
                        break;

                    case 5:
                        cart.checkout();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Lua chon khong hop le!");

                }
            }catch (CartException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println("Loi");
            }
        }
    }
}
