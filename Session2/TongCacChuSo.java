package BaiTap;

import java.util.Scanner;

public class TongCacChuSo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("Nhập số n: ");
        n=sc.nextInt();
        n=Math.abs(n);
        int tong=0;
        while (n>0){
            tong+=n%10;
            n/=10;
        }
        System.out.print("Tổng các chữ số là: "+tong);
    }
}
