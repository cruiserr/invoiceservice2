package edu.iu.c322.invoicingservice.repository;

import edu.iu.c322.invoicingservice.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query(value = "SELECT * FROM orders.item WHERE name = :name", nativeQuery = true)
    Item findByName(@Param("name") String name);
}
