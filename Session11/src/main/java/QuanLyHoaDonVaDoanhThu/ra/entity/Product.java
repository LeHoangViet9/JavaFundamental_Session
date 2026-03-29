package QuanLyHoaDonVaDoanhThu.ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private Status status;

    public Product() {
    }

    public Product(String productId, String productName, double price, Status status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Product [] arrProd, int index){
        while (true){
            System.out.println("Enter Product Id: ");
            String id=scanner.nextLine();
            if(!id.matches("^[CSA]\\d{3}$")){
                System.out.println("Wrong Id!");
                continue;
            }
            boolean isDuplicate=false;
            for(int i=0;i<index;i++){
                if(arrProd[i].equals(id)){
                    isDuplicate=true;
                    break;
                }
            }
            if(!isDuplicate){
                this.productId=id;
                break;
            }
            else{
                System.out.println("Id is existed!");
            }
        }
        while (true){
            System.out.println("Enter Product Name: ");
            String name=scanner.nextLine();
            if(name.length()>=10&&name.length()<=50){
                this.productName=name;
                break;
            }
            else{
                System.out.println("Wrong format!");
            }
        }
        while (true){
            System.out.println("Enter price: ");
            double price=scanner.nextDouble();
            if(price>0){
                this.price=price;
                break;
            }
            else{
                System.out.println("Price must be > 0");
            }
        }
        while (true){
            System.out.println("Enter status(AVAILABLE, OUT_OF_STOCK, STOP_SELLING): ");
            this.status=Status.valueOf(scanner.nextLine());
            break;
        }
    }
    public void displayData(){
        System.out.println("Product ID: "+productId);
        System.out.println("Product Name: "+productName);
        System.out.println("Price: "+price);
        System.out.println("Status: "+status);
    }
    public static void updateProduct(Scanner scanner, Product[] arrProd, int currentProd) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String id = scanner.nextLine();

        int index = -1;
        for (int i = 0; i < currentProd; i++) {
            if (arrProd[i].getProductId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }

        do {
            System.out.println("=== UPDATE MENU ===");
            System.out.println("1. Tên");
            System.out.println("2. Giá");
            System.out.println("3. Trạng thái");
            System.out.println("0. Thoát");

            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("Nhập tên mới (10-50 ký tự): ");
                        String name = scanner.nextLine();

                        if (name.length() >= 10 && name.length() <= 50) {
                            boolean isExist = false;
                            for (int i = 0; i < currentProd; i++) {
                                if (i != index && arrProd[i].getProductName().equals(name)) {
                                    isExist = true;
                                    break;
                                }
                            }

                            if (!isExist) {
                                arrProd[index].setProductName(name);
                                break;
                            }
                        }
                        System.out.println("Tên không hợp lệ hoặc bị trùng!");
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.print("Nhập giá mới > 0: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        if (price > 0) {
                            arrProd[index].setPrice(price);
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("1. AVAILABLE\n2. OUT_OF_STOCK\n3. STOP_SELLING");
                    int st = Integer.parseInt(scanner.nextLine());
                    arrProd[index].setStatus(Status.values()[st - 1]);
                    break;

                case 0:
                    return;
            }

        } while (true);
    }
    public static int deleteProduct(Scanner scanner, Product[] arrProd, int currentProd,
                                    Invoice[] arrInvoice, int currentInvoice) {
        System.out.print("Nhập mã cần xóa: ");
        String id = scanner.nextLine();

        int index = -1;

        for (int i = 0; i < currentProd; i++) {
            if (arrProd[i].getProductId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Không tìm thấy!");
            return currentProd;
        }
        for (int i = 0; i < currentInvoice; i++) {
            Invoice inv = arrInvoice[i];
            for (InvoiceDetail d : inv.getDetails()) {
                if (d.getProduct().getProductId().equals(id)) {
                    System.out.println("Không thể xóa! Đã có trong hóa đơn.");
                    return currentProd;
                }
            }
        }
        for (int i = index; i < currentProd - 1; i++) {
            arrProd[i] = arrProd[i + 1];
        }

        currentProd--;
        System.out.println("Xóa thành công!");
        return currentProd;
    }
    public static void searchProductByName(Scanner scanner, Product[] arrProd, int currentProd) {
        System.out.print("Nhập tên cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();

        for (int i = 0; i < currentProd; i++) {
            if (arrProd[i].getProductName().toLowerCase().contains(keyword)) {
                arrProd[i].displayData();
            }
        }
    }
}
