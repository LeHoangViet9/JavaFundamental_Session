package QuanLyDonHangVaThongKeNgayGiaoHang.view;

import QuanLyDonHangVaThongKeNgayGiaoHang.model.Order;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> list = Arrays.asList(
                new Order(1, "An",
                        LocalDate.of(2025,3,17),
                        Optional.of(LocalDate.of(2025, 3, 18))),

                new Order(2, "Binh",
                        LocalDate.of(2025,3,18),
                        null),

                new Order(3, "Cuong",
                        LocalDate.of(2025,3,19),
                        Optional.of(LocalDate.of(2025, 3, 20))),

                new Order(4, "Dung",
                        LocalDate.of(2025,3,21),
                        null),

                new Order(5, "Em",
                        LocalDate.of(2025,3,22),
                        Optional.of(LocalDate.of(2025, 3, 23)))
        );
        System.out.println("các đơn hàng đã được giao");
        List<Order> giao=list.stream().filter(o->o.getDeliveryDate().isPresent()).collect(Collectors.toList());
        printOrders(giao);
        System.out.println("các đơn hàng chưa được giao");
        List<Order> chuagiao=list.stream().filter(o->o.getDeliveryDate().isEmpty()).collect(Collectors.toList());
        printOrders(chuagiao);

        LocalDate start = LocalDate.of(2025,3,17);
        LocalDate end = LocalDate.of(2025,3,23);
        long count=list.stream().
                filter(o->o.getDeliveryDate().isPresent()).
                filter(o->{
            LocalDate date =o.getDeliveryDate().get();
        return !date.isBefore(start)&&!date.isAfter(end);}).count();
        System.out.println(" số đơn hàng đã giao trong khoảng thời gian từ 2025-03-17 đến 2025-03-23: "+count);

    }
    static void printOrders(List<Order> list) {
        if (list.isEmpty()) {
            System.out.println("Không có đơn!");
            return;
        }
        list.forEach(o -> System.out.println(o.toDisplayString()));
    }
}
