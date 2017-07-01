package corp.tarta.nerfertum.Model.IOControllers;

import corp.tarta.nerfertum.Exceptions.EpsonPrinterException;
import corp.tarta.nerfertum.Model.Entities.ShoppingCart;

import java.awt.print.PrinterException;

/**
 * Created by morio on 28/06/17.
 */
public interface PrintController {

  void connect(String port) throws EpsonPrinterException;

  void printTicket(ShoppingCart shoppingCart) throws EpsonPrinterException;

  void zClose();

  void disconnect() throws EpsonPrinterException;

  boolean status();

  void setPort(String port);
}
