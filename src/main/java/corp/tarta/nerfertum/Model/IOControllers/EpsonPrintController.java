package corp.tarta.nerfertum.Model.IOControllers;

import IFDrivers.EpsonTicket;
import corp.tarta.nerfertum.Exceptions.EpsonPrinterException;
import corp.tarta.nerfertum.Model.Entities.CartProduct;
import corp.tarta.nerfertum.Model.Entities.ShoppingCart;
import corp.tarta.nerfertum.Model.Services.ShoppingCartService;

import java.awt.print.PrinterException;
import java.util.logging.Logger;

/**
 * Created by morio on 30/06/17.
 */
public class EpsonPrintController implements PrintController {

  private final int BOUNDS = 9600;
  private final String STATUS_CODE_NORMAL = "N";

  private static EpsonPrintController instance = null;

  private Logger logger;

  private EpsonTicket printerManager;
  private String port;

  private EpsonPrintController(){
    printerManager = new EpsonTicket();
    port = "COM2";
    logger = Logger.getLogger(this.getClass().getName());
  }

  public static EpsonPrintController getInstance(){
    if(instance == null){
      instance = new EpsonPrintController();
    }
    return instance;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  @Override
  public void connect(String port) throws EpsonPrinterException {
    int connection_error = printerManager.IF_OPEN(port, this.BOUNDS);
    if (connection_error != 0){
      logger.info("Could not connect to printer at port: " + port);
      throw new EpsonPrinterException();
    }
    logger.info("Connection to printer successfull at port: " + port );
  }

  @Override
  public void printTicket(ShoppingCart shoppingCart) throws EpsonPrinterException {
      connect(this.port);
      openTicket();
      for(CartProduct cartProduct : shoppingCart.getProducts()){
        addItemToTicket(cartProduct);
      }
      addDiscount(0f);
      addPayment(0f);
      closeTicket();
      disconnect();
  }

  @Override
  public void zClose() {

  }

  private void openTicket() throws EpsonPrinterException{
    int connection_error = printerManager.TIQUEABRE("C");
    if (connection_error != 0){
      logger.info("Error to open ticket" );
      throw new EpsonPrinterException();
    }
    logger.info("Ticket successfull opened!" );
  }

  private void addTextToTicket(String text) throws EpsonPrinterException{
    int connection_error = printerManager.TIQUETEXTO(text);
    if (connection_error != 0){
      logger.info("Error to add text to ticket" );
      throw new EpsonPrinterException();
    }
    logger.info("Ticket's text successfull added!" );
  }

  private void addItemToTicket(CartProduct cartProduct) throws EpsonPrinterException{
    int connection_error = printerManager.TIQUEITEM(cartProduct.getDescription(),
        Double.valueOf(cartProduct.getQuantity()), Double.valueOf(cartProduct.getTotal()),
        Double.valueOf(10.5f),"M",1,0d,0d);
    if (connection_error != 0){
      logger.info("Error to add item to ticket" );
      throw new EpsonPrinterException();
    }
    logger.info("Ticket's item successfull added!" );
  }

  private void addDiscount(Float disscount) throws  EpsonPrinterException{
    if( disscount > 0){
      int connection_error = printerManager.TIQUEPAGO("Bonificación: ",
          disscount.doubleValue(),"D");
      if (connection_error != 0){
        logger.info("Error to add disscount to ticket" );
        throw new EpsonPrinterException();
      }
      logger.info("Ticket's disscount successfull added!" );
    }
  }

  private void addPayment(Float payment) throws EpsonPrinterException{
    if( payment > 0){
      int connection_error = printerManager.TIQUEPAGO("Su pago en pesos: ",
          payment.doubleValue(),"T");
      if (connection_error != 0){
        logger.info("Error to add payment to ticket" );
        throw new EpsonPrinterException();
      }
      logger.info("Ticket's text payment added!" );
    }
  }

  private void closeTicket() throws EpsonPrinterException{
    int connection_error = printerManager.TIQUECIERRA("T");
    if (connection_error != 0){
      logger.info("Error to close ticket" );
      throw new EpsonPrinterException();
    }
    logger.info("Ticket successfull closed!" );
  }

  @Override
  public void disconnect() throws EpsonPrinterException {
    int connection_error = printerManager.IF_CLOSE();
    if (connection_error != 0){
      throw new EpsonPrinterException();
    }
  }

  @Override
  public boolean status() {
    int connection_error = printerManager.ESTADO(this.STATUS_CODE_NORMAL);
    return (connection_error == 0) ? true : false;
  }
}
