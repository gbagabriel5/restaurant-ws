package com.example.Restaurant.repository;

import org.springframework.data.repository.query.Param;

public interface GenericRepository {

    <T> T findByName(@Param("pName") String name);
}
