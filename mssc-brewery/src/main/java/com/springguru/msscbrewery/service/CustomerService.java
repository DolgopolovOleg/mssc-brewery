package com.springguru.msscbrewery.service;

import com.springguru.msscbrewery.web.dto.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto findById(UUID uuid);

    CustomerDto save(CustomerDto customerDto);

    CustomerDto update(CustomerDto customerDto);

    void delete(UUID uuid);
}
