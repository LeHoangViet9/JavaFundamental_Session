package QuanLyTaiSanThietBi.ra.presentation;

import QuanLyTaiSanThietBi.ra.entity.Asset;
import QuanLyTaiSanThietBi.ra.entity.Computer;
import QuanLyTaiSanThietBi.ra.entity.NetworkDevice;

import java.util.ArrayList;
import java.util.Scanner;

public class AssetManager {
    private static ArrayList<Asset> list=new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);

    public static void showValue(Asset a){
        System.out.println("Market value"+a.getMarketValue());
    }
    public static Asset findAsset(String code){
        for(Asset  a : list){
            if(a.getAssetCode().equalsIgnoreCase(code)){
                return a;
            }
        }
        return null;
    }
    public static void findAsset(double minPrice){
        for(Asset a: list){
            if(a.getPurchasePrice()>minPrice){
                a.toString();
            }
        }
    }

    public static void add(){
        System.out.println("Nhập thông tin cho \n" +
                "1. Máy tình\n" +
                "2. Thiết bị mạng\n" +
                "Chọn: ");

        int choice=Integer.parseInt(sc.nextLine());

        while(true){
            switch (choice){
                case 1:
                    Computer c= Computer.input(sc);
                    break;
                case 2:
                    NetworkDevice n=NetworkDevice.input(sc);
                    break;
                default:
                    System.out.println("Nhập lại!");
            }
        }
    }
    public static void show(){
       for(Asset a: list){
           a.toString();
           showValue(a);

       }
    }
    public static void updatePrice(){
        System.out.println("Enter asset code: ");
        String code=sc.nextLine();
        Asset a=findAsset(code);
        if(a!=null){
            System.out.println("New purchase price: ");
            double price=Double.parseDouble(sc.nextLine());
            a.setPurchasePrice(price);
        }
        else{
            System.out.println("Can not found");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== ASSET MANAGEMENT ===");
            System.out.println("1. Add asset");
            System.out.println("2. Show report");
            System.out.println("3. Search by code");
            System.out.println("4. Search by price");
            System.out.println("5. Update purchase price");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    System.out.print("Enter asset code: ");
                    String code = sc.nextLine();
                    Asset a = findAsset(code);
                    if (a != null) a.toString();
                    else System.out.println("Not found!");
                    break;
                case 4:
                    System.out.print("Enter minimum price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    findAsset(price);
                    break;
                case 5:
                    updatePrice();
                    break;
                case 6:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
