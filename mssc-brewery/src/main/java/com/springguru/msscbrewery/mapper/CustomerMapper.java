package com.springguru.msscbrewery.mapper;

import com.springguru.msscbrewery.persistance.model.Customer;
import com.springguru.msscbrewery.web.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);

    Customer toModel(CustomerDto customerDto);
}
