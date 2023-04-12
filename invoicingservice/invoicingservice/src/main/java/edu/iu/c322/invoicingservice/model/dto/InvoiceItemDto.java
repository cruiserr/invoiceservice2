package edu.iu.c322.invoicingservice.model.dto;

import java.util.List;

public class InvoiceItemDto {
    private String status;

    private List<StructItemDto> items;

    private String on;

    private ShippingDto shippingDto;

    public InvoiceItemDto(){

    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StructItemDto> getItems() {
        return items;
    }

    public void setItems(List<StructItemDto> items) {
        this.items = items;
    }

    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }

    public ShippingDto getShippingDto() {
        return shippingDto;
    }

    public void setShippingDto(ShippingDto shippingDto) {
        this.shippingDto = shippingDto;
    }
}
