package QuanLySanPhamVaTinhToanGIaTri.model;

import java.util.List;

public class ProductProcessorImplement implements ProductProcessor{
    @Override
    public double calculateTotalValue(List<Product> products) {
        double sum=0;
        for(Product p:products){
            sum+=p.getPrice();
        }
        return sum;
    }

}
