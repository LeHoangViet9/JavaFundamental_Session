package BaiTap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLiTenSinhVien {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n********** MENU **********");
            System.out.println("1. Them ten sinh vien");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim ten sinh vien chua tu khoa");
            System.out.println("4. Dem so sinh vien co ten bat dau bang chu cai");
            System.out.println("5. Sap xep danh sach A-Z");
            System.out.println("6. Thoat");
            System.out.print("Lua chon: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Nhap ten sinh vien: ");
                    String name = sc.nextLine();
                    list.add(name);
                    System.out.println("Da them sinh vien.");
                    break;

                case 2:
                    System.out.println("Danh sach sinh vien:");
                    for (String s : list) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Nhap tu khoa: ");
                    String keyword = sc.nextLine().toLowerCase();

                    System.out.println("Ket qua tim kiem:");
                    for (String s : list) {
                        if (s.toLowerCase().contains(keyword)) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Nhap chu cai: ");
                    char ch = sc.nextLine().toLowerCase().charAt(0);

                    int count = 0;
                    for (String s : list) {
                        if (s.toLowerCase().charAt(0) == ch) {
                            count++;
                        }
                    }

                    System.out.println("So sinh vien bat dau bang '" + ch + "': " + count);
                    break;

                case 5:
                    Collections.sort(list);
                    System.out.println("Da sap xep danh sach.");
                    break;

                case 6:
                    System.out.println("Tam biet!");
                    sc.close();
                    return;

                default:
                    System.out.println("Lua chon khong hop le.");
            }

        } while (true);
    }
}