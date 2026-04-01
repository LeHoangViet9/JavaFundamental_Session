package QuanLySanPhamVaDonHang;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    private Map<String,Order> orders=new HashMap<>();
    public void addOrder(String code,Order o){
        orders.put(code,o);
    }
    public Order getOrder(String code) throws CustomerException.NotFoundException {
        if (!orders.containsKey(code)) {
            throw new CustomerException.NotFoundException("Không tìm thấy đơn hàng!");
        }
        return orders.get(code);
    }

    public void display() {
        if (orders.isEmpty()) {
            System.out.println("Không có đơn hàng");
            return;
        }
        orders.forEach((k, v) -> {
            System.out.println("Code: " + k);
            v.display();
        });
    }

}
