package com.example.demo.storage;

import com.example.demo.pojo.AnyDataPOJO;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AnyStorage {
    RestTemplate restTemplate = new RestTemplate();

    public List<AnyDataPOJO> getAnyData() {
        String URL = "http://jsonplaceholder.typicode.com/posts";
        AnyDataPOJO[] body = restTemplate.exchange(URL, HttpMethod.GET, null, AnyDataPOJO[].class).getBody();
        return Arrays.asList(body);
    }
}
