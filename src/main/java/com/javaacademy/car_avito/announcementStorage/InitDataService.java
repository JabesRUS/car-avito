package com.javaacademy.car_avito.announcementStorage;

import com.javaacademy.car_avito.announcement.Ad;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("test")
@RequiredArgsConstructor
public class InitDataService {
    private final AdStorage adStorage;

    private Ad createAd(String brand, String color, BigDecimal price) {
        return Ad.builder()
                .brand(brand)
                .color(color)
                .price(price)
                .build();
    }

    @PostConstruct
    public void init() {
        Ad ad1 = createAd("AUDI", "BLACK", BigDecimal.valueOf(1_000_000));
        Ad ad2 = createAd("AUDI", "YELOW", BigDecimal.valueOf(2_000_000));
        Ad ad3 = createAd("BMW", "BLACK", BigDecimal.valueOf(3_000_000));
        Ad ad4 = createAd("BMW", "RED", BigDecimal.valueOf(2_000_000));
        Ad ad5 = createAd("BMW", "RED", BigDecimal.valueOf(1_000_000));

        adStorage.saveAd(ad1);
        adStorage.saveAd(ad2);
        adStorage.saveAd(ad3);
        adStorage.saveAd(ad4);
        adStorage.saveAd(ad5);

    }
}
