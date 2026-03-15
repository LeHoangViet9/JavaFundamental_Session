package BaiTap;

import java.util.Scanner;

public class QuanLyNguoiDung {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = "";
        String email = "";
        String phone = "";
        String password = "";

        int choice;

        do {
            System.out.println("\n************ QUAN LY NGUOI DUNG ************");
            System.out.println("1. Nhap thong tin nguoi dung");
            System.out.println("2. Chuan hoa ho ten");
            System.out.println("3. Kiem tra email hop le");
            System.out.println("4. Kiem tra so dien thoai hop le");
            System.out.println("5. Kiem tra mat khau hop le");
            System.out.println("6. Thoat");
            System.out.print("Lua chon cua ban: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Nhap ho ten: ");
                    name = sc.nextLine();

                    System.out.print("Nhap email: ");
                    email = sc.nextLine();

                    System.out.print("Nhap so dien thoai: ");
                    phone = sc.nextLine();

                    System.out.print("Nhap mat khau: ");
                    password = sc.nextLine();
                    break;

                case 2:
                    name = chuanHoaTen(name);
                    System.out.println("Ho ten sau khi chuan hoa: " + name);
                    break;

                case 3:
                    if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                        System.out.println("Email hop le");
                    } else {
                        System.out.println("Email khong hop le");
                    }
                    break;

                case 4:
                    if (phone.matches("^(03|05|07|08|09)[0-9]{8}$")) {
                        System.out.println("So dien thoai hop le");
                    } else {
                        System.out.println("So dien thoai khong hop le");
                    }
                    break;

                case 5:
                    if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$")) {
                        System.out.println("Mat khau hop le");
                    } else {
                        System.out.println("Mat khau khong hop le");
                    }
                    break;

                case 6:
                    System.out.println("Thoat chuong trinh");
                    break;

                default:
                    System.out.println("Lua chon khong hop le");
            }

        } while (choice != 6);
    }

    public static String chuanHoaTen(String name) {

        name = name.trim().toLowerCase();
        String[] words = name.split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
                    .append(w.substring(1))
                    .append(" ");
        }

        return sb.toString().trim();
    }
}