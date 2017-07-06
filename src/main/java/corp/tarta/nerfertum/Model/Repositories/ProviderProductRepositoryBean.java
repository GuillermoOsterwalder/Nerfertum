package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Connection.JDBCConnection;
import corp.tarta.nerfertum.Model.Entities.ProviderProduct;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by morio on 06/07/17.
 */
public class ProviderProductRepositoryBean implements ProviderProductRepository{

  private JDBCConnection dbConnection = null;
  private ResultSet results = null;
  private PreparedStatement statement = null;

  @Override
  public void save(ProviderProduct providerProduct) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("INSERT INTO provider_product");
      statementBuilder
          .append(" (id,id_provider, id_product_assosiated, description, price)");
      statementBuilder.append(" VALUES (?,?,?,?,?)");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, providerProduct.getId().toString());
        statement.setString(2, providerProduct.getOwnerId().toString());
        statement.setString(3, providerProduct.getAssosiatedProduct().toString());
        statement.setString(4, providerProduct.getDescription());
        statement.setString(5, providerProduct.getPrice().toString());
        statement.executeUpdate();
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
  }

  @Override
  public ProviderProduct findOne(Long id) {
    ProviderProduct providerProduct = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM provider_product");
      statementBuilder.append(" WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        List<ProviderProduct> providerProducts = resultToProviderProduct(results);
        if (!providerProducts.isEmpty()){
          providerProduct = providerProducts.get(0);
        }
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return providerProduct;
  }

  @Override
  public void update(ProviderProduct providerProduct) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("UPDATE provider_product");
      statementBuilder.append(
          " SET id_provider = ?, id_assosiated_product = ?, description = ?, price = ?");
      statementBuilder.append("  WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(5, providerProduct.getId().toString());
        statement.setString(1, providerProduct.getOwnerId().toString());
        statement.setString(2, providerProduct.getAssosiatedProduct().toString());
        statement.setString(3, providerProduct.getDescription());
        statement.setString(4, providerProduct.getPrice().toString());
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
      StringBuilder statementBuilder = new StringBuilder("DELETE FROM provider_product");
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
  public List<ProviderProduct> findByProvider(Long id) {
    List<ProviderProduct> providerProducts = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM provider_product");
      statementBuilder.append(" WHERE id_provider = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        providerProducts = resultToProviderProduct(results);
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return providerProducts;
  }

  @Override
  public ProviderProduct findByAssosiatedProduct(Long id) {
    ProviderProduct providerProduct = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM provider_product");
      statementBuilder.append(" WHERE id_assosiated_product = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        List<ProviderProduct> providerProducts = resultToProviderProduct(results);
        if (!providerProducts.isEmpty()){
          providerProduct = providerProducts.get(0);
        }
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return providerProduct;
  }

  @Override
  public Long nextId() {
    Long nextId = Long.valueOf(0);
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT MAX(id) FROM provider");
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

  private List<ProviderProduct> resultToProviderProduct(ResultSet results) throws SQLException {
    List<ProviderProduct> providerProducts = new LinkedList<>();
    if (results != null) {
      while (results.next()) {
        ProviderProduct providerProduct = new ProviderProduct();
        providerProduct.setId(results.getLong("id"));
        providerProduct.setOwnerId(results.getLong("id_provider"));
        providerProduct.setAssosiatedProduct(results.getLong("id_product_assosiated"));
        providerProduct.setDescription(results.getString("description"));
        providerProduct.setPrice(results.getFloat("price"));
        providerProducts.add(providerProduct);
      }
    }
    return providerProducts;
  }
}
