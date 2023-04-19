package com.springguru.msscbrewery.web.controller;

import com.springguru.msscbrewery.mapper.CustomerMapper;
import com.springguru.msscbrewery.persistance.model.Customer;
import com.springguru.msscbrewery.service.CustomerService;
import com.springguru.msscbrewery.web.dto.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CustomerDto> getById(@PathVariable UUID uuid) {
        Customer customer = customerService.findById(uuid).orElseThrow(RuntimeException::new);
        CustomerDto customerDto = customerMapper.toDto(customer);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = customerMapper.toModel(customerDto);
        customer = customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + customer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<CustomerDto> editCustomer(@PathVariable UUID uuid, @RequestBody CustomerDto customerDto) {
        customerDto.setId(uuid);
        Customer customer = customerMapper.toModel(customerDto);
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID uuid) {
        customerService.delete(uuid);
    }
}
