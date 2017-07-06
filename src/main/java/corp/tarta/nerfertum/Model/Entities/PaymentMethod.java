package corp.tarta.nerfertum.Model.Entities;

/**
 * Created by mariano on 27/06/17.
 */
public class PaymentMethod {

    private Long id;
    private String method;
    private Float percent;

    public PaymentMethod(){
        id = 0l;
        method = "";
        percent = 0f;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Float getPercent() {
        return percent;
    }

    public void setPercent(Float percent) {
        this.percent = percent;
    }
}
