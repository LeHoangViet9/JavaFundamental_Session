package BaiTap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KiemTraDinhDangEmail {
    public static void main(String[] args) {
        Pattern p;
        Matcher m;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập email cần xác thực: ");
        String email=sc.nextLine();
        p=Pattern.compile("^[A-Za-z0-9._]+@[A-Za-z0-9.]+\\.[A-Za-z]{2,6}$");
        m=p.matcher(email);
        if(m.matches()){
            System.out.println("Email hợp lệ");
        }
        else{
            System.out.println("Email không hợp lệ");
        }
    }
}
