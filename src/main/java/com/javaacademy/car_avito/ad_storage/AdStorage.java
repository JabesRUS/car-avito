package com.javaacademy.car_avito.ad_storage;

import com.javaacademy.car_avito.ad.Ad;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Objects;

//3. Создать сервис хранения объявлений. Хранит в себе структуру: уникальный идентификатор - объявление.
//3.1. Позволяет сохранить объявление.
//3.2. Позволяет получить все объявления.
//3.3. Позволяет получить объявление по идентификатору.
//3.4. Позволяет удалить объявление.

@Component
public class AdStorage {
    private final Map<Integer, Ad> adStorage = new HashMap<>();
    private Integer count = 0;

    public void saveAd(Ad newAd) {
        count++;
        newAd.setId(count);
        adStorage.put(count, newAd);
    }

    public List<Ad> getAllAd() {
        return adStorage.values().stream().toList();
    }

    public Optional<Ad> getAdById(Integer id) {
        return Optional.ofNullable(adStorage.get(id));
    }

    public boolean removeAdById(Integer id) {
        return adStorage.remove(id) != null;
    }

    public List<Ad> getAdByParams(String brand, String color, BigDecimal price) {
        return adStorage.values().stream()
                .filter(ad -> brand == null || Objects.equals(ad.getBrand().toUpperCase(), brand.toUpperCase()))
                .filter(ad -> color == null || Objects.equals(ad.getColor().toUpperCase(), color.toUpperCase()))
                .filter(ad -> price == null || Objects.equals(ad.getPrice(), price))
                .toList();
    }

}
