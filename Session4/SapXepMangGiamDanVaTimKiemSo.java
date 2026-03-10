package BaiTap;

import java.util.Scanner;

public class SapXepMangGiamDanVaTimKiemSo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("Nhập số lượng phần tử của mảng: ");
        n=sc.nextInt();
        int []a=new int[n];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i=0;i<n;i++){
            System.out.println("Phần tử thứ "+(i+1)+": ");
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int maxIndex=i;
            for(int j=i+1;j<n;j++){
                if(a[j]>a[maxIndex]){
                    maxIndex=j;
                }
            }
            int temp=a[i];
            a[i]=a[maxIndex];
            a[maxIndex]=temp;
        }
        System.out.println("Mảng sau khi sắp xếp: ");
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        int k;
        System.out.print("\nNhập số cần tìm: ");
        k=sc.nextInt();

        int linearIndex=-1;
        for(int i=0;i<n;i++){
            if(a[i]==k){
                linearIndex=i;
                break;
            }
        }

        int left =0;
        int right=n-1;
        int binaryIndex=-1;
        while (left<=right){
            int mid=(right+left)/2;

            if(a[mid]==k){
                binaryIndex=mid;
                break;
            }
            if(a[mid]<k){
                right=mid-1;

            }else{
                left=mid+1;
            }
        }
        if(linearIndex!=-1){
            System.out.println("Tìm kiếm tuyến tính: Số "+k+" có tại ví trí "+linearIndex);
        }
        if(binaryIndex!=-1){
            System.out.println("Tìm kiếm nhị phân: Số "+k+" có tại vị trí "+binaryIndex);
        }
    }
}
