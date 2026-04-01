package QuanLyNguoiDung.presentation;

import QuanLyNguoiDung.entity.Person;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class UserManager {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedList<Person>list=new LinkedList<>();
        while(true){
            System.out.println("===============MENU QUẢN LÝ NGƯỜI DÙNG==========================\n" +
                    "1. Thêm người dùng\n" +
                    "2. Xóa người dùng\n" +
                    "3. Hiển thị danh sách người dùng\n" +
                    "4. Thoát\n" +
                    "Lựa chọn của bạn: ");
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    Person p=new Person();
                    p.input(sc);
                    list.add(p);
                    System.out.println("Thêm thành công");
                    break;
                case 2:
                    System.out.println("Nhập email cần xóa: ");
                    String email=sc.nextLine();
                    Iterator<Person> it=list.iterator();
                    boolean exist=false;
                    while(it.hasNext()){
                        p=it.next();
                        if(p.getEmail().equalsIgnoreCase(email)){
                            it.remove();
                            exist=true;
                            break;
                        }

                    }
                    if(exist){
                        System.out.println("Xóa thành công");
                    }
                    else{
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 3:
                    System.out.println("Danh sách người dùng: ");
                    if(list.isEmpty()){
                        System.out.println("Danh sách rỗng");
                        return;
                    }
                    for(Person p1:list){
                        System.out.println(p1.toString());
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Bạn chọn sai");
            }
        }
    }
}
