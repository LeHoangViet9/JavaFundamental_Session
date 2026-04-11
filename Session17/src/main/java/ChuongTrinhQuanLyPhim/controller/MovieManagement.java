package ChuongTrinhQuanLyPhim.controller;
import ChuongTrinhQuanLyPhim.utils.DBConnection;

import java.sql.*;

import static javax.swing.UIManager.getInt;

public class MovieManagement {
    public void add(String title,String director,int year){
        try(Connection con= DBConnection.getConnection()) {
            CallableStatement cs=con.prepareCall("Call add_movie(?,?,?)");
            cs.setString(1,title);
            cs.setString(2,director);
            cs.setInt(3,year);

            cs.execute();
            System.out.println("Add movie successful");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void show(){
        try(Connection con=DBConnection.getConnection()) {
            CallableStatement cs=con.prepareCall("Select * From list_movies()");
            ResultSet rs=cs.executeQuery();
            while(rs.next()){
                System.out.println( rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("director") + " | " +
                        rs.getInt("year"));
            }
        }catch (Exception e){
            throw new RuntimeException();

        }

    }
    public void update(int id,String title,String director,int year){
        try (Connection con=DBConnection.getConnection()){
            CallableStatement cs=con.prepareCall("Call update_movie(?,?,?,?)");
            cs.setInt(1,id);
            cs.setString(2,title);
            cs.setString(3,director);
            cs.setInt(4,year);
            cs.execute();
            System.out.println("Update successful");
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    public void delete(int id){
        try (Connection con=DBConnection.getConnection()){
            CallableStatement cs=con.prepareCall("Call delete_movie(?)");
            cs.setInt(1,id);
            cs.execute();
            System.out.println("Delete successful");
        }catch (Exception e){
            throw new RuntimeException();

        }
    }

}
