package com.springguru.msscbrewery.web.controller;

import com.springguru.msscbrewery.mapper.BeerMapper;
import com.springguru.msscbrewery.persistance.model.Beer;
import com.springguru.msscbrewery.service.BeerService;
import com.springguru.msscbrewery.web.dto.BeerDto;
import jakarta.validation.Valid;
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
    private final BeerMapper beerMapper;

    public BeerController(BeerService beerService, BeerMapper beerMapper) {
        this.beerService = beerService;
        this.beerMapper = beerMapper;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID uuid) {
        Beer beer = beerService.findById(uuid).orElseThrow(RuntimeException::new);
        BeerDto beerDto = beerMapper.toDto(beer);
        return new ResponseEntity<>(beerDto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<BeerDto> createBeer(@Valid @RequestBody BeerDto beerDto) {
        Beer beer = beerMapper.toModel(beerDto);
        beer = beerService.save(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + beer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<BeerDto> editBeer(@PathVariable UUID uuid, @RequestBody BeerDto beerDto) {
        beerDto.setId(uuid);
        Beer beer = beerMapper.toModel(beerDto);
        beerService.save(beer);
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
