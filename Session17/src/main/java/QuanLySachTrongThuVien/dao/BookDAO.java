package QuanLySachTrongThuVien.dao;

import ChuongTrinhQuanLyPhim.utils.DBConnection;
import QuanLySachTrongThuVien.db.DBUtility;
import QuanLySachTrongThuVien.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO   {
    public void add(Book book){
        String checksql="Select * From books Where title=? AND author=?";
        String insertSql = "INSERT INTO books(title, author, published_year, price) VALUES (?, ?, ?, ?)";
        try(Connection con=DBUtility.getConnection();
        PreparedStatement check=con.prepareStatement(checksql))
        {
                check.setString(1,book.getTitle());
                check.setString(2,book.getAuthor());
                ResultSet rs=check.executeQuery();
                if(rs.next()){
                    System.out.println("Book is existed");
                    return;
                }
                PreparedStatement ps=con.prepareStatement(insertSql);
                ps.setString(1,book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPublished_year());
            ps.setDouble(4, book.getPrice());
            ps.executeUpdate();
            System.out.println("Add succesful");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(int id, Book book){
        String sql="UPDATE books SET title=?, author=?, published_year=?, price=? WHERE id=?";

        try(Connection con=DBUtility.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPublished_year());
            ps.setDouble(4, book.getPrice());
            ps.setInt(5, id);

            int rows=ps.executeUpdate();

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
        String sql="Delete from books where id=?";
        try (Connection con=DBUtility.getConnection()){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            int rows=ps.executeUpdate();
            if(rows==0){
                System.out.println("Can not found");
            }else{
                System.out.println("Delete succesful");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Book> findByAuthor(String author){
        String sql="Select * From books where author ilike ?";
        List<Book> books=new ArrayList<>();
        try (Connection con=DBUtility.getConnection()){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,"%"+author+"%");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                books.add(new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("published_year"),
                        rs.getDouble("price")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  books;
    }
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection con = DBUtility.getConnection();
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                list.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("published_year"),
                        rs.getDouble("price")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
