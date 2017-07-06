package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.PrivateAccount;

import java.util.List;

/**
 * Created by morio on 06/07/17.
 */
public interface PrivateAccountRepository {

  void save(PrivateAccount privateAccount);

  PrivateAccount findOne(Long id);

  void update(PrivateAccount privateAccount);

  void delete(Long id);

  List<PrivateAccount> findAll();

  Long nextId();
}
