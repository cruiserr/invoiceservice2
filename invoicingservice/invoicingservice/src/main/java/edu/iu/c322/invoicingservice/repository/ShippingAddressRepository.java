package edu.iu.c322.invoicingservice.repository;

import edu.iu.c322.invoicingservice.model.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepository extends JpaRepository<Shipping, Integer> {
}