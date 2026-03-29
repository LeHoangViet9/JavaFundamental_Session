package QuanLiNhanVien;

public class Main {
    public static void main(String[] args) {
        Employee []em=new Employee[2];
        em[0]=new FullTimeEmployee(1,"Binh",1000);
        em[1]=new PartTimeEmployee(2,"An",40,10);
        for(Employee e:em){
            e.showInfo();
            System.out.println("Salary: "+e.calculateSalary());
            if(e instanceof BonusEligible){
                System.out.println("Bouns: "+((BonusEligible)e).calculateBonus());
            }
        }
    }
}
