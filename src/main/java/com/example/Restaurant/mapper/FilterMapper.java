package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.BaseEntity;

public interface FilterMapper<E extends BaseEntity, F> {
    E convertFilterToEntity(F filterDTO);
}