package BaiTap;

import java.util.Scanner;

public class QuanLiDiemSoSinhVien {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("Nhập số lượng sinh viên: ");
        n=sc.nextInt();
        float [] mark=new float[n];
        System.out.println("Nhập số điểm của từng sinh viên: ");
        for(int i=0;i<n;i++){
            System.out.print("Sinh viên "+(i+1)+" : ");
            mark[i]=sc.nextFloat();
        }

        int choice;
        System.out.println("---QUÁN LÝ ĐIỂM SINH VIÊN---");
        System.out.println("1. Xem tất cả điểm");
        System.out.println("2. Sắp xếp điểm");
        System.out.println("3. Tìm kiếm điểm");
        System.out.println("4. Thống kê điểm");
        System.out.println("5. Thoát");
        System.out.println("Lựa chọn của bạn: ");
        choice=sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Danh sách điểm: ");
                for(int i=0;i<n;i++){
                    System.out.print("Sinh viên 1: "+mark[i]);
                }
                break;
            case 2:
                System.out.println("Chọn cách sắp xếp: ");
                System.out.println("1. Tăng dần");
                System.out.println("2. Giảm dần");
                int ch=sc.nextInt();
                switch (ch){
                    case 1:
                        for(int i=0;i<n;i++){
                            for(int j=0;j<n-1-i;j++){
                                if(mark[j]>mark[j+1]){
                                    float temp= mark[j];
                                    mark[j]=mark[j+1];
                                    mark[j+1]=temp;
                                }
                            }
                        }
                        break;
                    case 2:
                        for(int i=0;i<n;i++){
                            for(int j=0;j<n-1-i;j++){
                                if(mark[j]<mark[j+1]){
                                    float temp= mark[j];
                                    mark[j]=mark[j+1];
                                    mark[j+1]=temp;
                                }
                            }
                        }
                        break;
                    default:
                        System.out.println("Không hợp lệ");
                }
                System.out.println("Mảng sau khi sắp xếp: ");
                for(float f: mark){
                    System.out.println(f+" ");
                }
                System.out.println();
                break;
            case 3:
                System.out.println("Nhập điểm cần tìm");
                float x=sc.nextFloat();
                int linearIndex=-1;
                for(int i=0;i<n;i++){
                    if(mark[i]==x){
                        linearIndex=i;
                        break;
                    }
                }
                int left =0;
                int right=n-1;
                int binaryIndex=-1;
                while (left<=right){
                    int mid=(right+left)/2;

                    if(mark[mid]==x){
                        binaryIndex=mid;
                        break;
                    }
                    if(mark[mid]<x){
                        right=mid-1;

                    }else{
                        left=mid+1;
                    }
                }
                if(linearIndex!=-1){
                    System.out.println("Tìm kiếm tuyến tính: Tìm thầy tại vị trí "+linearIndex);
                }
                else{
                    System.out.println("Không tìm thấy điểm số");
                }
                if(binaryIndex!=-1){
                    System.out.println("Tìm kiếm nhị phân : Tìm thấy tại vị trí: "+binaryIndex);
                }

                break;
            case 4:
                float sum=0;
               float max=mark[0];
               float min = mark[0];
               float avg=0;
               int countAvg=0;
               for(float f: mark){
                   sum+=f;
                   if(f>max){
                       max=f;
                   }
                   if(f<min){
                       min=f;
                   }
                    avg=sum/n;
                   for (float fl: mark){
                       if(fl>avg){
                           countAvg++;
                       }
                   }
               }
                System.out.println("Điểm trung bình: "+avg);
                System.out.println("Điểm cao nhất: "+max);
                System.out.println("Điểm thấp nhất: "+min);
                System.out.println("Số sinh viên có điểm trên trung bình: "+countAvg);
                break;
            default:
                System.out.println("Không hợp lệ ");
        }
    }
}
