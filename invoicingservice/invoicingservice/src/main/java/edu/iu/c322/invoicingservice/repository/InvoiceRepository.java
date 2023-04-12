package edu.iu.c322.invoicingservice.repository;

import edu.iu.c322.invoicingservice.model.entity.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {

    /*

    //crud
    //create
    //update
    //delete

    private List<Invoice> invoices = new ArrayList<>();

    public Invoice findByOrder(int id){
        Invoice x = getOrderById(id);
        if(x != null){
            return getOrderById(id);
        }else{
            throw new IllegalStateException("order with this id does not exist in the system");
        }

    }

    public int create(Invoice invoice){
        int id = invoices.size() + 1;
        invoice.setOrderId(id);
        List<InvoiceItem> invoiceItems = invoice.getInvoiceItem();
        double orderTotal = 0;
        int itemCounter = 0;
        for (InvoiceItem x: invoiceItems){
            List<Item> items = x.getItems();
            for (Item p: items){
                double quantity = p.getQuantity();
                double price = p.getPrice();
                double total = quantity * price;
                orderTotal += total;

                itemCounter++;
                p.setItemId(itemCounter);
            }
            x.setAddress(x.getAddress());
        }



        invoice.setTotal(orderTotal);


        Payment pay = invoice.getPayment();
        BillingAddress billingAddress = pay.getBillingAddress();
        pay.setBillingAddress(billingAddress);

        invoices.add(invoice);
        return id;
    }



    public void update(StatusUpdate stats, int id){

        int itemId = stats.getItemId();
        String status = stats.getStatus();
        Invoice x = getOrderById(id);

        if(x != null){
            List<InvoiceItem> itemss = x.getInvoiceItem();
            for (InvoiceItem m: itemss){
                m.setStatus(status);
            }
        }else{
            throw new IllegalStateException("order id is not valid.");
        }


    }



    private Invoice getOrderById(int id){
        return invoices.stream().filter(x -> x.getOrderId() == id).findAny().orElse(null);
    }


     */
}