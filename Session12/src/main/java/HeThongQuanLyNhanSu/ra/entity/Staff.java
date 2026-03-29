package HeThongQuanLyNhanSu.ra.entity;

import java.util.Scanner;

public abstract class Staff {
    private String id;
    private String name;
    private double baseSalary;

    public Staff() {
    }

    public Staff(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public abstract double calculateTotalSalary();
    public void input(Scanner sc){
        System.out.println("Enter id: ");
        id=sc.nextLine();
        System.out.println("Enter name: ");
        name=sc.nextLine();
        System.out.println("Enter base salary: ");
        baseSalary=sc.nextDouble();
        sc.nextLine();
    }
    public void display(){
        System.out.println("ID: "+id+"\nName: "+name+"\nBase Salary: "+baseSalary);
    }

}
