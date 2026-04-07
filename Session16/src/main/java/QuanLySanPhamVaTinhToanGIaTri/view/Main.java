package QuanLySanPhamVaTinhToanGIaTri.view;

import QuanLySanPhamVaTinhToanGIaTri.model.Product;
import QuanLySanPhamVaTinhToanGIaTri.model.ProductProcessor;
import QuanLySanPhamVaTinhToanGIaTri.model.ProductProcessorImplement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 1200));
        products.add(new Product("Mouse", 50));
        products.add(new Product("Keyboard", 80));
        ProductProcessor pp=new ProductProcessorImplement();
        if(pp.hasExpensiveProduct(products)){
            System.out.println("Có sản phẩm giá trên 100");
        }else{
            System.out.println("Không có sản phẩm đắt tiền");
        }
        double total=pp.calculateTotalValue(products);
        System.out.println("Tổng giá tiền là: "+total);
        ProductProcessor.printProductList(products);

    }
}
