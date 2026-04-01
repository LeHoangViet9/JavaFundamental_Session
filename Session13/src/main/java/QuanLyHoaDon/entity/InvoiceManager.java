package QuanLyHoaDon.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceManager implements Manage<Invoice>{

    Scanner sc=new Scanner(System.in);
    private List<Invoice> list=new ArrayList<>();
    @Override
    public void add(Invoice item) {
        list.add(item);
        System.out.println("Thêm thành công");
    }

    @Override
    public void update(int index, Invoice item) {
        if(index<0||index>list.size()){
            System.out.println("Index không hợp lệ");
        }
        else{
            list.set(index,item);
        }
    }

    @Override
    public void delete(int index) {
        if(index<0||index>=list.size()){
            System.out.println("Index không hợp lệ");
        }
        else{
            list.remove(index);
        }
    }

    @Override
    public void display() {
        if(list.isEmpty()){
            System.out.println("Danh sách rỗng");
            return;
        }
        for(Invoice i:list){
            System.out.println(i.toString());
        }
    }
    public int findIndexById(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
}
