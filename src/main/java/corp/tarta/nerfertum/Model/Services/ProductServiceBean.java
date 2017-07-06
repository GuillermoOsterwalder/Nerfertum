package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.Product;
import corp.tarta.nerfertum.Model.Repositories.ProductRepository;

import java.util.List;

/**
 * Created by mariano on 05/07/17.
 */
public class ProductServiceBean implements ProductService {

    private static ProductServiceBean instance = null;

    private ProductRepository productRepository;

    private ProductServiceBean(){
        //productRepository = new ProductRepositoryBean();
    }

    public ProductServiceBean getInstance(){
        if (instance == null){
            instance = new ProductServiceBean();
        }
        return instance;
    }

    @Override
    public void addProduct(Product product) throws AlreadyExistsException, NullValueException {
        if(product != null){
            Product persistedProduct = productRepository.findOne(product.getId());
            if(persistedProduct == null){
                productRepository.save(product);
            }else{
                throw new AlreadyExistsException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public Product getProduct(Long id) throws NotFoundException, NullValueException {
        if(id != null){
            Product persistedProduct = productRepository.findOne(id);
            if(persistedProduct != null){
                return productRepository.findOne(id);
            }else{
                throw new NotFoundException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public void updateProduct(Product product) throws NotFoundException, NullValueException {
        if(product != null){
            Product persistedProduct = productRepository.findOne(product.getId());
            if(persistedProduct != null){
                productRepository.update(product);
            }else{
                throw new NotFoundException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public void deleteProduct(Long id) throws NotFoundException, NullValueException {
        if(id != null){
            Product persistedProduct = productRepository.findOne(id);
            if(persistedProduct != null){
                productRepository.delete(id);
            }else{
                throw new NotFoundException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
