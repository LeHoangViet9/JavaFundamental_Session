package XuLiDsSvVaPhanLoai.entity;


import java.util.Scanner;

public class Student {
    private static int autoid=1;
    private int id;
    private String name;
    private double gpa;

    public Student() {
        this.id=autoid++;
    }

    public Student(int id, String name, double gpa) {
        this.id = autoid++;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void input(Scanner sc){
        System.out.println("Nhâp name: ");
        name=sc.nextLine();
        System.out.println("Nhập gpa: ");
        gpa=Double.parseDouble(sc.nextLine());
    }
    public String getRank(){
        if(gpa>=8.5&&gpa<=10){
            return "Xuất sắc";
        }else if (gpa>=7.0){
            return "Giỏi";
        }else if(gpa>=5.5){
            return "Khá";
        }else{
            return "Trung Bình/Yếu";
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                ", rank="+getRank()+
                '}';
    }
}
