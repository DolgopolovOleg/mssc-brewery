package com.springguru.msscbrewery.persistance.repository;

import com.springguru.msscbrewery.web.dto.CustomerDto;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public CustomerDto findById(UUID uuid) {
        return CustomerDto.builder()
                .id(uuid)
                .name("Guiness")
                .build();
    }

    @Override
    public CustomerDto save(CustomerDto beer) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Guiness")
                .build();
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
