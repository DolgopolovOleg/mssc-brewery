package com.springguru.msscbrewery.persistance.repository;

import com.springguru.msscbrewery.web.dto.BeerDto;

import java.util.UUID;

public interface BeerRepository {

    BeerDto findById(UUID uuid);

    BeerDto save(BeerDto beer);

    void deleteById(UUID uuid);
}
