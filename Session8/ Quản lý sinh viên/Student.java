package QuanLiSinhVien;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private double gpa;
    private static int countStudent;

    public Student() {
        countStudent++;
    }

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    private final double SCORE_FACTOR=0.25;
    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.print("ID: ");
        id=sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        name=sc.nextLine();
        System.out.print("GPA: ");
        gpa=sc.nextDouble();
    }
    public void print(){
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Gpa: "+gpa);
        System.out.println("Score_Factor: "+(gpa*SCORE_FACTOR));
    }
    public static int getTotalStudent(){
        return countStudent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
