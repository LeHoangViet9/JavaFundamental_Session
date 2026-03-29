package HeThongThanhToan;

public class Main {
    public static void main(String[] args) {
        Payment []p=new Payment[3];
        p[0]=new CashPayment(100);
        p[1]=new CreditCartPayment(200);
        p[2]=new EWalletPayment(300);
        for(Payment ps:p){
            ps.printAmount();
            ps.pay();
            if(ps instanceof Refundable){
                ((Refundable)ps).refund();
            }
        }


    }
}
