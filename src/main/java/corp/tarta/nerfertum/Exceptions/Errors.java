package corp.tarta.nerfertum.Exceptions;

/**
 * Created by mariano on 26/06/17.
 */
public enum Errors {

    ALREADY_EXISTS("Already Exists");

    private String errorMssg;

    Errors(String errorMssg){
        this.errorMssg = errorMssg;
    }

    public String getErrorMssg(){
        return this.errorMssg;
    }
}
