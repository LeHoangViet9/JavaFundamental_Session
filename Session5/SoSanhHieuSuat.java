package BaiTap;

public class SoSanhHieuSuat {
    public static void main(String[] args) {
        int n=1000000000;
        String str="Hello";
        long start=System.currentTimeMillis();
        for(int i=0;i<n;i++){
            str+="World";
        }
        long end=System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với String: "+(end-start));
        StringBuilder sb=new StringBuilder("Hello");
        long start1=System.currentTimeMillis();
        for(int i=0;i<n;i++){
            sb.append("World");
        }
        long end1=System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuilder: "+(end1-start1));
        StringBuffer sb2=new StringBuffer("Hello");
        long start2=System.currentTimeMillis();
        for(int i=0;i<n;i++){
            sb.append("World");
        }
        long end2=System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuffer: "+(end2-start2));

    }
    // String là immutable (không thay đổi được) mỗi lần nối tạo Object mới tốn bộ nhớ + thời gian
    // StringBuilder nhanh nhât thay đổi trực tiếp trong bộ nhớ phù hợp với nối chuỗi nhiều lần
    // StringBuffer gần giống StringBuilder nhưng có thread-safe chậm hơn StringBuilder một chút
}
