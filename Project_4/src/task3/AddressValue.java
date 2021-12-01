package task3;

import java.util.Objects;

public class AddressValue {
    private String city;
    private String street;
    private String streetNumber;
    private int apartmentNumber;

    public AddressValue(String city, String street, String streetNumber, int apartmentNumber) {
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public AddressValue() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressValue)) return false;
        AddressValue that = (AddressValue) o;
        return getApartmentNumber() == that.getApartmentNumber() && getCity().equals(that.getCity()) && getStreet().equals(that.getStreet()) && getStreetNumber().equals(that.getStreetNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getStreetNumber(), getApartmentNumber());
    }

    @Override
    public String toString() {
        return "AddressValue{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
