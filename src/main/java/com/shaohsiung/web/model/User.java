package com.shaohsiung.web.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {
    private String userName;
    private Integer age;
    private String city;
}
