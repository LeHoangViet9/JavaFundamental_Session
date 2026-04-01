package XuLyNgoaiLeTrongATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 1_000_000;
        final double MIN_BALANCE = 50_000;

        try {
            System.out.print("Nhap so tien muon rut: ");
            double amount = sc.nextDouble();
            if (amount <= 0) {
                System.out.println("Loi: So tien rut khong hop le!");
                return;
            }

            if (amount > balance) {
                System.out.println("Loi: So tien rut vuot qua so du!");
                return;
            }

            if ((balance - amount) < MIN_BALANCE) {
                System.out.println("Loi: Tai khoan phai duy tri so du toi thieu 50.000 dong!");
                return;
            }
            balance -= amount;

            System.out.println("Rut tien thanh cong!");
            System.out.println("So tien da rut: " + amount);
            System.out.println("So du con lai: " + balance);

        } catch (Exception e) {
            System.out.println("Loi: Vui long nhap mot so hop le!");
        }


    }
}
