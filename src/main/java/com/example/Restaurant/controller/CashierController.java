package com.example.Restaurant.controller;

import com.example.Restaurant.Service.CashierService;
import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.domain.Cashier;
import com.example.Restaurant.dto.CashierDto;
import com.example.Restaurant.mapper.CashierMapper;
import com.example.Restaurant.mapper.GenericMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Cashier Controller")
@RestController
@RequestMapping(value = "/cashier")
public class CashierController implements ListRest<Cashier, CashierDto, Integer> {

    private final CashierService cashierService;
    private final CashierMapper cashierMapper = new CashierMapper();

    public CashierController(CashierService cashierService) {
        this.cashierService = cashierService;
    }

    @Override
    public GenericMapper<Cashier, CashierDto> getMapper() {
        return new CashierMapper();
    }

    @Override
    public GenericService<Cashier, Integer> getService() {
        return cashierService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Client by id")
    public CashierDto findById(@ApiParam(value = "id", required = true) @PathVariable Integer id) {
        return cashierMapper.convertToDTO(cashierService.get(id));
    }

    @PostMapping
    @ApiOperation(value = "Create new Client")
    public CashierDto create(@ApiParam(value = "name", required = true) @RequestBody @Valid CashierDto cashierDto) {
        Cashier entity = cashierMapper.convertToEntity(cashierDto);

        return cashierMapper.convertToDTO(cashierService.add(entity));
    }

    @PutMapping()
    @ApiOperation(value = "Update Client")
    public CashierDto update(@ApiParam(value = "Client", required = true) @RequestBody @Valid CashierDto cashierDto) {
        Cashier entity = cashierMapper.convertToEntity(cashierDto);
        return cashierMapper.convertToDTO(cashierService.update(entity));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete Client")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable Integer id) {
        cashierService.removeById(id);
    }
}