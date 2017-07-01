package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Model.Entities.Account;
import corp.tarta.nerfertum.Model.Repositories.AccountRepository;

import java.util.logging.Logger;

/**
 * Created by morio on 30/06/17.
 */
public class AccountServiceBean implements AccountService{

  Logger logger;

  AccountRepository accountRepository;

  private AccountServiceBean(){
    //accountRepository = new AccountRepositoryBean();
  }

  @Override
  public void addAccount(Account account) throws AlreadyExistsException {
    Account persistedAccount = accountRepository.findOne(account.getId());
    if (persistedAccount != null) {
      logger.severe("Fail to add account: " + account.getId() + " ,already exists.");
      throw new AlreadyExistsException();
    }
    accountRepository.save(account);
    logger.info("Success to add account: " + account.getId() + ".");
  }

  @Override
  public Account getAccount(Long id) throws NotFoundException {
    Account persistedAccount = accountRepository.findOne(id);
    if (persistedAccount == null) {
      logger.severe("Fail to get account: " +id + " ,not exists.");
      throw new NotFoundException();
    }
    logger.info("Success to read account: " + id + ".");
    return persistedAccount;
  }

  @Override
  public Account getAccountByOwner(Long id) throws NotFoundException {
    return null;
  }

  @Override
  public void updateAccount(Account account) throws NotFoundException {

  }

  @Override
  public void deleteAccount() throws NotFoundException {

  }
}
