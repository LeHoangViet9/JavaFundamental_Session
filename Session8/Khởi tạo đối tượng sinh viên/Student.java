package BaiTap.KhoiTaoDoiTuongSinhVien;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student() {

    }

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }
}
