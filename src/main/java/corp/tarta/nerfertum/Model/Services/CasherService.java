package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.AccountMovement;
import corp.tarta.nerfertum.Model.Entities.PrivateAccountMovement;

import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface CasherService {

    void addMovement(PrivateAccountMovement privateAccountMovement) throws NullValueException;

    void endDay();

    Float getBalance();

    List<PrivateAccountMovement> getAllMovements();

    Long getCasherId();
}
