package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.Client;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface ClientRepository {

    public void save(Client client);

    public Client findOne(Long id);

    public void update(Client client);

    public void delete(Long id);

    public List<Client> findAll();

    public List<Client> findByName(String name);

    public List<Client> findByIdOrName(Long id, String name);

}
