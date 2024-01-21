package com.epam;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class Address {
    private String city;
    private String pincode;
    public Address(){}


    public Address(String city, String pincode) {
        super();
        this.city = city;
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }
}
