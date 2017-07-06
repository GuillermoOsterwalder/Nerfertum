package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.PaymentMethod;

import java.util.List;

/**
 * Created by morio on 28/06/17.
 */
public interface PaymentMethodService {

  void addPaymentMethod(PaymentMethod paymentMethod) throws AlreadyExistsException, NullValueException;

  PaymentMethod getPaymentMethod(Long id) throws NotFoundException, NullValueException;

  void updatePaymentMethod(PaymentMethod paymentMethod) throws NotFoundException, NullValueException;

  void deletePaymentMethod(Long id) throws NotFoundException, NullValueException;

  List<PaymentMethod> getAll();

}
