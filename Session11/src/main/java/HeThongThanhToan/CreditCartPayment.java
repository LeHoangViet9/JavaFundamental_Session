package HeThongThanhToan;

public class CreditCartPayment extends Payment implements Refundable {

    public CreditCartPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        System.out.println("Paid by Credit Card");
    }

    @Override
    public void refund() {
        System.out.println("Refund by Credit Card");
    }
}
