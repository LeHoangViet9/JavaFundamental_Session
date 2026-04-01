package QuanLyMonHoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubjectManager <T extends Subject>{
    List<T> list=new ArrayList<>();
    public void show(){
        if(list.isEmpty()){
            System.out.println("Danh sách rỗng");
            return;
        }
        for(T s:list){
            System.out.println(s);
        }
    }
    public void add(T subject){
        list.add(subject);
    }
    public boolean delete(String code){
        return list.removeIf(s->s.getCode().equals(code));
    }
    public void searchByName(String name){
        Optional<T> result=list.stream().filter(s->s.getName().toLowerCase().contains(name.toLowerCase())).findFirst();
            if(result.isPresent()){
                System.out.println(result.get());
            }
            else{
                System.out.println("Không tìm thấy");
            }

    }
    public void filterByCredit(){
        List<T> resut=list.stream().filter(s->s.getCredits()>3).collect(Collectors.toList());
        if(resut.isEmpty()){
            System.out.println("Không có môn học nào credit < 3");
        }
        else{
            resut.forEach(System.out::println);
        }
    }

}
