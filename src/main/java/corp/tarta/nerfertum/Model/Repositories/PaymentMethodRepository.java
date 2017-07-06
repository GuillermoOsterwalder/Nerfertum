package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.PaymentMethod;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface PaymentMethodRepository {

    void save(PaymentMethod paymentMethod);

    PaymentMethod findOne(Long id);

    void update(PaymentMethod provider);

    void delete(Long id);

    List<PaymentMethod> findAll();

    Long nextId();

}
