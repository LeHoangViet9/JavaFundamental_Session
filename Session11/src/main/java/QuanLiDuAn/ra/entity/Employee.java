package QuanLiDuAn.ra.entity;

import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private RoleEmployee role;
    private double salary;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, RoleEmployee role, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.role = role;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public RoleEmployee getRole() {
        return role;
    }

    public void setRole(RoleEmployee role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void inputDate(Scanner scanner, Employee[] arrEmp, int index) {
        while (true) {
            System.out.println("Enter employtId : ");
            String id = scanner.nextLine();
            if (!id.matches("E\\d{4}")) {
                System.out.println("Sai format");
                continue;
            }
            boolean isDuplicate=false;
            for(int i=0;i<index;i++){
                if(arrEmp[i].getEmployeeId().equals(id)) {
                    isDuplicate = true;
                    break;
                }

            }
            if(!isDuplicate){
                this.employeeId=id;
                break;
            }
            else{
                System.out.println("ID is duplicate");
            }
        }
        while (true){
            System.out.println("Enter name: ");
            String name=scanner.nextLine();
            if(name.length()>=6&&name.length()<=60){
                this.employeeName=name;
                break;
            }
            else{
                System.out.println("Sai độ dài");
            }
        }
        while (true) {
            System.out.print("Enter role (DEV/TESTER/PM/BA): ");
            this.role = RoleEmployee.valueOf(scanner.nextLine().toUpperCase());
            break;
        }
        while (true){
            System.out.println("Enter salary: ");
            double salary = scanner.nextDouble();
            if(salary>0){
                this.salary=salary;
                break;
            }
            else{
                System.out.println("Lương phải lớn hơn 0");
            }
        }
    }
    public void displayData(){
        System.out.println("EmployeeID: "+employeeId);
        System.out.println("Name: "+employeeName);
        System.out.println("Role: "+role);
        System.out.println("Salary: "+salary);
    }

}
