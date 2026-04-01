package QuanLyMonHoc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SubjectManager<Subject> manager = new SubjectManager<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm môn học");
            System.out.println("3. Xóa môn học");
            System.out.println("4. Tìm theo tên");
            System.out.println("5. Lọc tín chỉ > 3");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Lỗi nhập!");
                continue;
            }

            switch (choice) {
                case 1:
                    manager.show();
                    break;

                case 2:
                    try {
                        System.out.print("Code: ");
                        String code = sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Credits: ");
                        int credits = Integer.parseInt(sc.nextLine());

                        System.out.print("Start date (yyyy-MM-dd): ");
                        LocalDate date = LocalDate.parse(sc.nextLine(), formatter);

                        Subject s = new Subject(code, name, credits, date);
                        manager.add(s);

                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Credits phải là số!");
                    } catch (DateTimeParseException e) {
                        System.out.println("Lỗi: Sai định dạng ngày!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Nhập code cần xóa: ");
                    manager.delete(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Nhập tên cần tìm: ");
                    manager.searchByName(sc.nextLine());
                    break;

                case 5:
                    manager.filterByCredit();
                    break;

                case 6:
                    System.out.println("Thoát...");
                    return;

                default:
                    System.out.println("Chọn sai!");
            }
        }
    }
}
