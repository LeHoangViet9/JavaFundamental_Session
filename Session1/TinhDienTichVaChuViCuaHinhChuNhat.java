package BaiTap;

import java.util.Scanner;

public class TinhDienTichVaChuViCuaHinhChuNhat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float width ,height;
        System.out.print("width= ");
        width=Float.parseFloat(sc.nextLine());
        System.out.print("height= ");
        height=Float.parseFloat(sc.nextLine());
        System.out.println("Diện tích: "+(width*height));
        System.out.println("Chu Vi: "+((width+height)*2));

    }
}
