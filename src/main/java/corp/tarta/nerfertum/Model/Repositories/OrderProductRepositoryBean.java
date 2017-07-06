package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Connection.JDBCConnection;
import corp.tarta.nerfertum.Model.Entities.OrderProduct;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by morio on 06/07/17.
 */
public class OrderProductRepositoryBean implements OrderProductRepository{

  private JDBCConnection dbConnection = null;
  private ResultSet results = null;
  private PreparedStatement statement = null;

  @Override
  public void save(OrderProduct orderProduct) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("INSERT INTO order_product");
      statementBuilder
          .append(" (id_invoice, id_product, quantity, total)");
      statementBuilder.append(" VALUES (?,?,?,?,)");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, orderProduct.getInvoiceId().toString());
        statement.setString(2, orderProduct.getProductId().toString());
        statement.setString(3, orderProduct.getQuantity().toString());
        statement.setString(4, orderProduct.getTotal().toString());
        statement.executeUpdate();
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
  }

  @Override
  public OrderProduct findOne(Long id) {
    OrderProduct orderProduct = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM order_product");
      statementBuilder.append(" WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        List<OrderProduct> orderProducts = resultToOrderInvoiceProduct(results);
        if (!orderProducts.isEmpty()){
          orderProduct = orderProducts.get(0);
        }
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return orderProduct;
  }

  @Override
  public List<OrderProduct> findByOrder(Long id) {
    List<OrderProduct> orderProducts = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM order_product");
      statementBuilder.append(" WHERE id_invoice = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        orderProducts = resultToOrderInvoiceProduct(results);
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return orderProducts;
  }

  @Override
  public Long nextId() {
    Long nextId = Long.valueOf(0);
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT MAX(id) FROM order_product");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        results = statement.executeQuery();
        if(results != null){
          if (results.next()){
            Long resultsLong = results.getLong("MAX(id)");
            if(resultsLong != null){
              nextId = resultsLong;
            }
          }
        }
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    nextId++;
    return nextId;
  }

  private List<OrderProduct> resultToOrderInvoiceProduct(ResultSet results) throws SQLException {
    List<OrderProduct> orderProducts = new LinkedList<>();
    if (results != null) {
      while (results.next()) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(results.getLong("id"));
        orderProduct.setInvoiceId(results.getLong("id_invoice"));
        orderProduct.setProductId(results.getLong("id_product"));
        orderProduct.setQuantity(results.getInt("quantity"));
        orderProduct.setTotal(results.getFloat("total"));
        orderProducts.add(orderProduct);
      }
    }
    return orderProducts;
  }
}
