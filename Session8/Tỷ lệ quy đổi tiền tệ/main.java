package TiLeQuyDoiTienTe;

public class main {
    public static void main(String[] args) {
        CurrencyRate.setRate(26000);
        double vnd=100000;
        double usd=CurrencyRate.toUSD(vnd);
        System.out.println("VND: "+vnd);
        System.out.println("USD: "+CurrencyRate.formatUSD(usd));
    }
}
