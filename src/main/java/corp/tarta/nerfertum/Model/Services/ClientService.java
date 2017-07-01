package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Model.Entities.Client;

import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface ClientService {

  void addClient(Client provider) throws AlreadyExistsException;

  Client getClient(Long id) throws NotFoundException;

  void updateClient(Client provider) throws NotFoundException;

  void deleteClient(Long id) throws NotFoundException;

  List<Client> getAll();
}
