package com.springguru.msscbrewery.service;

import com.springguru.msscbrewery.persistance.repository.CustomerRepository;
import com.springguru.msscbrewery.web.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto findById(UUID uuid) {
        return customerRepository.findById(uuid);
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return customerRepository.save(customerDto);
    }

    @Override
    public CustomerDto update(CustomerDto customerDto) {
        return customerRepository.save(customerDto);
    }

    @Override
    public void delete(UUID uuid) {
        customerRepository.deleteById(uuid);
    }
}
