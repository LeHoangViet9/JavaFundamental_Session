package HeThongThanhToan;

public class CashPayment extends Payment{

    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        System.out.println("Paid by Cash");
    }
}
