package corp.tarta.nerfertum.Model.Entities;

import java.time.LocalTime;
import java.util.Date;

/**
 * Created by mariano on 27/06/17.
 */
public class AccountMovement {
    private Long id;
    private Long accountId;
    private LocalTime date;
    private String description;
    private Float ammount;
    private Float balance;


    public AccountMovement(){
        id = 0l;
        accountId = 0l;

        date = LocalTime.now();
        description = "";
        ammount = 0f;
        balance = 0f;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAmmount() {
        return ammount;
    }

    public void setAmmount(Float ammount) {
        this.ammount = ammount;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
