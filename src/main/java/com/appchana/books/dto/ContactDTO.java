package com.appchana.books.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactDTO
{
    private String country;
    private String region;
    private String city;
    private String postalCode;
    private String address;
    private String phone;


    private ContactDTO()
    {
    }


    public ContactDTO(String country, String region, String city, String postalCode, String address, String phone)
    {
        this.country = country;
        this.region = region;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.phone = phone;
    }

    public static ContactDTOBuilder newBuilder()
    {
        return new ContactDTOBuilder();
    }


    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public static class ContactDTOBuilder
    {
        private String country;
        private String region;
        private String city;
        private String postalCode;
        private String address;
        private String phone;


        public ContactDTOBuilder setCountry(String country)
        {
            this.country = country;
            return this;
        }

        public ContactDTOBuilder setRegion(String region)
        {
            this.region = region;
            return this;
        }

        public ContactDTOBuilder setCity(String city)
        {
            this.city = city;
            return this;
        }


        public ContactDTOBuilder setPostalCode(String postalCode)
        {
            this.postalCode = postalCode;
            return this;
        }

        public ContactDTOBuilder setAddress(String address)
        {
            this.address = address;
            return this;
        }

        public ContactDTOBuilder setPhone(String phone)
        {
            this.phone = phone;
            return this;
        }

        public ContactDTO createContactDTO()
        {
            return new ContactDTO(country, region, city, postalCode, address, phone);
        }

    }
}
