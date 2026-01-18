package com.example.week3.week3Learning.Controller;

import com.example.week3.week3Learning.Entity.ProductEntity;
import com.example.week3.week3Learning.Repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductEntity>> getAllItems(@RequestParam(name = "sortby", defaultValue = "id") String sortBy){

//    List<ProductEntity> productEntityList= productRepository.findByOrderByPriceDesc();

      List<ProductEntity> productEntityList = productRepository.findAll(Sort.by(sortBy));

      return ResponseEntity.ok(productEntityList);
    }
}
