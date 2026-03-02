package BaiTap;

import java.util.Scanner;

public class TinhQuangDuongDiDuoc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float vantoc,thoigian;
        System.out.print("Vận tốc= ");
        vantoc=Float.parseFloat(sc.nextLine());
        System.out.print("Thời gian= ");
        thoigian=Float.parseFloat(sc.nextLine());
        System.out.printf("Quãng đường= %.2f",(vantoc*thoigian));
    }
}
