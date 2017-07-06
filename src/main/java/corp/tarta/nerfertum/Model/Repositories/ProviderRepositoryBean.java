package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Connection.JDBCConnection;
import corp.tarta.nerfertum.Model.Entities.Provider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by morio on 06/07/17.
 */
public class ProviderRepositoryBean implements ProviderRepository {

  private JDBCConnection dbConnection = null;
  private ResultSet results = null;
  private PreparedStatement statement = null;

  @Override
  public void save(Provider provider) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("INSERT INTO provider");
      statementBuilder
          .append(" (first_name, last_name, address, phone, email)");
      statementBuilder.append(" VALUES (?,?,?,?,?)");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, provider.getFirstName());
        statement.setString(2, provider.getLastName());
        statement.setString(3, provider.getAddress());
        statement.setString(4, provider.getPhone());
        statement.setString(5, provider.getEmail());
        statement.executeUpdate();
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
  }

  @Override
  public Provider findOne(Long id) {
    Provider provider = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM provider");
      statementBuilder.append(" WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        List<Provider> providers = resultToProvider(results);
        if (!providers.isEmpty()){
          provider = providers.get(0);
        }
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return provider;
  }

  @Override
  public void update(Provider provider) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("UPDATE provider");
      statementBuilder.append(
          " SET first_name = ?, last_name = ?, address = ?, phone = ?, email = ?");
      statementBuilder.append("  WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, provider.getFirstName());
        statement.setString(2, provider.getLastName());
        statement.setString(3, provider.getAddress());
        statement.setString(4, provider.getPhone());
        statement.setString(5, provider.getEmail());
        statement.setString(6, provider.getId().toString());
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
      StringBuilder statementBuilder = new StringBuilder("DELETE FROM provider");
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
  public List<Provider> findAll() {
    List<Provider> providers = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM providers");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        results = statement.executeQuery();
        providers = resultToProvider(results);
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return providers;
  }

  private List<Provider> resultToProvider(ResultSet results) throws SQLException {
    List<Provider> providers = new LinkedList<>();
    if (results != null) {
      while (results.next()) {
        Provider provider = new Provider();
        provider.setId(results.getLong("id"));
        provider.setFirstName(results.getString("first_name"));
        provider.setLastName(results.getString("last_name"));
        provider.setAddress(results.getString("address"));
        provider.setPhone(results.getString("phone"));
        provider.setEmail(results.getString("email"));
        providers.add(provider);
      }
    }
    return providers;
  }
}
