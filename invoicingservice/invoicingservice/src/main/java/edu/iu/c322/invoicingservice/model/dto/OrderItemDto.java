package edu.iu.c322.invoicingservice.model.dto;

import jakarta.validation.constraints.NotNull;

public class OrderItemDto {


    private String name;
    @NotNull(message = "quantity should not be null")
    private Integer quantity;

    private double price;

    public OrderItemDto() {
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}