package com.javaacademy.car_avito.announcementStorage;

import com.javaacademy.car_avito.announcement.Announcement;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
//3. Создать сервис хранения объявлений. Хранит в себе структуру: уникальный идентификатор - объявление.
//3.1. Позволяет сохранить объявление.
//3.2. Позволяет получить все объявления.
//3.3. Позволяет получить объявление по идентификатору.
//3.4. Позволяет удалить объявление.

@Component
public class AnnouncementStorage {
    private final Map<Integer, Announcement> announcementStorage = new HashMap<>();
    int count = 0;

    public void saveAnnouncement(Announcement newAnnouncement) {
        count++;
        newAnnouncement.setId(count);
        announcementStorage.put(count, newAnnouncement);
    }

    public List<Announcement> getAllAnnouncement() {
        return announcementStorage.values().stream().toList();
    }

    public Optional<Announcement> getAnnouncementById(Integer id) {
        return Optional.ofNullable(announcementStorage.get(id));
    }

    public void removeAllAnnouncements() {
        announcementStorage.clear();
    }
}
