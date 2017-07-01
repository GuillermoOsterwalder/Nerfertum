package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Model.Entities.CartProduct;

import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface PrintService {

  boolean getStatusPrinter();

  void printTicket(List<CartProduct> cartProductList);

  void endZDay();

  boolean isZDayInitializated();
}
