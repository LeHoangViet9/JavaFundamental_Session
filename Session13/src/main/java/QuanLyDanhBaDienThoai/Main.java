package QuanLyDanhBaDienThoai;

import QuanLyDanhBaDienThoai.entity.Contact;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contact> list = new LinkedList<>();

        int choice;

        while (true) {
            System.out.println("========= MENU =========");
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Xóa theo SĐT");
            System.out.println("3. Tìm theo SĐT");
            System.out.println("4. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập SĐT: ");
                    String phone = sc.nextLine();

                    Contact newContact = new Contact(name, phone);

                    if (list.contains(newContact)) {
                        System.out.println("Số điện thoại đã tồn tại!");
                    } else {
                        list.add(newContact);
                        System.out.println("Thêm thành công!");
                    }
                    break;

                case 2:
                    System.out.print("Nhập SĐT cần xóa: ");
                    String phoneDelete = sc.nextLine();

                    boolean removed = false;

                    for (Contact c : list) {
                        if (c.getPhoneNumber().equals(phoneDelete)) {
                            list.remove(c);
                            removed = true;
                            break;
                        }
                    }

                    if (removed) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập SĐT cần tìm: ");
                    String phoneSearch = sc.nextLine();

                    boolean found = false;

                    for (Contact c : list) {
                        if (c.getPhoneNumber().equals(phoneSearch)) {
                            System.out.println(c);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tồn tại!");
                    }
                    break;

                case 4:
                    if (list.isEmpty()) {
                        System.out.println("Danh sách rỗng!");
                    } else {
                        for (Contact c : list) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }
}
