package BaiTap;

import java.util.Scanner;

public class QuanLiLuongNhanVien {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng nhân viên: ");
        int n=sc.nextInt();
        double []salaries=new double[n];
        System.out.println("Nhập từng nhân viên");
        for(int i=0;i<n;i++){
            System.out.print("Nhân viên "+(i+1)+" : ");
            salaries[i]=sc.nextDouble();
        }

        while (true){
            System.out.println("-- QUẢN LÝ LƯƠNG NHÂN VIÊN ---\n" +
                    "1. Xem danh sách lương\n" +
                    "2. Sắp xếp lương\n" +
                    "3. Tìm kiếm lương cụ thể\n" +
                    "4. Thống kê lương\n" +
                    "5. Thoát\n" +
                    "Lựa chọn của ban: ");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Danh sách lương nhân viên: ");
                    for (int i=0;i<n;i++){
                        System.out.println("Nhân viên "+(i+1)+": "+salaries[i]);
                    }
                    break;
                case 2:
                    System.out.println("Chọn cách sắp xếp: \n" +
                            "1. Tăng dần\n" +
                            "2. Giảm dần");
                    int sapxep=sc.nextInt();
                    String res="";
                    for(int i=0;i<n-1;i++){
                        int index=i;
                        for(int j=i+1;j<n;j++){
                            if(sapxep==1&&salaries[j]<salaries[index]){
                                index=j;
                                res="Đã sắp xếp tăng dần";
                            }
                            if(sapxep==2&&salaries[j]>salaries[index]){
                                index=j;
                                res="Đã sắp xếp giảm dần";
                            }

                        }
                        double temp=salaries[i];
                        salaries[i]=salaries[index];
                        salaries[index]=temp;
                        System.out.println(res);
                        for(double s : salaries){
                            System.out.print(s+" ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.print("Nhập lương cần tìm: ");
                    double x=sc.nextDouble();
                    // Linear search
                    int indexLinear=-1;
                    for(int i=0;i<n;i++){
                        if(salaries[i]==x){
                            indexLinear=i;
                            break;
                        }
                    }

                    // Binary search
                    int right=n-1;
                    int left=0;
                    int indexBinary=-1;
                    while (left<=right){
                        int mid=(right+left)/2;
                        if(salaries[mid]==x){
                            indexBinary=mid;
                            break;
                        }
                        if(salaries[mid]<x){
                            left=mid+1;
                        }
                        else{
                            right=mid-1;
                        }
                    }
                    if(indexLinear!=-1){
                        System.out.println("Linear Search: vị trí "+indexLinear);
                    }
                    else{
                        System.out.println("Linear Search: Không tìm thấy");
                    }
                    if(indexBinary!=-1){
                        System.out.println("Binary Search: vị trí "+indexBinary);
                    }
                    else{
                        System.out.println("Binary Search: Không tìm thấy");
                    }
                    break;
                case 4:
                    double sum=0;
                    double avg=0;
                    double max=salaries[0];
                    double min=salaries[0];
                    int count=0;
                    for(int i=0;i<n;i++){
                        sum+=salaries[i];

                        if(salaries[i]>max){
                            max=salaries[i];
                        }
                        if(salaries[i]<min){
                            min=salaries[i];
                        }

                        }
                    avg=sum/n;
                    for(double d: salaries){
                        if(d>avg){
                            count++;
                        }
                    }
                    System.out.println("Tổng lương: "+sum);
                    System.out.println("Lương trung bình: "+avg);
                    System.out.println("Lương cao nhất: "+max);
                    System.out.println("Lương thấp nhất: "+min);
                    System.out.println("Số nhân viên có lương trên trung bình: "+count);
                    break;
                case 5:
                    System.out.println("Thoát chương trình");
                    sc.close();
                    return;
                default:
                    System.out.println("Không hợp lệ");



            }
        }


    }
}
