package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Connection.JDBCConnection;
import corp.tarta.nerfertum.Model.Entities.AccountMovement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by morio on 06/07/17.
 */
public class AccountMovementRepositoryBean implements AccountMovementRepository{

  private JDBCConnection dbConnection = null;
  private ResultSet results = null;
  private PreparedStatement statement = null;

  @Override
  public void save(AccountMovement accountMovement) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("INSERT INTO account_movement");
      statementBuilder
          .append(" (id_account, movement_date, description, ammount, balance)");
      statementBuilder.append(" VALUES (?,?,?,?,?)");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, accountMovement.getAccountId().toString());
        statement.setString(2, accountMovement.getDate().toString());
        statement.setString(3, accountMovement.getDescription());
        statement.setString(4, accountMovement.getAmmount().toString());
        statement.setString(5, accountMovement.getBalance().toString());
        statement.executeUpdate();
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
  }

  @Override
  public AccountMovement findOne(Long id) {
    AccountMovement accountMovement = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM account_movement");
      statementBuilder.append(" WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        List<AccountMovement> accountMovements = resultToAccountMovement(results);
        if (!accountMovements.isEmpty()){
          accountMovement = accountMovements.get(0);
        }
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return accountMovement;
  }

  @Override
  public List<AccountMovement> findByAccount(Long id) {
    List<AccountMovement> accountMovements = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM account_movement");
      statementBuilder.append(" WHERE id_account = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        accountMovements = resultToAccountMovement(results);
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return accountMovements;
  }

  @Override
  public void deleteAllFromAccount(Long id) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("DELETE FROM account");
      statementBuilder.append("  WHERE id_account = ?");
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
  public Long nextId() {
    Long nextId = Long.valueOf(0);
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT MAX(id) FROM account_movement");
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

  private List<AccountMovement> resultToAccountMovement(ResultSet results) throws SQLException {
    List<AccountMovement> accountMovements = new LinkedList<>();
    if (results != null) {
      while (results.next()) {
        AccountMovement accountMovement = new AccountMovement();
        accountMovement.setId(results.getLong("id"));
        accountMovement.setAccountId(results.getLong("id_account"));
        accountMovement.setDate(results.getTimestamp("movement_date"));
        accountMovement.setDescription(results.getString("description"));
        accountMovement.setAmmount(results.getFloat("ammount"));
        accountMovement.setBalance(results.getFloat("balance"));
        accountMovements.add(accountMovement);
      }
    }
    return accountMovements;
  }
}
