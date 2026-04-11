package QuanLySinhVienVaKhoaHoc.presentation;

import QuanLySinhVienVaKhoaHoc.dao.CourseDAO;
import QuanLySinhVienVaKhoaHoc.dao.StudentDAO;
import QuanLySinhVienVaKhoaHoc.model.Course;
import QuanLySinhVienVaKhoaHoc.model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        CourseDAO cdao=new CourseDAO();
        StudentDAO sdao=new StudentDAO();
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll");
            System.out.println("4. List");
            System.out.println("5. Update Grade");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter name: ");
                    String name=sc.nextLine();
                    System.out.println("Enter email: ");
                    String email=sc.nextLine();
                    Student s=new Student(0,name,email);
                    sdao.addStudent(s);
                    break;
                case 2:
                    System.out.println("Enter title: ");
                    String title=sc.nextLine();
                    System.out.println("Enter credits; ");
                    int credits=Integer.parseInt(sc.nextLine());
                    Course c=new Course(0,title,credits);
                    cdao.addCourse(c);
                    break;
                case 3:
                    System.out.println("Enter student id: ");
                    int sid=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter course id: ");
                    int cid=Integer.parseInt(sc.nextLine());

                    sdao.enrollStudent(sid,cid);
                    break;
                case 4:
                    sdao.listStudentsAndGrades();
                    break;
                case 5:
                    System.out.println("Enter student id need update: ");
                     sid=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter course id need update: ");
                    cid=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter grade: ");
                    double grade=Double.parseDouble(sc.nextLine());
                    sdao.updateStudentGrade(sid,cid,grade);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Nhap sai");
            }
        }
    }
}
