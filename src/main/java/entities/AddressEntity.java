package entities;

/**
 * Created by odiachuk on 13.07.17.
 */
public class AddressEntity extends BaseEntity{
    String street;
    String street_2;
    String zip;
    String city;
    String region;
    String country;

    public AddressEntity(String street, String street_2, String zip, String city, String region, String country) {
        this.street = street;
        this.street_2 = street_2;
        this.zip = zip;
        this.city = city;
        this.region = region;
        this.country = country;
    }

    public AddressEntity() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet_2() {
        return street_2;
    }

    public void setStreet_2(String street_2) {
        this.street_2 = street_2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
