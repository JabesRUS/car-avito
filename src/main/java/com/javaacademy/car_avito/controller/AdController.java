package com.javaacademy.car_avito.controller;

import com.javaacademy.car_avito.ad.Ad;
import com.javaacademy.car_avito.ad_storage.AdStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AdController {
    //4. Создать web слой (все ниже это http endpoint). Использует сервис хранения объявлений.
    //4.1. Сервис позволяет создать объявление. На вход: имя бренда, цвет, цена.
    // Уникальный идентификатор генерируется во время создания объявления.
    //4.2. Сервис позволяет получить все объявления по определенному бренду.
    //4.3. Сервис позволяет удалить объявление (по уникальному идентификатору).
    //4.4. Сервис позволяет найти машину по уникальному идентификатору.

    private final AdStorage adStorage;
    private int count = 0;

    @PostMapping("/announcement")
    public void createAd(@RequestBody Ad ad) {
        adStorage.saveAd(ad);
    }

    @GetMapping("/announcement")
    public List<Ad> getAllAd() {
        return adStorage.getAllAd();
    }

    @DeleteMapping("/announcement/{id}")
    public boolean deleteAdById(@PathVariable Integer id) {
        return adStorage.removeAdById(id);
    }

    @GetMapping("/announcement/{id}")
    public Ad getAdById(@PathVariable Integer id) {
        return adStorage.getAdById(id).orElseThrow();
    }

    @GetMapping("/announcement/search")
    public List<Ad> getAdByParams(@RequestParam(required = false) String brand,
                                  @RequestParam(required = false) String color,
                                  @RequestParam(required = false) BigDecimal price) {
        return adStorage.getAdByParams(brand, color, price);
    }

}
