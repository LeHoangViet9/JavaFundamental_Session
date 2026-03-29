package QuanLyHoaDonVaDoanhThu.ra.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Invoice {
    private String invoiceId;
    private String customerName;
    private Date invoiceDate;
    private InvoiceDetail[] details;
    private double totalAmount;

    public Invoice() {
    }

    public Invoice(String invoiceId, String customerName, Date invoiceDate, InvoiceDetail[] details, double totalAmount) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
        this.details = details;
        this.totalAmount = totalAmount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public InvoiceDetail[] getDetails() {
        return details;
    }

    public void setDetails(InvoiceDetail[] details) {
        this.details = details;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex){
        while (true){
            System.out.println("Enter voice id: ");
            String id=scanner.nextLine();
            if(id.matches("^HD\\d{4}$")){
                this.invoiceId=id;
                break;
            }
            else{
                System.out.println("Wrong Id!");
            }
        }
        System.out.println("Enter customer name; ");
        this.customerName=scanner.nextLine();
        this.invoiceDate=new Date();
        System.out.println("Enter number of product: ");
        int number=scanner.nextInt();
        scanner.nextLine();
        details =new InvoiceDetail[number];
        for(int i=0;i<number;i++){
            details[i]=new InvoiceDetail();
            details[i].inputData(scanner,arrProd,prodIndex);
        }
        calculateAmount();
    }
    public void calculateAmount(){
        totalAmount=0;
        for(InvoiceDetail i: details){
            totalAmount+=i.getSubTotal();
        }
    }
    public void displayData(){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Invoice Id: "+invoiceId);
        System.out.println("Customer Name: "+customerName);
        System.out.println("Invoice Date: "+sdf.format(invoiceDate));
        for(InvoiceDetail i:details){
            i.displayData();
        }
        System.out.println("Total Amount: "+totalAmount);
    }
    public static void updateInvoice(Scanner scanner,Product[]arrPro,int proIndex, Invoice[] arrInv,int invIndex){
        System.out.println("Nhập hóa đơn cần cập nhập: ");
        String id=scanner.nextLine();
        int index=-1;
        for(int i=0;i<invIndex;i++){
            if(arrInv[i].getInvoiceId().equals(id)){
                index=i;
                break;
            }
        }
        if(index==-1){
            System.out.println("Can not find");
            return;
        }
        int choice;
        do {
            System.out.println("========== UPDATE INVOICE ============\n" +
                    "1. Customer Name\n" +
                    "2. Invoice Detail\n" +
                    "0. Thoát\n" +
                    "Chọn :");
            choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhập tên khách hàng mới: ");
                    arrInv[index].setCustomerName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập số sản phẩm mới: ");
                    int n=Integer.parseInt(scanner.nextLine());
                    InvoiceDetail[] details1=new InvoiceDetail[n];
                    for( int i=0;i< n;i++){
                        details1[i]=new InvoiceDetail();
                        details1[i].inputData(scanner,arrPro,proIndex);
                    }
                    arrInv[index].setDetails(details1);
                    arrInv[index].calculateAmount();
                    break;
            }
        }while(true);
    }
    public static int deleteInvoice(Scanner scanner, Invoice[] arrInv, int invIndex) {
        System.out.print("Nhập mã hóa đơn cần xóa: ");
        String id = scanner.nextLine();

        int index = -1;

        for (int i = 0; i < invIndex; i++) {
            if (arrInv[i].getInvoiceId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Không tìm thấy!");
            return invIndex;
        }
        for (int i = index; i < invIndex - 1; i++) {
            arrInv[i] = arrInv[i + 1];
        }

        invIndex--;

        System.out.println("Xóa thành công!");
        return invIndex;
    }
    public static void searchInvoiceById(Scanner scanner, Invoice[] arrInv, int invIndex) {
        System.out.print("Nhập mã hóa đơn: ");
        String id = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < invIndex; i++) {
            if (arrInv[i].getInvoiceId().equalsIgnoreCase(id)) {
                arrInv[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy hóa đơn!");
        }
    }
    public static void searchInvoiceByCustomerName(Scanner scanner, Invoice[] arrInv, int invIndex) {
        System.out.print("Nhập tên khách hàng: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;

        for (int i = 0; i < invIndex; i++) {
            if (arrInv[i].getCustomerName().toLowerCase().contains(keyword)) {
                arrInv[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy!");
        }
    }

}
