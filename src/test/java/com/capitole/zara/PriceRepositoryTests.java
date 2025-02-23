package com.capitole.zara;

import com.capitole.zara.model.PriceEntity;
import com.capitole.zara.repository.IPriceRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.time.LocalDateTime;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PriceRepositoryTests {

    @Autowired
    private IPriceRepository priceRepository;


    @Test
    @DisplayName("Test 1:get")
    @Order(1)
    @Rollback(value = false)
    public void getPriceTest(){


        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,00,00,00);
        int productId = 35455;
        int brandId = 1;


        Optional<PriceEntity> price = priceRepository.getPriceByDateAndPriority(applicationDate, productId, brandId);
        Assertions.assertEquals(35.50, price.get().getPrice());
        Assertions.assertEquals("EUR", price.get().getCurr());
    }


}
