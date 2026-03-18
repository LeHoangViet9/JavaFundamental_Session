package QuanLiSinhVien;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> list=new ArrayList<>();
        int choice;
        int n;
        do {
            System.out.println("===== MENU SINH VIEN =====\n" +
                    "1. Nhập danh sách sinh viên\n" +
                    "2. in danh sách sinh viên\n" +
                    "3. Tìm sinh viên GPA cao nhất\n" +
                    "4. In tổng số sinh viên đã tạo\n" +
                    "0. Thoát\n" +
                    "Lựa chọn của bạn: ");
            choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Nhập số lượng sinh viên: ");
                    n=sc.nextInt();
                    sc.nextLine();
                    for(int i=0;i<n;i++){
                        System.out.println("Sinh viên "+(i+1));
                        Student s=new Student();
                        s.input();
                        list.add(s);
                    }
                    break;
                case 2:
                    System.out.println("Danh sách sinh viên: ");
                    for (Student s : list){
                        s.print();
                    }
                    break;
                case 3:
                    Student max=list.get(0);
                    for(Student s: list){
                        if(s.getGpa()>max.getGpa()){
                            max=s;
                        }
                    }
                    System.out.println("Sinhh viên có Gpa cao nhất là: ");
                    max.print();
                    break;
                case 4:
                    System.out.println("Tổng số sinh viên đã tạo " +Student.getTotalStudent());
                    break;
                case 0:
                    System.out.println("Thoát");
                    sc.close();
                    return;
            }

        }while(choice!=0);
    }
}
