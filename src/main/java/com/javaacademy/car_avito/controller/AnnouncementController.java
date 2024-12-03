package com.javaacademy.car_avito.controller;

import com.javaacademy.car_avito.announcement.Announcement;
import com.javaacademy.car_avito.announcementStorage.AnnouncementStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AnnouncementController {
    //4. Создать web слой (все ниже это http endpoint). Использует сервис хранения объявлений.
    //4.1. Сервис позволяет создать объявление. На вход: имя бренда, цвет, цена.
    // Уникальный идентификатор генерируется во время создания объявления.
    //4.2. Сервис позволяет получить все объявления по определенному бренду.
    //4.3. Сервис позволяет удалить объявление (по уникальному идентификатору).
    //4.4. Сервис позволяет найти машину по уникальному идентификатору.

    private final AnnouncementStorage announcementStorage;
    int count = 0;

    @PostMapping("/announcement")
    public void createAnnouncement(@RequestBody Announcement announcement) {
        count++;
        announcement.setId(count);
        log.info(announcement.toString());
        announcementStorage.saveAnnouncement(announcement);
    }

    @GetMapping("/announcement")
    public List<Announcement> getAllAnnouncement() {
        return announcementStorage.getAllAnnouncement();
    }

    @DeleteMapping("/announcement/{id}")
    public boolean deleteAnnouncementById(@PathVariable Integer id) {
        return announcementStorage.removeAnnouncementById(id);
    }

    @GetMapping("/announcement/{id}")
    public Announcement getAnnouncementById(@PathVariable Integer id) {
        return announcementStorage.getAnnouncementById(id).orElseThrow();
    }

    @GetMapping("/announcement/search")
    public List<Announcement> getAnnouncementByParams(@RequestParam(required = false) String brand,
                                                      @RequestParam(required = false) String color,
                                                      @RequestParam(required = false) BigDecimal price) {
        return announcementStorage.getAnnouncementByParams(brand, color, price);
    }

}
