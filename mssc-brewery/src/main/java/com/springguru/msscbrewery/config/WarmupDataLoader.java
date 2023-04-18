package com.springguru.msscbrewery.config;

import com.springguru.msscbrewery.persistance.model.Beer;
import com.springguru.msscbrewery.persistance.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class WarmupDataLoader implements CommandLineRunner {

    final BeerRepository beerRepository;

    public WarmupDataLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Beer firstBeer = Beer.builder()
                .name("Beer #1")
                .style("LAGER")
                .upc(123L)
                .price(new BigDecimal(500))
                .build();

        Beer secondBeer = Beer.builder()
                .name("Beer #2")
                .style("GINES")
                .upc(124L)
                .price(new BigDecimal(550))
                .build();

        Beer thirdBeer = Beer.builder()
                .name("Beer #3")
                .style("IPA")
                .upc(125L)
                .price(new BigDecimal(300))
                .build();
        beerRepository.saveAll(new ArrayList<>(List.of(firstBeer, secondBeer, thirdBeer)));
    }
}
