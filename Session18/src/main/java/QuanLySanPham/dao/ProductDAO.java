package QuanLySanPham.dao;

import QuanLySanPham.db.DBUtility;
import QuanLySanPham.model.Product;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public void add(Product product){
        try (Connection con = DBUtility.getConnection()) {

            con.setAutoCommit(false);

            String sql = "CALL add_product(?,?,?,?,?,?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, product.getName());
            cs.setFloat(2, product.getPrice());
            cs.setString(3, product.getTitle());
            cs.setDate(4, Date.valueOf(product.getCreated()));
            cs.setString(5, product.getCatalog());
            cs.setBoolean(6,product.isStatus());

            cs.execute();

            con.commit();
            System.out.println("Thêm thành công!");

        } catch (Exception e) {
            e.printStackTrace();
            try {
                Connection con = null;
                con.rollback();
            }catch (Exception ex){
                ex.printStackTrace();
            }
            System.out.println("Lỗi → rollback!");
        }
    }
    public List<Product> show (){
        String sql="Select * From list_product()";
        List<Product> list=new ArrayList<>();
        try(Connection con=DBUtility.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)) {
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                list.add(new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getFloat("price"),
                        rs.getString("title"),
                        rs.getDate("created").toLocalDate(),
                        rs.getString("catalog"),
                        rs.getBoolean("status")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void update(Product product){
        String sql="Call update_product(?,?,?,?,?)";
        try (Connection con=DBUtility.getConnection();
        CallableStatement cs=con.prepareCall(sql)){
            cs.setInt(1, product.getId());
            cs.setString(2, product.getName());
            cs.setFloat(3,product.getPrice());
            cs.setString(4,product.getTitle());
            cs.setString(5,product.getCatalog());
            int rows=cs.executeUpdate();
            if(rows==0){
                System.out.println("Can not found");
            }else{
                System.out.println("Update successful");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(int id){
        String sql="Call delete_product(?)";
        try (Connection con=DBUtility.getConnection();
        CallableStatement cs=con.prepareCall(sql)) {
            cs.setInt(1,id);
            int rows=cs.executeUpdate();
            if(rows==0){
                System.out.println("Can not found");
            }else{
                System.out.println("Delete successful");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public List<Product> search(String keyword){
        List<Product> list=new ArrayList<>();
        String sqp="Select * From get_product_by_name(?)";
        try(Connection con=DBUtility.getConnection();
        PreparedStatement ps=con.prepareStatement(sqp)) {
            ps.setString(1,keyword);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                list.add(new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getFloat("price"),
                        rs.getString("title"),
                        rs.getDate("created").toLocalDate(),
                        rs.getString("catalog"),
                        rs.getBoolean("status")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<Product> sortByPrice(){
        List<Product> list=new ArrayList<>();
        String sql="Select * From Product Order by product_price";
        try (Connection con=DBUtility.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery()){
            while (rs.next()){
                list.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getFloat("product_price"),
                        rs.getString("product_title"),
                        rs.getDate("product_created").toLocalDate(),
                        rs.getString("product_catalog"),
                        rs.getBoolean("product_status")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void countByCatalog(){
        String sql="Select * From count_by_catalog()";
        try (Connection con=DBUtility.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery()){
            while (rs.next()){
                System.out.println(rs.getString("catalog") + " : " + rs.getInt("total"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
