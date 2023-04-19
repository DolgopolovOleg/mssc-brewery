package com.springguru.msscbrewery.service;

import com.springguru.msscbrewery.persistance.model.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    Optional<Customer> findById(UUID uuid);

    Customer save(Customer customer);

    void delete(UUID uuid);
}
