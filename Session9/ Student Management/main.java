package StudentManagement;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Nguyen Van A", 20, 3.5);
        Student s2 = new Student(2, "Tran Thi B", 21, 3.8);
        Student s3 = new Student(3, "Le Van C", 19, 4.5); // sẽ bị giới hạn về 4.0
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        for (Student s : list) {
            s.printInfo();
        }

        System.out.println("Tong so sinh vien: " + Student.getCount());
    }
}
