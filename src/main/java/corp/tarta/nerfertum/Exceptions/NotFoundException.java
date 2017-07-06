package corp.tarta.nerfertum.Exceptions;

/**
 * Created by morio on 28/06/17.
 */
public class NotFoundException extends Exception{

  public NotFoundException(){
    super(Errors.NOT_FOUND.getErrorMssg());
  }

}
