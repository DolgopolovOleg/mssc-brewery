package com.springguru.msscbrewery.mapper;

import com.springguru.msscbrewery.persistance.model.Beer;
import com.springguru.msscbrewery.web.dto.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto toDto(Beer beer);

    Beer toModel(BeerDto beerDto);
}
