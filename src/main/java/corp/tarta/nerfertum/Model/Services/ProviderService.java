package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.ExcelParameters;
import corp.tarta.nerfertum.Model.Entities.Provider;
import corp.tarta.nerfertum.Model.Entities.ProviderProduct;

import java.io.IOException;
import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface ProviderService {

  void addProvider(Provider provider) throws AlreadyExistsException, NullValueException;

  Provider getProvider(Long id) throws NotFoundException, NullValueException;

  void updateProvider(Provider provider) throws NotFoundException, NullValueException;

  void deleteProvider(Long id) throws NotFoundException, NullValueException;

  List<Provider> getAll();

  List<ProviderProduct> getProviderProductsByProviderId(Long providerId) throws NotFoundException, NullValueException;

  ProviderProduct getProviderProductByAssosiatedProduct(Long id) throws NotFoundException, NullValueException;

  void addToListPrice(List<ProviderProduct> providerProducts) throws  NullValueException;

  void addProviderProduct(ProviderProduct providerProduct);

  void deleteProviderProduct(Long id) throws NotFoundException, NullValueException;

  void updateListPriceFromExcel(Long id, String path, ExcelParameters excelParameters) throws NotFoundException, IOException;
}
