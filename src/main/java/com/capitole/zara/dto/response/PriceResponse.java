package com.capitole.zara.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class PriceResponse {

    private int brandId;
    private Date startDate;
    private Date endDate;
    private int priceList;
    private int productId;
    private float price;
    private String curr;


}
