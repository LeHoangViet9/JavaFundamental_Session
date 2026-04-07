package SuDungDateiTimeAPI.view;

import SuDungDateiTimeAPI.model.Event;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static List<Event> list=new ArrayList<>();
   static DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static void add(){
      try {
          System.out.println("Enter name: ");
          String name=sc.nextLine();
          System.out.println("Start date: ");
          LocalDateTime start=LocalDateTime.parse(sc.nextLine(),dtf);
          System.out.println("End date: ");
          LocalDateTime end=LocalDateTime.parse(sc.nextLine(),dtf);
          if(end.isBefore(start)){
              System.out.println("Wrong date");
              return;
          }
          list.add(new Event(name,start,end));
          System.out.println("Add sucessfull");
      }catch (Exception e){
          System.out.println("Wrong format");
      }
    }
    static void checkDate(){
        if(list.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        LocalDateTime now=LocalDateTime.now();
        for(Event e:list){
            if(now.isBefore(e.getStartDate())){
                System.out.println(e.getName()+" is comming");
            }
            else if (now.isAfter(e.getEndDate())){
                System.out.println(e.getName() + " → Finished");
            }
            else{
                System.out.println(e.getName() + " → Ongoing");
            }
        }
    }
    static void show(){
       if(list.isEmpty()){
           System.out.println("List is empty");
           return;
       }
       list.forEach(System.out::println);
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Event");
            System.out.println("2. Show Events");
            System.out.println("3. Check Status");
            System.out.println("0. Exit");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter number!");
                continue;
            }

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    checkDate();
                    break;
                case 0:
                    return;
            }
        }
    }

}
