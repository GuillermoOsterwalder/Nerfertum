package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.ProviderProduct;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface ProviderProductRepository {

    public void save(ProviderProduct client);

    public ProviderProduct findOne(Long id);

    public void update(ProviderProduct client);

    public void delete(Long id);

    public List<ProviderProduct> findAll();

    public List<ProviderProduct> findByProvider(Long id);

    public List<ProviderProduct> findByAssosiatedProduct(Long id);
}
