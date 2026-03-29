package HeThongQuanLyNhanSu.ra.entity;

import java.util.Scanner;

public class AdminStaff extends Staff {
    private double bonus;

    public AdminStaff(String id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public AdminStaff() {

    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateTotalSalary() {
        return getBaseSalary()+bonus;
    }
    public void input(Scanner sc){
        super.input(sc);
        System.out.println("Enter bonus: ");
        bonus=sc.nextDouble();
        sc.nextLine();
    }
    public void display(){
        super.display();
        System.out.println("Type: Admin | Bonus: " + bonus +
                " | Total Salary: " + calculateTotalSalary());
    }
}
