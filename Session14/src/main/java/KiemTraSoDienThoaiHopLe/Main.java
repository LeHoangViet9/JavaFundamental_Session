package KiemTraSoDienThoaiHopLe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> validPhones = new ArrayList<>();
        Map<String, String> invalidPhones = new LinkedHashMap<>();

        System.out.print("Nhap danh sach SDT (cach nhau boi dau phay): ");
        String input = sc.nextLine();

        String[] phones = input.split(",");

        for (String phone : phones) {
            phone = phone.trim();

            try {
                InvalidPhoneNumberLengthException.validatePhoneNumber(phone);
                validPhones.add(phone);

            } catch (InvalidPhoneNumberLengthException e) {
                invalidPhones.put(phone, e.getMessage());
            }
        }
        System.out.println("\n===== KET QUA =====");

        System.out.println("So dien thoai hop le:");
        System.out.println(validPhones);

        System.out.println("\nSo dien thoai khong hop le:");
        for (Map.Entry<String, String> entry : invalidPhones.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
