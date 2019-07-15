package com.example.Restaurant.controller;

import com.example.Restaurant.Service.GrupoProdutoService;
import com.example.Restaurant.dto.GrupoProdutoDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("grupoproduto")
public class GrupoProdutoController {

    @Autowired
    private GrupoProdutoService grupoProdutoService;

    @PostMapping
    @ApiOperation("Salva um novo Grupo de Produto")
    public ResponseEntity<GrupoProdutoDto> save(@RequestBody GrupoProdutoDto grupoProdutoDto) {
        return new ResponseEntity<>(grupoProdutoService.save(grupoProdutoDto), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Listagem de todos os Grupos de Produtos")
    public ResponseEntity<Page<GrupoProdutoDto>> findAll(
            @RequestParam(value = "pag", defaultValue = "0") int pag,
            @RequestParam(value = "qtd", defaultValue = "10") int qtd,
            @RequestParam(name = "sortProperty", defaultValue = "grpdesc") String sortProperty,
            @RequestParam(name = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "name", defaultValue = "") String nome
    ) {
        PageRequest pageRequest = PageRequest.of(pag, qtd, Sort.Direction.valueOf("ASC"), "id");
        return new ResponseEntity<>(grupoProdutoService.getAll(pageRequest, nome, sortProperty, direction), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation("Altera um Grupo de Produto")
    public ResponseEntity<GrupoProdutoDto> update(@RequestBody GrupoProdutoDto grupoProdutoDto) {
        return new ResponseEntity<>(grupoProdutoService.update(grupoProdutoDto), HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation("Remove um Grupo de Produto")
    public ResponseEntity delete(@RequestParam(value = "id") Integer id) {
        grupoProdutoService.delete(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
