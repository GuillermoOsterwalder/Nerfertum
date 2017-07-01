package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Model.Entities.ExcelParameters;
import corp.tarta.nerfertum.Model.Entities.Provider;
import corp.tarta.nerfertum.Model.Entities.ProviderProduct;

import java.io.IOException;
import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface ProviderService {

  void addProvider(Provider provider) throws AlreadyExistsException;

  Provider getProvider(Long id) throws NotFoundException;

  void updateProvider(Provider provider) throws NotFoundException;

  void deleteProvider(Long id) throws NotFoundException;

  List<Provider> getAll();

  List<ProviderProduct> getProviderProductsByProviderId(Long providerId) throws NotFoundException;

  ProviderProduct getProviderProductByAssosiatedProduct(Long id) throws NotFoundException;

  void addToListPrice(Long id, List<ProviderProduct> providerProducts) throws NotFoundException;

  void addProviderProduct(ProviderProduct providerProduct) throws AlreadyExistsException;

  void updateProviderProduct(ProviderProduct providerProduct) throws NotFoundException;

  void deleteProviderProduct(Long id) throws NotFoundException;

  void updateListPriceFromExcel(Long id, String path, ExcelParameters excelParameters) throws NotFoundException, IOException;

}
