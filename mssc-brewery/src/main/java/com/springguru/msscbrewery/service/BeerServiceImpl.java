package com.springguru.msscbrewery.service;

import com.springguru.msscbrewery.persistance.repository.BeerRepository;
import com.springguru.msscbrewery.web.dto.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public BeerDto findById(UUID uuid) {
        return beerRepository.findById(uuid);
    }

    @Override
    public BeerDto save(BeerDto beer) {
        return beerRepository.save(beer);
    }

    @Override
    public BeerDto update(BeerDto beer) {
        return beerRepository.save(beer);
    }

    @Override
    public void delete(UUID uuid) {
        beerRepository.deleteById(uuid);
    }
}
