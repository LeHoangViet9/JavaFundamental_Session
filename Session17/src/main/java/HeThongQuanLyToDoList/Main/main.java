package HeThongQuanLyToDoList.Main;

import HeThongQuanLyToDoList.controller.TaskManagement;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManagement tm = new TaskManagement();

        while (true) {
            System.out.println("\n===== TODO MENU =====");
            System.out.println("1. Thêm");
            System.out.println("2. Xem");
            System.out.println("3. Update");
            System.out.println("4. Xóa");
            System.out.println("5. Search");
            System.out.println("6. Thống kê");
            System.out.println("0. Thoát");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Tên: ");
                        String name = sc.nextLine();

                        System.out.print("Status: ");
                        String status = sc.nextLine();

                        if (name.isEmpty()) throw new Exception("Tên rỗng");

                        tm.add(name, status);
                        break;

                    case 2:
                        tm.listTask();
                        break;

                    case 3:
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Status mới: ");
                        status = sc.nextLine();

                        tm.update(id, status);
                        break;

                    case 4:
                        System.out.print("ID: ");
                        id = Integer.parseInt(sc.nextLine());

                        tm.delete(id);
                        break;

                    case 5:
                        System.out.print("Nhập tên: ");
                        name = sc.nextLine();

                        tm.searchByName(name);
                        break;

                    case 6:
                        tm.taskStatistics();
                        break;

                    case 0:
                        return;
                }

            } catch (NumberFormatException e) {
                System.out.println(" Sai số!");
            } catch (Exception e) {
                System.out.println( e.getMessage());
            }
        }
    }
}
