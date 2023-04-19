package com.springguru.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springguru.msscbrewery.mapper.BeerMapper;
import com.springguru.msscbrewery.persistance.model.Beer;
import com.springguru.msscbrewery.service.BeerService;
import com.springguru.msscbrewery.web.dto.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerServiceMock;
    @MockBean
    BeerMapper beerMapper;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        UUID uuid = UUID.randomUUID();
        Beer beerDto = Beer.builder().id(uuid).name("testName").build();
        when(beerServiceMock.findById(uuid)).thenReturn(Optional.of(beerDto));
        when(beerMapper.toDto(any())).thenReturn(BeerDto.builder().id(uuid).build());

//        String beerDtoString = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(get("/api/v1/beer/" + uuid).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(content().json(beerDtoString));
    }

    @Test
    void createBeerValidationTest() throws Exception {
        BeerDto notNullBeerDto = BeerDto.builder()
                .id(UUID.randomUUID())
                .build();

        String beerDtoString = objectMapper.writeValueAsString(notNullBeerDto);
        mockMvc.perform(post("/api/v1/beer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoString))
                .andExpect(status().isBadRequest());
    }

    @Test
    void editBeerTest() {

    }

    @Test
    void deleteBeerTest() {

    }

    @Test
    void pingPong() {

    }
}