package edu.iu.c322.invoicingservice.model.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Entity
@Table(name = "invoiceItem")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iiid")
    @SequenceGenerator(name = "iiid", sequenceName = "InvoiceItemIdSeq", allocationSize = 1)
    private int invoiceItemId;


    private String status;
    @ManyToOne()
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private String onDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shippingAddressId", referencedColumnName = "id")
    private Shipping shippingAddress;

    public InvoiceItem(){

    }

    public InvoiceItem(Invoice invoice, Item item, InvoiceItem invoiceItem, Shipping shippingAddress) {
        this.status = invoiceItem.getStatus();
        this.invoice = invoice;
        this.item = item;
        this.onDate = invoiceItem.getOn();
        this.shippingAddress = shippingAddress;
    }


    public int getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(int invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getOn() {
        return onDate;
    }

    public void setOn(String on) {
        this.onDate = on;
    }

    public Shipping getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Shipping shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
