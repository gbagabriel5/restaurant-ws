package com.example.Restaurant.controller;

import com.example.Restaurant.Service.ProdutoService;
import com.example.Restaurant.dto.ProdutoDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ApiOperation("Salva um novo Produto")
    public ResponseEntity<ProdutoDto> save(@RequestBody ProdutoDto produtoDto) {
        return new ResponseEntity<>(produtoService.save(produtoDto), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Listagem de todos os Produtos")
    public ResponseEntity<Page<ProdutoDto>> findAll(
            @RequestParam(value = "pag", defaultValue = "0") int pag,
            @RequestParam(value = "qtd", defaultValue = "10") int qtd,
            @RequestParam(name = "sortProperty", defaultValue = "pronome") String sortProperty,
            @RequestParam(name = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "name", defaultValue = "") String nome
    ) {
        PageRequest pageRequest = PageRequest.of(pag, qtd, Sort.Direction.valueOf("ASC"), "id");
        return new ResponseEntity<>(produtoService.getAll(pageRequest, nome, sortProperty, direction), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation("Altera um Produto")
    public ResponseEntity<ProdutoDto> update(@RequestBody ProdutoDto produtoDto) {
        return new ResponseEntity<>(produtoService.update(produtoDto), HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation("Remove um Produto")
    public ResponseEntity delete(@RequestParam(value = "id") Integer id) {
        produtoService.delete(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
