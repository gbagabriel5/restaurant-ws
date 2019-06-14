package com.example.Restaurant.Service;

import com.example.Restaurant.dto.GrupoProdutoDto;
import com.example.Restaurant.model.GrupoProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GrupoProdutoService {

    GrupoProduto findById(Integer id);

    GrupoProdutoDto save(GrupoProdutoDto grupoProdutoDto);

    Page<GrupoProdutoDto> getAll(Pageable pageable, String nome, String sortBy, String direction);

    GrupoProdutoDto update(GrupoProdutoDto grupoProdutoDto);

    void delete(Integer id);

}
