package com.springguru.msscbrewery.persistance.repository;

import com.springguru.msscbrewery.web.dto.CustomerDto;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<CustomerDto, UUID> {

}
