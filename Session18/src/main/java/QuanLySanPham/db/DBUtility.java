package QuanLySanPham.db;

import java.sql.*;

public class DBUtility {
    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/productmanagement","postgres","1");
        }catch (ClassNotFoundException e){
            throw new RuntimeException();
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return con;
    }

    public static void closeAll(Connection con, Statement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
