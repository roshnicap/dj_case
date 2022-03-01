package com.example.dj_case.controller;

import com.example.dj_case.entity.DJ;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DJControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllDJ() throws Exception {
        mockMvc.perform(get("/dj/get/all/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    void getId() throws Exception {
        mockMvc.perform(get("/dj/get/{id}/",1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    void create() throws Exception {
        DJ testDj = new DJ("Garrix", 25, "house" );

        mockMvc.perform(post("/dj/", 42L)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(testDj)))
                .andExpect(status().isCreated());
    }

    @Test
    void delete() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.delete("/dj/{id}/", 1))
                        .andExpect(status().isAccepted());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void update() {
    }
}