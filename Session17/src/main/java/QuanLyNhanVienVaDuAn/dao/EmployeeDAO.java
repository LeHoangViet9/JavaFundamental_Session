package QuanLyNhanVienVaDuAn.dao;

import QuanLyNhanVienVaDuAn.db.DBUtility;
import QuanLyNhanVienVaDuAn.model.Employee;
import QuanLyNhanVienVaDuAn.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void addEmployee(Employee employee){
        String sql="Insert into employee(name,department,salary) values(?,?,?)";
        String check="Select 1 From employee where name =?";
        try (Connection con= DBUtility.getConnection();
        PreparedStatement checksql=con.prepareStatement(check);
             PreparedStatement ps=con.prepareStatement(sql);){
            checksql.setString(1,employee.getName());
            ResultSet rs=checksql.executeQuery();
            if(rs.next()){
                System.out.println("Name is existed");
                return;
            }
            ps.setString(1,employee.getName());
            ps.setString(2,employee.getDepartment());
            ps.setDouble(3,employee.getSalary());
            ps.executeUpdate();
            System.out.println("Add suscessful");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public List<Employee> getAllEmployee(){
        String sql="Select * From employee";
        List<Employee> list=new ArrayList<>();
        try (Connection con=DBUtility.getConnection()){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                list.add(new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }
    public void updateSalary(int employeeId,double newSalary){
        String sql="Update employee set salary=? where id=?";
        try(Connection con=DBUtility.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,newSalary);
            ps.setInt(2,employeeId);
            if(ps.executeUpdate()>0){
                System.out.println("Update sucessful");
            }else{
                System.out.println("Can not found");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void listEmployeeAndProject(){
        String sql = """
    SELECT e.name, p.name, a.role
    FROM employee e
    LEFT JOIN assignment a ON e.id = a.employee_id
    LEFT JOIN project p ON a.project_id = p.id
""";
        try (Connection con=DBUtility.getConnection()){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                System.out.println(
                        rs.getString(1) + " | " +
                                rs.getString(2) + " | " +
                                rs.getString(3)
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void assignEmployeeToProject(int empId, int proId, String role){
        String checkEmp="Select 1 From employee where id=?";
        String checkPro="Select 1 From project where id=?";
        String checkAss="Select 1 From assignment where employee_id=? and project_id=?";
        String insert="Insert into assignment (employee_id,project_id,role) values(?,?,?)";
        try (Connection con=DBUtility.getConnection();
        PreparedStatement empcheck=con.prepareStatement(checkEmp);
        PreparedStatement procheck=con.prepareStatement(checkPro);
        PreparedStatement asscheck=con.prepareStatement(checkAss);
        PreparedStatement ps=con.prepareStatement(insert)
        ){
            empcheck.setInt(1,empId);
            if(!empcheck.executeQuery().next()){
                System.out.println("EmployeeId is not existed");
                return;
            }
            procheck.setInt(1,proId);
            if(!procheck.executeQuery().next()){
                System.out.println("Project Id is not existed");
                return;
            }
            asscheck.setInt(1,empId);
            asscheck.setInt(2,proId);
            if(asscheck.executeQuery().next()){
                System.out.println("Da phan cong");
                return;
            }
            ps.setInt(1,empId);
            ps.setInt(2,proId);
            ps.setString(3,role);
            ps.executeUpdate();
            System.out.println("Assign sucessful");

        }catch (Exception e){
e.printStackTrace();
        }
    }
}
