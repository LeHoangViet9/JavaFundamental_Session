package QuanLiDuAn.ra.presentation;

import QuanLiDuAn.ra.entity.Employee;
import QuanLiDuAn.ra.entity.Project;

import java.util.Scanner;

public class ProjectManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[100];
        Project[] projects = new Project[100];

        int empIndex = 0;
        int projIndex = 0;

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Show Employees");
            System.out.println("3. Add Project");
            System.out.println("4. Show Projects");
            System.out.println("0. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    employees[empIndex] = new Employee();
                    employees[empIndex].inputDate(sc, employees, empIndex);
                    empIndex++;
                    break;

                case 2:
                    for (int i = 0; i < empIndex; i++) {
                        employees[i].displayData();
                    }
                    break;

                case 3:
                    if (empIndex == 0) {
                        System.out.println("Chưa có nhân viên!");
                        break;
                    }
                    projects[projIndex] = new Project();
                    projects[projIndex].inputData(sc, projects, projIndex, employees, empIndex);
                    projIndex++;
                    break;

                case 4:
                    for (int i = 0; i < projIndex; i++) {
                        projects[i].displayData();
                    }
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}
