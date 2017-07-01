package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Model.Entities.CartProduct;
import corp.tarta.nerfertum.Model.Entities.Client;
import corp.tarta.nerfertum.Model.Entities.PaymentMethod;
import corp.tarta.nerfertum.Model.Entities.Product;

/**
 * Created by morio on 28/06/17.
 */
public interface ShoppingCartService {

  void addToCart(Product product, int quantity);

  void addToCart(CartProduct cartProduct);

  CartProduct getCartProduct(Long id);

  void updateToCart(CartProduct cartProduct);

  void removeFromCart(Long id);

  Float getSubTotal();

  Float getDisscount();

  Float getTotal();

  void setClient(Client client);

  Client getClient();

  void setPaymentMethod(PaymentMethod paymentMethod);

  PaymentMethod getPaymentMethod();

  void executeSell();

  void executeSellAndPrint();
}
