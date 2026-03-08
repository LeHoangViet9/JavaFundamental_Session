package BaiTap;

import java.util.Scanner;

public class SoArmStrong {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N;
        
        while (true) {
            System.out.print("Nhập số nguyên dương N: ");
            N = sc.nextInt();

            if (N >= 0) {
                break;
            } else {
                System.out.println("Số nhập vào không hợp lệ");
            }
        }

        System.out.println("Các số Armstrong từ 0 đến " + N + ":");

        for (int i = 0; i <= N; i++) {

            int temp = i;
            int digits = 0;

            int copy = temp;
            if (copy == 0) {
                digits = 1;
            } else {
                while (copy > 0) {
                    digits++;
                    copy /= 10;
                }
            }

            int sum = 0;
            copy = temp;

            while (copy > 0) {
                int digit = copy % 10;
                sum += Math.pow(digit, digits);
                copy /= 10;
            }

            if (i == 0) {
                sum = 0;
            }

            if (sum == i) {
                System.out.print(i + " ");
            }
        }
    }
}
