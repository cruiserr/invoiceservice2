package edu.iu.c322.invoicingservice.model.dto;

public class StructItemDto {
    private int id;

    private String item;

    private double price;



    public StructItemDto(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

