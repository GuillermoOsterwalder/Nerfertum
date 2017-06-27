package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.Provider;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface ProviderRepository {

    public void save(Provider provider);

    public Provider findOne(Long id);

    public void update(Provider provider);

    public void delete(Long id);

    public List<Provider> findAll();

    public List<Provider> findByName(String name);

    public List<Provider> findByIdOrName(Long id, String name);
}
