package QuanLyDiemDanh.entity;

import java.util.ArrayList;
import java.util.List;

public class AttendanceManager implements Manage<Student>{

    private List<Student> list=new ArrayList<>();
    @Override
    public void add(Student item) {
            list.add(item);
        System.out.println("Thêm thành công");
    }

    @Override
    public void update(int index, Student item) {
        if (index >= 0 && index < list.size()) {
            list.set(index, item);
            System.out.println(">> Cập nhật thành công");
        } else {
            System.out.println(">> Index không hợp lệ");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            System.out.println(">> Xóa thành công");
        } else {
            System.out.println(">> Index không hợp lệ");
        }
    }

    @Override
    public void display() {
        if(list.isEmpty()){
            System.out.println("Danh sách rỗng");
        }
        else{
            for(int i=0;i<list.size();i++){
                System.out.println(i+"\t"+list.get(i));
            }
        }
    }
}
