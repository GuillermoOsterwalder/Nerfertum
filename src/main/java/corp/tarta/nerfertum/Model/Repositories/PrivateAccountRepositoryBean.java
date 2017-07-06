package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Connection.JDBCConnection;
import corp.tarta.nerfertum.Model.Entities.PrivateAccount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by morio on 06/07/17.
 */
public class PrivateAccountRepositoryBean implements PrivateAccountRepository{

  private JDBCConnection dbConnection = null;
  private ResultSet results = null;
  private PreparedStatement statement = null;

  @Override
  public void save(PrivateAccount privateAccount) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("INSERT INTO private_account");
      statementBuilder
          .append(" (purpose, balance)");
      statementBuilder.append(" VALUES (?,?)");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, privateAccount.getPurpose());
        statement.setString(2, privateAccount.getBalance().toString());
        statement.executeUpdate();
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
  }

  @Override
  public PrivateAccount findOne(Long id) {
    PrivateAccount privateAccount = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM private_account");
      statementBuilder.append(" WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        List<PrivateAccount> privateAccounts = resultToPrivateAccount(results);
        if (!privateAccounts.isEmpty()){
          privateAccount = privateAccounts.get(0);
        }
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return privateAccount;
  }

  @Override
  public void update(PrivateAccount privateAccount) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("UPDATE private_accounts");
      statementBuilder.append(
          " SET purpose = ?, balance = ?");
      statementBuilder.append("  WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, privateAccount.getPurpose());
        statement.setString(2, privateAccount.getBalance().toString());
        statement.setString(3, privateAccount.getId().toString());
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
      StringBuilder statementBuilder = new StringBuilder("DELETE FROM private_accounts");
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
  public List<PrivateAccount> findAll() {
    List<PrivateAccount> privateAccounts = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM private_accounts");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        results = statement.executeQuery();
        privateAccounts = resultToPrivateAccount(results);
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return privateAccounts;
  }

  @Override
  public Long nextId() {
    Long nextId = Long.valueOf(0);
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT MAX(id) FROM private_account");
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

  private List<PrivateAccount> resultToPrivateAccount(ResultSet results) throws SQLException {
    List<PrivateAccount> privateAccounts = new LinkedList<>();
    if (results != null) {
      while (results.next()) {
        PrivateAccount privateAccount = new PrivateAccount();
        privateAccount.setId(results.getLong("id"));
        privateAccount.setPurpose(results.getString("purpose"));
        privateAccount.setBalance(results.getFloat("balance"));
        privateAccounts.add(privateAccount);
      }
    }
    return privateAccounts;
  }
}
