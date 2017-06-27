package corp.tarta.nerfertum.Model.Entities;

/**
 * Created by mariano on 27/06/17.
 */
public class CartProduct {

    private Long productId;
    private Integer quantity;
    private Float total;

    public CartProduct(){
        productId = -1l;
        quantity = 0;
        total = 0f;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
