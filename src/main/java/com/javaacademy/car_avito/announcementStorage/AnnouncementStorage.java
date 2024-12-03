package com.javaacademy.car_avito.announcementStorage;

import com.javaacademy.car_avito.announcement.Announcement;
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
public class AnnouncementStorage {
    private final Map<Integer, Announcement> announcementStorage = new HashMap<>();

    public void saveAnnouncement(Announcement newAnnouncement) {
        announcementStorage.put(newAnnouncement.getId(), newAnnouncement);
    }

    public List<Announcement> getAllAnnouncement() {
        return announcementStorage.values().stream().toList();
    }

    public Optional<Announcement> getAnnouncementById(Integer id) {
        return Optional.ofNullable(announcementStorage.get(id));
    }

    public boolean removeAnnouncementById(Integer id) {
        return announcementStorage.remove(id) != null;
    }

    public List<Announcement> getAnnouncementByParams(String brand, String color, BigDecimal price) {
        return announcementStorage.values().stream()
                .filter(announcement -> brand == null || Objects.equals(announcement.getBrand(), brand.toUpperCase()))
                .filter(announcement -> color == null || Objects.equals(announcement.getColor(), color.toUpperCase()))
                .filter(announcement -> price == null || Objects.equals(announcement.getPrice(), price))
                .toList();
    }

}
