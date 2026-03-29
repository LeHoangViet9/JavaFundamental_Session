package QuanLiNhanVien;

public class PartTimeEmployee extends Employee implements BonusEligible{

   private double workingHour;
   private double hourRate;

    public PartTimeEmployee(int id, String name, double workingHour, double hourRate) {
        super(id, name);
        this.workingHour = workingHour;
        this.hourRate = hourRate;
    }

    @Override
    public double calculateBonus() {
        return calculateSalary()*0.05;
    }

    @Override
    double calculateSalary() {
        return workingHour*hourRate;
    }
}
