package com.springguru.msscbrewery.persistance.repository;

import com.springguru.msscbrewery.web.dto.CustomerDto;

import java.util.UUID;

public interface CustomerRepository {

    CustomerDto findById(UUID uuid);

    CustomerDto save(CustomerDto beer);

    void deleteById(UUID uuid);
}
