package com.capitole.zara.controller;

import com.capitole.zara.service.IPriceService;
import com.capitole.zara.service.PriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class PricesController {


    private IPriceService priceService;

    public PricesController(IPriceService priceService){
        this.priceService = priceService;
    }



    @GetMapping(value = "/prices")
    public ResponseEntity<?> getPriceFinalPrice (){
        return ResponseEntity.ofNullable(priceService.getPriceFinalPrice());
    }
}
