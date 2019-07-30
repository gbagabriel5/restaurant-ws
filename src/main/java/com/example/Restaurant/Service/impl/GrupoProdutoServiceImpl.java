package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.GrupoProdutoService;
import com.example.Restaurant.dto.GrupoProdutoDto;
import com.example.Restaurant.exceptions.DefaultException;
import com.example.Restaurant.model.GrupoProduto;
import com.example.Restaurant.repository.GrupoProdutoRepository;
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
public class GrupoProdutoServiceImpl implements GrupoProdutoService {

    @Autowired
    private GrupoProdutoRepository repository;

    @Autowired
    private GrupoProdutoFilter grupoProdutoFilter;

    @Override
    public GrupoProduto findById(Integer id) {
        Assert.notNull(id, "id.not.informed");
        Optional<GrupoProduto> optionalGrupoProduto = repository.findById(id);
        if (!optionalGrupoProduto.isPresent())
            throw new DefaultException("grupoproduto.not.found");
        return optionalGrupoProduto.get();
    }

    @Override
    public GrupoProdutoDto save(GrupoProdutoDto grupoProdutoDto) {
        GrupoProduto grupoProduto = grupoProdutoDto.toModel();
        grupoProduto = repository.save(grupoProduto);
        return grupoProduto.toDto();
    }

    @Override
    public Page<GrupoProdutoDto> getAll(Pageable pageable, String name, String sortBy, String direction) {
        FilterManager<GrupoProduto> filterManager = new FilterManager<>(grupoProdutoFilter);

        filterManager.addParameter("grpdesc", "%" + name + "%");

        if(direction.equals("ASC")){
            filterManager.orderBy(sortBy).asc();
        }else {
            filterManager.orderBy(sortBy).desc();
        }

        List<GrupoProduto> grupoProdutos = filterManager.findByFilter();

        List<GrupoProdutoDto> grupoProdutoDtos = new ArrayList<>();

        grupoProdutos.forEach(grupoProduto -> grupoProdutoDtos.add(grupoProduto.toDto()));
        Long pageInit = pageable.getOffset();
        Long pageEnd = (pageInit + pageable.getPageSize()) > grupoProdutoDtos.size() ? grupoProdutoDtos.size() : (pageInit + pageable.getPageSize());

        return new PageImpl<>(grupoProdutoDtos.subList(pageInit.intValue(), pageEnd.intValue()), pageable, grupoProdutoDtos.size());
    }

    @Override
    public GrupoProdutoDto update(GrupoProdutoDto grupoProdutoDto) {
        Assert.notNull(grupoProdutoDto.getCod(), "id.not.informed");
        return save(grupoProdutoDto);
    }

    @Override
    public void delete(Integer id) {
        Assert.notNull(id, "id.not.informed");
        GrupoProduto grupoProduto = findById(id);
        repository.delete(grupoProduto);
    }
}