package com.capitole.zara.service;

import com.capitole.zara.dto.response.PriceResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Date;

public interface IPriceService {

    PriceResponse getPriceFinalPrice(LocalDate applicationDate, int productId , int brandId) throws Exception;
}
