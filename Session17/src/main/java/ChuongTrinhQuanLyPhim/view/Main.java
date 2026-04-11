package ChuongTrinhQuanLyPhim.view;

import ChuongTrinhQuanLyPhim.controller.MovieManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MovieManagement mm=new MovieManagement();
        while(true){
            System.out.println("============ MOVIE ============\n" +
                    "1. Add Movie\n" +
                    "2. Show all moive\n" +
                    "3. Update movie\n" +
                    "4. Delete movie\n" +
                    "Your choice: ");
            int n=Integer.parseInt(sc.nextLine());
            switch (n){
                case 1:
                    System.out.println("Title: ");
                    String title=sc.nextLine();
                    System.out.println("Director: ");
                    String director=sc.nextLine();
                    System.out.println("Year: ");
                    int year=Integer.parseInt(sc.nextLine());
                    mm.add(title,director,year);
                    break;
                case 2:
                    mm.show();
                    break;
                case 3:
                    System.out.println("ID: ");
                    int id=Integer.parseInt(sc.nextLine());
                    System.out.println("Title: ");
                     title=sc.nextLine();
                    System.out.println("Director: ");
                     director=sc.nextLine();
                    System.out.println("Year: ");
                     year=Integer.parseInt(sc.nextLine());
                     mm.update(id,title,director,year);
                     break;
                case 4:
                    System.out.println("Enter your id your want delete; ");
                    id=Integer.parseInt(sc.nextLine());
                    mm.delete(id);
                    break;
                default:
                    System.out.println("Error!");
            }
        }
    }
}
