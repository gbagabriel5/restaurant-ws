package com.example.Restaurant.controller;

import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.Service.ProductService;
import com.example.Restaurant.domain.Product;
import com.example.Restaurant.dto.ProductDto;
import com.example.Restaurant.mapper.GenericMapper;
import com.example.Restaurant.mapper.ProductMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Product Controller")
@RestController
@RequestMapping(value = "/product")
public class ProductController implements ListRest<Product, ProductDto, Integer> {

    private final ProductService productService;
    private final ProductMapper productMapper = new ProductMapper();

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public GenericMapper<Product, ProductDto> getMapper() {
        return new ProductMapper();
    }

    @Override
    public GenericService<Product, Integer> getService() {
        return productService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Product by id")
    public ProductDto findById(@ApiParam(value = "id", required = true) @PathVariable Integer id) {
        return productMapper.convertToDTO(productService.get(id));
    }

    @PostMapping
    @ApiOperation(value = "Create new Product")
    public ProductDto create(@ApiParam(value = "Product", required = true) @RequestBody @Valid ProductDto productDto) {
        Product entity = productMapper.convertToEntity(productDto);
        return productMapper.convertToDTO(productService.add(entity));
    }

    @PutMapping()
    @ApiOperation(value = "Update Product")
    public ProductDto update(@ApiParam(value = "Product", required = true) @RequestBody @Valid ProductDto productDto) {
        Product entity = productMapper.convertToEntity(productDto);
        return productMapper.convertToDTO(productService.update(entity));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete Product")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable Integer id) {
        productService.removeById(id);
    }
}