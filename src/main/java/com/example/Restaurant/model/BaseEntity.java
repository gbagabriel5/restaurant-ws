package com.example.Restaurant.model;

import java.io.Serializable;

public interface BaseEntity<ID> extends Serializable {
    ID getId();

    void setId(ID id);
}
