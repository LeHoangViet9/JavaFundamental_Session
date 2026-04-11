package QuanLySanPham.presentation;

import QuanLySanPham.dao.ProductDAO;
import QuanLySanPham.model.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {
            System.out.println("\n====== PRODUCT MANAGEMENT ======");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Sắp xếp theo giá");
            System.out.println("7. Thống kê theo catalog");
            System.out.println("0. Thoát");

            System.out.print("Chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    List<Product> list = dao.show();
                    if (list.isEmpty()) {
                        System.out.println("Không có dữ liệu");
                    } else {
                        list.forEach(System.out::println);
                    }
                    break;

                case 2:
                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    if (name.isEmpty()) {
                        System.out.println("Tên không được rỗng!");
                        break;
                    }

                    System.out.print("Giá: ");
                    float price = Float.parseFloat(sc.nextLine());

                    if (price <= 0) {
                        System.out.println("Giá phải > 0");
                        break;
                    }

                    System.out.print("Tiêu đề: ");
                    String title = sc.nextLine();

                    System.out.print("Catalog: ");
                    String catalog = sc.nextLine();

                    Product p = new Product(
                            0,
                            name,
                            price,
                            title,
                            LocalDate.now(),
                            catalog,
                            true
                    );

                    dao.add(p);
                    break;

                case 3:
                    System.out.print("Nhập ID cần update: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Tên mới: ");
                    name = sc.nextLine();

                    System.out.print("Giá mới: ");
                    price = Float.parseFloat(sc.nextLine());

                    System.out.print("Tiêu đề mới: ");
                    title = sc.nextLine();

                    System.out.print("Catalog mới: ");
                    catalog = sc.nextLine();

                    Product updateProduct = new Product(
                            id,
                            name,
                            price,
                            title,
                            null,
                            catalog,
                            true
                    );

                    dao.update(updateProduct);
                    break;

                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    dao.delete(deleteId);
                    break;

                case 5:
                    System.out.print("Nhập tên cần tìm: ");
                    String keyword = sc.nextLine();

                    List<Product> result = dao.search(keyword);

                    if (result.isEmpty()) {
                        System.out.println("Không tìm thấy");
                    } else {
                        result.forEach(System.out::println);
                    }
                    break;

                case 6:
                    dao.sortByPrice().forEach(System.out::println);
                    break;

                case 7:
                    dao.countByCatalog();
                    break;

                case 0:
                    System.out.println("Bye");
                    return;

                default:
                    System.out.println("Chọn sai!");
            }
        }
    }
}
