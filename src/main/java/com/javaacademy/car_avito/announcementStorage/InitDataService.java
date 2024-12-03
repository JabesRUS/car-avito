package com.javaacademy.car_avito.announcementStorage;

import com.javaacademy.car_avito.announcement.Announcement;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("test")
@RequiredArgsConstructor
public class InitDataService {
    private final AnnouncementStorage announcementStorage;

    private Announcement createAnnouncement(Integer id, String brand, String color, BigDecimal price) {
        return Announcement.builder().
                id(id)
                .brand(brand)
                .color(color)
                .price(price)
                .build();
    }

    @PostConstruct
    public void init() {
        Announcement announcement1 = createAnnouncement(1, "AUDI", "BLACK", BigDecimal.valueOf(1_000_000));
        Announcement announcement2 = createAnnouncement(2, "AUDI", "YELOW", BigDecimal.valueOf(2_000_000));
        Announcement announcement3 = createAnnouncement(3, "BMW", "BLACK", BigDecimal.valueOf(3_000_000));
        Announcement announcement4 = createAnnouncement(4, "BMW", "RED", BigDecimal.valueOf(2_000_000));
        Announcement announcement5 = createAnnouncement(5, "BMW", "RED", BigDecimal.valueOf(1_000_000));

        announcementStorage.saveAnnouncement(announcement1);
        announcementStorage.saveAnnouncement(announcement2);
        announcementStorage.saveAnnouncement(announcement3);
        announcementStorage.saveAnnouncement(announcement4);
        announcementStorage.saveAnnouncement(announcement5);

    }
}
