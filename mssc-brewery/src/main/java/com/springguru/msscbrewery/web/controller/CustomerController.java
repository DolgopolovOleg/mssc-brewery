package com.springguru.msscbrewery.web.controller;

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

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CustomerDto> getById(@PathVariable UUID uuid) {
        return new ResponseEntity<>(customerService.findById(uuid).orElseThrow(RuntimeException::new), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.save(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + createdCustomer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<CustomerDto> editCustomer(@PathVariable UUID uuid, @RequestBody CustomerDto customerDto) {
        customerDto.setId(uuid);
        customerService.update(customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID uuid) {
        customerService.delete(uuid);
    }
}
