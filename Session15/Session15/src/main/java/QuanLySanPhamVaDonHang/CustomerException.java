package QuanLySanPhamVaDonHang;

public class CustomerException extends Exception{
    class InvalidPriceException extends Exception {
        public InvalidPriceException(String msg) {
            super(msg);
        }
    }

    static class NotFoundException extends Exception {
        public NotFoundException(String msg) {
            super(msg);
        }
    }
}
