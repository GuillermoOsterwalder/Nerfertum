package corp.tarta.nerfertum.Model.Entities;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by morio on 06/07/17.
 */
public class PrivateAccount {

  private Long id;
  private String purpose;
  private List<PrivateAccountMovement> movements;
  private Float balance;

  public PrivateAccount(){
    id = 0l;
    purpose = "";
    movements = new LinkedList<PrivateAccountMovement>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public List<PrivateAccountMovement> getMovements() {
    return movements;
  }

  public void setMovements(
      List<PrivateAccountMovement> movements) {
    this.movements = movements;
  }

  public Float getBalance() {
    return balance;
  }

  public void setBalance(Float balance) {
    this.balance = balance;
  }
}
