package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.Client;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface ClientRepository {

    void save(Client client);

    Client findOne(Long id);

    void update(Client client);

    void delete(Long id);

    List<Client> findAll();


}
