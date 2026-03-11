package BaiTap;

import java.util.Random;
import java.util.Scanner;

public class TaoMaGiaNgauNhien {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập một số nguyên: ");
        int n=sc.nextInt();
        Random ra=new Random();
        StringBuilder sb=new StringBuilder(n);
        for(int i=0;i<n;i++){
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            int index = ra.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        String randomString=sb.toString();
        System.out.println("Chuỗi ngẫu nhiên :");
        System.out.println(randomString);
        System.out.println("Dộ dài thực tế: "+randomString.length());

    }
}
