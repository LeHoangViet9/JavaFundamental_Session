package QuanLyNhanVienVaDuAn.model;

public class Assignment {
    private int employee_id;
    private int project_id;
    private String role;

    public Assignment() {
    }

    public Assignment(int employee_id, int project_id, String role) {
        this.employee_id = employee_id;
        this.project_id = project_id;
        this.role = role;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "employee_id=" + employee_id +
                ", project_id=" + project_id +
                ", role='" + role + '\'' +
                '}';
    }
}
