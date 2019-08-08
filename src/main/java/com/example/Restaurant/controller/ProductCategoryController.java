package com.example.Restaurant.controller;

import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.Service.ProductCategoryService;
import com.example.Restaurant.domain.ProductCategory;
import com.example.Restaurant.dto.ProductCategoryDto;
import com.example.Restaurant.mapper.GenericMapper;
import com.example.Restaurant.mapper.ProductCategoryMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Product Category Controller")
@RestController
@RequestMapping(value = "/productCategory")
public class ProductCategoryController implements ListRest<ProductCategory, ProductCategoryDto, Integer> {

    @Autowired
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryMapper productCategoryMapper = new ProductCategoryMapper();

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @Override
    public GenericMapper<ProductCategory, ProductCategoryDto> getMapper() {
        return new ProductCategoryMapper();
    }

    @Override
    public GenericService<ProductCategory, Integer> getService() {
        return productCategoryService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Product Category by id")
    public ProductCategoryDto findById(@PathVariable Integer id) {
        return productCategoryMapper.convertToDTO(productCategoryService.get(id));
    }

    @PostMapping
    @ApiOperation(value = "Create new Product Category")
    public ProductCategoryDto create(@ApiParam(value = "ProductCategory", required = true) @RequestBody @Valid ProductCategoryDto productCategoryDto) {
        ProductCategory entity = productCategoryMapper.convertToEntity(productCategoryDto);
        return productCategoryMapper.convertToDTO(productCategoryService.add(entity));
    }

    @PutMapping()
    @ApiOperation(value = "Update Product Category")
    public ProductCategoryDto update(@ApiParam(value = "ProductCategory", required = true) @RequestBody @Valid ProductCategoryDto productCategoryDto) {
        ProductCategory entity = productCategoryMapper.convertToEntity(productCategoryDto);
        return productCategoryMapper.convertToDTO(productCategoryService.update(entity));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete Product Category")
    public void delete(@PathVariable Integer id) {
        productCategoryService.removeById(id);
    }
}