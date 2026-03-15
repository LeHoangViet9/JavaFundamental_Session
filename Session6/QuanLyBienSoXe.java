package BaiTap;

import java.util.Scanner;

public class QuanLyBienSoXe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=0;
        int choice;
        String []plates=new String[100];
        do {
            System.out.println("\n************ QUAN LY BIEN SO XE ************");
            System.out.println("1. Them cac bien so xe");
            System.out.println("2. Hien thi danh sach bien so xe");
            System.out.println("3. Tim kiem bien so xe");
            System.out.println("4. Tim bien so xe theo ma tinh");
            System.out.println("5. Sap xep bien so xe tang dan");
            System.out.println("6. Thoat");
            System.out.print("Lua chon cua ban: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Thêm các biển số xe: ");
                    n=sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {

                        while (true) {

                            System.out.print("Nhap bien so xe " + (i + 1) + ": ");
                            String plate = sc.nextLine();

                            if (plate.matches("^[0-9]{2}[A-Z]-[0-9]{3}\\.[0-9]{2}$")) {
                                plates[i] = plate;
                                break;
                            } else {
                                System.out.println("Bien so khong dung dinh dang! (VD: 30F-123.45)");
                            }

                        }

                    }

                    break;
                case 2:
                    if (n == 0) {
                        System.out.println("Danh sach rong!");
                        break;
                    }

                    System.out.println("Danh sach bien so xe:");
                    for (int i = 0; i < n; i++) {
                        System.out.println((i + 1) + ". " + plates[i]);
                    }
                    break;

                case 3:
                    System.out.print("Nhap bien so can tim: ");
                    String search = sc.nextLine();

                    boolean found = false;

                    for (int i = 0; i < n; i++) {
                        if (plates[i].equalsIgnoreCase(search)) {
                            System.out.println("Tim thay tai vi tri: " + (i + 1));
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Khong tim thay!");
                    }
                    break;

                case 4:
                    System.out.print("Nhap ma tinh : ");
                    String code = sc.nextLine();

                    boolean check = false;

                    for (int i = 0; i < n; i++) {

                        if (plates[i].startsWith(code)) {
                            System.out.println(plates[i]);
                            check = true;
                        }
                    }

                    if (!check) {
                        System.out.println("Khong co bien so nao!");
                    }

                    break;

                case 5:

                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {

                            if (plates[i].compareTo(plates[j]) > 0) {

                                String temp = plates[i];
                                plates[i] = plates[j];
                                plates[j] = temp;
                            }
                        }
                    }

                    System.out.println("Da sap xep!");
                    break;

                case 6:
                    System.out.println("Thoat chuong trinh");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }while(choice!=6);
    }
}
