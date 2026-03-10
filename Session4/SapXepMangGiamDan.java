package BaiTap;

import java.util.Scanner;

public class SapXepMangGiamDan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("Nhập số lượng phần tử của mảng: ");
        n=sc.nextInt();
        int []a= new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Nhập phần thử thứ "+(i+1)+": ");
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                if(a[j]<a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        System.out.println("Mảng sau khi sắp xếp giảm dần : ");
        for (int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }

    }
}
