package com.javaacademy.car_avito.announcement;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Announcement {
    //Объявление: уникальный идентификатор , имя бренда, цвет, цена.
    private Integer id;
    private String brand;
    private String color;
    private BigDecimal price;

}
