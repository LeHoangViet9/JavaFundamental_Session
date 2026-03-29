package QuanLiDuAn.ra.entity;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Project {
    private String projectId;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Employee[] employee;
    private EmployeeStatus status;

    public Project() {
    }

    public Project(String projectId, String projectName, LocalDate startDate, LocalDate endDate, Employee[] employee, EmployeeStatus status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
        this.status = status;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee[] getEmployee() {
        return employee;
    }

    public void setEmployee(Employee[] employee) {
        this.employee = employee;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }
    public void inputData(Scanner scanner,Project[] arrProject,int index,Employee[] arrEmp,int empIndex){
        while (true){
            System.out.println("Enter project id");
            String id=scanner.nextLine();
            if(!id.matches("{P}\\d{5}")){
                System.out.println("Sai format");
                continue;
            }
            boolean isDuplicate=false;
            for(int i=0;i<index;i++){
                if(arrProject[i].getProjectId().equals(id)){
                    isDuplicate=true;
                    break;
                }
            }
            if(!isDuplicate){
                this.projectId=id;
                break;
            }
            else{
                System.out.println("Id is duplicate");
            }
        }
        while(true){
            System.out.println("Enter project name: ");
            String name=scanner.nextLine();
            if(name.length()>=10&&name.length()<=50){
                this.projectName=name;
                break;
            }
            else{
                System.out.println("Sai length");
            }
        }
        while(true){
            System.out.println("Enter start date: ");
            LocalDate start=LocalDate.parse(scanner.nextLine());
            System.out.println("Enter end date: ");
            LocalDate end=LocalDate.parse(scanner.nextLine());
            if(!end.isBefore(start)){
                this.startDate=start;
                this.endDate=end;
                break;
            }
            else{
                System.out.println("End > Start!");
            }
        }
        System.out.print("Status (PLANNING/RUNNING/FINISHED): ");
        this.status = EmployeeStatus.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Number of employee: ");
        int n=Integer.parseInt(scanner.nextLine());
        employee =new Employee[n];

        for(int i=0;i<n;i++){
            System.out.println("Choose employee index: ");
            for(int j=0;j<empIndex;j++){
                System.out.println(j+": ");
                arrEmp[i].displayData();
            }
            int choice=Integer.parseInt(scanner.nextLine());
            employee[i]=arrEmp[choice];
        }

    }
    public void displayData() {
        System.out.println("Project ID: " + projectId +
                " | Name: " + projectName +
                " | Status: " + status);

        System.out.println("Employees:");
        for (Employee e : employee) {
            if (e != null) e.displayData();
        }
    }

}
