package com.springguru.msscbrewery.web.controller;

import com.springguru.msscbrewery.service.BeerService;
import com.springguru.msscbrewery.web.dto.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID uuid) {
        BeerDto beerDto = beerService.findById(uuid);
        return new ResponseEntity<>(beerDto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<BeerDto> createBeer(@RequestBody BeerDto beer) {
        BeerDto createdBeer = beerService.save(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + createdBeer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<BeerDto> editBeer(@PathVariable UUID uuid, @RequestBody BeerDto beer) {
        beer.setId(uuid);
        beerService.update(beer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID uuid) {
        beerService.delete(uuid);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> pingPong() {
        return new ResponseEntity<>("pongs", HttpStatus.OK);
    }
}
