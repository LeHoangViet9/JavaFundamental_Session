package BaiTap;

import java.util.Scanner;

public class QuanLiDiemHocVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        int count = 0;
        double total = 0;
        double max = -1;
        double min = 11;

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    while (true) {

                        System.out.print("Nhập điểm (-1 để kết thúc): ");
                        double score = sc.nextDouble();

                        if (score == -1) {
                            break;
                        }

                        if (score < 0 || score > 10) {
                            System.out.println("Điểm không hợp lệ! Nhập lại.");
                            continue;
                        }

                        count++;
                        total += score;

                        if (score > max) {
                            max = score;
                        }

                        if (score < min) {
                            min = score;
                        }

                        if (score < 5) {
                            System.out.println("Xếp loại: Yếu");
                        } else if (score < 7) {
                            System.out.println("Xếp loại: Trung Bình");
                        } else if (score < 8) {
                            System.out.println("Xếp loại: Khá");
                        } else if (score < 9) {
                            System.out.println("Xếp loại: Giỏi");
                        } else {
                            System.out.println("Xếp loại: Xuất sắc");
                        }
                    }

                    break;

                case 2:

                    if (count == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {

                        double avg = total / count;

                        System.out.println("Số học viên: " + count);
                        System.out.println("Điểm trung bình: " + avg);
                        System.out.println("Điểm cao nhất: " + max);
                        System.out.println("Điểm thấp nhất: " + min);
                    }

                    break;

                case 3:

                    System.out.println("Kết thúc chương trình");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
