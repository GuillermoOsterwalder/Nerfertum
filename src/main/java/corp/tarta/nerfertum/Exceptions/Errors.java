package corp.tarta.nerfertum.Exceptions;

/**
 * Created by mariano on 26/06/17.
 */
public enum Errors {

    NULL_VALUE("Null value"),
    NOT_FOUND("Not found"),
    ALREADY_EXISTS("Already Exists"),
    PRINTER_FAIL("Error to print at the specified port");

    private String errorMssg;

    Errors(String errorMssg){
        this.errorMssg = errorMssg;
    }

    public String getErrorMssg(){
        return this.errorMssg;
    }
}
