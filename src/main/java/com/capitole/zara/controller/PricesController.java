package com.capitole.zara.controller;

import com.capitole.zara.dto.response.PriceResponse;
import com.capitole.zara.service.IPriceService;
import com.capitole.zara.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1")
public class PricesController {


    private IPriceService priceService;

    public PricesController(IPriceService priceService){
        this.priceService = priceService;
    }

    @GetMapping(value = "/prices")
    public ResponseEntity<PriceResponse> getPriceFinalPrice (
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDate applicationDate,
            @RequestParam int productId,
            @RequestParam int brandId) throws Exception {
        return ResponseEntity.ok(priceService.getPriceFinalPrice(applicationDate , productId,brandId));
    }
}
