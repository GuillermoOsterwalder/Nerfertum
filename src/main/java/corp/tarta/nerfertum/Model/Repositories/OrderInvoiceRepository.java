package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.OrderInvoice;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface OrderInvoiceRepository {

    public void save(OrderInvoice orderInvoice);

    public OrderInvoice findOne(Long id);

    public void update(OrderInvoice orderInvoice);

    public void delete(Long id);

    public List<OrderInvoice> findAll();

    public List<OrderInvoice> findByBuyer(Long id);

}
