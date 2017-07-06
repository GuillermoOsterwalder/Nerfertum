package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.OrderInvoice;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface OrderInvoiceRepository {

    void save(OrderInvoice orderInvoice);

    OrderInvoice findOne(Long id);

    void update(OrderInvoice orderInvoice);

    void delete(Long id);

    List<OrderInvoice> findAll();

    List<OrderInvoice> findByClient(Long id);

    Long nextId();

}
