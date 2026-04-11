package QuanLySinhVienVaKhoaHoc.dao;

import QuanLySinhVienVaKhoaHoc.db.DBUtility;
import QuanLySinhVienVaKhoaHoc.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CourseDAO {
    public void addCourse(Course c) {
        String check = "SELECT 1 FROM course WHERE title = ?";
        String sql = "INSERT INTO course(title, credits) VALUES (?, ?)";

        try (Connection con = DBUtility.getConnection();
             PreparedStatement psCheck = con.prepareStatement(check);
             PreparedStatement ps = con.prepareStatement(sql)) {

            psCheck.setString(1, c.getTitle());
            if (psCheck.executeQuery().next()) {
                System.out.println("Course đã tồn tại!");
                return;
            }

            ps.setString(1, c.getTitle());
            ps.setInt(2, c.getCredits());
            ps.executeUpdate();

            System.out.println("Add course successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
