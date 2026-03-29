package HeThongThanhToan;

public class EWalletPayment extends Payment implements Refundable{
    public EWalletPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        System.out.println("Paid by Ewallet");
    }

    @Override
    public void refund() {
        System.out.println("Refund by Ewallet");
    }
}
