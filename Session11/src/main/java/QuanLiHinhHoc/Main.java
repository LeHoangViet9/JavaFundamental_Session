package QuanLiHinhHoc;

public class Main {
    public static void main(String[] args) {
        Shape []shapes=new Shape[2];
        shapes[0]=new Rectangle(3,4);
        shapes[1]=new Circle(2);
        for (Shape s:shapes){
            s.displayInfor();
            System.out.println("Area: "+s.getArea());
            System.out.println("Perimeter: "+s.getPerimeter());
            ((Drawable)s).draw();
        }


    }
}
