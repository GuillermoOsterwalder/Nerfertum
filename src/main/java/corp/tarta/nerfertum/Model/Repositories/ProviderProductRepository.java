package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.ProviderProduct;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface ProviderProductRepository {

    void save(ProviderProduct client);

    ProviderProduct findOne(Long id);

    void update(ProviderProduct client);

    void delete(Long id);

    List<ProviderProduct> findByProvider(Long id);

    ProviderProduct findByAssosiatedProduct(Long id);
}
