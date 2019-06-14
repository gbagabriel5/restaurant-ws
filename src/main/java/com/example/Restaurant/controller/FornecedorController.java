package com.example.Restaurant.controller;

import com.example.Restaurant.Service.FornecedorService;
import com.example.Restaurant.dto.FornecedorDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    @ApiOperation("Salva um novo fornecedor")
    public ResponseEntity<FornecedorDto> save(@RequestBody FornecedorDto fornecedorDto) {
        return new ResponseEntity<>(fornecedorService.save(fornecedorDto), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Listagem de todos os fornecedores")
    public ResponseEntity<Page<FornecedorDto>> findAll(
            @RequestParam(value = "pag", defaultValue = "0") int pag,
            @RequestParam(value = "qtd", defaultValue = "10") int qtd,
            @RequestParam(name = "sortProperty", defaultValue = "fornome") String sortProperty,
            @RequestParam(name = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "name", defaultValue = "") String nome
    ) {
        PageRequest pageRequest = PageRequest.of(pag, qtd, Sort.Direction.valueOf("ASC"), "id");
        return new ResponseEntity<>(fornecedorService.getAll(pageRequest, nome, sortProperty, direction), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation("Altera um fornecedor")
    public ResponseEntity<FornecedorDto> update(@RequestBody FornecedorDto fornecedorDto) {
        return new ResponseEntity<>(fornecedorService.update(fornecedorDto), HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation("Remove um fornecedor")
    public ResponseEntity delete(@RequestParam(value = "id") Integer id) {
        fornecedorService.delete(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
