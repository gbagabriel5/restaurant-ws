package com.example.Restaurant.controller;

import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.Service.TablesService;
import com.example.Restaurant.domain.Tables;
import com.example.Restaurant.dto.TablesDto;
import com.example.Restaurant.mapper.GenericMapper;
import com.example.Restaurant.mapper.TableMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Api(value = "Tables Controller")
@RestController
@RequestMapping(value = "/table")

public class TablesController implements ListRest<Tables, TablesDto, Integer> {

    @Autowired
    private final TablesService tablesService;

    private final TableMapper tableMapper = new TableMapper();

    public TablesController(TablesService tablesService) {
        this.tablesService = tablesService;
    }

    @Override
    public GenericMapper<Tables, TablesDto> getMapper() {
        return new TableMapper();
    }

    @Override
    public GenericService<Tables, Integer> getService() {
        return tablesService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Table by id")
    public TablesDto findById(@PathVariable Integer id) {
        return tableMapper.convertToDTO(tablesService.get(id));
    }

    @PostMapping
    @ApiOperation(value = "Create new Table")
    public TablesDto create(@ApiParam(value = "Table", required = true) @RequestBody @Valid TablesDto tablesDto) {
        Tables entity = tableMapper.convertToEntity(tablesDto);
        return tableMapper.convertToDTO(tablesService.add(entity));
    }

    @GetMapping(value = "exists/{id}")
    @ApiOperation(value = "Check if Exists")
    public boolean checkIfExists(@PathVariable Integer id) {
        return tablesService.findBusyTable(id);
    }

}