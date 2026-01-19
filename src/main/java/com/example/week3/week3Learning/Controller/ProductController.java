package com.example.week3.week3Learning.Controller;

import com.example.week3.week3Learning.Entity.ProductEntity;
import com.example.week3.week3Learning.Repository.ProductRepository;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    private final Integer PAGE_SIZE=5;
    private final ProductRepository productRepository;

    ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductEntity>> getAllItems(@RequestParam(name = "sortby", defaultValue = "id") String sortBy){

//      List<ProductEntity> productEntityList= productRepository.findByOrderByPriceDesc();

        //Using sort object default sort direction is ascending
//      List<ProductEntity> productEntityList = productRepository.findAll(Sort.by(sortBy));

        //we can use Sort.Direction.DESC for descending sort
//      List<ProductEntity> productEntityList = productRepository.findAll(Sort.by(Sort.Direction.DESC,sortBy));

        //we can add multiple properties to sort
//        List<ProductEntity> productEntityList = productRepository.findAll(Sort.by(
//                        Sort.Direction.DESC,sortBy,"quantity")
//        );

        //if we require more flexibility
        List<ProductEntity> productEntityList = productRepository.findAll(Sort.by(
                Sort.Order.desc(sortBy),
                Sort.Order.asc("quantity")
                ));

        return ResponseEntity.ok(productEntityList);
    }

    @GetMapping("/some")
    public ResponseEntity<List<ProductEntity>> getSomeItems
            (@RequestParam(name = "sortby", defaultValue = "id") String sortBy,
             @RequestParam(name = "page", defaultValue = "0") Integer pageNumber,
             @RequestParam(name = "title", defaultValue = "") String title){


//        Sort sort = Sort.by(
//                Sort.Order.desc(sortBy),
//                Sort.Order.asc("price")
//        );
        System.out.println("sort by - "+sortBy+", title containing - "+title+ " ,page number - "+pageNumber);
//        Pageable pageable = PageRequest.of(pageNumber,PAGE_SIZE);
        Pageable pageable = PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy));

//      Page<ProductEntity> productEntityList = productRepository.findAll(pageable);

        List<ProductEntity> productEntityList = productRepository.findByTitleContaining(title,pageable);

        return ResponseEntity.ok(productEntityList);
    }


}
