package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.Client;

import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface ClientService {

  void addClient(Client client) throws AlreadyExistsException, NullValueException;

  Client getClient(Long id) throws NotFoundException, NullValueException;

  void updateClient(Client client) throws NotFoundException, NullValueException;

  void deleteClient(Long id) throws NotFoundException, NullValueException;

  List<Client> getAll();

}
