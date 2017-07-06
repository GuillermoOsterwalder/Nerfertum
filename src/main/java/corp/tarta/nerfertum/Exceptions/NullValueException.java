package corp.tarta.nerfertum.Exceptions;

/**
 * Created by mariano on 04/07/17.
 */
public class NullValueException extends Exception {

    public NullValueException(){
        super(Errors.NULL_VALUE.getErrorMssg());
    }

}
