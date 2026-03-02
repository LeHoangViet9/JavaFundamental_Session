package BaiTap;

import java.util.Scanner;

public class TinhTongHaiPhanSo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tu1,mau1,tu2,mau2;
        System.out.print("Tử 1: ");
        tu1=Integer.parseInt(sc.nextLine());
        System.out.print("Mẫu 1: ");
        mau1=Integer.parseInt(sc.nextLine());
        System.out.print("Tử 2: ");
        tu2=Integer.parseInt(sc.nextLine());
        System.out.print("Mẫu 2: ");
        mau2=Integer.parseInt(sc.nextLine());
        System.out.println("Kết quả: ");
        System.out.println(+(tu1*mau2)+(tu2*mau1)+"/"+(mau1*mau2));
    }
}
