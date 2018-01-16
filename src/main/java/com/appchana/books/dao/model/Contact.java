package com.appchana.books.dao.model;

/**
 * Created by ivanmolera on 16/01/2018.
 */
public class Contact {
    private String country;
    private String region;
    private String city;
    private String postalCode;
    private String address;
    private String phone;

    public Contact(String country, String region, String city, String postalCode, String address, String phone) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }


    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return this.phone;
    }
}
