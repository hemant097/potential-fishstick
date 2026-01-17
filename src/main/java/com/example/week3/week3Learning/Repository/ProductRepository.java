package com.example.week3.week3Learning.Repository;

import com.example.week3.week3Learning.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    @Query("select sum(p.quantity) from ProductEntity p")
    Optional<Integer> findTotalItems();

}
