package QuanLiNhanVien;

public class FullTimeEmployee extends Employee {
    private double basicSalary;

    public FullTimeEmployee(int id, String name, double basicSalary) {
        super(id, name);
        this.basicSalary = basicSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    double calculateSalary() {
        return basicSalary;
    }
}
