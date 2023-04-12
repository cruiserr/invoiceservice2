package edu.iu.c322.invoicingservice.model.dto;

public class PaymentDto {
    private String method;

    private String number;

    private BillingAddressDto billingAddress;

    public PaymentDto(){

    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BillingAddressDto getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddressDto billingAddressDto) {
        this.billingAddress = billingAddressDto;
    }
}
