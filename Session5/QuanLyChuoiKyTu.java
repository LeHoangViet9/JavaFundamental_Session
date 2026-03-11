package BaiTap;

import java.util.Scanner;

public class QuanLyChuoiKyTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        String str = "";
        do {
            System.out.println("********** MENU **********\n" +
                    "1. Nhập chuỗi\n" +
                    "2. Đếm số ký tự thường, hoa , số , đặc biệt\n" +
                    "3. Đảo ngược chuỗi\n" +
                    "4. Kiểm tra Palindrome\n" +
                    "5. Chuẩn hóa chuỗi (xóa khoảng trắng dư thừa, viết hoa chữ cái đầu)\n" +
                    "6. Thoát\n" +
                    "*****************************************************\n" +
                    "Lựa chọn của bạn: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Nhập chuỗi: ");
                    str = sc.nextLine();
                    break;
                case 2:
                    demkitu(str);
                    break;
                case 3:
                    daonguoc(str);
                    break;
                case 4:
                    isPalinDrome(str);
                    break;
                case 5:
                    chuanhoa(str);
                    break;
                case 6:
                    System.out.println("Tạm biệt !");
                    sc.close();
                    return;
            }
        }while (true);
    }
    public static void demkitu(String str){
        int thuong=0,hoa=0,so=0,kitu=0;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(Character.isLowerCase(c)){
                thuong++;
            }
            else if(Character.isUpperCase(c)){
                hoa++;
            }
            else if(Character.isDigit(c)){
                so++;
            }
            else{
                kitu++;
            }
        }
        System.out.println("Số kí tự thường: "+thuong);
        System.out.println("Số kí tự hoa: "+hoa);
        System.out.println("Số chữ số: "+so);
        System.out.println("Số ký tự đặc biệt: "+kitu);
    }
    public static void daonguoc(String s){
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        System.out.println("Chuỗi đảo ngược: "+sb.toString());
    }
    public static void isPalinDrome(String s){
        StringBuilder sb=new StringBuilder(s);
        String re=sb.reverse().toString();
        if(s.equals(re)){
            System.out.println("Chuỗi là Palindrome");
        }
        else{
            System.out.println("Chuỗi không phải là Palindrome");
        }
    }
    public static void chuanhoa(String s){
        s=s.trim().replaceAll("\\s+"," ");
        if(s.length()>0){
            s=Character.toUpperCase(s.charAt(0) )+ s.substring(1);
        }
        System.out.println("Chuỗi sau khi chuẩn hóa"+s);
    }
}
