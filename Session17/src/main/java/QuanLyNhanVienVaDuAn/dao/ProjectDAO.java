package QuanLyNhanVienVaDuAn.dao;

import QuanLyNhanVienVaDuAn.db.DBUtility;
import QuanLyNhanVienVaDuAn.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
    public void addProject(Project project){
        String sql="Insert into project (name,budget) values (?,?)";
        String check="Select * From project Where name=?";
        try (Connection con= DBUtility.getConnection();
             PreparedStatement checksql=con.prepareStatement(check)) {
            checksql.setString(1,project.getName());
            ResultSet rs=checksql.executeQuery();
            if(rs.next()){
                System.out.println("Name is existed");
                return;
            }
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,project.getName());
            ps.setDouble(2,project.getBudget());
            ps.executeUpdate();
            System.out.println("Add suscessful");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public List<Project> getAllProject(){
        String sql="Select * From project";
        List<Project> list=new ArrayList<>();
        try (Connection con=DBUtility.getConnection()){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                list.add(new Project(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("budget")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }
}
