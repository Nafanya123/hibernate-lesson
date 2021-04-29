package com.example.demo.controllers;

import com.example.demo.pojo.AnyDataPOJO;
import com.example.demo.storage.AnyStorage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("IntegrationTest")
@SpringBootTest
public class AnyControllerTest {

    @Autowired
    private MockMvc mvc;

    @SpyBean
    private AnyStorage anyStorage;

    @Test
    public void getAnyData() throws Exception {
        AnyDataPOJO anyDataPOJO = new AnyDataPOJO()
                .setId(1)
                .setUserId(2)
                .setBody("body")
                .setTitle("title");
        List<AnyDataPOJO> listAnyDataPOJO = Arrays.asList(anyDataPOJO);
        Mockito.doReturn(listAnyDataPOJO).when(anyStorage).getAnyData();

        mvc.perform(get("/anyData")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*]", iterableWithSize(1)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
