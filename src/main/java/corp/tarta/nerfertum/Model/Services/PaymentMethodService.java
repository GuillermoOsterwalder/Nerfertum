package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Model.Entities.PaymentMethod;

import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface PaymentMethodService {

  void addPaymentMethod(PaymentMethod provider) throws AlreadyExistsException;

  PaymentMethod getPaymentMethod(Long id) throws NotFoundException;

  void updatePaymentMethod(PaymentMethod provider) throws NotFoundException;

  void deletePaymentMethod(Long id) throws NotFoundException;

  List<PaymentMethod> getAll();

}
