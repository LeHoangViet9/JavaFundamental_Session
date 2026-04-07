package XayDungUngDungChat.view;

import XayDungUngDungChat.model.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class main {
    static Scanner sc=new Scanner(System.in);
    static List<Message> list=new ArrayList<>();
    static DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static void sendMessage(){
        System.out.println("Enter sender: ");
        String sender=sc.nextLine();
        System.out.println("Enter content: ");
        String content=sc.nextLine();
        LocalDateTime now=LocalDateTime.now();
        list.add(new Message(sender,content,now));
        System.out.println("Sent");
    }
    static void show(){
        if(list.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        list.forEach(System.out::println);
    }
    static void filterBySender(){
        System.out.println("Enter sender");
        String sender=sc.nextLine();
        List<Message> listBySender=list.stream().filter(s->s.getSender().equalsIgnoreCase(sender)).collect(Collectors.toList());
        if(listBySender.isEmpty()){
            System.out.println("List is empty");
        }else{
            listBySender.forEach(System.out::println);
        }
    }
    static void filterByDate(){
        try {
            System.out.println("Enter date: ");
            LocalDateTime date=LocalDateTime.parse(sc.nextLine(),dtf);
            List<Message> listByDate=list.stream().filter(d->d.getTimestamp().equals(date)).collect(Collectors.toList());
            if (list.isEmpty()) {
                System.out.println("No messages on this date!");
            } else {
                list.forEach(System.out::println);
            }
        }catch (Exception e){
            System.out.println("Wrong date format! (dd/MM/yyyy)");

        }
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== CHAT MENU =====");
            System.out.println("1. Send message");
            System.out.println("2. Show history");
            System.out.println("3. Filter by sender");
            System.out.println("4. Filter by date");
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
                    sendMessage();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    filterBySender();
                    break;
                case 4:
                    filterByDate();
                    break;
                case 0:
                    return;
            }
        }
    }

}
