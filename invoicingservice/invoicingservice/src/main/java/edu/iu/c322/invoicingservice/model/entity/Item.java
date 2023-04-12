package edu.iu.c322.invoicingservice.model.entity;

import edu.iu.c322.invoicingservice.model.dto.ItemDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "item", schema = "orders")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemGen")
    @SequenceGenerator(name = "itemGen", sequenceName = "itemSeq", allocationSize = 1)
    private int id;
    @NotEmpty(message = "name cannot be empty.")

    private String name;
    @NotNull(message = "price cannot be empty.")

    private Double price;

    @NotNull(message = "quantity cannot be empty.")

    private int quantity;

    public Item() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
