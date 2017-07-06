package corp.tarta.nerfertum.Model.Services;

import com.sun.deploy.util.SessionState;
import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.Client;
import corp.tarta.nerfertum.Model.Repositories.ClientRepository;

import java.util.List;

/**
 * Created by mariano on 05/07/17.
 */
public class ClientServiceBean implements ClientService {

    private static ClientServiceBean instance = null;

    private ClientRepository clientRepository;

    private ClientServiceBean(){
        //clientRepository = new ClientRepositoryBean();
    }

    public static ClientServiceBean getInstance(){
        if (instance == null){
            instance = new ClientServiceBean();
        }
        return instance;
    }


    @Override
    public void addClient(Client client) throws AlreadyExistsException, NullValueException {
        if (client != null) {
            Client persistedClient = clientRepository.findOne(client.getId());
            if (persistedClient == null) {
                clientRepository.save(client);
            } else {
                throw new AlreadyExistsException();
            }
        } else {
            throw new NullValueException();
        }
    }

    @Override
    public Client getClient(Long id) throws NotFoundException, NullValueException {
        if (id != null) {
            Client persistedClient = clientRepository.findOne(id);
            if (persistedClient != null) {
                return persistedClient;
            } else {
                throw new NotFoundException();
            }
        } else {
            throw new NullValueException();
        }
    }

    @Override
    public void updateClient(Client client) throws NotFoundException, NullValueException {
        if (client != null) {
            Client persistedClient = clientRepository.findOne(client.getId());
            if (persistedClient != null) {
                clientRepository.update(client);
            } else {
                throw new NotFoundException();
            }
        } else {
            throw new NullValueException();
        }
    }

    @Override
    public void deleteClient(Long id) throws NotFoundException, NullValueException {
        if (id != null) {
            Client persistedClient = clientRepository.findOne(id);
            if (persistedClient != null) {
                clientRepository.delete(id);
            } else {
                throw new NotFoundException();
            }
        } else {
            throw new NullValueException();
        }
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }


}
