package BaiTap;

import java.util.Scanner;

public class ToanTuSoHoc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a,b;
        System.out.print("Nhập số thứ nhất(firstNumber): ");
        a=Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số thứ hai(secondNumber): ");
        b=Integer.parseInt(sc.nextLine());
        System.out.print("\n--- Kết quả ---\n");
        System.out.println("firstNumber"+a);
        System.out.println("secondNumber"+b);
        System.out.println("Tổng= "+(a+b));
        System.out.println("Hiệu= "+(a-b));
        System.out.println("Tích= "+(a*b));
        System.out.println("Thương= "+(a/b));
        System.out.println("Phần dư= "+(a%b));
    }
}
