package com.example.Restaurant.utils;

import com.example.Restaurant.domain.BaseEntity;

public final class BaseEntityUtils {
    private BaseEntityUtils() {
    }

    public static <T> T getId(BaseEntity<T> entity, T valueIfNull) {
        if (entity != null && entity.getId() != null) {
            return entity.getId();
        }
        return valueIfNull;
    }

    public static boolean hasId(BaseEntity<Long> entity) {
        return entity != null && hasId(entity.getId());
    }

    public static boolean hasId(Long id) {
        return id != null && (id > 0L);
    }

    public static boolean hasId(Integer id) {
        return id != null && (id > 0L);
    }
}