package com.capitole.zara.repository;

import com.capitole.zara.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface IPriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query(value = "SELECT * FROM prices n \n" +
            "WHERE :applicationDate BETWEEN start_date AND end_date \n" +
            "and n.product_id = :productId \n" +
            "and n.brand_id = :brandId \n" +
            "ORDER BY priority DESC \n" +
            "LIMIT 1;" , nativeQuery = true)
    Optional<PriceEntity> getPriceByDateAndPriority(@Param("applicationDate") LocalDate applicationDate,
                                                    int productId, int brandId);



}
