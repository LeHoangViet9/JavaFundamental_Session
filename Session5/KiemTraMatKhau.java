package BaiTap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KiemTraMatKhau {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập mật khẩu cần kiểm tra: ");
        String pass=sc.nextLine();
        Pattern p;
        Matcher m;
        p=Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%$!]).{8,}$");
        m=p.matcher(pass);
        if(m.matches()){
            System.out.println("Mật khẩu hợp lệ");
        }
        else{
            System.out.println("Mật khẩu không hợp lệ");
        }
    }
}
