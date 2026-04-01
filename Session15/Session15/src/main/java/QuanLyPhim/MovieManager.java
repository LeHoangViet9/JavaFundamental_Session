package QuanLyPhim;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MovieManager <T extends Movie>{
    private List<T> list=new ArrayList<>();

    public void add(T movie){
        list.add(movie);
    }

    public boolean edit(String id,T movie){
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(id)){
                list.set(i,movie);
                return true;
            }
        }
        return false;
    }
    public boolean delete(String id){
        return list.removeIf(m -> m.getId().equals(id));
    }

    public void show(){
        if(list.isEmpty()){
            System.out.println("Danh sách rỗng");
            return;
        }
        for(T t:list){
            System.out.println(t);
        }

    }
    public void searchByName(String name){
        boolean isExist=false;
        for(T t:list){
            if(t.getTitle().toLowerCase().contains(name.toLowerCase())){
                System.out.println(t);
                isExist=true;
            }
        }
        if(!isExist){
            System.out.println("Không tìm thấy");
        }
    }
    public void filterRating(){
        for(T t:list){
            if(t.getRating()>8.0){
                System.out.println(t);
            }
        }
    }
}
