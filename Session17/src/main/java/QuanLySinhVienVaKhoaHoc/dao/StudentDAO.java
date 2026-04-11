package QuanLySinhVienVaKhoaHoc.dao;

import QuanLySinhVienVaKhoaHoc.db.DBUtility;
import QuanLySinhVienVaKhoaHoc.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class StudentDAO {
    public void addStudent(Student student){
        String sql="Insert into Student (name,email) values(?,?)";
        String checkEmail="Select 1 From Student Where email=?";
        try(Connection con= DBUtility.getConnection();
            PreparedStatement check=con.prepareStatement(checkEmail);
            PreparedStatement ps=con.prepareStatement(sql)) {
            check.setString(1,student.getEmail());
            ResultSet rs=check.executeQuery();
            if(rs.next()){
                System.out.println("Email is existed");
                return;
            }
            ps.setString(1,student.getName());
            ps.setString(2,student.getEmail());
            ps.executeUpdate();
            System.out.println("Add sucessful");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void enrollStudent(int studentId,int courseId){
        String checkStu="Select 1 From Student Where id=?";
        String checkCou="Select 1 From Course Where id=?";
        String checkEn="Select 1 From Enrollment Where student_id=? and course_id=?";
        String insert="Insert into Enrollment (student_id,course_id,grade) values(?,?,?)";
        try (Connection con=DBUtility.getConnection();
        PreparedStatement stu=con.prepareStatement(checkStu);
        PreparedStatement cou=con.prepareStatement(checkCou);
        PreparedStatement en=con.prepareStatement(checkEn);
        PreparedStatement ps=con.prepareStatement(insert)){
            stu.setInt(1,studentId);
            if(!stu.executeQuery().next()){
                System.out.println("Student is not existed");
                return;
            }
            cou.setInt(1,courseId);
            if(!cou.executeQuery().next()){
                System.out.println("Course is not existed");
                return;
            }
            en.setInt(1,studentId);
            en.setInt(2,courseId);
            if(en.executeQuery().next()){
                System.out.println("Da dang ki");
                return;
            }
            ps.setInt(1,studentId);
            ps.setInt(2,courseId);
            ps.setNull(3, Types.DOUBLE);
            ps.executeUpdate();
            System.out.println("Update successful");
        }catch (Exception e){
e.printStackTrace();
        }
    }
    public void updateStudentGrade(int studentId, int courseId, double grade) {
        String sql = "UPDATE enrollment SET grade=? WHERE student_id=? AND course_id=?";

        try (Connection con = DBUtility.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, grade);
            ps.setInt(2, studentId);
            ps.setInt(3, courseId);

            if (ps.executeUpdate() > 0) {
                System.out.println("Update grade thành công!");
            } else {
                System.out.println("Không tìm thấy enrollment!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void listStudentsAndGrades() {
        String sql = """
        SELECT s.name, c.title, e.grade
        FROM student s
        LEFT JOIN enrollment e ON s.id = e.student_id
        LEFT JOIN course c ON e.course_id = c.id
    """;

        try (Connection con = DBUtility.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Double grade = rs.getObject(3) != null ? rs.getDouble(3) : null;

                System.out.println(
                        rs.getString(1) + " | " +
                                rs.getString(2) + " | " +
                                (grade == null ? "No grade" : grade)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
