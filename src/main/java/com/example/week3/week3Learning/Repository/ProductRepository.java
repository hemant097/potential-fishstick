package com.example.week3.week3Learning.Repository;

import com.example.week3.week3Learning.Entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    //as title and price having a unique constraint, so it is expected to return one row only
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);


    //Definition in SQL -> SELECT * FROM table_name WHERE price = ? LIMIT 3; --no ordering takes place
    List<ProductEntity> findFirst3ByPrice(BigDecimal bigDecimal);


    //SELECT * FROM table ORDER BY price ASC LIMIT 3; --order in ascending
    List<ProductEntity> findFirst3ByOrderByPriceAsc();


    //Select * from table where created_at > ?
    List<ProductEntity> findByCreatedAtAfter(LocalDate localDate);


    //select * from table where quantity=? or price=?;
    List<ProductEntity> findByQuantityOrPrice(Integer quantity, BigDecimal price);


    //select * from table where quantity>=11 or price<=470.5 order by price ASC;
    List<ProductEntity> findByQuantityGreaterThanEqualOrPriceLessThanEqualOrderByPriceAsc(Integer quantity,BigDecimal price);


    //SELECT DISTINCT * FROM table WHERE quantity = ?;
    List<ProductEntity> findDistinctByQuantity(Integer quantity);


    //SELECT * FROM table WHERE title LIKE '?'; --we need to use % or _ while passing title
    List<ProductEntity> findByTitleLike(String title);


    //SELECT * FROM table WHERE title LIKE '?'; --no need to use % or _ as spring takes care of it
    List<ProductEntity> findByTitleContaining(String title, Pageable pageable);

    //Select * from table order by price desc;
    List<ProductEntity> findByOrderByPriceDesc();

    List<ProductEntity> findBy(Sort sort);

    //Custom queries, if required as JPA does not cover everything
    @Query("select sum(p.quantity) from ProductEntity p")
    Optional<Integer> findTotalQuantityOfItems();

}
