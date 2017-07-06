package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.ExcelParameters;
import corp.tarta.nerfertum.Model.Entities.Provider;
import corp.tarta.nerfertum.Model.Entities.ProviderProduct;
import corp.tarta.nerfertum.Model.Repositories.ProviderProductRepository;
import corp.tarta.nerfertum.Model.Repositories.ProviderRepository;

import java.io.IOException;
import java.util.List;

/**
 * Created by mariano on 04/07/17.
 */
public class ProviderServiceBean implements ProviderService {

    private static ProviderServiceBean instance = null;

    private ProviderRepository providerRepository;
    private ProviderProductRepository providerProductRepository;

    private ProviderServiceBean(){
        //providerRepository = new ProviderRepositoryBean();
        //providerProductRepository = new ProviderProductRepository();
    }

    public static ProviderServiceBean getInstance(){
        if (instance == null){
            instance = new ProviderServiceBean();
        }
        return instance;
    }

    @Override
    public void addProvider(Provider provider) throws AlreadyExistsException, NullValueException {
        if(provider != null){
            Provider persistedProvider = providerRepository.findOne(provider.getId());
            if(persistedProvider == null){
                providerRepository.save(provider);
            }else{
                throw new AlreadyExistsException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public Provider getProvider(Long id) throws NotFoundException, NullValueException {
        if(id != null){
            Provider persistedProvider = providerRepository.findOne(id);
            if(persistedProvider != null){
                return persistedProvider;
            }else{
                throw new NotFoundException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public void updateProvider(Provider provider) throws NotFoundException, NullValueException {
        if(provider != null){
            Provider persistedProvider = providerRepository.findOne(provider.getId());
            if(persistedProvider != null){
                providerRepository.update(provider);
            }else{
                throw new NotFoundException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public void deleteProvider(Long id) throws NotFoundException, NullValueException {
        if(id != null){
            Provider persistedProvider = providerRepository.findOne(id);
            if(persistedProvider != null){
                providerRepository.delete(id);
            }else{
                throw new NotFoundException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public List<Provider> getAll() {
        return providerRepository.findAll();
    }

    @Override
    public List<ProviderProduct> getProviderProductsByProviderId(Long providerId) throws NullValueException{
        if (providerId != null){
            return providerProductRepository.findByProvider(providerId);
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public ProviderProduct getProviderProductByAssosiatedProduct(Long id) throws NotFoundException,NullValueException {
        if(id != null){
            ProviderProduct persistedProviderProduct = providerProductRepository.findByAssosiatedProduct(id);
            if(persistedProviderProduct != null){
                return persistedProviderProduct;
            }else{
                throw new NotFoundException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public void addToListPrice(List<ProviderProduct> providerProducts) throws NullValueException {
        if(providerProducts != null){
            for (ProviderProduct providerProduct: providerProducts){
                addProviderProduct(providerProduct);
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public void addProviderProduct(ProviderProduct providerProduct){
        ProviderProduct persistedProviderProduct = providerProductRepository.findOne(providerProduct.getId());
        if (persistedProviderProduct != null){
            providerProductRepository.update(persistedProviderProduct);
        }else
        {
            providerProductRepository.save(persistedProviderProduct);
        }
    }

    @Override
    public void deleteProviderProduct(Long id) throws NotFoundException, NullValueException {
        if(id != null){
            ProviderProduct persistedProviderProduct = providerProductRepository.findOne(id);
            if(persistedProviderProduct != null){
                providerProductRepository.delete(id);
            }else{
                throw new NotFoundException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public void updateListPriceFromExcel(Long id, String path, ExcelParameters excelParameters) throws NotFoundException, IOException {
        //NOT IMPLEMENTED YET
    }

}
