package QuanLyDonHangVaThongKeNgayGiaoHang.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;

public class Order {
    private int id;
    private String customerName;
    private LocalDate createdDate;
    private Optional<LocalDate> deliveryDate;

    public Order() {
    }

    public Order(int id, String customerName, LocalDate createdDate, Optional<LocalDate> deliveryDate) {
        this.id = id;
        this.customerName = customerName;
        this.createdDate = createdDate;
        this.deliveryDate = Optional.ofNullable(
                deliveryDate != null ? deliveryDate.orElse(null) : null
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Optional<LocalDate> getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Optional<LocalDate> deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public String toDisplayString(){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String delivery=deliveryDate.map(d->d.format(dtf)).orElse("Chua giao");
        return "ID: "+id+"| Name: "+customerName+"| Created Date: "+createdDate.format(dtf)+"| Delivery Date: "+delivery;
    }
}
