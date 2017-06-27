package corp.tarta.nerfertum.Model.Entities;

/**
 * Created by mariano on 26/06/17.
 */
public class Provider{
    protected Long id;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String phone;
    protected String email;

    public Provider(){
        this.id = 0l;
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.phone = "";
        this.email = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
