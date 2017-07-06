package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.Product;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface ProductRepository {

    void save(Product product);

    Product findOne(Long id);

    void update(Product product);

    void delete(Long id);

    List<Product> findAll();

    List<Product> findByDescription(String description);
}
