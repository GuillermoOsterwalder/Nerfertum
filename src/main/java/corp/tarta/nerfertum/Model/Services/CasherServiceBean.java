package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.AccountMovement;
import corp.tarta.nerfertum.Model.Entities.PrivateAccountMovement;
import corp.tarta.nerfertum.Model.Repositories.AccountMovementRepository;
import corp.tarta.nerfertum.Model.Repositories.PrivateAccountMovementRepository;

import java.util.List;

/**
 * Created by mariano on 05/07/17.
 */
public class CasherServiceBean implements CasherService{

    private final Long CASHER_ID = 1l;

    private static CasherServiceBean instance = null;

    private PrivateAccountMovementRepository privateAccountMovementRepository;


    private CasherServiceBean(){
        //privateAccountRepository = new PrivateAccountRepositoryBean();
    }

    public static CasherService getInstance(){
        if (instance == null){
            instance = new CasherServiceBean();
        }
        return instance;
    }

    @Override
    public void addMovement(PrivateAccountMovement privateAccountMovement) throws NullValueException {
        if(privateAccountMovement != null){
            privateAccountMovementRepository.save(privateAccountMovement);
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public void endDay() {
        privateAccountMovementRepository.deleteAllFromAccount(this.CASHER_ID);
        //printer zday();
    }

    @Override
    public Float getBalance() {
        List<PrivateAccountMovement> privateAccountMovements = privateAccountMovementRepository.findByAccount(this.CASHER_ID);
        Float balance = 0f;
        for(PrivateAccountMovement privateAccountMovement: privateAccountMovements){
            balance += privateAccountMovement.getAmmount();
        }
        return balance;
    }

    @Override
    public List<PrivateAccountMovement> getAllMovements() {
        return privateAccountMovementRepository.findByAccount(this.CASHER_ID);

    }

    @Override
    public Long getCasherId() {
        return this.CASHER_ID;
    }
}
