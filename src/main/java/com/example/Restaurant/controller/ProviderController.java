package com.example.Restaurant.controller;

import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.Service.ProviderService;
import com.example.Restaurant.domain.Provider;
import com.example.Restaurant.dto.ProviderDto;
import com.example.Restaurant.mapper.GenericMapper;
import com.example.Restaurant.mapper.ProviderMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Api(value = "Provider Controller")
@RestController
@RequestMapping(value = "/provider")
public class ProviderController implements ListRest<Provider, ProviderDto, Integer> {

    @Autowired
    private final ProviderService providerService;
    private final ProviderMapper providerMapper = new ProviderMapper();

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @Override
    public GenericMapper<Provider, ProviderDto> getMapper() {
        return new ProviderMapper();
    }

    @Override
    public GenericService<Provider, Integer> getService() {
        return providerService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Provider by id")
    public ProviderDto findById(@PathVariable Integer id) {
        return providerMapper.convertToDTO(providerService.get(id));
    }

    @PostMapping
    @ApiOperation(value = "Create new Provider")
    public ProviderDto create(@ApiParam(value = "Provider", required = true) @RequestBody @Valid ProviderDto providerDto) {
        Provider entity = providerMapper.convertToEntity(providerDto);
        return providerMapper.convertToDTO(providerService.add(entity));
    }

    @PutMapping()
    @ApiOperation(value = "Update Provider")
    public ProviderDto update(@ApiParam(value = "Provider", required = true) @RequestBody @Valid ProviderDto providerDto) {
        Provider entity = providerMapper.convertToEntity(providerDto);
        return providerMapper.convertToDTO(providerService.update(entity));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete Provider")
    public void delete(@PathVariable Integer id) {
        providerService.removeById(id);
    }
}