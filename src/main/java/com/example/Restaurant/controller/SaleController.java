package com.example.Restaurant.controller;

import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.Service.SaleService;
import com.example.Restaurant.domain.Sale;
import com.example.Restaurant.dto.SaleDto;
import com.example.Restaurant.mapper.GenericMapper;
import com.example.Restaurant.mapper.SaleMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Api(value = "Sale Controller")
@RestController
@RequestMapping(value = "/sale")
public class SaleController implements ListRest<Sale, SaleDto, Integer> {

    @Autowired
    private final SaleService saleService;

    private final SaleMapper saleMapper = new SaleMapper();

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @Override
    public GenericMapper<Sale, SaleDto> getMapper() {
        return new SaleMapper();
    }

    @Override
    public GenericService<Sale, Integer> getService() {
        return saleService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Sale by id")
    public SaleDto findById(@PathVariable Integer id) {
        return saleMapper.convertToDTO(saleService.get(id));
    }

    @PostMapping
    @ApiOperation(value = "Create new Sale")
    public SaleDto create(@ApiParam(value = "Sale", required = true) @RequestBody @Valid SaleDto saleDto) {
        Sale entity = saleMapper.convertToEntity(saleDto);
        return saleMapper.convertToDTO(saleService.add(entity));
    }

    @PutMapping()
    @ApiOperation(value = "Update Sale")
    public SaleDto update(@ApiParam(value = "Sale", required = true) @RequestBody @Valid SaleDto saleDto) {
        Sale entity = saleMapper.convertToEntity(saleDto);
        return saleMapper.convertToDTO(saleService.update(entity));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete Sale")
    public void delete(@PathVariable Integer id) {
        saleService.removeById(id);
    }
}