package TiLeQuyDoiTienTe;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyRate {
    private static double rate;

    public static double getRate() {
        return rate;
    }

    public static void setRate(double rate) {
        if(rate<0){
            System.out.println("Ti gia khong hop le");
            return;
        }
        CurrencyRate.rate = rate;
    }
    public static double toUSD(double vnd){
        if(vnd<0){
            System.out.println("Tien khong hop le");
            return 0;
        }
        return vnd/rate;
    }
    public static String formatUSD(double usd){
        NumberFormat nf=NumberFormat.getCurrencyInstance(Locale.US);
        return nf.format(usd);
    }
}
