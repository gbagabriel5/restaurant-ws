package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.FornecedorService;
import com.example.Restaurant.dto.FornecedorDto;
import com.example.Restaurant.exceptions.DefaultException;
import com.example.Restaurant.model.Fornecedor;
import com.example.Restaurant.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private FornecedorFilter fornecedorFilter;

    @Override
    public Fornecedor findById(Integer id) {
        Assert.notNull(id, "id.not.informed");
        Optional<Fornecedor> optionalFornecedor = repository.findById(id);
        if (!optionalFornecedor.isPresent())
            throw new DefaultException("fornecedor.not.found");
        return optionalFornecedor.get();
    }

    @Override
    public FornecedorDto save(FornecedorDto fornecedorDto) {
        Fornecedor fornecedor = fornecedorDto.toModel();
        fornecedor = repository.save(fornecedor);
        return fornecedor.toDto();
    }

    @Override
    public Page<FornecedorDto> getAll(Pageable pageable, String name, String sortBy, String direction) {
        FilterManager<Fornecedor> filterManager = new FilterManager<>(fornecedorFilter);

        filterManager.addParameter("fornome", "%" + name + "%");

        if(direction.equals("ASC")){
            filterManager.orderBy(sortBy).asc();
        }else {
            filterManager.orderBy(sortBy).desc();
        }

        List<Fornecedor> fornecedores = filterManager.findByFilter();

        List<FornecedorDto> fornecedorDtos = new ArrayList<>();

        fornecedores.forEach(client -> fornecedorDtos.add(client.toDto()));
        Long pageInit = pageable.getOffset();
        Long pageEnd = (pageInit + pageable.getPageSize()) > fornecedorDtos.size() ? fornecedorDtos.size() : (pageInit + pageable.getPageSize());

        return new PageImpl<>(fornecedorDtos.subList(pageInit.intValue(), pageEnd.intValue()), pageable, fornecedorDtos.size());
    }

    @Override
    public FornecedorDto update(FornecedorDto fornecedorDto) {
        Assert.notNull(fornecedorDto.getCod(), "id.not.informed");
        return save(fornecedorDto);
    }

    @Override
    public void delete(Integer id) {
        Assert.notNull(id, "id.not.informed");
        Fornecedor fornecedor = findById(id);
        repository.delete(fornecedor);
    }
}