package QuanLiNhieuDoiTuong;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "Nguyen Van A", 100);
        Book b2 = new Book("OOP in Java", "Tran Thi B", 150);
        Book b3 = new Book("Data Structures", "Le Van C", 200);

        ArrayList<Book> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);

        for (Book b : list) {
            b.printInfo();
        }
    }
}
