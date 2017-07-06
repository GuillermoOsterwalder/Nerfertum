package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.Account;
import corp.tarta.nerfertum.Model.Entities.AccountMovement;
import corp.tarta.nerfertum.Model.Repositories.AccountMovementRepository;
import corp.tarta.nerfertum.Model.Repositories.AccountRepository;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by morio on 30/06/17.
 */
public class AccountServiceBean implements AccountService{

  private static AccountServiceBean instance = null;

  AccountRepository accountRepository;
  AccountMovementRepository accountMovementRepository;

  private AccountServiceBean(){
    //accountRepository = new AccountRepositoryBean();
    //accountMovementRepository = new AccountMovementRepository();
  }

  public static AccountServiceBean getInstance(){
    if (instance == null){
      instance = new AccountServiceBean();
    }
    return instance;
  }

  @Override
  public void addAccount(Account account) throws AlreadyExistsException, NullValueException {
    if(account != null){
      Account persistedAccount = accountRepository.findOne(account.getId());
      if(persistedAccount == null){
        accountRepository.save(account);
      }else{
        throw new AlreadyExistsException();
      }
    }else{
      throw new NullValueException();
    }
  }

  @Override
  public Account getAccount(Long id) throws NotFoundException, NullValueException {
    if(id != null){
      Account persistedAccount = accountRepository.findOne(id);
      if(persistedAccount != null){
        return persistedAccount;
      }else{
        throw new NotFoundException();
      }
    }else{
      throw new NullValueException();
    }
  }

  @Override
  public Account getAccountByOwner(Long id) throws NotFoundException, NullValueException {
    if(id != null){
      Account persistedAccount = accountRepository.findByOwner(id);
      if(persistedAccount != null){
        return persistedAccount;
      }else{
        throw new NotFoundException();
      }
    }else{
      throw new NullValueException();
    }
  }

  @Override
  public void updateAccount(Account account) throws NotFoundException, NullValueException {
    if(account != null){
      Account persistedAccount = accountRepository.findOne(account.getId());
      if(persistedAccount != null){
        accountRepository.update(account);
      }else{
        throw new NotFoundException();
      }
    }else{
      throw new NullValueException();
    }
  }

  @Override
  public void deleteAccount(Long id) throws NotFoundException, NullValueException {
    if(id != null){
      Account persistedAccount = accountRepository.findOne(id);
      if(persistedAccount != null){
        accountRepository.delete(id);
      }else{
        throw new NotFoundException();
      }
    }else{
      throw new NullValueException();
    }
  }

  @Override
  public List<AccountMovement> getMovements(Long id) throws NotFoundException, NullValueException {
    if(id != null){
      Account persistedAccount = accountRepository.findOne(id);
      if(persistedAccount != null){
        return accountMovementRepository.findByAccount(id);
      }else{
        throw new NotFoundException();
      }
    }else{
      throw new NullValueException();
    }
  }

  @Override
  public void addMovement(AccountMovement accountMovement) throws NotFoundException, NullValueException {
    if(accountMovement != null){
      Account persistedAccount = accountRepository.findOne(accountMovement.getAccountId());
      if(persistedAccount != null){
        accountMovementRepository.save(accountMovement);
      }else{
        throw new NotFoundException();
      }
    }else{
      throw new NullValueException();
    }
  }
}
