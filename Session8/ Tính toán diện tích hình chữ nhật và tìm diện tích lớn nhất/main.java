package DienTichHCN;

public class main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(5, 2);
        Rectangle r3 = new Rectangle(4.5, 3.5);
        Rectangle[] arr = {r1, r2, r3};
        for (int i = 0; i < arr.length; i++) {
            Rectangle r = arr[i];
            System.out.println("Rectangle " + (i + 1) +
                    ": width=" + r.getWidth() +
                    ", height=" + r.getHeight() +
                    ", area=" + r.getArea() +
                    ", perimeter=" + r.getPermeter());
        }

        double maxArea = arr[0].getArea();
        int index = 0;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].getArea() > maxArea) {
                maxArea = arr[i].getArea();
                index = i;
                count = 1;
            } else if (arr[i].getArea() == maxArea) {
                count++;
            }
        }

        System.out.println();

        if (count > 1) {
            System.out.println("Co nhieu hinh co dien tich lon nhat = " + maxArea);
        } else {
            Rectangle r = arr[index];
            System.out.println("Largest area = " + maxArea +
                    " (Rectangle " + (index + 1) +
                    ": width=" + r.getWidth() +
                    ", height=" + r.getHeight() + ")");
        }
    }
}
