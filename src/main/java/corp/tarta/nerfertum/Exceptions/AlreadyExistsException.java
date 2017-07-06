package corp.tarta.nerfertum.Exceptions;

/**
 * Created by mariano on 26/06/17.
 */
public class AlreadyExistsException extends Exception{

    public AlreadyExistsException(){
        super(Errors.ALREADY_EXISTS.getErrorMssg());
    }
}
