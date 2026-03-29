package HeThongQuanLyNhanSu.ra.entity;

import java.util.Scanner;

public class Lecture extends Staff{
    private int teachingHours;

    public Lecture(String id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    public Lecture() {

    }

    public int getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(int teachingHours) {
        this.teachingHours = teachingHours;
    }

    @Override
    public double calculateTotalSalary() {
        return getBaseSalary()*(teachingHours*200000);
    }

    public void input(Scanner sc){
        super.input(sc);
        System.out.println("Enter hour: ");
        teachingHours=Integer.parseInt(sc.nextLine());
    }
    public void display(){
        super.display();
        System.out.println("Type: Lecturer | Hours: " + teachingHours +
                " | Total Salary: " + calculateTotalSalary());
    }

}
