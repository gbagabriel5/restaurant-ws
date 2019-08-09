package com.example.Restaurant.Service;

import com.example.Restaurant.domain.Item;
import com.example.Restaurant.dto.ItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService extends GenericService<Item, Integer> {
    Item save(Item item);

    Page<ItemDto> getByName(Pageable pageable, String name, String orderBy, String direction);
}