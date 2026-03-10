package BaiTap;

import java.util.Scanner;

public class SapXepChanTruocLeSau {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Nhập số phần tử của mảng: ");
        n=sc.nextInt();
        if(n==0){
            System.out.println("Mảng không có phần tử");
            return;
        }
        int []a=new int[n];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int []res=new int[n];
        int index=0;
        for (int i=0;i<n;i++){
            if(a[i]%2==0){
                res[i++]=a[i];
            }
        }
        for(int i=0;i<n;i++){
            if(a[i]%2!=0){
                res[i++]=a[i];
            }
        }
        System.out.println("Mảng sau khi sắp xếp: ");
        for(int i=0;i<n;i++){
            System.out.println(res[i]+" ");
        }

    }
}
