package BaiTap;

import java.util.Scanner;

public class QuanLyDiemSV {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        int n=0;
        double[] scores = new double[100];
        do {
            System.out.println("**********QUẢN LÝ ĐIỂM SV**********\n" +
                    "1. Nhập danh sách điểm sinh viên\n" +
                    "2. In danh sách điểm\n" +
                    "3. Tìm điểm trung bình của các sinh viên\n" +
                    "4. Tìm điểm cao nhất và nhỏ nhất\n" +
                    "5. Đếm số lượng sinh viên đạt và trượt\n" +
                    "6. Sắp xếp điểm tăng dần\n" +
                    "7. Thống kê số lượng sinh viên giỏi và xuất sắc\n" +
                    "8. Thoát\n" +
                    "Lụa chọn của bạn: ");
            choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.print("Nhap so sinh vien: ");
                    n = sc.nextInt();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhap diem SV " + (i + 1) + ": ");
                        scores[i] = sc.nextDouble();
                    }
                    break;

                case 2:
                    if(n == 0){
                        System.out.println("Ban chua nhap danh sach diem!");
                        break;
                    }
                    System.out.println("Danh sach diem:");
                    for (int i = 0; i < n; i++) {
                        System.out.println("SV " + (i + 1) + ": " + scores[i]);
                    }
                    break;

                case 3:
                    double avg=0;
                    double sum=0;
                    for (int i = 0; i < n; i++) {
                        sum+=scores[i];
                    }
                    avg=sum/n;

                    System.out.println("Điểm trung bình của các sinh viên là: "+avg);
                    break;
                case 4:
                    double max=scores[0];
                    double min=scores[0];
                    for(int i=0;i<n;i++){
                        if(scores[i]>max){
                            max=scores[i];
                        }
                        if(scores[i]<min){
                            min=scores[i];
                        }
                    }
                    System.out.println("Điểm cao nhất: "+max);
                    System.out.println("Điểm nhỏ nhất: "+min);
                    break;

                case 5:
                    int pass=0;
                    int fail=0;
                    for(int i = 0; i < n; i++){
                        if(scores[i] >= 5){
                            pass++;
                        }else{
                            fail++;
                        }
                    }

                    System.out.println("So SV dat: " + pass);
                    System.out.println("So SV truot: " + fail);

                    break;
                case 6:
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (scores[i] > scores[j]) {
                                double temp = scores[i];
                                scores[i] = scores[j];
                                scores[j] = temp;
                            }
                        }
                    }
                    System.out.println("Da sap xep!");
                    break;

                case 7:
                    int count=0;
                    for (int i = 0; i < n; i++) {
                            if(scores[i]>=8){
                                count++;
                            }
                    }
                    System.out.println("Số lượng sinh viên xuất sắc và giỏi là:"+count);
                    break;

                case 8:
                    System.out.println("Thoat chuong trinh.");
                    return;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }while(true);
    }
}
