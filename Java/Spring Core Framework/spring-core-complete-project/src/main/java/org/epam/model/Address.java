package org.epam.model;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class Address {
    private Integer id;
    private List<String> currentAddress;
    private Set<String> pincode;
    private Map<String, String> phoneNumbers;

    public Address() {
    }

    public Address(Integer id, List<String> currentAddress, Set<String> pincode, Map<String, String> phoneNumbers) {
        this.id = id;
        this.currentAddress = currentAddress;
        this.pincode = pincode;
        this.phoneNumbers = phoneNumbers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("Setting id using the setter/property injection");
        this.id = id;
    }

    public List<String> getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(List<String> currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Set<String> getPincode() {
        return pincode;
    }

    public void setPincode(Set<String> pincode) {
        this.pincode = pincode;
    }

    public Map<String, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<String, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address=" + currentAddress +
                ", pincode=" + pincode +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
