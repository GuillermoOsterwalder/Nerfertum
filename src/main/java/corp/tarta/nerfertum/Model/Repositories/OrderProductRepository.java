package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Entities.OrderProduct;

import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public interface OrderProductRepository {

    void save(OrderProduct orderProduct);

    OrderProduct findOne(Long id);

    List<OrderProduct> findByOrder(Long id);

    Long nextId();
}
