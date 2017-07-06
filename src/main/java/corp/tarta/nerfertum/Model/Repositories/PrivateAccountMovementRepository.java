package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.PrivateAccountMovement;

import java.util.List;

/**
 * Created by morio on 06/07/17.
 */
public interface PrivateAccountMovementRepository {

  void save(PrivateAccountMovement accountMovement);

  PrivateAccountMovement findOne(Long id);

  List<PrivateAccountMovement> findByAccount(Long id);

  void deleteAllFromAccount(Long id);

  Long nextId();
}
