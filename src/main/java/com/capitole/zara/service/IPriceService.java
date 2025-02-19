package com.capitole.zara.service;

import com.capitole.zara.dto.response.PriceResponse;
import java.time.LocalDate;


public interface IPriceService {

    PriceResponse getPriceFinalPrice(LocalDate applicationDate, int productId , int brandId) throws Exception;
}
