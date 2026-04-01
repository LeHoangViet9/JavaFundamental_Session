package QuanLyPhim;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManager<Movie> manager = new MovieManager<>();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them phim");
            System.out.println("2. Sua phim");
            System.out.println("3. Xoa phim");
            System.out.println("4. Hien thi");
            System.out.println("5. Tim theo ten");
            System.out.println("6. Loc rating > 8");
            System.out.println("0. Thoat");

            System.out.print("Chon: ");
            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhap sai!");
                continue;
            }

            try {
                switch (choice) {

                    case 1: // add
                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Ten: ");
                        String title = sc.nextLine();

                        System.out.print("Dao dien: ");
                        String director = sc.nextLine();

                        System.out.print("Ngay (yyyy-MM-dd): ");
                        LocalDate date = LocalDate.parse(sc.nextLine());

                        System.out.print("Rating: ");
                        double rating = Double.parseDouble(sc.nextLine());

                        manager.add(new Movie(id, title, director, date, rating));
                        System.out.println("Them thanh cong!");
                        break;

                    case 2: // update
                        System.out.print("Nhap ID can sua: ");
                        String uid = sc.nextLine();

                        System.out.print("Ten moi: ");
                        String newTitle = sc.nextLine();

                        System.out.print("Dao dien moi: ");
                        String newDirector = sc.nextLine();

                        System.out.print("Ngay moi: ");
                        LocalDate newDate = LocalDate.parse(sc.nextLine());

                        System.out.print("Rating moi: ");
                        double newRating = Double.parseDouble(sc.nextLine());

                        boolean updated = manager.edit(uid,
                                new Movie(uid, newTitle, newDirector, newDate, newRating));

                        System.out.println(updated ? "Sua thanh cong!" : "Khong tim thay!");
                        break;

                    case 3: // delete
                        System.out.print("Nhap ID can xoa: ");
                        String did = sc.nextLine();

                        boolean deleted = manager.delete(did);
                        System.out.println(deleted ? "Xoa thanh cong!" : "Khong tim thay!");
                        break;

                    case 4:
                        manager.show();
                        break;

                    case 5:
                        System.out.print("Nhap ten can tim: ");
                        manager.searchByName(sc.nextLine());
                        break;

                    case 6:
                        manager.filterRating();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Lua chon sai!");
                }

            } catch (DateTimeException e) {
                System.out.println("Sai dinh dang ngay (yyyy-MM-dd)!");
            } catch (NumberFormatException e) {
                System.out.println("Rating phai la so!");
            }
        }
    }
}
