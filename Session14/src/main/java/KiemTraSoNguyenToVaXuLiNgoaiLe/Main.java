package KiemTraSoNguyenToVaXuLiNgoaiLe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        try {
            System.out.println("Enter n:");
            n=Integer.parseInt(sc.nextLine());
            if(n<0){
                System.out.println("N must be >0");
                return;
            }
            if(isPrime(n)){
                System.out.println(n+" is Prime");
            }else{
                System.out.println(n+" is not Prime");
            }

        }catch (NumberFormatException e){
            System.out.println("You must enter an integer");
        }
        sc.close();
    }
    public static boolean isPrime(int n){
        if(n<2){
            return false;
        }
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
