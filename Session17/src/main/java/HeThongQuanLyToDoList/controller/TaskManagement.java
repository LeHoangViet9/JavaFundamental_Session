package HeThongQuanLyToDoList.controller;

import ChuongTrinhQuanLyPhim.utils.DBConnection;

import java.net.ConnectException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class TaskManagement {
    public void add(String taskName,String status){
        try(Connection con= DBConnection.getConnection()) {
            CallableStatement cs=con.prepareCall("Call add_task(?,?)");
            cs.setString(1,taskName);
            cs.setString(2,status);
            cs.execute();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    public void listTask(){
        try(Connection con=DBConnection.getConnection()) {
            CallableStatement cs= con.prepareCall("Select * From list_task()");
            ResultSet rs=cs.executeQuery();
            while(rs.next()){
                System.out.println( rs.getInt("id") + " | " +
                        rs.getString("task name") + " | " +
                        rs.getString("status"));
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    public void update(int id,String status){
        try (Connection con=DBConnection.getConnection()){
            CallableStatement cs=con.prepareCall("Call update_task(?,?)");
            cs.setInt(1,id);
            cs.setString(2,status);
            cs.execute();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    public void delete(int id){
        try (Connection con=DBConnection.getConnection()){
            CallableStatement cs=con.prepareCall("Call delete_task(?)");
            cs.setInt(1,id);
            cs.execute();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    public void searchByName(String name){
        try (Connection con=DBConnection.getConnection()) {
            CallableStatement cs=con.prepareCall("Select * From search_task_by_name(?)");
            cs.setString(1,name);
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("task_name") + " | " +
                        rs.getString("status"));
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    public void taskStatistics(){
        try(Connection con=DBConnection.getConnection()) {
            CallableStatement cs=con.prepareCall("Select * From task_statistic()");
            ResultSet rs=cs.executeQuery();
            if (rs.next()) {
                System.out.println(" Đã hoàn thành: " + rs.getInt("completed"));
                System.out.println(" Chưa hoàn thành: " + rs.getInt("not completed"));
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
