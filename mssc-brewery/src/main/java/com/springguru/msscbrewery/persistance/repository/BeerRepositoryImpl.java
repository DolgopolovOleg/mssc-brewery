package com.springguru.msscbrewery.persistance.repository;

import com.springguru.msscbrewery.web.dto.BeerDto;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static com.springguru.msscbrewery.web.dto.BeerStyle.IPA;

@Repository
public class BeerRepositoryImpl implements BeerRepository {
    @Override
    public BeerDto findById(UUID uuid) {
        return BeerDto.builder()
                .id(uuid)
                .beerName("Guiness")
                .beerStyle(IPA)
                .upc(123123L)
                .build();
    }

    @Override
    public BeerDto save(BeerDto beer) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .upc(beer.getUpc())
                .build();
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
