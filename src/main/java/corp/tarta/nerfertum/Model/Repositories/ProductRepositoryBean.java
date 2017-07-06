package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Connection.JDBCConnection;
import corp.tarta.nerfertum.Model.Entities.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by morio on 06/07/17.
 */
public class ProductRepositoryBean implements ProductRepository {

  private JDBCConnection dbConnection = null;
  private ResultSet results = null;
  private PreparedStatement statement = null;

  @Override
  public void save(Product product) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("INSERT INTO product");
      statementBuilder
          .append(" (id, description, cost_price, winning_percent, sell_price, quantity)");
      statementBuilder.append(" VALUES (?,?,?,?,?,?)");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, product.getId().toString());
        statement.setString(2, product.getDescription());
        statement.setString(3, product.getCostPrice().toString());
        statement.setString(4, product.getWinningPercent().toString());
        statement.setString(5, product.getSellPrice().toString());
        statement.setString(6, product.getQuantity().toString());
        statement.executeUpdate();
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
  }

  @Override
  public Product findOne(Long id) {
    Product product = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM product");
      statementBuilder.append(" WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        List<Product> products = resultToProduct(results);
        if (!products.isEmpty()){
          product = products.get(0);
        }
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return product;
  }

  @Override
  public void update(Product product) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("UPDATE product");
      statementBuilder.append(
          " SET description = ?, cost_price = ?, winning_percent = ?, sell_price = ?, quantity = ?");
      statementBuilder.append("  WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, product.getDescription());
        statement.setString(2, product.getCostPrice().toString());
        statement.setString(3, product.getWinningPercent().toString());
        statement.setString(4, product.getSellPrice().toString());
        statement.setString(5, product.getQuantity().toString());
        statement.setString(6, product.getId().toString());
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
      StringBuilder statementBuilder = new StringBuilder("DELETE FROM product");
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
  public List<Product> findAll() {
    List<Product> products = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM product");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        results = statement.executeQuery();
        products = resultToProduct(results);
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return products;
  }

  @Override
  public List<Product> findByDescription(String description) {
    List<Product> products = null;
        dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM product");
      statementBuilder.append(" WHERE description = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, description);
        results = statement.executeQuery();
        products = resultToProduct(results);
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return products;
  }

  private List<Product> resultToProduct(ResultSet results) throws SQLException {
    List<Product> products = new LinkedList<>();
    if (results != null) {
      while (results.next()) {
          Product product = new Product();
          product.setId(results.getLong("id"));
          product.setDescription(results.getString("description"));
          product.setCostPrice(results.getFloat("cost_price"));
          product.setWinningPercent(results.getFloat("winning_percent"));
          product.setSellPrice(results.getFloat("sell_price"));
          product.setQuantity(results.getInt("quantity"));
          products.add(product);
      }
    }
    return products;
  }
}
