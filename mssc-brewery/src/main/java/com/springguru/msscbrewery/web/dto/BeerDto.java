package com.springguru.msscbrewery.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private UUID id;
    private Integer version;

    private OffsetDateTime created;
    private OffsetDateTime updated;

    private String beerName;
    private BeerStyle beerStyle;
    private BigDecimal price;
    private Long upc;
    private Long quantityOnHand;
}
