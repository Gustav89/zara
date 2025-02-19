package com.capitole.zara.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="prices")
@Getter
public class PriceEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int brandId;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    @Column(nullable = false)
    private int priceList;
    @Column(nullable = false)
    private int productId;
    @Column(nullable = false)
    private int priority;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
    private String curr;
}
