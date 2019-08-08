package com.example.Restaurant.controller;

import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.Service.ItemService;
import com.example.Restaurant.domain.Item;
import com.example.Restaurant.dto.ItemDto;
import com.example.Restaurant.mapper.GenericMapper;
import com.example.Restaurant.mapper.ItemMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Item Controller")
@RestController
@RequestMapping(value = "/item")
public class ItemController implements ListRest<Item, ItemDto, Integer> {

    @Autowired
    private final ItemService itemService;
    private final ItemMapper itemMapper = new ItemMapper();

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public GenericMapper<Item, ItemDto> getMapper() {
        return new ItemMapper();
    }

    @Override
    public GenericService<Item, Integer> getService() {
        return itemService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Item by id")
    public ItemDto findById(@PathVariable Integer id) {
        return itemMapper.convertToDTO(itemService.get(id));
    }

    @PostMapping
    @ApiOperation(value = "Create new Item")
    public ItemDto create(@ApiParam(value = "Item", required = true) @RequestBody @Valid ItemDto itemDto) {
        Item entity = itemMapper.convertToEntity(itemDto);
        return itemMapper.convertToDTO(itemService.add(entity));
    }

    @PutMapping()
    @ApiOperation(value = "Update Item")
    public ItemDto update(@ApiParam(value = "Item", required = true) @RequestBody @Valid ItemDto itemDto) {
        Item entity = itemMapper.convertToEntity(itemDto);
        return itemMapper.convertToDTO(itemService.update(entity));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete Item")
    public void delete(@PathVariable Integer id) {
        itemService.removeById(id);
    }
}