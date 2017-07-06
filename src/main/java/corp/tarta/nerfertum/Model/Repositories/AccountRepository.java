package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.Account;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface AccountRepository {

    void save(Account account);

    Account findOne(Long id);

    void update(Account account);

    void delete(Long id);

    List<Account> findAll();

    Account findByOwner(Long id);

    Long nextId();
}
