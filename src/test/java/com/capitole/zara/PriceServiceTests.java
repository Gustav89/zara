package com.capitole.zara;

import com.capitole.zara.config.aop.GeneralAspect;
import com.capitole.zara.dto.response.PriceResponse;
import com.capitole.zara.exception.NoPriceExistException;
import com.capitole.zara.model.PriceEntity;
import com.capitole.zara.repository.IPriceRepository;
import com.capitole.zara.service.PriceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = GeneralAspect.class)
public class PriceServiceTests {

    @InjectMocks
    PriceService service;

    @Mock
    IPriceRepository repository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("Test 1:Get Price")
    void getPriceTest() throws Exception {

        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,00,00,00);
        int productId = 35455;
        int brandId = 1;

        Mockito.when(this.repository.getPriceByDateAndPriority(applicationDate,productId,brandId))
                .thenReturn(getPriceResponse(Float.parseFloat("35.50"),"EUR"));

       PriceResponse response = service.getPriceFinalPrice(applicationDate, productId, brandId);

        Assertions.assertEquals(35.50, response.getPrice());
        Assertions.assertEquals("EUR", response.getCurr());

    }



    @Test
    @DisplayName("Test 1:Get Price null")
    void getPriceNullTest()  {

        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,00,00,00);
        int productId = 35456;
        int brandId = 1;

        Mockito.when(this.repository.getPriceByDateAndPriority(applicationDate,productId,brandId))
                .thenReturn(getPriceEntityNull());

        Assertions.assertThrows(NoPriceExistException.class,
                () -> {
                    PriceResponse response = service.getPriceFinalPrice(applicationDate, productId, brandId);
                });
    }



    private Optional<PriceEntity> getPriceResponse(float price, String curr ){
        return Optional.of(PriceEntity.builder().price(price).curr(curr).build());
    }

    private Optional<PriceEntity> getPriceEntityNull(){
        PriceEntity p = null;
        return Optional.ofNullable(p);
    }






}
