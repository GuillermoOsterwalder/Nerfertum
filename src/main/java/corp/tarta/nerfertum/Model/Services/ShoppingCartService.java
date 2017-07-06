package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.EpsonPrinterException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.CartProduct;
import corp.tarta.nerfertum.Model.Entities.Client;
import corp.tarta.nerfertum.Model.Entities.PaymentMethod;
import corp.tarta.nerfertum.Model.Entities.Product;

import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface ShoppingCartService {

  void addToCart(Product product, int quantity) throws NullValueException;

  void removeFromCart(Long id) throws NotFoundException, NullValueException;

  Float getSubTotal();

  void setDisscount(Float disscount) throws NullValueException;

  Float getDisscountPercent();

  Float getDisscountPrice();

  Float getTotal();

  void setClient(Client client) throws NullValueException;

  Client getClient();

  void setPaymentMethod(PaymentMethod paymentMethod) throws NullValueException;

  PaymentMethod getPaymentMethod();

  List<CartProduct> getAll();

  void clear();

  void executeSell() throws NotFoundException, NullValueException;

  void executeSellAndPrint() throws NullValueException, EpsonPrinterException;
}
