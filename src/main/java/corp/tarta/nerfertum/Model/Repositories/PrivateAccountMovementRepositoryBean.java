package corp.tarta.nerfertum.Model.Repositories;

import corp.tarta.nerfertum.Model.Connection.JDBCConnection;
import corp.tarta.nerfertum.Model.Entities.PrivateAccountMovement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by morio on 06/07/17.
 */
public class PrivateAccountMovementRepositoryBean implements PrivateAccountMovementRepository{

  private JDBCConnection dbConnection = null;
  private ResultSet results = null;
  private PreparedStatement statement = null;

  @Override
  public void save(PrivateAccountMovement accountMovement) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("INSERT INTO private_account_movement");
      statementBuilder
          .append(" (id_private_account, movement_date, description, ammount, balance)");
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
  public PrivateAccountMovement findOne(Long id) {
    PrivateAccountMovement privateAccountMovement = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM private_account_movement");
      statementBuilder.append(" WHERE id = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        List<PrivateAccountMovement> privateAccountMovements = resultToPrivateAccountMovement(results);
        if (!privateAccountMovements.isEmpty()){
          privateAccountMovement = privateAccountMovements.get(0);
        }
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return privateAccountMovement;
  }

  @Override
  public List<PrivateAccountMovement> findByAccount(Long id) {
    List<PrivateAccountMovement> privateAccountMovements = null;
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("SELECT * FROM private_account_movement");
      statementBuilder.append(" WHERE id_private_account = ?");
      try {
        statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
        statement.setString(1, id.toString());
        results = statement.executeQuery();
        privateAccountMovements = resultToPrivateAccountMovement(results);
        results.close();
        results = null;
        statement.close();
        statement = null;
      } catch (SQLException e) {
        Logger.getAnonymousLogger().severe(e.getMessage());
      }
    }
    return privateAccountMovements;
  }

  @Override
  public void deleteAllFromAccount(Long id) {
    dbConnection = JDBCConnection.getInstance();
    if (dbConnection != null && !dbConnection.isClosed()) {
      StringBuilder statementBuilder = new StringBuilder("DELETE FROM private_account");
      statementBuilder.append("  WHERE id_private_account = ?");
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
      StringBuilder statementBuilder = new StringBuilder("SELECT MAX(id) FROM private_account_movement");
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

  private List<PrivateAccountMovement> resultToPrivateAccountMovement(ResultSet results) throws SQLException {
    List<PrivateAccountMovement> privateAccountMovements = new LinkedList<>();
    if (results != null) {
      while (results.next()) {
        PrivateAccountMovement privateAccountMovement = new PrivateAccountMovement();
        privateAccountMovement.setId(results.getLong("id"));
        privateAccountMovement.setAccountId(results.getLong("id_private_account"));
        privateAccountMovement.setDate(results.getTimestamp("movement_date"));
        privateAccountMovement.setDescription(results.getString("description"));
        privateAccountMovement.setAmmount(results.getFloat("ammount"));
        privateAccountMovement.setBalance(results.getFloat("balance"));
        privateAccountMovements.add(privateAccountMovement);
      }
    }
    return privateAccountMovements;
  }
}
