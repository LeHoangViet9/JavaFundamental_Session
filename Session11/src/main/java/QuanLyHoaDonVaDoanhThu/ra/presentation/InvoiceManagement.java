package QuanLyHoaDonVaDoanhThu.ra.presentation;

import QuanLyHoaDonVaDoanhThu.ra.entity.Invoice;
import QuanLyHoaDonVaDoanhThu.ra.entity.InvoiceDetail;
import QuanLyHoaDonVaDoanhThu.ra.entity.Product;

import java.util.Scanner;

public class InvoiceManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Invoice[] invoice = new Invoice[100];
        Product[] products = new Product[100];
        InvoiceDetail[] details = new InvoiceDetail[100];
        int prodIndex = 0;
        int invIndex = 0;
        do {
            System.out.println("========== QUẢN LÝ HÓA ĐƠN ==========\n" +
                    "1. Quản lý sản phẩm\n" +
                    "2. Quản lý hóa đơn\n" +
                    "3. Báo cáo doanh thu\n" +
                    "4. Thoát\n" +
                    "========================================================\n" +
                    "Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    do {
                        System.out.println("===== QUẢN LÝ SẢN PHẨM =====");
                        System.out.println("1. Thêm");
                        System.out.println("2. Hiển thị");
                        System.out.println("3. Cập nhật");
                        System.out.println("4. Xóa");
                        System.out.println("5. Tìm");
                        System.out.println("6. Thoát");

                        int proChoice = Integer.parseInt(sc.nextLine());

                        switch (proChoice) {
                            case 1:
                                products[prodIndex] = new Product();
                                products[prodIndex].inputData(sc, products, prodIndex);
                                prodIndex++;
                                break;

                            case 2:
                                for (int i = 0; i < prodIndex; i++) {
                                    products[i].displayData();
                                }
                                break;

                            case 3:
                                Product.updateProduct(sc, products, prodIndex);
                                break;

                            case 4:
                                prodIndex = Product.deleteProduct(sc, products, prodIndex, invoice, invIndex);
                                break;

                            case 5:
                                Product.searchProductByName(sc, products, prodIndex);
                                break;

                            case 6:
                                break;
                        }

                        if (proChoice == 6) break;

                    } while (true);
                    break;
                case 2:
                    do {
                        System.out.println("===== QUẢN LÝ HÓA ĐƠN =====");
                        System.out.println("1. Thêm");
                        System.out.println("2. Hiển thị");
                        System.out.println("3. Cập nhật");
                        System.out.println("4. Xóa");
                        System.out.println("5. Tìm theo mã");
                        System.out.println("6. Tìm theo tên");
                        System.out.println("7. Thoát");

                        int invChoice = Integer.parseInt(sc.nextLine());

                        switch (invChoice) {
                            case 1:
                                invoice[invIndex] = new Invoice();
                                invoice[invIndex].inputData(sc, products, prodIndex);
                                invIndex++;
                                break;

                            case 2:
                                for (int i = 0; i < invIndex; i++) {
                                    invoice[i].displayData();
                                }
                                break;

                            case 3:
                                Invoice.updateInvoice(sc, products, prodIndex, invoice, invIndex);
                                break;

                            case 4:
                                invIndex = Invoice.deleteInvoice(sc, invoice, invIndex);
                                break;

                            case 5:
                                Invoice.searchInvoiceById(sc, invoice, invIndex);
                                break;

                            case 6:
                                Invoice.searchInvoiceByCustomerName(sc, invoice, invIndex);
                                break;

                            case 7:
                                break;
                        }

                        if (invChoice == 7) break;

                    } while (true);
                    break;
                case 3:
                    do {
                        System.out.println("===== DOANH THU =====");
                        System.out.println("1. Tổng doanh thu");
                        System.out.println("2. Hóa đơn lớn nhất");
                        System.out.println("3. Đếm theo ngày");
                        System.out.println("4. Doanh thu theo ngày");
                        System.out.println("5. Thoát");

                        int rpChoice = Integer.parseInt(sc.nextLine());

                        switch (rpChoice) {
                            case 1:
                                InvoiceDetail.totalRevenue(invoice, invIndex);
                                break;
                            case 2:
                                InvoiceDetail.maxInvoice(invoice, invIndex);
                                break;
                            case 3:
                                InvoiceDetail.countInvoiceByDate(sc, invoice, invIndex);
                                break;
                            case 4:
                                InvoiceDetail.revenueByDate(sc, invoice, invIndex);
                                break;
                            case 5:
                                break;
                        }

                        if (rpChoice == 5) break;

                    } while (true);
                    break;
                case 4:
                    System.exit(0);
            }
            while (true) ;
        }while (true);
    }
}
