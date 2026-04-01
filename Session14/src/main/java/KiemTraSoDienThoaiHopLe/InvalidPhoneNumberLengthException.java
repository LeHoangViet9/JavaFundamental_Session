package KiemTraSoDienThoaiHopLe;

public class InvalidPhoneNumberLengthException extends Exception {
    public InvalidPhoneNumberLengthException(String message){
        super(message);
    }
    public static void validatePhoneNumber(String phone) throws InvalidPhoneNumberLengthException {
        if(phone.length()!=10){
            throw new InvalidPhoneNumberLengthException("Sai độ dài");
        }
        if(!phone.matches("\\d+")){
            throw new InvalidPhoneNumberLengthException("Chỉ chứa số");
        }
    }
}
