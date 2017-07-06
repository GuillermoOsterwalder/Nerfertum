package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.Product;

import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface ProductService {

  void addProduct(Product provider) throws AlreadyExistsException, NullValueException;

  Product getProduct(Long id) throws NotFoundException, NullValueException;

  void updateProduct(Product provider) throws NotFoundException, NullValueException;

  void deleteProduct(Long id) throws NotFoundException, NullValueException;

  List<Product> getAll();
}
