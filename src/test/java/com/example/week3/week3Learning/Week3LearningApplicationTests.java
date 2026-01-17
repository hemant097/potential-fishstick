package com.example.week3.week3Learning;

import com.example.week3.week3Learning.Entity.ProductEntity;
import com.example.week3.week3Learning.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Week3LearningApplicationTests {

    @Autowired
    ProductRepository prodRepo;

	@Test
	void contextLoads() {
	}

    @Test
    void testRepository(){
        ProductEntity product = ProductEntity.builder()
                .sku("MAIR15")
                .title("Apple macbook air 15.3inch")
                .price(BigDecimal.valueOf(105000))
                .quantity(18)
                .standardIdentificationNumber("APPLEM153")
                .build();

        ProductEntity savedProd = prodRepo.save(product);
        System.out.println(savedProd);
    }

    @Test
    void getRepository(){
        List<ProductEntity> productEntityList = prodRepo.findAll();
        productEntityList.stream()
                .forEach(prod-> System.out.println(prod));
    }

    @Test
    void getSingleItem(){
        Optional<ProductEntity> productEntityOptional = prodRepo.findByTitleAndPrice("HoneyVeda Jamun Honey",BigDecimal.valueOf(525.00));

        productEntityOptional.ifPresent(popt -> System.out.println(popt));

        Optional<Integer> productEInteger = prodRepo.findTotalItems();

        productEInteger.ifPresent((temp)-> System.out.println("total items in inventory is "+temp));
    }

}
