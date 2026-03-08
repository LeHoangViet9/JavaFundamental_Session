package BaiTap;

import java.util.Scanner;

public class TinhTongCacSoTu1DenN {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        int tong = 0;
        n=sc.nextInt();
        if(n==0){
            System.out.println("Số nhập vào không hợp lệ");
        }
        else{
            for(int i=0;i<=n;i++){
                tong+=i;
            }
            System.out.println("Tổng các số từ 1 đến "+n+" là: "+tong);
        }

    }
}
