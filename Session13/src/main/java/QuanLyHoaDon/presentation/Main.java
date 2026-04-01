package QuanLyHoaDon.presentation;

import QuanLyHoaDon.entity.Invoice;
import QuanLyHoaDon.entity.InvoiceManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InvoiceManager im=new InvoiceManager();
        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    Invoice i=new Invoice();
                    i.input(sc);
                    im.add(i);
                    break;
                case 2:
                    System.out.println("Nhập id: ");
                    String id=sc.nextLine();
                    int index=im.findIndexById(id);
                    Invoice ni=new Invoice();
                    ni.input(sc);
                    im.update(index,ni);
                    break;
                case 3:
                    System.out.println("Nhập id cần xóa: ");
                    id=sc.nextLine();
                    index=im.findIndexById(id);
                    im.delete(index);
                    break;
                case 4:
                    System.out.println("Danh sách: ");
                    im.display();
                    break;
                case 5:
                    System.exit(5);
                default:
                    System.out.println("Bạn nhập sai");
            }
        }while(true);
    }
}
