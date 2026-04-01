package QuanLyDiemDanh.presentation;

import QuanLyDiemDanh.entity.AttendanceManager;
import QuanLyDiemDanh.entity.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        AttendanceManager am=new AttendanceManager();
        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Student s = new Student();
                    s.input(sc);
                    am.add(s);
                    break;

                case 2:
                    System.out.print("Nhập index cần sửa: ");
                    int uIndex = Integer.parseInt(sc.nextLine());

                    Student newS = new Student();
                    newS.input(sc);

                    am.update(uIndex, newS);
                    break;

                case 3:
                    System.out.print("Nhập index cần xóa: ");
                    int dIndex = Integer.parseInt(sc.nextLine());

                    am.delete(dIndex);
                    break;

                case 4:
                    am.display();
                    break;

                case 0:
                    System.out.println("Thoát...");
                    break;

                default:
                    System.out.println("Chọn sai!");
            }

        } while (choice != 0);
    }
}
