package com.example.week3.week3Learning.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(
		name = "productTable",
		uniqueConstraints = {//used to create unique constraints, eg. no 2 SIN can be same, no 2 rows can have same title , price
				@UniqueConstraint(name="sin_unique", columnNames = {"sin"}),
				@UniqueConstraint(name = "title_price_unique",columnNames = {"productTitle","price"})
        },
        indexes = { //for faster searches
                @Index(name = "sku_index",columnList = "sku")
        }
)
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length=20)
	private String sku;

    @Column(name = "sin")
    private String standardIdentificationNumber;

	@Column(name="productTitle")
	private String title;

	private BigDecimal price;

	private Integer quantity;

	@CreationTimestamp
	private LocalDate createdAt;
	@UpdateTimestamp
	private LocalDate updatedAt;
	
	

}
