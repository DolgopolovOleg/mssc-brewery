package com.springguru.msscbrewery.persistance.repository;

import com.springguru.msscbrewery.persistance.model.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID>, CrudRepository<Beer, UUID> {
}
