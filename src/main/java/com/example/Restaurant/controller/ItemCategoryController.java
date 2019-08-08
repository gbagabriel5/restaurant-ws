package com.example.Restaurant.controller;

import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.Service.ItemCategoryService;
import com.example.Restaurant.domain.ItemCategory;
import com.example.Restaurant.dto.ItemCategoryDto;
import com.example.Restaurant.mapper.GenericMapper;
import com.example.Restaurant.mapper.ItemCategoryMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Api(value = "Item Category Controller")
@RestController
@RequestMapping(value = "/itemCategory")
public class ItemCategoryController implements ListRest<ItemCategory, ItemCategoryDto, Integer> {

    @Autowired
    private final ItemCategoryService itemCategoryService;
    private final ItemCategoryMapper itemCategoryMapper = new ItemCategoryMapper();

    public ItemCategoryController(ItemCategoryService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }

    @Override
    public GenericMapper<ItemCategory, ItemCategoryDto> getMapper() {
        return new ItemCategoryMapper();
    }

    @Override
    public GenericService<ItemCategory, Integer> getService() {
        return itemCategoryService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Item Category by id")
    public ItemCategoryDto findById(@PathVariable Integer id) {
        return itemCategoryMapper.convertToDTO(itemCategoryService.get(id));
    }

    @PostMapping
    @ApiOperation(value = "Create new Item Category")
    public ItemCategoryDto create(@ApiParam(value = "ItemCategory", required = true) @RequestBody @Valid ItemCategoryDto itemCategoryDto) {
        ItemCategory entity = itemCategoryMapper.convertToEntity(itemCategoryDto);
        return itemCategoryMapper.convertToDTO(itemCategoryService.add(entity));
    }

    @PutMapping()
    @ApiOperation(value = "Update Item Category")
    public ItemCategoryDto update(@ApiParam(value = "ItemCategory", required = true) @RequestBody @Valid ItemCategoryDto itemCategoryDto) {
        ItemCategory entity = itemCategoryMapper.convertToEntity(itemCategoryDto);
        return itemCategoryMapper.convertToDTO(itemCategoryService.update(entity));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete Item Category")
    public void delete(@PathVariable Integer id) {
        itemCategoryService.removeById(id);
    }
}