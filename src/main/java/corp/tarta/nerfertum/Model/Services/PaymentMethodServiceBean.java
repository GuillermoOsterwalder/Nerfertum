package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.AlreadyExistsException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.PaymentMethod;
import corp.tarta.nerfertum.Model.Repositories.PaymentMethodRepository;

import java.util.List;

/**
 * Created by mariano on 05/07/17.
 */
public class PaymentMethodServiceBean implements PaymentMethodService {

    private static PaymentMethodServiceBean instance = null;

    private PaymentMethodRepository paymentMethodRepository;

    private PaymentMethodServiceBean(){
        //paymentMethodRepository = new PaymentMethodRepositoryBean();
    }

    public static PaymentMethodServiceBean getInstance(){
        if (instance == null){
            instance = new PaymentMethodServiceBean();
        }
        return instance;
    }

    @Override
    public void addPaymentMethod(PaymentMethod paymentMethod) throws AlreadyExistsException, NullValueException {
        if(paymentMethod != null){
            PaymentMethod persistedPaymentMethod = paymentMethodRepository.findOne(paymentMethod.getId());
            if(persistedPaymentMethod == null){
                paymentMethodRepository.save(paymentMethod);
            }else{
                throw new AlreadyExistsException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public PaymentMethod getPaymentMethod(Long id) throws NotFoundException, NullValueException {
        if(id != null){
            PaymentMethod persistedPaymentMethod = paymentMethodRepository.findOne(id);
            if(persistedPaymentMethod == null){
                return paymentMethodRepository.findOne(id);
            }else{
                throw new NotFoundException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public void updatePaymentMethod(PaymentMethod paymentMethod) throws NotFoundException, NullValueException {
        if(paymentMethod != null){
            PaymentMethod persistedPaymentMethod = paymentMethodRepository.findOne(paymentMethod.getId());
            if(persistedPaymentMethod != null){
                paymentMethodRepository.update(paymentMethod);
            }else{
                throw new NotFoundException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public void deletePaymentMethod(Long id) throws NotFoundException, NullValueException {
        if(id != null){
            PaymentMethod persistedPaymentMethod = paymentMethodRepository.findOne(id);
            if(persistedPaymentMethod == null){
                paymentMethodRepository.delete(id);
            }else{
                throw new NotFoundException();
            }
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public List<PaymentMethod> getAll() {
        return paymentMethodRepository.findAll();
    }
}
