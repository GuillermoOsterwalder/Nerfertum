package corp.tarta.nerfertum.Model.Entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by mariano on 27/06/17.
 *
 */
public class OrderInvoice {

    private Long id;
    private Timestamp date;
    private Long buyerId;
    private Float total;

    public OrderInvoice(){
        id = 0l;
        date = Timestamp.valueOf(LocalDateTime.now());
        buyerId = -1l;
        total = 0f;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}