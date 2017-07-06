package corp.tarta.nerfertum.Model.Entities;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mariano on 27/06/17.
 */
public class Account {
    private Long id;
    private Long owner;
    private List<AccountMovement> movements;
    private Float balance;

    public Account(){
        id = 0l;
        owner = -1l;
        movements = new LinkedList<AccountMovement>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public List<AccountMovement> getMovements() {
        return movements;
    }

    public void setMovements(List<AccountMovement> movements) {
        this.movements = movements;
    }
}
