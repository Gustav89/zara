package com.capitole.zara.service;

import com.capitole.zara.dto.response.PriceResponse;
import com.capitole.zara.exception.NoPriceExistException;
import com.capitole.zara.model.PriceEntity;
import com.capitole.zara.repository.IPriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service("priceService")
public class PriceService implements IPriceService{

    IPriceRepository priceRepository;

    public PriceService(IPriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceResponse getPriceFinalPrice(LocalDateTime applicationDate, int productId, int brandId) throws Exception {

        Optional<PriceEntity> price = priceRepository.getPriceByDateAndPriority(applicationDate, productId, brandId);

        if(price.isPresent()){
            return toPriceResponse(price.get());
        }
        throw new NoPriceExistException("El precio a aplicar no existe");
    }



    private PriceResponse toPriceResponse(PriceEntity price){
        return PriceResponse.builder()
                .brandId(price.getBrandId())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .priceList(price.getPriceList())
                .productId(price.getProductId())
                .price(price.getPrice())
                .curr(price.getCurr()).build();
    }
}
