package com.example.Restaurant.controller;

import com.example.Restaurant.Service.ClienteService;
import com.example.Restaurant.dto.ClienteDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ApiOperation("Salva um novo cliente")
    public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto clienteDto) {
        return new ResponseEntity<>(clienteService.save(clienteDto), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Listagem de todos os clientes")
    public ResponseEntity<Page<ClienteDto>> findAll(
            @RequestParam(value = "pag", defaultValue = "0") int pag,
            @RequestParam(value = "qtd", defaultValue = "10") int qtd,
            @RequestParam(name = "sortProperty", defaultValue = "clinome") String sortProperty,
            @RequestParam(name = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "name", defaultValue = "") String nome
    ) {
        PageRequest pageRequest = PageRequest.of(pag, qtd, Sort.Direction.valueOf("ASC"), "id");
        return new ResponseEntity<>(clienteService.getAll(pageRequest, nome, sortProperty, direction), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation("Altera um cliente")
    public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto clientDto) {
        return new ResponseEntity<>(clienteService.update(clientDto), HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation("Remove um cliente")
    public ResponseEntity delete(@RequestParam(value = "id") Integer id) {
        clienteService.delete(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
