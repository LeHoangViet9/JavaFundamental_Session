package HeThongQuanLiDoUong.ra.presentation;

import HeThongQuanLiDoUong.ra.entity.Coffee;
import HeThongQuanLiDoUong.ra.entity.Drink;
import HeThongQuanLiDoUong.ra.entity.FruitTea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrinkManager {
    private static List<Drink> list=new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);
    public static void add(){
        System.out.println("Nhập đồ uống :\n" +
                "1. Coffee\n" +
                "2. FruitTea\n" +
                "Chọn: ");
        int choice=Integer.parseInt(sc.nextLine());
        if(choice==1){
            list.add(Coffee.input(sc));
        }
        else if(choice==2){
            list.add(FruitTea.input(sc));
        }

    }
    public static void show(){
        for(Drink d:list){
            d.toString();
        }
    }
    public static void applyDiscount(){
        System.out.println("Enter percent: ");
        double percent=Double.parseDouble(sc.nextLine());

        for(Drink d:list){
            d.applyDiscount(percent);
        }
    }

    public static void delete(){
        System.out.println("Enter drink you want delete: ");
        String id=sc.nextLine();
        list.removeIf(d -> d.getId().equalsIgnoreCase(id));

    }
    public static double averagePrice(){
        double sum=0;
        for(Drink d:list){
            sum+=d.getPrice();
        }
        return sum/list.size();
    }

    public static void main(String[] args) {
        System.out.println("===============MENU==================\n" +
                "1. Thêm món vào Menu\n" +
                "2. Hiển thị Menu\n" +
                "3. Áp dụng mã giảm giá\n" +
                "4. Xóa món\n" +
                "5. Thống kê\n" +
                "6. Thoát\n" +
                "Lựa chọn của bạn: ");
        int choice=Integer.parseInt(sc.nextLine());
        do {
            switch (choice){
                case 1:
                    add();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    applyDiscount();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    System.out.println("Tổng giá tiền trung bình các món trong menu: "+averagePrice());
                    break;
                case 6:
                    System.exit(0);
                    return;
                default:
                    System.out.println("Nhập lại");
            }
        }while(true);
    }
}
