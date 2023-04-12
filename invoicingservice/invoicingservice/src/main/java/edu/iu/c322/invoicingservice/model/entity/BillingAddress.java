package edu.iu.c322.invoicingservice.model.entity;

import edu.iu.c322.invoicingservice.model.dto.BillingAddressDto;
import jakarta.persistence.*;

@Entity
@Table(name = "billing")
public class BillingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billingGen")
    @SequenceGenerator(name = "billingGen", sequenceName = "billingSeq", allocationSize = 1)
    private int id;

    private String state, city;
    private int postalCode;



    public BillingAddress() {
    }

    public BillingAddress(BillingAddressDto billingAddressDto) {
        this.state = billingAddressDto.getState();
        this.city = billingAddressDto.getCity();
        this.postalCode = billingAddressDto.getPostalCode();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
