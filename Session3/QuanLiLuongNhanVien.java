package BaiTap;

import java.util.Scanner;

public class QuanLiLuongNhanVien {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=0;
        double total=0;
        double salary = 0;
        String rank;
        double max=Double.MIN_VALUE;
        double min=Double.MAX_VALUE;
        double avg=0;
       while (true){
           System.out.println("********** MENU NHẬP LƯƠNG **********\n"+
                   "1. Nhập lương nhân viên\n"+
                   "2. Hiện thị thống kê\n"+
                   "3. Tính tổng số tiền thưởng cho nhân viên\n"+
                   "4. Thoát\n"+
                   "Lựa chọn của bạn: ");

           int choice=sc.nextInt();

           switch (choice) {
               case 1:
                   while (true) {
                       System.out.println("--- Nhập lương nhân viên (nhập -1 để kết thúc)--");

                       System.out.print("Nhập lương: ");
                       salary = sc.nextDouble();
                       avg = total / count;
                       if (salary == -1) {
                           break;
                       }
                       if (salary < 0 || salary > 500000000) {
                           System.out.println("Lương không hợp lệ. Nhập lại.");
                           continue;
                       }
                       if (salary > max) {
                           max = salary;
                       }
                       if (salary < min) {
                           min = salary;
                       }
                       count++;
                       total += salary;
                       if (salary < 5000000) {
                           rank = "Thu nhập thấp";
                       } else if (salary < 15000000) {
                           rank = "Thu nhập trung bình";
                       } else if (salary < 50000000) {
                           rank = "Thu nhập khá";
                       } else {
                           rank = "Thu nhập cao";
                       }
                       System.out.println("Phân loại: " + rank);

                   }
                   break;
               case 2:
                   if (count == 0) {
                       System.out.println("Chưa có dữ liệu");
                   } else {

                       System.out.println("--- Thống kê ---");
                       System.out.println("Số nhân viên: " + count);
                       System.out.println("Tổng lương: " + total);
                       System.out.println("Lương trung bình: " + avg);
                       System.out.println("Lương cao nhất: " + max);
                       System.out.println("Lương nhỏ nhât: " + min);
                   }
                   break;
               case 3:
                   System.out.println("---Tính tổng số tiền thưởng nhân viên ---");
                   double tienthuong;
                   if (avg < 5000000) {
                       tienthuong = total * 0.05;
                   } else if (avg < 15000000) {
                       tienthuong = total * 0.1;
                   } else if (avg < 50000000) {
                       tienthuong = total * 0.15;
                   } else {
                       tienthuong = total * 0.25;
                   }
                   System.out.println("Tổng tiền thưởng nhân viên: " + tienthuong + " VND");
                   break;
               case 4:
                   System.out.println("Kết thúc chương trình");
                   sc.close();
               default:
                   System.out.println("Nhập không hợp lệ");
           }

       }



    }
}

