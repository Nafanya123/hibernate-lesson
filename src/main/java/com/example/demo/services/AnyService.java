package com.example.demo.services;

import com.example.demo.pojo.AnyDataPOJO;
import com.example.demo.storage.AnyStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnyService {
    @Autowired
    private AnyStorage anyStorage;

    public List<AnyDataPOJO> getAnyData() {
        return anyStorage.getAnyData();
    }
}
