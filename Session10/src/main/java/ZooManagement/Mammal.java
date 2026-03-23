package ZooManagement;

import ZooManagement.Animal;

public class Mammal extends Animal {
    boolean hasFur;

    public Mammal(String name,int age,boolean hasFur) {
        super(name,age);
        this.hasFur = hasFur;
    }

    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("Has fur: "+hasFur);
    }
}
