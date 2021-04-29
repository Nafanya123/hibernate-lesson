package com.example.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class AnyDataPOJO {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
