package QuanLiHinhHoc;

public abstract class Shape {
    private String name;

    public Shape() {
    }

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract double getArea();
    abstract double getPerimeter();
    void displayInfor(){
        System.out.println("Shape: "+name);
    }
}
