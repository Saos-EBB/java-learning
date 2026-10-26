package PM.Management;

public class Address {

    private String zipCode;
    private String city;
    private String street;
    private String houseNumber;

    public Address(String zipCode, String city, String street, String houseNumber) {
        setZipCode(zipCode);
        setCity(city);
        setStreet(street);
        setHouseNumber(houseNumber);
    }

    // Getter
    public String getZipCode()     { return zipCode;     }
    public String getCity()        { return city;        }
    public String getStreet()      { return street;      }
    public String getHouseNumber() { return houseNumber; }

    // Setter — null-safe mit trim()
    public void setZipCode(String zipCode) {
        this.zipCode = (zipCode != null) ? zipCode.trim() : "";
    }

    public void setCity(String city) {
        this.city = (city != null) ? city.trim() : "";
    }

    public void setStreet(String street) {
        this.street = (street != null) ? street.trim() : "";
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = (houseNumber != null) ? houseNumber.trim() : "";
    }

    @Override
    public String toString() {
        return street + " " + houseNumber + ", " + zipCode + " " + city;
    }
}
