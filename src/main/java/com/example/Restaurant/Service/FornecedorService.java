package com.example.Restaurant.Service;

import com.example.Restaurant.dto.FornecedorDto;
import com.example.Restaurant.model.Fornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FornecedorService {

    Fornecedor findById(Integer id);

    FornecedorDto save(FornecedorDto fornecedorDto);

    Page<FornecedorDto> getAll(Pageable pageable, String nome, String sortBy, String direction);

    FornecedorDto update(FornecedorDto fornecedorDto);

    void delete(Integer id);
}
