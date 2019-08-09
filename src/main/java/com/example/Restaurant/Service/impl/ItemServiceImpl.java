package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ItemService;
import com.example.Restaurant.domain.Item;
import com.example.Restaurant.dto.ItemDto;
import com.example.Restaurant.mapper.ItemMapper;
import com.example.Restaurant.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item,Integer> implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private  ItemFilter itemFilter;

    private final ItemMapper itemMapper = new ItemMapper();

    @Override
    public void trim(Item entity) {
    }


    @Override
    public Item save(Item item) {
        if(item.getQuantity()>item.getMinQuantity())
            item.setStatus("OK");
        return itemRepository.save(item);
    }

    @Override
    public Page<ItemDto> getByName(Pageable pageable, String name, String order, String direction) {
        FilterManager<Item> filterManager = new FilterManager<>(itemFilter);

        filterManager.addParameter("name", "%" + name + "%");
        if(direction.equals("ASC")){
            filterManager.orderBy(order).asc();
        }else {
            filterManager.orderBy(order).desc();
        }

        List<Item> itemList = filterManager.findByFilter();

        List<ItemDto> itemDtos= new ArrayList<>();

        itemList.forEach(item ->  itemDtos.add(itemMapper.convertToDTO(item)));
        Long pageInit = pageable.getOffset();
        Long pageEnd = (pageInit + pageable.getPageSize()) > itemDtos.size() ? itemDtos.size() : (pageInit + pageable.getPageSize());

        return new PageImpl<>(itemDtos.subList(pageInit.intValue(), pageEnd.intValue()), pageable, itemDtos.size());
    }
}