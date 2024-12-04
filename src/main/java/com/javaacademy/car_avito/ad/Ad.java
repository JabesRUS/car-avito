package com.javaacademy.car_avito.ad;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Ad {
    //Объявление: уникальный идентификатор , имя бренда, цвет, цена.
    private Integer id;
    private String brand;
    private String color;
    private BigDecimal price;

}
