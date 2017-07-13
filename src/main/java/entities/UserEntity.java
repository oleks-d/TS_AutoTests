package entities;

/**
 * Created by odiachuk on 13.07.17.
 */
public class UserEntity extends BaseEntity{
    String firstname;
    String lastname;
    String password;

    ContactsEntity contacts;
    AddressEntity address;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ContactsEntity getContacts() {
        return contacts;
    }

    public void setContacts(ContactsEntity contacts) {
        this.contacts = contacts;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

}
