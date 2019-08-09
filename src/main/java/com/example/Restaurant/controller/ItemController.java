package com.example.Restaurant.controller;

import com.example.Restaurant.Service.ItemService;
import com.example.Restaurant.domain.Item;
import com.example.Restaurant.dto.ItemDto;
import com.example.Restaurant.mapper.ItemMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Api(value = "Item Controller")
@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private final ItemService itemService;
    private final ItemMapper itemMapper = new ItemMapper();

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/getByName")
    @ApiOperation(value = "Find Item by name")
    public Page<ItemDto> findByName(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                    @RequestParam(name = "count", defaultValue = "25") Integer count,
                                    @RequestParam(name = "orderby", defaultValue = "name") String orderBy,
                                    @RequestParam(name = "direction", defaultValue = "ASC") String direction,
                                    @RequestParam(value = "name", defaultValue = "") String name) {
        Pageable pageable = PageRequest.of(page, count, Sort.by(orderBy));
        return itemService.getByName(pageable, name, orderBy, direction);
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
        return itemMapper.convertToDTO(itemService.save(entity));
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