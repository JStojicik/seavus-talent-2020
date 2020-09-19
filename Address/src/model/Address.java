package model;

import exceptions.InvalidZipCodeException;

public class Address {
    private String street;
    private Integer streetNumber;
    private String city;
    private Integer zipCode;

    public Address(String street, Integer streetNumber, String city, Integer zipCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = checkZipIfValid(zipCode);
    }

    private static Integer checkZipIfValid(Integer zipCode) throws InvalidZipCodeException {
        if ((zipCode > 99999 || zipCode < 10000) && (zipCode > 999999999 || zipCode < 100000000)) {
            throw new InvalidZipCodeException("invalid zip code");
        } else {
            return zipCode;
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address { " +
                "street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                " }";
    }
}
