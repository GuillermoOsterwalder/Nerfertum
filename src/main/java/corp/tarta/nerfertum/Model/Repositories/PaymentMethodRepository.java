package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.PaymentMethod;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface PaymentMethodRepository {

    public void save(PaymentMethod paymentMethod);

    public PaymentMethod findOne(Long id);

    public void update(PaymentMethod provider);

    public void delete(Long id);

    public List<PaymentMethod> findAll();

    public List<PaymentMethod> findByMethod(String method);
}
