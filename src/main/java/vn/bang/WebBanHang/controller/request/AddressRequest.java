package vn.bang.WebBanHang.controller.request;

import java.io.Serializable;
import java.util.Date;

public class AddressRequest implements Serializable {
    private String apartmentNumber;
    private String floor;
    private String building;
    private String street_number;
    private String street;
    private String city;
    private String country;
    private Integer address_type;

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAddress_type() {
        return address_type;
    }

    public void setAddress_type(Integer address_type) {
        this.address_type = address_type;
    }
}
