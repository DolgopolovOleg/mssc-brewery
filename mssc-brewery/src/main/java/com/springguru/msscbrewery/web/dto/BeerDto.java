package com.springguru.msscbrewery.web.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @Null
    private UUID id;
    private Integer version;

    private LocalDateTime created;
    private LocalDateTime updated;

    @NotBlank
    private String name;
    @NotNull
    private BeerStyle beerStyle;
    @PositiveOrZero
    private BigDecimal price;
    @Positive
    private Long upc;
    @PositiveOrZero
    private Long quantityOnHand;
}
