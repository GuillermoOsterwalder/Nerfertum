package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Connection.JDBCConnection;
import corp.tarta.nerfertum.Model.Entities.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by morio on 06/07/17.
 */
public class AccountRepositoryBean implements AccountRepository{

  private JDBCConnection dbConnection = null;
  private ResultSet results = null;
  private PreparedStatement statement = null;

  @Override
  public void save(Account account) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("INSERT INTO account");
      statementBuilder
          .append(" (id_owner, balance)");
      statementBuilder.append(" VALUES (?,?)");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, account.getOwner().toString());
        statement.setString(2, account.getBalance().toString());
        statement.executeUpdate();
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
  }

  @Override
  public Account findOne(Long id) {
    Account account = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM account");
      statementBuilder.append(" WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        List<Account> accounts = resultToAccount(results);
        if (!accounts.isEmpty()){
          account = accounts.get(0);
        }
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return account;
  }

  @Override
  public void update(Account account) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("UPDATE account");
      statementBuilder.append(
          " SET id_owner = ?, balance = ?");
      statementBuilder.append("  WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, account.getOwner().toString());
        statement.setString(2, account.getBalance().toString());
        statement.setString(3, account.getId().toString());
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
      StringBuilder statementBuilder = new StringBuilder("DELETE FROM account");
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
  public List<Account> findAll() {
    List<Account> accounts = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM account");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        results = statement.executeQuery();
        accounts = resultToAccount(results);
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return accounts;
  }

  @Override
  public Account findByOwner(Long id) {
    Account account = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM account");
      statementBuilder.append(" WHERE id_owner = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        List<Account> accounts = resultToAccount(results);
        if (!accounts.isEmpty()){
          account = accounts.get(0);
        }
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return account;
  }

  @Override
  public Long nextId() {
    Long nextId = Long.valueOf(0);
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT MAX(id) FROM account");
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

  private List<Account> resultToAccount(ResultSet results) throws SQLException {
    List<Account> accounts = new LinkedList<>();
    if (results != null) {
      while (results.next()) {
        Account account = new Account();
        account.setId(results.getLong("id"));
        account.setOwner(results.getLong("id_owner"));
        account.setBalance(results.getFloat("balance"));
        accounts.add(account);
      }
    }
    return accounts;
  }
}
