package XuLiDsSvVaPhanLoai.presentaion;

import XuLiDsSvVaPhanLoai.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Student> list=new ArrayList<>();
        int choice;
        while(true){
            System.out.println("======================MENU=======================\n" +
                    "1. Nhập danh sách sinh viên\n" +
                    "2. Hiển thị danh sách sinh viên\n" +
                    "3. Tìm kiếm sinh viên theo tên\n" +
                    "4. Phân loại sinh viên theo GPA\n" +
                    "0. Thoát\n" +
                    "==================================================================\n" +
                    "Lựa chọn của bạn: ");
            choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhập số lượng sinh viên: ");
                    int n=Integer.parseInt(sc.nextLine());
                    if(n<5){
                        System.out.println("Phải nhập ít nhất 5 sinh viên");
                        break;
                    }
                    for(int i=0;i<n;i++){
                        System.out.println("Nhập sinh viên thứ "+(i+1));
                        Student s=new Student();
                        s.input(sc);
                        list.add(s);
                    }
                    break;
                case 2:
                    if(list.isEmpty()){
                        System.out.println("Danh sách rỗng");
                        break;
                    }
                    for(Student s:list){
                        System.out.println(s.toString());
                    }
                    break;
                case 3:
                    System.out.println("Nhập tên sinh viên cần tìm: ");

                    String keyword = sc.nextLine().toLowerCase();

                    boolean found = false;

                    for (Student s : list) {
                        if (s.getName().toLowerCase().contains(keyword)) {
                            System.out.println(s);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy!");
                    }
                    break;
                case 4:
                    if(list.isEmpty()){
                        System.out.println("Danh sách rỗng");
                        break;
                    }
                    for(Student s:list){
                        System.out.println(s.getName()+"->"+s.getRank());
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Nhập sai");
            }
        }
    }
}
