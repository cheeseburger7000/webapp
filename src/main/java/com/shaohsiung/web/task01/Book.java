package com.shaohsiung.web.task01;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Book {
    private String name;
    private String detail;
    private BigDecimal price;
}
