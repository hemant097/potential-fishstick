package com.example.week3.week3Learning.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
		uniqueConstraints = {
				@UniqueConstraint(name="sku_unique", columnNames = {"sku"}),
				@UniqueConstraint(name = "title_price_unique",columnNames = {"title","price"})
})
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length=20)
	private String sku;
	
	@Column(name="productTitle")
	private String title;
	
	
	private BigDecimal price;
	private Integer quantity;
	@CreationTimestamp
	private LocalDate createdAt;
	@UpdateTimestamp
	private LocalDate updatedAt;
	
	

}
