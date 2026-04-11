package QuanLySachTrongThuVien.presentation;

import QuanLySachTrongThuVien.dao.BookDAO;
import QuanLySachTrongThuVien.model.Book;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {
            System.out.println("\n1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Find by author");
            System.out.println("5. List all");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Year: ");
                    int year = sc.nextInt();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    dao.add(new Book(title, author, year, price));
                    break;

                case 4:
                    System.out.print("Author: ");
                    List<Book> list = dao.findByAuthor(sc.nextLine());

                    for (Book b : list) {
                        System.out.println(b.getTitle() + " - " + b.getAuthor());
                    }
                    break;

                case 5:
                    for (Book b : dao.getAllBooks()) {
                        System.out.println(b);
                    }
                    break;

                case 0:
                    return;
            }
        }

    }
}
