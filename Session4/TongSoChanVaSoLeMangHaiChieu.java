package BaiTap;

import java.util.Scanner;

public class TongSoChanVaSoLeMangHaiChieu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m,n;
        System.out.print("Nhập số hàng của mảng: ");
        m=sc.nextInt();
        System.out.print("Nhâp số cột của mảng: ");
        n=sc.nextInt();
        int [][]a= new int[m][n];
        System.out.println("Nhập các phần tử của mảng: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print("Phần tử ["+i+"]["+j+"]: ");
                a[i][j]=sc.nextInt();
            }
        }
        int sumEven=0,sumOdd=0;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j]%2==0){
                    sumEven+=a[i][j];
                }
                else{
                    sumOdd+=a[i][j];
                }
            }
        }
        System.out.println("Tổng các số chẵn: "+sumEven);
        System.out.println("Tổng các số lẻ: "+sumOdd);
    }
}
