package TrinhQuanLyGiaoDichNganHang;

public class BankAccout {
    private String accountId;
    private double balance;

    public BankAccout() {
    }

    public BankAccout(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws Exception {
        if(amount<0){
            throw new Exception("Số tiền không hợp lệ");
        }
        balance+=amount;
    }
    public void withDraw(double amount) throws Exception {
        if(amount<0 ){
            throw new Exception("Số tiền không hợp lệ");
        }
        if(amount>balance){
            throw new Exception("Số tiền không hợp lệ");
        }
        balance-=amount;
    }
    public void transfer(BankAccout target,double amount) throws Exception {
        if(target==null){
            throw new Exception("Tài khoản đích không tồn tại");
        }
        if(amount<0 ){
            throw new Exception("Số tiền không hợp lệ");
        }
        if(amount>balance){
            throw new Exception("Số tiền không hợp lệ");
        }
        this.balance -= amount;
        target.balance += amount;
    }

    @Override
    public String toString() {
        return "BankAccout{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
