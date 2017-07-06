package corp.tarta.nerfertum.Model.Entities;

import java.time.LocalDateTime;

/**
 * Created by mariano on 26/06/17.
 */
public class ProviderProduct {

    private Long id;
    private Long ownerId;
    private Long assosiatedProduct;
    private String description;
    private Float price;


    public ProviderProduct(){
        id = 0l;
        ownerId = -1l;
        assosiatedProduct = -1l;
        description = "";
        price = 0f;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getAssosiatedProduct() {
        return assosiatedProduct;
    }

    public void setAssosiatedProduct(Long assosiatedProduct) {
        this.assosiatedProduct = assosiatedProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
