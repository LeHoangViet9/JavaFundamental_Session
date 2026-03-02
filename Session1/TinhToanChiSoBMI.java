package BaiTap;

import java.util.Scanner;

public class TinhToanChiSoBMI {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float cannang,chieucao;
        System.out.print("Cân nậng= ");
        cannang=Float.parseFloat(sc.nextLine());
        System.out.print("Chiều cao= ");
        chieucao=Float.parseFloat(sc.nextLine());
        System.out.printf("Chỉ số BMI= %.2f",(cannang/(chieucao*chieucao)));
    }
}
