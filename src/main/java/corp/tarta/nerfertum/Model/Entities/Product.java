package corp.tarta.nerfertum.Model.Entities;

/**
 * Created by mariano on 26/06/17.
 */
public class Product {

    protected Long id;
    protected String description;
    protected Float costPrice;
    protected Float winningPercent;
    protected Float sellPrice;
    protected Integer quantity;

    public Product(){
        id = 0l;
        description = "";
        costPrice = 0f;
        winningPercent = 0f;
        sellPrice = 0f;
        quantity = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Float costPrice) {
        this.costPrice = costPrice;
    }

    public Float getWinningPercent() {
        return winningPercent;
    }

    public void setWinningPercent(Float winningPercent) {
        this.winningPercent = winningPercent;
    }

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
