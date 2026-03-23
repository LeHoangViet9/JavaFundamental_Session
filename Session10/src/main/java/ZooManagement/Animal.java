package ZooManagement;

public class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void showInfor(){
        System.out.println("Name: "+name+"\t Age: "+age);
    }
    public void makeSound(){
        System.out.println("Some generic animal sound");
    }
    public  void eat(){
        System.out.println(name+" is eating");
    }
    public void eat(String food){
        System.out.println(name +" is eating "+food+".");
    }
}
