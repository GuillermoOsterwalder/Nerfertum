package corp.tarta.nerfertum.Model.Entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by morio on 28/06/17.
 */
public class ShoppingCart {

    private Map<Long,CartProduct> products;
    private Float disscount;
    private Client client;
    private PaymentMethod paymentMethod;

    public ShoppingCart(){
      products = new HashMap<>();
    }

  public Map<Long,CartProduct> getProducts() {
    return products;
  }

  public Float getDisscount() {
      return disscount;
  }

  public void setDisscount(Float disscount) {
      this.disscount = disscount;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

}
