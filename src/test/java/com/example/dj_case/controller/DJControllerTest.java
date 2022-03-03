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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
    void getId() {
        try {
            mockMvc.perform(get("/dj/get/{id}/",1))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void create() {
        DJ testDj = new DJ("Garrix", 25, "house" );

        try {
            mockMvc.perform(post("/dj/", 42L)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(objectMapper.writeValueAsString(testDj)))
                    .andExpect(status().isCreated());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void delete() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.delete("/dj/delete/{id}/", 1)
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                            .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            mockMvc.perform(MockMvcRequestBuilders.delete("/dj/delete/{id}/", 10)
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void update() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.put("/dj/update/{id}",1)
                    .content(objectMapper.writeValueAsString(new DJ("Garrix", 25, "house" )))
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Garrix"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(25))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.style").value("house"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}