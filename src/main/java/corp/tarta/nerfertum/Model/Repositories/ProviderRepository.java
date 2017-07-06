package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.Provider;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface ProviderRepository {

    void save(Provider provider);

    Provider findOne(Long id);

    void update(Provider provider);

    void delete(Long id);

    List<Provider> findAll();
}
