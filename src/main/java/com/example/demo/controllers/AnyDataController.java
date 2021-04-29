package com.example.demo.controllers;

import com.example.demo.pojo.AnyDataPOJO;
import com.example.demo.services.AnyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnyDataController {

    private final AnyService anyService;

    @GetMapping("/anyData")
    public List<AnyDataPOJO> getAnyDat() {
        return anyService.getAnyData();
    }
}
