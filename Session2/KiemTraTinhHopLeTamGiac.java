package BaiTap;

import java.util.Scanner;

public class KiemTraTinhHopLeTamGiac {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a,b,c;
        System.out.print("Nhập vào 3 cạnh của tam giác: ");
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        if(a<0||b<0||c<0){
            System.out.println("Không hợp lệ");
            return;
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Không phải tam giác");
            return;
        }

        if(a==b&&a==c){
            System.out.println("Tam giác đều");
        }
        else if(a==b&&a!=c||a==c&&a!=b||b==c&&a!=b){
            System.out.println("Tam giác cân");
        }
        else if(a*a==b*b+c*c||a*a+b*b==c*c||b*b==a*a+c*c){
            System.out.println("Tam giác vuông");
        }
        else{
            System.out.println("Tam giác thường");
        }

    }
}
