package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.AccountMovement;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface AccountMovementRepository {

    void save(AccountMovement accountMovement);

    AccountMovement findOne(Long id);

    List<AccountMovement> findByAccount(Long id);

    void deleteAllFromAccount(Long id);
}
