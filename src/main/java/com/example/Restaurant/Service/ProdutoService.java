package com.example.Restaurant.Service;

import com.example.Restaurant.dto.ProdutoDto;
import com.example.Restaurant.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService {

    Produto findById(Integer id);

    ProdutoDto save(ProdutoDto produtoDto);

    Page<ProdutoDto> getAll(Pageable pageable, String nome, String sortBy, String direction);

    ProdutoDto update(ProdutoDto produtoDto);

    void delete(Integer id);

}
