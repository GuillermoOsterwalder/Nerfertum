package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.Account;
import corp.tarta.nerfertum.Model.Entities.AccountMovement;

import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface AccountService {

  void addAccount(Account account) throws AlreadyExistsException, NullValueException;

  Account getAccount(Long id) throws NotFoundException, NullValueException;

  Account getAccountByOwner(Long id) throws NotFoundException, NullValueException;

  void updateAccount(Account account) throws NotFoundException, NullValueException;

  void deleteAccount(Long id) throws NotFoundException, NullValueException;

  List<AccountMovement> getMovements(Long id) throws NotFoundException, NullValueException;

  void addMovement(AccountMovement accountMovement) throws NotFoundException, NullValueException;
}
