package corp.tarta.nerfertum.Exceptions;

/**
 * Created by morio on 30/06/17.
 */
public class EpsonPrinterException extends Exception{

  public EpsonPrinterException(){
    super(Errors.PRINTER_FAIL.getErrorMssg());
  }

}
