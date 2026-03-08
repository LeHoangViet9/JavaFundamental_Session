package BaiTap;

import java.util.Scanner;
import java.text.DecimalFormat;

public class TinhTienHoaDonSieuThi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");

        String customerName, productName;
        double price;
        int quantity;
        boolean thethanhvien;

        System.out.print("Tên khách hàng: ");
        customerName = sc.nextLine();

        System.out.print("Sản phẩm: ");
        productName = sc.nextLine();

        System.out.print("Giá: ");
        price = sc.nextDouble();

        System.out.print("Số lượng: ");
        quantity = sc.nextInt();

        System.out.print("Thẻ thành viên: ");
        thethanhvien = sc.nextBoolean();

        double thanhtien = price * quantity;
        double giamgia;

        if (thethanhvien) {
            giamgia = thanhtien * 0.1;
        } else {
            giamgia = 0;
        }

        double vat = thanhtien * 0.08;
        double tongtien = thanhtien - giamgia + vat;

        System.out.println("Khách hàng: " + customerName);
        System.out.println("Sản phẩm: " + productName);
        System.out.println("Giá: " + df.format(price) + " VNĐ");
        System.out.println("Số lượng: " + quantity);
        System.out.println("Thành tiền: " + df.format(thanhtien) + " VNĐ");
        System.out.println("Giảm giá: " + df.format(giamgia));
        System.out.println("Tiền VAT: " + df.format(vat));
        System.out.println("Tổng tiền thanh toán: " + df.format(tongtien) + " VNĐ");
    }
}