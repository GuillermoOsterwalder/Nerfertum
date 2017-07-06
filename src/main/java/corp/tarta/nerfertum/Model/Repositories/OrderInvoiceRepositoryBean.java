package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Connection.JDBCConnection;
import corp.tarta.nerfertum.Model.Entities.OrderInvoice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by morio on 06/07/17.
 */
public class OrderInvoiceRepositoryBean implements OrderInvoiceRepository {

  private JDBCConnection dbConnection = null;
  private ResultSet results = null;
  private PreparedStatement statement = null;

  @Override
  public void save(OrderInvoice orderInvoice) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("INSERT INTO order_invoice");
      statementBuilder
          .append(" (id_client, invoice_date, total)");
      statementBuilder.append(" VALUES (?,?,?)");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, orderInvoice.getBuyerId().toString());
        statement.setString(2, orderInvoice.getDate().toString());
        statement.setString(3, orderInvoice.getTotal().toString());
        statement.executeUpdate();
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
  }

  @Override
  public OrderInvoice findOne(Long id) {
    OrderInvoice orderInvoice = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM order_invoice");
      statementBuilder.append(" WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        List<OrderInvoice> orderInvoices = resultToOrderInvoice(results);
        if (!orderInvoices.isEmpty()){
          orderInvoice = orderInvoices.get(0);
        }
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return orderInvoice;
  }

  @Override
  public void update(OrderInvoice orderInvoice) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("UPDATE order_invoice");
      statementBuilder.append(
          " SET id_client = ?, invoice_date = ?, total = ?");
      statementBuilder.append("  WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, orderInvoice.getBuyerId().toString());
        statement.setString(2, orderInvoice.getDate().toString());
        statement.setString(3, orderInvoice.getTotal().toString());
        statement.setString(4, orderInvoice.getId().toString());
        statement.executeUpdate();
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
  }

  @Override
  public void delete(Long id) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("DELETE FROM order_invoice");
      statementBuilder.append("  WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        statement.executeUpdate();
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
  }

  @Override
  public List<OrderInvoice> findAll() {
    List<OrderInvoice> orderInvoices = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM order_invoice");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        results = statement.executeQuery();
        orderInvoices = resultToOrderInvoice(results);
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return orderInvoices;
  }

  @Override
  public List<OrderInvoice> findByClient(Long id) {
    List<OrderInvoice> orderInvoices = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM order_invoice");
      statementBuilder.append(" WHERE id_client = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        orderInvoices = resultToOrderInvoice(results);
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return orderInvoices;
  }

  @Override
  public Long nextId() {
    Long nextId = Long.valueOf(0);
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT MAX(id) FROM order_invoice");
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

  private List<OrderInvoice> resultToOrderInvoice(ResultSet results) throws SQLException {
    List<OrderInvoice> orderInvoices = new LinkedList<>();
    if (results != null) {
      while (results.next()) {
        OrderInvoice orderInvoice = new OrderInvoice();
        orderInvoice.setId(results.getLong("id"));
        orderInvoice.setBuyerId(results.getLong("id_client"));
        orderInvoice.setDate(results.getTimestamp("invoice_date"));
        orderInvoice.setTotal(results.getFloat("total"));
        orderInvoices.add(orderInvoice);
      }
    }
    return orderInvoices;
  }
}
