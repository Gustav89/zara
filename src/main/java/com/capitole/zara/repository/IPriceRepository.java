package com.capitole.zara.repository;

import com.capitole.zara.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query(value = "select * from prices n where n.id = :id and n.deleted = FALSE" , nativeQuery = true)
    Optional<PriceEntity> getPriceById(@Param("id") Long id);

}
