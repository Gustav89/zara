package com.capitole.zara.service;

import com.capitole.zara.entities.PriceEntity;
import com.capitole.zara.repository.IPriceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("priceService")
public class PriceService implements IPriceService{

    IPriceRepository priceRepository;

    public PriceService(IPriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    //agregarle el objeto body que viene desde postman
    @Override
    public String getPriceFinalPrice() {

        //cambiar a uso de la db
        Optional<PriceEntity> price = Optional.empty();

        if(price.isPresent()){
            return "existe el precio";
        }
        return "el precio no existe";
    }
}
