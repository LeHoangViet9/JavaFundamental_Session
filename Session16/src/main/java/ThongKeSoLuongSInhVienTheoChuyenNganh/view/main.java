package ThongKeSoLuongSInhVienTheoChuyenNganh.view;

import ThongKeSoLuongSInhVienTheoChuyenNganh.model.Student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("An", "IT", 8.5),
                new Student("Binh", "Business", 7.0),
                new Student("Cuong", "IT", 9.0),
                new Student("Dung", "Design", 6.5),
                new Student("Em", "IT", 7.5),
                new Student("Huy", "Business", 8.0),
                new Student("Khanh", "Design", 7.2),
                new Student("Linh", "IT", 8.8),
                new Student("Minh", "Business", 6.9),
                new Student("Nam", "Design", 7.8)
        );
        Map<String,Long> map=list.stream().collect(Collectors.groupingBy(Student::getMajor,Collectors.counting()));

        List<Map.Entry<String,Long>>sorted=map.entrySet().stream().sorted((a,b)->a.getValue().compareTo(b.getValue())).collect(Collectors.toList());
        System.out.println("=======Statistc==============");
        for(Map.Entry<String,Long> entry:sorted){
            System.out.println("Major: "+entry.getKey()+"| Count: "+entry.getValue());
        }
    }
}
