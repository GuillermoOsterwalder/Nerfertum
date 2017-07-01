package corp.tarta.nerfertum.Model.Entities;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public class ShoppingCart {

    private List<CartProduct> products;
    private Client client;
    private PaymentMethod paymentMethod;

    public ShoppingCart(){
      products = new LinkedList<>();
    }

  public List<CartProduct> getProducts() {
    return products;
  }

  public void setProducts(List<CartProduct> products) {
    this.products = products;
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
