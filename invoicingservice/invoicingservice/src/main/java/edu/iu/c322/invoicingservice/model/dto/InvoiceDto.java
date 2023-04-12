package edu.iu.c322.invoicingservice.model.dto;

import java.util.List;

public class InvoiceDto {
    private String orderPlaced;
    private double total;

    private InvoiceItemDto invoiceItemDto;

    private PaymentDto paymentDto;

    public InvoiceDto(){

    }
    public InvoiceDto(String error){
        System.out.println(error);
    }


    public String getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(String orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public InvoiceItemDto getInvoiceItemDto() {
        return invoiceItemDto;
    }

    public void setInvoiceItemDto(InvoiceItemDto invoiceItemDto) {
        this.invoiceItemDto = invoiceItemDto;
    }

    public PaymentDto getPaymentDto() {
        return paymentDto;
    }

    public void setPaymentDto(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }
}
