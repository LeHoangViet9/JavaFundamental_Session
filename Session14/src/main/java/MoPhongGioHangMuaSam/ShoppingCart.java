package MoPhongGioHangMuaSam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {
    List<CartItem> list=new ArrayList<>();
    public void addToCart(Product product,int quantity) throws Exception {
        if(quantity<0){
            throw new Exception("Số hàng không hợp lệ!");
        }
        for(CartItem ci:list){
            if(ci.getProduct().getId().equals(product.getId())){
                ci.setQuantity(ci.getQuantity() + quantity);
                return;
            }
        }
        list.add(new CartItem(product,quantity));
    }
    public void removeFromCart(String productId) throws Exception {
        Iterator<CartItem> it=list.iterator();
        while(it.hasNext()){
            CartItem ci=it.next();
            if(ci.getProduct().getId().equals(productId)){
                it.remove();
                return;
            }
        }
        throw new Exception("Không tìm thấy sản phẩm");
    }
    public void displayCart(){
        for(CartItem ci:list){
            System.out.println(ci.getProduct().getName()+"| SL: "+ci.getQuantity()+"| Tiền: "+ci.calPrice());
        }
    }
    public void checkout(){
        double total = 0;
        for (CartItem item : list) {
            total += item.calPrice();
        }

        System.out.println("Tổng tiền thanh toán: " + total);
    }
}
