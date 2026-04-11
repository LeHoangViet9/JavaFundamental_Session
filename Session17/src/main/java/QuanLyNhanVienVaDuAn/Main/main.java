package QuanLyNhanVienVaDuAn.Main;

import QuanLyNhanVienVaDuAn.dao.EmployeeDAO;
import QuanLyNhanVienVaDuAn.dao.ProjectDAO;
import QuanLyNhanVienVaDuAn.model.Employee;
import QuanLyNhanVienVaDuAn.model.Project;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO edao=new EmployeeDAO();
        ProjectDAO pdao=new ProjectDAO();

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Add Project");
            System.out.println("3. Assign");
            System.out.println("4. List");
            System.out.println("5. Update Salary");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Dept: ");
                    String dept = sc.nextLine();
                    System.out.print("Salary: ");
                    double sal = sc.nextDouble();

                    edao.addEmployee(new Employee(0, name, dept, sal));
                    break;

                case 2:
                    System.out.print("Project name: ");
                    String pname = sc.nextLine();
                    System.out.print("Budget: ");
                    double budget = sc.nextDouble();

                    pdao.addProject(new Project(0, pname, budget));
                    break;

                case 3:
                    System.out.print("Emp ID: ");
                    int eid = sc.nextInt();
                    System.out.print("Pro ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Role: ");
                    String role = sc.nextLine();

                    edao.assignEmployeeToProject(eid, pid, role);
                    break;

                case 4:
                    edao.listEmployeeAndProject();
                    break;

                case 5:
                    System.out.print("Emp ID: ");
                    int id = sc.nextInt();
                    System.out.print("New Salary: ");
                    double newSal = sc.nextDouble();

                    edao.updateSalary(id, newSal);
                    break;

                case 0:
                    return;
            }
        }
    }
}
