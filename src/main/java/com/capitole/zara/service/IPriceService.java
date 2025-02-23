package com.capitole.zara.service;

import com.capitole.zara.dto.response.PriceResponse;

import java.time.LocalDateTime;


public interface IPriceService {

    PriceResponse getPrice(LocalDateTime applicationDate, int productId , int brandId) throws Exception;
}
