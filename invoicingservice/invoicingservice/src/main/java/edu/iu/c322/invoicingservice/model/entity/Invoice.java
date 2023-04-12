package edu.iu.c322.invoicingservice.model.entity;

import edu.iu.c322.invoicingservice.model.dto.InvoiceDto;
import edu.iu.c322.invoicingservice.model.dto.InvoiceItemDto;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InGen")
    @SequenceGenerator(name = "InGen", sequenceName = "invoiceIdSeq", allocationSize = 1)
    private int invoiceId;
    private int orderId;

    private String invoiceCreationDate;

    private String status;

    public Invoice(){

    }

    public Invoice(InvoiceItemDto invoiceItemDto) {
        this.invoiceCreationDate = invoiceItemDto.getOn();
        this.status = invoiceItemDto.getStatus();
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getInvoiceCreationDate() {
        return invoiceCreationDate;
    }

    public void setInvoiceCreationDate(String invoiceCreationDate) {
        this.invoiceCreationDate = invoiceCreationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
