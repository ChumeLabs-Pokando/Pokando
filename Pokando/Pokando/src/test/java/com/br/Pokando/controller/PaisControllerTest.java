/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.br.Pokando.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author 05029689150
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PaisControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public PaisControllerTest() {
    }

    public void dadoIdInexistente_DevolverNaoEncontrado() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/pais/{id}", 1L);
        ResultActions result = mockMvc.perform(request);

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        result.andExpect(resultStatus);

        ResultMatcher resultMediaType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        result.andExpect(resultMediaType);

        Long expectedId = 1L;
        ResultMatcher resultId = MockMvcResultMatchers.jsonPath("$.id").value(expectedId);
        result.andExpect(resultId);

    }

}
