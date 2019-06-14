package com.example.Restaurant.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public final class PagingUtils {

    private static final int PAGE = 0;
    private static final int COUNT = 99;

    private PagingUtils() {
    }

    public static PageRequest createPageRequest(Integer page, Integer count, String order, String sortProperty) {

        Sort.Direction direction = order == null || order.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        if (sortProperty == null) {
            sortProperty = "id";
        }

        if (page == null) {
            page = PAGE;
        }
        if (count == null) {
            count = COUNT;
        }
        return PageRequest.of(page, count, new Sort(direction, sortProperty));
    }

}
