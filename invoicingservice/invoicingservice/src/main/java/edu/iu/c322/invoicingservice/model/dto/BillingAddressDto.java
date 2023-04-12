package edu.iu.c322.invoicingservice.model.dto;

import edu.iu.c322.invoicingservice.model.entity.BillingAddress;

public class BillingAddressDto {

    private String state;

    private String city;

    private int postalCode;

    public BillingAddressDto(){

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
