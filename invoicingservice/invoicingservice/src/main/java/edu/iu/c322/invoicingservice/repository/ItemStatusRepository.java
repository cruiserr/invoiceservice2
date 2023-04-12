package edu.iu.c322.invoicingservice.repository;

import edu.iu.c322.invoicingservice.model.entity.ItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemStatusRepository extends JpaRepository<ItemStatus, Integer> {
}