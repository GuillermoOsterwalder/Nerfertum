package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.Product;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface ProductRepository {

    public void save(Product product);

    public Product findOne(Long id);

    public void update(Product product);

    public void delete(Long id);

    public List<Product> findAll();

    public List<Product> findByDescription(String description);

    public List<Product> findByIdOrDescription(Long id, String description);
}
