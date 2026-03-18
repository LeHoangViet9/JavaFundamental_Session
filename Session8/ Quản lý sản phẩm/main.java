package QuanLiSanPham;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim theo khoang gia");
            System.out.println("4. Tong so san pham");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    Product p = new Product();
                    p.input();
                    list.add(p);
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("Danh sach rong!");
                    } else {
                        for (Product pr : list) {
                            pr.print();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhap gia min: ");
                    double min = sc.nextDouble();
                    System.out.print("Nhap gia max: ");
                    double max = sc.nextDouble();

                    boolean found = false;
                    for (Product pr : list) {
                        if (pr.getPrice() >= min && pr.getPrice() <= max) {
                            pr.print();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Khong tim thay!");
                    }
                    break;

                case 4:
                    System.out.println("Tong so san pham: " + (Product.AUTO_ID - 1));
                    break;

                case 0:
                    System.out.println("Thoat!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 0);
    }
}
