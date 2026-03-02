package BaiTap;

import java.util.Scanner;

public class TinhDienTichHinhTron {
    public static void main(String[] args) {
        double r;
        Scanner sc=new Scanner(System.in);
        System.out.print("bán kính: ");
        r=Float.parseFloat(sc.nextLine());
        double A= (double) (Math.PI*r*r);
        System.out.printf("Diện tích: %.2f", A);
    }
}
