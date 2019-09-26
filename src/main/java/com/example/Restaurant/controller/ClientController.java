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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Api(value = "Client Controller")
@RestController
@RequestMapping(value = "/client")
public class ClientController implements ListRest<Client, ClientDto, Integer> {

    @Autowired
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

    ;@GetMapping("/getByName")
        @ApiOperation(value = "Find Client by name")
        public Page<ClientDto> findByName(@RequestParam(name = "page", defaultValue = "0") Integer page,
                @RequestParam(name = "count", defaultValue = "25") Integer count,
                @RequestParam(name = "orderby", defaultValue = "name") String orderBy,
                @RequestParam(name = "direction", defaultValue = "ASC") String direction,
                @RequestParam(value = "name", defaultValue = "") String name) {
            Pageable pageable = PageRequest.of(page, count, Sort.by(orderBy));
            return clientService.getByName(pageable, name, orderBy, direction);
        }

        @GetMapping(value = "/{id}")
        @ApiOperation(value = "Find Client by id")
        public ClientDto findById(@PathVariable Integer id) {
            return clientMapper.convertToDTO(clientService.get(id));
        }

        @PostMapping
        @ApiOperation(value = "Create new Client")
        public ClientDto create(@ApiParam(value = "Client", required = true) @RequestBody @Valid ClientDto clientDto) {
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
    public void delete(@PathVariable Integer id) {
        clientService.removeById(id);
    }
}