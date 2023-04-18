package com.springguru.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springguru.msscbrewery.service.BeerService;
import com.springguru.msscbrewery.web.dto.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerServiceMock;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        UUID uuid = UUID.randomUUID();
        BeerDto beerDto = BeerDto.builder().id(uuid).beerName("testName").build();
        when(beerServiceMock.findById(uuid)).thenReturn(beerDto);

        String beerDtoString = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(get("/api/v1/beer/" + uuid).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(beerDtoString));
    }

    @Test
    void createBeer() {

    }

    @Test
    void editBeer() {

    }

    @Test
    void deleteBeer() {

    }

    @Test
    void pingPong() {

    }
}