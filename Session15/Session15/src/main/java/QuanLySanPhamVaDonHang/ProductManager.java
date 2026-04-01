package QuanLySanPhamVaDonHang;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products=new ArrayList<>();
    public void add(Product p){
        products.add(p);
    }
    public boolean delete(int id){
        return products.removeIf(p->p.getId()==id);
    }
    public Product findById(int id) throws CustomerException.NotFoundException {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new CustomerException.NotFoundException("Không tìm thấy sản phẩm");
    }
    public void show(){
        if (products.isEmpty()) {
            System.out.println("Danh sách rỗng");
        } else {
            products.forEach(System.out::println);
        }
    }
}
