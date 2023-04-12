package edu.iu.c322.invoicingservice.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ItemStatus")
public class ItemStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemStGen")
    @SequenceGenerator(name = "itemStGen", sequenceName = "itemStatusSeq", allocationSize = 1)
    private int itemStatusId;


    private int itemId;

    private int OrderId;

    private String status;

    private String date;


    public int getItemStatusId() {
        return itemStatusId;
    }

    public void setItemStatusId(int itemStatusId) {
        this.itemStatusId = itemStatusId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

