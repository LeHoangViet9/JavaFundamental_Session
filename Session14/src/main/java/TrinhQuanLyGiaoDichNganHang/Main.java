package TrinhQuanLyGiaoDichNganHang;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BankAccout> list=new ArrayList<>();
        list.add(new BankAccout("A01", 1_000_000));
        list.add(new BankAccout("A02", 500_000));
        list.add(new BankAccout("A03", 200_000));
        try {
            BankAccout acc1 = findAccount(list, "A01");
            acc1.deposit(200_000);
            System.out.println("Sau khi gui tien: " + acc1);

            acc1.withDraw(100_000);
            System.out.println("Sau khi rut tien: " + acc1);

            BankAccout acc2 = findAccount(list, "A02");
            acc1.transfer(acc2, 300_000);

            System.out.println("Sau khi chuyen tien:");
            System.out.println(acc1);
            System.out.println(acc2);
        }catch (Exception e){
            System.out.println("Loi: " + e.getMessage());
        }
        System.out.println("Danh sách tài khoản");
        for(BankAccout b:list){
            System.out.println(b.toString());
        }
    }
    public static BankAccout findAccount(List<BankAccout> list, String id) {
        for (BankAccout acc : list) {
            if (acc.getAccountId().equals(id)) {
                return acc;
            }
        }
        return null;
    }
}
