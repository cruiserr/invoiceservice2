package edu.iu.c322.invoicingservice.repository;

import edu.iu.c322.invoicingservice.model.entity.Invoice;
import edu.iu.c322.invoicingservice.model.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoice, Integer> {
}