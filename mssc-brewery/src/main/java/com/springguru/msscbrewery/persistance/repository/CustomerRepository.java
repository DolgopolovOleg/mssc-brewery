package com.springguru.msscbrewery.persistance.repository;

import com.springguru.msscbrewery.persistance.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

}
