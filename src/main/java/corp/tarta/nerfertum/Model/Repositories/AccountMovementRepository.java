package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.AccountMovement;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface AccountMovementRepository {

    public void save(AccountMovement accountMovement);

    public AccountMovement findOne(Long id);

    public void update(AccountMovement accountMovement);

    public void delete(Long id);

    public List<AccountMovement> findAll();

    public List<AccountMovement> findByAccount(Long id);
}
