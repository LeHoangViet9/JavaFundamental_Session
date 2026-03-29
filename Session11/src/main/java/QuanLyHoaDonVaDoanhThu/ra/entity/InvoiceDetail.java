package QuanLyHoaDonVaDoanhThu.ra.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InvoiceDetail {
    private Product product;
    private int quantity;
    private double subTotal;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Product product, int quantity, double subTotal) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public void inputData(Scanner scanner,Product[] arrProd,int productIndex){
        for(int i=0;i<productIndex;i++){
            arrProd[i].displayData();
        }
        System.out.println("Choose your product: ");
        int choice=scanner.nextInt();
        scanner.nextLine();
        this.product=arrProd[choice];
        while(true){
            System.out.println("Enter quantity: ");
            int quantity= scanner.nextInt();
            scanner.nextLine();
            if(quantity>0){
                this.quantity=quantity;
                break;
            }
            else{
                System.out.println("Quantity must be > 0");
            }
        }
        this.subTotal=product.getPrice()*quantity;

    }
    public void displayData(){
        System.out.println("Product: "+product.getProductName());
        System.out.println("Quantity: "+quantity);
        System.out.println("Sub Total: "+subTotal);
    }
    public static void totalRevenue(Invoice[] arrInvoice, int currentInvoice) {
        double sum = 0;

        for (int i = 0; i < currentInvoice; i++) {
            sum += arrInvoice[i].getTotalAmount();
        }

        System.out.println("Tổng doanh thu: " + sum);
    }
    public static void maxInvoice(Invoice[] arrInvoice, int currentInvoice) {
        if (currentInvoice == 0) {
            System.out.println("Không có dữ liệu!");
            return;
        }

        Invoice max = arrInvoice[0];

        for (int i = 1; i < currentInvoice; i++) {
            if (arrInvoice[i].getTotalAmount() > max.getTotalAmount()) {
                max = arrInvoice[i];
            }
        }

        System.out.println("Hóa đơn lớn nhất:");
        max.displayData();
    }
    public static void countInvoiceByDate(Scanner scanner, Invoice[] arrInvoice, int currentInvoice) {
        try {
            System.out.print("Từ ngày (dd/MM/yyyy): ");
            Date from = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());

            System.out.print("Đến ngày (dd/MM/yyyy): ");
            Date to = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());

            int count = 0;

            for (int i = 0; i < currentInvoice; i++) {
                Date d = arrInvoice[i].getInvoiceDate();

                if (!d.before(from) && !d.after(to)) {
                    count++;
                }
            }

            System.out.println("Số hóa đơn: " + count);

        } catch (Exception e) {
            System.out.println("Sai định dạng ngày!");
        }
    }
    public static void revenueByDate(Scanner scanner, Invoice[] arrInvoice, int currentInvoice) {
        try {
            System.out.print("Từ ngày (dd/MM/yyyy): ");
            Date from = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());

            System.out.print("Đến ngày (dd/MM/yyyy): ");
            Date to = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());

            double sum = 0;

            for (int i = 0; i < currentInvoice; i++) {
                Date d = arrInvoice[i].getInvoiceDate();

                if (!d.before(from) && !d.after(to)) {
                    sum += arrInvoice[i].getTotalAmount();
                }
            }

            System.out.println("Doanh thu: " + sum);

        } catch (Exception e) {
            System.out.println("Sai định dạng ngày!");
        }
    }
}
