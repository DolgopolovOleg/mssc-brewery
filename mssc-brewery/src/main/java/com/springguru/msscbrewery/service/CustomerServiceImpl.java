package com.springguru.msscbrewery.service;

import com.springguru.msscbrewery.persistance.model.Customer;
import com.springguru.msscbrewery.persistance.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findById(UUID uuid) {
        return customerRepository.findById(uuid);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(UUID uuid) {
        customerRepository.deleteById(uuid);
    }
}
