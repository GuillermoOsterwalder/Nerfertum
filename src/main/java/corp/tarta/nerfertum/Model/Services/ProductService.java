package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Model.Entities.Product;

import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface ProductService {

  void addProduct(Product provider) throws AlreadyExistsException;

  Product getProduct(Long id) throws NotFoundException;

  void updateProduct(Product provider) throws NotFoundException;

  void deleteProduct(Long id) throws NotFoundException;

  List<Product> getAll();
}
