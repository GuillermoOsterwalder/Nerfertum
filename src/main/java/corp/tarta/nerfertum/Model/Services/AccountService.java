package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Model.Entities.Account;

/**
 * Created by morio on 28/06/17.
 */
public interface AccountService {

  void addAccount(Account account) throws AlreadyExistsException;

  Account getAccount(Long id) throws NotFoundException;

  Account getAccountByOwner(Long id) throws NotFoundException;

  void updateAccount(Account account) throws NotFoundException;

  void deleteAccount() throws NotFoundException;
}
