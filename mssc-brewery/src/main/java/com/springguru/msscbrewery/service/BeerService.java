package com.springguru.msscbrewery.service;

import com.springguru.msscbrewery.persistance.model.Beer;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Optional<Beer> findById(UUID uuid);

    Beer save(Beer beer);

    void delete(UUID uuid);
}
