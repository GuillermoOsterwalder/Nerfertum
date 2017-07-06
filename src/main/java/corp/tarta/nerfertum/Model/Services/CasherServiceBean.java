package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.AccountMovement;
import corp.tarta.nerfertum.Model.Repositories.AccountMovementRepository;

import java.util.List;

/**
 * Created by mariano on 05/07/17.
 */
public class CasherServiceBean implements CasherService{

    private final Long CASHER_ID = 999999l;

    private static CasherServiceBean instance = null;

    private AccountMovementRepository accountMovementRepository;


    private CasherServiceBean(){
        //accountRepository = new AccountRepositoryBean();
    }

    public static CasherService getInstance(){
        if (instance == null){
            instance = new CasherServiceBean();
        }
        return instance;
    }

    @Override
    public void addMovement(AccountMovement accountMovement) throws NullValueException {
        if(accountMovement != null){
            accountMovementRepository.save(accountMovement);
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public void endDay() {
        accountMovementRepository.deleteAllFromAccount(this.CASHER_ID);
        //printer zday();
    }

    @Override
    public Float getBalance() {
        List<AccountMovement> accountMovements = accountMovementRepository.findByAccount(this.CASHER_ID);
        Float balance = 0f;
        for(AccountMovement accountMovement: accountMovements){
            balance += accountMovement.getAmmount();
        }
        return balance;
    }

    @Override
    public List<AccountMovement> getAllMovements() {
        return accountMovementRepository.findByAccount(this.CASHER_ID);

    }

    @Override
    public Long getCasherId() {
        return this.CASHER_ID;
    }
}
