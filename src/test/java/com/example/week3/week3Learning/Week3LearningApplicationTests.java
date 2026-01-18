package com.example.week3.week3Learning;

import com.example.week3.week3Learning.Entity.ProductEntity;
import com.example.week3.week3Learning.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.time.LocalDate;
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
//        List<ProductEntity> productEntityList = prodRepo.findAll();
//
//        productEntityList.stream()
//                .forEach(prod-> System.out.println(prod));

        List<ProductEntity> productEntityList1 = prodRepo.findDistinctByQuantity(11);
        productEntityList1.stream()
                .forEach(prod-> System.out.println(prod));

        List<ProductEntity> productEntityList2 = prodRepo.findFirst3ByPrice(BigDecimal.valueOf(470.5));
        productEntityList2.stream()
                .forEach(prod-> System.out.println(prod));



    }

    @Test
    void getRepo2(){
        List<ProductEntity> productEntityList3 = prodRepo.findFirst3ByOrderByPriceAsc();
        productEntityList3.stream()
                .forEach(prod-> System.out.println(prod));
    }

    @Test
    void getRepo3(){
        Optional<Integer> productEInteger = prodRepo.findTotalQuantityOfItems();
        productEInteger.ifPresent((temp)-> System.out.println("total items in inventory is "+temp));
    }

    @Test
    void getRepo4(){
        List<ProductEntity> productEntityList = prodRepo.findByCreatedAtAfter(LocalDate.of(2025,12,31));
        productEntityList.forEach(System.out::println);
    }

    @Test
    void getRepo5(){
        List<ProductEntity> productEntityList = prodRepo.findByQuantityOrPrice(11,BigDecimal.valueOf(470.5));
        productEntityList.forEach(System.out::println);
    }


    @Test
    void getRepo6(){
        List<ProductEntity> productEntityList = prodRepo.
                findByQuantityGreaterThanEqualOrPriceLessThanEqualOrderByPriceAsc(12,BigDecimal.valueOf(470.5));

        productEntityList.forEach(System.out::println);
    }

    @Test
    void getRepo7(){
        //will return items which have title starting with honey
        List<ProductEntity> productEntityList = prodRepo.findByTitleLike("honey%");
        productEntityList.forEach(System.out::println);
    }


    @Test
    void getRepo8(){
        List<ProductEntity> productEntityList = prodRepo.findByTitleContaining("harat");
        productEntityList.forEach(System.out::println);
    }

    @Test
    void getSingleItem(){
        Optional<ProductEntity> productEntityOptional = prodRepo.findByTitleAndPrice("Jamun Honey",BigDecimal.valueOf(475.5));

       try{
           System.out.println(productEntityOptional.orElseThrow());
       } catch (RuntimeException e) {
           System.out.println("No entry found, check your parameters again");
       }
       finally {
           System.out.println("Rerun this test");
       }
    }

}
