package ZooManagement;

import java.util.Scanner;

public class ZooApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Dog dog=new Dog("Buddy",3,true);
        Cat cat = new Cat("Whiskers", 2, true);
        Elephant elephant = new Elephant("Dumbo", 5, false);
        boolean running=true;
        while (true){
            System.out.println("\n=== Zoo Management Menu ===");
            System.out.println("1. Show info of all animals");
            System.out.println("2. Make all animals sound");
            System.out.println("3. Feed animals");
            System.out.println("4. Special action of animals");
            System.out.println("5. Test eat(food) overloading");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    dog.showInfor();
                    cat.showInfor();
                    elephant.showInfor();
                    break;
                case 2:
                    dog.makeSound();
                    cat.makeSound();
                    elephant.makeSound();
                    break;
                case 3:
                    dog.eat();
                    cat.eat();
                    elephant.eat();
                    break;
                case 4:
                    dog.fetchBall();
                    cat.climbTree();
                    elephant.sprayWater();
                    break;
                case 5:
                    System.out.println("Enter food for animals: ");
                    String food=sc.nextLine();
                    dog.eat(food);
                    cat.eat(food);
                    elephant.eat(food);
                    break;
                case 0:
                    running=false;
                    System.out.println("Existing ZooApp .....");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            sc.close();
        }

    }
}
