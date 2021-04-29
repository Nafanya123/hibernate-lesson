package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("IntegrationTest")
@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @Sql(scripts = "classpath:data.sql")
    public void getAllStudent() throws Exception {
        mvc.perform(get("/students")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*]", iterableWithSize(1)))
                .andExpect(jsonPath("$.[*].id", containsInAnyOrder(0)))
                .andExpect(jsonPath("$.[*].name", containsInAnyOrder("Vasy")))
                .andExpect(jsonPath("$.[*].group.name", containsInAnyOrder("History Group")))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @Sql(scripts = "classpath:data.sql")
    public void saveStudent() throws Exception {
        String body =
                "{\n" +
                "    \"name\": \"Ozz\",\n" +
                "    \"age\": 20,\n" +
                "    \"group\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"History Group\"\n" +
                "    }\n" +
                "}";

        mvc.perform(post("/student/save")
                .contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(jsonPath("$.[*]", iterableWithSize(2)))
                .andExpect(jsonPath("$.[*].id", containsInAnyOrder(0, 1)))
                .andExpect(jsonPath("$.[*].name", containsInAnyOrder("Vasy", "Ozz")))
                .andExpect(jsonPath("$.[*].group.name", containsInAnyOrder("History Group", "History Group")))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
