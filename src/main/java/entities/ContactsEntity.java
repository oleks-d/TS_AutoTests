package entities;

/**
 * Created by odiachuk on 13.07.17.
 */
public class ContactsEntity extends BaseEntity{
    String email;
    String phone;
    String company;
    String fax;

    public ContactsEntity() {
    }

    public ContactsEntity(String email, String phone, String company, String fax) {
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.fax = fax;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() { return fax; }

    public void setFax(String fax) {
        this.fax = fax;
    }




}
