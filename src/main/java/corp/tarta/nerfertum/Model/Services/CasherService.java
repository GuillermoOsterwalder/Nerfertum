package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.AccountMovement;

import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface CasherService {

    void addMovement(AccountMovement accountMovement) throws NullValueException;

    void endDay();

    Float getBalance();

    List<AccountMovement> getAllMovements();

    Long getCasherId();
}
