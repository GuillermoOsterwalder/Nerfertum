package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.Account;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface AccountRepository {

    public void save(Account account);

    public Account findOne(Long id);

    public void update(Account account);

    public void delete(Long id);

    public List<Account> findAll();

    public List<Account> findByOwner(Long id);
}
