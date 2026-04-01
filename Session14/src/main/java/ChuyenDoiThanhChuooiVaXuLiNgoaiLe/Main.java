package ChuyenDoiThanhChuooiVaXuLiNgoaiLe;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> validNumber=new ArrayList<>();
        int invalid=0;
        System.out.println("Nhập các chuỗi: ");
        while(true){
            System.out.println("Nhập: ");
            String input=sc.nextLine();
            if(input.equals("exit")){
                break;
            }
            try {
                int number=Integer.parseInt(input);
                validNumber.add(number);
            }catch (NumberFormatException e){
                invalid++;
            }
            System.out.println("Số chuỗi hợp lệ: "+validNumber.size());
            System.out.println("Số chuỗi không hợp lệ "+invalid);
            System.out.println("Danh sách số nguyên hợp lệ: "+validNumber);
        }
    }
}
