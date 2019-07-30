package com.example.Restaurant.controller;

import com.example.Restaurant.Service.ClientService;
import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.domain.Client;
import com.example.Restaurant.dto.ClientDto;
import com.example.Restaurant.mapper.ClientMapper;
import com.example.Restaurant.mapper.GenericMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Api(value = "Client Controller")
@RestController
@RequestMapping(value = "/client")
public class ClientController implements ListRest<Client, ClientDto, Integer> {

    private final ClientService clientService;
    private final ClientMapper clientMapper = new ClientMapper();

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public GenericMapper<Client, ClientDto> getMapper() {
        return new ClientMapper();
    }

    @Override
    public GenericService<Client, Integer> getService() {
        return clientService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Client by id")
    public ClientDto findById(@ApiParam(value = "id", required = true) @PathVariable Integer id) {
        return clientMapper.convertToDTO(clientService.get(id));
    }

    @PostMapping
    @ApiOperation(value = "Create new Client")
    public ClientDto create(@ApiParam(value = "name", required = true) @RequestBody @Valid ClientDto clientDto) {
        Client entity = clientMapper.convertToEntity(clientDto);

        return clientMapper.convertToDTO(clientService.add(entity));
    }

    @PutMapping()
    @ApiOperation(value = "Update Client")
    public ClientDto update(@ApiParam(value = "Client", required = true) @RequestBody @Valid ClientDto clientDto) {
        Client entity = clientMapper.convertToEntity(clientDto);
        return clientMapper.convertToDTO(clientService.update(entity));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete Client")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable Integer id) {
        clientService.removeById(id);
    }
}