package com.springguru.msscbrewery.service;

import com.springguru.msscbrewery.web.dto.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto findById(UUID uuid);

    BeerDto save(BeerDto beer);

    BeerDto update(BeerDto beer);

    void delete(UUID uuid);
}
