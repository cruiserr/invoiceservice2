package edu.iu.c322.invoicingservice.model.entity;

import edu.iu.c322.invoicingservice.model.dto.ShippingDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shippingGen")
    @SequenceGenerator(name = "shippingGen", sequenceName = "shippingSeq", allocationSize = 1)
    private int id;
    @NotEmpty(message = "shipping fields cannot be empty.")
    private String state, city;
    private int postalCode;

    public Shipping() {
    }

    public Shipping(ShippingDto addressDto) {
        this.state = addressDto.getState();
        this.city = addressDto.getCity();
        this.postalCode = addressDto.getPostalCode();
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
