package BaiTap;

import java.util.Scanner;

public class DocChuSo3ChuSo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số (100-999): ");
        int number = sc.nextInt();

        if (number < 100 || number > 999) {
            System.out.println("Số nhập vào không hợp lệ");
            return;
        }

        int hundreds = number / 100;
        int tens = (number % 100) / 10;
        int units = number % 10;

        String h = "", t = "", u = "";

        switch (hundreds) {
            case 1:
                h = "Một trăm";
                break;
            case 2:
                h = "Hai trăm";
                break;
            case 3:
                h = "Ba trăm";
                break;
            case 4:
                h = "Bốn trăm";
                break;
            case 5:
                h = "Năm trăm";
                break;
            case 6:
                h = "Sáu trăm";
                break;
            case 7:
                h = "Bảy trăm";
                break;
            case 8:
                h = "Tám trăm";
                break;
            case 9:
                h = "Chín trăm";
                break;
        }

        switch (tens) {
            case 0:
                t = " linh";
                break;
            case 1:
                t = " mười";
                break;
            case 2:
                t = " hai mươi";
                break;
            case 3:
                t = " ba mươi";
                break;
            case 4:
                t = " bốn mươi";
                break;
            case 5:
                t = " năm mươi";
                break;
            case 6:
                t = " sáu mươi";
                break;
            case 7:
                t = " bảy mươi";
                break;
            case 8:
                t = " tám mươi";
                break;
            case 9:
                t = " chín mươi";
                break;
        }

        switch (units) {
            case 0:
                u = "";
                break;
            case 1:
                u = " một";
                break;
            case 2:
                u = " hai";
                break;
            case 3:
                u = " ba";
                break;
            case 4:
                u = " bốn";
                break;
            case 5:
                u = " năm";
                break;
            case 6:
                u = " sáu";
                break;
            case 7:
                u = " bảy";
                break;
            case 8:
                u = " tám";
                break;
            case 9:
                u = " chín";
                break;
        }

        System.out.println("Đọc là: " + h + t + u);
    }
}
