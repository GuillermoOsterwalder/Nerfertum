package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.OrderProduct;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface OrderProductRepository {

    public void save(OrderProduct orderProduct);

    public OrderProduct findOne(Long id);

    public void update(OrderProduct orderProduct);

    public void delete(Long id);

    public List<OrderProduct> findAll();

    public List<OrderProduct> findByOrder(Long id);
}
