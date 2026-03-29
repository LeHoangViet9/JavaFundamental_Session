package HeThongThanhToan;

public abstract class Payment {
    private double amount;

    public Payment() {
    }

    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    abstract void pay();
    void printAmount(){
        System.out.println("Amount: "+amount);
    }
}
