package edu.iu.c322.invoicingservice.model.entity;

import edu.iu.c322.invoicingservice.model.dto.PaymentDto;
import edu.iu.c322.invoicingservice.model.entity.BillingAddress;
import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentGen")
    @SequenceGenerator(name = "paymentGen", sequenceName = "paymentSeq", allocationSize = 1)
    private int id;
    private String method, number;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private BillingAddress billingAddress;

    public Payment() {
    }
    public Payment(PaymentDto paymentDto, BillingAddress billingAddress) {
        this.method = paymentDto.getMethod();
        this.number = paymentDto.getNumber();
        this.billingAddress = billingAddress;
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

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
