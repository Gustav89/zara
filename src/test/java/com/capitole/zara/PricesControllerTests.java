package com.capitole.zara;

import com.capitole.zara.controller.PricesController;
import com.capitole.zara.dto.response.PriceResponse;
import com.capitole.zara.service.PriceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricesControllerTests {


    @LocalServerPort
    private int port;


    @InjectMocks
    private PricesController pricesController;

    @Mock
    private PriceService service;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void getPriceTest() throws Exception {

        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,00,00,00);
        int productId = 35455;
        int brandId = 1;

        Mockito.when(service.getPriceFinalPrice(applicationDate, productId, brandId))
                .thenReturn(getPriceResponse(Float.parseFloat("35.50"),"EUR").getBody());

        ResponseEntity<PriceResponse> response =  this.pricesController.getFinalPrice(applicationDate, productId, brandId);

        Assertions.assertEquals(HttpStatusCode.valueOf(200),response.getStatusCode());
        Assertions.assertEquals(35.50, response.getBody().getPrice());
        Assertions.assertEquals("EUR", response.getBody().getCurr());

    }



    private  ResponseEntity<PriceResponse> getPriceResponse(float price , String curr){

        return ResponseEntity.ok(PriceResponse.builder().price(price).curr(curr).build());
    }

}
