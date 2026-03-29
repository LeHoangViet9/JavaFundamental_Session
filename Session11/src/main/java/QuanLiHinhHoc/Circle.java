package QuanLiHinhHoc;

public class Circle extends Shape implements Drawable{

    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    double getArea() {
        return radius*radius*Math.PI;
    }

    @Override
    double getPerimeter() {
        return radius*Math.PI*2;
    }
}
