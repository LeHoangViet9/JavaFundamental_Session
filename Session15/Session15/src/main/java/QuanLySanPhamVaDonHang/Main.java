package QuanLySanPhamVaDonHang;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProductManager pm = new ProductManager();
        OrderManager om = new OrderManager();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm");
            System.out.println("3. Hiển thị sản phẩm");
            System.out.println("4. Tạo đơn hàng");
            System.out.println("5. Thêm SP vào đơn");
            System.out.println("6. Xem đơn hàng");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Price: ");
                        double price = Double.parseDouble(sc.nextLine());

                        pm.add(new Product(id, name, price));
                        break;

                    case 2:
                        System.out.print("Nhập ID cần xóa: ");
                        pm.delete(Integer.parseInt(sc.nextLine()));
                        break;

                    case 3:
                        pm.show();
                        break;

                    case 4:
                        System.out.print("Mã đơn: ");
                        String code = sc.nextLine();

                        System.out.print("Order ID: ");
                        int oid = Integer.parseInt(sc.nextLine());

                        om.addOrder(code, new Order(oid,new ArrayList<>()));
                        break;

                    case 5:
                        System.out.print("Mã đơn: ");
                        String ocode = sc.nextLine();

                        System.out.print("ID sản phẩm: ");
                        int pid = Integer.parseInt(sc.nextLine());

                        Order order = om.getOrder(ocode);
                        Product product = pm.findById(pid);

                        order.addProduct(product);
                        break;

                    case 6:
                        om.display();
                        break;

                    case 7:
                        return;
                }
            } catch (CustomerException.NotFoundException e) {
                System.out.println("Lỗi: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Lỗi nhập dữ liệu!");
            } finally {
                System.out.println("---- Xong thao tác ----");
            }
        }
    }
}
