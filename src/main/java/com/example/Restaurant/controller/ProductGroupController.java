package com.example.Restaurant.controller;

import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.Service.ProductGroupService;
import com.example.Restaurant.domain.ProductGroup;
import com.example.Restaurant.dto.ProductGroupDto;
import com.example.Restaurant.mapper.GenericMapper;
import com.example.Restaurant.mapper.ProductGroupMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Api(value = "ProductGroup Controller")
@RestController
@RequestMapping(value = "/productGroup")
public class ProductGroupController implements ListRest<ProductGroup, ProductGroupDto, Integer> {

    private final ProductGroupService productGroupService;
    private final ProductGroupMapper productGroupMapper = new ProductGroupMapper();

    public ProductGroupController(ProductGroupService productGroupService) {
        this.productGroupService = productGroupService;
    }

    @Override
    public GenericMapper<ProductGroup, ProductGroupDto> getMapper() {
        return new ProductGroupMapper();
    }

    @Override
    public GenericService<ProductGroup, Integer> getService() {
        return productGroupService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find ProductGroup by id")
    public ProductGroupDto findById(@ApiParam(value = "id", required = true) @PathVariable Integer id) {
        return productGroupMapper.convertToDTO(productGroupService.get(id));
    }

    @PostMapping
    @ApiOperation(value = "Create new ProductGroup")
    public ProductGroupDto create(@ApiParam(value = "ProductGroup", required = true) @RequestBody @Valid ProductGroupDto productGroupDto) {
        ProductGroup entity = productGroupMapper.convertToEntity(productGroupDto);
        return productGroupMapper.convertToDTO(productGroupService.add(entity));
    }

    @PutMapping()
    @ApiOperation(value = "Update ProductGroup")
    public ProductGroupDto update(@ApiParam(value = "ProductGroup", required = true) @RequestBody @Valid ProductGroupDto productGroupDto) {
        ProductGroup entity = productGroupMapper.convertToEntity(productGroupDto);
        return productGroupMapper.convertToDTO(productGroupService.update(entity));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete ProductGroup")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable Integer id) {
        productGroupService.removeById(id);
    }
}