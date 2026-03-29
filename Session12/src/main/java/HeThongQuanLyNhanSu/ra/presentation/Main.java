package HeThongQuanLyNhanSu.ra.presentation;

import HeThongQuanLyNhanSu.ra.entity.AdminStaff;
import HeThongQuanLyNhanSu.ra.entity.Lecture;
import HeThongQuanLyNhanSu.ra.entity.Staff;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Staff> list = new ArrayList<>();

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("1. Lecturer");
                    System.out.println("2. Admin");
                    int type = Integer.parseInt(sc.nextLine());

                    Staff s = null;

                    if (type == 1) {
                        s = new Lecture();
                    } else {
                        s = new AdminStaff();
                    }

                    s.input(sc);
                    list.add(s);
                    break;

                case 2:
                    for (Staff st : list) {
                        st.display();

                        System.out.println("----------------");
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID cần sửa: ");
                    String id = sc.nextLine();
                    for (Staff st : list) {
                        if (st.getId().equals(id)) {
                            st.input(sc);
                            System.out.println("Cập nhật thành công");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    String delId = sc.nextLine();
                    list.removeIf(st -> st.getId().equals(delId));
                    System.out.println("Đã xóa");
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
